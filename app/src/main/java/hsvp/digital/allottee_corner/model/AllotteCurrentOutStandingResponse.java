package hsvp.digital.allottee_corner.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class AllotteCurrentOutStandingResponse {

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

        @SerializedName("Particular")
        @Expose
        private String Particular;
        @SerializedName("amount")
        @Expose
        private float amount;

        public String getParticular() {
            return Particular;
        }

        public void setParticular(String Particular) {
            this.Particular = Particular;
        }

        public float getAmount() {
            return amount;
        }

        public void setAmount(float amount) {
            this.amount = amount;
        }

    }

}
