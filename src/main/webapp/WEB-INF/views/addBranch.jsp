<div id="addBranch" class="panel panel-info">


    <div class="panel-heading">
        <h3 class="panel-title text-center">Add Branch</h3>
    </div>
    <div class="panel-body">

        <c:if test="${!empty param.success}">
            <div class="alert alert-success" role="alert">New branch added successfully.</div>
        </c:if>

        <c:if test="${!empty param.error}">
            <div class="alert alert-success" role="alert">Adding new branch failed.</div>
        </c:if>

        <sf:form action="/Foodeezz/restaurants/addBranch" method="POST" commandName="newRestaurantBranch">

            <input id="restaurant.id" name="restaurant.id" class="form-control" type="hidden"
                   value="${restaurant.id}"/>

            <p> Name <sf:errors path="name" cssClass="error"/><input type="text" id="name" name="name"
                                                                     class="form-control"></p>

            <p> City <sf:errors path="city" cssClass="error"/><input type="text" id="city" name="city"
                                                                     class="form-control"></p>

            <p> Street <sf:errors path="street" cssClass="error"/><input type="text" id="street" name="street"
                                                                         class="form-control"></p>

            <p> Area <sf:errors path="area" cssClass="error"/><input type="text" id="area" name="area"
                                                                     class="form-control"></p>

            <p> Contact No <sf:errors path="contactNo" cssClass="error"/><input type="text" id="contactNo"
                                                                                name="contactNo" class="form-control">
            </p>

            <div id="addBranchMap" class="map"></div>

            <div class="form-inline">
                <p>Latitude <input type="text" id="latLong.latitude" name="latLong.latitude"
                                   class="form-control form-control-small" readonly>


                    Longitude <input type="text" id="latLong.longtitude" name="latLong.longtitude"
                                     class="form-control form-control-small"
                                     readonly>
                    <span>Right click to clear Marker</span>
                </p>

            </div>


            <p><input type="submit" name="addBranchSubmit" class="btn btn-default" value="add Branch"></p>

        </sf:form>

    </div>
</div>
