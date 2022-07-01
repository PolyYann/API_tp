function sliding() {
    document.getElementById("sliderValue").innerHTML = document.getElementById("slider").value + " $";
}
const he = jQuery('#he');
const skin = jQuery('#skin');
const analgesic = jQuery('#analgesic');
const massage = jQuery("#massage");
const taping = jQuery("#taping");

jQuery('#productChoix').click(function (){
    he.prop('disabled', false);
    he.prop('checked', true);
    skin.prop('checked',true);
    skin.prop('disabled', false);
    analgesic.prop('disabled', false);
    analgesic.prop('checked',true);
     massage.prop('checked',false);
    massage.prop('disabled', true);
    taping.prop('checked',false);
    taping.prop('disabled', true);
})
jQuery('#treatmentChoix').click(function (){
    he.prop('disabled', true);
    he.prop('checked', false);
    skin.prop('disabled', true);
    skin.prop('checked',false);
    analgesic.prop('disabled', true);
    analgesic.prop('checked',false);
     massage.prop('checked',true);
    massage.prop('disabled', false);
    taping.prop('checked',true);
    taping.prop('disabled', false);
})
function submit(){
    let form= document.getElementById("ArticleForm");



    form.submit();

}

