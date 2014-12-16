package controllers;

import java.util.ArrayList;
import java.util.List;

import play.*;
import play.mvc.*;

import models.*;

import views.html.*;

import views.html.index;
import views.html.signup;

import play.data.Form;

import play.db.ebean.*; 

import javax.persistence.*;
import play.Logger;







public class Application extends Controller {

	public static final Form<Users> signupForm = Form.form(Users.class);
    public static final Form<SignIn> signinForm = Form.form(SignIn.class);

    // Log some debug info



	
    public static Result up() {
      String remote = request().remoteAddress();
        Logger.info("Signup"+ "," +remote);
      if (session().get("emailwId") != null) {
        return redirect(routes.Application.index());


      }
        return ok(signup.render(signupForm));
    }

    
    public static Result signin(){
      Logger.info("Signin");
      if (session().get("emailId") != null) {
        return redirect(routes.Application.index());
      }
       session().clear();
       return ok(signin.render(signinForm));
    }
    
  


    public static Result authenticate() {
        Form<SignIn> boundForm = signinForm.bindFromRequest();
        if(boundForm.hasErrors()){
           flash("error", "You have entered the wrong details");
            return badRequest(signin.render(boundForm));
           }
        SignIn user = boundForm.get();
        Users user1= Users.authenticate(user);
        if(user1 == null){
            flash("error", "You have entered the wrong details");
            return badRequest(signin.render(boundForm));
        }
        else{
        session().clear();
        session("emailId", boundForm.get().emailId);
    	
        return redirect(routes.Application.index());
    }
    }

    
     public static Result index(){
      if (session().get("emailId") == null) {
        return redirect(routes.Application.signin());
      }
      List<Notes> notes = Notes.findAll();
      return ok(index.render(notes));
     }

      public static Result logout(){
      session().clear();
      flash("success","You have been logged out!");
      return redirect(routes.Application.signin());
     }

   public static Result save(){
        Form<Users> boundForm = signupForm.bindFromRequest();
       
        if(boundForm.hasErrors()){
            flash("error", "You have entered the wrong details");
            return ok(signup.render(boundForm));
        }
         Users user = boundForm.get();
        user.save();
        flash("success", "Your account has been created!");
        return redirect(routes.Application.up());
        }

        
     
}
