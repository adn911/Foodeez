<div class="review-div" class="col-md-12">

    <div>
        <em>${review.user.userId}</em> at <em>${review.created}</em> <br><br>
    </div>
    <div>
        <p>Rating: <input type="number" class="rating" data-min="0" data-max="5" data-step="0.5" data-size="xs"
                          data-readonly="true" value="${review.rating.overall}"></p>
    </div>

    <div>
        <p>${review.comment}</p>
    </div>

</div>

<hr>