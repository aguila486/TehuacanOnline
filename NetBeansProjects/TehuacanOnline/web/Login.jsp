<%-- 
    Document   : Login
    Created on : 24/05/2015, 04:54:06 PM
    Author     : aguila86
--%>

<!DOCTYPE html>
<%@page import="com.tehuacanonline.paginas.Settings"%>
<%@page import="com.tehuacanonline.paginas.LoginPage"%>
<%@page import="Elementos.ElementoHtml"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <%
            Settings setting = new Settings(request,  out);
            LoginPage pageMain = new LoginPage(setting);
            pageMain.renderPage();
        %>
    
