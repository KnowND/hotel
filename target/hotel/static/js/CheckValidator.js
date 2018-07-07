$(document).ready(function () {
    $("#phoneField").CcPicker();

    // $("#phoneField").CcPicker({
    //
    //     "countryCode":"ua",
    //     dataUrl: "data.json"
    //
    //
    // });
//     $("#phoneField").CcPicker("setCountryByCode","ua");
//
//     $("#phoneField").CcPicker({
//
//
// });

    $('#submit').click(function () {
        var name = $('#name').val().length;
        var surname = $('#surname').val().length;
        var phone = $('#phone').val();
        var passport = $('#passport').val().length;
        var room = $('#room').val();
        var cost = $('#cost').val();

        var code = $('#code').val;
        console.log(code);
        var check = true;

        // var phone_pattern = /\(?([0-9]{3})\)?([ .-]?)([0-9]{3})\2([0-9]{4})/;

        //
        // if (code == "+38") {
        //
        // }

        var phoneNum = phone.match(/\d+/);

        if (phoneNum == null || phoneNum[0].length != 10) {
            check = false;
            $('#phone').css("border-color", "#FF0000");

        } else {
            $('#phone').css("border-color", "#0aff07");
        }


        if (name == 0) {
            check = false;
            $('#name').css("border-color", "#FF0000");
        } else {
            $('#name').css("border-color", "#0aff07");
        }

        if (surname == 0) {
            check = false;
            $('#surname').css("border-color", "#FF0000");
        } else {
            $('#surname').css("border-color", "#0aff07");
        }

        // if (!phone_pattern.test(phone)){
        //     check = false;
        //     $('#phone').css("border-color", "#FF0000");
        // } else {
        //     $('#phone').css("border-color", "#0aff07");
        // }

        if (cost.length == 0) {
            check = false;
            $('#cost').css("border-color", "#FF0000");
        } else {
            $('#cost').css("border-color", "#0aff07");
        }


        if (passport == 0) {
            check = false;
            $('#passport').css("border-color", "#FF0000");
        } else {
            $('#passport').css("border-color", "#0aff07");
        }

        return check;


    })
});