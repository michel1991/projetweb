<%-- 
    Document   : learnCss
    Created on : 4 mars 2016, 20:36:52
    Author     : michel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/style.css" />
    </head>
    <body>
       <header>
            <h1>Gestionnaire d'utilisateurs</h1>
        </header>
        
        <section id="menuGauche">
            <ul>
                <li><a href="">Afficher les d&eacute;tails d'un utilisateur</a></li>
                <li><a href="ServletUsers?action=listerLesUtilisateurs">Afficher tous les utilisateurs</a></li>
                <li><a href="">Cr&eacute;er un utilisateur</a></li>
                <li><a href="ServletUsers?action=creerUtilisateursDeTest">Créer quatre utilisateurs de test</a></li>
                <li><a href="">Modifier les d&eacute; d'un utilisateur</a></li>
            </ul>
        </section>
        
        <section id="menuDroit">
            <header>
                Menu droit
            </header>
        </section>
        
        <footer> creer par michel et melissa</footer>
    </body>
</html>
