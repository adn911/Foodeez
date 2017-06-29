<%--
  Created by IntelliJ IDEA.
  User: bakhtiar.galib
  Date: 3/10/15
  Time: 11:30 AM
  To change this template use File | Settings | File Templates.
--%>

<%@include file="../header.jsp" %>

<div class="row">

    <div id="addRestaurant" class="col-md-6 col-md-offset-3">

        <c:if test="${!empty param.error}">
            <c:if test="${param.error eq 1}">
                <div class="alert alert-danger" role="alert">
                    invalid image format!
                </div>
            </c:if>
        </c:if>

        <div class="panel panel-info">

            <div class="panel-heading">
                <h3 class="panel-title text-center">Add New Restaurant</h3>
            </div>

            <div class="panel-body">

                <sf:form action="/Foodeezz/restaurants/save" method="POST" commandName="newRestaurant"
                         enctype="multipart/form-data">

                    <label for="name">Name</label><br>
                    <sf:errors path="name" cssClass="error"/>
                    <input id="name" name="name" class="form-control" placeholder="Restaurant Name" type="text"
                           value="${newRestaurant.name}"/> <br>

                    <label for="category.id">Category</label><br>
                    <sf:errors path="category" cssClass="error"/>
                    <%@include file="../restaurantCategorySelect.jsp" %>

                    <label for="description">description</label><br>
                    <sf:errors path="description" cssClass="error"/>
                    <textarea id="description" name="description" class="form-control"
                              style="height: 200px;">${newRestaurant.description}</textarea>
                    <br>

                    <label for="picture">Profile Photo</label><br>

                    <%--<img id="preview" src="/Foodeezz/resources/images/thumbnail-default.jpg" alt="your image" class="img-thumbnail previewImage" /><br>--%>

                    <div class="form-inline">
                        <input type="file" id="picture" name="picture" class="form-control btn btn-default" onchange="readURL(this)"/>
                        <button type="button" id="clear" onclick="clearImage($('#picture'))" class="form-control btn btn-default">Clear</button>
                    </div>

                    <br>


                    <input type="submit" class="btn btn-default form-control" name="addRestaurantSubmit"
                           value="Submit"/><br><br>

                </sf:form>

            </div>

        </div>

    </div>

</div>

<%@include file="../footer.jsp" %>
