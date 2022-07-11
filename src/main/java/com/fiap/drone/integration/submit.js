//Representação de um conjunto de pares chave/valor para serem enviados via JSON
var serialize = function (form) {
   var json = {};
   var data = new FormData(form);
   var keys = data.keys();
   for (var key = keys.next(); !key.done; key = keys.next()) {
      var values = data.getAll(key.value);
      json[key.value] = values.length == 1 ? values[0] : values;
   }
   return json;
}
//Add referencias do elemento através do seu ID nas variaveis const e var
const droneId = document.getElementById("droneId");
const temperatura = document.getElementById("temperatura");
const umidade = document.getElementById("umidade");
const latitudeLongitude = document.getElementById("latitudeLongitude");

var form = document.querySelector("form");
var enviar = document.getElementById("enviar");
//Add evento do click
enviar.addEventListener("click", function (event) {
   //Validação Campos vazios
   if (droneId.value == "" || temperatura.value == "" || umidade.value == "" || latitudeLongitude.value == "") {
      event.preventDefault();
      alert("Preencher os campos vazios");
   }
   //Valiação de range das informações de temperatura e umidade
   else if (temperatura.value < -25 || temperatura.value > 40) {
      event.preventDefault();
      alert("Preencher temperatura com os valores entre -25º e 40º");
   }
   else if (umidade.value < 0 || umidade.value > 100) {
      event.preventDefault();
      alert("Preencher umidade com os valores entre 0% - 100%");
   }
   else {
      event.preventDefault();
      var json = serialize(form);
      console.log(json);

      //Gravando no LocalStorage
      localStorage.setItem('json', JSON.stringify(json));
      //Limpando campos apos envio da requisição
      droneId.value = '';
      umidade.value = '';
      temperatura.value = '';
      latitudeLongitude.value = '';
      alert("Enviado para Fila com Sucesso");
   }

});

//Recupear JSON do LocalStorage
var buscar = document.getElementById("buscar");
buscar.addEventListener("click", function (event) {
   event.preventDefault();
   console.info(JSON.parse(localStorage.getItem('json')));
});



