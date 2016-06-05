$(document).ready(function () {
    $('.modal-trigger').leanModal();
    $('.datepicker').pickadate({
        selectMonths: true, // Creates a dropdown to control month
        selectYears: 15 // Creates a dropdown of 15 years to control year
    });
    $('select').material_select();
    $(".button-collapse").sideNav();
    $('input[type=radio]').click(function () {
        var checkval = $(this).val();
        var regreso = document.getElementById('fecharegreso');
        var txtregreso = document.getElementById('textofecharegreso');
        if (checkval === '1') {
            regreso.style.display = 'none';
            txtregreso.style.display = 'none';
        } else {
            regreso.style.display = 'block';
            txtregreso.style.display = 'block';
        }
    });
});