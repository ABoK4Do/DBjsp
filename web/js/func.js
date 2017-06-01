/**
 * Created by ABoK4Do on 31.05.17.
 */
function addRow() {
    var $table = $("#mainTable");
    $("<tr class='additionalRow'>").appendTo($table)
        .append($("<td>").html(""))
        .append($("<td>").html("<img src='' height='60px' width='auto'>"))
        .append($("<td>").html("<input type='text' name='addName' value=''>"))
        .append($("<td>").html("<input type='text' name='addCat' value=''>"))
        .append($("<td>").html("<input type='text' name='addPrice' value=''>"))
        .append($("<td>").html("<button type='button' id='yes' value='SAVE' ><img src='img/yes.png' width='25px' height='25px'></button>"))
        .append($("<td>").html("<button type='button' id='addedBut' onclick='deleteRow(this)'><img src='img/delete.png' width='25px' height='25px'></button>"));

}

$(document).on("click", "#hiddenAll", function() {
    $('.simpleRow').toggle();


});

function deleteRow(r)
{

    var i=r.parentNode.parentNode.rowIndex;
    document.getElementById('mainTable').deleteRow(i);
    if(document.getElementById("addedBut") == null){
        showButtons(0);
    }
}


function selectAll(elem) {


    var x = document.getElementsByName("updateBox")
    var i;
    if(elem.checked ==  true){
        for (i = 0; i < x.length; i++) {
            if (x[i].type == "checkbox") {
                x[i].checked = true
                showButtons(1)
            }
        }}
    else {
        for (i = 0; i < x.length; i++) {
            if (x[i].type == "checkbox") {
                x[i].checked = false
                showButtons(0)
            }
        }
    }
}