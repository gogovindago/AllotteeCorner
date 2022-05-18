package hsvp.digital.allottee_corner.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StudentRegistrationResponse {

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
        private String fileStudentImage;
        @SerializedName("casteCategoryName")
        @Expose
        private String casteCategoryName;
        @SerializedName("familyIncome")
        @Expose
        private String familyIncome;
        @SerializedName("aadhaarNo")
        @Expose
        private String aadhaarNo;
        @SerializedName("familyID")
        @Expose
        private String familyID;
        @SerializedName("fatherFullName")
        @Expose
        private String fatherFullName;
        @SerializedName("department_Id")
        @Expose
        private String departmentId;
        @SerializedName("nodalBody_Id")
        @Expose
        private String nodalBodyId;

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

        public String getFileStudentImage() {
            return fileStudentImage;
        }

        public void setFileStudentImage(String fileStudentImage) {
            this.fileStudentImage = fileStudentImage;
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

        public String getDepartmentId() {
            return departmentId;
        }

        public void setDepartmentId(String departmentId) {
            this.departmentId = departmentId;
        }

        public String getNodalBodyId() {
            return nodalBodyId;
        }

        public void setNodalBodyId(String nodalBodyId) {
            this.nodalBodyId = nodalBodyId;
        }

    }
}
