function validate(){

     
     let e=document.getElementById("productname").value;
     let f=document.getElementById("brand").value;
     let g=document.getElementById("producttype").value;
     let h=document.getElementById("quantity").value;//d.o.m
     let i=document.getElementById("stock").value;//d.o.e
    
     let
    flag = true;
    let
    regex =  /^[A-Za-z]+$/;
    let
    regex_no =  /^[0-9]+$/;

    if (e==null||e == "") {
        alert("Enter the product name");
        return false;
        }
    
    if(!regex.test(e))
    {
    alert("Product name contains digits.Please enter only alphabets");
    return false;
}
    
    if (f==null||f== "") {
    alert("Enter the number of items");
    return false;
    }
    if(!regex_no.test(f))
    {
    alert("Number of items should contain numbers only");
    return false;
    }
    
    if (g==null||g== "") {
    alert("Enter the product type");
    return false;
    }
    if(!regex_no.test(g))
    {
    alert("Product type should contain number only");
    return false;
    }
    
    if (h==null||h == "") {
        alert("Enter the Date Of Manufacturing");
        return false;
        }
    if(h)
    
    
    if (i==null||i == "") {
        alert("Enter the Date of Expiry");
        return false;
        }
}

