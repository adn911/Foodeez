<div class="row">

    <div class="menuitem-div" class="col-md-12">

        <div class="col-md-5">
            <img src="/Foodeezz/image/menuItem/${item.id}" width="150px" height="150px">
        </div>

        <div class="col-md-7">
            <h3><a href="/Foodeezz/menuItems/${item.id}">${item.name} ${item.restaurant.name}</a></h3>

            <p>Rating: <input type="number" class="rating" data-min="0" data-max="5" data-step="0.5" data-size="xs"
                              data-readonly="true" value="${item.rating.overall}"></p>

            <p>Price: ${item.price}/=</p>

            <p>
                ${item.description}
            </p>
        </div>
    </div>


</div>

<hr>