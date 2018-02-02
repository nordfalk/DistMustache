package data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NoteDao {

  public static final NoteDao instans = new NoteDao();
  static {instans.saveNote("test");}

    private Map<Integer, Note> noter = new HashMap<>();
    private static int nextId = 0;

    public List<Note> getNotes(){
        return new ArrayList<>(noter.values());
    }

    public Note saveNote(String note){
        int newNo = nextId++;
        Note noteObj= new Note(newNo, note);
        noter.put(newNo,noteObj);
        return noteObj;
    }

    public boolean deleteNote(Integer id){
        return (noter.remove(id)!=null);
    }


}
