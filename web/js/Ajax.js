$(document).ready(function () {
    $(document).on("click", "#showAll", function () {
        $.ajax({
            type: 'POST',
            // contentType: 'application/json',
            url: '/showAllAJAX',
            success: function (responseJson) {
                $('.simpleRow').remove();
                $('.additionalRow').remove();
                var tr;
                for (var i = 0; i < responseJson.length; i++) {
                    tr = $('<tr class="simpleRow">');
                    tr.append("<td>" + "<input type='checkbox' name='updateBox' value=''>" + "</td>");
                    tr.append("<td>" + "<img src='../img/food/default_food.png' height='60px' width='auto'>" + "</td>");
                    tr.append("<td>" + responseJson[i].name + "</td>");
                    tr.append("<td>" + responseJson[i].category.name + "</td>");
                    tr.append("<td>" + responseJson[i].price + "</td>");
                    tr.append("<td>" + "<button type='button' name='updBut'' class='updBut' onclick='updateRow(this)' value=" + responseJson[i].id + "><img src='img/update.png' width='25px' height='25px'></button>" + "</td>");
                    tr.append("<td>" + "<button type='button' name='delBut' class='delBut' onclick='deleteRow(this)' value=" + responseJson[i].id + "><img src='img/delete.png' width='25px' height='25px'></button>" + "</td>");
                    $("#mainTable").append(tr);
                }
            }
        });


    });

    $(document).on("click", "#findBut", function () {
        var finder = $('#finder').val();
        var search = $('#searchCat').val();
        var data1 = {finder: finder, searchCat: search};
        $.ajax({
            type: 'POST',
            data: data1,
            //contentType: 'application/json',
            url: '/searchAJAX',
            success: function (responseJson) {
                $('.simpleRow').remove();
                $('.additionalRow').remove();
                var tr;
                for (var i = 0; i < responseJson.length; i++) {
                    tr = $('<tr class="simpleRow">');
                    tr.append("<td>" + "<input type='checkbox' name='updateBox' value=''>" + "</td>");
                    tr.append("<td>" + "<img src='../img/food/default_food.png' height='60px' width='auto'>" + "</td>");
                    tr.append("<td>" + responseJson[i].name + "</td>");
                    tr.append("<td>" + responseJson[i].category.name + "</td>");
                    tr.append("<td>" + responseJson[i].price + "</td>");
                    tr.append("<td>" + "<button type='button' name='updBut'  class='updBut' onclick='updateRow(this)' value=" + responseJson[i].id + "><img src='img/update.png' width='25px' height='25px'></button>" + "</td>");
                    tr.append("<td>" + "<button type='button' name='delBut' class='delBut' onclick='deleteRow(this)' value=" + responseJson[i].id + "><img src='img/delete.png' width='25px' height='25px'></button>" + "</td>");
                    $("#mainTable").append(tr);
                }
            }
        });


    });

    $(document).on("click", "#saveBut", function () {
        var rows = document.getElementsByClassName("additionalRow");
        var data1 = [];
        for (var i = 0; i < rows.length; i++) {
            var name = rows[i].childNodes.item(2).firstChild.value;
            var catName = rows[i].childNodes.item(3).firstChild.value;
            var price = rows[i].childNodes.item(4).firstChild.value;
            if ((name == "") || (price == "")) {
                rows[i].setAttribute("name", "delIt");
            } else {
                data1[data1.length] = {name: name, catName: catName, price: price};
            }

        }
        var delRows = document.getElementsByName("delIt");
        while (delRows.length) {
            delRows[0].remove();
        }


        $.ajax({
            type: 'POST',
            data: data1,
            dataType: 'json',
            //contentType: 'application/json',
            url: '/addSomeAJAX',
            success: function (responseJson) {

                if (responseJson != null && responseJson != "") {
                    for (i = 0; i < responseJson.length; i++) {
                        var tr= rows[0];
                        while (tr.firstChild) {
                            tr.removeChild(tr.firstChild);
                        }
                        tr.setAttribute("class", "simpleRow")
                        var td = document.createElement("td");
                        tr.appendChild(td);
                        td.innerHTML = "<input type='checkbox' name='updateBox' value=''>";
                        var td = document.createElement("td");
                        tr.appendChild(td);
                        td.innerHTML = "<img src='../img/food/default_food.png' height='60px' width='auto'>";
                        var td = document.createElement("td");
                        tr.appendChild(td);
                        td.innerHTML = responseJson[i].name;
                        var td = document.createElement("td");
                        tr.appendChild(td);
                        td.innerHTML = responseJson[i].category.name;
                        var td = document.createElement("td");
                        tr.appendChild(td);
                        td.innerHTML = responseJson[i].price;
                        var td = document.createElement("td");
                        tr.appendChild(td);
                        td.innerHTML = "<button type='button' name='updBut' class='updBut' onclick='updateRow(this)' value=" + responseJson[i].id + "><img src='img/update.png' width='25px' height='25px'></button>";
                        var td = document.createElement("td");
                        tr.appendChild(td);
                        td.innerHTML = "<button type='button' name='delBut' class='delBut' onclick='deleteRow(this)' value=" + responseJson[i].id + "><img src='img/delete.png' width='25px' height='25px'></button>";
                    }

                }


            }
        });
    });


    $(document).on("click", "#checkBut", function () {
        var rows = document.getElementsByClassName("additionalRow");
        var data1 = [];
        for (var i = 0; i < rows.length; i++) {
            var name = rows[i].childNodes.item(2).firstChild.value;
            var catName = rows[i].childNodes.item(3).firstChild.value;
            var price = rows[i].childNodes.item(4).firstChild.value;
            if ((name == "") || (price == "")) {
                rows[i].setAttribute("name", "delIt");
            } else {
                data1[data1.length] = {name: name, catName: catName, price: price};
            }

        }
        var delRows = document.getElementsByName("delIt");
        while (delRows.length) {
            delRows[0].remove();
        }
        alert("len:" + rows.length + "other:" + data1);
    });

});

