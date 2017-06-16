/**
 * Created by ABoK4Do on 31.05.17.
 */

function addRow() {
    var $table = $("#mainTable");
    $("<tr name='additionalRow' class='additionalRow'>").appendTo($table)
        .append($("<td>").html(""))
        .append($("<td>").html("<img src='' height='60px' width='auto'>"))
        .append($("<td>").html("<input type='text' name='addName' value=''>"))
        .append($("<td>").html("<input type='text' name='addCat' value=''>"))
        .append($("<td>").html("<input type='text' name='addPrice' value=''>"))
        .append($("<td>").html("<button type='button' name='yes1' value='SAVE' onclick='saveNew(this)'><img src='img/yes.png' width='25px' height='25px'></button>"))
        .append($("<td>").html("<button type='button' class='delBut' value='del' name='addBut' onclick='deleteRow(this)'><img src='img/delete.png' width='25px' height='25px'></button>"));
    showButtons("save");
}

$(document).on("click", "#hiddenAll", function () {
    $('.simpleRow').toggle();


});

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


    var x = document.getElementsByName("updateBox")
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

}

function backRow(ee) {
    var row = ee.parentNode.parentNode;
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

}