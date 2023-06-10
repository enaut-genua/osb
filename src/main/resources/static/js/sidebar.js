var x = window.matchMedia("(max-width: 700px)")

$(document).ready(function () {
    $('#sidebarCollapse').on('click', function () {
        $('#sidebar').toggleClass('active');
    });
});


/* Set the width of the side navigation to 250px */
function openNav() {
    if (x.matches) { // If media query matches
        document.getElementById("mySidenav").style.width = "40%";
    } else {
        document.getElementById("mySidenav").style.width = "12%";
    }
}

/* Set the width of the side navigation to 0 */
function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
}
function myFunction(x) {
    if (x.matches) { // If media query matches
        document.body.style.backgroundColor = "yellow";
    } else {
        document.body.style.backgroundColor = "pink";
    }
}
