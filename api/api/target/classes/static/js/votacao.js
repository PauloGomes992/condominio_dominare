// // Objeto para armazenar os votos
// let votos = {
//     opcao1: 0,
//     opcao2: 0,
//     opcao3: 0
// };

// // Carregar votos salvos do localStorage, se existirem
// document.addEventListener('DOMContentLoaded', () => {
//     if (localStorage.getItem('votos')) {
//         votos = JSON.parse(localStorage.getItem('votos'));
//         // Atualiza a exibição do resultado na página
//         document.getElementById('resultado-opcao1').textContent = votos.opcao1;
//         document.getElementById('resultado-opcao2').textContent = votos.opcao2;
//         document.getElementById('resultado-opcao3').textContent = votos.opcao3;
//     }
//     // Verifica se há um tempo de bloqueio armazenado
//     if (localStorage.getItem('bloqueioFim')) {
//         let bloqueioFim = parseInt(localStorage.getItem('bloqueioFim'));
//         let tempoRestante = bloqueioFim - Date.now();

//         if (tempoRestante > 0) {
//             // Se o tempo de bloqueio ainda não acabou, desativa a votação
//             votacaoBloqueada = true;
//             setTimeout(() => {
//                 votacaoBloqueada = false;
//             }, tempoRestante);
//         }
//     }
// });

// // Variável para rastrear se a votação está bloqueada
// let votacaoBloqueada = false;

// // Função para votar em uma opção
// function vote(opcao) {
//     if (votacaoBloqueada) {
//         alert("Você já realizou seu voto!");
//         return;
//     }

//     if (votos.hasOwnProperty(opcao)) { // Verifica se a opção existe no objeto de votos
//         votos[opcao]++;  // Incrementa o voto para a opção escolhida
//         // Atualiza a exibição do resultado na página
//         document.getElementById(`resultado-${opcao}`).textContent = votos[opcao];

//         // Salva a contagem de votos no localStorage
//         localStorage.setItem('votos', JSON.stringify(votos));

//         // Define o tempo de bloqueio de um minuto a partir de agora
//         votacaoBloqueada = true;
//         localStorage.setItem('bloqueioFim', Date.now() + 60000); // Salva o tempo de término do bloqueio
//         setTimeout(() => {
//             votacaoBloqueada = false;
//         }, 60000); // 60000 ms = 1 minuto
//     } else {
//         console.error('Opção inválida de voto:', opcao);
//     }
// }


let votos = {
    opcao1: 0,
    opcao2: 0,
    opcao3: 0
  };

  // Variável para rastrear se a votação está bloqueada
  let votacaoBloqueada = false;

  // Carregar votos salvos do localStorage, se existirem
  document.addEventListener('DOMContentLoaded', () => {
    if (localStorage.getItem('votos')) {
      votos = JSON.parse(localStorage.getItem('votos'));
      // Atualiza a exibição do resultado na página
      document.getElementById('resultado-opcao1').textContent = votos.opcao1;
      document.getElementById('resultado-opcao2').textContent = votos.opcao2;
      document.getElementById('resultado-opcao3').textContent = votos.opcao3;
    }

    // Verifica se há um tempo de bloqueio armazenado
    if (localStorage.getItem('bloqueioFim')) {
      let bloqueioFim = parseInt(localStorage.getItem('bloqueioFim'));
      let tempoRestante = bloqueioFim - Date.now();

      if (tempoRestante > 0) {
        // Se o tempo de bloqueio ainda não acabou, desativa a votação
        votacaoBloqueada = true;
        document.getElementById('mensagem-bloqueio').style.display = 'block';
        setTimeout(() => {
          votacaoBloqueada = false;
          document.getElementById('mensagem-bloqueio').style.display = 'none';
        }, tempoRestante);
      }
    }
  });

  // Função para votar em uma opção
  function vote(opcao) {
    if (votacaoBloqueada) {
      document.getElementById('mensagem-bloqueio').style.display = 'block';
      return;
    }

    if (votos.hasOwnProperty(opcao)) { // Verifica se a opção existe no objeto de votos
      votos[opcao]++;  // Incrementa o voto para a opção escolhida
      // Atualiza a exibição do resultado na página
      document.getElementById(`resultado-${opcao}`).textContent = votos[opcao];

      // Salva a contagem de votos no localStorage
      localStorage.setItem('votos', JSON.stringify(votos));

      // Define o tempo de bloqueio de um minuto a partir de agora
      votacaoBloqueada = true;
      localStorage.setItem('bloqueioFim', Date.now() + 60000); // Salva o tempo de término do bloqueio
      document.getElementById('mensagem-bloqueio').style.display = 'block';
      
      setTimeout(() => {
        votacaoBloqueada = false;
        document.getElementById('mensagem-bloqueio').style.display = 'none';
      }, 60000); // 60000 ms = 1 minuto
    } else {
      console.error('Opção inválida de voto:', opcao);
    }
  }