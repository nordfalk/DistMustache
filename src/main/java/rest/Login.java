package rest;

import data.Note;
import util.FileLoader;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Path("login")
public class Login {

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String postLogin(@FormParam("username") String userName,
                            @FormParam("password") String password) throws IOException {
        Map<String, Object> mustacheData = new HashMap<String, Object>();
        mustacheData.put("username", userName);
        String s = FileLoader.loadMustache("loginsuccess.mustache", mustacheData);
        return s;
    }
}
