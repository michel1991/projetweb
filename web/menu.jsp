<%-- 
    Document   : menu
    Created on : Apr 1, 2016, 12:25:35 AM
    Author     : mel
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!-- ///// CONTENT SIDEBAR  ///// -->
<div class="header_top_area">
    <div class="container">
        <div class="row">
            <div class="col-md-6 col-sm-6 col-xs-12  ">
                <div class="header_top_cc_left  ">
                    <ul>
                        <li><a href="#"><i class="fa fa-phone"></i>Contact: +337 94 88 53 68</a></li>
                        <li><a href=""><img alt="" src="images/french.png"> Français</a>
                    </ul>
                </div>
            </div>
            <div class="col-md-6 col-sm-6 col-xs-12  ">
                <div class="header_top_cc_right  ">
                    <ul>
                        </li>
                        <li>
                            <c:if test="${sessionScope.idUserFrontEnd==null}">
                               <li class="active"><a href="${pageContext.servletContext.contextPath}/ControllerServletFrontEnd?action=accueil">Créer un compte</a></li> 
                            </c:if>
                        <!--creer-compte.jsp-->
                        <li><a href="">|</a></li> 
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <!-- si l'utilisateur vient de creer son compte ou s'est connecter -->
                                <c:choose>
                                    <c:when test="${sessionScope.idUserFrontEnd!=null}">
                                        <i class="fa fa-user"></i> Mon compte <b class="caret"></b>
                                    </c:when>
                                    <c:otherwise>
                                        Se connecter <b class="caret"></b>
                                    </c:otherwise>
                                </c:choose>
                            </a>
                            <ul class="dropdown-menu dropMn">
                                <li>
                                    <div class="row">
                                        <div class="col-md-12">
                                            <form class="form" role="form" method="post" action="ServletConnectionFE" accept-charset="UTF-8" id="login-nav">
                                                <c:choose>
                                                    <c:when test="${sessionScope.idUserFrontEnd==null}">
                                                        <div class="form-group">
                                                            <label class="sr-only" for="emailConnection">Adresse mail</label><!--exampleInputEmail2-->
                                                            <input type="email" value="${requestScope.emailEchecConnectionFE}" class="form-control" name="emailCFE" id="emailConnection" placeholder="Adresse mail" required>
                                                        </div>
                                                        <div class="form-group">
                                                            <label class="sr-only" for="mdpConnection">Mot de passe</label><!--exampleInputPassword2-->
                                                            <input type="password" name="mdpCFE" class="form-control" id="mdpConnection" placeholder="Mot de passe" required>
                                                        </div>
                                                        
                                                        <div class="checkbox"><!--cookies se souvenir de moi-->
                                                            <label>
                                                                <input type="checkbox" id="rememberMe" value="0" name="rememberCFE">Se souvenir de moi
                                                            </label>
                                                        </div>
                                                        
                                                        <!-- pour savoir s'il veut se connecter utiliser dans les controles au niveau de la servlet -->
                                                        <div class="form-group hidden">
                                                            <label class="sr-only" for="">Indicatif</label><!--exampleInputPassword2-->
                                                            <input type="hidden" class="form-control" name="indice" value="connect">
                                                        </div>
                                                        
                                                        <c:if test="${requestScope.messageEchecConnection!=null}">
                                                            <div class="form-group"><!-- message indicatif en cas de paramètre de connection incorrecte-->
                                                                <div class="alert alert-danger" role="alert">
                                                                    <a href="#" class="alert-link"> Param&egrave;tres incorrects</a>
                                                                </div>
                                                            </div>
                                                        </c:if>
                                                        
                                                        
                                                        <div class="form-group">
                                                            <button type="submit" class="btn btn-success btn-block">Se connecter</button>
                                                        </div>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <!-- pour savoir s'il veut se déconnecter utiliser dans les controles au niveau de la servlet -->
                                                        <div class="form-group hidden">
                                                            <label class="sr-only" for="">Indicatif</label><!--exampleInputPassword2-->
                                                            <input type="hidden" class="form-control" name="indice" value="deconnect">
                                                        </div>
                                                        
                                                        <div> <br/><div><i class="fa fa-user"></i> ${requestScope.annonce.utilisateur.login}</div><br/> </div>
                                                                                                                       
                                                        
                                                        <div class="form-group ">
                                                            <button type="submit" class="btn btn-success btn-block">Se D&eacute;connecter</button>
                                                        </div>
                                                    </c:otherwise>
                                                </c:choose>
                                                
                                                
                                                
                                            </form>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </li>			      
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- ///// CONTENT MENU  ///// -->
<div class="header_middle_area">
    <div class="container">
        <div class="row">
            <div class="col-md-388 col-sm-2 col-xs-12">
                <div class="header_logo">
                    <a href="index.jsp"><img src="images/logo.png" alt="logo" id="img_logo"/></a>
                </div>
            </div>
            <div class="col-md-788 col-sm-8 col-xs-12">
                <div class="header_middle_right">
                    <nav class="mainmenu">
                        <ul>
                            <li><a href="index.jsp">Accueil</a></li>
                            <c:if test="${sessionScope.idUserFrontEnd!=null}">
                                    <li><a href="ControllerCentralDepotAnnoceFE">Déposer une annonce</a></li>
                            </c:if>
                            <!--<li><a href="deposer-annonce.jsp">Déposer une annonce</a></li>-->
                            <li><a href="ControllerCentralAnnonce?action=Offres">Offres</a></li><!--offres.jsp NB Laissr le lien ainsi utilisation Offres pour la requete-->
                            <!--<li><a href="demandes.jsp">Demandes</a></li>-->
                            
                            <li><a href="ControllerCentralAnnonce?action=Recherches">Demandes</a></li><!-- NB:pareil que pour Offres -->
                            
                            <c:if test="${sessionScope.idUserFrontEnd!=null}">
                                <li><a href="ControllerCentralMesAnnonces?action=MesAnnonces">Mes annonces</a></li><!--mes-annonces.jsp--> 
                            </c:if>
                           
                            <li><a href="contact.jsp">Contact</a></li>
                        </ul>
                    </nav>
                </div>
            </div>
         
        </div>
    </div>
</div>

<!-- ///// CONTENT MENU MOBILE  ///// -->
<div class="cc_mobile_navigation">
    <div class="container">
        <div class="row">
            <div class="col-xs-12">
                <div class="only-for-mobile">
                    <div class="col-xs-12">
                        <ul class="ofm">
                            <li class="m_nav"><i class="fa fa-bars"></i> Navigation</li>
                        </ul>
                        <!-- MOBILE MENU -->
                        <div class="mobi-menu">
                            <div id='cssmenu'>
                                <ul>
                                    <li class='has-sub'>
                                        <a href='index.html'><span>Accueil</span></a>
                                    </li>
                                    
                                    <c:if test="${sessionScope.idUserFrontEnd!=null}">
                                       <li>
                                            <a href='#'><span>Déposer une annonce</span></a>
                                        </li>
                                    </c:if>
                                    
                                    <li>
                                        <a href='#'><span>Offres</span></a>
                                    </li>
                                    <li>
                                        <a href='#'><span>Demandes</span></a>
                                    </li>
                                    <li>
                                        <a href='#'><span>Mes annonces</span></a>
                                    </li>
                                    <li>
                                        <a href='#'><span>Boutiques</span></a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
