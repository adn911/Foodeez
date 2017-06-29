<%--
  Created by IntelliJ IDEA.
  User: bakhtiar.galib
  Date: 3/9/15
  Time: 11:26 AM
  To change this template use File | Settings | File Templates.
--%>

<%@include file="header.jsp" %>
<%--<%@include file="slider.jsp"%>--%>

<div class="container-fluid">

    <%@include file="jumbotron.jsp" %>

    <div class="container marketing">
        <hr>
        <h3 class="section-title">Search Restaurant</h3>
        <div class="row">
            <div class="col-md-8 col-md-offset-3">
                <%@include file="restaurant/_searchBox.jsp" %>
            </div>
        </div>
        <br><br><br><br>

        <hr>
        <h2 class="section-title">Restaurant Category</h2>
        <!-- Three columns of text below the carousel -->
        <div class="row">

            <c:forEach items="${categories}" var="category">
                <%@include file="restaurant/_categoryTile.jsp" %>
            </c:forEach>
            <!-- /.col-lg-4 -->
        </div>
        <!-- /.row -->

        <div class="row">
            <div class="col-md-8 col-md-offset-2">
            </div>
        </div>

    </div>

    <%@include file="footer.jsp" %>
