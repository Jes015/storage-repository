

const nav=()=>{
    const iconNav = document.getElementById('icon-nav');
    const navContainer = document.querySelector('.header__group-main-nav');
    const nav = document.querySelector('.main-nav')
    const nav_list = document.querySelector('.main-nav__list')

    iconNav.addEventListener('click',()=>{

        navContainer.classList.toggle('header__group-main-nav--responsive')
        nav.classList.toggle('main-nav--responsive')
        nav_list.classList.toggle('main-nav--list')
    })
}

const animations=()=>{
    ScrollReveal().reveal('.banner')
}

animations();
nav();