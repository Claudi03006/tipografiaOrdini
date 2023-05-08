$(document).ready(function(){
    $.getJSON("/api/ordini", function(data){
        $.each(data, function(index, value){
			let button = `<button class="btn btn-danger" id="elimina_${value.id}"> elimina </button>`;
$("#ordini").append("<tr><td>"+value.id+"</td><td>"+value.dataAcquisizione+"</td><td>"+value.dataConsegna+"</td><td>"+button+"</td></tr>");

	
        $(`#elimina_${value.id}`).on("click",eliminaOrdine);
        });
    });
});

function eliminaOrdine(e){
	let id = e.target.id.split("_")[1];
	$.ajax({
            type:"post",
            url:"api/eliminaOrdine",
            data:{
               id:id
            }
        }).done(function(res){
            alert("ordine eliminato con successo");
            $(e.target).closest("tr").remove();
           
        });	
}
$("#btn_aggiungi_ordine").on("click",aggiungi_ordine);
function aggiungi_ordine(){
    const dataAcquisizione = $("#dataAcquisizione").val();
    const dataConsegna = parseInt( $("#dataConsegna").val());
    if(dataAcquisizione != null &&  dataConsegna != null){
       $.ajax({
        type:"post",
        url:"api/aggiungiOrdine",
        data:
        {
            dataAcquisizione:dataAcquisizione,
           dataConsegna:dataConsegna
        }

       }).done(function(id){
        alert("prodotto inserito con successo");
        $("#ordini").append("<tr><td>"+id+"</td><td>"+dataAcquisizione+"</td><td>"+dataConsegna+"</td></tr>");	

       });
        
    }else{
        alert("i valori inseriti non sono corretti");
    }

}

