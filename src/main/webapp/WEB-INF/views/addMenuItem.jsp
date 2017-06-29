<%--
  Created by IntelliJ IDEA.
  User: bakhtiar.galib
  Date: 3/10/15
  Time: 11:30 AM
  To change this template use File | Settings | File Templates.
--%>

<%@include file="header.jsp" %>

<div class="row">

    <div id="addMenuItem" class="col-md-6 col-md-offset-3">

        <c:if test="${!empty param.success}">
            <div class="alert alert-success" role="alert">Menuitem added successfully.</div>
        </c:if>

        <c:if test="${!empty param.error}">

            <c:if test="${param.error eq 1}">
                <div class="alert alert-danger" role="alert">
                    Invalid Image format
                </div>
            </c:if>

        </c:if>

        <div class="panel panel-info">

            <div class="panel-heading">
                <h3 class="panel-title text-center">Add New Menu Item</h3>
            </div>

            <div class="panel-body">

                <sf:form action="/Foodeezz/menuItems/add" method="POST" enctype="multipart/form-data"
                         commandName="newMenuItem">

                    <input id="restaurant.id" name="restaurant.id" class="form-control" type="hidden"
                           value="${restaurant.id}"/>

                    <label for="name">Name</label>
                    <sf:errors path="name" cssClass="error"/>
                    <input id="name" name="name" class="form-control" placeholder="Item Name" type="text"
                           value="${newMenuItem.name}"/> <br>

                    <label for="description">description</label>
                    <sf:errors path="description" cssClass="error"/>
                    <textarea id="description" name="description" class="form-control" style="height:200px;"
                              value="${newMenuItem.description}"></textarea>
                    <br>

                    <label for="price">Price</label>
                    <sf:errors path="price" cssClass="error"/>
                    <input id="price" name="price" class="form-control" placeholder="0.00" type="number" value="0.0"
                           min="0" value="${newMenuItem.price}"/> <br>

                    <label for="picture">Photo</label>
                    <input type="file" id="picture" name="picture" class="form-control"/><br>

                    <input type="submit" class="btn btn-default form-control" name="addMenuItemSubmit"
                           value="Submit"/><br><br>

                </sf:form>

            </div>
        </div>

    </div>


</div>

<%@include file="footer.jsp" %>
