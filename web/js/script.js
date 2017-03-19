/**
 * Created by ABoK4Do on 14.03.17.
 */
function colorChange(el) {
    document.body.style.backgroundColor = "rgb(255, 255, 0)"


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



function showButtons(xx) {
    if(xx == "1"){
        document.getElementById("updateSome").style.visibility = "visible"
        document.getElementById("deleteSome").style.visibility = "visible"

    }
    if(xx == "0"){
        document.getElementById("updateSome").style.visibility = "hidden"
        document.getElementById("deleteSome").style.visibility = "hidden"
        document.getElementById("saveSome").style.visibility = "hidden"
    }
    if(xx=="2"){
        document.getElementById("updateSome").style.visibility = "visible"
        document.getElementById("deleteSome").style.visibility = "visible"
        document.getElementById("saveSome").style.visibility = "visible"

    }


}
function checkBoxThis() {
    var x = document.getElementsByName("updateBox");
    var checker = 0
    for (i = 0; i < x.length; i++) {
        if ((x[i].type == "checkbox") && (x[i].checked == true)) {
            checker = 1
        }
    }

    showButtons(checker)
}

function addTr() {
    var d = document
    var div = d.getElementById("mainTable")
    var tr = d.createElement("tr")
    div.appendChild(tr)
    var td1 = d.createElement("th")
    tr.appendChild(td1)
    td1.innerHTML = "<input type='checkbox' name='updateBox' value='' onclick='checkBoxThis()'>"
    var td2 = d.createElement("th")
    tr.appendChild(td2)
    td2.innerHTML = "<img src='<%=srcLink%>' height='60px' width='auto'>"
    var td3 = d.createElement("th")
    tr.appendChild(td3)
    td3.innerHTML = "<input type='text' name='addName'>"
    var td4 = d.createElement("th")
    tr.appendChild(td4)
    td4.innerHTML = "<input type='text' name='addCat'>"
    var td5 = d.createElement("th")
    tr.appendChild(td5)
    td5.innerHTML = "<input type='text' name='addPrice'>"
    var td6 = d.createElement("th")
    tr.appendChild(td6)
    td6.innerHTML = "<input type='image' src='img/yes.png' width='25px' height='25px'>"
    var td7 = d.createElement("th")
    tr.appendChild(td7)
    td7.innerHTML = "<button type='button' id='addedBut' onclick='deleteRow(this)'><img src='img/delete.png' width='25px' height='25px'></button>"

    showButtons(2);

}
function deleteRow(r)
{
    var i=r.parentNode.parentNode.rowIndex;
    document.getElementById('mainTable').deleteRow(i);
    if(document.getElementById("addedBut") == null){
        showButtons(0);
    }
}

function deleteElem(r) {
    deleteRow(r);



}