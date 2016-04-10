<%-- 
    Document   : intro
    Created on : Mar 6, 2016, 8:38:05 PM
    Author     : Mélissa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Full Page Image Header Area -->
<div id="top" class="header">
    <div class="vert-text">
        <h1>Administration Troc Students.</h1>
        <h3>Console d'administration, réalisée par les créateurs Michel et Mélissa,<em>Try it!</em></h3>
        <a href="#about" class="btn btn-default btn-lg"> Connectez-vous </a>
    </div>
</div>

<!-- Intro -->
<div id="about" class="intro">
    <div class="container">
        <div class="row">
            <c:if test="${sessionScope.idUser==null}">
                <h1>Connexion</h1>
            </c:if>
        </div>
    </div>
</div>
<!-- /Intro -->

<!-- Callout -->
<div class="callout">
    <div class="vert-text">

        <%-- l'utilisateur ne s'est pas encore connecter alors son idUser n'existe pas dans la session
             Il n'aura que le message connexion, deconnexion dans le cas contraire  pageContext.request.contextPath
        --%>


        <form action="${pageContext.servletContext.contextPath}/ServletConnectionAdmin" method="get" id="formConnexion"><!-- mettre la méthode à post-->
            <ul>
                <%-- l'utilisateur ne s'est pas encore connecter alors son idUser n'existe pas dans la session
                 Il n'aura que les champs login, et mot de passe login:tp2 et password:tp2 coder à cause de la strategie de 
                  glassfish drop and create qui supprime tout à chaque déploiement en recréer.
                --%>
                <c:if test="${sessionScope.idUser==null}">                   
                    <input type="text" class="css-input1" name="login" required id="login" value="" placeholder="login"/>
                    <input type="password" class="css-input1" name="password" required id="password" value="" placeholder="mot de passe"/>                   
                </c:if>
                <%-- l'utilisateur ne s'est pas encore connecter alors son idUser n'existe pas dans la session
                    Il n'aura que le bouton connexion,  deconnexion dans le cas contraire, connexion avec un message de bienvenue
                --%>
                <c:if test="${sessionScope.idUser==null}">
                    <input class="css-input2" type="submit" value="Connexion" name="submit"/>
                    <input type="hidden" name="action" value="con"/>
                </c:if>
                <%-- Paramètre de connexion incorrectes juste un petit message d'erreur
                --%>
                <span id="messageConnection">
                    ${param['messageConnexion']}
                </span> 
            </ul>

        </form>

    </div>
</div>
<!-- /Callout -->

<!-- Footer -->
<footer>
    <div class="container">
        <div class=" ">
            <div class="col-md-6 col-md-offset-3 text-center">
                <ul class="list-inline">
                    <li><i class="fa fa-facebook fa-3x"></i>
                    </li>
                    <li><i class="fa fa-twitter fa-3x"></i>
                    </li>
                    <li><i class="fa fa-dribbble fa-3x"></i>
                    </li>
                </ul>

                <p>- Copyright &copy; ManageUser 2016, Begyn Mélissa et Mvouma Michel -</p>

            </div>
        </div>
    </div>
</footer>
<!-- /Footer -->

<!-- JavaScript -->
<script src="${pageContext.servletContext.contextPath}/resources/jquery-1.10.2.js"></script>
<script src="${pageContext.servletContext.contextPath}/resources/bootstrap.js"></script>

<!-- Custom JavaScript for the Side Menu and Smooth Scrolling -->
<script>
    $("#menu-close").click(function (e) {
        e.preventDefault();
        $("#sidebar-wrapper").toggleClass("active");
    });
</script>
<script>
    $("#menu-toggle").click(function (e) {
        e.preventDefault();
        $("#sidebar-wrapper").toggleClass("active");
    });
</script>
<script>
    $(function () {
        $('a[href*=#]:not([href=#])').click(function () {
            if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') || location.hostname == this.hostname) {

                var target = $(this.hash);
                target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');
                if (target.length) {
                    $('html,body').animate({
                        scrollTop: target.offset().top
                    }, 1000);
                    return false;
                }
            }
        });
    });
</script>

