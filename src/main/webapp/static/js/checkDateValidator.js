$(function() {
    $('input[name="daterange"]').daterangepicker({
        minDate: new Date(),
        opens: 'left'
    }, function(start, end, label) {
        console.log("A new date selection was made: " + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD'));
    });
});

$(document).ready(function () {

    $(".checkk").click(function() {

        var id = parseInt(this.id.match(/\d+/));

        if(id == 1) {
            $('#class1').prop("checked", true);
            $('#class2').prop('checked', false);
            $('#class3').prop('checked', false);
        }else if (id == 2){
            $('#class3').prop('checked',false);
            $('#class2').prop('checked',true);
            $('#class1').prop('checked',false);
        }else if (id == 3){
            $('#class1').prop('checked',false);
            $('#class2').prop('checked',false);
            $('#class3').prop('checked',true);
        }
    });

    $('#submit').click(function () {
        var check = true;

        var sY = parseInt($('#sYear').val());
        var sM = parseInt($('#sMonth').val());
        var sD = parseInt($('#sDay').val());
        var eY = parseInt($('#eYear').val());
        var eM = parseInt($('#eMonth').val());
        var eD = parseInt($('#eDay').val());

        // if (!(sY >= 2018 && sY <= 2020)) {
        //     check = false;
        //     $('#sYear').css("border-color", "#FF0000");
        // } else {
        //     $('#sYear').css("border-color", "#0aff07");
        // }
        //
        // if (!( sM >= 1 && sM <= 12)) {
        //     check = false;
        //     $('#sMonth').css("border-color", "#FF0000");
        // } else {
        //     $('#sMonth').css("border-color", "#0aff07");
        // }
        //
        // if (!(sD >= 1 && sD <= 31)) {
        //     check = false;
        //     $('#sDay').css("border-color", "#FF0000");
        //
        // } else {
        //     $('#sDay').css("border-color", "#0aff07");
        // }
        //
        //
        // if (!(eY >= 2018 && eY <= 2020)) {
        //     check = false;
        //     $('#eYear').css("border-color", "#FF0000");
        // } else {
        //     $('#eYear').css("border-color", "#0aff07");
        // }
        //
        //
        // if (!(eM >= 1 && eM <= 12)) {
        //     check = false;
        //     $('#eMonth').css("border-color", "#FF0000");
        //
        // } else {
        //     $('#eMonth').css("border-color", "#0aff07");
        // }
        //
        // if (!( eD >= 1 && eD <= 31)) {
        //     check = false;
        //     $('#eDay').css("border-color", "#FF0000");
        //
        // } else {
        //     $('#eDay').css("border-color", "#0aff07");
        // }

        var class0 = $('#class1').prop("checked");
        var class1 = $('#class2').prop("checked");
        var class2 = $('#class3').prop("checked");

        if ((!class0 && !class1 && !class2) || (class0 && class1 && class2) || (!class0 && class1 && class2) || (class0 && !class1 && class2)
            || (class0 && class1 && !class2)){
            check = false;
        }

        if (!check) {
            $('#error-data').show();

        }

        return check;
    })
});
