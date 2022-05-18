package hsvp.digital.allottee_corner.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {


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

        @SerializedName("name")
        @Expose
        private String name;


        @SerializedName("casteCategoryName")
        @Expose
        private String casteCategoryName;


        @SerializedName("familyIncome")
        @Expose
        private String familyIncome;


        @SerializedName("aadhaarNo")
        @Expose
        private String aadhaarNo;


        @SerializedName("collegeId")
        @Expose
        private String collegeId;
        @SerializedName("college")
        @Expose
        private String college;
        @SerializedName("collegeCode")
        @Expose
        private String collegeCode;
        @SerializedName("studentId")
        @Expose
        private String studentId;
        @SerializedName("memberId")
        @Expose
        private String memberId;
        @SerializedName("token")
        @Expose
        private String token;
        @SerializedName("userType")
        @Expose
        private String userType;
        @SerializedName("mobileNo")
        @Expose
        private String mobileNo;
        @SerializedName("email")
        @Expose
        private String email;

        @SerializedName("file_Student_Image")
        @Expose
        private String file_Student_Image;


        @SerializedName("department_Id")
        @Expose
        private String department_Id;

        /*familyID
fatherFullName*/
        @SerializedName("familyID")
        @Expose
        private String familyID;

        @SerializedName("fatherFullName")
        @Expose
        private String fatherFullName;

  @SerializedName("nodalBody_Id")
        @Expose
        private String nodalBody_Id;

        public String getNodalBody_Id() {
            return nodalBody_Id;
        }

        public void setNodalBody_Id(String nodalBody_Id) {
            this.nodalBody_Id = nodalBody_Id;
        }

        public String getDepartment_Id() {
            return department_Id;
        }

        public void setDepartment_Id(String department_Id) {
            this.department_Id = department_Id;
        }

        public String getFamilyID() {
            return familyID;
        }

        public void setFamilyID(String familyID) {
            this.familyID = familyID;
        }

        public String getFatherFullName() {
            return fatherFullName;
        }

        public void setFatherFullName(String fatherFullName) {
            this.fatherFullName = fatherFullName;
        }

        public String getFile_Student_Image() {
            return file_Student_Image;
        }

        public void setFile_Student_Image(String file_Student_Image) {
            this.file_Student_Image = file_Student_Image;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCollegeId() {
            return collegeId;
        }

        public void setCollegeId(String collegeId) {
            this.collegeId = collegeId;
        }

        public String getCollege() {
            return college;
        }

        public void setCollege(String college) {
            this.college = college;
        }

        public String getCollegeCode() {
            return collegeCode;
        }

        public void setCollegeCode(String collegeCode) {
            this.collegeCode = collegeCode;
        }

        public String getStudentId() {
            return studentId;
        }

        public void setStudentId(String studentId) {
            this.studentId = studentId;
        }

        public String getMemberId() {
            return memberId;
        }

        public void setMemberId(String memberId) {
            this.memberId = memberId;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getUserType() {
            return userType;
        }

        public void setUserType(String userType) {
            this.userType = userType;
        }

        public String getMobileNo() {
            return mobileNo;
        }

        public void setMobileNo(String mobileNo) {
            this.mobileNo = mobileNo;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }


        public String getCasteCategoryName() {
            return casteCategoryName;
        }

        public void setCasteCategoryName(String casteCategoryName) {
            this.casteCategoryName = casteCategoryName;
        }

        public String getFamilyIncome() {
            return familyIncome;
        }

        public void setFamilyIncome(String familyIncome) {
            this.familyIncome = familyIncome;
        }

        public String getAadhaarNo() {
            return aadhaarNo;
        }

        public void setAadhaarNo(String aadhaarNo) {
            this.aadhaarNo = aadhaarNo;
        }
    }


}
