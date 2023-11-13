function scrollToTop() {
    window.scrollTo({
        top: 0,
        behavior: 'smooth'
    });
}

const searchicon1 = document.querySelector('#searchicon1');
const srchicon1 = document.querySelector('#srchicon1');
const search1 = document.querySelector('#searchinput1');

searchicon1.addEventListener('click', function(){
    search1.style.display = 'flex';
    searchicon1.style.display = 'none';
});

// Función para eliminar el resaltado anterior
function removeHighlights() {
    const elements = document.querySelectorAll('span[style*="background-color: yellow;"]');
    elements.forEach((element) => {
        const parent = element.parentNode;
        parent.replaceChild(document.createTextNode(element.textContent), element);
    });
}

// Función para resaltar las palabras coincidentes en el primer cuadro de búsqueda
function highlightWords1(input) {
    const elements = document.querySelectorAll('body *');
    const searchText = input.toLowerCase().trim();

    elements.forEach((element) => {
        if (element.childNodes.length === 1 && element.childNodes[0].nodeType === Node.TEXT_NODE) {
            const text = element.innerText.toLowerCase();
            const index = text.indexOf(searchText);
            if (index !== -1) {
                const newText = element.innerText.replace(
                    new RegExp(searchText, 'gi'),
                    (match) => `<span style="background-color: yellow;">${match}</span>`
                );
                element.innerHTML = newText;
                element.scrollIntoView({ behavior: 'smooth', block: 'center' });
            }
        }
    });
}

const searchicon2 = document.querySelector('#searchicon2');
const srchicon2 = document.querySelector('#srchicon2');
const search2 = document.querySelector('#searchinput2');

searchicon2.addEventListener('click', function(){
    search2.style.display = 'flex';
    searchicon2.style.display = 'none';
});

const searchInput = document.querySelector('#searchinput2 input');
const searchIcon = document.querySelector('#searchinput2 .srchicon');

// Función para resaltar las palabras coincidentes
function highlightWords(input) {
    const elements = document.querySelectorAll('body *');
    const searchText = input.toLowerCase().trim();

    elements.forEach((element) => {
        if (element.childNodes.length === 1 && element.childNodes[0].nodeType === Node.TEXT_NODE) {
            const text = element.innerText.toLowerCase();
            const index = text.indexOf(searchText);
            if (index !== -1) {
                const newText = element.innerText.replace(
                    new RegExp(searchText, 'gi'),
                    (match) => `<span style="background-color: yellow;">${match}</span>`
                );
                element.innerHTML = newText;
                element.scrollIntoView({ behavior: 'smooth', block: 'center' });
            }
        }
    });
}

// Escucha el clic en el icono de búsqueda del primer cuadro de búsqueda
searchIcon.addEventListener('click', function () {
    const searchText = searchInput.value;
    removeHighlights(); // Elimina el resaltado anterior
    highlightWords(searchText);
});

// Escucha el evento "Enter" en el cuadro de texto del primer cuadro de búsqueda
searchInput.addEventListener('keypress', function (e) {
    if (e.key === 'Enter') {
        const searchText = searchInput.value;
        removeHighlights(); // Elimina el resaltado anterior
        highlightWords(searchText);
    }
});

const bar = document.querySelector('.fa-bars');
const cross = document.querySelector('#hdcross');
const headerbar = document.querySelector('.headerbar');

bar.addEventListener('click', function(){
    setTimeout(() => {
        cross.style.display = 'block';
    },200);
    headerbar.style.right = '0%';
});

cross.addEventListener('click', function(){
    cross.style.display = 'none';
    headerbar.style.right = '-100%';
});





document.addEventListener('DOMContentLoaded', function () {
    const formTitle = document.getElementById('form-title');
    const registerForm = document.getElementById('register-form');
    const loginForm = document.getElementById('login-form');
    const registerBtn = document.getElementById('registerBtn');
    const loginBtn = document.getElementById('loginBtn');
    const confirmLoginBtn = document.getElementById('confirmLoginBtn');
    const nextBtn = document.getElementById('nextBtn');

    registerBtn.addEventListener('click', function () {
        formTitle.innerText = 'Registrarse';
        registerForm.style.display = 'block';
        loginForm.style.display = 'none';
    });

    loginBtn.addEventListener('click', function () {
        formTitle.innerText = 'Ingresar';
        registerForm.style.display = 'none';
        loginForm.style.display = 'block';
    });

    confirmLoginBtn.addEventListener('click', function () {
        formTitle.innerText = 'Ingresar';
        registerForm.style.display = 'none';
        loginForm.style.display = 'none';
    });

    nextBtn.addEventListener('click', function () {
        // Aquí se enviarán los datos a la base de datos
        console.log('Se ha hecho clic en el botón de siguiente.');
    });
});
