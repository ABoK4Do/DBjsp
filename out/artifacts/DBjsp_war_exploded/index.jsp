<%--
  Created by IntelliJ IDEA.
  User: ABoK4Do
  Date: 25.12.16
  Time: 2:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="classes.ResultPOJO" %>

<html>
<head>
    <title>Restaurant</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <script src="js/script.js"></script>

</head>
<body>

<div class="top-name"><h3>Table:<a class="reff" href="index.jsp"><img src="img/refresh-icon-113581.png" width="40px" height="40px"></a></h3></div>
<%  String counter = null; %>


<input type="button" name="hi" value="click" onclick="colorChange()">







<form name="form1" class="Form1" method="POST" action="/wayServlet" >
    <INPUT TYPE="button" src="img/add.png" id="add_plus" VALUE="PLUS" onclick="addTr()">
    <input TYPE="submit" name="chooser"  VALUE="showAll">
    <input type="submit" name="chooser" value="closeAll">
    <input TYPE="submit" id="saveSome" name="chooser" VALUE="SAVE" style="visibility:hidden">
    <input TYPE="submit" id="updateSome" name="chooser" VALUE="UPDATE" style="visibility:hidden">
    <input TYPE="submit" id="deleteSome" name="chooser" VALUE="DELETE" style="visibility:hidden">



    <br>
    <input type="text" name="finder"><select name="searchCat">
        <option value="1">
        Название блюда
        </option>
    <option value="2">
        Категория
    </option>
</select>
    <INPUT TYPE="submit" name="chooser" VALUE="search">
    <br>

    <div class="showAlldiv">
<table class="showAll" id="mainTable">

<%

        if(request.getAttribute("resultArray") != null){
%>
        <tr id="headRow">
            <th width="10px"><input type="checkbox" name="updateBox" value="" onclick="selectAll(this)"></th>
            <th>Photo</th>

            <th>Name</th>
            <th>Category_Name</th>
            <th>Price</th>

            <th><img src="img/update.png" width="25px" height="25px"></th>
            <th><img src="img/delete.png" width="25px" height="25px"></th>
        </tr>
        <%



        ArrayList<ResultPOJO> listTable = (ArrayList<ResultPOJO>) request.getAttribute("resultArray");
        for (ResultPOJO s : listTable){
            String srcLink = "img/food/"+Integer.toString(s.getId())+".jpg";
        %>
    <tr id="bodyRow">
        <th width="10px"><input type="checkbox" name="updateBox" value="<%=s.getId()%>" onclick="checkBoxThis()"></th>
        <th><img src="<%=srcLink%>" height="60px" width="auto"></th>
        <th><%=(s.getName())%></th>
        <th><%=(s.getCat_name())%></th>
        <th><%=Float.toString(s.getPrice())%></th>
        <th><input type="image" src="img/update.png" width="25px" height="25px" name=""></th>
        <th><button type='button' onclick='deleteElem(this)'><img src='img/delete.png' width='25px' height='25px'></button></th>
        <input type="hidden" name="idRow" value="<%=s.getId()%>">
    </tr>
    <div id="add_tr"></div>


        <%}}
        %>
    </table>
    </div>
    <br>


</form>



  </body>
</html>
