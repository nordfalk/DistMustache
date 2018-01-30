package rest;

import data.Note;
import data.NoteDao;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("noterest")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class NoteRest {
    private static NoteDao noteDao = new NoteDao();
    static {noteDao.saveNote("test");}

    @GET
    public List<Note> getNotes(){
        return noteDao.getNotes();
    }

    @POST
    public Note saveNote(Note note){
        return noteDao.saveNote(note.getTekst());
    }

    @DELETE
    @Path("{id}")
    public boolean deleteNote(@PathParam("id") Integer id){
        return noteDao.deleteNote(id);
    }
}
