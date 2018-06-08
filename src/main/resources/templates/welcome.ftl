<!DOCTYPE html>
<html lang="en">
<head>
    <script type="text/javascript"
            src="webjars/jquery/2.2.4/jquery.min.js"></script>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div id="feedback"></div>

<form id="search-form">
    <div>
        <label>Username</label>
        <div>
            <input type="text" id="username"/>
        </div>
    </div>

    <div >
        <div>
            <button type="submit" id="bth-search">Search</button>
        </div>
    </div>
</form>

<script type="text/javascript">
    <#include "new/script/ajax.js" />
</script>
</body>
</html>