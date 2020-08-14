function cadastrar(){

    var data = document.getElementById("txtData").value;
    var ano = data.substring(0,4);
    var mes = data.substring(5,7);
    var dia = data.substring(8);
    var dataFormatada = dia + "/" + mes + "/" + ano;
    var codagencia = document.getElementById("txtAgencia").value.substring(0,document.getElementById("txtAgencia").value.indexOf(" "));
    
   var mensagem = {
       nomeCli : document.getElementById("txtNome").value,
       email : document.getElementById("txtEmail").value,
       celular : document.getElementById("txtCelular").value,
       dataAgendamento : dataFormatada,
       horaAgendamento : document.getElementById("txtHorario").value,
       observacao : document.getElementById("txtObs").value,
       agencia : {
                    id : codagencia
                }
   }
    
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
       .then(res => {window.location="index.html";})
       .catch(err => {window.alert("Horário já reervado. Selecione outro horário.");});

}


function carregarPagina(){
var mensagem = {}
    
       
var data = new Date();
data.setDate(data.getDate()+1);
var dia = data.getDate();
var mes = data.getMonth()+1;
var ano = data.getFullYear();
dia = String(dia);
mes = String(mes);
ano = String(ano);

if (dia.length==1){
    dia = "0" + dia;
}
if (mes.length==1){
    mes = "0" + mes;
}
var dataFormatada = ano + "-" + mes + "-" + dia;

document.getElementById("txtData").value = dataFormatada;

    var cabecalho = {
        method:"POST",
        body:JSON.stringify(mensagem),
        headers:{
                "Content-Type":"Application/json"
        }
    }

    fetch("http://localhost:8080/agencias", cabecalho)
    .then(res => res.json())
    .then(res => carregarAgencia(res));
}


function carregarAgencia(lista){
    
    var saida = ""
    for(i=0;i<lista.length;i++){
        saida+=
        "<option selected>" + lista[i].id + " - " + lista[i].nomeAgencia +  "</option>"
    }
    saida+="<option selected></option>"
    document.getElementById("txtAgencia").innerHTML=saida;

}

