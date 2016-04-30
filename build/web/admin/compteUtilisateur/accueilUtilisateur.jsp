<%-- 
    Document   : accueilUtilisateur
    Created on : 31 mars 2016, 17:49:05
    Author     : michel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin</title>
    </head>
    <body>
       <c:import context="${pageContext.servletContext.contextPath}" url="/admin/index.jsp">
         <c:param name="url" value="admin/compteUtilisateur/contenuUtilisateur.jsp"/>
         <c:param name="ecoles" value="${requestScope['ecolesM']}"/>
        </c:import>
    </body>
</html>
