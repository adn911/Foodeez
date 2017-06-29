<label for="category">Select Category</label>

<select id="category" name="category" class="form-control form-control-small">
    <option value="">ALL</option>

    <c:forEach items="${categories}" var="category">

        <c:if test="${param.category == category.name}">
            <option selected value="${category.name}">${category.name}</option>
        </c:if>

        <c:if test="${param.category != category.name}">
            <option value="${category.name}">${category.name}</option>
        </c:if>

    </c:forEach>
</select>