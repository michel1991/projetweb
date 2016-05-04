/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function getDataEcole()
{
    var url =''+path+'/ControllerUtilisateur?action=dataEcole';
    var xhr = new XMLHttpRequest();
    xhr.open('POST', url, true);
    xhr.onloadend = function () 
    {
        var datas =  JSON.parse(this.response);
        /*console.log("reponse " +JSON.stringify(datas));*/
        if(typeof datas !='undefined')
        {
            for(var i =0; i<datas.length; i++)
            {

                $('#ecole').append($('<option>', {
                        value: datas[i].id,
                        text: datas[i].nom
                }));
                
                $('#ecoleSearchBar').append($('<option>', {
                        value: datas[i].id,
                        text: datas[i].nom
                }));
            }
            
             //$('#ecoleSearchBar option[value="134"]').prop('selected', true);
             $("#ecoleSearchBar").val($("#ecoleId").val()); // pour cocher la recherche de l'utilisateur
             //$("#categorieAnnonceR").val($("#cateId").val());// pour cocher la recherche de l'utilisateur
        }
    };
    xhr.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
    xhr.send("");
}

function getDataCategories()
{
    var url =''+path+'/ControllerCentralDepotAnnoceFE?action=categorie';
    var xhr = new XMLHttpRequest();
    xhr.open('POST', url, true);
    xhr.onloadend = function () 
    {
        var datas =  JSON.parse(this.response);
        //console.log("reponse " +JSON.stringify(datas));
        
        console.log("longueur 0 " + datas.length);
        if(typeof datas !='undefined')
        {
            for(var i =0; i<datas.length; i++)
            {

                $('#categorieAnnonce').append($('<optgroup>', {
                        //value:"",// datas[i].idTypeCat
                        label: datas[i].nomTypeCat,
                        id:datas[i].idTypeCat
                }));
                
                $('#categorieAnnonceR').append($('<optgroup>', {
                        //value:"",// datas[i].idTypeCat
                        label: datas[i].nomTypeCat,
                        id:datas[i].idTypeCat
                }));
                $("#categorieAnnonceR").val($("#cateId").val());// pour cocher l'image de la categorie selectionner
                
                
                //console.log(" erreur " + '#'+datas[i].idTypeCat + datas[i].nomTypeCat + $("#idCategorieModifier").val());
                
                var dataCategories = datas[i].categories;
                if(typeof dataCategories !='undefined')
                {
                    for(var j =0; j<dataCategories.length; j++)
                    {
                        
                        $('#'+datas[i].idTypeCat).append($('<option>', {
                            value: dataCategories[j].idCat,
                            text: dataCategories[j].nomCat
                        }));
                    }
                }
            }
            
           $("#categorieAnnonce").val($("#idCategorieModifier").val());
        }
    };
    xhr.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
     console.log("appel" );
    xhr.send("");
}

/**
 * 
 */
function getDataForEasyLocator(tableauDonnees)
{
    var url =''+path+'/ControllerUtilisateur?action=dataEcole';
    var xhr = new XMLHttpRequest();
    xhr.open('POST', url, true);
    xhr.onloadend = function () 
    {
        var datas =  JSON.parse(this.response);
        
        //console.log("reponse " +JSON.stringify(datas));
        if(typeof datas !='undefined')
        {
            for(var i =0; i<datas.length; i++)
            {
                if(datas[i].lat !='undefined' && datas[i].lon)
                {
                    var ecoleEasy ={
                        title: datas[i].nom,
                        description: datas[i].sigle,
                        image: 'images/picture-school.png', 
                        link: 'ServletControllerIndex',
                        iconMarker: 'images/pins-maps.png',
                        lat: datas[i].lat,
                        adresse: datas[i].lat,
                        lng: datas[i].lon
                    };
                    
                    tableauDonnees.push(ecoleEasy);
                }
            }
        }
    };
    xhr.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
    xhr.send("");
}

