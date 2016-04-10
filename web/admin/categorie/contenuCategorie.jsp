<%-- 
    Document   : contenuCategorie
    Created on : 25 mars 2016, 21:02:04
    Author     : michel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div class="cssManAdmin">
<div class="">
    <div class="row">
       
        <div class="col-md-12">
            <div class="">
                <form role="form"  onsubmit="return addCategorie();" id="formCategorie"><!-- mettre la méthode à post return  addTypeCategorie();-->

                    <label for="nom" class="css-input01"> Libell&eacute;:  </label> <input type="text" class="css-input1" name="libelle"  value="" required id="libelle"/><br/>

                    <label for="prenom" class="css-input01"> Type cat&eacute;gorie: </label> 
                    <!--<input type="text" class="css-input1" name="typeCategorie" required id="typeCategorie" value=""/>-->
                    <c:set var="totalTypeCategorie" value="0"/>
                    <select name="typeCategorie" required id="typeCategorie" class="">
                        <option value="">
                            Aucune
                        </option>
                        <c:forEach var="tcA" items="${requestScope['tc']}">
                            <option value="${tcA.id}">
                                ${tcA.nomTyp}
                            </option>
                            <c:set var="totalTypeCategorie" value="${totalTypeCategorie+1}"/>
                        </c:forEach>
                           <%--  <c:if test="${totalTypeCategorie==0}">
                                <option value="">
                                  Aucune
                               </option>
                            </c:if>--%>
                    </select>
                    <input type="hidden" name="action" value=""/> <br/>
                    <label for="" class="cache"></label> <input type="hidden" name="idCategorie" value="" id="idCategorie"/>
                    <!--<input type="submit" class="css-input2" value="" name="submit"/>-->
                    <label for="nom" class="css-input01">Sous annonce:  </label> <input type="checkbox"  name="sousAnnonce"  id="sousAnnonce"/><br/>
                    <div class="btn-group" role="group">
                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                          Action
                          <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu">
                          <li>
                              <button type="submit" id="save" data-loading-text="Ajout..." class="btn btn-primary" autocomplete="off">
                                Ajouter
                              </button>
                              
                          </li>
                          <li role="separator" class="divider"></li>
                          <li>
                              <button type="submit" id="modif" data-loading-text="Modif..." class="btn btn-warning" autocomplete="off">
                                Modifier
                              </button>
                          </li>
                          <li role="separator" class="divider"></li>
                          <li>
                             <button type="button" id="supprim" data-loading-text="Sup..." class="btn btn-danger" autocomplete="off">
                                Supprimer
                              </button>
                          </li>
                        </ul>
                    </div>

                </form>
                </div>
        </div>
      
    </div>
   
</div>

    <div class="modal fade" tabindex="-1" role="dialog" id="modalMessage">
        <div class="modal-dialog modal-sm">
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
              <h4 class="modal-title">Message</h4>
            </div>
            <div class="modal-body">
              <p id="contenuMessage"></p>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
          </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->


<table id="tableCategorie" class="table table-striped table-bordered" cellspacing="0" width="100%">
            <thead>
                <tr>
                     <th>
                        <input name="select_all" value="1" type="checkbox">
                    </th>
                    
                    <th>
                        Nom
                    </th>
                
                    <th>
                       Type cat&eacute;gorie
                    </th>
                    <th class="">
                        
                    </th>
                    
                    <th class="">
                        
                    </th>
                   
                </tr>
            </thead>
            
            <tbody>
                
            </tbody>
             
</table>
    
</div>

<script src="${pageContext.servletContext.contextPath}/resources/jquery-1.10.2.js" type="text/javascript"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/categorie.js" type="text/javascript"></script>
 