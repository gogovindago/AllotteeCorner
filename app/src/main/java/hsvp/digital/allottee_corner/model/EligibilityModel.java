package hsvp.digital.allottee_corner.model;

public class EligibilityModel {

    public String Scheme;
    public  String InstituteType;
    public  String Category;
    public  String FamilyIncome;
    public  String Domicile;
    public String Attendance;
    public String SchemeDocument;
    public String GuidelineUrl;
    public int Id;

    public EligibilityModel(String scheme, String instituteType, String category, String familyIncome, String domicile, String attendance, String schemeDocument,String guidelineUrl, int id) {
        Scheme = scheme;
        InstituteType = instituteType;
        Category = category;
        FamilyIncome = familyIncome;
        Domicile = domicile;
        Attendance = attendance;
        SchemeDocument = schemeDocument;
        GuidelineUrl = guidelineUrl;
        Id = id;
    }
}
