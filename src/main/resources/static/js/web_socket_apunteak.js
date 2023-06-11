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
        gehituHtml = "<div class='col-md-3' ><div class='card' style='width: 18rem; background-color: rgb(43, 43, 43); margin-top: 30px; align-items: center;'><div class='card-body'><h5 class='card-title' style='color: whitesmoke;'>"+izena+"</h5><span class='card-text' style='color: whitesmoke;'>"+email+"</span><hr><form action='/apunteak/"+id+"/deskargatu' method='get'><button type='submit' class='btn btn-primary'>Deskargatu</button></form><hr><div class='d-grid gap-2 d-md-flex'><form action='/apunteak/"+id+"' method='post'><button type='submit' name='bozka' value='+1' style='background-color: rgb(43, 43, 43);'><svg xmlns='http://www.w3.org/2000/svg' width='24' height='24' fill='currentColor' style='color: whitesmoke;'class='bi bi-arrow-up-square-fill' viewBox='0 0 16 16'><path d='M2 16a2 2 0 0 1-2-2V2a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H2zm6.5-4.5V5.707l2.146 2.147a.5.5 0 0 0 .708-.708l-3-3a.5.5 0 0 0-.708 0l-3 3a.5.5 0 1 0 .708.708L7.5 5.707V11.5a.5.5 0 0 0 1 0z'/></svg></button><span class='card-text'style='color: whitesmoke;'> "+puntuazioa+" </span><button type='submit' name='bozka' value='+1' style='background-color: rgb(43, 43, 43);'><svg xmlns='http://www.w3.org/2000/svg' width='24' height='24' fill='currentColor' style='color: whitesmoke;'class='bi bi-arrow-down-square-fill' viewBox='0 0 16 16'><path d='M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm6.5 4.5v5.793l2.146-2.147a.5.5 0 0 1 .708.708l-3 3a.5.5 0 0 1-.708 0l-3-3a.5.5 0 1 1 .708-.708L7.5 10.293V4.5a.5.5 0 0 1 1 0z' /></svg></button></form></div></div></div></div>";
        $("#dataContainer").append(gehituHtml);
    }
}
function refreshApunteak() {
    console.log("hooalla");
    stompClient.send("/ws/apunteak", {});
}
