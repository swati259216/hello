package models;

import java.util.ArrayList;
import java.util.List;

import play.data.validation.Constraints.*;

public class SignIn  {
	
	@Required
	public String emailId;
	@Required
	public String password;
	
public SignIn(){}


public SignIn( String emailId, String password) {

this.emailId = emailId;
this.password = password;

}



}

