package hsvp.digital.allottee_corner.model;

public class YesNo {
    public int Id;
    public String yesNo;

    public YesNo(int id, String yesno) {
        Id = id;
        yesNo = yesno;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getYesNo() {
        return yesNo;
    }

    public void setYesNo(String yesNo) {
        this.yesNo = yesNo;
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
