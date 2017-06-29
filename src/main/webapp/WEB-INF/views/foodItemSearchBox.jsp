<%--
  Created by IntelliJ IDEA.
  User: bakhtiar.galib
  Date: 4/20/15
  Time: 3:24 PM
  To change this template use File | Settings | File Templates.
--%>


<sf:form cssClass="form-inline" action="/Foodeezz/menuItems/search" method="get" commandName="menuItemSearchCriteria">

    <div class="form-group">
        <label for="item">Item:</label>
        <input type="text" id="item" name="item" placeholder="Search Item" class="form-control form-control-small"
               value="${param.item}"/>
    </div>
    <div class="form-group">
        <label for="minPrice">Min Price: </label>
        <input type="number" id="minPrice" name="minPrice" min="0" placeholder="min price"
               class="form-control form-control-small" value="${param.minPrice}"/>

        <label for="maxPrice">Max Price: </label>
        <input type="number" id="maxPrice" name="maxPrice" min="0" placeholder="max price"
               class="form-control form-control-small" value="${param.maxPrice}"/>

        <input type="hidden" id="page" name="page" value="1"/>
    </div>

    <button type="submit" class="btn btn-primary">Search</button>

</sf:form>

