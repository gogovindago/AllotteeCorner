package hsvp.digital.allottee_corner.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class NodalBodyDashboardResponse {

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

        @SerializedName("totalRegistration")
        @Expose
        private int totalRegistration;
        @SerializedName("totalApplication")
        @Expose
        private int totalApplication;
        @SerializedName("pendingAtCollege")
        @Expose
        private int pendingAtCollege;
        @SerializedName("sB_COllege")
        @Expose
        private int sBCOllege;
        @SerializedName("pending")
        @Expose
        private int pending;
        @SerializedName("approve")
        @Expose
        private int approve;
        @SerializedName("reject")
        @Expose
        private int reject;
        @SerializedName("sendBack")
        @Expose
        private int sendBack;
        @SerializedName("disbursement")
        @Expose
        private int disbursement;

        public int getTotalRegistration() {
            return totalRegistration;
        }

        public void setTotalRegistration(int totalRegistration) {
            this.totalRegistration = totalRegistration;
        }

        public int getTotalApplication() {
            return totalApplication;
        }

        public void setTotalApplication(int totalApplication) {
            this.totalApplication = totalApplication;
        }

        public int getPendingAtCollege() {
            return pendingAtCollege;
        }

        public void setPendingAtCollege(int pendingAtCollege) {
            this.pendingAtCollege = pendingAtCollege;
        }

        public int getsBCOllege() {
            return sBCOllege;
        }

        public void setsBCOllege(int sBCOllege) {
            this.sBCOllege = sBCOllege;
        }

        public int getPending() {
            return pending;
        }

        public void setPending(int pending) {
            this.pending = pending;
        }

        public int getApprove() {
            return approve;
        }

        public void setApprove(int approve) {
            this.approve = approve;
        }

        public int getReject() {
            return reject;
        }

        public void setReject(int reject) {
            this.reject = reject;
        }

        public int getSendBack() {
            return sendBack;
        }

        public void setSendBack(int sendBack) {
            this.sendBack = sendBack;
        }

        public int getDisbursement() {
            return disbursement;
        }

        public void setDisbursement(int disbursement) {
            this.disbursement = disbursement;
        }

    }

}
