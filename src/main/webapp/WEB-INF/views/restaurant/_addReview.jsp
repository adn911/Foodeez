<div class="review-div" class="col-md-12">


    <div>
        <h3>Leave a review</h3> <br><br>
    </div>

    <c:if test="${!empty param.addReviewSuccess}">
        <div class="alert alert-success" role="alert">Your review added successfully.</div>
    </c:if>

    <c:if test="${!empty param.error}">
        <div class="alert alert-danger" role="alert">Your review adding failed.</div>
    </c:if>


    <div>

        <sf:form action="/Foodeezz/restaurantReviews/add" method="POST" commandName="newRestaurantReview">

            <input id="user.id" name="user.id" type="hidden" value="${user.id}"/>

            <input id="restaurant.id" name="restaurant.id" type="hidden" value="${restaurant.id}"/>

            <p> Environment <input type="number" id="rating.environment" name="rating.environment" class="rating"
                                   data-min="0"
                                   data-max="5" data-step="1" data-size="xs" required></p>

            <p> Food Quality <input type="number" id="rating.foodQuality" name="rating.foodQuality" class="rating"
                                    data-min="0"
                                    data-max="5" data-step="1" data-size="xs" required></p>

            <p> Service <input type="number" id="rating.service" name="rating.service" class="rating" data-min="0"
                               data-max="5"
                               data-step="1" data-size="xs" required></p>

            <p> Overall <input type="number" id="rating.overall" name="rating.overall" class="rating" data-min="0"
                               data-max="5"
                               data-step="1" data-size="xs" required></p>

            <p>Add a comment <textarea id="comment" name="comment" class="form-control" required></textarea></p>

            <p><input type="submit" name="restaurantReviewSubmit" class="btn btn-default" value="Submit Review"/></p>

        </sf:form>

    </div>
</div>

<hr>