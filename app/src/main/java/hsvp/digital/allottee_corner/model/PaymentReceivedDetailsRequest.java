package hsvp.digital.allottee_corner.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PaymentReceivedDetailsRequest {

    @SerializedName("plotID")
    @Expose
    private String plotID;

    @SerializedName("paymentID")
    @Expose
    private String paymentID;

    public String getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
    }

    public String getPlotID() {
        return plotID;
    }

    public void setPlotID(String plotID) {
        this.plotID = plotID;
    }
}
