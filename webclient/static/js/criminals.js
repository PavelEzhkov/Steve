window.onload =function(){

var httpRequest = new XMLHttpRequest();
    httpRequest.onreadystatechange = function(e){
    if  (this.readyState === XMLHttpRequest.DONE && this.status === 200){
        console.log(httpRequest.responseText);
        }
    }
    httpRequest.open("GET", '/api/criminals', true);
    httpRequest.send();
    }