package hsvp.digital.allottee_corner.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VerifyOTPRequestforMEMIDResponse {
    @SerializedName("result")
    @Expose
    private Result result;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public class Result {

        @SerializedName("familyID")
        @Expose
        private String familyID;
        @SerializedName("memberID")
        @Expose
        private String memberID;
        @SerializedName("isHouseHoldOrMember")
        @Expose
        private String isHouseHoldOrMember;
        @SerializedName("firstName")
        @Expose
        private String firstName;
        @SerializedName("lastName")
        @Expose
        private String lastName;
        @SerializedName("fullName")
        @Expose
        private String fullName;
        @SerializedName("fullNameLL")
        @Expose
        private String fullNameLL;
        @SerializedName("fatherFullName")
        @Expose
        private String fatherFullName;
        @SerializedName("fatherFullNameLL")
        @Expose
        private String fatherFullNameLL;
        @SerializedName("motherFullName")
        @Expose
        private String motherFullName;
        @SerializedName("motherFullNameLL")
        @Expose
        private String motherFullNameLL;
        @SerializedName("spouseFullName")
        @Expose
        private String spouseFullName;
        @SerializedName("spouseFullNameLL")
        @Expose
        private String spouseFullNameLL;
        @SerializedName("gender")
        @Expose
        private String gender;
        @SerializedName("fatherFirstName")
        @Expose
        private String fatherFirstName;
        @SerializedName("fatherLastName")
        @Expose
        private String fatherLastName;
        @SerializedName("motherFirstName")
        @Expose
        private String motherFirstName;
        @SerializedName("motherLastName")
        @Expose
        private String motherLastName;
        @SerializedName("maritalStatus")
        @Expose
        private String maritalStatus;
        @SerializedName("spouseFirstName")
        @Expose
        private String spouseFirstName;
        @SerializedName("spouseLastName")
        @Expose
        private String spouseLastName;
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
        @SerializedName("dCode")
        @Expose
        private String dCode;
        @SerializedName("btCode")
        @Expose
        private String btCode;
        @SerializedName("wvCode")
        @Expose
        private String wvCode;
        @SerializedName("districtName")
        @Expose
        private String districtName;
        @SerializedName("btName")
        @Expose
        private String btName;
        @SerializedName("wvName")
        @Expose
        private String wvName;
        @SerializedName("districtNameLL")
        @Expose
        private String districtNameLL;
        @SerializedName("btNameLL")
        @Expose
        private String btNameLL;
        @SerializedName("wvNameLL")
        @Expose
        private String wvNameLL;
        @SerializedName("aadhaarNo")
        @Expose
        private String aadhaarNo;
        @SerializedName("ruralUrban")
        @Expose
        private String ruralUrban;
        @SerializedName("dob")
        @Expose
        private String dob;
        @SerializedName("age")
        @Expose
        private int age;
        @SerializedName("mobileNo")
        @Expose
        private String mobileNo;
        @SerializedName("relationshipWithHH_codes")
        @Expose
        private int relationshipWithHHCodes;
        @SerializedName("isDivyang")
        @Expose
        private String isDivyang;
        @SerializedName("divyangPercentage")
        @Expose
        private double divyangPercentage;
        @SerializedName("casteCategory")
        @Expose
        private int casteCategory;
        @SerializedName("occupation")
        @Expose
        private int occupation;
        @SerializedName("totalIncome")
        @Expose
        private double totalIncome;
        @SerializedName("familyIncome")
        @Expose
        private double familyIncome;
        @SerializedName("qualification")
        @Expose
        private int qualification;
        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("totallandholding")
        @Expose
        private double totallandholding;
        @SerializedName("acres_landholding")
        @Expose
        private int acresLandholding;
        @SerializedName("kanal_landholding")
        @Expose
        private int kanalLandholding;
        @SerializedName("marla_landholding")
        @Expose
        private int marlaLandholding;
        @SerializedName("incometaxpayee")
        @Expose
        private String incometaxpayee;
        @SerializedName("hasPanCard")
        @Expose
        private String hasPanCard;
        @SerializedName("disabiltyType")
        @Expose
        private String disabiltyType;
        @SerializedName("bankAccountNumber")
        @Expose
        private String bankAccountNumber;
        @SerializedName("ifscCode")
        @Expose
        private String ifscCode;
        @SerializedName("firstNameLL")
        @Expose
        private String firstNameLL;
        @SerializedName("lastNameLL")
        @Expose
        private String lastNameLL;
        @SerializedName("fatherFirstNameLL")
        @Expose
        private String fatherFirstNameLL;
        @SerializedName("fatherLastNameLL")
        @Expose
        private String fatherLastNameLL;
        @SerializedName("motherFirstNameLL")
        @Expose
        private String motherFirstNameLL;
        @SerializedName("motherLastNameLL")
        @Expose
        private String motherLastNameLL;
        @SerializedName("spouseFirstNameLL")
        @Expose
        private String spouseFirstNameLL;
        @SerializedName("spouseLastNameLL")
        @Expose
        private String spouseLastNameLL;
        @SerializedName("blockSmitiCode")
        @Expose
        private String blockSmitiCode;
        @SerializedName("voterIDNo")
        @Expose
        private String voterIDNo;
        @SerializedName("livingsinceyear")
        @Expose
        private String livingsinceyear;
        @SerializedName("placeofBirthState")
        @Expose
        private String placeofBirthState;
        @SerializedName("placeofBirthDistrict")
        @Expose
        private String placeofBirthDistrict;
        @SerializedName("placeofBirthBlockTown")
        @Expose
        private String placeofBirthBlockTown;
        @SerializedName("placeofBirthWardVillage")
        @Expose
        private String placeofBirthWardVillage;
        @SerializedName("govtEmployee")
        @Expose
        private String govtEmployee;
        @SerializedName("pan")
        @Expose
        private String pan;
        @SerializedName("bpl")
        @Expose
        private String bpl;
        @SerializedName("subCaste_name")
        @Expose
        private String subCasteName;
        @SerializedName("subCaste_code")
        @Expose
        private String subCasteCode;
        @SerializedName("casteDescription")
        @Expose
        private String casteDescription;
        @SerializedName("bplCardNO")
        @Expose
        private String bplCardNO;
        @SerializedName("divyangCategory")
        @Expose
        private String divyangCategory;
        @SerializedName("divyangValidUpto")
        @Expose
        private String divyangValidUpto;
        @SerializedName("deprived")
        @Expose
        private String deprived;
        @SerializedName("isDemoAuth")
        @Expose
        private String isDemoAuth;
        @SerializedName("dCodeLGD")
        @Expose
        private String dCodeLGD;
        @SerializedName("btCodeLGD")
        @Expose
        private String btCodeLGD;
        @SerializedName("wvCodeLGD")
        @Expose
        private String wvCodeLGD;
        @SerializedName("relationshipWithHH_name")
        @Expose
        private String relationshipWithHHName;
        @SerializedName("casteCategoryName")
        @Expose
        private String casteCategoryName;
        @SerializedName("occupationName")
        @Expose
        private String occupationName;
        @SerializedName("qualificationName")
        @Expose
        private String qualificationName;
        @SerializedName("isDOBVerified")
        @Expose
        private String isDOBVerified;
        @SerializedName("isCasteVerified")
        @Expose
        private String isCasteVerified;
        @SerializedName("isIncomeVerified")
        @Expose
        private String isIncomeVerified;
        @SerializedName("isResidenceVerified")
        @Expose
        private String isResidenceVerified;
        @SerializedName("isNameVerified")
        @Expose
        private String isNameVerified;
        @SerializedName("isFnameVerified")
        @Expose
        private String isFnameVerified;
        @SerializedName("isMnameVerified")
        @Expose
        private String isMnameVerified;
        @SerializedName("isSnameVerified")
        @Expose
        private String isSnameVerified;
        @SerializedName("isGenderVerified")
        @Expose
        private String isGenderVerified;
        @SerializedName("isMobileVerified")
        @Expose
        private String isMobileVerified;
        @SerializedName("isPlaceOfBirthVerified")
        @Expose
        private String isPlaceOfBirthVerified;
        @SerializedName("isMaritalStatusVerified")
        @Expose
        private String isMaritalStatusVerified;
        @SerializedName("isRelationWithHeadVerified")
        @Expose
        private String isRelationWithHeadVerified;
        @SerializedName("isBankVerified")
        @Expose
        private String isBankVerified;
        @SerializedName("isVoterIDVerified")
        @Expose
        private String isVoterIDVerified;
        @SerializedName("isPanVerified")
        @Expose
        private String isPanVerified;
        @SerializedName("isBPLVerified")
        @Expose
        private String isBPLVerified;
        @SerializedName("isDivyangVerified")
        @Expose
        private String isDivyangVerified;
        @SerializedName("isEngagementVerified")
        @Expose
        private String isEngagementVerified;
        @SerializedName("isQualificationVerified")
        @Expose
        private String isQualificationVerified;
        @SerializedName("tehsilCode")
        @Expose
        private String tehsilCode;
        @SerializedName("tehsilName")
        @Expose
        private String tehsilName;
        @SerializedName("lgdpC_Code")
        @Expose
        private String lgdpCCode;
        @SerializedName("lgdaC_Code")
        @Expose
        private String lgdaCCode;

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

        public String getIsHouseHoldOrMember() {
            return isHouseHoldOrMember;
        }

        public void setIsHouseHoldOrMember(String isHouseHoldOrMember) {
            this.isHouseHoldOrMember = isHouseHoldOrMember;
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

        public String getFullNameLL() {
            return fullNameLL;
        }

        public void setFullNameLL(String fullNameLL) {
            this.fullNameLL = fullNameLL;
        }

        public String getFatherFullName() {
            return fatherFullName;
        }

        public void setFatherFullName(String fatherFullName) {
            this.fatherFullName = fatherFullName;
        }

        public String getFatherFullNameLL() {
            return fatherFullNameLL;
        }

        public void setFatherFullNameLL(String fatherFullNameLL) {
            this.fatherFullNameLL = fatherFullNameLL;
        }

        public String getMotherFullName() {
            return motherFullName;
        }

        public void setMotherFullName(String motherFullName) {
            this.motherFullName = motherFullName;
        }

        public String getMotherFullNameLL() {
            return motherFullNameLL;
        }

        public void setMotherFullNameLL(String motherFullNameLL) {
            this.motherFullNameLL = motherFullNameLL;
        }

        public String getSpouseFullName() {
            return spouseFullName;
        }

        public void setSpouseFullName(String spouseFullName) {
            this.spouseFullName = spouseFullName;
        }

        public String getSpouseFullNameLL() {
            return spouseFullNameLL;
        }

        public void setSpouseFullNameLL(String spouseFullNameLL) {
            this.spouseFullNameLL = spouseFullNameLL;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getFatherFirstName() {
            return fatherFirstName;
        }

        public void setFatherFirstName(String fatherFirstName) {
            this.fatherFirstName = fatherFirstName;
        }

        public String getFatherLastName() {
            return fatherLastName;
        }

        public void setFatherLastName(String fatherLastName) {
            this.fatherLastName = fatherLastName;
        }

        public String getMotherFirstName() {
            return motherFirstName;
        }

        public void setMotherFirstName(String motherFirstName) {
            this.motherFirstName = motherFirstName;
        }

        public String getMotherLastName() {
            return motherLastName;
        }

        public void setMotherLastName(String motherLastName) {
            this.motherLastName = motherLastName;
        }

        public String getMaritalStatus() {
            return maritalStatus;
        }

        public void setMaritalStatus(String maritalStatus) {
            this.maritalStatus = maritalStatus;
        }

        public String getSpouseFirstName() {
            return spouseFirstName;
        }

        public void setSpouseFirstName(String spouseFirstName) {
            this.spouseFirstName = spouseFirstName;
        }

        public String getSpouseLastName() {
            return spouseLastName;
        }

        public void setSpouseLastName(String spouseLastName) {
            this.spouseLastName = spouseLastName;
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

        public String getdCode() {
            return dCode;
        }

        public void setdCode(String dCode) {
            this.dCode = dCode;
        }

        public String getBtCode() {
            return btCode;
        }

        public void setBtCode(String btCode) {
            this.btCode = btCode;
        }

        public String getWvCode() {
            return wvCode;
        }

        public void setWvCode(String wvCode) {
            this.wvCode = wvCode;
        }

        public String getDistrictName() {
            return districtName;
        }

        public void setDistrictName(String districtName) {
            this.districtName = districtName;
        }

        public String getBtName() {
            return btName;
        }

        public void setBtName(String btName) {
            this.btName = btName;
        }

        public String getWvName() {
            return wvName;
        }

        public void setWvName(String wvName) {
            this.wvName = wvName;
        }

        public String getDistrictNameLL() {
            return districtNameLL;
        }

        public void setDistrictNameLL(String districtNameLL) {
            this.districtNameLL = districtNameLL;
        }

        public String getBtNameLL() {
            return btNameLL;
        }

        public void setBtNameLL(String btNameLL) {
            this.btNameLL = btNameLL;
        }

        public String getWvNameLL() {
            return wvNameLL;
        }

        public void setWvNameLL(String wvNameLL) {
            this.wvNameLL = wvNameLL;
        }

        public String getAadhaarNo() {
            return aadhaarNo;
        }

        public void setAadhaarNo(String aadhaarNo) {
            this.aadhaarNo = aadhaarNo;
        }

        public String getRuralUrban() {
            return ruralUrban;
        }

        public void setRuralUrban(String ruralUrban) {
            this.ruralUrban = ruralUrban;
        }

        public String getDob() {
            return dob;
        }

        public void setDob(String dob) {
            this.dob = dob;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getMobileNo() {
            return mobileNo;
        }

        public void setMobileNo(String mobileNo) {
            this.mobileNo = mobileNo;
        }

        public int getRelationshipWithHHCodes() {
            return relationshipWithHHCodes;
        }

        public void setRelationshipWithHHCodes(int relationshipWithHHCodes) {
            this.relationshipWithHHCodes = relationshipWithHHCodes;
        }

        public String getIsDivyang() {
            return isDivyang;
        }

        public void setIsDivyang(String isDivyang) {
            this.isDivyang = isDivyang;
        }

        public double getDivyangPercentage() {
            return divyangPercentage;
        }

        public void setDivyangPercentage(double divyangPercentage) {
            this.divyangPercentage = divyangPercentage;
        }

        public int getCasteCategory() {
            return casteCategory;
        }

        public void setCasteCategory(int casteCategory) {
            this.casteCategory = casteCategory;
        }

        public int getOccupation() {
            return occupation;
        }

        public void setOccupation(int occupation) {
            this.occupation = occupation;
        }

        public double getTotalIncome() {
            return totalIncome;
        }

        public void setTotalIncome(double totalIncome) {
            this.totalIncome = totalIncome;
        }

        public double getFamilyIncome() {
            return familyIncome;
        }

        public void setFamilyIncome(double familyIncome) {
            this.familyIncome = familyIncome;
        }

        public int getQualification() {
            return qualification;
        }

        public void setQualification(int qualification) {
            this.qualification = qualification;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public double getTotallandholding() {
            return totallandholding;
        }

        public void setTotallandholding(double totallandholding) {
            this.totallandholding = totallandholding;
        }

        public int getAcresLandholding() {
            return acresLandholding;
        }

        public void setAcresLandholding(int acresLandholding) {
            this.acresLandholding = acresLandholding;
        }

        public int getKanalLandholding() {
            return kanalLandholding;
        }

        public void setKanalLandholding(int kanalLandholding) {
            this.kanalLandholding = kanalLandholding;
        }

        public int getMarlaLandholding() {
            return marlaLandholding;
        }

        public void setMarlaLandholding(int marlaLandholding) {
            this.marlaLandholding = marlaLandholding;
        }

        public String getIncometaxpayee() {
            return incometaxpayee;
        }

        public void setIncometaxpayee(String incometaxpayee) {
            this.incometaxpayee = incometaxpayee;
        }

        public String getHasPanCard() {
            return hasPanCard;
        }

        public void setHasPanCard(String hasPanCard) {
            this.hasPanCard = hasPanCard;
        }

        public String getDisabiltyType() {
            return disabiltyType;
        }

        public void setDisabiltyType(String disabiltyType) {
            this.disabiltyType = disabiltyType;
        }

        public String getBankAccountNumber() {
            return bankAccountNumber;
        }

        public void setBankAccountNumber(String bankAccountNumber) {
            this.bankAccountNumber = bankAccountNumber;
        }

        public String getIfscCode() {
            return ifscCode;
        }

        public void setIfscCode(String ifscCode) {
            this.ifscCode = ifscCode;
        }

        public String getFirstNameLL() {
            return firstNameLL;
        }

        public void setFirstNameLL(String firstNameLL) {
            this.firstNameLL = firstNameLL;
        }

        public String getLastNameLL() {
            return lastNameLL;
        }

        public void setLastNameLL(String lastNameLL) {
            this.lastNameLL = lastNameLL;
        }

        public String getFatherFirstNameLL() {
            return fatherFirstNameLL;
        }

        public void setFatherFirstNameLL(String fatherFirstNameLL) {
            this.fatherFirstNameLL = fatherFirstNameLL;
        }

        public String getFatherLastNameLL() {
            return fatherLastNameLL;
        }

        public void setFatherLastNameLL(String fatherLastNameLL) {
            this.fatherLastNameLL = fatherLastNameLL;
        }

        public String getMotherFirstNameLL() {
            return motherFirstNameLL;
        }

        public void setMotherFirstNameLL(String motherFirstNameLL) {
            this.motherFirstNameLL = motherFirstNameLL;
        }

        public String getMotherLastNameLL() {
            return motherLastNameLL;
        }

        public void setMotherLastNameLL(String motherLastNameLL) {
            this.motherLastNameLL = motherLastNameLL;
        }

        public String getSpouseFirstNameLL() {
            return spouseFirstNameLL;
        }

        public void setSpouseFirstNameLL(String spouseFirstNameLL) {
            this.spouseFirstNameLL = spouseFirstNameLL;
        }

        public String getSpouseLastNameLL() {
            return spouseLastNameLL;
        }

        public void setSpouseLastNameLL(String spouseLastNameLL) {
            this.spouseLastNameLL = spouseLastNameLL;
        }

        public String getBlockSmitiCode() {
            return blockSmitiCode;
        }

        public void setBlockSmitiCode(String blockSmitiCode) {
            this.blockSmitiCode = blockSmitiCode;
        }

        public String getVoterIDNo() {
            return voterIDNo;
        }

        public void setVoterIDNo(String voterIDNo) {
            this.voterIDNo = voterIDNo;
        }

        public String getLivingsinceyear() {
            return livingsinceyear;
        }

        public void setLivingsinceyear(String livingsinceyear) {
            this.livingsinceyear = livingsinceyear;
        }

        public String getPlaceofBirthState() {
            return placeofBirthState;
        }

        public void setPlaceofBirthState(String placeofBirthState) {
            this.placeofBirthState = placeofBirthState;
        }

        public String getPlaceofBirthDistrict() {
            return placeofBirthDistrict;
        }

        public void setPlaceofBirthDistrict(String placeofBirthDistrict) {
            this.placeofBirthDistrict = placeofBirthDistrict;
        }

        public String getPlaceofBirthBlockTown() {
            return placeofBirthBlockTown;
        }

        public void setPlaceofBirthBlockTown(String placeofBirthBlockTown) {
            this.placeofBirthBlockTown = placeofBirthBlockTown;
        }

        public String getPlaceofBirthWardVillage() {
            return placeofBirthWardVillage;
        }

        public void setPlaceofBirthWardVillage(String placeofBirthWardVillage) {
            this.placeofBirthWardVillage = placeofBirthWardVillage;
        }

        public String getGovtEmployee() {
            return govtEmployee;
        }

        public void setGovtEmployee(String govtEmployee) {
            this.govtEmployee = govtEmployee;
        }

        public String getPan() {
            return pan;
        }

        public void setPan(String pan) {
            this.pan = pan;
        }

        public String getBpl() {
            return bpl;
        }

        public void setBpl(String bpl) {
            this.bpl = bpl;
        }

        public String getSubCasteName() {
            return subCasteName;
        }

        public void setSubCasteName(String subCasteName) {
            this.subCasteName = subCasteName;
        }

        public String getSubCasteCode() {
            return subCasteCode;
        }

        public void setSubCasteCode(String subCasteCode) {
            this.subCasteCode = subCasteCode;
        }

        public String getCasteDescription() {
            return casteDescription;
        }

        public void setCasteDescription(String casteDescription) {
            this.casteDescription = casteDescription;
        }

        public String getBplCardNO() {
            return bplCardNO;
        }

        public void setBplCardNO(String bplCardNO) {
            this.bplCardNO = bplCardNO;
        }

        public String getDivyangCategory() {
            return divyangCategory;
        }

        public void setDivyangCategory(String divyangCategory) {
            this.divyangCategory = divyangCategory;
        }

        public String getDivyangValidUpto() {
            return divyangValidUpto;
        }

        public void setDivyangValidUpto(String divyangValidUpto) {
            this.divyangValidUpto = divyangValidUpto;
        }

        public String getDeprived() {
            return deprived;
        }

        public void setDeprived(String deprived) {
            this.deprived = deprived;
        }

        public String getIsDemoAuth() {
            return isDemoAuth;
        }

        public void setIsDemoAuth(String isDemoAuth) {
            this.isDemoAuth = isDemoAuth;
        }

        public String getdCodeLGD() {
            return dCodeLGD;
        }

        public void setdCodeLGD(String dCodeLGD) {
            this.dCodeLGD = dCodeLGD;
        }

        public String getBtCodeLGD() {
            return btCodeLGD;
        }

        public void setBtCodeLGD(String btCodeLGD) {
            this.btCodeLGD = btCodeLGD;
        }

        public String getWvCodeLGD() {
            return wvCodeLGD;
        }

        public void setWvCodeLGD(String wvCodeLGD) {
            this.wvCodeLGD = wvCodeLGD;
        }

        public String getRelationshipWithHHName() {
            return relationshipWithHHName;
        }

        public void setRelationshipWithHHName(String relationshipWithHHName) {
            this.relationshipWithHHName = relationshipWithHHName;
        }

        public String getCasteCategoryName() {
            return casteCategoryName;
        }

        public void setCasteCategoryName(String casteCategoryName) {
            this.casteCategoryName = casteCategoryName;
        }

        public String getOccupationName() {
            return occupationName;
        }

        public void setOccupationName(String occupationName) {
            this.occupationName = occupationName;
        }

        public String getQualificationName() {
            return qualificationName;
        }

        public void setQualificationName(String qualificationName) {
            this.qualificationName = qualificationName;
        }

        public String getIsDOBVerified() {
            return isDOBVerified;
        }

        public void setIsDOBVerified(String isDOBVerified) {
            this.isDOBVerified = isDOBVerified;
        }

        public String getIsCasteVerified() {
            return isCasteVerified;
        }

        public void setIsCasteVerified(String isCasteVerified) {
            this.isCasteVerified = isCasteVerified;
        }

        public String getIsIncomeVerified() {
            return isIncomeVerified;
        }

        public void setIsIncomeVerified(String isIncomeVerified) {
            this.isIncomeVerified = isIncomeVerified;
        }

        public String getIsResidenceVerified() {
            return isResidenceVerified;
        }

        public void setIsResidenceVerified(String isResidenceVerified) {
            this.isResidenceVerified = isResidenceVerified;
        }

        public String getIsNameVerified() {
            return isNameVerified;
        }

        public void setIsNameVerified(String isNameVerified) {
            this.isNameVerified = isNameVerified;
        }

        public String getIsFnameVerified() {
            return isFnameVerified;
        }

        public void setIsFnameVerified(String isFnameVerified) {
            this.isFnameVerified = isFnameVerified;
        }

        public String getIsMnameVerified() {
            return isMnameVerified;
        }

        public void setIsMnameVerified(String isMnameVerified) {
            this.isMnameVerified = isMnameVerified;
        }

        public String getIsSnameVerified() {
            return isSnameVerified;
        }

        public void setIsSnameVerified(String isSnameVerified) {
            this.isSnameVerified = isSnameVerified;
        }

        public String getIsGenderVerified() {
            return isGenderVerified;
        }

        public void setIsGenderVerified(String isGenderVerified) {
            this.isGenderVerified = isGenderVerified;
        }

        public String getIsMobileVerified() {
            return isMobileVerified;
        }

        public void setIsMobileVerified(String isMobileVerified) {
            this.isMobileVerified = isMobileVerified;
        }

        public String getIsPlaceOfBirthVerified() {
            return isPlaceOfBirthVerified;
        }

        public void setIsPlaceOfBirthVerified(String isPlaceOfBirthVerified) {
            this.isPlaceOfBirthVerified = isPlaceOfBirthVerified;
        }

        public String getIsMaritalStatusVerified() {
            return isMaritalStatusVerified;
        }

        public void setIsMaritalStatusVerified(String isMaritalStatusVerified) {
            this.isMaritalStatusVerified = isMaritalStatusVerified;
        }

        public String getIsRelationWithHeadVerified() {
            return isRelationWithHeadVerified;
        }

        public void setIsRelationWithHeadVerified(String isRelationWithHeadVerified) {
            this.isRelationWithHeadVerified = isRelationWithHeadVerified;
        }

        public String getIsBankVerified() {
            return isBankVerified;
        }

        public void setIsBankVerified(String isBankVerified) {
            this.isBankVerified = isBankVerified;
        }

        public String getIsVoterIDVerified() {
            return isVoterIDVerified;
        }

        public void setIsVoterIDVerified(String isVoterIDVerified) {
            this.isVoterIDVerified = isVoterIDVerified;
        }

        public String getIsPanVerified() {
            return isPanVerified;
        }

        public void setIsPanVerified(String isPanVerified) {
            this.isPanVerified = isPanVerified;
        }

        public String getIsBPLVerified() {
            return isBPLVerified;
        }

        public void setIsBPLVerified(String isBPLVerified) {
            this.isBPLVerified = isBPLVerified;
        }

        public String getIsDivyangVerified() {
            return isDivyangVerified;
        }

        public void setIsDivyangVerified(String isDivyangVerified) {
            this.isDivyangVerified = isDivyangVerified;
        }

        public String getIsEngagementVerified() {
            return isEngagementVerified;
        }

        public void setIsEngagementVerified(String isEngagementVerified) {
            this.isEngagementVerified = isEngagementVerified;
        }

        public String getIsQualificationVerified() {
            return isQualificationVerified;
        }

        public void setIsQualificationVerified(String isQualificationVerified) {
            this.isQualificationVerified = isQualificationVerified;
        }

        public String getTehsilCode() {
            return tehsilCode;
        }

        public void setTehsilCode(String tehsilCode) {
            this.tehsilCode = tehsilCode;
        }

        public String getTehsilName() {
            return tehsilName;
        }

        public void setTehsilName(String tehsilName) {
            this.tehsilName = tehsilName;
        }

        public String getLgdpCCode() {
            return lgdpCCode;
        }

        public void setLgdpCCode(String lgdpCCode) {
            this.lgdpCCode = lgdpCCode;
        }

        public String getLgdaCCode() {
            return lgdaCCode;
        }

        public void setLgdaCCode(String lgdaCCode) {
            this.lgdaCCode = lgdaCCode;
        }

    }
}
