package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.sql.Timestamp;


import play.db.ebean.*; 
import play.data.validation.Constraints.*;
import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.*;


 @Entity
 public class Users extends Model {

	@Id
	public int id;

  @Required
	@MinLength(4)
	public String firstName;
  
  @Required
  @MinLength(4) 
	public String lastName;

	@Required
	@Column(unique=true)
  @Email
	public String emailId;

	@Required
  @Pattern(value="^[a-zA-Z0-9!#@\\$%\\^&\\*\\(\\):;\"'<>\\.\\?~]{6,}$")
	public String password;

  
  
	public  Date createdAt ;
  
  public Date updatedAt;


	
//public Users(){}
//
//
//
//public Users(int id , String firstName, String lastName, String emailId, String password) {
//this.id = id;
//this.firstName = firstName;
//this.lastName = lastName;
//this.emailId = emailId;
//this.password = password;
//
//}

//public static void create(Users user) {
//
//    user.password = BCrypt.hashpw(user.password, BCrypt.gensalt());
//    user.save();
//  }

 public static Users authenticate(SignIn user) {
 	Finder<Long,Users> find = new Finder(
	Long.class , Users.class
	);
    Users user1 = find.where().eq("emailId", user.emailId).findUnique();
    if(user1 ==null){
      return user1;
    }
    else if (user1 != null && BCrypt.checkpw(user.password, user1.password)) {

      return user1;
    } 
    else {
      return null;
    }
  }
  


}
