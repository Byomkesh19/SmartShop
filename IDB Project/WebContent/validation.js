function validate() {
let
a = document.getElementById("firstname").value;
let
b = document.getElementById("lastname").value;
let
c = document.getElementById("age").value;
let
d = document.getElementById("number").value;
let
e = document.getElementById("userid").value;
let
f = document.getElementById("password").value;

let
flag = true;
let
regex =  /^[A-Za-z]+$/;
let
regex_no =  /^[0-9]+$/;


        
 
if (a==null||a == "") {
alert("Enter the first name");
return false;
}
if (a.length > 50 || a.length < 3) {
alert("First Name should be between 3 to 50 characters");
return false;
}

       if(!regex.test(a))
                     {
                     alert("Consists of number or special charecters");
                     return false;
                     } 
        
 
 
 
 
if (b==null||b== "") {
alert("Enter the Last Name");
return false;
}
if (b.length > 50 || b.length < 3) {
alert("Last Name should be between 3 to 50 characters");
return false;
}
if(!regex.test(b))
{
alert("Last name consists of number or special charecters");
return false;
} 
 
 
if (c == "") {
alert("Enter the Age");
return false;
}
if (isNaN(c)) {
alert("Age must be number only");
return false;

}
if (c.length != 2) {
alert("Age must have 2 digits");
return false;
}
if(!regex_no.test(c))
{
alert(" Age consists of number or special charecters");
return false;
} 
 
 
if (isNaN(d)) {
alert("Contact Number must be number only");
return false;

}
if (d.length != 10) {
alert("Contact Number must have 10 digits");
return false;
}
if(!regex_no.test(d))
{
alert("Contact number consists of alphabets or special characters");
return false;
} 

if (e==null||e == "") {
    alert("Enter the Id");
    return false;
    }
if (e.length <=5) {
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
