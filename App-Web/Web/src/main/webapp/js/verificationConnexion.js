/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function isLoggedInClient(redirecturl) {
    $.ajax({
        url: './ActionServlet',
        method: 'POST',
        data: {
            todo : 'est-connecte-client'
        },
        datatype: 'json'
    })
    .done(function(response) {
        console.log(response);
        if(!response.connecte){
            window.location = redirecturl;
        }
    })
    .fail(function(error) {
        console.log(error);
        window.location = redirecturl;
    });
}


function isLoggedInEmploye(redirecturl) {
    $.ajax({
        url: './ActionServlet',
        method: 'POST',
        data: {
            todo : 'est-connecte-employe'
        },
        datatype: 'json'
    })
    .done(function(response) {
        console.log(response);
        if(!response.connecte){
            window.location = redirecturl;
            //console.log("Il y un pb");
        }
    })
    .fail(function(error) {
        console.log(error);
        window.location = redirecturl;
    });
}
$( document ).ready(function() {
    $("#btn-deconnexion-client").on("click", function(event){
        $.ajax({
            url:'./ActionServlet',
            method: 'POST',
            data: {
                todo : 'deconnexion-client'
            },
            datatype: 'json'
        })
        .done(function(response){
            window.location = 'index.html';
        })
        .fail(function(error){
            console.log(error);
            console.log("Il y a eu un probleme");
        });
    });

    $("#btn-deconnexion-employe").on("click", function(event){
        $.ajax({
            url:'./ActionServlet',
            method: 'POST',
            data: {
                todo : 'deconnexion-employe'
            },
            datatype: 'json'
        })
        .done(function(response){
            window.location = 'index.html';
        })
        .fail(function(error){
            console.log(error);
            console.log("Il y a eu un probleme");
        });
    });

});
