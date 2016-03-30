<%-- 
    Document   : accueilTypeAnnonce
    Created on : 27 mars 2016, 23:58:20
    Author     : michel
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrateur</title>
    </head>
    <body>
       <c:import context="${pageContext.servletContext.contextPath}" url="/admin/index.jsp">
         <c:param name="url" value="admin/annonce/contenuTypeAnnonce.jsp"/>
        </c:import>
    </body>
</html>
