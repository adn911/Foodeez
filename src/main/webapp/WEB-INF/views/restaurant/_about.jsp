<%@ page import="org.foodeezz.persistance.entity.UserType" %>

<c:if test="${!empty param.success}">
    <div class="alert alert-success" role="alert">New Restaurant Created Successfully..</div>
</c:if>

<div id="title" class="row">

    <div class="col-md-8">
        <h2>${restaurant.name}</h2>
    </div>

</div>

<br><br>

<div class="row">

    <div id="photo" class="col-md-5">
        <img src="/Foodeezz/image/restaurant/${restaurant.id}" width="150px" height="150px">
    </div>


    <div id="ratings" class="col-md-7">
        <p> Environment <input type="number" id="environment" data-readonly="true" name="environment" class="rating"
                               data-min="0" data-max="5" data-step="0.5" data-size="xs"
                               value="${restaurant.rating.environment}"></p>

        <p> Food Quality <input type="number" id="foodQuality" data-readonly="true" name="foodQuality" class="rating"
                                data-min="0" data-max="5" data-step="0.5" data-size="xs"
                                value="${restaurant.rating.foodQuality}"></p>

        <p> Service <input type="number" id="service" name="service" data-readonly="true" class="rating" data-min="0"
                           data-max="5" data-step="0.5" data-size="xs" value="${restaurant.rating.service}"></p>

        <p> Overall <input type="number" id="overall" name="overall" data-readonly="true" class="rating" data-min="0"
                           data-max="5" data-step="0.5" data-size="xs" value="${restaurant.rating.overall}"></p>
    </div>


</div>

<br><br>

<div id="description" class="row">
    <h3>About US</h3>
    <p>${restaurant.description}</p>
    <br>
</div>

<div class="col-md-12">

    <c:if test="${!empty user}">
        <c:set var = "SYSTEM_ADMIN" value="<%=UserType.SYSTEM_ADMIN%>"/>
        <c:if test="${user.userType == SYSTEM_ADMIN}">

            <form action="/Foodeezz/restaurants/delete" class="pull-right" method="post"
                  onsubmit="return confirmAction();">
                <a href="/Foodeezz/restaurants/edit/${restaurant.id}" class="btn btn-default"><span
                        class="glyphicon glyphicon-edit"> Edit</span></a>
                <input type="hidden" name="restaurantId" value="${restaurant.id}"/>
                <button type="submit" class="btn btn-default" name="removeRestaurantSubmit"><span
                        class="glyphicon glyphicon-remove"> Delete</span></button>
            </form>

        </c:if>

    </c:if>
</div>

<br><br>



