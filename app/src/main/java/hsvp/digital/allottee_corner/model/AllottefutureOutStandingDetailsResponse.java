package hsvp.digital.allottee_corner.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class AllottefutureOutStandingDetailsResponse {

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

        @SerializedName("GLCod")
        @Expose
        private int gLCod;
        @SerializedName("GLDescription")
        @Expose
        private String gLDescription;
        @SerializedName("EnhancementNumber")
        @Expose
        private String enhancementNumber;
        @SerializedName("InstallmentNumber")
        @Expose
        private int installmentNumber;
        @SerializedName("DueDate")
        @Expose
        private String dueDate;
        @SerializedName("BalanceCost")
        @Expose
        private float balanceCost;
        @SerializedName("PrincipalDueAmount")
        @Expose
        private float principalDueAmount;
        @SerializedName("PossessionOrEnhancementInterestAmount")
        @Expose
        private float possessionOrEnhancementInterestAmount;
        @SerializedName("TotalAmount")
        @Expose
        private float totalAmount;

        public int getGLCod() {
            return gLCod;
        }

        public void setGLCod(int gLCod) {
            this.gLCod = gLCod;
        }

        public String getGLDescription() {
            return gLDescription;
        }

        public void setGLDescription(String gLDescription) {
            this.gLDescription = gLDescription;
        }

        public String getEnhancementNumber() {
            return enhancementNumber;
        }

        public void setEnhancementNumber(String enhancementNumber) {
            this.enhancementNumber = enhancementNumber;
        }

        public int getInstallmentNumber() {
            return installmentNumber;
        }

        public void setInstallmentNumber(int installmentNumber) {
            this.installmentNumber = installmentNumber;
        }

        public String getDueDate() {
            return dueDate;
        }

        public void setDueDate(String dueDate) {
            this.dueDate = dueDate;
        }

        public float getBalanceCost() {
            return balanceCost;
        }

        public void setBalanceCost(float balanceCost) {
            this.balanceCost = balanceCost;
        }

        public float getPrincipalDueAmount() {
            return principalDueAmount;
        }

        public void setPrincipalDueAmount(float principalDueAmount) {
            this.principalDueAmount = principalDueAmount;
        }

        public float getPossessionOrEnhancementInterestAmount() {
            return possessionOrEnhancementInterestAmount;
        }

        public void setPossessionOrEnhancementInterestAmount(float possessionOrEnhancementInterestAmount) {
            this.possessionOrEnhancementInterestAmount = possessionOrEnhancementInterestAmount;
        }

        public float getTotalAmount() {
            return totalAmount;
        }

        public void setTotalAmount(float totalAmount) {
            this.totalAmount = totalAmount;
        }

    }
}
