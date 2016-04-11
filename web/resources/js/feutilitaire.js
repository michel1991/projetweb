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
            }
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
        /*console.log("reponse " +JSON.stringify(datas));*/
        if(typeof datas !='undefined')
        {
            for(var i =0; i<datas.length; i++)
            {

                $('#categorieAnnonce').append($('<optgroup>', {
                        //value:"",// datas[i].idTypeCat
                        label: datas[i].nomTypeCat,
                        id:datas[i].idTypeCat
                }));
                
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
        }
    };
    xhr.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
    xhr.send("");
}