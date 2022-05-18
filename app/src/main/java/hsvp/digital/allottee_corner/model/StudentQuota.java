package hsvp.digital.allottee_corner.model;

public class StudentQuota {
    public int Id;
    public String StudentQuota;

    public StudentQuota(int id, String studentQuota) {
        Id = id;
        StudentQuota = studentQuota;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getStudentQuota() {
        return StudentQuota;
    }

    public void setStudentQuota(String studentQuota) {
        StudentQuota = studentQuota;
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
