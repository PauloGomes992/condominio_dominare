// Função para aplicar a máscara no CPF
function aplicarMascaraCPF(cpf) {
  // Remove tudo que não for número
  cpf = cpf.replace(/\D/g, "");

  // Aplica a máscara no formato XXX.XXX.XXX-XX
  cpf = cpf.replace(/(\d{3})(\d)/, "$1.$2");
  cpf = cpf.replace(/(\d{3})(\d)/, "$1.$2");
  cpf = cpf.replace(/(\d{3})(\d{1,2})$/, "$1-$2");

  return cpf;
}

// Função para aplicar a máscara enquanto o usuário digita o CPF
function mascaraCPF(event) {
  let campoCPF = event.target;
  let cpf = campoCPF.value;
  campoCPF.value = aplicarMascaraCPF(cpf);
}

// Função para aplicar a máscara no telefone
function aplicarMascaraTelefone(telefone) {
  // Remove tudo que não for número
  telefone = telefone.replace(/\D/g, "");

  // Aplica a máscara no formato (XX) XXXXX-XXXX
  telefone = telefone.replace(/^(\d{2})(\d)/, "($1) $2");
  telefone = telefone.replace(/(\d{5})(\d)/, "$1-$2");

  return telefone;
}

// Função para aplicar a máscara enquanto o usuário digita
function mascaraTelefone(event) {
  let campoTelefone = event.target;
  let telefone = campoTelefone.value;

  // Limita a entrada a no máximo 11 números (para telefone com DDD)
  telefone = telefone.replace(/\D/g, "").substring(0, 11);

  campoTelefone.value = aplicarMascaraTelefone(telefone);
}

//   Função para máscara de data de nascimento
// document
//   .getElementById("dataNascimento")
//   .addEventListener("input", function () {
//     let value = this.value.replace(/\D/g, ""); // Remove caracteres não numéricos
//     let formattedValue = "";

//     // Adiciona os separadores de acordo com o tamanho da entrada
//     if (value.length > 2) {
//       formattedValue += value.substring(0, 2) + "/";
//       if (value.length > 4) {
//         formattedValue += value.substring(2, 4) + "/";
//         formattedValue += value.substring(4, 8);
//       } else {
//         formattedValue += value.substring(2);
//       }
//     } else {
//       formattedValue = value;
//     }

//     this.value = formattedValue.substring(0, 10); // Limita a 10 caracteres
//   });
