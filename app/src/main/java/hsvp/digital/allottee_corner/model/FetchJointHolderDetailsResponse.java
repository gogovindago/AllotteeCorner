package hsvp.digital.allottee_corner.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class FetchJointHolderDetailsResponse {
    @SerializedName("response")
    @Expose
    private int response;
    @SerializedName("sys_message")
    @Expose
    private String sysMessage;
    @SerializedName("data")
    @Expose
    private Data data;

    public int getResponse() {
        return response;
    }

    public void setResponse(int response) {
        this.response = response;
    }

    public String getSysMessage() {
        return sysMessage;
    }

    public void setSysMessage(String sysMessage) {
        this.sysMessage = sysMessage;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }


    public class JHolder {

        @SerializedName("PlotId")
        @Expose
        private int plotId;
        @SerializedName("OwnerID")
        @Expose
        private int ownerID;
        @SerializedName("NumberOfOwners")
        @Expose
        private int numberOfOwners;
        @SerializedName("OwnerType")
        @Expose
        private String ownerType;
        @SerializedName("Name")
        @Expose
        private String name;
        @SerializedName("Surname")
        @Expose
        private String surname;
        @SerializedName("FatherName")
        @Expose
        private String fatherName;
        @SerializedName("FatherSurname")
        @Expose
        private String fatherSurname;
        @SerializedName("PermanentAddress1")
        @Expose
        private String permanentAddress1;
        @SerializedName("PermanentAddress2")
        @Expose
        private String permanentAddress2;
        @SerializedName("PermanentAddress3")
        @Expose
        private String permanentAddress3;
        @SerializedName("PermanentState")
        @Expose
        private String permanentState;
        @SerializedName("PermanentPIN")
        @Expose
        private String permanentPIN;
        @SerializedName("CorrespondenceAddress1")
        @Expose
        private String correspondenceAddress1;
        @SerializedName("CorrespondenceAddress2")
        @Expose
        private String correspondenceAddress2;
        @SerializedName("CorrespondenceAddress3")
        @Expose
        private String correspondenceAddress3;
        @SerializedName("CorrespondenceState")
        @Expose
        private String correspondenceState;
        @SerializedName("CorrespondencePIN")
        @Expose
        private String correspondencePIN;
        @SerializedName("MobileNumber")
        @Expose
        private String mobileNumber;
        @SerializedName("EmailID")
        @Expose
        private String emailID;
        @SerializedName("PANNo")
        @Expose
        private String pANNo;
        @SerializedName("OCI_AadharNumber")
        @Expose
        private String oCIAadharNumber;

        public int getPlotId() {
            return plotId;
        }

        public void setPlotId(int plotId) {
            this.plotId = plotId;
        }

        public int getOwnerID() {
            return ownerID;
        }

        public void setOwnerID(int ownerID) {
            this.ownerID = ownerID;
        }

        public int getNumberOfOwners() {
            return numberOfOwners;
        }

        public void setNumberOfOwners(int numberOfOwners) {
            this.numberOfOwners = numberOfOwners;
        }

        public String getOwnerType() {
            return ownerType;
        }

        public void setOwnerType(String ownerType) {
            this.ownerType = ownerType;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public String getFatherName() {
            return fatherName;
        }

        public void setFatherName(String fatherName) {
            this.fatherName = fatherName;
        }

        public String getFatherSurname() {
            return fatherSurname;
        }

        public void setFatherSurname(String fatherSurname) {
            this.fatherSurname = fatherSurname;
        }

        public String getPermanentAddress1() {
            return permanentAddress1;
        }

        public void setPermanentAddress1(String permanentAddress1) {
            this.permanentAddress1 = permanentAddress1;
        }

        public String getPermanentAddress2() {
            return permanentAddress2;
        }

        public void setPermanentAddress2(String permanentAddress2) {
            this.permanentAddress2 = permanentAddress2;
        }

        public String getPermanentAddress3() {
            return permanentAddress3;
        }

        public void setPermanentAddress3(String permanentAddress3) {
            this.permanentAddress3 = permanentAddress3;
        }

        public String getPermanentState() {
            return permanentState;
        }

        public void setPermanentState(String permanentState) {
            this.permanentState = permanentState;
        }

        public String getPermanentPIN() {
            return permanentPIN;
        }

        public void setPermanentPIN(String permanentPIN) {
            this.permanentPIN = permanentPIN;
        }

        public String getCorrespondenceAddress1() {
            return correspondenceAddress1;
        }

        public void setCorrespondenceAddress1(String correspondenceAddress1) {
            this.correspondenceAddress1 = correspondenceAddress1;
        }

        public String getCorrespondenceAddress2() {
            return correspondenceAddress2;
        }

        public void setCorrespondenceAddress2(String correspondenceAddress2) {
            this.correspondenceAddress2 = correspondenceAddress2;
        }

        public String getCorrespondenceAddress3() {
            return correspondenceAddress3;
        }

        public void setCorrespondenceAddress3(String correspondenceAddress3) {
            this.correspondenceAddress3 = correspondenceAddress3;
        }

        public String getCorrespondenceState() {
            return correspondenceState;
        }

        public void setCorrespondenceState(String correspondenceState) {
            this.correspondenceState = correspondenceState;
        }

        public String getCorrespondencePIN() {
            return correspondencePIN;
        }

        public void setCorrespondencePIN(String correspondencePIN) {
            this.correspondencePIN = correspondencePIN;
        }

        public String getMobileNumber() {
            return mobileNumber;
        }

        public void setMobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
        }

        public String getEmailID() {
            return emailID;
        }

        public void setEmailID(String emailID) {
            this.emailID = emailID;
        }

        public String getPANNo() {
            return pANNo;
        }

        public void setPANNo(String pANNo) {
            this.pANNo = pANNo;
        }

        public String getOCIAadharNumber() {
            return oCIAadharNumber;
        }

        public void setOCIAadharNumber(String oCIAadharNumber) {
            this.oCIAadharNumber = oCIAadharNumber;
        }
    }
    public class Gpa {

        @SerializedName("PlotId")
        @Expose
        private int plotId;
        @SerializedName("OwnerID")
        @Expose
        private int ownerID;
        @SerializedName("NumberOfOwners")
        @Expose
        private int numberOfOwners;
        @SerializedName("OwnerType")
        @Expose
        private String ownerType;
        @SerializedName("Name")
        @Expose
        private String name;
        @SerializedName("Surname")
        @Expose
        private String surname;
        @SerializedName("FatherName")
        @Expose
        private String fatherName;
        @SerializedName("FatherSurname")
        @Expose
        private String fatherSurname;
        @SerializedName("PermanentAddress1")
        @Expose
        private String permanentAddress1;
        @SerializedName("PermanentAddress2")
        @Expose
        private String permanentAddress2;
        @SerializedName("PermanentAddress3")
        @Expose
        private String permanentAddress3;
        @SerializedName("PermanentState")
        @Expose
        private String permanentState;
        @SerializedName("PermanentPIN")
        @Expose
        private int permanentPIN;
        @SerializedName("CorrespondenceAddress1")
        @Expose
        private String correspondenceAddress1;
        @SerializedName("CorrespondenceAddress2")
        @Expose
        private String correspondenceAddress2;
        @SerializedName("CorrespondenceAddress3")
        @Expose
        private String correspondenceAddress3;
        @SerializedName("CorrespondenceState")
        @Expose
        private String correspondenceState;
        @SerializedName("CorrespondencePIN")
        @Expose
        private int correspondencePIN;
        @SerializedName("MobileNumber")
        @Expose
        private String mobileNumber;
        @SerializedName("EmailID")
        @Expose
        private String emailID;
        @SerializedName("PANNo")
        @Expose
        private String pANNo;
        @SerializedName("OCI_AadharNumber")
        @Expose
        private String oCIAadharNumber;

        public int getPlotId() {
            return plotId;
        }

        public void setPlotId(int plotId) {
            this.plotId = plotId;
        }

        public int getOwnerID() {
            return ownerID;
        }

        public void setOwnerID(int ownerID) {
            this.ownerID = ownerID;
        }

        public int getNumberOfOwners() {
            return numberOfOwners;
        }

        public void setNumberOfOwners(int numberOfOwners) {
            this.numberOfOwners = numberOfOwners;
        }

        public String getOwnerType() {
            return ownerType;
        }

        public void setOwnerType(String ownerType) {
            this.ownerType = ownerType;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public String getFatherName() {
            return fatherName;
        }

        public void setFatherName(String fatherName) {
            this.fatherName = fatherName;
        }

        public String getFatherSurname() {
            return fatherSurname;
        }

        public void setFatherSurname(String fatherSurname) {
            this.fatherSurname = fatherSurname;
        }

        public String getPermanentAddress1() {
            return permanentAddress1;
        }

        public void setPermanentAddress1(String permanentAddress1) {
            this.permanentAddress1 = permanentAddress1;
        }

        public String getPermanentAddress2() {
            return permanentAddress2;
        }

        public void setPermanentAddress2(String permanentAddress2) {
            this.permanentAddress2 = permanentAddress2;
        }

        public String getPermanentAddress3() {
            return permanentAddress3;
        }

        public void setPermanentAddress3(String permanentAddress3) {
            this.permanentAddress3 = permanentAddress3;
        }

        public String getPermanentState() {
            return permanentState;
        }

        public void setPermanentState(String permanentState) {
            this.permanentState = permanentState;
        }

        public int getPermanentPIN() {
            return permanentPIN;
        }

        public void setPermanentPIN(int permanentPIN) {
            this.permanentPIN = permanentPIN;
        }

        public String getCorrespondenceAddress1() {
            return correspondenceAddress1;
        }

        public void setCorrespondenceAddress1(String correspondenceAddress1) {
            this.correspondenceAddress1 = correspondenceAddress1;
        }

        public String getCorrespondenceAddress2() {
            return correspondenceAddress2;
        }

        public void setCorrespondenceAddress2(String correspondenceAddress2) {
            this.correspondenceAddress2 = correspondenceAddress2;
        }

        public String getCorrespondenceAddress3() {
            return correspondenceAddress3;
        }

        public void setCorrespondenceAddress3(String correspondenceAddress3) {
            this.correspondenceAddress3 = correspondenceAddress3;
        }

        public String getCorrespondenceState() {
            return correspondenceState;
        }

        public void setCorrespondenceState(String correspondenceState) {
            this.correspondenceState = correspondenceState;
        }

        public int getCorrespondencePIN() {
            return correspondencePIN;
        }

        public void setCorrespondencePIN(int correspondencePIN) {
            this.correspondencePIN = correspondencePIN;
        }

        public String getMobileNumber() {
            return mobileNumber;
        }

        public void setMobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
        }

        public String getEmailID() {
            return emailID;
        }

        public void setEmailID(String emailID) {
            this.emailID = emailID;
        }

        public String getPANNo() {
            return pANNo;
        }

        public void setPANNo(String pANNo) {
            this.pANNo = pANNo;
        }

        public String getOCIAadharNumber() {
            return oCIAadharNumber;
        }

        public void setOCIAadharNumber(String oCIAadharNumber) {
            this.oCIAadharNumber = oCIAadharNumber;
        }

    }



        public class Data {

            @SerializedName("JHolder")
            @Expose
            private List<JHolder> jHolder = new ArrayList<JHolder>();
            @SerializedName("GPA")
            @Expose
            private List<Gpa> gpa = new ArrayList<Gpa>();

            public List<JHolder> getJHolder() {
                return jHolder;
            }

            public void setJHolder(List<JHolder> jHolder) {
                this.jHolder = jHolder;
            }

            public List<Gpa> getGpa() {
                return gpa;
            }

            public void setGpa(List<Gpa> gpa) {
                this.gpa = gpa;
            }

        }

}


