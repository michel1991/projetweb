<%-- 
    Document   : detailUtilisateur
    Created on : 5 mars 2016, 23:20:59
    Author     : michel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="text-center">
    <c:if test="${requestScope.nombre>0}">
        <form action="ServletUsers" method="get"><!-- mettre la méthode à post-->
                
                <label for="login">Login : </label> 
                <input type="text" class="css-input1" name="login" required id="login" value=""/> 

                <input type="hidden"  name="action" value="chercherParLogin"/>

                <input type="submit" class="css-input2" value="Rechercher" name="submit"/> 

        </form>
    </c:if>
</div>