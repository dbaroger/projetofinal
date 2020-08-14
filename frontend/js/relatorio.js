function carregarPagina(){
    var usuarioLogado = localStorage.getItem("logado");

    if (!usuarioLogado){
        window.location="index.html";
    }else{
        var usuarioJson = JSON.parse(usuarioLogado);
        document.getElementById("foto").innerHTML = 
            "<img alt='Imagem não encontrada' width='30%' src=images/" + usuarioJson.foto + ">";
        document.getElementById("nome").innerHTML = 
            "<br><h4>" + usuarioJson.nome + " (" + usuarioJson.racf + ")</h4>"
    }

    var mensagem = {}
                        
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


function gerar(){

    var data = document.getElementById("txtData").value;
    var ano = data.substring(0,4);
    var mes = data.substring(5,7);
    var dia = data.substring(8);
    var dataFormatada = dia + "/" + mes + "/" + ano;
  
    var agencia  = document.getElementById("txtAgencia").value.length;
    var dataAgenda  = document.getElementById("txtData").value.length;
    var cliente  = document.getElementById("txtCliente").value.length;

    var codagencia = document.getElementById("txtAgencia").value.substring(0,document.getElementById("txtAgencia").value.indexOf(" "));
    
    //window.alert(agencia);
    //window.alert(dataAgenda);
    //window.alert(cliente);


    if (agencia>0){
        agencia = 1
    }
    if (dataAgenda>0){
        dataAgenda = 3
    }
    if (cliente>0){
        cliente = 5
    }
    var resultado = agencia + dataAgenda + cliente;
    //window.alert(resultado);

    if (resultado==1) {
                        var mensagem = {
                                agencia : {
                                        id : codagencia
                                    }
                        }

                        //window.alert(JSON.stringify(mensagem));

                        var cabecalho = {
                            method:"POST",
                            body:JSON.stringify(mensagem),
                            headers:{
                                    "Content-Type":"Application/json"
                            }
                        }

                            fetch("http://localhost:8080/relatorioporagencia", cabecalho)
                            .then(res => res.json())
                            .then(res => listarAgendamentos(res))
                            .catch(err => {window.alert("Nenhum dado encontrado.");});
                        }
    else if (resultado==3){
                        var mensagem = {
                            dataAgendamento : dataFormatada
                         }

                        //window.alert(JSON.stringify(mensagem));

                        var cabecalho = {
                            method:"POST",
                            body:JSON.stringify(mensagem),
                            headers:{
                                    "Content-Type":"Application/json"
                            }
                        }
                            fetch("http://localhost:8080/relatoriopordata", cabecalho)
                            .then(res => res.json())
                            .then(res => listarAgendamentos(res))
                            .catch(err => {window.alert("Nenhum dado encontrado.");});
                        }
    else if (resultado==5){
                        var mensagem = {
                            nomeCli : document.getElementById("txtCliente").value
                         }

                        //window.alert(JSON.stringify(mensagem));

                        var cabecalho = {
                            method:"POST",
                            body:JSON.stringify(mensagem),
                            headers:{
                                    "Content-Type":"Application/json"
                            }
                        }
                            fetch("http://localhost:8080/relatoriopornomecli", cabecalho)
                            .then(res => res.json())
                            .then(res => listarAgendamentos(res))
                            .catch(err => {window.alert("Nenhum dado encontrado.");});
                        }
    else if (resultado==8){
                        var mensagem = {
                            nomeCli : document.getElementById("txtCliente").value,
                            dataAgendamento : dataFormatada
                         }

                        //window.alert(JSON.stringify(mensagem));

                        var cabecalho = {
                            method:"POST",
                            body:JSON.stringify(mensagem),
                            headers:{
                                    "Content-Type":"Application/json"
                            }
                        }
                            fetch("http://localhost:8080/relatoriopoclientedata", cabecalho)
                            .then(res => res.json())
                            .then(res => listarAgendamentos(res))
                            .catch(err => {window.alert("Nenhum dado encontrado.");});
                        }
    else if (resultado==6){
                        var mensagem = {
                            nomeCli : document.getElementById("txtCliente").value,
                            agencia : {
                                id : codagencia
                            }
                         }

                        //window.alert(JSON.stringify(mensagem));

                        var cabecalho = {
                            method:"POST",
                            body:JSON.stringify(mensagem),
                            headers:{
                                    "Content-Type":"Application/json"
                            }
                        }
                            fetch("http://localhost:8080/relatorioporagenciacliente", cabecalho)
                            .then(res => res.json())
                            .then(res => listarAgendamentos(res))
                            .catch(err => {window.alert("Nenhum dado encontrado.");});
                        }
else if (resultado==4){
                        var mensagem = {
                            dataAgendamento : dataFormatada,
                            agencia : {
                                id : codagencia
                            }
                         }

                        //window.alert(JSON.stringify(mensagem));

                        var cabecalho = {
                            method:"POST",
                            body:JSON.stringify(mensagem),
                            headers:{
                                    "Content-Type":"Application/json"
                            }
                        }
                            fetch("http://localhost:8080/relatorioporagenciadata", cabecalho)
                            .then(res => res.json())
                            .then(res => listarAgendamentos(res))
                            .catch(err => {window.alert("Nenhum dado encontrado.");});
                        }
else if (resultado==9){
                        var mensagem = {
                            nomeCli : document.getElementById("txtCliente").value,
                            dataAgendamento : dataFormatada,
                            agencia : {
                                id : codagencia
                            }
                         }

                        //window.alert(JSON.stringify(mensagem));

                        var cabecalho = {
                            method:"POST",
                            body:JSON.stringify(mensagem),
                            headers:{
                                    "Content-Type":"Application/json"
                            }
                        }
                            fetch("http://localhost:8080/relatorioporagenciadatacliente", cabecalho)
                            .then(res => res.json())
                            .then(res => listarAgendamentos(res))
                            .catch(err => {window.alert("Nenhum dado encontrado.");});
                        }
else if (resultado==0){
                        var mensagem = {}
                        
                        var cabecalho = {
                            method:"POST",
                            body:JSON.stringify(mensagem),
                            headers:{
                                    "Content-Type":"Application/json"
                            }
                        }
                        //window.alert(JSON.stringify(cabecalho));

                            fetch("http://localhost:8080/relatoriogeral", cabecalho)
                            .then(res => res.json())
                            .then(res => listarAgendamentos(res))
                            .catch(err => {window.alert("Nenhum dado encontrado.");});
                        }                        
}


function listarAgendamentos(lista){ 
    
   /* saida = "";
    saida = 
    "<thead>" +
            "<tr>" +
                "<th>Código Agência</th>" +
                "<th>Nome Agência</th>" +
                "<th>Cliente</th>" +
                "<th>Email</th>" +
                "<th>Celular</th>" +
                "<th>Data Agendamento</th>" +
                "<th>Horário</th>" +
                "<th>Observação</th>" +
            "</tr>" +
    "</thead>" +
        "<tbody>";
        for(x=0;x<lista.length;x++){
            saida+=
            "<tr>" +
            "<td>" + lista[i].agencia.id + "</td>" +
            "<td>" + lista[i].agencia.nomeAgencia + "</td>" +
            "<td>" + lista[i].nomeCli + "</td>" +
            "<td>" + lista[i].email + "</td>" +
            "<td>" + lista[i].celular + "</td>" +
            "<td>" + lista[i].dataAgendamento + "</td>" +
            "<td>" + lista[i].horaAgendamento + "</td>" +
            "<td>" + lista[i].observacao + "</td>" +
            "</tr>";
        }
        saida+="</tbody>"
        document.getElementById("agendamento2").innerHTML=saida;
*/

    var saida = 
    "<div class='row>" + 
    "<div class='col-12>" +
    "<table border='1' cellpadding='5' cellspacing='2' align='center' width'80%'>" +
    "<tr>" + 
    "<th>Cliente</th> <th>Email</th> <th>Celular</th> <th>Data Agendamento</th> <th>Hora Agendamento</th> <th>Observacao</th>" + 
    "</tr>";
    for(i=0;i<lista.length;i++){
        saida+=
        "<tr>" +
        "<td>" + lista[i].nomeCli + "</td>" +
        "<td>" + lista[i].email + "</td>" +
        "<td>" + lista[i].celular + "</td>" +
        "<td>" + lista[i].dataAgendamento + "</td>" +
        "<td>" + lista[i].horaAgendamento + "</td>" +
        "<td>" + lista[i].observacao + "</td>" +
        "</tr>";
    }
    saida+="</table></div></div>"
    document.getElementById("agendamento").innerHTML=saida;


}



