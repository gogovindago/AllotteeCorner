package hsvp.digital.allottee_corner.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class AllottePaymentReceived2Response {


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

    public class Data {

        @SerializedName("Payment")
        @Expose
        private List<Payment> payment = new ArrayList<Payment>();
        @SerializedName("PaymentDetail")
        @Expose
        private List<PaymentDetail> paymentDetail = new ArrayList<PaymentDetail>();

        public List<Payment> getPayment() {
            return payment;
        }

        public void setPayment(List<Payment> payment) {
            this.payment = payment;
        }

        public List<PaymentDetail> getPaymentDetail() {
            return paymentDetail;
        }

        public void setPaymentDetail(List<PaymentDetail> paymentDetail) {
            this.paymentDetail = paymentDetail;
        }

    }

    public class Payment {

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

        public void setPlotId(int plotId) {
            this.plotId = plotId;
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


    public class PaymentDetail {

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
