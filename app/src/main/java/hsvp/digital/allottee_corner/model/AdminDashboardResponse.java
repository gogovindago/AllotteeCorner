package hsvp.digital.allottee_corner.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class AdminDashboardResponse {
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

    public static class Datum {

        @SerializedName("lastUpdated")
        @Expose
        private String lastUpdated;



        @SerializedName("sortingOrder")
        @Expose
        private int sortingOrder;
        @SerializedName("department")
        @Expose
        private String department;
        @SerializedName("academicSession")
        @Expose
        private String academicSession;
        @SerializedName("caste")
        @Expose
        private String caste;
        @SerializedName("totalApplications")
        @Expose
        private int totalApplications;
        @SerializedName("approvedByColleges")
        @Expose
        private int approvedByColleges;
        @SerializedName("approvedByNB")
        @Expose
        private int approvedByNB;
        @SerializedName("approvedByHQ")
        @Expose
        private int approvedByHQ;
        @SerializedName("disbursement")
        @Expose
        private int disbursement;
        @SerializedName("pendingAtCollege")
        @Expose
        private int pendingAtCollege;
        @SerializedName("pendingAtNB")
        @Expose
        private int pendingAtNB;
        @SerializedName("pendingAtHQ")
        @Expose
        private int pendingAtHQ;
        @SerializedName("rejected")
        @Expose
        private int rejected;
        @SerializedName("sentBack")
        @Expose
        private int sentBack;
        @SerializedName("schemeId")
        @Expose
        private int schemeId;
        @SerializedName("moSJE_API_Status")
        @Expose
        private int moSJEAPIStatus;


        public String getLastUpdated() {
            return lastUpdated;
        }

        public void setLastUpdated(String lastUpdated) {
            this.lastUpdated = lastUpdated;
        }

        public void setPendingAtNB(int pendingAtNB) {
            this.pendingAtNB = pendingAtNB;
        }

        public int getSortingOrder() {
            return sortingOrder;
        }

        public void setSortingOrder(int sortingOrder) {
            this.sortingOrder = sortingOrder;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getAcademicSession() {
            return academicSession;
        }

        public void setAcademicSession(String academicSession) {
            this.academicSession = academicSession;
        }

        public String getCaste() {
            return caste;
        }

        public void setCaste(String caste) {
            this.caste = caste;
        }

        public int getTotalApplications() {
            return totalApplications;
        }

        public void setTotalApplications(int totalApplications) {
            this.totalApplications = totalApplications;
        }

        public int getApprovedByColleges() {
            return approvedByColleges;
        }

        public void setApprovedByColleges(int approvedByColleges) {
            this.approvedByColleges = approvedByColleges;
        }

        public int getApprovedByNB() {
            return approvedByNB;
        }

        public void setApprovedByNB(int approvedByNB) {
            this.approvedByNB = approvedByNB;
        }

        public int getApprovedByHQ() {
            return approvedByHQ;
        }

        public void setApprovedByHQ(int approvedByHQ) {
            this.approvedByHQ = approvedByHQ;
        }

        public int getDisbursement() {
            return disbursement;
        }

        public void setDisbursement(int disbursement) {
            this.disbursement = disbursement;
        }

        public int getPendingAtCollege() {
            return pendingAtCollege;
        }

        public void setPendingAtCollege(int pendingAtCollege) {
            this.pendingAtCollege = pendingAtCollege;
        }

        public int getPendingAtNB() {
            return pendingAtNB;
        }

        public int getPendingAtHQ() {
            return pendingAtHQ;
        }

        public void setPendingAtHQ(int pendingAtHQ) {
            this.pendingAtHQ = pendingAtHQ;
        }

        public int getRejected() {
            return rejected;
        }

        public void setRejected(int rejected) {
            this.rejected = rejected;
        }

        public int getSentBack() {
            return sentBack;
        }

        public void setSentBack(int sentBack) {
            this.sentBack = sentBack;
        }

        public int getSchemeId() {
            return schemeId;
        }

        public void setSchemeId(int schemeId) {
            this.schemeId = schemeId;
        }

        public int getMoSJEAPIStatus() {
            return moSJEAPIStatus;
        }

        public void setMoSJEAPIStatus(int moSJEAPIStatus) {
            this.moSJEAPIStatus = moSJEAPIStatus;
        }

    }
}
