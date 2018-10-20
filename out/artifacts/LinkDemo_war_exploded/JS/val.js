function checkUrl() {
    var elepar = document.getElementById("link");
    var msg = document.getElementById("linkMsg");
    var regex = /^(?:([A-Za-z]+):)?(\/{0,3})([0-9.\-A-Za-z]+)(?::(\d+))?(?:\/([^?#]*))?(?:\?([^#]*))?(?:#(.*))?$/;
    if(elepar.value==""){
        msg.innerHTML = "<font color='red'>网址不能为空！</font>";
        return false;
    }else{
        if(!regex.test(elepar.value)){
            msg.innerHTML = "<font color='red'>输入的网址有误！</font>";
            return false;
        }
        msg.innerHTML = "<font></font>";
        return true;
    }
}

function validate() {
    return checkUrl();
}
