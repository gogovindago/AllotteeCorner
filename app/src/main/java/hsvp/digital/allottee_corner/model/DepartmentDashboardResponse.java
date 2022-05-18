package hsvp.digital.allottee_corner.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class DepartmentDashboardResponse {

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
        @SerializedName("rejectedAtColleges")
        @Expose
        private int rejectedAtColleges;
        @SerializedName("rejectedAtNB")
        @Expose
        private int rejectedAtNB;
        @SerializedName("rejectedAtHQ")
        @Expose
        private int rejectedAtHQ;
        @SerializedName("sentBackAtColleges")
        @Expose
        private int sentBackAtColleges;
        @SerializedName("sentBackAtNB")
        @Expose
        private int sentBackAtNB;
        @SerializedName("sentBackAtHQ")
        @Expose
        private int sentBackAtHQ;
        @SerializedName("moSJE_API_Status")
        @Expose
        private int moSJEAPIStatus;

        @SerializedName("schemeId")
        @Expose
        private int schemeId;


        public String getLastUpdated() {
            return lastUpdated;
        }

        public void setLastUpdated(String lastUpdated) {
            this.lastUpdated = lastUpdated;
        }

        public int getSchemeId() {
            return schemeId;
        }

        public void setSchemeId(int schemeId) {
            this.schemeId = schemeId;
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

        public void setPendingAtNB(int pendingAtNB) {
            this.pendingAtNB = pendingAtNB;
        }

        public int getPendingAtHQ() {
            return pendingAtHQ;
        }

        public void setPendingAtHQ(int pendingAtHQ) {
            this.pendingAtHQ = pendingAtHQ;
        }

        public int getRejectedAtColleges() {
            return rejectedAtColleges;
        }

        public void setRejectedAtColleges(int rejectedAtColleges) {
            this.rejectedAtColleges = rejectedAtColleges;
        }

        public int getRejectedAtNB() {
            return rejectedAtNB;
        }

        public void setRejectedAtNB(int rejectedAtNB) {
            this.rejectedAtNB = rejectedAtNB;
        }

        public int getRejectedAtHQ() {
            return rejectedAtHQ;
        }

        public void setRejectedAtHQ(int rejectedAtHQ) {
            this.rejectedAtHQ = rejectedAtHQ;
        }

        public int getSentBackAtColleges() {
            return sentBackAtColleges;
        }

        public void setSentBackAtColleges(int sentBackAtColleges) {
            this.sentBackAtColleges = sentBackAtColleges;
        }

        public int getSentBackAtNB() {
            return sentBackAtNB;
        }

        public void setSentBackAtNB(int sentBackAtNB) {
            this.sentBackAtNB = sentBackAtNB;
        }

        public int getSentBackAtHQ() {
            return sentBackAtHQ;
        }

        public void setSentBackAtHQ(int sentBackAtHQ) {
            this.sentBackAtHQ = sentBackAtHQ;
        }

        public int getMoSJEAPIStatus() {
            return moSJEAPIStatus;
        }

        public void setMoSJEAPIStatus(int moSJEAPIStatus) {
            this.moSJEAPIStatus = moSJEAPIStatus;
        }

    }
}
