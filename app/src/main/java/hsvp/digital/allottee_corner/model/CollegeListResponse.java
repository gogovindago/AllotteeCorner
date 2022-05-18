package hsvp.digital.allottee_corner.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class CollegeListResponse {

    @SerializedName("response")
    @Expose
    private long response;
    @SerializedName("sys_message")
    @Expose
    private String sysMessage;
    @SerializedName("data")
    @Expose
    private List<Datum> data = new ArrayList<Datum>();

    public long getResponse() {
        return response;
    }

    public void setResponse(long response) {
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

        @SerializedName("college_Id")
        @Expose
        private long collegeId;
        @SerializedName("department_Id")
        @Expose
        private long departmentId;
        @SerializedName("department")
        @Expose
        private String department;
        @SerializedName("district_Id")
        @Expose
        private String districtId;
        @SerializedName("district")
        @Expose
        private String district;
        @SerializedName("college")
        @Expose
        private String college;
        @SerializedName("collegeCode")
        @Expose
        private long collegeCode;
        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("category")
        @Expose
        private String category;
        @SerializedName("affiliationBody")
        @Expose
        private String affiliationBody;
        @SerializedName("affiliationBody2")
        @Expose
        private String affiliationBody2;
        @SerializedName("isActive")
        @Expose
        private String isActive;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("college_Status")
        @Expose
        private String collegeStatus;

        public long getCollegeId() {
            return collegeId;
        }

        public void setCollegeId(long collegeId) {
            this.collegeId = collegeId;
        }

        public long getDepartmentId() {
            return departmentId;
        }

        public void setDepartmentId(long departmentId) {
            this.departmentId = departmentId;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getDistrictId() {
            return districtId;
        }

        public void setDistrictId(String districtId) {
            this.districtId = districtId;
        }

        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

        public String getCollege() {
            return college;
        }

        public void setCollege(String college) {
            this.college = college;
        }

        public long getCollegeCode() {
            return collegeCode;
        }

        public void setCollegeCode(long collegeCode) {
            this.collegeCode = collegeCode;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getAffiliationBody() {
            return affiliationBody;
        }

        public void setAffiliationBody(String affiliationBody) {
            this.affiliationBody = affiliationBody;
        }

        public String getAffiliationBody2() {
            return affiliationBody2;
        }

        public void setAffiliationBody2(String affiliationBody2) {
            this.affiliationBody2 = affiliationBody2;
        }

        public String getIsActive() {
            return isActive;
        }

        public void setIsActive(String isActive) {
            this.isActive = isActive;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCollegeStatus() {
            return collegeStatus;
        }

        public void setCollegeStatus(String collegeStatus) {
            this.collegeStatus = collegeStatus;
        }

    }

}
