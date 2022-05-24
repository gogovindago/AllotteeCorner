package hsvp.digital.allottee_corner.model;

public class ApplicationStatusType {
    public int Id;
    public String appStatusType;

    public ApplicationStatusType(int id, String s) {
        Id = id;
        appStatusType = s;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getappStatusType() {
        return appStatusType;
    }

    public void setappStatusType(String areaName) {
        appStatusType = areaName;
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
