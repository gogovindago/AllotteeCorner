package hsvp.digital.allottee_corner.model;

public class ListOfScholarshipDataModel {




    public int SchemeId;
    public String SchemeName;
    public Boolean IsschemeActive1;
    public Boolean IsschemeActive2;
    public Boolean IsschemeActive3;
    public Boolean IsschemeActive4;
    public Boolean IsschemeActive5;


    public ListOfScholarshipDataModel(int schemeId, String schemeName, Boolean isschemeActive1, Boolean isschemeActive2, Boolean isschemeActive3, Boolean isschemeActive4, Boolean isschemeActive5) {
        SchemeId = schemeId;
        SchemeName = schemeName;
        IsschemeActive1 = isschemeActive1;
        IsschemeActive2 = isschemeActive2;
        IsschemeActive3 = isschemeActive3;
        IsschemeActive4 = isschemeActive4;
        IsschemeActive5 = isschemeActive5;

    }
}
