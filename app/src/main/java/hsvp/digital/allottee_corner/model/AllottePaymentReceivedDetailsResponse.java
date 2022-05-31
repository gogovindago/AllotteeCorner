package hsvp.digital.allottee_corner.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class AllottePaymentReceivedDetailsResponse{
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

        @SerializedName("PlotId")
        @Expose
        private int plotId;
        @SerializedName("PaymentId")
        @Expose
        private int paymentId;
        @SerializedName("AdjustedPaymentAmount")
        @Expose
        private float adjustedPaymentAmount;
        @SerializedName("GLCode")
        @Expose
        private int gLCode;
        @SerializedName("AccountDescription")
        @Expose
        private String accountDescription;

        public int getPlotId() {
            return plotId;
        }

        public void setPlotId(int plotId) {
            this.plotId = plotId;
        }

        public int getPaymentId() {
            return paymentId;
        }

        public void setPaymentId(int paymentId) {
            this.paymentId = paymentId;
        }

        public float getAdjustedPaymentAmount() {
            return adjustedPaymentAmount;
        }

        public void setAdjustedPaymentAmount(float adjustedPaymentAmount) {
            this.adjustedPaymentAmount = adjustedPaymentAmount;
        }

        public int getGLCode() {
            return gLCode;
        }

        public void setGLCode(int gLCode) {
            this.gLCode = gLCode;
        }

        public String getAccountDescription() {
            return accountDescription;
        }

        public void setAccountDescription(String accountDescription) {
            this.accountDescription = accountDescription;
        }

    }
}
