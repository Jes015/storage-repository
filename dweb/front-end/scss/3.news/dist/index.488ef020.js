const nav = ()=>{
    const iconNav = document.getElementById("icon-nav");
    const navContainer = document.querySelector(".header__group-main-nav");
    const nav = document.querySelector(".main-nav");
    const nav_list = document.querySelector(".main-nav__list");
    iconNav.addEventListener("click", ()=>{
        navContainer.classList.toggle("header__group-main-nav--responsive");
        nav.classList.toggle("main-nav--responsive");
        nav_list.classList.toggle("main-nav--list");
    });
};
const animations = ()=>{
    ScrollReveal({
        reset: true
    });
    ScrollReveal().reveal(".banner", {
        delay: 100
    });
    ScrollReveal().reveal(".carrousel", {
        delay: 100
    });
};
animations();
nav();

//# sourceMappingURL=index.488ef020.js.map
