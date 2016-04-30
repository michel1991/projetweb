<%-- 
    Document   : accueilEcole
    Created on : 28 mars 2016, 04:44:15
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
         <c:param name="url" value="admin/ecole/contenuEcole.jsp"/>
        </c:import>
    </body>
</html>
