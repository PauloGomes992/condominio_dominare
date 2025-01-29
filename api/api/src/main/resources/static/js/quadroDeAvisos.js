// Simulação de dados iniciais
const avisos = [
    { titulo: "Reunião de condomínio", descricao: "Detalhes do Aviso 1: Lembre-se da reunião de condomínio - Segunda-feira, 12/08 às 09:30."  },
    { titulo: "Manuntenção elétrica", descricao: "Detalhes do Aviso 2: Manutenção elétrica programada. Segunda-feira, 12/08 às 09:30." },
    { titulo: "Atualização de regulamento", descricao: "Detalhes do Aviso 3: Atualização do regulamento interno. Segunda-feira, 12/08 às 09:30." },
];

// Elementos do DOM
const avisosList = document.getElementById("avisos-list");
const modal = document.getElementById("aviso-modal");
const closeModal = document.getElementById("close-modal");
const avisoTitulo = document.getElementById("aviso-titulo");
const avisoDescricao = document.getElementById("aviso-descricao");
const formCriarAviso = document.getElementById("form-criar-aviso");
const tituloAvisoInput = document.getElementById("titulo-aviso");
const descricaoAvisoInput = document.getElementById("descricao-aviso");


// Função para exibir o modal
// Não funciona

function showModal(aviso) {
    modal.classList.remove("hidden");
    avisoTitle.textContent = aviso.titulo;
    avisoDescription.textContent = aviso.descricao;
}
// Renderizar a lista de avisos
function renderAvisos() {
    avisosList.innerHTML = ""; // Limpa a lista antes de renderizar
    avisos.forEach((aviso) => {
        const li = document.createElement("li");
        li.textContent = aviso.titulo;

        // Adicionar evento para abrir o modal
        li.addEventListener("click", () => showModal(aviso));
        avisosList.appendChild(li);
        // TESTE pra ver se funciona o evento de click
        li.addEventListener("click", () => console.log("Aviso clicado"));
    });
}



// Função para fechar o modal
// Não funciona

function hideModal() {
    modal.classList.add("hidden");
}

// Evento para fechar o modal/
// Não funciona
closeModal.addEventListener("click", hideModal);
modal.addEventListener("click", (event) => {
    if (event.target === modal) hideModal();
});


// Função para criar um novo aviso
// Não funciona

function criarAviso(titulo, descricao) {
    avisos.push({ titulo, descricao }); // Adiciona o novo aviso ao array
    renderAvisos(); // Atualiza a lista
}

// Gerenciar o envio do formulário
// Não funciona

formCriarAviso.addEventListener("submit", (event) => {
    event.preventDefault(); // Impede o envio do formulário padrão

    const titulo = tituloAvisoInput.value.trim();
    const descricao = descricaoAvisoInput.value.trim();

    if (titulo && descricao) {
        criarAviso(titulo, descricao); // Cria um novo aviso
        formCriarAviso.reset(); // Limpa os campos do formulário
    } else {
        alert("Preencha todos os campos!");
    }
});

// Inicializar avisos ao carregar a página
document.addEventListener("DOMContentLoaded", renderAvisos);
