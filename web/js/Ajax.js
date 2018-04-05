$(document).ready(function () {
    $(document).on("click", "#showAll", function () {
        $.ajax({
            type: 'POST',
            // contentType: 'application/json',
            url: '/showAllAJAX',
            success: function (responseJson) {
                $('.simpleRow').remove();
                $('.updateRow').remove();
                $('.additionalRow').remove();
                for (var i = 0; i < responseJson.length; i++) {
                    patternArray(responseJson[i]);
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
                for (var i = 0; i < responseJson.length; i++) {
                    patternArray(responseJson[i]);
                }
            }
        });


    });

    $(document).on("click", "#saveBut", function () {
        if ($('.updateRow').length > 0) updateSome();
        if ($('.additionalRow').length > 0) saveSome();
        hidButtons("save");
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
        //alert("len:" + rows.length + "other:" + data1);
    });

})
;

function saveNew(ee) {
    var row = ee.parentNode.parentNode;
    var name = row.childNodes.item(2).firstChild.value;
    var catName = row.childNodes.item(3).firstChild.value;
    var price = row.childNodes.item(4).firstChild.value;
    var data1 = {name: name, catName: catName, price: price};

    // alert(validationName(name));


    $.ajax({
        type: 'POST',
        data: data1,
        //contentType: 'application/json',
        url: '/addOneAJAX',
        success: function (responseJson) {

            if (responseJson != null && responseJson != "") {
                patternString(row, aa);
            }


        }
    });
}

function updateRow(ee) {
    var row = ee.parentNode.parentNode;
    row.setAttribute("class", "updateRow");
    row.firstChild.firstChild.checked = true;
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
    checkAllBoxes();

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
                patternString(row, responseJson);
            }


        }
    });


}

$(document).on("click", "#deleteBut", function () {
    var x = document.getElementsByName("updateBox");
    var data1 = [];
    for (i = 0; i < x.length; i++) {
        if (x[i].checked == true) {
            var row = x[i].parentNode.parentNode;
            var id = row.lastChild.firstChild.value;
            var preData = new Object();
            preData.id = id;
            data1[data1.length] = preData;
            row.setAttribute("class", "deleteRow");
        }

    }
    $.ajax({
        type: 'POST',
        data: {json: JSON.stringify(data1)},
        url: '/delSomeAJAX',
        success: function () {
            $('.deleteRow').remove();
        }
    });

    checkAllBoxes();

});

function deleteRow(ee) {
    var row = ee.parentNode.parentNode;
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


$(document).on("click", "#updateBut", function () {
    var x = document.getElementsByName("updateBox");
    for (i = 0; i < x.length; i++) {
        if (x[i].checked == true) {
            updateRow(x[i]);
        }
    }
    $('.simpleRow').remove();
    showButtons("undo");
    showButtons("save");
    checkAllBoxes();
    hidButtons("update");
});

$(document).on("click", "#undoBut", function () {
    var x = document.getElementsByName("updateBox");
    for (i = 0; i < x.length; i++) {
        if (x[i].checked == true) {
            backRow(x[i]);
        }
    }
    hidButtons("undo");
    hidButtons("save");
    checkAllBoxes();
});


function updateSome() {
    var data1 = [];
    var x = $('#updateBox:checked');
    for (i = 0; i < x.length; i++) {
        var row = x[i].parentNode.parentNode;
        var preData = new Object();
        preData.id = row.lastChild.firstChild.value;
        preData.name = row.childNodes.item(2).lastChild.value;
        preData.category = new Object();
        preData.category.name = row.childNodes.item(3).firstChild.value;
        preData.price = row.childNodes.item(4).firstChild.value;
        data1[data1.length] = preData;
    }


    $.ajax({
        type: 'POST',
        data: {json: JSON.stringify(data1)},
        //contentType: 'application/json',
        url: '/updateSomeAJAX',
        success: function (responseJson) {

            if (responseJson != null && responseJson != "") {
                for (i = 0; i < responseJson.length; i++) {
                    var tr = x[i].parentNode.parentNode;
                    patternArray2(tr, responseJson[i]);
                }
            }


        }
    });


}

function saveSome() {
    var rows = document.getElementsByClassName("additionalRow");
    var data1 = [];
    for (var i = 0; i < rows.length; i++) {
        var name = rows[i].childNodes.item(2).firstChild.value;
        var catName = rows[i].childNodes.item(3).firstChild.value;
        var price = rows[i].childNodes.item(4).firstChild.value;
        var preData = new Object();
        preData.name = name;
        preData.price = price;
        preData.category = new Object();
        preData.category.name = catName;
        if ((name == "") || (price == "")) {
            rows[i].setAttribute("name", "delIt");
        } else {
            data1[data1.length] = preData;
        }

    }


    var delRows = document.getElementsByName("delIt");
    while (delRows.length) {
        delRows[0].remove();
    }


    $.ajax({
        type: 'POST',
        data: {json: JSON.stringify(data1)},
        url: '/addSomeAJAX',
        success: function (responseJson) {

            if (responseJson != null && responseJson != "") {
                for (i = 0; i < responseJson.length; i++) {
                    var tr = rows[0];
                    patternArray2(tr, responseJson[i]);
                }

            }


        }
    });

}

