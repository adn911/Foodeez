<%@include file="header.jsp" %>

<div class="row">

    <div class="col-md-6 col-md-offset-3">

        <div id="updateMenuItem" class="col-md-12">

            <c:if test="${!empty param.success}">
                <div class="alert alert-success" role="alert">Menu item updated successfully.</div>
            </c:if>

            <c:if test="${!empty param.error}">
                <c:if test="${param.error eq 1}">
                    <div class="alert alert-danger" role="alert">
                        Menu item update failed.
                    </div>
                </c:if>
            </c:if>

            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title text-center">Update Menu Item Info</h3>
                </div>
                <div class="panel-body">

                    <sf:form action="/Foodeezz/menuItems/update/${menuItem.id}" method="POST"
                             enctype="multipart/form-data"
                             commandName="menuItem">

                        <input id="id" name="id" type="hidden" value="${menuItem.id}"/>

                        <input id="restaurant.id" name="restaurant.id" type="hidden" value="${menuItem.restaurant.id}"
                                />

                        <label for="name">Name</label><br>
                        <sf:errors path="name" cssClass="error"/>
                        <input id="name" name="name" class="form-control" placeholder="Item Name" type="text"
                               value="${menuItem.name}"/> <br>

                        <label for="description">description</label><br>
                        <sf:errors path="description" cssClass="error"/>
                        <textarea id="description" name="description" class="form-control" style="height:200px;">
                                ${menuItem.description}
                        </textarea>
                        <br>

                        <label for="price">Price</label>
                        <sf:errors path="price" cssClass="error"/>
                        <input id="price" name="price" class="form-control" placeholder="0.00" type="number"
                               value="${menuItem.price}" min="0"/> <br>

                        <label for="picture">Photo</label><br>

                        <label for="picture">
                            <div id="photo" class="col-md-5">
                                <img src="/Foodeezz/image/menuItem/${menuItem.id}" width="150px" height="150px">
                            </div>
                        </label>

                        <input type="file" id="picture" name="picture" class="form-control"/><br>

                        <input type="submit" class="btn btn-default form-control" name="addMenuItemSubmit"
                               value="Submit"/><br><br>

                    </sf:form>

                </div>
            </div>

        </div>

    </div>

</div>

<%@include file="footer.jsp" %>
