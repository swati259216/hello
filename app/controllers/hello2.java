package controllers;

import play.Logger;
import play.mvc.Result;
import views.html.signin;

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

    public static Result signin(){
        Logger.info("Signin");
        if (session().get("emailId") != null) {
            return redirect(routes.Application.index());
        }
        session().clear();
        return ok(signin.render(signinForm));
    }

}
