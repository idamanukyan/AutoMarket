<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.example.auto_am.model.Car" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Single Car</title>
</head>
<body>
<%
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    Car car = (Car) request.getAttribute("car");%>

<a href="/home"><b>Go Home</b></a> | <a href="/logout"><b>Logout</b></a>


<h1><%=car.getMake()%>
</h1>
<img src="/getImage?picUrl=<%=car.getPicUrl()%>" width="200"/> <br>
<b>Model:</b> <%=car.getModel()%> <br>
<b>Price:</b> <%=car.getPrice()%> <br>
<b>Description:</b> <%=car.getDescription()%> <br>
<b>Created Date:</b> <%= sdf.format(car.getCreatedDate())%> <br>
<b>User name:</b> <%=car.getUser().getName()%> <br>
<b>User surname:</b> <%=car.getUser().getSurname()%> <br>

</body>
</html>
