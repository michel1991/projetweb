<%-- 
    Document   : menuGauche
    Created on : 4 mars 2016, 10:41:49
    Author     : michel Mvouma and Melissa Begyn 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%-- Comme son nom l'indique il s'agit du menu gauche --%>
<section id="menuGauche">

    <div id="wrapper">

        <!-- Sidebar -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">Manager User</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                    <li class="active"><a href="#"><i class="fa fa-dashboard"></i> Tableau de bord</a></li>
                    <li><a href="${pageContext.servletContext.contextPath}/ControllerCentralRegion?action=accueil"><i class="fa fa-bar-chart-o"></i> R&eacute;gion</a></li>
                    <li><a href="${pageContext.servletContext.contextPath}/ControllerCentralTypeCategorie?action=accueil"><i class="fa fa-table"></i> Type cat&eacute;gorie</a></li>
                    <li><a href="${pageContext.servletContext.contextPath}/ControllerCentralCategorie?action=accueil"><i class="fa fa-table"></i> Cat&eacute;gorie</a></li>
                    <li><a href="${pageContext.servletContext.contextPath}/ControllerCentralTypeAnnonce?action=accueil"><i class="fa fa-table"></i> Type Annonce</a></li>
                    <li><a href="${pageContext.servletContext.contextPath}/ControllerCentralEcole?action=accueil"><i class="fa fa-edit"></i> Ecole</a></li>
                    <li><a href="${pageContext.servletContext.contextPath}/ControllerUtilisateur?action=accueil"><i class="fa fa-users"></i> Utilisateur</a></li>
                    <li><a href="ServletUsers?action=listerLesUtilisateurs&flatM=SU"><i class="fa fa-times"></i> Supprimer un utilisateur</a></li>
                </ul>

                <ul class="nav navbar-nav navbar-right navbar-user">  
                    <li class="dropdown alerts-dropdown">
                        <form action="ServletConnexion" method="get" id="formConnexion"><!-- mettre la méthode à post-->
                            <%-- l'utilisateur ne s'est pas encore connecter alors son idUser n'existe pas dans la session
                                Il n'aura que le bouton connexion,  deconnexion dans le cas contraire, connexion avec un message de bienvenue
                            --%>
                            <c:if test="${sessionScope.idUser!=null}">
                                <p class="msgb">${sessionScope.messageConnexion}!</p>
                                <input class="btn13 msgb-input" type="submit" value="D&eacute;connexion" name="submit"/> 
                                <input type="hidden" name="action" value="decon"/>
                            </c:if>             
                        </form>
                    </li>
                </ul>
            </div><!-- /.navbar-collapse -->
        </nav>

        <!-- Permet d'afficher la page d'accueil de l'administrateur + les differents msgs -->

        <div class="row">
            <div class="col-lg-12">
                <h1>Tableau de bord <small>Accueil</small></h1>
                <%-- Dans le nav on affiche juste l'action de l'utilisateur c'est pour cela que nous avons mis informationSurAction
                     Cela provient de la requete Pour la première l'utilisateur n'a rien choisir alors il a juste un message de bienvenue
                --%>
                <nav id="actionMsm">
                    <c:choose>
                        <c:when test="${requestScope.informationSurAction==null}"><%-- BIEN JOUER MEL POUR CE MESSAGE --%>
                            <jsp:include page="nav.jsp"/> 
                        </c:when>
                        <c:otherwise>
                            <ol class="breadcrumb">
                                <li class="active"><i class="fa fa-dashboard"></i> ${requestScope.informationSurAction}</li><%-- ${requestScope.totalElement}--%>
                            </ol>
                        </c:otherwise>
                    </c:choose>
                </nav>
            </div>
        </div><!-- /.row -->


        <p id="statusAction">

            <%-- 
                Ici l'utilisateur a juste un message pour lui informer que son action s'est bien deroulé
              par exemple s'il veut la liste la liste des utilisateurs et qu'il n'ya aucun utilisateur alors il aura aucun utilisateur
            --%>
        <div class="text-center msgConfirm"> ${requestScope.statusAction} </div>

        </p>

        <%-- 
           On va laisser un trou à ce niveau pour inserer le contenu de toutes nos pages
        --%>
        <c:import context="${pageContext.servletContext.contextPath}" url="/${param['url']}">
            
        </c:import>
        

    </div>    
</div>
</div>

</section>
