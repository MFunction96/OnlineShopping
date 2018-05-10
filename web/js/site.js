function svrTime() {
    let xmlhttp;
    try {
        xmlhttp = new XMLHttpRequest();
    } catch (err1) {
        try {
            xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (err2) {
            try {
                xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (err3) {}
        }
    }
    if (xmlhttp) {
        xmlhttp.open("HEAD", window.location.href.toString(), false);
        xmlhttp.setRequestHeader("Content-Type", "text/html");
        xmlhttp.send("");
        const date = new Date(xmlhttp.getResponseHeader("Date"));
        $("ServerTime").html(date);
    }
}

function queryTime() {
    setInterval(svrTime, 1000);
}