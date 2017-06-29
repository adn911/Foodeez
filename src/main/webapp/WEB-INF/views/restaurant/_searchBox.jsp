<%--
  Created by IntelliJ IDEA.
  User: GALIB
  Date: 4/21/2015
  Time: 8:25 PM
  To change this template use File | Settings | File Templates.
--%>


<sf:form action="/Foodeezz/restaurants/search" method="get" cssClass="form-inline"
         commandName="restaurantSearchCriteria">

    <div class="form-group">

        <%@include file="../_selectCategory.jsp" %>
        <%@include file="../selectArea.jsp" %>

        <input type="text" id="keyword" name="keyword" class="form-control form-control-small" placeholder="keyword"
               value="${param.keyword}"/>
        <input type="hidden" id="page" name="page" value="1"/>

    </div>

    <input type="submit" class="btn btn-primary" value="Search"/>

    <a href="/Foodeezz/restaurants/?area=&category=&keyword=&page=1" class="btn btn-default">Show All</a>

</sf:form>





