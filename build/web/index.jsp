<%-- 
    Document   : template
    Created on : 01 avril 2016, 00:17:17
    Author     : mel
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
        
        <!-- ///// ESPACE BLANC DIV ///// -->
        <div class="classWhite"></div>
        
        <div id="locatorList" style="height:400px;"></div>
        

        <!-- ///// ESPACE BLANC DIV ///// -->
        <div class="classWhite"></div>
        
        <footer>
            <jsp:include page="footer.jsp"/> 
        </footer>

        <jsp:include page="links-js.jsp"/> 
        
        <!-- a styler -->
        <c:if test="${requestScope.messageResultatAction!=null}">
                                    
        </c:if>
        
        <script src="${pageContext.servletContext.contextPath}/resources/js/connectionUtilisateurFE.js" type="text/javascript"></script>
        <script src="${pageContext.servletContext.contextPath}/resources/js/pourLaPageIndex.js" type="text/javascript"></script>
        
        <%--<script src="${pageContext.servletContext.contextPath}/resources/js/easyLocator.js" type="text/javascript"></script>--%>
        <script src="${pageContext.servletContext.contextPath}/resources/js/localisationUser.js" type="text/javascript"></script>
    </body>
 

</html>
