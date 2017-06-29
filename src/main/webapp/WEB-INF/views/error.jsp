<%--
  Created by IntelliJ IDEA.
  User: bakhtiar.galib
  Date: 4/12/15
  Time: 3:13 PM
  To change this template use File | Settings | File Templates.
--%>

<%@include file="header.jsp" %>

<div class="row">

    <div class="col-md-6 col-md-offset-3">

        <c:if test="${not empty errorCode}">
            <h3 class="text-center">${errorCode} : System Errors</h3>
        </c:if>

        <c:if test="${not empty errorMessage}">
            <h3 class="text-center">${errorMessage}</h3>
        </c:if>

    </div>

</div>


<%@include file="footer.jsp" %>