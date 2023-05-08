$(document).ready(function(){
    $.getJSON("/api/clienti", function(data){
        $.each(data, function(index, value){
            let button = `<button class="btn btn-danger" data-id="${value.id}" data-rowid="row_${value.id}"> elimina </button> ` 
            $("#clienti").append(`<tr id="row_${value.id}"><td>${value.id}</td><td>${value.cognome}</td><td>${value.email}</td><td>${value.numeroTelefono}</td><td>${value.nome}</td><td>${button}</td></tr>`);
        	$(`button[data-id='${value.id}']`).on("click",eliminaCliente);
        });
    });
});

function eliminaCliente(e){
	let id = $(e.target).data("id");
	let rowId = $(e.target).data("rowid");
	$.ajax({
            type:"post",
            url:"api/eliminaCliente",
            data:{
               id:id
            }
        }).done(function(res){
            alert("cliente eliminato con successo");
            $(`#${rowId}`).remove();
        });	
}

$("#btn_aggiungi_cliente").on("click", aggiungi_cliente);

function aggiungi_cliente(){
    const nome = $("#nome").val();
    const cognome =$("#cognome").val();
    const email = $("#email").val();
    const numeroTelefono =$("#numeroTelefono").val();
    if(nome.trim().length > 2 && cognome.trim().length > 2 && email.trim().length > 2 && numeroTelefono.trim().length > 2){
        $.ajax({
            type:"post",
            url:"api/aggiungiCliente",
            data:{
                cognome:cognome,
                email:email,
                numeroTelefono:numeroTelefono,
                nome:nome
            }
        }).done(function(id){
            alert("cliente inserito con successo");
            $("#clienti").append(`<tr id="row_${id}"><td>${id}</td><td>${cognome}</td><td>${email}</td><td>${numeroTelefono}</td><td>${nome}</td><td><button class="btn btn-danger" data-id="${id}" data-rowid="row_${id}"> elimina </button></td></tr>`);
            $(`button[data-id='${id}']`).on("click",eliminaCliente);
        });
    }else{
        alert("i valori inseriti non sono corretti");
    }
}
