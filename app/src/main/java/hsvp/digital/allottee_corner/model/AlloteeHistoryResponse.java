package hsvp.digital.allottee_corner.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class AlloteeHistoryResponse {

    @SerializedName("response")
    @Expose
    private int response;
    @SerializedName("sys_message")
    @Expose
    private String sysMessage;
    @SerializedName("data")
    @Expose
    private List<Datum> data = new ArrayList<Datum>();

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

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public class Datum {

        @SerializedName("Name")
        @Expose
        private String name;
        @SerializedName("PlotId")
        @Expose
        private int plotId;
        @SerializedName("OwnerId")
        @Expose
        private int ownerId;
        @SerializedName("OwnerTypeId")
        @Expose
        private int ownerTypeId;
        @SerializedName("Surname")
        @Expose
        private String surname;
        @SerializedName("PreviousOwnerName")
        @Expose
        private String previousOwnerName;
        @SerializedName("FatherName")
        @Expose
        private String fatherName;
        @SerializedName("FatherSurname")
        @Expose
        private String fatherSurname;
        @SerializedName("FatherFullName")
        @Expose
        private String fatherFullName;
        @SerializedName("Gender")
        @Expose
        private String gender;
        @SerializedName("MaritalStatus")
        @Expose
        private String maritalStatus;
        @SerializedName("DateOfSpouseDeath")
        @Expose
        private Object dateOfSpouseDeath;
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
        private Object permanentPIN;
        @SerializedName("PermanentAddress")
        @Expose
        private String permanentAddress;
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
        @SerializedName("CorrespondenceAddress")
        @Expose
        private String correspondenceAddress;
        @SerializedName("CorrespondencePIN")
        @Expose
        private Object correspondencePIN;
        @SerializedName("PreviousAllotmentDate")
        @Expose
        private String previousAllotmentDate;
        @SerializedName("PreviousReasonChange")
        @Expose
        private String previousReasonChange;
        @SerializedName("PreviousReasonChangeDesc")
        @Expose
        private String previousReasonChangeDesc;
        @SerializedName("PreviousChangeDate")
        @Expose
        private String previousChangeDate;
        @SerializedName("PreviousTransferMode")
        @Expose
        private String previousTransferMode;
        @SerializedName("PreviousTransferModeDesc")
        @Expose
        private String previousTransferModeDesc;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPlotId() {
            return plotId;
        }

        public void setPlotId(int plotId) {
            this.plotId = plotId;
        }

        public int getOwnerId() {
            return ownerId;
        }

        public void setOwnerId(int ownerId) {
            this.ownerId = ownerId;
        }

        public int getOwnerTypeId() {
            return ownerTypeId;
        }

        public void setOwnerTypeId(int ownerTypeId) {
            this.ownerTypeId = ownerTypeId;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public String getPreviousOwnerName() {
            return previousOwnerName;
        }

        public void setPreviousOwnerName(String previousOwnerName) {
            this.previousOwnerName = previousOwnerName;
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

        public String getFatherFullName() {
            return fatherFullName;
        }

        public void setFatherFullName(String fatherFullName) {
            this.fatherFullName = fatherFullName;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getMaritalStatus() {
            return maritalStatus;
        }

        public void setMaritalStatus(String maritalStatus) {
            this.maritalStatus = maritalStatus;
        }

        public Object getDateOfSpouseDeath() {
            return dateOfSpouseDeath;
        }

        public void setDateOfSpouseDeath(Object dateOfSpouseDeath) {
            this.dateOfSpouseDeath = dateOfSpouseDeath;
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

        public Object getPermanentPIN() {
            return permanentPIN;
        }

        public void setPermanentPIN(Object permanentPIN) {
            this.permanentPIN = permanentPIN;
        }

        public String getPermanentAddress() {
            return permanentAddress;
        }

        public void setPermanentAddress(String permanentAddress) {
            this.permanentAddress = permanentAddress;
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

        public String getCorrespondenceAddress() {
            return correspondenceAddress;
        }

        public void setCorrespondenceAddress(String correspondenceAddress) {
            this.correspondenceAddress = correspondenceAddress;
        }

        public Object getCorrespondencePIN() {
            return correspondencePIN;
        }

        public void setCorrespondencePIN(Object correspondencePIN) {
            this.correspondencePIN = correspondencePIN;
        }

        public String getPreviousAllotmentDate() {
            return previousAllotmentDate;
        }

        public void setPreviousAllotmentDate(String previousAllotmentDate) {
            this.previousAllotmentDate = previousAllotmentDate;
        }

        public String getPreviousReasonChange() {
            return previousReasonChange;
        }

        public void setPreviousReasonChange(String previousReasonChange) {
            this.previousReasonChange = previousReasonChange;
        }

        public String getPreviousReasonChangeDesc() {
            return previousReasonChangeDesc;
        }

        public void setPreviousReasonChangeDesc(String previousReasonChangeDesc) {
            this.previousReasonChangeDesc = previousReasonChangeDesc;
        }

        public String getPreviousChangeDate() {
            return previousChangeDate;
        }

        public void setPreviousChangeDate(String previousChangeDate) {
            this.previousChangeDate = previousChangeDate;
        }

        public String getPreviousTransferMode() {
            return previousTransferMode;
        }

        public void setPreviousTransferMode(String previousTransferMode) {
            this.previousTransferMode = previousTransferMode;
        }

        public String getPreviousTransferModeDesc() {
            return previousTransferModeDesc;
        }

        public void setPreviousTransferModeDesc(String previousTransferModeDesc) {
            this.previousTransferModeDesc = previousTransferModeDesc;
        }

    }
}
