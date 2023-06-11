var stompClient = null;

$(document).ready(function () {
    connect();
});

function connect() {
    console.log("triying");
    var socket = new SockJS('/ourws');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function () {
        console.log("connected");
        setInterval(refreshApunteak, 1000);
        refreshApunteak();
        stompClient.subscribe('/osb/apunteak', function (message) {
            // Manejar el mensaje recibido
            console.log(message.body);
            showMessage(message.body);
        });
    });

}

function showMessage(message) {
    var apunteLista = JSON.parse(message);

    var divElement = document.getElementById("dataContainer");

    while (divElement.firstChild) {
        divElement.removeChild(divElement.firstChild);
    }
    for (var i = 0; i < apunteLista.length; i++) {
        var id = apunteLista[i].id
    var izena = apunteLista[i].izena;
    var email = apunteLista[i].egileEmail;
    var puntuazioa = apunteLista[i].puntuazioa;
        gehituHtml = "<div class='col-md-3' ><div class='card' style='width: 18rem;'><div class='card-body'><h5 class='card-title'>"+izena+"</h5><span class='card-text'>"+email+"</span><hr><form action='/apunteak/"+id+"/deskargatu' method='get'><button type='submit' class='btn btn-primary'>Deskargatu</button></form><hr><div class='d-grid gap-2 d-md-flex'><form action='/apunteak/"+id+"' method='post'><input type='submit' name='bozka' value='+1'><span class='card-text'>"+puntuazioa+"</span><input type='submit' name='bozka' value='-1'></form></div></div></div></div>";
        $("#dataContainer").append(gehituHtml);
    }
}
function refreshApunteak() {
    console.log("hooalla");
    stompClient.send("/ws/apunteak", {});
}
