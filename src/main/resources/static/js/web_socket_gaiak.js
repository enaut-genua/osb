var stompClient = null;

$(document).ready(function () {
    console.log("11145678");
    connect();
    var botoiak = document.getElementsByClassName("send");
    for (var i = 0; i < botoiak.length; i++) {
        botoiak[i].addEventListener("click", function () {
            var buttonValue = this.value;
            console.log(buttonValue);
            kargatu(buttonValue);
        });
    }

});

function connect() {
    console.log("triying");
    var socket = new SockJS('/ourws');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function () {
        console.log("connected");
        stompClient.subscribe('/osb/gaiak', function (message) {
            // Manejar el mensaje recibido
            console.log(message.body);
            showMessage(message.body);
        });
    });

}

function showMessage(message) {
    var artxiboLista = JSON.parse(message);
    var id;
    var izena;
    var divElement = document.getElementById("dataContainer");

    while (divElement.firstChild) {
        divElement.removeChild(divElement.firstChild);
    }
    for (var i = 0; i < artxiboLista.length; i++) {
        id = artxiboLista[i].artxiboID;
        izena = artxiboLista[i].izena;
        gehituHtml = "<div class='card mb-3' style='background-color: rgb(43, 43, 43);''><h3 class='card-header' style='color: antiquewhite;''>" + izena + "</h3><div class='card-body'><a href='/gaiak/" + id + "/deskargatu' class='card-link'>Deskargatu</a></div></div>";
        $("#dataContainer").append(gehituHtml);
    }
}
function kargatu(id){
    var divElement = document.getElementById("dataContainer");

    while (divElement.firstChild) {
        divElement.removeChild(divElement.firstChild);
    }
    gehituHtml = "<div class='text-center'><div class='spinner-border' role='status'><span class='visually-hidden'>Loading...</span></div></div>";
        $("#dataContainer").append(gehituHtml);
    bidaliGaiaId(id);
}
function bidaliGaiaId(id) {
    console.log("hooalla");
    stompClient.send("/ws/gaiak", {}, id);
}
