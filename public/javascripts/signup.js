

        function validate(e){
                var input=document.getElementById(e.id).value;
                var element = document.getElementById(e.id).parentNode.getElementsByTagName('label');
                if(input.length<4){
                    element[0].innerHTML='✘' + "Must contain 4 characters";
                    element[0].style.color="maroon"
                    return false;
                }
                else{
                    element[0].innerHTML='✔' + "Done";
                    element[0].style.color="green";
                }
                
               
                
            }
         function validateEmail(){
                   var email= document.getElementById('inputEmail').value;
                   var element = document.getElementById('labeluser1');
                   var reg =  /^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
                   if (reg.test(email)){
                    element.innerHTML='✔' + "Done";
                    element.style.color="green";
                     }
                     else{
                        element.innerHTML='✘' + "Not a valid email id";
                        element.style.color="maroon";
                                              } 
            }
         function validatePassword(){
                   var password= document.getElementById('inputPassword').value;
                   var element = document.getElementById('labeluser2');
                   var reg = /(?=.*\d)(?=.*[@#%]).{8}/;
                   if (reg.test(password)){
                    element.innerHTML='✔' + "Done";
                    element.style.color="green";
                     }
                     else{
                        element.innerHTML='✘' + "Password should contain minimum 8 characters -must have atleast 1 number and atleast 1 special character ";
                        element.style.color = "maroon";
                                              } 
                    }
         function validateCPassword(){
                   var cpassword= document.getElementById('inputcf').value;
                   var password=document.getElementById('inputPassword').value;
                   var element = document.getElementById('labeluser3');
                   if (cpassword == password){
                    element.innerHTML='✔' + "Password Match";
                    element.style.color="green";
                     }
                     else{
                        element.innerHTML='✘' + "Password don't Match";
                        element.style.color="maroon";
                                              } 
                    }
             