function saveNew(ee) {
    var row = ee.parentNode.parentNode;
    var name = row.childNodes.item(2).firstChild.value;
    var catName = row.childNodes.item(3).firstChild.value;
    var price = row.childNodes.item(4).firstChild.value;
    var data1 = {name: name, catName: catName, price: price};

    $.ajax({
        type: 'POST',
        data: data1,
        //contentType: 'application/json',
        url: '/addOneAJAX',
        success: function (responseJson) {

            if (responseJson != null && responseJson != "") {
                var tr;
                while (row.firstChild) {
                    row.removeChild(row.firstChild);
                }
                row.setAttribute("class", "simpleRow")
                tr = row;
                var td = document.createElement("td");
                tr.appendChild(td);
                td.innerHTML = "<input type='checkbox' name='updateBox' value=''>";
                var td = document.createElement("td");
                tr.appendChild(td);
                td.innerHTML = "<img src='../img/food/default_food.png' height='60px' width='auto'>";
                var td = document.createElement("td");
                tr.appendChild(td);
                td.innerHTML = responseJson.name;
                var td = document.createElement("td");
                tr.appendChild(td);
                td.innerHTML = responseJson.category.name;
                var td = document.createElement("td");
                tr.appendChild(td);
                td.innerHTML = responseJson.price;
                var td = document.createElement("td");
                tr.appendChild(td);
                td.innerHTML = "<button type='button' name='updBut' class='updBut' onclick='updateRow(this)' value=" + responseJson.id + "><img src='img/update.png' width='25px' height='25px'></button>";
                var td = document.createElement("td");
                tr.appendChild(td);
                td.innerHTML = "<button type='button' name='delBut' class='delBut' onclick='deleteRow(this)' value=" + responseJson.id + "><img src='img/delete.png' width='25px' height='25px'></button>";
            }


        }
    });
}

