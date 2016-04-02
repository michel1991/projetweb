var utag_resize;

function getDisplay(width){
    if(width > 1023) display_type = "desktop";
    else if(width > 767 && width < 1024) display_type = "tablet";
    else display_type = "smartphone";
    return display_type;
}

function getDevice(){
    var md = new MobileDetect(window.navigator.userAgent), device = "";
    if(md.mobile()==null) device = "desktop";
    else if(md.tablet()!=null) device = "tablet";
    else if(md.phone()!=null) device = "smartphone";
    else device = "other";
    return device;
}

function doneResizing(){
    var display = getDisplay($(window).innerWidth());
    if(typeof(utag_data)!="undefined"){
        if(utag_data.displaytype!=display) utag.view({displaytype: display});
    }
}

$(window).resize(function() {
    clearTimeout(utag_resize);
    utag_resize = setTimeout(doneResizing, 300);
});
