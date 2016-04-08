<%-- 
    Document   : template
    Created on : 01 avril 2016, 00:17:17
    Author     : Michel Mvouma and Mélissa Begyn 
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="head.jsp"/> 
    </head>

    <body>  
        <jsp:include page="menu.jsp"/>


        <jsp:include page="page-accueil.jsp"/> 

        <footer>
            <jsp:include page="footer.jsp"/> 
        </footer>

        <jsp:include page="links-js.jsp"/> 
        
        <!-- a styler -->
        <c:if test="${requestScope.messageResultatAction!=null}">
                                    
        </c:if>
          
        <!-- /.modal -->
        <%--<script src="${pageContext.servletContext.contextPath}/resources/jquery-1.10.2.js" type="text/javascript"></script>
        <script src="${pageContext.servletContext.contextPath}/resources/js/bootstrap3.js"></script>--%>
        <script src="${pageContext.servletContext.contextPath}/resources/js/connectionUtilisateurFE.js" type="text/javascript"></script>
        <script src="${pageContext.servletContext.contextPath}/resources/js/pourLaPageIndex.js" type="text/javascript"></script>
    </body>
    
</html>

