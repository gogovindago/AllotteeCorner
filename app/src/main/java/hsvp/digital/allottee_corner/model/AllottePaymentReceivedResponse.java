package hsvp.digital.allottee_corner.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class AllottePaymentReceivedResponse {

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
        @SerializedName("PaymentFlag")
        @Expose
        private String paymentFlag;
        @SerializedName("PaymentId")
        @Expose
        private int paymentId;
        @SerializedName("PaymentAmount")
        @Expose
        private float paymentAmount;
        @SerializedName("PaymentDate")
        @Expose
        private String paymentDate;
        @SerializedName("Paydate")
        @Expose
        private String paydate;
        @SerializedName("PaymentReceiptMemoNumber")
        @Expose
        private String paymentReceiptMemoNumber;

        public int getPlotId() {
            return plotId;
        }

        public String getPaymentFlag() {
            return paymentFlag;
        }

        public void setPaymentFlag(String paymentFlag) {
            this.paymentFlag = paymentFlag;
        }

        public int getPaymentId() {
            return paymentId;
        }

        public void setPaymentId(int paymentId) {
            this.paymentId = paymentId;
        }

        public float getPaymentAmount() {
            return paymentAmount;
        }

        public void setPaymentAmount(float paymentAmount) {
            this.paymentAmount = paymentAmount;
        }

        public String getPaymentDate() {
            return paymentDate;
        }

        public void setPaymentDate(String paymentDate) {
            this.paymentDate = paymentDate;
        }

        public String getPaydate() {
            return paydate;
        }

        public void setPaydate(String paydate) {
            this.paydate = paydate;
        }

        public String getPaymentReceiptMemoNumber() {
            return paymentReceiptMemoNumber;
        }

        public void setPaymentReceiptMemoNumber(String paymentReceiptMemoNumber) {
            this.paymentReceiptMemoNumber = paymentReceiptMemoNumber;
        }
    }
}
