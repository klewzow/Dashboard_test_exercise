 
function ibg() {

    let ibg = document.querySelectorAll(".ibg");
    for (var i = 0; i < ibg.length; i++) {
        if (ibg[i].querySelector('img')) {
            ibg[i].style.backgroundImage = "url(" + ibg[i].querySelector("img").getAttribute("src") + ")";
        }
    }
}
ibg();



// var burger = document.querySelector('.header__burger');
// burger.addEventListener('click', function () {
//     document.querySelector('.header__burger-menu').classList.toggle("_active");
//     document.querySelector('.header__burger').classList.toggle("_active");
// });
 
var btn = document.querySelectorAll('._btn');
for (var i = 0; i < btn.length; i++) {
    btn[i].addEventListener('click', function(e){
        e.target.classList.toggle("_inactive");
        e.target.innerHTML = e.target.innerHTML=='Active' ? 'Inactive' : 'Active';
        });

}
 

 

 
 



// document.onclick = function(event){
//     console.log(event.target.tagName);
//     if (event.target.tagName == 'BUTTON'){
//         event.target.classList.toggle('_inactive') ;
//        let text =  document.querySelector(event.target.tagName);
//        text.innerHTML = "asd";
//         }
//     }
// btn.addEventListener('click', function () {
//     alert('a');
// });

