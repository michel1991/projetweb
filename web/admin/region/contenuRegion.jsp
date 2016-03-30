<%-- 
    Document   : listerUtilisateurs
    Created on : 4 mars 2016, 22:31:46
   Author     : michel Mvouma and Melissa Begyn 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="text-center">
    <div class="row">
       
        <div class="col-md-4">
            <ul class="list-unstyled">
                <li>
                    <a tabindex="0" class="css-input2 linkAdd" data-placement="bottom" data-toggle="popover" data-container="body" data-placement="left" type="button" data-html="true" href="#" id="linkAdd">
                    Ajouter
                    </a>
                </li>
                <div id="popover-content" class="hide">
                    <form class="form-inline" role="form"  onsubmit="return addRegion();" id="formRegion">
                      <div class="form-group"> 
                          <input class="input-sm" id="nomRegion" name="nomRegion" type="text" required value=""/>
                          <input class="input-sm hidden" id="idRegion" name="idReg" type="text" />
                          <input class="btn btn-primary btn-xs" id="btValider" type="submit" value="valider"/>
                          <!--<a class="btn btn-primary btn-xs" id="btValider" type="button">valider</a>-->
                      </div>
                    </form>
                </div>
            </ul>
        </div>
       
        
        <div class="col-md-4">
            <ul class="list-unstyled">
                <li>
                <a tabindex="0" class="css-input2"   data-placement="bottom" data-toggle="popover" data-container="body" data-placement="left" type="button" data-html="true" href="#" id="linkupdate">
                    Modifier
                </a>
            </li>
            <div id="popover-contentUpdate" class="hide">
                <form class="form-inline" role="form" id="formRegionUpdate" onsubmit="return updateRegion();">
                  <div class="form-group"> 
                      <input class="input-sm" id="nomRegionUpdate" name="nomRegionUpdate" type="text" required value=""/>
                      <input class="input-sm hidden" id="idRegionUpdate" name="idRegionUpdate" type="text" />
                      <input class="btn btn-primary btn-xs" id="btValiderUpdate" type="submit" value="valider"/>
                      
                  </div>
                </form>
            </div>
            </ul>
            
            
            
        </div>
        
        <div class="col-md-4">
            <input type="button" class="css-input2 cache" value="Supprimer" name="submit" id="supprimerRegion" />
            
        </div>
       
        <!--<div class="col-md-2">
            
        </div>-->
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


<table id="tableRegion" class="table table-striped table-bordered" cellspacing="0" width="100%">
            <thead>
                <tr>
                     <th>
                        <input name="select_all" value="1" type="checkbox">
                    </th>
                    
                    <th>
                        Nom
                    </th>
                
                    <th>
                        Date de cr&eacute;ation
                    </th>
                    <th class="">
                        
                    </th>
                   
                </tr>
            </thead>
            
            <tbody>
                <c:forEach var="r" items="${requestScope['regions']}">
                    <tr>
                        <td>
                        </td>
                        <td>
                            ${r.nomRe}
                        </td>
                        <td>
                            <fmt:formatDate value="${r.dateCreatRegion}" pattern="yyyy-MM-dd"/>

                        </td>
                    
                        <td class="">
                           ${r.id}
                        </td>
                    
                    </tr>
                </c:forEach>
            </tbody>
             
</table>

<script src="${pageContext.servletContext.contextPath}/resources/jquery-1.10.2.js" type="text/javascript"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/region.js" type="text/javascript"></script>
<script>
    
</script>
