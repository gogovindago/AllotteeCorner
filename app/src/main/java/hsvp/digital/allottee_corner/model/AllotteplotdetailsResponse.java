package hsvp.digital.allottee_corner.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class AllotteplotdetailsResponse {

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

        @SerializedName("PlotId")
        @Expose
        private int plotId;
        @SerializedName("UrbanEstateName")
        @Expose
        private String urbanEstateName;
        @SerializedName("SectorId")
        @Expose
        private String sectorId;
        @SerializedName("PlotNumber")
        @Expose
        private String plotNumber;
        @SerializedName("CategoryName")
        @Expose
        private String categoryName;
        @SerializedName("SubCategoryName")
        @Expose
        private String subCategoryName;
        @SerializedName("PlotArea")
        @Expose
        private float plotArea;
        @SerializedName("PlotStatus")
        @Expose
        private String plotStatus;
        @SerializedName("PresentOwnerName")
        @Expose
        private String presentOwnerName;
        @SerializedName("PresentOwnerSurname")
        @Expose
        private String presentOwnerSurname;
        @SerializedName("PresentOwnerFatherName")
        @Expose
        private String presentOwnerFatherName;
        @SerializedName("PresentOwnerFatherSurname")
        @Expose
        private String presentOwnerFatherSurname;
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
        @SerializedName("Email")
        @Expose
        private String email;
        @SerializedName("MobileNumber")
        @Expose
        private String mobileNumber;
        @SerializedName("Pancard")
        @Expose
        private String pancard;
        @SerializedName("AadharNumber")
        @Expose
        private String aadharNumber;

        public int getPlotId() {
            return plotId;
        }

        public void setPlotId(int plotId) {
            this.plotId = plotId;
        }

        public String getUrbanEstateName() {
            return urbanEstateName;
        }

        public void setUrbanEstateName(String urbanEstateName) {
            this.urbanEstateName = urbanEstateName;
        }

        public String getSectorId() {
            return sectorId;
        }

        public void setSectorId(String sectorId) {
            this.sectorId = sectorId;
        }

        public String getPlotNumber() {
            return plotNumber;
        }

        public void setPlotNumber(String plotNumber) {
            this.plotNumber = plotNumber;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public String getSubCategoryName() {
            return subCategoryName;
        }

        public void setSubCategoryName(String subCategoryName) {
            this.subCategoryName = subCategoryName;
        }

        public float getPlotArea() {
            return plotArea;
        }

        public void setPlotArea(float plotArea) {
            this.plotArea = plotArea;
        }

        public String getPlotStatus() {
            return plotStatus;
        }

        public void setPlotStatus(String plotStatus) {
            this.plotStatus = plotStatus;
        }

        public String getPresentOwnerName() {
            return presentOwnerName;
        }

        public void setPresentOwnerName(String presentOwnerName) {
            this.presentOwnerName = presentOwnerName;
        }

        public String getPresentOwnerSurname() {
            return presentOwnerSurname;
        }

        public void setPresentOwnerSurname(String presentOwnerSurname) {
            this.presentOwnerSurname = presentOwnerSurname;
        }

        public String getPresentOwnerFatherName() {
            return presentOwnerFatherName;
        }

        public void setPresentOwnerFatherName(String presentOwnerFatherName) {
            this.presentOwnerFatherName = presentOwnerFatherName;
        }

        public String getPresentOwnerFatherSurname() {
            return presentOwnerFatherSurname;
        }

        public void setPresentOwnerFatherSurname(String presentOwnerFatherSurname) {
            this.presentOwnerFatherSurname = presentOwnerFatherSurname;
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

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getMobileNumber() {
            return mobileNumber;
        }

        public void setMobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
        }

        public String getPancard() {
            return pancard;
        }

        public void setPancard(String pancard) {
            this.pancard = pancard;
        }

        public String getAadharNumber() {
            return aadharNumber;
        }

        public void setAadharNumber(String aadharNumber) {
            this.aadharNumber = aadharNumber;
        }

    }

}
