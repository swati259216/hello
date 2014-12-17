package controllers;

import models.Notes;
import models.SignIn;
import models.Users;
import play.Logger;

import play.libs.F;
import play.mvc.Http;

import play.data.Form;

import play.mvc.Result;

import play.mvc.SimpleResult;
import views.html.signup;

import views.html.index;

import views.html.signin;


import java.util.List;

import static play.mvc.Results.internalServerError;
import static play.mvc.Results.notFound;

/**
 * Created by swati on 16/12/14.
 */
public class hello2 {

    private String h ="hello , there";
    private int trials=3;

    public static final Form<Users> signupForm = Form.form(Users.class);
    public static final Form<SignIn> signinForm = Form.form(SignIn.class);



    public String getH() {
        return h;
    }

    public void setH(String h) {
        this.h = h;
    }

    public int getTrials() {
        return trials;
    }

    public void setTrials(int trials) {
        this.trials = trials;

    }

    public void gt(){
        String set ="how";
    }

    public hello2(String h, int trials) {
        this.h = h;
        this.trials = trials;
    }


    public void truee(){
        
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

    public F.Promise<SimpleResult> onError(Http.RequestHeader request, Throwable t) {
        return F.Promise.<SimpleResult>pure(internalServerError(
                views.html.errorPage.render(t)
        ));
    }


}
