/**
 * Created by ABoK4Do on 31.05.17.
 */

function addRow() {
    var $table = $("#mainTable");
    $("<tr name='additionalRow' class='additionalRow'>").appendTo($table)
        .append($("<td>").html(""))
        .append($("<td>").html("<img src='' height='60px' width='auto'>"))
        .append($("<td>").html("<input type='text' name='addName' value='' id='nameField'>"))
        .append($("<td>").html("<input type='text' name='addCat' value='' id='catNameField'>"))
        .append($("<td>").html("<input type='text' name='addPrice' value='' id='priceField'>"))
        .append($("<td>").html("<button type='button' name='yes1' value='SAVE' onclick='saveNew(this)'><img src='img/yes.png' width='25px' height='25px'></button>"))
        .append($("<td>").html("<button type='button' class='delBut' value='del' name='addBut' onclick='deleteRow(this)'><img src='img/delete.png' width='25px' height='25px'></button>"));
    showButtons("save");
}

$(document).on("click", "#hiddenAll", function () {
    $('.simpleRow').toggle();
});

$(document).on("click", "#updateBox", function () {
    checkAllBoxes();
});

function checkAllBoxes() {
    var x = document.getElementsByName("updateBox");
    var flag = 0;
    for (var i = 0; i < x.length; i++) {
        var row = x[i].parentNode.parentNode;
        var rowClass = row.getAttribute("class");
        if (x[i].checked == true & rowClass == "simpleRow") {
            flag++;
        }
    }
    if (flag > 0) {
        showButtons("update");
        showButtons("delete");
    } else {
        hidButtons("update");
        hidButtons("delete");
    }
}

function showButtons(str) {
    str = str + "But";
    document.getElementById(str).style.visibility = "visible";
}
function hidButtons(str) {
    str = str + "But";
    document.getElementById(str).style.visibility = "hidden";
}

/*$(document).on("click", ".simpleRow", function (){
 var checker = this.firstChild.firstChild;
 if(checker.checked == true){
 checker.checked = false;
 }
 else {
 checker.checked = true;
 }

 });*/

/*function deleteRow(r) {

 var i = r.parentNode.parentNode.rowIndex;
 document.getElementById('mainTable').deleteRow(i);
 if (document.getElementById("addedBut") == null) {
 showButtons(0);
 }
 }*/


function selectAll(elem) {


    var x = document.getElementsByName("updateBox");
    var i;
    if (elem.checked == true) {
        for (i = 0; i < x.length; i++) {
            if (x[i].type == "checkbox") {
                x[i].checked = true


            }
        }
    }
    else {
        for (i = 0; i < x.length; i++) {
            if (x[i].type == "checkbox") {
                x[i].checked = false

            }
        }
    }
    checkAllBoxes();

}

function backRow(ee) {
    var row = ee.parentNode.parentNode;
    row.setAttribute("class", "simpleRow");
    row.firstChild.firstChild.checked = false;
    var nameTd = row.childNodes.item(2);
    var catTd = row.childNodes.item(3);
    var priceTd = row.childNodes.item(4);
    //Достаю прежние данные
    var name = nameTd.firstChild.value;
    nameTd.firstChild.remove();
    var catName = nameTd.firstChild.value;
    nameTd.firstChild.remove();
    var price = nameTd.firstChild.value;
    nameTd.firstChild.remove();
    //Очистка под новую инфу
    nameTd.firstChild.remove();
    catTd.firstChild.remove();
    priceTd.firstChild.remove();
    //Загрузка новой инфы
    nameTd.innerText = name;
    catTd.innerText = catName;
    priceTd.innerText = price;
    //Смена знаков и функций кнопок
    row.childNodes.item(5).firstChild.firstChild.setAttribute("src", "img/update.png");
    row.childNodes.item(5).firstChild.setAttribute("onclick", "updateRow(this)");
    row.childNodes.item(6).firstChild.firstChild.setAttribute("src", "img/delete.png");
    row.childNodes.item(6).firstChild.setAttribute("onclick", "deleteRow(this)");

    checkAllBoxes();

}

