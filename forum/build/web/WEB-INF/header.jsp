<%-- 
    Document   : header
    Created on : 22 nov. 2018, 11:11:20
    Author     : Stagiaire
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html style="height: 100%;">
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
         <!-- Latest compiled and minified CSS -->
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
              <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">

            <!-- jQuery library -->
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

            <!-- Popper JS -->
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>

            <!-- Latest compiled JavaScript -->
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script> 
    </head>
    
    <!-- si l'utilisateur est sur l'index on choisira un arriere plan avec image sinon non -->
    <body style="<c:choose>
          <c:when test="${index != null}">
          background-image: url('inc/soldiers.jpg');</c:when>
          <c:otherwise>
              
              color:#333228;
          </c:otherwise>
                 </c:choose>
              background-repeat: no-repeat; background-size: cover; height:100%;">
        <nav  class="navbar navbar-expand-sm" style="background-color:#333228;">
                     <ul class="navbar-nav">
                            <li class="nav-item active" style="padding:1em; font-family: fantasy; font-size: 1.5em;">
                              <a class="nav-link" href="./" style="color: #C0BB95;">INDEX</a>
                            </li>
                            <!-- si l'utilisateur n'est pas connecte alors on affiche le menu consacré -->
                            <c:if test="${sessionScope.user == null}">
                        
                            <li class="nav-item" style="padding:1em; font-family: fantasy; font-size: 1.5em;">
                              <a class="nav-link" href="connexion" style="color: #C0BB95;">connexion</a>
                            </li>
                            <li class="nav-item" style="padding:1em; font-family: fantasy; font-size: 1.5em;">
                              <a class="nav-link" href="inscription" style="color: #C0BB95;">inscription</a>
                            </li>
                            </c:if>
                            <!-- si l'utilisateur n'est pas connecté on affiche le menu dédié -->
                            <c:if test="${sessionScope.user != null}">
                                 <li class="nav-item" style="padding:1em; font-family: fantasy; font-size: 1.5em;">
                              <a class="nav-link" href="menu" style="color: #C0BB95;">menu</a>
                            </li>
                              <li class="nav-item" style="padding:1em; font-family: fantasy; font-size: 1.5em;">
                              <a class="nav-link" href="moncompte" style="color: #C0BB95;">mon compte</a>
                            </li>
                                 <li class="nav-item" style="padding:1em; font-family: fantasy; font-size: 1.5em;">
                              <a class="nav-link" href="deconnexion" style="color: #C0BB95;">deconnexion</a>
                            </li>
                            </c:if>
                          </ul>
        </nav>