<!Doctype html>

<html>

<head>
    <asset:stylesheet src="login/index.css" />
</head>

<body>
    <g:form action="login" class="login-form">
        <g:if test="${flash.message}"><label>${flash.message}</label></g:if>
        <input type="email" name="email" />
        <g:submitButton name="submit" value="Login" />
    </g:form>
</body>

</html>