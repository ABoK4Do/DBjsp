$(document).ready(function () {
    $(document).on("click", "#showAll", function () {
        $.ajax({
            type: 'POST',
            // contentType: 'application/json',
            url: '/showAllAJAX',
            success: function (responseJson) {
                $('.simpleRow').remove();
                $('.additionalRow').remove();
                var $table = $("#mainTable");
                $.each(responseJson, function (index, food) {
                    $("<tr class='simpleRow'>").appendTo($table)
                        .append($("<td>").html("<input type='checkbox' name='updateBox' value=''>"))
                        .append($("<td>").html("<img src='../img/food/default_food.png' height='60px' width='auto'>"))
                        .append($("<td>").text(food.name))
                        .append($("<td>").text(food.category.name))
                        .append($("<td>").text(food.price))
                        .append($("<td>").html("<button type='button' name='sayHello' id='updateBut'' ><img src='img/update.png' width='25px' height='25px'></button>"))
                        .append($("<td>").html("<button type='button' id='addedBut' onclick='deleteRow(this)' value=" + food.id + "><img src='img/delete.png' width='25px' height='25px'></button>"));
                });
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
                var $table = $("#mainTable");
                $.each(responseJson, function (index, food) {
                    $("<tr class='simpleRow'>").appendTo($table)
                        .append($("<td>").html("<input type='checkbox' name='updateBox' value=''>"))
                        .append($("<td>").html("<img src='../img/food/default_food.png' height='60px' width='auto'>"))
                        .append($("<td>").text(food.name))
                        .append($("<td>").text(food.category.name))
                        .append($("<td>").text(food.price))
                        .append($("<td>").html("<button type='button' name='sayHello' id='updateBut''><img src='img/update.png' width='25px' height='25px'></button>"))
                        .append($("<td>").html("<button type='button' id='addedBut' onclick='deleteRow(this)' value=" + food.id + "><img src='img/delete.png' width='25px' height='25px'></button>"));
                });
            }
        });


    });


    $(document).on("click", "#checkBut", function () {
        var row = document.getElementsByName('yes1').item(0).parentNode.parentNode.childNodes.item(6).firstChild.value;
        // var name = row.getElementsByName('addName').val();
        alert(row);
    });

});

function saveNew(ee) {
    var row = ee.parentNode.parentNode;
    var name = row.childNodes.item(2).firstChild.value;
    var catName = row.childNodes.item(3).firstChild.value;
    var price = row.childNodes.item(4).firstChild.value;
    alert(name+catName+price);
    var data1 = {name: name, catName: catName, price: price};

    $.ajax({
        type: 'POST',
        data: data1,
        //contentType: 'application/json',
        url: '/addOneAJAX',
        success: function (responseJson) {
            $('.simpleRow').remove();
            $('.additionalRow').remove();
            var $table = $("#mainTable");
            //$.each(responseJson, function (index, food) {
                $("<tr class='simpleRow'>").appendTo($table)
                    .append($("<td>").html("<input type='checkbox' name='updateBox' value=''>"))
                    .append($("<td>").html("<img src='../img/food/default_food.png' height='60px' width='auto'>"))
                    .append($("<td>").text(food.name))
                    .append($("<td>").text("here")) //food.category.name
                    .append($("<td>").text(food.price))
                    .append($("<td>").html("<button type='button' name='sayHello' id='updateBut'' ><img src='img/update.png' width='25px' height='25px'></button>"))
                    .append($("<td>").html("<button type='button' id='addedBut' onclick='deleteRow(this)' value=" + food.id + "><img src='img/delete.png' width='25px' height='25px'></button>"));
           // }


        }
    });
}



