package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.sql.Timestamp;


import play.db.ebean.*; 
import play.data.validation.Constraints.*;
import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.*;


public class Notes  {

public int id;
public String memo;
public String remDate;
public String remTime;
public boolean isArchive;
public boolean isTrash;

public Notes() {}

public Notes(String memo,String remDate, String remTime,boolean isArchive,boolean isTrash) {
this.memo = memo;
this.remDate = remDate;
this.remTime = remTime;
this.isArchive = isArchive;
this.isTrash = isTrash;
}


private static List<Notes> notes;
static {
notes = new ArrayList<Notes>();
notes.add(new Notes("Getting Started","","",false,false));
notes.add(new Notes("Welcome","","",false,false));

}
public static List<Notes> findAll() {
return new ArrayList<Notes>(notes);
}


}