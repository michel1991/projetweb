<%-- 
    Document   : CreerUtilisateur
    Created on : 4 mars 2016, 22:54:12
    Author     : michel Mvouma and Melissa Begyn 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="text-center">
<form action="ServletUsers" method="get"><!-- mettre la méthode à post-->
 
            <label for="nom">Nom:  </label> <input type="text" class="css-input1" name="nom"  value="${requestScope.util.lastname}" required id="nom"/>
 
            <label for="prenom">Pr&eacute;nom: </label> <input type="text" class="css-input1" name="prenom" required id="prenom" value="${requestScope.util.firstname}"/>
 
            <label for="login">Login : </label> <input type="text" class="css-input1" name="login" required id="login" value="${requestScope.util.login}"/>
 
            <input type="hidden" name="action" value="${requestScope.action}"/>
 
            <label for="${requestScope.util.id}" class="cache">*</label> <input type="hidden" name="idUser" value="${requestScope.util.id}" id="${requestScope.util.id}"/>
 
            <input type="submit" class="css-input2" value="${requestScope.bouton}" name="submit"/> 
 
</form>
</div>
