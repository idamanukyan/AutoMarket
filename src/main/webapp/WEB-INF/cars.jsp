<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title>List of Cars</title>
    <link href="css/carsStyle.css" rel="stylesheet">
</head>

<%--<div class="modal fade" id="confirm-delete" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">

            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">Confirm Delete</h4>
            </div>

            <div class="modal-body">
                <p>You are about to delete one track, this procedure is irreversible.</p>
                <p>Do you want to proceed?</p>
                <p class="debug-url"></p>
            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                <a class="btn btn-danger btn-ok">Delete</a>
            </div>
        </div>
    </div>
</div>--%>




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
                    <div class="table-data"><a href="/singleCar?id=<c:out value="${car.id}"/>">Show more</a> | <a
                            href="/updateCar?id=<c:out value="${car.id}"/>">Update</a> |
                        <a href="#"
                           data-href="/deleteCar?id=<c:out value="${car.id}"/>"
                           data-toggle="modal"
                           data-target="#confirm-delete">Delete</a></div>
                </div>
            </c:forEach>


        </div>
    </div>
</div>


<%--<script>
    $('#confirm-delete').on('show.bs.modal', function (e) {
        $(this).find('.btn-ok').attr('href', $(e.relatedTarget).data('href'));
        $('.debug-url').html('Delete URL: <strong>' + $(this).find('.btn-ok').attr('href') + '</strong>');
    });
</script>--%>
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
