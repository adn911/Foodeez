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

        <div class="col-md-4 col-md-offset-4" style="margin-top: 50px;">

            <c:if test="${!empty error}">
                <div class="alert alert-danger" role="alert">${error}.</div>
            </c:if>

            <div class="panel panel-info">

                <div class="panel-heading">
                    <h3 class="panel-title text-center">Login</h3>
                </div>

                <div class="panel-body">

                    <form name="login" action="/Foodeezz/login" method="POST">

                        <input type="email" name="email" class="form-control" placeholder="Email" required/><br>
                        <input type="password" name="password" class="form-control" placeholder="password"
                               required/><br>
                        <input type="submit" class="btn btn-default form-control" name="login" value="login"/><br><br>


                        <div class="text-center">
                            <a href="signup"> Don't have an account? signup</a>
                        </div>

                    </form>
                </div>
            </div>


        </div>


    </div>

</div>


<%@include file="footer.jsp" %>
