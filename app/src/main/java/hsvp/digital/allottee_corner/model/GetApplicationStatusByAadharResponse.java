package hsvp.digital.allottee_corner.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetApplicationStatusByAadharResponse {
    @SerializedName("response")
    @Expose
    private int response;
    @SerializedName("sys_message")
    @Expose
    private String sysMessage;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

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

        @SerializedName("fullName")
        @Expose
        private String fullName;
        @SerializedName("fatherFullName")
        @Expose
        private String fatherFullName;
        @SerializedName("familyID")
        @Expose
        private String familyID;
        @SerializedName("memberID")
        @Expose
        private String memberID;
        @SerializedName("aadhaarNo")
        @Expose
        private String aadhaarNo;
        @SerializedName("casteCategoryName")
        @Expose
        private String casteCategoryName;
        @SerializedName("college")
        @Expose
        private String college;
        @SerializedName("courseName")
        @Expose
        private String courseName;
        @SerializedName("year")
        @Expose
        private String year;
        @SerializedName("application_Id")
        @Expose
        private int applicationId;
        @SerializedName("academicSession")
        @Expose
        private String academicSession;
        @SerializedName("appliedOn")
        @Expose
        private String appliedOn;
        @SerializedName("rR_No")
        @Expose
        private String rRNo;
        @SerializedName("attendance")
        @Expose
        private int attendance;
        @SerializedName("collegeStatus")
        @Expose
        private String collegeStatus;
        @SerializedName("collegeStatusDate")
        @Expose
        private String collegeStatusDate;
        @SerializedName("collegeRemarks")
        @Expose
        private String collegeRemarks;
        @SerializedName("nodalBody_Status")
        @Expose
        private String nodalBodyStatus;
        @SerializedName("nodalBody_StatusDate")
        @Expose
        private String nodalBodyStatusDate;
        @SerializedName("nodalBody_Remarks")
        @Expose
        private String nodalBodyRemarks;
        @SerializedName("hQ_Status")
        @Expose
        private String hQStatus;
        @SerializedName("hQ_StatusDate")
        @Expose
        private String hQStatusDate;
        @SerializedName("hQ_Remarks")
        @Expose
        private String hQRemarks;
        @SerializedName("isScholarshipDisbursed")
        @Expose
        private String isScholarshipDisbursed;
        @SerializedName("transactionNo")
        @Expose
        private String transactionNo;
        @SerializedName("amountDisbursed")
        @Expose
        private String amountDisbursed;
        @SerializedName("transactionDate")
        @Expose
        private String transactionDate;

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getFatherFullName() {
            return fatherFullName;
        }

        public void setFatherFullName(String fatherFullName) {
            this.fatherFullName = fatherFullName;
        }

        public String getFamilyID() {
            return familyID;
        }

        public void setFamilyID(String familyID) {
            this.familyID = familyID;
        }

        public String getMemberID() {
            return memberID;
        }

        public void setMemberID(String memberID) {
            this.memberID = memberID;
        }

        public String getAadhaarNo() {
            return aadhaarNo;
        }

        public void setAadhaarNo(String aadhaarNo) {
            this.aadhaarNo = aadhaarNo;
        }

        public String getCasteCategoryName() {
            return casteCategoryName;
        }

        public void setCasteCategoryName(String casteCategoryName) {
            this.casteCategoryName = casteCategoryName;
        }

        public String getCollege() {
            return college;
        }

        public void setCollege(String college) {
            this.college = college;
        }

        public String getCourseName() {
            return courseName;
        }

        public void setCourseName(String courseName) {
            this.courseName = courseName;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public int getApplicationId() {
            return applicationId;
        }

        public void setApplicationId(int applicationId) {
            this.applicationId = applicationId;
        }

        public String getAcademicSession() {
            return academicSession;
        }

        public void setAcademicSession(String academicSession) {
            this.academicSession = academicSession;
        }

        public String getAppliedOn() {
            return appliedOn;
        }

        public void setAppliedOn(String appliedOn) {
            this.appliedOn = appliedOn;
        }

        public String getrRNo() {
            return rRNo;
        }

        public void setrRNo(String rRNo) {
            this.rRNo = rRNo;
        }

        public int getAttendance() {
            return attendance;
        }

        public void setAttendance(int attendance) {
            this.attendance = attendance;
        }

        public String getCollegeStatus() {
            return collegeStatus;
        }

        public void setCollegeStatus(String collegeStatus) {
            this.collegeStatus = collegeStatus;
        }

        public String getCollegeStatusDate() {
            return collegeStatusDate;
        }

        public void setCollegeStatusDate(String collegeStatusDate) {
            this.collegeStatusDate = collegeStatusDate;
        }

        public String getCollegeRemarks() {
            return collegeRemarks;
        }

        public void setCollegeRemarks(String collegeRemarks) {
            this.collegeRemarks = collegeRemarks;
        }

        public String getNodalBodyStatus() {
            return nodalBodyStatus;
        }

        public void setNodalBodyStatus(String nodalBodyStatus) {
            this.nodalBodyStatus = nodalBodyStatus;
        }

        public String getNodalBodyStatusDate() {
            return nodalBodyStatusDate;
        }

        public void setNodalBodyStatusDate(String nodalBodyStatusDate) {
            this.nodalBodyStatusDate = nodalBodyStatusDate;
        }

        public String getNodalBodyRemarks() {
            return nodalBodyRemarks;
        }

        public void setNodalBodyRemarks(String nodalBodyRemarks) {
            this.nodalBodyRemarks = nodalBodyRemarks;
        }

        public String gethQStatus() {
            return hQStatus;
        }

        public void sethQStatus(String hQStatus) {
            this.hQStatus = hQStatus;
        }

        public String gethQStatusDate() {
            return hQStatusDate;
        }

        public void sethQStatusDate(String hQStatusDate) {
            this.hQStatusDate = hQStatusDate;
        }

        public String gethQRemarks() {
            return hQRemarks;
        }

        public void sethQRemarks(String hQRemarks) {
            this.hQRemarks = hQRemarks;
        }

        public String getIsScholarshipDisbursed() {
            return isScholarshipDisbursed;
        }

        public void setIsScholarshipDisbursed(String isScholarshipDisbursed) {
            this.isScholarshipDisbursed = isScholarshipDisbursed;
        }

        public String getTransactionNo() {
            return transactionNo;
        }

        public void setTransactionNo(String transactionNo) {
            this.transactionNo = transactionNo;
        }

        public String getAmountDisbursed() {
            return amountDisbursed;
        }

        public void setAmountDisbursed(String amountDisbursed) {
            this.amountDisbursed = amountDisbursed;
        }

        public String getTransactionDate() {
            return transactionDate;
        }

        public void setTransactionDate(String transactionDate) {
            this.transactionDate = transactionDate;
        }

    }
}
