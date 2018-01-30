package data;

public class Note {
    private int id;
    private String tekst;

    public Note(){

    }

    public Note(int id, String tekst) {
        this.id = id;

        this.tekst = tekst;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
