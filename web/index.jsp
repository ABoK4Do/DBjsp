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

            left: 80px;
            top: 15px;
        }
        .showAll {
            border: black 1px solid;
            background-color: greenyellow;
            overflow: auto;
            height: 80%;
        }
        th{
                border: black 2px solid;


            }
        body {
            background-color: #fdffd5;
            padding-left: 15%;
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
        .Form1{
            width: 80%;
            height: 90%;
h

        }
        table{
            width: 100%;
        }
        .showAlldiv {
            height: 80%;
            overflow: scroll;
        }
        tr {
            max-height: 20px;
        }


    </style>
</head>
<body>

<div class="top-name"><h3>Table:<a class="reff" href="index.jsp"><img src="img/refresh-icon-113581.png" width="40px" height="40px"></a></h3></div>
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
    function findJS() {
        var counter = 3
        document.form1.hidden.value = counter
        form1.submit()
    }
    function addJS() {
        var counter = 2
        document.form1.hidden.value = counter

        form1.submit()
        window.onload=document.getElementById('add_plus').scrollIntoView(true)

    }


</script>
<form name="form1" class="Form1" method="POST">
    <INPUT TYPE="BUTTON" VALUE="showAll" ONCLICK="showAllJS()">
    <INPUT TYPE="BUTTON" VALUE="closeAll" ONCLICK="closeAllJS()">
    <INPUT TYPE="hidden" name="hidden" VALUE="1">

    <br>
    <input type="text" name="finder"><INPUT TYPE="BUTTON" VALUE="find" ONCLICK="findJS()">
    <br>
    <% if(request.getParameter("hidden") != null) {
        counter = Integer.parseInt(request.getParameter("hidden"));
    }
    if(counter !=0){
    %>
    <div class="showAlldiv">
<table class="showAll">


        <tr>
            <th width="10px"><input type="checkbox" name="update" value=""></th>
            <th>Photo</th>

            <th>Name</th>
            <th>Category_Name</th>
            <th>Price</th>

            <th><img src="img/update.png" width="25px" height="25px"></th>
            <th><img src="img/delete.png" width="25px" height="25px"></th>
        </tr>
        <%
            }
        if((counter==1)||(counter==2)){
        ArrayList<ResultPOJO> listTable = DataBaseWorker.showDB();
        for (ResultPOJO s : listTable){
            String srcLink = "img/food/"+Integer.toString(s.getId())+".jpg";
        %>
    <tr>
        <th width="10px"><input type="checkbox" name="update" value=""></th>
        <th><img src="<%=srcLink%>" height="60px" width="auto"></th>
        <th><%=(s.getName())%></th>
        <th><%=(s.getCat_name())%></th>
        <th><%=Float.toString(s.getPrice())%></th>
        <th><input type="image" src="img/update.png" width="25px" height="25px" name=""></th>
        <th><form action="/delClick?<%=(s.getName())%>" method="POST"><input type="image" src="img/delete.png" width="25px" height="25px" ></form></th>

    </tr>


        <%}}
            if(counter==2){
                %>
    <tr>
        <form action="/addOneServlet" method="POST">
        <th></th>
        <th></th>
        <th><input type="text" name="food_name"></th>
        <th><input type="text" name="cat_name"></th>
            <th><input type="text" name="price"></th>
        <th><input type="image" src="img/yes.png" width="25px" height="25px" name="yes"></th>
            </form>
        <th><input type="image" src="img/delete.png" width="25px" height="25px" name="no" ONCLICK="showAllJS()" > </th>

    </tr>
    <%

        }%>
    </table>
    </div>
    <br>
    <INPUT TYPE="image" src="img/add.png" id="add_plus" VALUE="PLUS" ONCLICK="addJS()">
</form>


  </body>
</html>
