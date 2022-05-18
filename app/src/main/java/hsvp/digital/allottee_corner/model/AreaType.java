package hsvp.digital.allottee_corner.model;

public class AreaType {
    public int Id;
    public String AreaName;

    public AreaType(int id, String areaName) {
        Id = id;
        AreaName = areaName;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getAreaName() {
        return AreaName;
    }

    public void setAreaName(String areaName) {
        AreaName = areaName;
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
