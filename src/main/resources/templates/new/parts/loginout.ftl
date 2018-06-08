<#macro loginout method, action, name>
    <form method="${method}" action="${action}">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit">${name}</button>
    </form>
</#macro>