function cadastrar(){

    var data = document.getElementById("txtData").value;
    var ano = data.substring(0,4);
    var mes = data.substring(5,7);
    var dia = data.substring(8);
    var dataFormatada = dia + "/" + mes + "/" + ano;
  
   var mensagem = {
       nomeCli : document.getElementById("txtNome").value,
       email : document.getElementById("txtEmail").value,
       celular : document.getElementById("txtCelular").value,
       dataAgendamento : dataFormatada,
       horaAgendametno : document.getElementById("txtHoraIni").value,
       observacao : document.getElementById("txtObs").value,
       agencia : {
                    id : document.getElementById("txtAgencia").value
                }
   }
window.alert(JSON.stringify(mensagem));
   var cabecalho = {
       method:"POST",
       body:JSON.stringify(mensagem),
       headers:{
            "Content-Type":"Application/json"
       }
   }

       fetch("http://localhost:8080/novoagendamento", cabecalho)
       .then(res => res.json())
       .then(res => {window.alert("Gravado com sucesso.");})
       .catch(err => {window.alert("Erro.");});
 
}
