package hsvp.digital.allottee_corner.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetMemberbasicdetailsfromFIDUIDRequest {

    @SerializedName("DeptCode")
    @Expose
    private String deptCode;
    @SerializedName("ServiceCode")
    @Expose
    private String serviceCode;
    @SerializedName("DeptKey")
    @Expose
    private String deptKey;
    @SerializedName("UIDFID")
    @Expose
    private String uidfid;

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

    public String getUidfid() {
        return uidfid;
    }

    public void setUidfid(String uidfid) {
        this.uidfid = uidfid;
    }



}
