<%--
  Created by IntelliJ IDEA.
  User: bakhtiar.galib
  Date: 3/9/15
  Time: 11:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp" %>


<div class="container-fluid">


    <div class="row">

        <div class="col-md-8 col-md-offset-2">

            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title text-center">Browse Food Items</h3>
                </div>
                <div class="panel-body">

                    <%@include file="foodItemSearchBox.jsp" %>

                    <hr>

                    <c:if test="${empty items}">
                        <p class="text-center">No search result found.</p>
                    </c:if>

                    <c:forEach items="${items}" var="item">
                        <%@include file="foodItem.jsp" %>
                    </c:forEach>

                    <div class="pull-right">
                        <ul class="pagination">

                            <c:forEach var="page" begin="1" end="${numberOfPages}">
                                <li>
                                    <a href="search?item=${param.item}&minPrice=${param.minPrice}&maxPrice=${param.maxPrice}&page=${page}">${page}</a>
                                </li>
                            </c:forEach>

                        </ul>
                    </div>

                </div>
            </div>

        </div>

    </div>

</div>

<%@include file="footer.jsp" %>