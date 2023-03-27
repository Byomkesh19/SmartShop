function loginValidate(){

     
     let e=document.getElementById("userId").value;
     let f=document.getElementById("password").value;
    
     let
    flag = true;
    let
    regex =  /^[A-Za-z]+$/;
    let
    regex_no =  /^[0-9]+$/;

    if (e==null||e == "") {
        alert("Enter the Id");
        return false;
        }
    if (e.length <5) {
        alert("Id should have atleast 5 characters");
        return false;
        }
    if(!regex_no.test(e))
    {
    alert("Id consists of special characters or alphabets");
    return false;
    }
    
    if (f==null||f== "") {
    alert("Enter the password");
    return false;
    }
    if (f.length <= 8) {
    alert("Password must have atleast 8 digits");
    return false;
   }
}

