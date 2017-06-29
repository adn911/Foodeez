<%--
  Created by IntelliJ IDEA.
  User: bakhtiar.galib
  Date: 4/21/15
  Time: 9:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp" %>
<%--<%@include file="slider.jsp"%>--%>

<div class="container-fluid">

    <div class="row">

        <div class="col-md-6 col-md-offset-3">

            <a href="/Foodeezz/restaurants/${item.restaurant.id}">
                <h3>${item.restaurant.name}<%--Restaurant Title --%></h3>
            </a>
            <hr>

            <div class="row">

                <div class="menuitem-div" class="col-md-12">

                    <div class="col-md-4">
                        <img src="/Foodeezz/image/menuItem/${item.id}" width="150px" height="150px"
                             style="margin: 10px;">
                    </div>

                    <div class="col-md-8">

                        <div class="row">

                            <div class="col-md-8">
                                <h3><a href="/Foodeezz/menuItems/${item.id}">${item.name}</a></h3>
                            </div>

                            <div class="col-md-4">

                                <c:if test="${!empty user}">

                                    <c:if test="${user.userType == UserType.SYSTEM_ADMIN}">

                                        <form action="/Foodeezz/menuItems/remove" method="post" class="pull-right"
                                              onsubmit="return confirmAction();">
                                            <input type="hidden" name="menuItemId" value="${item.id}"/>
                                            <button type="submit" class="btn btn-default" name="removeMenuItemSubmit">
                                                <span class="glyphicon glyphicon-remove"/></button>
                                            <a href="/Foodeezz/menuItems/update/${item.id}"
                                               class="btn btn-default"><span class="glyphicon glyphicon-edit"/></a>
                                        </form>

                                    </c:if>

                                </c:if>
                            </div>
                        </div>


                        <p>Rating: <input type="number" class="rating" data-min="0" data-max="5" data-step="0.5"
                                          data-size="xs"
                                          data-readonly="true" value="${item.rating.overall}"></p>

                        <p>Price: ${item.price}/=</p>

                        <p>
                            ${item.description}
                        </p>


                        <div>


                        </div>


                    </div>
                </div>

            </div>
            <hr>


        </div>

    </div>

    <div class="row">

        <div class="col-md-6 col-md-offset-3">

            <div class="panel panel-info">

                <div class="panel-heading">
                    <h3 class="panel-title text-center">Reviews</h3>
                </div>

                <div class="panel-body">

                    <c:if test="${empty user}">
                        <div>
                            <p>Please <a href="/Foodeezz/login">Login</a> leave add review!</p>
                        </div>
                        <hr>
                    </c:if>

                    <c:if test="${!empty user}">
                        <%@include file="addMenuItemReview.jsp" %>
                    </c:if>

                    <c:forEach items="${item.reviews}" var="review">
                        <%@include file="menuItemReview.jsp" %>
                    </c:forEach>

                </div>

            </div>

        </div>

    </div>

</div>

<%@include file="footer.jsp" %>
