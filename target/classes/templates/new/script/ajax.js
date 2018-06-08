$(document).ready(function () {

    $("#inputForm").submit(function (event) {

        event.preventDefault();
        fire_ajax_submit();
    });
});

function fire_ajax_submit()
{
    var prop = {};

    prop[$("#msName").attr("id")] = $("#msName").is(':checked');
    prop[$("#msPressure").attr("id")] = $("#msPressure").is(':checked');
    prop[$("#msTemp").attr("id")] = $("#msTemp").is(':checked');
    prop[$("#msDirection").attr("id")] = $("#msDirection").is(':checked');

    $("#buttonSubmit").prop("disabled", true);
    
    $.ajaxSetup({
       headers:{'X-CSRF-TOKEN': $('meta[name="csrf-token"]').attr('content')}
    });

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/getTableProperty",
        data: JSON.stringify(prop),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {

            var obj = JSON.stringify(data);
            obj = JSON.parse(obj);

            var table = "<table><tr>";
            var columsName = "default";
            var sideTable;

               $.each(obj["result"], function (key, value)
               {
                   sideTable = "";
                   switch (key)
                   {
                       case '1': columsName = "Meteostation name";  break;
                       case '2': columsName = "Pressure";           break;
                       case '3': columsName = "Temperature";        break;
                       case '4': columsName = "Wind direction";     break;
                   }
                   sideTable += "<td><table><tr><td>"+ columsName +"</td></tr>";
                  $.each(value, function (arrKey, arrValue)
                  {
                      sideTable += "<tr><td>"+ arrValue.toString() +"</td></tr>";
                  });
                  sideTable += "</table></td>";
                  table += sideTable;
               });

            table += "</tr></table>";
            $('#reportTable').html(table);

            console.log("SUCCESS : ", data);
            $("#buttonSubmit").prop("disabled", false);
        },
        error: function (e) {

            var json = "<h4>Ajax Response</h4><pre>"
                + e.responseText + "</pre>";
            $('#reportTitle').html(json);

            console.log("ERROR : ", e);
            $("#buttonSubmit").prop("disabled", false);

        }
    });


}
