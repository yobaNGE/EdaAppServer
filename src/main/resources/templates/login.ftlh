<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Spring Security Example</title>
</head>
<body>
<form action="/login" method="post">
    User Name: <input type="email" name="username"/>
    Password: <input type="password" name="password"/>
<#--    <input type="hidden" name="_csrf" value="${_csrf.token}"/>-->
    <input type="submit" value="Sign In"/>
</form>
</body>
</html>
