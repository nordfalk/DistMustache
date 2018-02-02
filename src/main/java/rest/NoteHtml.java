package rest;

import data.Note;
import data.NoteDao;
import util.FileLoader;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Path("notehtml")
public class NoteHtml {
    private static NoteDao noteDao = NoteDao.instans;

    @GET
    public String getNoter() throws IOException {
        HashMap<String, Object> mustacheData = new HashMap<String, Object>();
        mustacheData.put("noter",noteDao.getNotes());
        return FileLoader.loadMustache("notehtml.mustache", mustacheData);
    }

    @POST
    public String postNote(@FormParam("note") String note, @FormParam("delete") Integer no) throws IOException {
        if(note!=null) {
            noteDao.saveNote(note);
        }
        if(no!=null){
            noteDao.deleteNote(no);
        }
        return getNoter();
    }



}
