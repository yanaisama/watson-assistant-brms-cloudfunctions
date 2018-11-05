var request = require("request");

function main(params) {
    
   var req = {
      "cliente": {
        "peso": params.p,
        "altura": params.a,
        "sexo": params.s,
        "idade": params.i
      },
      "questionario": {
        "exame": params.exame,
        "perguntas": []
      }
    }
   var options = {
      method: 'POST',
      url: 'https://api.us.apiconnect.ibmcloud.com/luizyanaigmailcom-dev/sb/odm/dev/DecisionService/rest/AgendarExameService/1.0/ConsultarQuestionario/1.0',
      headers: {
          'Content-Type' : 'application/json',
          'Accept' : 'application/json',
          'Authorization' : 'Basic dGVzdGVyLmZpZEB0MTEyODorK25pZVlsS3JZK2llVXpSZ2gzMWVFRzFPS2czRTlhM3VZaFZwSkd4'
      },
      body:req,
      json: true
   };
   return new Promise(function (resolve, reject) {
      request(options, function (err, resp) {
         //console.log(resp);
         if (err) {
            console.log(err);
            return reject({err: err});
         }
      return resolve(resp.body);
      });
   });
}
