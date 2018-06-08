function f(list, text)
{
    var selind = document.getElementById(list).options.selectedIndex;
    var txt= document.getElementById(list).options[selind].text;

    var input = document.getElementById(text);
    input.value = txt;

    var event = new Event("change");
    input.dispatchEvent(event);
}