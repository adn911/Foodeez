<div class="row">


    <div class="restaurant-div" class="col-md-12">

        <div class="col-md-5">
            <img src="/Foodeezz/image/restaurant/${restaurant.id}" width="150px" height="150px" style="margin: 10px;">
        </div>

        <div class="col-md-7">
            <h3><a href="/Foodeezz/restaurants/${restaurant.id}">${restaurant.name}</a></h3>

            <p>Rating: <input type="number" class="rating" data-min="0" data-max="5" data-step="0.5" data-size="xs"
                              data-readonly="true" value="${restaurant.rating.overall}"></p>

            <p>
                ${restaurant.description}
            </p>
        </div>
    </div>

</div>

<hr>