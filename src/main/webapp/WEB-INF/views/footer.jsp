<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->


<nav class="navbar navbar-default footer" role="navigation">

    <div class="container-fluid">

        <p class="text-center">Copyright Foodee@2015</p>
        <!--/.nav-collapse -->

    </div>

</nav>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="/Foodeezz/resources/js/bootstrap.min.js"></script>
<%--<script src="http://maps.googleapis.com/maps/api/js"></script>--%>
<script src="/Foodeezz/resources/js/star-rating.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<!-- <script src="view/js/ie10-viewport-bug-workaround.js"></script> -->


<script type="text/javascript">

    //alert("hello world");

    function initBranchesMap() {

        var locations = ${locations};
        var markers;

        var mapOptions = {
            zoom: 15,
            center: new google.maps.LatLng(23.793992700000000000, 90.404271900000020000)
        };

        var showBranchesMap = new google.maps.Map(document.getElementById('branchesMap'),
                mapOptions);

        $.each(locations, function (index, value) {
            placeMarker(value.latitude, value.longtitude);
        });

        function placeMarker(lat, long) {

            marker = new google.maps.Marker({
                position: new google.maps.LatLng(lat, long),
                map: showBranchesMap
            });
        }
    }

    function initializeAddBranchMap() {

        var marker;

        var mapOptions = {
            zoom: 15,
            center: new google.maps.LatLng(23.793992700000000000, 90.404271900000020000)
        };

        var addBranchmap = new google.maps.Map(document.getElementById('addBranchMap'),
                mapOptions);

        google.maps.event.addListener(addBranchmap, 'click', function (event) {
            placeMarker(event.latLng);
        });

        google.maps.event.addListener(addBranchmap, 'rightclick', function (mouseEvent) {
            marker.setMap(null);
            marker = null;

            $("#latLong\\.latitude").val("");
            $("#latLong\\.longtitude").val("");
        });


        function placeMarker(location) {

            if (!marker) {

                marker = new google.maps.Marker({
                    position: location,
                    map: addBranchmap,
                    draggable: true
                });

                google.maps.event.addListener(marker, 'dragend', function (event) {
                    updatePosition(event.latLng);
                });

            } else {
                marker.setPosition(location);
            }

            $("#latLong\\.latitude").val(location.lat());
            $("#latLong\\.longtitude").val(location.lng());

        }

        function updatePosition(location) {
            $("#latLong\\.latitude").val(location.lat());
            $("#latLong\\.longtitude").val(location.lng());
        }

    }

    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $('#preview')
                        .attr('src', e.target.result)
                        .width(150)
                        .height(150);
            };

            reader.readAsDataURL(input.files[0]);
        }
    }

    $(function () {
        var hash = window.location.hash;
        hash && $('ul.nav a[href="' + hash + '"]').tab('show');

        $('.nav-tabs a').click(function (e) {
            $(this).tab('show');
            var scrollmem = $('body').scrollTop();
            window.location.hash = this.hash;
            $('html,body').scrollTop(scrollmem);
        });
    });

    (function (d, s, id) {
        var js, fjs = d.getElementsByTagName(s)[0];
        if (d.getElementById(id)) return;
        js = d.createElement(s);
        js.id = id;
        js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.3&appId=1036493686380443";
        fjs.parentNode.insertBefore(js, fjs);
    }(document, 'script', 'facebook-jssdk'));

    function confirmAction() {
        return  confirm("Are you sure?");
    }

    function toggleSearchMode() {
        $("#advanced").toggle();
    }

    function clearImage(e) {
        e.wrap('<form>').closest('form').get(0).reset();
        e.unwrap();
        $('#preview')
                .attr('src',"#");

        e.preventDefault();
    }


    //google.maps.event.addDomListener(window, 'load', initBranchesMap(${locations}));
    //google.maps.event.addDomListener(window, 'load', initializeAddBranchMap());

</script>

<script async defer
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAr5hzwv9N4ZrwdPFWv5dRArlD_1c9G9MU&callback=initBranchesMap">
</script>

</body>
</html>
