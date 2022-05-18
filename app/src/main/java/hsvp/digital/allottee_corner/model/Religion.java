package hsvp.digital.allottee_corner.model;

public class Religion {
    public int Id;
    public String ReligionName;

    public Religion(int id, String religionName) {
        Id = id;
        ReligionName = religionName;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getReligionName() {
        return ReligionName;
    }

    public void setReligionName(String religionName) {
        ReligionName = religionName;
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
