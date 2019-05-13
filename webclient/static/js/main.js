function onTestGeyButtonClick(){
    var httpRequest = new XMLHttpRequest();
    httpRequest.onreadystatechange = function(e){
    if  (this.readyState === XMLHttpRequest.DONE && this.status === 200){
        var responseJSON = JSON.parse(httpRequest.responseText);
        console.log(httpRequest.responseText);
        document.getElementById("server_response_section").innerHTML = responseJSON.location;
    }
    }
    httpRequest.open("POST", '/api/testpost', true);

    var requestJson = {
        text : document.getElementById("test_input").value,
        location : location.host,
        protocol : location.protocol
    };

    httpRequest.send(JSON.stringify(requestJson));
    }