<%--
  Created by IntelliJ IDEA.
  User: ABoK4Do
  Date: 25.12.16
  Time: 2:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="classes.DataBaseWorker" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="classes.ResultPOJO" %>

<html>
<head>
    <title>Restaurant</title>
    <style>
        .reff{
            position: absolute;
            left: 80px;
            top: 5px;
        }
        .showAll {
            border: black 1px solid;
            background-color: greenyellow;
        }
        th{
                border: black 2px solid;

            }
        body {
            background-color: #fdffd5;
        }
        .top-name {
            margin-top:5px;
        }
        .Form {
            position: fixed;
            top: 65px;
            right: 150px;
            height: 200px;
            background-color: red;
            padding:10px;
        }

    </style>
</head>
<body>
<a class="reff" href="index.jsp"><img src="img/refresh-icon-113581.png" width="40px" height="40px"></a>
<div class="top-name"><h3>Table:</h3></div>
<% int counter=1; %>
<script>
    function showAllJS() {
        var counter = 1
        document.form1.hidden.value = counter
        form1.submit()

    }
    function closeAllJS() {
        var counter = 0
        document.form1.hidden.value = counter
        form1.submit()

    }

</script>
<form name="form1" method="POST">
    <INPUT TYPE="BUTTON" VALUE="showAll" ONCLICK="showAllJS()">
    <INPUT TYPE="BUTTON" VALUE="closeAll" ONCLICK="closeAllJS()">
    <INPUT TYPE="hidden" name="hidden" VALUE="1">

    <% if(request.getParameter("hidden") != null) {
        counter = Integer.parseInt(request.getParameter("hidden"));
    }
    if(counter ==1){
    %>


<table class="showAll">


        <tr>
            <th></th>
            <th>Photo</th>
            <th>ID</th>
            <th>Name</th>
            <th>Category_ID</th>
            <th>Price</th>
            <th>|||||</th>
            <th>Cat_ID</th>
            <th>Name</th>
            <th><img src="img/update.png" width="25px" height="25px"></th>
            <th><img src="img/delete.png" width="25px" height="25px"></th>
        </tr>
        <%

        ArrayList<ResultPOJO> listTable = DataBaseWorker.showDB();
        for (ResultPOJO s : listTable){
            String srcLink = "img/food/"+Integer.toString(s.getId())+".jpg";
        %>
    <tr>
        <th><input type="checkbox" name="update" value=""></th>
        <th><img src="<%=srcLink%>" height="60px" width="auto"></th>
        <th><%=Integer.toString(s.getId())%></th>
        <th><%=(s.getName())%></th>
        <th><%=Integer.toString(s.getCat_id1())%></th>
        <th><%=Float.toString(s.getPrice())%></th>
        <th>|||||</th>
        <th><%=Integer.toString(s.getCat_id2())%></th>
        <th><%=(s.getCat_name())%></th>
        <th><input type="image" src="img/update.png" width="25px" height="25px" name=""></th>
        <th><form action="/delClick?<%=(s.getName())%>" method="POST"><input type="image" src="img/delete.png" width="25px" height="25px" ></form></th>

    </tr>


        <%}}%>
    </table>

</form>
<div class="Form" >
    <form name="form2" action="/addOneServlet" method="POST">
        <div align="center">Добавить элемент в таблицу</div>

        <table border="1px">
        <tr><td>Название блюда:</td><td><input name="food_name" type="text" value=""></td></tr>
        <tr><td>Название катергории:</td><td><input name="cat_name" type="text" value=""></td></tr>
        <tr><td>Цена:</td><td><input name="price" type="text" value=""></td></tr>
            <tr><td></td><td><input name="but" type="submit" value="Добавить"></td></tr>
        </table>
    </form>
    <form name="form3" action="/delOneServlet" method="post">
        Удалить:
        <table>
            <tr>
                <td><input type="text" name="del_name"></td>
                <td><input name="del_but" type="submit" value="Удалить"></td>
            </tr>
        </table>
    </form>
</div>

  </body>
</html>
