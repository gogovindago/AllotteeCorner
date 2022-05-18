package hsvp.digital.allottee_corner.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class CheckApplicationExistResponse {
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

        @SerializedName("output")
        @Expose
        private int output;
        @SerializedName("collegeStatus")
        @Expose
        private String collegeStatus;
        @SerializedName("edit")
        @Expose
        private List<Edit> edit = new ArrayList<Edit>();

        public int getOutput() {
            return output;
        }

        public void setOutput(int output) {
            this.output = output;
        }

        public String getCollegeStatus() {
            return collegeStatus;
        }

        public void setCollegeStatus(String collegeStatus) {
            this.collegeStatus = collegeStatus;
        }

        public List<Edit> getEdit() {
            return edit;
        }

        public void setEdit(List<Edit> edit) {
            this.edit = edit;
        }

    }

    public class Edit {

        @SerializedName("student_Id")
        @Expose
        private int studentId;
        @SerializedName("familyID")
        @Expose
        private String familyID;
        @SerializedName("memberID")
        @Expose
        private String memberID;
        @SerializedName("firstName")
        @Expose
        private String firstName;
        @SerializedName("lastName")
        @Expose
        private String lastName;
        @SerializedName("fullName")
        @Expose
        private String fullName;
        @SerializedName("fatherFullName")
        @Expose
        private String fatherFullName;
        @SerializedName("motherFullName")
        @Expose
        private String motherFullName;
        @SerializedName("gender")
        @Expose
        private String gender;
        @SerializedName("houseNo")
        @Expose
        private String houseNo;
        @SerializedName("streetNo")
        @Expose
        private String streetNo;
        @SerializedName("address_LandMark")
        @Expose
        private String addressLandMark;
        @SerializedName("pinCode")
        @Expose
        private String pinCode;
        @SerializedName("districtName")
        @Expose
        private String districtName;
        @SerializedName("aadhaarNo")
        @Expose
        private String aadhaarNo;
        @SerializedName("dob")
        @Expose
        private String dob;
        @SerializedName("mobileNo")
        @Expose
        private String mobileNo;
        @SerializedName("casteCategory")
        @Expose
        private String casteCategory;
        @SerializedName("familyIncome")
        @Expose
        private int familyIncome;
        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("bpl")
        @Expose
        private String bpl;
        @SerializedName("bplCardNO")
        @Expose
        private String bplCardNO;
        @SerializedName("casteCategoryName")
        @Expose
        private String casteCategoryName;
        @SerializedName("academicSession")
        @Expose
        private String academicSession;
        @SerializedName("college_Id")
        @Expose
        private int collegeId;
        @SerializedName("college")
        @Expose
        private String college;
        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("collegeCategory")
        @Expose
        private String collegeCategory;
        @SerializedName("district_Id")
        @Expose
        private String districtId;
        @SerializedName("district")
        @Expose
        private String district;
        @SerializedName("department_Id")
        @Expose
        private int departmentId;
        @SerializedName("isOutsideHaryana")
        @Expose
        private String isOutsideHaryana;
        @SerializedName("course_Id")
        @Expose
        private int courseId;
        @SerializedName("courseName")
        @Expose
        private String courseName;
        @SerializedName("courseCategory")
        @Expose
        private String courseCategory;
        @SerializedName("year")
        @Expose
        private String year;
        @SerializedName("collegeRollNo")
        @Expose
        private String collegeRollNo;
        @SerializedName("isDenotifiedTribe")
        @Expose
        private String isDenotifiedTribe;
        @SerializedName("universityRollNo")
        @Expose
        private String universityRollNo;
        @SerializedName("admissionDate")
        @Expose
        private String admissionDate;
        @SerializedName("areaType")
        @Expose
        private String areaType;
        @SerializedName("boardingType")
        @Expose
        private String boardingType;
        @SerializedName("appliedOn")
        @Expose
        private String appliedOn;
        @SerializedName("rR_No")
        @Expose
        private String rRNo;
        @SerializedName("attendance")
        @Expose
        private int attendance;
        @SerializedName("maintenanceRate")
        @Expose
        private int maintenanceRate;
        @SerializedName("maintenanceMonth")
        @Expose
        private int maintenanceMonth;
        @SerializedName("totalMaintenance")
        @Expose
        private int totalMaintenance;
        @SerializedName("courseFee")
        @Expose
        private int courseFee;
        @SerializedName("courseFeeReimburse")
        @Expose
        private int courseFeeReimburse;
        @SerializedName("otherComponentAmount")
        @Expose
        private int otherComponentAmount;
        @SerializedName("scholarshipAmount")
        @Expose
        private int scholarshipAmount;
        @SerializedName("nB_MaintenanceRate")
        @Expose
        private int nBMaintenanceRate;
        @SerializedName("nB_MaintenanceMonth")
        @Expose
        private int nBMaintenanceMonth;
        @SerializedName("nB_TotalMaintenance")
        @Expose
        private int nBTotalMaintenance;
        @SerializedName("nB_CourseFee")
        @Expose
        private int nBCourseFee;
        @SerializedName("nB_CourseFeeReimburse")
        @Expose
        private int nBCourseFeeReimburse;
        @SerializedName("nB_OtherComponentAmount")
        @Expose
        private int nBOtherComponentAmount;
        @SerializedName("nB_ScholarshipAmount")
        @Expose
        private int nBScholarshipAmount;
        @SerializedName("hQ_MaintenanceRate")
        @Expose
        private int hQMaintenanceRate;
        @SerializedName("hQ_MaintenanceMonth")
        @Expose
        private int hQMaintenanceMonth;
        @SerializedName("hQ_TotalMaintenance")
        @Expose
        private int hQTotalMaintenance;
        @SerializedName("hQ_CourseFee")
        @Expose
        private int hQCourseFee;
        @SerializedName("hQ_CourseFeeReimburse")
        @Expose
        private int hQCourseFeeReimburse;
        @SerializedName("hQ_OtherComponentAmount")
        @Expose
        private int hQOtherComponentAmount;
        @SerializedName("hQ_ScholarshipAmount")
        @Expose
        private int hQScholarshipAmount;
        @SerializedName("collegeStatus")
        @Expose
        private String collegeStatus;
        @SerializedName("collegeStatusDate")
        @Expose
        private String collegeStatusDate;
        @SerializedName("collegeRemarks")
        @Expose
        private String collegeRemarks;
        @SerializedName("collegeDDO")
        @Expose
        private String collegeDDO;
        @SerializedName("nodalBody_Status")
        @Expose
        private String nodalBodyStatus;
        @SerializedName("nodalBody_StatusDate")
        @Expose
        private String nodalBodyStatusDate;
        @SerializedName("nodalBody_Remarks")
        @Expose
        private String nodalBodyRemarks;
        @SerializedName("nodalBody_DDO")
        @Expose
        private String nodalBodyDDO;
        @SerializedName("hQ_Status")
        @Expose
        private String hQStatus;
        @SerializedName("hQ_StatusDate")
        @Expose
        private String hQStatusDate;
        @SerializedName("hQ_Remarks")
        @Expose
        private String hQRemarks;
        @SerializedName("hQ_DDO")
        @Expose
        private String hQDDO;
        @SerializedName("moSJE_API_Status")
        @Expose
        private String moSJEAPIStatus;
        @SerializedName("file_Student_Image")
        @Expose
        private String fileStudentImage;
        @SerializedName("file_Student_Signature")
        @Expose
        private String fileStudentSignature;
        @SerializedName("file_Aadhar_Copy_Path")
        @Expose
        private String fileAadharCopyPath;
        @SerializedName("file_Aadhar_Copy_ContentType")
        @Expose
        private String fileAadharCopyContentType;
        @SerializedName("file_Income_Certificate_Path")
        @Expose
        private String fileIncomeCertificatePath;
        @SerializedName("file_Income_Certificate_ContentType")
        @Expose
        private String fileIncomeCertificateContentType;
        @SerializedName("file_Caste_Certificate_Path")
        @Expose
        private String fileCasteCertificatePath;
        @SerializedName("file_Caste_Certificate_ContentType")
        @Expose
        private String fileCasteCertificateContentType;
        @SerializedName("file_Hostel_Certificate_Path")
        @Expose
        private String fileHostelCertificatePath;
        @SerializedName("file_Hostel_Certificate_ContentType")
        @Expose
        private String fileHostelCertificateContentType;
        @SerializedName("file_10_DMC_Path")
        @Expose
        private String file10DMCPath;
        @SerializedName("file_10_DMC_ContentType")
        @Expose
        private String file10DMCContentType;
        @SerializedName("file_12_DMC_Path")
        @Expose
        private String file12DMCPath;
        @SerializedName("file_12_DMC_ContentType")
        @Expose
        private String file12DMCContentType;
        @SerializedName("file_Last_Exam_Passed_DMC_Path")
        @Expose
        private String fileLastExamPassedDMCPath;
        @SerializedName("file_Last_Exam_Passed_DMC_ContentType")
        @Expose
        private String fileLastExamPassedDMCContentType;
        @SerializedName("file_Fee_Receipt_Copy_Path")
        @Expose
        private String fileFeeReceiptCopyPath;
        @SerializedName("file_Fee_Receipt_Copy_ContentType")
        @Expose
        private String fileFeeReceiptCopyContentType;
        @SerializedName("file_Father_Death_Certificate_Path")
        @Expose
        private String fileFatherDeathCertificatePath;
        @SerializedName("file_Father_Death_Certificate_ContentType")
        @Expose
        private String fileFatherDeathCertificateContentType;
        @SerializedName("file_BPL_Certificate_Path")
        @Expose
        private String fileBPLCertificatePath;
        @SerializedName("file_BPL_Certificate_ContentType")
        @Expose
        private String fileBPLCertificateContentType;
        @SerializedName("file_AttendanceCertificate")
        @Expose
        private String fileAttendanceCertificate;
        @SerializedName("file_FeeStructureCopy")
        @Expose
        private String fileFeeStructureCopy;
        @SerializedName("file_UniversityCertificate")
        @Expose
        private String fileUniversityCertificate;
        @SerializedName("file_NSVPCertificate")
        @Expose
        private String fileNSVPCertificate;
        @SerializedName("file_CollegeAffiliationCertificate")
        @Expose
        private String fileCollegeAffiliationCertificate;
        @SerializedName("file_DomicileCertificate")
        @Expose
        private String fileDomicileCertificate;
        @SerializedName("file_ParivarPehchaanPatra")
        @Expose
        private String fileParivarPehchaanPatra;
        @SerializedName("student_Quota")
        @Expose
        private String studentQuota;
        @SerializedName("is_Lateral_Entry")
        @Expose
        private String isLateralEntry;
        @SerializedName("courseType")
        @Expose
        private String courseType;
        @SerializedName("isScholarshipDisbursed")
        @Expose
        private String isScholarshipDisbursed;
        @SerializedName("transactionDate")
        @Expose
        private String transactionDate;
        @SerializedName("transactionNo")
        @Expose
        private String transactionNo;
        @SerializedName("amountDisbursed")
        @Expose
        private String amountDisbursed;
        @SerializedName("file_Student_Image_Path")
        @Expose
        private String fileStudentImagePath;
        @SerializedName("file_Student_Signature_Path")
        @Expose
        private String fileStudentSignaturePath;
        @SerializedName("fcmToken")
        @Expose
        private String fcmToken;
        @SerializedName("schemeName")
        @Expose
        private String schemeName;

        public int getStudentId() {
            return studentId;
        }

        public void setStudentId(int studentId) {
            this.studentId = studentId;
        }

        public String getFamilyID() {
            return familyID;
        }

        public void setFamilyID(String familyID) {
            this.familyID = familyID;
        }

        public String getMemberID() {
            return memberID;
        }

        public void setMemberID(String memberID) {
            this.memberID = memberID;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getFatherFullName() {
            return fatherFullName;
        }

        public void setFatherFullName(String fatherFullName) {
            this.fatherFullName = fatherFullName;
        }

        public String getMotherFullName() {
            return motherFullName;
        }

        public void setMotherFullName(String motherFullName) {
            this.motherFullName = motherFullName;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getHouseNo() {
            return houseNo;
        }

        public void setHouseNo(String houseNo) {
            this.houseNo = houseNo;
        }

        public String getStreetNo() {
            return streetNo;
        }

        public void setStreetNo(String streetNo) {
            this.streetNo = streetNo;
        }

        public String getAddressLandMark() {
            return addressLandMark;
        }

        public void setAddressLandMark(String addressLandMark) {
            this.addressLandMark = addressLandMark;
        }

        public String getPinCode() {
            return pinCode;
        }

        public void setPinCode(String pinCode) {
            this.pinCode = pinCode;
        }

        public String getDistrictName() {
            return districtName;
        }

        public void setDistrictName(String districtName) {
            this.districtName = districtName;
        }

        public String getAadhaarNo() {
            return aadhaarNo;
        }

        public void setAadhaarNo(String aadhaarNo) {
            this.aadhaarNo = aadhaarNo;
        }

        public String getDob() {
            return dob;
        }

        public void setDob(String dob) {
            this.dob = dob;
        }

        public String getMobileNo() {
            return mobileNo;
        }

        public void setMobileNo(String mobileNo) {
            this.mobileNo = mobileNo;
        }

        public String getCasteCategory() {
            return casteCategory;
        }

        public void setCasteCategory(String casteCategory) {
            this.casteCategory = casteCategory;
        }

        public int getFamilyIncome() {
            return familyIncome;
        }

        public void setFamilyIncome(int familyIncome) {
            this.familyIncome = familyIncome;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getBpl() {
            return bpl;
        }

        public void setBpl(String bpl) {
            this.bpl = bpl;
        }

        public String getBplCardNO() {
            return bplCardNO;
        }

        public void setBplCardNO(String bplCardNO) {
            this.bplCardNO = bplCardNO;
        }

        public String getCasteCategoryName() {
            return casteCategoryName;
        }

        public void setCasteCategoryName(String casteCategoryName) {
            this.casteCategoryName = casteCategoryName;
        }

        public String getAcademicSession() {
            return academicSession;
        }

        public void setAcademicSession(String academicSession) {
            this.academicSession = academicSession;
        }

        public int getCollegeId() {
            return collegeId;
        }

        public void setCollegeId(int collegeId) {
            this.collegeId = collegeId;
        }

        public String getCollege() {
            return college;
        }

        public void setCollege(String college) {
            this.college = college;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getCollegeCategory() {
            return collegeCategory;
        }

        public void setCollegeCategory(String collegeCategory) {
            this.collegeCategory = collegeCategory;
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

        public int getDepartmentId() {
            return departmentId;
        }

        public void setDepartmentId(int departmentId) {
            this.departmentId = departmentId;
        }

        public String getIsOutsideHaryana() {
            return isOutsideHaryana;
        }

        public void setIsOutsideHaryana(String isOutsideHaryana) {
            this.isOutsideHaryana = isOutsideHaryana;
        }

        public int getCourseId() {
            return courseId;
        }

        public void setCourseId(int courseId) {
            this.courseId = courseId;
        }

        public String getCourseName() {
            return courseName;
        }

        public void setCourseName(String courseName) {
            this.courseName = courseName;
        }

        public String getCourseCategory() {
            return courseCategory;
        }

        public void setCourseCategory(String courseCategory) {
            this.courseCategory = courseCategory;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public String getCollegeRollNo() {
            return collegeRollNo;
        }

        public void setCollegeRollNo(String collegeRollNo) {
            this.collegeRollNo = collegeRollNo;
        }

        public String getIsDenotifiedTribe() {
            return isDenotifiedTribe;
        }

        public void setIsDenotifiedTribe(String isDenotifiedTribe) {
            this.isDenotifiedTribe = isDenotifiedTribe;
        }

        public String getUniversityRollNo() {
            return universityRollNo;
        }

        public void setUniversityRollNo(String universityRollNo) {
            this.universityRollNo = universityRollNo;
        }

        public String getAdmissionDate() {
            return admissionDate;
        }

        public void setAdmissionDate(String admissionDate) {
            this.admissionDate = admissionDate;
        }

        public String getAreaType() {
            return areaType;
        }

        public void setAreaType(String areaType) {
            this.areaType = areaType;
        }

        public String getBoardingType() {
            return boardingType;
        }

        public void setBoardingType(String boardingType) {
            this.boardingType = boardingType;
        }

        public String getAppliedOn() {
            return appliedOn;
        }

        public void setAppliedOn(String appliedOn) {
            this.appliedOn = appliedOn;
        }

        public String getrRNo() {
            return rRNo;
        }

        public void setrRNo(String rRNo) {
            this.rRNo = rRNo;
        }

        public int getAttendance() {
            return attendance;
        }

        public void setAttendance(int attendance) {
            this.attendance = attendance;
        }

        public int getMaintenanceRate() {
            return maintenanceRate;
        }

        public void setMaintenanceRate(int maintenanceRate) {
            this.maintenanceRate = maintenanceRate;
        }

        public int getMaintenanceMonth() {
            return maintenanceMonth;
        }

        public void setMaintenanceMonth(int maintenanceMonth) {
            this.maintenanceMonth = maintenanceMonth;
        }

        public int getTotalMaintenance() {
            return totalMaintenance;
        }

        public void setTotalMaintenance(int totalMaintenance) {
            this.totalMaintenance = totalMaintenance;
        }

        public int getCourseFee() {
            return courseFee;
        }

        public void setCourseFee(int courseFee) {
            this.courseFee = courseFee;
        }

        public int getCourseFeeReimburse() {
            return courseFeeReimburse;
        }

        public void setCourseFeeReimburse(int courseFeeReimburse) {
            this.courseFeeReimburse = courseFeeReimburse;
        }

        public int getOtherComponentAmount() {
            return otherComponentAmount;
        }

        public void setOtherComponentAmount(int otherComponentAmount) {
            this.otherComponentAmount = otherComponentAmount;
        }

        public int getScholarshipAmount() {
            return scholarshipAmount;
        }

        public void setScholarshipAmount(int scholarshipAmount) {
            this.scholarshipAmount = scholarshipAmount;
        }

        public int getnBMaintenanceRate() {
            return nBMaintenanceRate;
        }

        public void setnBMaintenanceRate(int nBMaintenanceRate) {
            this.nBMaintenanceRate = nBMaintenanceRate;
        }

        public int getnBMaintenanceMonth() {
            return nBMaintenanceMonth;
        }

        public void setnBMaintenanceMonth(int nBMaintenanceMonth) {
            this.nBMaintenanceMonth = nBMaintenanceMonth;
        }

        public int getnBTotalMaintenance() {
            return nBTotalMaintenance;
        }

        public void setnBTotalMaintenance(int nBTotalMaintenance) {
            this.nBTotalMaintenance = nBTotalMaintenance;
        }

        public int getnBCourseFee() {
            return nBCourseFee;
        }

        public void setnBCourseFee(int nBCourseFee) {
            this.nBCourseFee = nBCourseFee;
        }

        public int getnBCourseFeeReimburse() {
            return nBCourseFeeReimburse;
        }

        public void setnBCourseFeeReimburse(int nBCourseFeeReimburse) {
            this.nBCourseFeeReimburse = nBCourseFeeReimburse;
        }

        public int getnBOtherComponentAmount() {
            return nBOtherComponentAmount;
        }

        public void setnBOtherComponentAmount(int nBOtherComponentAmount) {
            this.nBOtherComponentAmount = nBOtherComponentAmount;
        }

        public int getnBScholarshipAmount() {
            return nBScholarshipAmount;
        }

        public void setnBScholarshipAmount(int nBScholarshipAmount) {
            this.nBScholarshipAmount = nBScholarshipAmount;
        }

        public int gethQMaintenanceRate() {
            return hQMaintenanceRate;
        }

        public void sethQMaintenanceRate(int hQMaintenanceRate) {
            this.hQMaintenanceRate = hQMaintenanceRate;
        }

        public int gethQMaintenanceMonth() {
            return hQMaintenanceMonth;
        }

        public void sethQMaintenanceMonth(int hQMaintenanceMonth) {
            this.hQMaintenanceMonth = hQMaintenanceMonth;
        }

        public int gethQTotalMaintenance() {
            return hQTotalMaintenance;
        }

        public void sethQTotalMaintenance(int hQTotalMaintenance) {
            this.hQTotalMaintenance = hQTotalMaintenance;
        }

        public int gethQCourseFee() {
            return hQCourseFee;
        }

        public void sethQCourseFee(int hQCourseFee) {
            this.hQCourseFee = hQCourseFee;
        }

        public int gethQCourseFeeReimburse() {
            return hQCourseFeeReimburse;
        }

        public void sethQCourseFeeReimburse(int hQCourseFeeReimburse) {
            this.hQCourseFeeReimburse = hQCourseFeeReimburse;
        }

        public int gethQOtherComponentAmount() {
            return hQOtherComponentAmount;
        }

        public void sethQOtherComponentAmount(int hQOtherComponentAmount) {
            this.hQOtherComponentAmount = hQOtherComponentAmount;
        }

        public int gethQScholarshipAmount() {
            return hQScholarshipAmount;
        }

        public void sethQScholarshipAmount(int hQScholarshipAmount) {
            this.hQScholarshipAmount = hQScholarshipAmount;
        }

        public String getCollegeStatus() {
            return collegeStatus;
        }

        public void setCollegeStatus(String collegeStatus) {
            this.collegeStatus = collegeStatus;
        }

        public String getCollegeStatusDate() {
            return collegeStatusDate;
        }

        public void setCollegeStatusDate(String collegeStatusDate) {
            this.collegeStatusDate = collegeStatusDate;
        }

        public String getCollegeRemarks() {
            return collegeRemarks;
        }

        public void setCollegeRemarks(String collegeRemarks) {
            this.collegeRemarks = collegeRemarks;
        }

        public String getCollegeDDO() {
            return collegeDDO;
        }

        public void setCollegeDDO(String collegeDDO) {
            this.collegeDDO = collegeDDO;
        }

        public String getNodalBodyStatus() {
            return nodalBodyStatus;
        }

        public void setNodalBodyStatus(String nodalBodyStatus) {
            this.nodalBodyStatus = nodalBodyStatus;
        }

        public String getNodalBodyStatusDate() {
            return nodalBodyStatusDate;
        }

        public void setNodalBodyStatusDate(String nodalBodyStatusDate) {
            this.nodalBodyStatusDate = nodalBodyStatusDate;
        }

        public String getNodalBodyRemarks() {
            return nodalBodyRemarks;
        }

        public void setNodalBodyRemarks(String nodalBodyRemarks) {
            this.nodalBodyRemarks = nodalBodyRemarks;
        }

        public String getNodalBodyDDO() {
            return nodalBodyDDO;
        }

        public void setNodalBodyDDO(String nodalBodyDDO) {
            this.nodalBodyDDO = nodalBodyDDO;
        }

        public String gethQStatus() {
            return hQStatus;
        }

        public void sethQStatus(String hQStatus) {
            this.hQStatus = hQStatus;
        }

        public String gethQStatusDate() {
            return hQStatusDate;
        }

        public void sethQStatusDate(String hQStatusDate) {
            this.hQStatusDate = hQStatusDate;
        }

        public String gethQRemarks() {
            return hQRemarks;
        }

        public void sethQRemarks(String hQRemarks) {
            this.hQRemarks = hQRemarks;
        }

        public String gethQDDO() {
            return hQDDO;
        }

        public void sethQDDO(String hQDDO) {
            this.hQDDO = hQDDO;
        }

        public String getMoSJEAPIStatus() {
            return moSJEAPIStatus;
        }

        public void setMoSJEAPIStatus(String moSJEAPIStatus) {
            this.moSJEAPIStatus = moSJEAPIStatus;
        }

        public String getFileStudentImage() {
            return fileStudentImage;
        }

        public void setFileStudentImage(String fileStudentImage) {
            this.fileStudentImage = fileStudentImage;
        }

        public String getFileStudentSignature() {
            return fileStudentSignature;
        }

        public void setFileStudentSignature(String fileStudentSignature) {
            this.fileStudentSignature = fileStudentSignature;
        }

        public String getFileAadharCopyPath() {
            return fileAadharCopyPath;
        }

        public void setFileAadharCopyPath(String fileAadharCopyPath) {
            this.fileAadharCopyPath = fileAadharCopyPath;
        }

        public String getFileAadharCopyContentType() {
            return fileAadharCopyContentType;
        }

        public void setFileAadharCopyContentType(String fileAadharCopyContentType) {
            this.fileAadharCopyContentType = fileAadharCopyContentType;
        }

        public String getFileIncomeCertificatePath() {
            return fileIncomeCertificatePath;
        }

        public void setFileIncomeCertificatePath(String fileIncomeCertificatePath) {
            this.fileIncomeCertificatePath = fileIncomeCertificatePath;
        }

        public String getFileIncomeCertificateContentType() {
            return fileIncomeCertificateContentType;
        }

        public void setFileIncomeCertificateContentType(String fileIncomeCertificateContentType) {
            this.fileIncomeCertificateContentType = fileIncomeCertificateContentType;
        }

        public String getFileCasteCertificatePath() {
            return fileCasteCertificatePath;
        }

        public void setFileCasteCertificatePath(String fileCasteCertificatePath) {
            this.fileCasteCertificatePath = fileCasteCertificatePath;
        }

        public String getFileCasteCertificateContentType() {
            return fileCasteCertificateContentType;
        }

        public void setFileCasteCertificateContentType(String fileCasteCertificateContentType) {
            this.fileCasteCertificateContentType = fileCasteCertificateContentType;
        }

        public String getFileHostelCertificatePath() {
            return fileHostelCertificatePath;
        }

        public void setFileHostelCertificatePath(String fileHostelCertificatePath) {
            this.fileHostelCertificatePath = fileHostelCertificatePath;
        }

        public String getFileHostelCertificateContentType() {
            return fileHostelCertificateContentType;
        }

        public void setFileHostelCertificateContentType(String fileHostelCertificateContentType) {
            this.fileHostelCertificateContentType = fileHostelCertificateContentType;
        }

        public String getFile10DMCPath() {
            return file10DMCPath;
        }

        public void setFile10DMCPath(String file10DMCPath) {
            this.file10DMCPath = file10DMCPath;
        }

        public String getFile10DMCContentType() {
            return file10DMCContentType;
        }

        public void setFile10DMCContentType(String file10DMCContentType) {
            this.file10DMCContentType = file10DMCContentType;
        }

        public String getFile12DMCPath() {
            return file12DMCPath;
        }

        public void setFile12DMCPath(String file12DMCPath) {
            this.file12DMCPath = file12DMCPath;
        }

        public String getFile12DMCContentType() {
            return file12DMCContentType;
        }

        public void setFile12DMCContentType(String file12DMCContentType) {
            this.file12DMCContentType = file12DMCContentType;
        }

        public String getFileLastExamPassedDMCPath() {
            return fileLastExamPassedDMCPath;
        }

        public void setFileLastExamPassedDMCPath(String fileLastExamPassedDMCPath) {
            this.fileLastExamPassedDMCPath = fileLastExamPassedDMCPath;
        }

        public String getFileLastExamPassedDMCContentType() {
            return fileLastExamPassedDMCContentType;
        }

        public void setFileLastExamPassedDMCContentType(String fileLastExamPassedDMCContentType) {
            this.fileLastExamPassedDMCContentType = fileLastExamPassedDMCContentType;
        }

        public String getFileFeeReceiptCopyPath() {
            return fileFeeReceiptCopyPath;
        }

        public void setFileFeeReceiptCopyPath(String fileFeeReceiptCopyPath) {
            this.fileFeeReceiptCopyPath = fileFeeReceiptCopyPath;
        }

        public String getFileFeeReceiptCopyContentType() {
            return fileFeeReceiptCopyContentType;
        }

        public void setFileFeeReceiptCopyContentType(String fileFeeReceiptCopyContentType) {
            this.fileFeeReceiptCopyContentType = fileFeeReceiptCopyContentType;
        }

        public String getFileFatherDeathCertificatePath() {
            return fileFatherDeathCertificatePath;
        }

        public void setFileFatherDeathCertificatePath(String fileFatherDeathCertificatePath) {
            this.fileFatherDeathCertificatePath = fileFatherDeathCertificatePath;
        }

        public String getFileFatherDeathCertificateContentType() {
            return fileFatherDeathCertificateContentType;
        }

        public void setFileFatherDeathCertificateContentType(String fileFatherDeathCertificateContentType) {
            this.fileFatherDeathCertificateContentType = fileFatherDeathCertificateContentType;
        }

        public String getFileBPLCertificatePath() {
            return fileBPLCertificatePath;
        }

        public void setFileBPLCertificatePath(String fileBPLCertificatePath) {
            this.fileBPLCertificatePath = fileBPLCertificatePath;
        }

        public String getFileBPLCertificateContentType() {
            return fileBPLCertificateContentType;
        }

        public void setFileBPLCertificateContentType(String fileBPLCertificateContentType) {
            this.fileBPLCertificateContentType = fileBPLCertificateContentType;
        }

        public String getFileAttendanceCertificate() {
            return fileAttendanceCertificate;
        }

        public void setFileAttendanceCertificate(String fileAttendanceCertificate) {
            this.fileAttendanceCertificate = fileAttendanceCertificate;
        }

        public String getFileFeeStructureCopy() {
            return fileFeeStructureCopy;
        }

        public void setFileFeeStructureCopy(String fileFeeStructureCopy) {
            this.fileFeeStructureCopy = fileFeeStructureCopy;
        }

        public String getFileUniversityCertificate() {
            return fileUniversityCertificate;
        }

        public void setFileUniversityCertificate(String fileUniversityCertificate) {
            this.fileUniversityCertificate = fileUniversityCertificate;
        }

        public String getFileNSVPCertificate() {
            return fileNSVPCertificate;
        }

        public void setFileNSVPCertificate(String fileNSVPCertificate) {
            this.fileNSVPCertificate = fileNSVPCertificate;
        }

        public String getFileCollegeAffiliationCertificate() {
            return fileCollegeAffiliationCertificate;
        }

        public void setFileCollegeAffiliationCertificate(String fileCollegeAffiliationCertificate) {
            this.fileCollegeAffiliationCertificate = fileCollegeAffiliationCertificate;
        }

        public String getFileDomicileCertificate() {
            return fileDomicileCertificate;
        }

        public void setFileDomicileCertificate(String fileDomicileCertificate) {
            this.fileDomicileCertificate = fileDomicileCertificate;
        }

        public String getFileParivarPehchaanPatra() {
            return fileParivarPehchaanPatra;
        }

        public void setFileParivarPehchaanPatra(String fileParivarPehchaanPatra) {
            this.fileParivarPehchaanPatra = fileParivarPehchaanPatra;
        }

        public String getStudentQuota() {
            return studentQuota;
        }

        public void setStudentQuota(String studentQuota) {
            this.studentQuota = studentQuota;
        }

        public String getIsLateralEntry() {
            return isLateralEntry;
        }

        public void setIsLateralEntry(String isLateralEntry) {
            this.isLateralEntry = isLateralEntry;
        }

        public String getCourseType() {
            return courseType;
        }

        public void setCourseType(String courseType) {
            this.courseType = courseType;
        }

        public String getIsScholarshipDisbursed() {
            return isScholarshipDisbursed;
        }

        public void setIsScholarshipDisbursed(String isScholarshipDisbursed) {
            this.isScholarshipDisbursed = isScholarshipDisbursed;
        }

        public String getTransactionDate() {
            return transactionDate;
        }

        public void setTransactionDate(String transactionDate) {
            this.transactionDate = transactionDate;
        }

        public String getTransactionNo() {
            return transactionNo;
        }

        public void setTransactionNo(String transactionNo) {
            this.transactionNo = transactionNo;
        }

        public String getAmountDisbursed() {
            return amountDisbursed;
        }

        public void setAmountDisbursed(String amountDisbursed) {
            this.amountDisbursed = amountDisbursed;
        }

        public String getFileStudentImagePath() {
            return fileStudentImagePath;
        }

        public void setFileStudentImagePath(String fileStudentImagePath) {
            this.fileStudentImagePath = fileStudentImagePath;
        }

        public String getFileStudentSignaturePath() {
            return fileStudentSignaturePath;
        }

        public void setFileStudentSignaturePath(String fileStudentSignaturePath) {
            this.fileStudentSignaturePath = fileStudentSignaturePath;
        }

        public String getFcmToken() {
            return fcmToken;
        }

        public void setFcmToken(String fcmToken) {
            this.fcmToken = fcmToken;
        }

        public String getSchemeName() {
            return schemeName;
        }

        public void setSchemeName(String schemeName) {
            this.schemeName = schemeName;
        }
    }
}
