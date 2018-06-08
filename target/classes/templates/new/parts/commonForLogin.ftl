<#macro page logOrReg, path>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Login</title>
  
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
</head>
<body class="text-center">
  <#nested>
  <form class="form-signin" method="post" action="${path}">
      <h2>${logOrReg}</h2>
      <input type="text" name="username" id="inputUsername" class="form-control mt-3" placeholder="Enter your username" required autofocus />
      <input type="password" name="password" id="inputPassword" class="form-control mt-2" placeholder="Enter your password" />
      <input type="hidden" name="_csrf" value="${_csrf.token}" />
      <#if logOrReg="Login page">
        <button type="submit" class="btn btn-primary btn-lg btn-block mt-3">Sign in</button>
        <a href="/registration" class="badge badge-light mt-2">Dont have account? Registration here</a>
      <#else>
        <button type="submit" class="btn btn-primary btn-lg btn-block mt-3">Registration</button>
        <a href="/login" class="badge badge-light mt-2">Already has account? Try to login</a>
        <span class="mt-2">${message?if_exists}</span>
      </#if>
  </form>
  
  
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
  </body>
</body>
</html>
</#macro>