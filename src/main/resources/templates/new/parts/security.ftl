<#assign known = Session.SPRING_SECURITY_CONTEXT??>

<#if known>
  <#assign
    user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    name = user.getUsername()
    buttonName = "Sign out"
    buttonActionPath = "/logout"
    headersName = "Login page"
  >
<#else>
  <#assign
    name = "Unknown"
    buttonName = "Sign in"
    buttonActionPath = "new/login"
    headersName = "Login page"
  >
</#if>