function validationPrice(price) {
    if ((price > 2147483647) || (price <= 0)) {
        return false;
    }
    return (price.search("[0-9]{1,}") != -1)

}

function validationName(name) {
    return (name.search("[a-z]{1,}|[A-Z]{1,}|[а-я]{1,}|[А-Я]{1,}")!=-1)

}

function patternArray(aa) {
    var tr = $('<tr class="simpleRow">');
    tr.append("<td>" + "<input type='checkbox' name='updateBox' id='updateBox' value=''>" + "</td>");
    tr.append("<td>" + "<img src='../img/food/default_food.png' height='60px' width='auto'>" + "</td>");
    tr.append("<td>" + aa.name + "</td>");
    tr.append("<td>" + aa.category.name + "</td>");
    tr.append("<td>" + aa.price + "</td>");
    tr.append("<td>" + "<button type='button' name='updBut'' class='updBut' onclick='updateRow(this)' value=" + aa.id + "><img src='img/update.png' width='25px' height='25px'></button>" + "</td>");
    tr.append("<td>" + "<button type='button' name='delBut' class='delBut' onclick='deleteRow(this)' value=" + aa.id + "><img src='img/delete.png' width='25px' height='25px'></button>" + "</td>");
    $("#mainTable").append(tr);


}

function patternString(row, aa) {
    var tr;
    while (row.firstChild) {
        row.removeChild(row.firstChild);
    }
    row.setAttribute("class", "simpleRow")
    tr = row;
    var td = document.createElement("td");
    tr.appendChild(td);
    td.innerHTML = "<input type='checkbox' name='updateBox' id='updateBox' value=''>";
    var td = document.createElement("td");
    tr.appendChild(td);
    td.innerHTML = "<img src='../img/food/default_food.png' height='60px' width='auto'>";
    var td = document.createElement("td");
    tr.appendChild(td);
    td.innerHTML = aa.name;
    var td = document.createElement("td");
    tr.appendChild(td);
    td.innerHTML = aa.category.name;
    var td = document.createElement("td");
    tr.appendChild(td);
    td.innerHTML = aa.price;
    var td = document.createElement("td");
    tr.appendChild(td);
    td.innerHTML = "<button type='button' name='updBut' class='updBut' onclick='updateRow(this)' value=" + aa.id + "><img src='img/update.png' width='25px' height='25px'></button>";
    var td = document.createElement("td");
    tr.appendChild(td);
    td.innerHTML = "<button type='button' name='delBut' class='delBut' onclick='deleteRow(this)' value=" + aa.id + "><img src='img/delete.png' width='25px' height='25px'></button>";
}

function patternArray2(tr,aa) {

    while (tr.firstChild) {
        tr.removeChild(tr.firstChild);
    }
    var td = document.createElement("td");
    tr.appendChild(td);
    td.innerHTML = "<input type='checkbox' name='updateBox' id='updateBox' value=''>";
    var td = document.createElement("td");
    tr.appendChild(td);
    td.innerHTML = "<img src='../img/food/default_food.png' height='60px' width='auto'>";
    var td = document.createElement("td");
    tr.appendChild(td);
    td.innerHTML = aa.name;
    var td = document.createElement("td");
    tr.appendChild(td);
    td.innerHTML = aa.category.name;
    var td = document.createElement("td");
    tr.appendChild(td);
    td.innerHTML = aa.price;
    var td = document.createElement("td");
    tr.appendChild(td);
    td.innerHTML = "<button type='button' name='updBut' class='updBut' onclick='updateRow(this)' value=" + aa.id + "><img src='img/update.png' width='25px' height='25px'></button>";
    var td = document.createElement("td");
    tr.appendChild(td);
    td.innerHTML = "<button type='button' name='delBut' class='delBut' onclick='deleteRow(this)' value=" + aa.id + "><img src='img/delete.png' width='25px' height='25px'></button>";
    tr.setAttribute("class", "simpleRow");

}