<%@ page import="com.example.auto_am.model.Car" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Car</title>
</head>
<body>
<% String msg = (String) session.getAttribute("msg");%>
<% Car car = (Car) request.getAttribute("car");%>
<% if (msg != null && !"".equals(msg)) { %>
<span><%=msg%></span>
<%
        session.removeAttribute("msg");
    }%>
<h1><b>Add Car</b></h1> | <a href="/logout"><b>Logout</b></a>


<form action="/updateCar" method="post" enctype="multipart/form-data">
    <input type="hidden" name="id" value="<%=car.getId()%>">
    <b>Make:</b> <input type="text" name="make" value="<%=car.getMake()%>"/> <br>
    <b>Model:</b> <input type="text" name="model" value="<%=car.getModel()%>"/> <br>
    <b>Price:</b> <input type="number" name="price" value="<%=car.getPrice()%>"/> <br>
    <b>Description:</b> <input type="text" name="description" value="<%=car.getDescription()%>"/> <br>
    <b>Picture:</b> <input type="file" name="picture"> <br>
    <input type="submit" value="update car">
</form>
</body>
</html>
