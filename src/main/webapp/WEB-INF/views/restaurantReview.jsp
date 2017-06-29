<div class="review-div" class="col-md-12">

    <div>
        <em>${review.user.userId}</em> at <em>${review.created}</em> <br><br>
    </div>

    <div>

        <p> Environment <input type="number" id="environment" data-readonly="true" name="environment" class="rating"
                               data-min="0" data-max="5" data-step="0.5" data-size="xs"
                               value="${review.rating.environment}"></p>

        <p> Food Quality <input type="number" id="foodQuality" data-readonly="true" name="foodQuality" class="rating"
                                data-min="0" data-max="5" data-step="0.5" data-size="xs"
                                value="${review.rating.foodQuality}"></p>

        <p> Service <input type="number" id="service" name="service" data-readonly="true" class="rating" data-min="0"
                           data-max="5" data-step="0.5" data-size="xs" value="${review.rating.service}"></p>

        <p> Overall <input type="number" id="overall" name="overall" data-readonly="true" class="rating" data-min="0"
                           data-max="5" data-step="0.5" data-size="xs" value="${review.rating.overall}"></p>

    </div>

    <div>
        <p>${review.comment} </p>
    </div>
</div>

<hr>