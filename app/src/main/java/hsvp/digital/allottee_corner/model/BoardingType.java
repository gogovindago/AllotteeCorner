package hsvp.digital.allottee_corner.model;

public class BoardingType {
    public int Id;
    public String BoardingType;

    public BoardingType(int id, String boardingType) {
        Id = id;
        BoardingType = boardingType;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getBoardingType() {
        return BoardingType;
    }

    public void setBoardingType(String boardingType) {
        BoardingType = boardingType;
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
