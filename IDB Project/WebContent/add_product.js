function validate(){

	 let d=document.getElementById("productid").value;
     let e=document.getElementById("productname").value;
     let f=document.getElementById("brand").value;
     let g=document.getElementById("producttype").value;
     let h=document.getElementById("quantity").value;
     let i=document.getElementById("rate").value;
     let j=document.getElementById("stock").value;
    
    let
    flag = true;
    let
    regex =  /^[A-Za-z]+$/;
    let
    regex_no =  /^[0-9]+$/;
    
    if (d==null||d == "") {
        alert("Enter the product id");
        return false;
        }
    if(!regex_no.test(d))
    {
    alert("Product Id should contain numbers only");
    return false;
    }
    
    

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
    alert("Enter the brand name");
    return false;
    }
    if(!regex.test(f))
    {
    alert("Brand should contain alphabets only");
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
    if(!g==1 ||!g==2||!g==3||!g==4||!g==5){
    	alert("Product type should be between 1-5");
    	return false;
    }
    
    
    if (h==null||h == "") {
        alert("Enter the quantity type");
        return false;
        }
    /*if(!regex_no.test(h))
    {
    alert("Quantity Type contain numbers only");
    return false;
    }*/
    
    if (i==null||i == "") {
        alert("Enter the rate:");
        return false;
        }
    if(!regex_no.test(i))
    {
    alert("Quantity Type contain numbers only");
    return false;
    }
    
    
  if (j==null||j == "") {
        alert("Enter Stock");
        return false;
        }
    if(!regex_no.test(j))
    {
    alert("Stock Count should contain numbers only");
    return false;
    }
}

