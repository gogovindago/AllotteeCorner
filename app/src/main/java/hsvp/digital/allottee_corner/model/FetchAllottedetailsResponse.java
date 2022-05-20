package hsvp.digital.allottee_corner.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class FetchAllottedetailsResponse {

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
        @SerializedName("OriginalAllotteeName")
        @Expose
        private String originalAllotteeName;
        @SerializedName("OriginalAllotteeSurname")
        @Expose
        private String originalAllotteeSurname;
        @SerializedName("OriginalAllotteeFatherName")
        @Expose
        private String originalAllotteeFatherName;
        @SerializedName("OriginalAllotteeFatherSurname")
        @Expose
        private String originalAllotteeFatherSurname;
        @SerializedName("OriginalAllotteePermanentAddress1")
        @Expose
        private String originalAllotteePermanentAddress1;
        @SerializedName("OriginalAllotteePermanentAddress2")
        @Expose
        private String originalAllotteePermanentAddress2;
        @SerializedName("OriginalAllotteePermanentAddress3")
        @Expose
        private String originalAllotteePermanentAddress3;
        @SerializedName("OriginalAllotteePermanentState")
        @Expose
        private String originalAllotteePermanentState;
        @SerializedName("OriginalAllotteePermanentPIN")
        @Expose
        private String originalAllotteePermanentPIN;
        @SerializedName("OriginalAllotteeEmail")
        @Expose
        private String originalAllotteeEmail;
        @SerializedName("OriginalAllotteeMobileNumber")
        @Expose
        private String originalAllotteeMobileNumber;
        @SerializedName("OriginalAllotteePancard")
        @Expose
        private String originalAllotteePancard;
        @SerializedName("OriginalAllotteeAadharNumber")
        @Expose
        private String originalAllotteeAadharNumber;
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

        public String getOriginalAllotteeName() {
            return originalAllotteeName;
        }

        public void setOriginalAllotteeName(String originalAllotteeName) {
            this.originalAllotteeName = originalAllotteeName;
        }

        public String getOriginalAllotteeSurname() {
            return originalAllotteeSurname;
        }

        public void setOriginalAllotteeSurname(String originalAllotteeSurname) {
            this.originalAllotteeSurname = originalAllotteeSurname;
        }

        public String getOriginalAllotteeFatherName() {
            return originalAllotteeFatherName;
        }

        public void setOriginalAllotteeFatherName(String originalAllotteeFatherName) {
            this.originalAllotteeFatherName = originalAllotteeFatherName;
        }

        public String getOriginalAllotteeFatherSurname() {
            return originalAllotteeFatherSurname;
        }

        public void setOriginalAllotteeFatherSurname(String originalAllotteeFatherSurname) {
            this.originalAllotteeFatherSurname = originalAllotteeFatherSurname;
        }

        public String getOriginalAllotteePermanentAddress1() {
            return originalAllotteePermanentAddress1;
        }

        public void setOriginalAllotteePermanentAddress1(String originalAllotteePermanentAddress1) {
            this.originalAllotteePermanentAddress1 = originalAllotteePermanentAddress1;
        }

        public String getOriginalAllotteePermanentAddress2() {
            return originalAllotteePermanentAddress2;
        }

        public void setOriginalAllotteePermanentAddress2(String originalAllotteePermanentAddress2) {
            this.originalAllotteePermanentAddress2 = originalAllotteePermanentAddress2;
        }

        public String getOriginalAllotteePermanentAddress3() {
            return originalAllotteePermanentAddress3;
        }

        public void setOriginalAllotteePermanentAddress3(String originalAllotteePermanentAddress3) {
            this.originalAllotteePermanentAddress3 = originalAllotteePermanentAddress3;
        }

        public String getOriginalAllotteePermanentState() {
            return originalAllotteePermanentState;
        }

        public void setOriginalAllotteePermanentState(String originalAllotteePermanentState) {
            this.originalAllotteePermanentState = originalAllotteePermanentState;
        }

        public String getOriginalAllotteePermanentPIN() {
            return originalAllotteePermanentPIN;
        }

        public void setOriginalAllotteePermanentPIN(String originalAllotteePermanentPIN) {
            this.originalAllotteePermanentPIN = originalAllotteePermanentPIN;
        }

        public String getOriginalAllotteeEmail() {
            return originalAllotteeEmail;
        }

        public void setOriginalAllotteeEmail(String originalAllotteeEmail) {
            this.originalAllotteeEmail = originalAllotteeEmail;
        }

        public String getOriginalAllotteeMobileNumber() {
            return originalAllotteeMobileNumber;
        }

        public void setOriginalAllotteeMobileNumber(String originalAllotteeMobileNumber) {
            this.originalAllotteeMobileNumber = originalAllotteeMobileNumber;
        }

        public String getOriginalAllotteePancard() {
            return originalAllotteePancard;
        }

        public void setOriginalAllotteePancard(String originalAllotteePancard) {
            this.originalAllotteePancard = originalAllotteePancard;
        }

        public String getOriginalAllotteeAadharNumber() {
            return originalAllotteeAadharNumber;
        }

        public void setOriginalAllotteeAadharNumber(String originalAllotteeAadharNumber) {
            this.originalAllotteeAadharNumber = originalAllotteeAadharNumber;
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
