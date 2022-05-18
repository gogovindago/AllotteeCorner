package hsvp.digital.allottee_corner.model;

public class LateralEntry {
    public int Id;
    public String LateralEntry;

    public LateralEntry(int id, String lateralEntry) {
        Id = id;
        LateralEntry = lateralEntry;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getLateralEntry() {
        return LateralEntry;
    }

    public void setLateralEntry(String lateralEntry) {
        LateralEntry = lateralEntry;
    }
/*Select
Hindu
Muslim
Christian
Sikh
Buddhist
Jain
Parsi*/
}
