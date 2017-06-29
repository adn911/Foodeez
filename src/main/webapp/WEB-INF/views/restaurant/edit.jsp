<%--
  Created by IntelliJ IDEA.
  User: bakhtiar.galib
  Date: 3/10/15
  Time: 11:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../header.jsp" %>

<div class="row">

    <div class="col-md-6 col-md-offset-3">

        <div id="updateRestaurant" class="col-md-12">

            <c:if test="${!empty param.success}">
                <div class="alert alert-success" role="alert">Updated restaurant info successfully.</div>
            </c:if>

            <c:if test="${!empty param.error}">
                <c:if test="${param.error eq 1}">
                    <div class="alert alert-danger" role="alert">
                        Restaurant info update failed
                    </div>
                </c:if>
            </c:if>

            <div class="panel panel-info">

                <div class="panel-heading">
                    <h3 class="panel-title text-center">Update Restaurant Profile </h3>
                </div>

                <div class="panel-body">

                    <sf:form action="/Foodeezz/restaurants/update/${restaurant.id}" method="POST"
                             commandName="restaurant"
                             enctype="multipart/form-data">

                        <input id="id" name="id" type="hidden" value="${restaurant.id}"/> <br>

                        <label for="name">Name</label><br>
                        <sf:errors path="name" cssClass="error"/>
                        <input id="name" name="name" class="form-control" placeholder="Restaurant Name" type="text"
                               value="${restaurant.name}"/> <br>

                        <label for="category.id">Category</label><br>
                        <%@include file="../restaurantCategorySelect.jsp" %>


                        <label for="description">description</label><br>
                        <sf:errors path="description" cssClass="error"/>
                        <textarea id="description" name="description" class="form-control"
                                  style="height:200px;">${restaurant.description}</textarea>
                        <br>

                        <label>Picture </label>
                        <label for="picture">
                            <div id="photo" class="col-md-5">
                                <img src="/Foodeezz/image/restaurant/${restaurant.id}" width="150px" height="150px">
                            </div>
                        </label>

                        <div class="form-inline">

                            <input type="file" id="picture" name="picture" class="form-control btn btn-default" onchange="readURL(this)"/>
                            <button type="button" id="clear" onclick="clearImage($('#picture'))" class="form-control btn btn-default">Clear</button>
                        </div>

                        <br><br>
                        <%--<input type="file" id="picture" name="picture" class="form-control"/><br>--%>
                        <div>
                            <input type="submit" class="btn btn-default pull-right" name="updateRestaurantSubmit"
                                   value="update"/><br><br>
                        </div>


                    </sf:form>

                </div>
            </div>

        </div>

    </div>

</div>


<%@include file="../footer.jsp" %>