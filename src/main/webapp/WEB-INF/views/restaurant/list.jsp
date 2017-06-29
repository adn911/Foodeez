<%@ page import="org.foodeezz.persistance.entity.UserType" %><%--
  Created by IntelliJ IDEA.
  User: bakhtiar.galib
  Date: 3/9/15
  Time: 11:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../header.jsp" %>


<div class="container-fluid">

    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title text-center">Restaurants</h3>
                </div>
                <div class="panel-body">
                    <c:if test="${!empty user}">
                       <c:set var = "SYSTEM_ADMIN" value="<%=UserType.SYSTEM_ADMIN%>"/>
                        <c:if test="${user.userType == SYSTEM_ADMIN}">
                            <a class="btn btn-default form-control" href="/Foodeezz/restaurants/create">Create New Restaurant</a>
                            <br><br>
                        </c:if>
                    </c:if>

                    <%@include file="_searchBox.jsp" %><hr>

                    <c:if test="${empty restaurants}">
                        <p class="text-center">No search result found.</p>
                    </c:if>

                    <c:forEach items="${restaurants}" var="restaurant">

                        <%@include file="_listItem.jsp" %>

                    </c:forEach>


                    <div class="pull-right">
                        <ul class="pagination">

                            <c:forEach var="page" begin="1" end="${numberOfPages}">
                                <li>
                                    <a href="?area=${param.area}&category=${param.category}&keyword=${param.keyword}&page=${page}">${page}</a>
                                </li>
                            </c:forEach>

                        </ul>
                    </div>


                </div>

            </div>

        </div>


    </div>

</div>


<%@include file="../footer.jsp" %>