<label for="area">Select Area</label>

<select id="area" name="area" class="form-control form-control-small">
    <option value="">ALL</option>

    <c:forEach items="${areas}" var="area">
        <c:if test="${param.area == area}">
            <option selected value="${area}">${area}</option>
        </c:if>

        <c:if test="${param.area != area}">
            <option value="${area}">${area}</option>
        </c:if>
    </c:forEach>
</select>