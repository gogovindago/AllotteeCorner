package hsvp.digital.allottee_corner.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VerifyOTPRequestforMEMIDRequest {



    @SerializedName("DeptCode")
    @Expose
    private String deptCode;
    @SerializedName("ServiceCode")
    @Expose
    private String serviceCode;
    @SerializedName("DeptKey")
    @Expose
    private String deptKey;
    @SerializedName("MemberID")
    @Expose
    private String memberID;
    @SerializedName("Txn")
    @Expose
    private String txn;
    @SerializedName("OTP")
    @Expose
    private String otp;

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getDeptKey() {
        return deptKey;
    }

    public void setDeptKey(String deptKey) {
        this.deptKey = deptKey;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getTxn() {
        return txn;
    }

    public void setTxn(String txn) {
        this.txn = txn;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }
}
