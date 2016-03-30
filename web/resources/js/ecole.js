
/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//var path = '${pageContext.servletContext.contextPath}';//context de l'application
     //console.log(path.replace('/',''));
      var table=null;
      var idTypeEcoleSupprimer = [];
      var donneesEcoles = [];
      
    $(function(){
        
        $("#modif").attr("disabled", "disabled");
        var rows_selected = [];
        table = $('#tableEcoles').DataTable(
        {
            'columnDefs': [{
            'targets': 0,
            'searchable': false,
            'orderable': false,
            'width': '1%',
            'className': 'dt-body-center',
            'render': function (data, type, full, meta){
                return '<input type="checkbox">';
            }
          },
            {
              "targets": [ 4 ],
              "visible": false,
              "searchable": false
           }// pour l'id de la categorie
           
           
          
      ],
          'order': [1, 'asc'],
          
           'rowCallback': function(row, data, dataIndex)
            {
              // Get row ID
              var rowId = data[0];
              // If row ID is in the list of selected row IDs
              if($.inArray(rowId, rows_selected) !== -1){
                 $(row).find('input[type="checkbox"]').prop('checked', true);
                 $(row).addClass('selected');
              }
              
            }
        }); // fin du databale
        
         $('#supprim').click(function(){
            /**
            * remplissage du tableau avec les identifiants à supprimer
            */
           var tableauData = table.rows('.selected').data();
          idTypeEcoleSupprimer=[];
           for(var i =0; i<tableauData.length; i++)
           {
               var tableauIntermediaire =tableauData[i];
               if(tableauIntermediaire[4]!==null)
               {
                   idTypeEcoleSupprimer.push(tableauIntermediaire[4]);
               }
              
           }
           table.rows('.selected').remove().draw();
           if(idTypeEcoleSupprimer.length>0)
           {
               supprimerEcole(idTypeEcoleSupprimer);
           }else{
               $('#contenuMessage').text("Aucune colonne selectionée");
              $('#modalMessage').modal('show');
           }
          
           
        });
        
       
        function updateDataTableSelectAllCtrl(table)
        {
            var $table             = table.table().node();
            var $chkbox_all        = $('tbody input[type="checkbox"]', $table);
            var $chkbox_checked    = $('tbody input[type="checkbox"]:checked', $table);
            var chkbox_select_all  = $('thead input[name="select_all"]', $table).get(0);

            // If none of the checkboxes are checked
            if($chkbox_checked.length === 0)
            {
               chkbox_select_all.checked = false;
               if('indeterminate' in chkbox_select_all)
               {
                  chkbox_select_all.indeterminate = false;
               }
             // If all of the checkboxes are checked
            } else if ($chkbox_checked.length === $chkbox_all.length)
            {
               chkbox_select_all.checked = true;
               if('indeterminate' in chkbox_select_all)
               {
                  chkbox_select_all.indeterminate = false;
               }
                // If some of the checkboxes are checked
            } else 
            {
                chkbox_select_all.checked = true;
                if('indeterminate' in chkbox_select_all){
                   chkbox_select_all.indeterminate = true;
                }
            }
        }
        
        // Handle click on checkbox
        $('#tableEcoles tbody').on('click', 'input[type="checkbox"]', function(e)
        {
           var $row = $(this).closest('tr');

           // Get row data
           var data = table.row($row).data();

           // Get row ID
           var rowId = data[0];
           // Determine whether row ID is in the list of selected row IDs 
           var index = $.inArray(rowId, rows_selected);

           // If checkbox is checked and row ID is not in list of selected row IDs
           if(this.checked && index === -1){
              rows_selected.push(rowId);

           // Otherwise, if checkbox is not checked and row ID is in list of selected row IDs
           } else if (!this.checked && index !== -1){
              rows_selected.splice(index, 1);
           }

           if(this.checked){
              $row.addClass('selected');
           } else {
              $row.removeClass('selected');
           }
           
          
          /*
           * verifie si le nombre de ligne selectionné = 1 pour pourvoir afficher la modification
           */
          
           if(table.rows('.selected').data().length===1)
           {
               
               var resultat = table.rows('.selected').data();
               var tableauResultat = resultat[0];
               
               
               if(tableauResultat[1]!==null)
               {
                   $('#nom').val(tableauResultat[1]);
               }
               
               if(tableauResultat[2]!==null)
                {
                    $('#cp').val(tableauResultat[2]);
                    //document.getElementById("idCategorie").setAttribute('value',tableauResultat[3]); 
                }
                
                if(tableauResultat[3]!==null)
                {
                    $('#adresse').val(tableauResultat[3]);
                    //document.getElementById("idCategorie").setAttribute('value',tableauResultat[3]); 
                }
                
                if(tableauResultat[4]!==null)
                {
                    $('#idEcole').val(tableauResultat[4]);
                    //document.getElementById("idCategorie").setAttribute('value',tableauResultat[3]); 
                }
                
                
               $("#modif").removeAttr("disabled"); 
           }else{
              
               $('#libelle').val('');
               $('#idTypeAnnonce').val('');
               $("#modif").attr("disabled", "disabled");
           }
           updateDataTableSelectAllCtrl(table);

           // Prevent click event from propagating to parent
           e.stopPropagation();
        });
        
        // Handle click on table cells with checkboxes
        $('#tableEcoles').on('click', 'tbody td, thead th:first-child', function(e){
           $(this).parent().find('input[type="checkbox"]').trigger('click');
        });
        
        // Handle click on "Select all" control
        $('thead input[name="select_all"]', table.table().container()).on('click', function(e){
           if(this.checked){
              $('#tableEcoles tbody input[type="checkbox"]:not(:checked)').trigger('click');
           } else {
              $('#tableEcoles tbody input[type="checkbox"]:checked').trigger('click');
           }

           // Prevent click event from propagating to parent
           e.stopPropagation();
        });
        
        // Handle table draw event
        table.on('draw', function(){
           // Update state of "Select all" control
           updateDataTableSelectAllCtrl(table);
        });
        
    });
    //document.getElementById("nomRegion").setAttribute('value','My default value');
    
    // Ajouter une region
    function addEcole() 
    {
        //$('#linkupdate').hide();
        var ecole = {};
        ecole.nom =document.querySelector("#nom").value;
        ecole.id =document.querySelector("#idEcole").value;
        ecole.cp =document.querySelector("#cp").value;
        ecole.adresse =document.querySelector("#adresse").value;
        
        var url =''+path+'/ControllerCentralEcole?action=add';
        var xhr = new XMLHttpRequest();
        xhr.open('POST', url, true);
        xhr.onloadend = function () 
        {
            var ecoleR = JSON.parse(this.response);
           // console.log("reponse " +JSON.stringify(ecoleR));
            if(typeof ecoleR !='undefined')//== "undefined"
            {
                if(ecoleR.id!==null)
                {
                    if(typeof ecoleR.op !='undefined' &&  ecoleR.op==='add')
                    {
                        table.row.add( [ '', ecoleR.nom, ecoleR.cp, ecoleR.adresse,  ecoleR.id]).draw();
                        $('#contenuMessage').text("Insertion reussie");
                        $('#modalMessage').modal('show');
                        donneesEcoles.push(ecoleR);
                    }else if(typeof ecoleR.op !='undefined' && ecoleR.op==='upd')
                    {
                       $('#contenuMessage').text("Modification reussie");
                        $('#modalMessage').modal('show');
                        
                        table.rows().every( function ( rowIdx, tableLoop, rowLoop ) {
                            var d = this.data();

                             
                            console.log(d[4] + ' '+ ecoleR.id);
                            if(d[4]==ecoleR.id)
                            {
                                //console.log("trouver ");
                                d[1]=ecoleR.nom;
                                d[2]=ecoleR.cp;
                                d[3]=ecoleR.adresse;
                            }

                           table.row( this ).data(d).draw();
                           
                        } );
                    }
                    
                    $('input[type="text"]').each(function()
                        {
                            $(this).val('');
                        }
                    );
                    $('#idEcole').val('');
            
                }
                
            }else{
                if(ecoleR.op==='add')
                {
                    $('#contenuMessage').text("Echec insertion");
                    $('#modalMessage').modal('show');
                }else if(ecoleR.op==='upd')
                {
                    $('#contenuMessage').text("Echec Modification");
                    $('#modalMessage').modal('show');
                }
            }
            
        };
        xhr.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
        //console.log("send " +JSON.stringify(ecole));
        xhr.send(JSON.stringify(ecole));

        return false;
    }
   
    function supprimerEcole(tableauId)
    {
        var url =''+path+'/ControllerCentralEcole?action=delete';
        //console.log(JSON.stringify(tableauId));
        var xhr = new XMLHttpRequest();
        xhr.open('POST', url, true);

        xhr.onloadend = function () 
        {
            //console.log(JSON.parse(this.response));
            if(JSON.parse(this.response)==0)
            {
                $('#contenuMessage').text("Suppression reussie");
            }else{
                $('#contenuMessage').text("Impossible de suprimer");
            }
            $('#modalMessage').modal('show');
            
             $('input[type="text"]').each(function()
                {
                    $(this).val('');
                });
                $('#idEcole').val('');
                
            
        };
        xhr.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
        xhr.send(JSON.stringify(tableauId));
        return false;
    }
    
    
    
    
    
   











