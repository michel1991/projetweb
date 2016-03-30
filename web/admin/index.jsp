<%-- 
    Document   : template
    Created on : 4 mars 2016, 10:17:17
    Author     : Michel Mvouma and Mélissa Begyn 
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LPAE Admin</title>
        <link rel="stylesheet" type="text/css"
	href="${pageContext.servletContext.contextPath}/resources/style.css" />
        <link rel="stylesheet" type="text/css"
	href="${pageContext.servletContext.contextPath}/resources/bootstrap.css" />
        
        <link rel="stylesheet" type="text/css"
	href="${pageContext.servletContext.contextPath}/resources/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css"
	href="${pageContext.servletContext.contextPath}/resources/stylish-portfolio.css" />
        <link rel="stylesheet" type="text/css"
	href="${pageContext.servletContext.contextPath}/resources/sb-admin.css" />
        <link rel="stylesheet" type="text/css"
	href="${pageContext.servletContext.contextPath}/resources/font-awesome/css/font-awesome.min.css" />
       <%-- <link href="${pageContext.servletContext.contextPath}/resources/css/dataTables.bootstrap4.min.css" rel="stylesheet" type="text/css"/>--%>
       
        <%-- <link href="${pageContext.servletContext.contextPath}/resources/css/dataTables.bootstrap4.min.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.servletContext.contextPath}/resources/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css"/>--%>
        <link href="${pageContext.servletContext.contextPath}/resources/css/dataTables.bootstrap.min.css" rel="stylesheet" type="text/css"/>
        
        <style>
            table.dataTable.select tbody tr,
            table.dataTable thead th:first-child {
              cursor: pointer;
            }
            
            .container {padding:20px;}
            .form-control {width:120px;}
            .popover {max-width:400px;}
        </style>
        
    </head>
    
    
     <c:choose>
        <c:when test="${sessionScope.idUser!=null}">
            <body>  
                  <jsp:include page="menuGauche.jsp"/> 
            </body>
        </c:when>
        <c:otherwise>
            <jsp:include page="intro.jsp"/>
        </c:otherwise>
    </c:choose>
 <script src="${pageContext.servletContext.contextPath}/resources/jquery-1.10.2.js" type="text/javascript"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/bootstrap3.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/jquery.dataTables.min.js" type="text/javascript"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/dataTables.bootstrap.min.js" type="text/javascript"></script>
<script>
    //var path = 'http://localhost:8080/LPAE';//context de l'application
    var path = '${pageContext.servletContext.contextPath}';//context de l'application
</script>
</html>
