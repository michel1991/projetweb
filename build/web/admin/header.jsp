<%-- 
    Document   : header
    Created on : 4 mars 2016, 10:17:56
    Author     : michel Mvouma and Melissa Begyn 
   On aura pu faire mieux partout le code reste à ameliorer mais fallait un code fontionnel
      
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header>
    <!--<h3 id="infosApplication">Gestionnaire d'utilisateurs</h3>-->
    <!--<article id="articleConnexion">
        
    </article>-->

    <%-- details  utiliser pour la connexion de l'utilisateur   --%>
    <details id="articleConnexion">
        <summary>

            <%-- l'utilisateur ne s'est pas encore connecter alors son idUser n'existe pas dans la session
                 Il n'aura que le message connexion, deconnexion dans le cas contraire
            --%>
           <c:if test="${sessionScope.idUser==null}">
                Connexion 
            </c:if>

            <c:if test="${sessionScope.idUser!=null}">
                d&eacute;connexion 
            </c:if>

        </summary>
        <form action="ServletConnexion" method="get" id="formConnexion"><!-- mettre la méthode à post-->
            <ul>

                <%-- l'utilisateur ne s'est pas encore connecter alors son idUser n'existe pas dans la session
                 Il n'aura que les champs login, et mot de passe login:tp2 et password:tp2 coder à cause de la strategie de 
                  glassfish drop and create qui supprime tout à chaque déploiement en recréer.
                --%>
                <c:if test="${sessionScope.idUser==null}">
                    <li>
                        <input type="text" name="login" required id="login" value="" placeholder="login"/>
                    </li>
                    <li>
                        <input type="password" name="password" required id="password" value="" placeholder="mot de passe"/>
                    </li> 
                </c:if>

                <li>

                    <%-- l'utilisateur ne s'est pas encore connecter alors son idUser n'existe pas dans la session
                        Il n'aura que le bouton connexion,  deconnexion dans le cas contraire, connexion avec un message de bienvenue
                    --%>
                    <c:if test="${sessionScope.idUser==null}">
                        <input type="submit" value="Connexion" name="submit"/>
                        <input type="hidden" name="action" value="con"/>
                    </c:if>

                    <c:if test="${sessionScope.idUser!=null}">
                        <span>${sessionScope.messageConnexion}</span>
                        <input type="submit" value="D&eacute;connexion" name="submit"/> 
                        <input type="hidden" name="action" value="decon"/>
                    </c:if>

                </li>

                <%-- Paramètre de connexion incorrectes juste un petit message d'erreur
                --%>
                <li>
                    <span id="messageConnection">
                        ${param['messageConnexion']}
                    </span> 
                </li>


            </ul>
        </form>
    </details>
</header>
