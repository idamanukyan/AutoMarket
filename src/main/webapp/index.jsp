<%@ page import="com.example.auto_am.model.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<head>
    <link href="css/carsStyle.css" rel="stylesheet">
</head>

<!DOCTYPE html>
<html>

<title>Welcome to the Garage Company's Official Website</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<body>

<div class="w3-top">
    <div class="w3-bar w3-white w3-wide w3-padding w3-card">
        <b>GARAGE</b> Collection
        <div class="w3-right w3-hide-small">
            <a href="/cars" class="w3-bar-item w3-button">Cars</a>
            <a href="/login" class="w3-bar-item w3-button">LogIn</a>
            <a href="#contact" class="w3-bar-item w3-button">Contact</a>
        </div>
    </div>
</div>


<div class="w3-content w3-padding" style="max-width:1564px">
    <div class="w3-container w3-padding-32" id="about">
        <h3 class="w3-border-bottom w3-border-light-grey w3-padding-16">Car List</h3>
        <p>You can see all available cars in our website below.</p>
        <div class="container">
            <div class="table">
                <div class="table-header">
                    <div class="header__item"><a id="make" class="filter__link">Make</a></div>
                    <div class="header__item"><a id="model" class="filter__link ">Model</a></div>
                    <div class="header__item"><a id="price" class="filter__link filter__link--number">Price</a></div>
                    <div class="header__item"><a id="Show More" class="filter__link ">Action</a></div>
                </div>
                <div class="table-content">
                    <c:forEach var="car" items="${requestScope.get('cars')}">
                    <div class="table-row">
                        <div class="table-data"><c:out value="${car.getMake()}"/></div>
                        <div class="table-data"><c:out value="${car.getModel()}"/></div>
                        <div class="table-data"><c:out value="${car.price}"/></div>
                        <div class="table-data"><a href="/singleCar?id=<c:out value="${car.id}"/>Show more</a></div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Contact Section -->
<div class=" w3-container w3-padding-32" id="contact">
                            <h3 class="w3-border-bottom w3-border-light-grey w3-padding-16">Contact</h3>
                            <p>Lets get in touch and talk about concerning questions.</p>
                            <form action="this" target="_blank">
                                <input class="w3-input w3-border" type="text" placeholder="Name" required name="Name">
                                <input class="w3-input w3-section w3-border" type="text" placeholder="Email" required
                                       name="Email">
                                <input class="w3-input w3-section w3-border" type="text" placeholder="Subject" required
                                       name="Subject">
                                <input class="w3-input w3-section w3-border" type="text" placeholder="Comment" required
                                       name="Comment">
                                <button class="w3-button w3-black w3-section" type="submit">
                                    <i class="fa fa-paper-plane"></i> SEND MESSAGE
                                </button>
                            </form>
                        </div>


                        <!-- End page content -->
                    </div>


                    <!-- Footer -->
                    <footer class="w3-center w3-black w3-padding-16">
                        <p>Powered by Garage company</p>
                    </footer>

</body>

<div id="cars"></div>


<script>
    $(document).ready(function () {
        getCars();
    })

    function getCars() {
        $.ajax({
            url: 'http://localhost:8080/cars',
            method: 'GET'
        }).done(function (data) {
            $("#cars").html(data)
        })
    }
</script>

</html>
