$(document).ready(function ()
{
    $("#buttonSaveReport").click(function ()
    {
        saveJsonToTable();
    });
});

function saveJsonToTable()
{
    var prop = {};

    prop["title"] = $("#reportTitle").text();
    prop["table"] = $("#reportTable").html();
    prop["autograph"] = $("#fioAutograph").text();

    $.ajax({
        type: 'POST',
        contentType: 'application/json',
        url: '/jsonToDb',
        data: JSON.stringify(prop),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data)
        {
            $.each(data, function (key, value)
            {
                alert(value);
            });
        },
        error: function (e)
        {
            console.log(e.responseText);
        }
    });
}