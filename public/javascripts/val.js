var app = angular.module("Validation",[]);

app.controller("Submit",['$http',function($http){

         this.form = {firstname:"",lastname:"",emailId:"",password:"",conf_password:""};
         var rege =  /^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
         var reg = /(?=.*\d)(?=.*[@#%]).{8}/;
      this.submission = function(form){
        if(this.form.firstname.length>=4 && this.form.lastname.length>=4 && rege.test(this.form.emailId) && reg.test(this.form.password) && (this.form.conf_password == this.form.password)){
           return true;
            
        }
        return false;
        
      }


}]);