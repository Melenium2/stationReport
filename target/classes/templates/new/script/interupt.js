function interupt()
{
    var pressureInput = document.getElementById('pressure');
    var temperatureInput = document.getElementById('temperature');
    var directionInput = document.getElementById('directionResult');
    var meteoIdInput = document.getElementById('meteoInfo');

    var button = document.getElementById('buttonGo');
    if  (!pressureInput.value.trim() || !temperatureInput.value.trim() || !directionInput.value.trim() || !meteoIdInput.value.trim())
    {
        button.disabled = true;
    }
    else
    {
        button.disabled = false;
    }
}