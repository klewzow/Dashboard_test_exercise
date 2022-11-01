const MAX_PAGE = 6;
const MIN_PAGE = 1;
const DEFAULT_PAGE = 1;
function ibg() {

    let ibg = document.querySelectorAll(".ibg");
    for (var i = 0; i < ibg.length; i++) {
        if (ibg[i].querySelector('img')) {
            ibg[i].style.backgroundImage = "url(" + ibg[i].querySelector("img").getAttribute("src") + ")";
        }
    }
}
ibg();

var btn = document.querySelectorAll('._btn');
for (var i = 0; i < btn.length; i++) {
    btn[i].addEventListener('click', function (e) {
        e.target.classList.toggle("_inactive");
        e.target.innerHTML = e.target.innerHTML == 'Active' ? 'Inactive' : 'Active';
    });

}
pageNav();
function get(key) {
    var p = window.location.search;
    p = p.match(new RegExp(key + '=([^&=]+)'));
    return p ? p[1] : false;
}

function pageNav() {
    var nav = document.querySelectorAll('.footer__navigation');
    let maxPage = MAX_PAGE;
    let minPage = MIN_PAGE;
    let value = DEFAULT_PAGE;
    for (var i = 0; i < nav.length; i++) {

        nav[i].addEventListener('click', function (e) {
            value = e.target.innerHTML;

            if (e.target.classList == 'footer__navigation icon-cheveron-right') {
                value = parseInt(get("page")) + 1;
                if (value > maxPage) value = maxPage;
            }
            if (e.target.classList == 'footer__navigation icon-cheveron-left') {
                value = parseInt(get("page")) - 1;
                if (value < minPage) value = minPage;
            }

            window.location.href = '?page=' + value;
        });

    }
}