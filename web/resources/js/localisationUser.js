/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// source du code je l'ai piquer sur un lien mis par Mr Buffa c'est pas moi qui l'ai ecrit https://dev.opera.com/articles/w3c-geolocation-api/
$(function(){
    if (navigator.geolocation) 
    {
	// Locate position
	navigator.geolocation.getCurrentPosition(displayPosition, errorFunction);
    } else {
        //It seems like Geolocation, which is required for this page, is not enabled in your browser. Please use a browser which supports it.
            alert('La geolocalisation est requise par cette page veuillez l\'activer merci!!');
    }
});
function errorFunction(pos) {
	alert('Erreur impossible de satisfaire votre requete!');
}



// Success callback function
function displayPosition(pos) {
    var latitude = pos.coords.latitude;
    var longitude = pos.coords.longitude;

    console.log("votre position latitude: " + latitude + " longitude " + longitude);
}


