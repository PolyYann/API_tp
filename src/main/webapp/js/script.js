
function sliding() {
    document.getElementById("sliderValue").innerHTML = document.getElementById("slider").value + " $";
}
const form = document.querySelector("form"), radio = form.elements.namedItem("choix");

form.addEventListener('click', switchRadio);

function switchRadio(e) {
    let list;
    const clicked = e.target;
    if(clicked.name !== "type"){return;} //ignore les click inutiles
    if(clicked.id === "product") {
        list = "he,skin,analgesic".split(",");
    }else if(clicked.id === "treatment") {
        list = "massage,tapping".split(",");
    }else{
        console.log("pas de type sélectionner");
        return;
    }
    Array.from(radio).forEach(el => el.removeAttribute("disabled"));
    Array.from(radio).forEach(el=>el.setAttribute("checked",""));

    const disableMe = Array.from(radio).filter(el => !list.includes(el.id));
    disableMe.forEach(el => el.removeAttribute("checked"));
    disableMe.forEach(el => el.setAttribute("disabled", ""));

}

