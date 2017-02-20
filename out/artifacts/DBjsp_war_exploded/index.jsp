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
            top: 35px;
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

<table class="showAll">
        <%
        ArrayList listTable = DataBaseWorker.showDB().getResultPOJO();
        int columns = ((ArrayList)listTable.get(0)).size();
        for (Object s : listTable){
        %>

        <tr>
            <%
            for (int i = 0; i < columns; i++) {
            %>

            <th><%=(String)((ArrayList)s).get(i)%></th>
            <%}%>
        </tr>
        <%}%>
    </table>
<div class="Form" >
    <form action="/addOneServlet" method="POST">
        <div align="center">Добавить элемент в таблицу</div>

        <table border="1px">
        <tr><td>Название блюда:</td><td><input name="food_name" type="text" value=""></td></tr>
        <tr><td>Название катергории:</td><td><input name="cat_name" type="text" value=""></td></tr>
        <tr><td>Цена:</td><td><input name="price" type="text" value=""></td></tr>
            <tr><td></td><td><input name="but" type="submit" value="Добавить"></td></tr>
        </table>
    </form>
    <form action="/delOneServlet" method="post">
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