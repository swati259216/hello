package controllers;

import models.Notes;
import models.Users;
import play.Logger;
<<<<<<< HEAD
import play.libs.F;
import play.mvc.Http;
=======
import play.data.Form;
>>>>>>> tile
import play.mvc.Result;
<<<<<<< HEAD
<<<<<<< HEAD
import play.mvc.SimpleResult;
import views.html.signup;
=======
=======
import views.html.index;
>>>>>>> 129db90b05106ebd6ac0936892777487d052014c
import views.html.signin;
>>>>>>> 7c9e38506a5241afb82442241eafe7f10723c7f9

import java.util.List;

import static play.mvc.Results.internalServerError;
import static play.mvc.Results.notFound;

/**
 * Created by swati on 16/12/14.
 */
public class hello2 {

    private String h ="hello , there";
    private int trials=3;


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

    public F.Promise<SimpleResult> onError(Http.RequestHeader request, Throwable t) {
        return F.Promise.<SimpleResult>pure(internalServerError(
                views.html.errorPage.render(t)
        ));
    }

}
