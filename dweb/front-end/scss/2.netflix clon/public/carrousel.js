
const buttons = document.querySelectorAll('.movies-carrousel__btn-scroll')
const containers = document.querySelectorAll('.movies-carrousel__group-movies')

let buttonsIndex = [0,1];
for(let i = 0;i< containers.length;i++){

    buttons[buttonsIndex[0]].addEventListener('click',()=>{

        if(window.innerWidth<=1206){
            containers[i].scrollLeft -= 208;
        }else{
        containers[i].scrollLeft -= 1249;
        }

    })

    buttons[buttonsIndex[1]].addEventListener('click',()=>{

        if(window.innerWidth<=1206){
            containers[i].scrollLeft += 208;
        }else{
        containers[i].scrollLeft += 1249;
        }

    })
    
    buttonsIndex[0]+=2;
    buttonsIndex[1]+=2;
}