<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Car</title>
</head>
<body>
<% String msg = (String) session.getAttribute("msg");%>
<% if (msg != null && !"".equals(msg)) { %>
<span><%=msg%></span>
<%
        session.removeAttribute("msg");
    }%>
<div class="top">
    <div class="button">
        <a href="/addCar" class="button"><b>Logout</b></a>
        <a href="/home">Home</a>
    </div>
</div>

<form action="/addCar" method="post" enctype="multipart/form-data">
    make: <input type="text" name="make"/> <br>
    model: <input type="text" name="model"/> <br>
    price: <input type="number" name="price"/> <br>
    description: <input type="text" name="description"/> <br>
    picture: <input type="file" name="picture"> <br>
    <input type="submit" value="add car">
</form>

</body>
</html>
