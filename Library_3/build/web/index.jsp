<%-- 
    Document   : Library_1
    Created on : Dec 24, 2017, 9:05:34 AM
    Author     : diskj
--%>
<%@page import ="testjdbc.TestConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>
        
        <img src="images/logo.png" width="300px" height="200px">
        
        <div>
            Добро пожаловать в библиотеку<br>
            Введите Ваше имя для входа
        </div>
        
        <form name="form" method="POST" action="pages/main.jsp">
            <input id="text" type="text" name="username">
            <p>
                <input id="button" type="submit" value="Войти" name="confirm" />
            </p>
        </form>
    </body>
</html>
