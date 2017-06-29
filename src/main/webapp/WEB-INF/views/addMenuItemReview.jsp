<div class="review-div" class="col-md-12">

    <div>
        <h3>Add a review</h3> <br><br>
    </div>

    <div>

        <sf:form action="/Foodeezz/menuItemReviews/add" method="POST" commandName="newMenuItemReview">

            <input type="hidden" id="user.id" name="user.id" value="${user.id}">

            <input type="hidden" id="menuItem.id" name="menuItem.id" value="${item.id}">

            <p> Rating: <input type="number" id="rating.overall" name="rating.overall" class="rating" data-min="0"
                               data-max="5" data-step="1" data-size="xs"></p>

            <p>Add a comment <textarea id="comment" name="comment" class="form-control"></textarea></p>

            <p><input type="submit" name="menuItemReviewSubmit" class="btn btn-default" value="Submit Review"></p>

        </sf:form>

    </div>

</div>

<hr>