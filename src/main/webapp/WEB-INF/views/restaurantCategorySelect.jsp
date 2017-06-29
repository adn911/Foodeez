<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<select id="category.id" name="category.id" class="form-control">
    <c:forEach items="${categories}" var="category">

        <c:if test="${newRestaurant.category.id == category.id}">
            <option selected value="${category.id}">${category.name}</option>
        </c:if>

        <c:if test="${newRestaurant.category.id != category.id}">
            <option value="${category.id}">${category.name}</option>
        </c:if>

    </c:forEach>
</select>

<br>