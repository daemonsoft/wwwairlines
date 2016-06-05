<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!--Import Google Icon Font-->
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import materialize.css-->
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>

        <link type="text/css" rel="stylesheet" href="css/customize.css"  media="screen,projection"/>
        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <title>WWWAirlines</title>
    </head>
    <body>
        <div class="navbar-fixed">
            <nav>
                <div class="nav-wrapper blue-grey">
                    <a href="./" class="brand-logo">WWW Airlines</a>
                    <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="material-icons">menu</i></a>
                    <ul class="right hide-on-med-and-down">
                        <li><a href="LoginServlet">Ingresar</a></li>
                        <li><a href="RegisterServlet">Registrarse</a></li>
                        <li><a href="InvoiceServlet">Facturas</a></li>
                    </ul>
                    <ul class="side-nav" id="mobile-demo">
                        <li><a href="LoginServlet">Ingresar</a></li>
                        <li><a href="RegisterServlet">Registrarse</a></li>
                        <li><a href="InvoiceServlet">Facturas</a></li>
                    </ul>
                </div>
            </nav>
        </div>
        <main>
            <div class="container">
                <h4 class="center"><p>${message}</p></h4>