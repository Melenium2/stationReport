$(document).ready(function ()
{
   $("#titleLabel").on('input', function ()
   {
       $("#reportTitle").html($("#titleLabel").val());
   });

    $("#autograph").on('input', function ()
    {
        $("#fioAutograph").html($("#autograph").val());
    });

    $("#autographCheck").change(function ()
    {
        if ($("#autographCheck").is(':checked'))
        {
            $("#autograph").prop('disabled', false);
            $("#autograph").prop('placeholder', "input your name");
            $("#reportAutograph").css('display', "block");
        }
        else
        {
            $("#autograph").prop('disabled', true);
            $("#autograph").val('');
            $("#fioAutograph").html('');
            $("#autograph").prop('placeholder', "disabled");
            $("#reportAutograph").css('display', "none");
        }
    });
});