function updateRow(ee) {
    row = ee.parentNode.parentNode;
    row.childNodes.item(1).firstChild.checked = true;
    var nameTd = row.childNodes.item(2);
    var catTd = row.childNodes.item(3);
    var priceTd = row.childNodes.item(4);
    var name = nameTd.innerText;
    var catName = catTd.innerText;
    var price = priceTd.innerText;

    nameTd.innerText = "";
    catTd.innerText = "";
    priceTd.innerText = "";
    var input = document.createElement("input");
    input.setAttribute("type", "hidden");
    input.setAttribute("value", name);
    nameTd.appendChild(input);
    var input = document.createElement("input");
    input.setAttribute("type", "hidden");
    input.setAttribute("value", catName);
    nameTd.appendChild(input);
    var input = document.createElement("input");
    input.setAttribute("type", "hidden");
    input.setAttribute("value", price);
    nameTd.appendChild(input);
    var input = document.createElement("input");
    input.setAttribute("type", "text");
    input.setAttribute("value", name);
    nameTd.appendChild(input);
    input = document.createElement("input")
    input.setAttribute("type", "text");
    input.setAttribute("value", catName);
    catTd.appendChild(input);
    input = document.createElement("input")
    input.setAttribute("type", "text");
    input.setAttribute("value", price);
    priceTd.appendChild(input);

    row.childNodes.item(5).firstChild.firstChild.setAttribute("src", "img/yes.png");
    row.childNodes.item(5).firstChild.setAttribute("onclick", "saveRow(this)");
    row.childNodes.item(6).firstChild.firstChild.setAttribute("src", "img/back.png");
    row.childNodes.item(6).firstChild.setAttribute("onclick", "backRow(this)");

}

function saveRow(ee) {
    var row = ee.parentNode.parentNode;
    var id = ee.value;
    var name = row.childNodes.item(2).lastChild.value;
    var catName = row.childNodes.item(3).firstChild.value;
    var price = row.childNodes.item(4).firstChild.value;
    var data1 = {id: id, name: name, catName: catName, price: price};

    $.ajax({
        type: 'POST',
        data: data1,
        //contentType: 'application/json',
        url: '/updateOneAJAX',
        success: function (responseJson) {

            if (responseJson != null && responseJson != "") {
                var tr;
                while (row.firstChild) {
                    row.removeChild(row.firstChild);
                }
                row.setAttribute("class", "simpleRow")
                tr = row;
                var td = document.createElement("td");
                tr.appendChild(td);
                td.innerHTML = "<input type='checkbox' name='updateBox' value=''>";
                var td = document.createElement("td");
                tr.appendChild(td);
                td.innerHTML = "<img src='../img/food/default_food.png' height='60px' width='auto'>";
                var td = document.createElement("td");
                tr.appendChild(td);
                td.innerHTML = responseJson.name;
                var td = document.createElement("td");
                tr.appendChild(td);
                td.innerHTML = responseJson.category.name;
                var td = document.createElement("td");
                tr.appendChild(td);
                td.innerHTML = responseJson.price;
                var td = document.createElement("td");
                tr.appendChild(td);
                td.innerHTML = "<button type='button' name='updBut' class='updBut' onclick='updateRow(this)' value=" + responseJson.id + "><img src='img/update.png' width='25px' height='25px'></button>";
                var td = document.createElement("td");
                tr.appendChild(td);
                td.innerHTML = "<button type='button' name='delBut' class='delBut' onclick='deleteRow(this)' value=" + responseJson.id + "><img src='img/delete.png' width='25px' height='25px'></button>";

            }


        }
    });


}

function deleteRow(ee) {
    row = ee.parentNode.parentNode;
    var id = ee.value;
    if (id == "del") {
        var i = row.rowIndex;
        document.getElementById('mainTable').deleteRow(i);
        if (document.getElementsByClassName("delBut").length == 0) {
            hidButtons("save");
        }

    } else {
        $.ajax({
            type: 'POST',
            data: {id: id},
            //contentType: 'application/json',
            url: '/delOneAJAX',
            success: function () {
                var i = row.rowIndex;
                document.getElementById('mainTable').deleteRow(i);
            }

        });
    }
}



