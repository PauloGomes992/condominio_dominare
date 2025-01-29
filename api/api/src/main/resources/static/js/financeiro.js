        // Adiciona um evento ao botão para simular o download

document.getElementById('downloadBtn').addEventListener('click', function () {
    const link = document.createElement('a'); // Cria um elemento <a>
    link.href = '../img/descktopimg2.jpg'; // Substitua pelo caminho do arquivo PDF
    link.download = 'ContaApagar'; // Nome do arquivo a ser baixado
    link.click(); // Simula o clique no link
});