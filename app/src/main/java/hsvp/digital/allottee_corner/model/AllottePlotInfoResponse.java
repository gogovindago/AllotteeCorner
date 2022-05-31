package hsvp.digital.allottee_corner.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class AllottePlotInfoResponse {


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

        @SerializedName("UrbanEstateCode")
        @Expose
        private String urbanEstateCode;
        @SerializedName("UrbanEstateName")
        @Expose
        private String urbanEstateName;
        @SerializedName("SectorId")
        @Expose
        private String sectorId;
        @SerializedName("PlotNumber")
        @Expose
        private String plotNumber;
        @SerializedName("CategoryCode")
        @Expose
        private String categoryCode;
        @SerializedName("CategoryName")
        @Expose
        private String categoryName;
        @SerializedName("SubCategoryCode")
        @Expose
        private String subCategoryCode;
        @SerializedName("SubCategoryName")
        @Expose
        private String subCategoryName;
        @SerializedName("ModeOfAllotmentCode")
        @Expose
        private String modeOfAllotmentCode;
        @SerializedName("ModeOfAllotmentDesc")
        @Expose
        private String modeOfAllotmentDesc;
        @SerializedName("NumberOfOwners")
        @Expose
        private int numberOfOwners;
        @SerializedName("Column1")
        @Expose
        private String column1;
        @SerializedName("OriginalReservationCategoryDesc")
        @Expose
        private String originalReservationCategoryDesc;
        @SerializedName("Column2")
        @Expose
        private String column2;
        @SerializedName("OriginalReservationSubCategoryDesc1")
        @Expose
        private String originalReservationSubCategoryDesc1;
        @SerializedName("OriginalAllotteeName")
        @Expose
        private String originalAllotteeName;
        @SerializedName("OriginalAllotteeFatherName")
        @Expose
        private String originalAllotteeFatherName;
        @SerializedName("OriginalAllotteeSurname")
        @Expose
        private String originalAllotteeSurname;
        @SerializedName("OriginalAllotteeFatherSurname")
        @Expose
        private String originalAllotteeFatherSurname;
        @SerializedName("PresentOwnerName")
        @Expose
        private String presentOwnerName;
        @SerializedName("PresentOwnerSurname")
        @Expose
        private String presentOwnerSurname;
        @SerializedName("PresentOwnerFatherName")
        @Expose
        private String presentOwnerFatherName;
        @SerializedName("PresentOwnerFatherSurname")
        @Expose
        private String presentOwnerFatherSurname;
        @SerializedName("CurrentReservationCategoryCode")
        @Expose
        private String currentReservationCategoryCode;
        @SerializedName("CurrentReservationCategoryDesc")
        @Expose
        private String currentReservationCategoryDesc;
        @SerializedName("CurrentReservationSubCategoryCode")
        @Expose
        private String currentReservationSubCategoryCode;
        @SerializedName("CurrentReservationSubCategoryDesc")
        @Expose
        private String currentReservationSubCategoryDesc;
        @SerializedName("PermanentAddress1")
        @Expose
        private String permanentAddress1;
        @SerializedName("PermanentAddress2")
        @Expose
        private String permanentAddress2;
        @SerializedName("PermanentAddress3")
        @Expose
        private String permanentAddress3;
        @SerializedName("PermanentState")
        @Expose
        private String permanentState;
        @SerializedName("PermanentPIN")
        @Expose
        private int permanentPIN;
        @SerializedName("CorrespondenceAddress1")
        @Expose
        private String correspondenceAddress1;
        @SerializedName("CorrespondenceAddress2")
        @Expose
        private String correspondenceAddress2;
        @SerializedName("CorrespondenceAddress3")
        @Expose
        private String correspondenceAddress3;
        @SerializedName("CorrespondenceState")
        @Expose
        private String correspondenceState;
        @SerializedName("CorrespondencePIN")
        @Expose
        private int correspondencePIN;
        @SerializedName("PlotDimension")
        @Expose
        private Object plotDimension;
        @SerializedName("PlotLength")
        @Expose
        private float plotLength;
        @SerializedName("PlotBreadth")
        @Expose
        private float plotBreadth;
        @SerializedName("PlotArea")
        @Expose
        private float plotArea;
        @SerializedName("IncidentalArea")
        @Expose
        private float incidentalArea;
        @SerializedName("LocationStatus")
        @Expose
        private String locationStatus;
        @SerializedName("LocationCost")
        @Expose
        private float locationCost;
        @SerializedName("Cost")
        @Expose
        private float cost;
        @SerializedName("IncreasedCost")
        @Expose
        private float increasedCost;
        @SerializedName("TotalCost")
        @Expose
        private float totalCost;
        @SerializedName("InitialPremium")
        @Expose
        private float initialPremium;
        @SerializedName("YearOfLease")
        @Expose
        private int yearOfLease;
        @SerializedName("PayMode")
        @Expose
        private String payMode;
        @SerializedName("TypeOfInstalment1")
        @Expose
        private String typeOfInstalment1;
        @SerializedName("TypeOfInstalment")
        @Expose
        private String typeOfInstalment;
        @SerializedName("PlotStatusDesc")
        @Expose
        private String plotStatusDesc;
        @SerializedName("PlotStatus")
        @Expose
        private String plotStatus;
        @SerializedName("SchemeNumber")
        @Expose
        private Object schemeNumber;
        @SerializedName("RegistrationNumber")
        @Expose
        private Object registrationNumber;
        @SerializedName("IncidentalCost")
        @Expose
        private float incidentalCost;
        @SerializedName("OwnerID")
        @Expose
        private int ownerID;
        @SerializedName("NumberOfInstalment")
        @Expose
        private int numberOfInstalment;
        @SerializedName("DepositWithApplicationPercentage")
        @Expose
        private float depositWithApplicationPercentage;
        @SerializedName("DepositWithApplicationAmount")
        @Expose
        private float depositWithApplicationAmount;
        @SerializedName("PaymentOnAllotmentPercentage")
        @Expose
        private float paymentOnAllotmentPercentage;
        @SerializedName("PaymentOnAllotmentAmount")
        @Expose
        private float paymentOnAllotmentAmount;
        @SerializedName("CourtCaseStatus")
        @Expose
        private String courtCaseStatus;
        @SerializedName("UnderMortgageStatus")
        @Expose
        private String underMortgageStatus;
        @SerializedName("UnderMisuseStatus")
        @Expose
        private String underMisuseStatus;
        @SerializedName("SurrenderStatus")
        @Expose
        private String surrenderStatus;
        @SerializedName("ResumptionStatus")
        @Expose
        private String resumptionStatus;
        @SerializedName("CancelledStatus")
        @Expose
        private String cancelledStatus;
        @SerializedName("DrawOrAuctionDate")
        @Expose
        private Object drawOrAuctionDate;
        @SerializedName("AllotmentDate")
        @Expose
        private String allotmentDate;
        @SerializedName("PossessionDate")
        @Expose
        private String possessionDate;
        @SerializedName("BuildingPlanSanctionDate")
        @Expose
        private String buildingPlanSanctionDate;
        @SerializedName("DPCIssueDate")
        @Expose
        private String dPCIssueDate;
        @SerializedName("POCIssueDate")
        @Expose
        private Object pOCIssueDate;
        @SerializedName("OCIssueDate")
        @Expose
        private String oCIssueDate;
        @SerializedName("ConveyanceLeaseDeedDate")
        @Expose
        private String conveyanceLeaseDeedDate;
        @SerializedName("OfferOfPossessionDate")
        @Expose
        private String offerOfPossessionDate;
        @SerializedName("CurrentPlotLength")
        @Expose
        private float currentPlotLength;
        @SerializedName("CurrentPlotBreadth")
        @Expose
        private float currentPlotBreadth;
        @SerializedName("CurrentPlotArea")
        @Expose
        private float currentPlotArea;
        @SerializedName("CurrentPlotDimension")
        @Expose
        private Object currentPlotDimension;
        @SerializedName("TypeOfProperty")
        @Expose
        private String typeOfProperty;
        @SerializedName("RentToBePaidBy")
        @Expose
        private Object rentToBePaidBy;
        @SerializedName("TypeOfPropertyDesc")
        @Expose
        private String typeOfPropertyDesc;
        @SerializedName("EnhancementCost")
        @Expose
        private float enhancementCost;
        @SerializedName("ChangedAreaDate")
        @Expose
        private String changedAreaDate;
        @SerializedName("AllotmentLetterMemoNumber")
        @Expose
        private String allotmentLetterMemoNumber;
        @SerializedName("Gender")
        @Expose
        private String gender;
        @SerializedName("MaritalStatus")
        @Expose
        private String maritalStatus;
        @SerializedName("DateOfSpouseDeath")
        @Expose
        private Object dateOfSpouseDeath;
        @SerializedName("DateOfRemarriage")
        @Expose
        private Object dateOfRemarriage;

        public String getUrbanEstateCode() {
            return urbanEstateCode;
        }

        public void setUrbanEstateCode(String urbanEstateCode) {
            this.urbanEstateCode = urbanEstateCode;
        }

        public String getUrbanEstateName() {
            return urbanEstateName;
        }

        public void setUrbanEstateName(String urbanEstateName) {
            this.urbanEstateName = urbanEstateName;
        }

        public String getSectorId() {
            return sectorId;
        }

        public void setSectorId(String sectorId) {
            this.sectorId = sectorId;
        }

        public String getPlotNumber() {
            return plotNumber;
        }

        public void setPlotNumber(String plotNumber) {
            this.plotNumber = plotNumber;
        }

        public String getCategoryCode() {
            return categoryCode;
        }

        public void setCategoryCode(String categoryCode) {
            this.categoryCode = categoryCode;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public String getSubCategoryCode() {
            return subCategoryCode;
        }

        public void setSubCategoryCode(String subCategoryCode) {
            this.subCategoryCode = subCategoryCode;
        }

        public String getSubCategoryName() {
            return subCategoryName;
        }

        public void setSubCategoryName(String subCategoryName) {
            this.subCategoryName = subCategoryName;
        }

        public String getModeOfAllotmentCode() {
            return modeOfAllotmentCode;
        }

        public void setModeOfAllotmentCode(String modeOfAllotmentCode) {
            this.modeOfAllotmentCode = modeOfAllotmentCode;
        }

        public String getModeOfAllotmentDesc() {
            return modeOfAllotmentDesc;
        }

        public void setModeOfAllotmentDesc(String modeOfAllotmentDesc) {
            this.modeOfAllotmentDesc = modeOfAllotmentDesc;
        }

        public int getNumberOfOwners() {
            return numberOfOwners;
        }

        public void setNumberOfOwners(int numberOfOwners) {
            this.numberOfOwners = numberOfOwners;
        }

        public String getColumn1() {
            return column1;
        }

        public void setColumn1(String column1) {
            this.column1 = column1;
        }

        public String getOriginalReservationCategoryDesc() {
            return originalReservationCategoryDesc;
        }

        public void setOriginalReservationCategoryDesc(String originalReservationCategoryDesc) {
            this.originalReservationCategoryDesc = originalReservationCategoryDesc;
        }

        public String getColumn2() {
            return column2;
        }

        public void setColumn2(String column2) {
            this.column2 = column2;
        }

        public String getOriginalReservationSubCategoryDesc1() {
            return originalReservationSubCategoryDesc1;
        }

        public void setOriginalReservationSubCategoryDesc1(String originalReservationSubCategoryDesc1) {
            this.originalReservationSubCategoryDesc1 = originalReservationSubCategoryDesc1;
        }

        public String getOriginalAllotteeName() {
            return originalAllotteeName;
        }

        public void setOriginalAllotteeName(String originalAllotteeName) {
            this.originalAllotteeName = originalAllotteeName;
        }

        public String getOriginalAllotteeFatherName() {
            return originalAllotteeFatherName;
        }

        public void setOriginalAllotteeFatherName(String originalAllotteeFatherName) {
            this.originalAllotteeFatherName = originalAllotteeFatherName;
        }

        public String getOriginalAllotteeSurname() {
            return originalAllotteeSurname;
        }

        public void setOriginalAllotteeSurname(String originalAllotteeSurname) {
            this.originalAllotteeSurname = originalAllotteeSurname;
        }

        public String getOriginalAllotteeFatherSurname() {
            return originalAllotteeFatherSurname;
        }

        public void setOriginalAllotteeFatherSurname(String originalAllotteeFatherSurname) {
            this.originalAllotteeFatherSurname = originalAllotteeFatherSurname;
        }

        public String getPresentOwnerName() {
            return presentOwnerName;
        }

        public void setPresentOwnerName(String presentOwnerName) {
            this.presentOwnerName = presentOwnerName;
        }

        public String getPresentOwnerSurname() {
            return presentOwnerSurname;
        }

        public void setPresentOwnerSurname(String presentOwnerSurname) {
            this.presentOwnerSurname = presentOwnerSurname;
        }

        public String getPresentOwnerFatherName() {
            return presentOwnerFatherName;
        }

        public void setPresentOwnerFatherName(String presentOwnerFatherName) {
            this.presentOwnerFatherName = presentOwnerFatherName;
        }

        public String getPresentOwnerFatherSurname() {
            return presentOwnerFatherSurname;
        }

        public void setPresentOwnerFatherSurname(String presentOwnerFatherSurname) {
            this.presentOwnerFatherSurname = presentOwnerFatherSurname;
        }

        public String getCurrentReservationCategoryCode() {
            return currentReservationCategoryCode;
        }

        public void setCurrentReservationCategoryCode(String currentReservationCategoryCode) {
            this.currentReservationCategoryCode = currentReservationCategoryCode;
        }

        public String getCurrentReservationCategoryDesc() {
            return currentReservationCategoryDesc;
        }

        public void setCurrentReservationCategoryDesc(String currentReservationCategoryDesc) {
            this.currentReservationCategoryDesc = currentReservationCategoryDesc;
        }

        public String getCurrentReservationSubCategoryCode() {
            return currentReservationSubCategoryCode;
        }

        public void setCurrentReservationSubCategoryCode(String currentReservationSubCategoryCode) {
            this.currentReservationSubCategoryCode = currentReservationSubCategoryCode;
        }

        public String getCurrentReservationSubCategoryDesc() {
            return currentReservationSubCategoryDesc;
        }

        public void setCurrentReservationSubCategoryDesc(String currentReservationSubCategoryDesc) {
            this.currentReservationSubCategoryDesc = currentReservationSubCategoryDesc;
        }

        public String getPermanentAddress1() {
            return permanentAddress1;
        }

        public void setPermanentAddress1(String permanentAddress1) {
            this.permanentAddress1 = permanentAddress1;
        }

        public String getPermanentAddress2() {
            return permanentAddress2;
        }

        public void setPermanentAddress2(String permanentAddress2) {
            this.permanentAddress2 = permanentAddress2;
        }

        public String getPermanentAddress3() {
            return permanentAddress3;
        }

        public void setPermanentAddress3(String permanentAddress3) {
            this.permanentAddress3 = permanentAddress3;
        }

        public String getPermanentState() {
            return permanentState;
        }

        public void setPermanentState(String permanentState) {
            this.permanentState = permanentState;
        }

        public int getPermanentPIN() {
            return permanentPIN;
        }

        public void setPermanentPIN(int permanentPIN) {
            this.permanentPIN = permanentPIN;
        }

        public String getCorrespondenceAddress1() {
            return correspondenceAddress1;
        }

        public void setCorrespondenceAddress1(String correspondenceAddress1) {
            this.correspondenceAddress1 = correspondenceAddress1;
        }

        public String getCorrespondenceAddress2() {
            return correspondenceAddress2;
        }

        public void setCorrespondenceAddress2(String correspondenceAddress2) {
            this.correspondenceAddress2 = correspondenceAddress2;
        }

        public String getCorrespondenceAddress3() {
            return correspondenceAddress3;
        }

        public void setCorrespondenceAddress3(String correspondenceAddress3) {
            this.correspondenceAddress3 = correspondenceAddress3;
        }

        public String getCorrespondenceState() {
            return correspondenceState;
        }

        public void setCorrespondenceState(String correspondenceState) {
            this.correspondenceState = correspondenceState;
        }

        public int getCorrespondencePIN() {
            return correspondencePIN;
        }

        public void setCorrespondencePIN(int correspondencePIN) {
            this.correspondencePIN = correspondencePIN;
        }

        public Object getPlotDimension() {
            return plotDimension;
        }

        public void setPlotDimension(Object plotDimension) {
            this.plotDimension = plotDimension;
        }

        public float getPlotLength() {
            return plotLength;
        }

        public void setPlotLength(float plotLength) {
            this.plotLength = plotLength;
        }

        public float getPlotBreadth() {
            return plotBreadth;
        }

        public void setPlotBreadth(float plotBreadth) {
            this.plotBreadth = plotBreadth;
        }

        public float getPlotArea() {
            return plotArea;
        }

        public void setPlotArea(float plotArea) {
            this.plotArea = plotArea;
        }

        public float getIncidentalArea() {
            return incidentalArea;
        }

        public void setIncidentalArea(float incidentalArea) {
            this.incidentalArea = incidentalArea;
        }

        public String getLocationStatus() {
            return locationStatus;
        }

        public void setLocationStatus(String locationStatus) {
            this.locationStatus = locationStatus;
        }

        public float getLocationCost() {
            return locationCost;
        }

        public void setLocationCost(float locationCost) {
            this.locationCost = locationCost;
        }

        public float getCost() {
            return cost;
        }

        public void setCost(float cost) {
            this.cost = cost;
        }

        public float getIncreasedCost() {
            return increasedCost;
        }

        public void setIncreasedCost(float increasedCost) {
            this.increasedCost = increasedCost;
        }

        public float getTotalCost() {
            return totalCost;
        }

        public void setTotalCost(float totalCost) {
            this.totalCost = totalCost;
        }

        public float getInitialPremium() {
            return initialPremium;
        }

        public void setInitialPremium(float initialPremium) {
            this.initialPremium = initialPremium;
        }

        public int getYearOfLease() {
            return yearOfLease;
        }

        public void setYearOfLease(int yearOfLease) {
            this.yearOfLease = yearOfLease;
        }

        public String getPayMode() {
            return payMode;
        }

        public void setPayMode(String payMode) {
            this.payMode = payMode;
        }

        public String getTypeOfInstalment1() {
            return typeOfInstalment1;
        }

        public void setTypeOfInstalment1(String typeOfInstalment1) {
            this.typeOfInstalment1 = typeOfInstalment1;
        }

        public String getTypeOfInstalment() {
            return typeOfInstalment;
        }

        public void setTypeOfInstalment(String typeOfInstalment) {
            this.typeOfInstalment = typeOfInstalment;
        }

        public String getPlotStatusDesc() {
            return plotStatusDesc;
        }

        public void setPlotStatusDesc(String plotStatusDesc) {
            this.plotStatusDesc = plotStatusDesc;
        }

        public String getPlotStatus() {
            return plotStatus;
        }

        public void setPlotStatus(String plotStatus) {
            this.plotStatus = plotStatus;
        }

        public Object getSchemeNumber() {
            return schemeNumber;
        }

        public void setSchemeNumber(Object schemeNumber) {
            this.schemeNumber = schemeNumber;
        }

        public Object getRegistrationNumber() {
            return registrationNumber;
        }

        public void setRegistrationNumber(Object registrationNumber) {
            this.registrationNumber = registrationNumber;
        }

        public float getIncidentalCost() {
            return incidentalCost;
        }

        public void setIncidentalCost(float incidentalCost) {
            this.incidentalCost = incidentalCost;
        }

        public int getOwnerID() {
            return ownerID;
        }

        public void setOwnerID(int ownerID) {
            this.ownerID = ownerID;
        }

        public int getNumberOfInstalment() {
            return numberOfInstalment;
        }

        public void setNumberOfInstalment(int numberOfInstalment) {
            this.numberOfInstalment = numberOfInstalment;
        }

        public float getDepositWithApplicationPercentage() {
            return depositWithApplicationPercentage;
        }

        public void setDepositWithApplicationPercentage(float depositWithApplicationPercentage) {
            this.depositWithApplicationPercentage = depositWithApplicationPercentage;
        }

        public float getDepositWithApplicationAmount() {
            return depositWithApplicationAmount;
        }

        public void setDepositWithApplicationAmount(float depositWithApplicationAmount) {
            this.depositWithApplicationAmount = depositWithApplicationAmount;
        }

        public float getPaymentOnAllotmentPercentage() {
            return paymentOnAllotmentPercentage;
        }

        public void setPaymentOnAllotmentPercentage(float paymentOnAllotmentPercentage) {
            this.paymentOnAllotmentPercentage = paymentOnAllotmentPercentage;
        }

        public float getPaymentOnAllotmentAmount() {
            return paymentOnAllotmentAmount;
        }

        public void setPaymentOnAllotmentAmount(float paymentOnAllotmentAmount) {
            this.paymentOnAllotmentAmount = paymentOnAllotmentAmount;
        }

        public String getCourtCaseStatus() {
            return courtCaseStatus;
        }

        public void setCourtCaseStatus(String courtCaseStatus) {
            this.courtCaseStatus = courtCaseStatus;
        }

        public String getUnderMortgageStatus() {
            return underMortgageStatus;
        }

        public void setUnderMortgageStatus(String underMortgageStatus) {
            this.underMortgageStatus = underMortgageStatus;
        }

        public String getUnderMisuseStatus() {
            return underMisuseStatus;
        }

        public void setUnderMisuseStatus(String underMisuseStatus) {
            this.underMisuseStatus = underMisuseStatus;
        }

        public String getSurrenderStatus() {
            return surrenderStatus;
        }

        public void setSurrenderStatus(String surrenderStatus) {
            this.surrenderStatus = surrenderStatus;
        }

        public String getResumptionStatus() {
            return resumptionStatus;
        }

        public void setResumptionStatus(String resumptionStatus) {
            this.resumptionStatus = resumptionStatus;
        }

        public String getCancelledStatus() {
            return cancelledStatus;
        }

        public void setCancelledStatus(String cancelledStatus) {
            this.cancelledStatus = cancelledStatus;
        }

        public Object getDrawOrAuctionDate() {
            return drawOrAuctionDate;
        }

        public void setDrawOrAuctionDate(Object drawOrAuctionDate) {
            this.drawOrAuctionDate = drawOrAuctionDate;
        }

        public String getAllotmentDate() {
            return allotmentDate;
        }

        public void setAllotmentDate(String allotmentDate) {
            this.allotmentDate = allotmentDate;
        }

        public String getPossessionDate() {
            return possessionDate;
        }

        public void setPossessionDate(String possessionDate) {
            this.possessionDate = possessionDate;
        }

        public String getBuildingPlanSanctionDate() {
            return buildingPlanSanctionDate;
        }

        public void setBuildingPlanSanctionDate(String buildingPlanSanctionDate) {
            this.buildingPlanSanctionDate = buildingPlanSanctionDate;
        }

        public String getDPCIssueDate() {
            return dPCIssueDate;
        }

        public void setDPCIssueDate(String dPCIssueDate) {
            this.dPCIssueDate = dPCIssueDate;
        }

        public Object getPOCIssueDate() {
            return pOCIssueDate;
        }

        public void setPOCIssueDate(Object pOCIssueDate) {
            this.pOCIssueDate = pOCIssueDate;
        }

        public String getOCIssueDate() {
            return oCIssueDate;
        }

        public void setOCIssueDate(String oCIssueDate) {
            this.oCIssueDate = oCIssueDate;
        }

        public String getConveyanceLeaseDeedDate() {
            return conveyanceLeaseDeedDate;
        }

        public void setConveyanceLeaseDeedDate(String conveyanceLeaseDeedDate) {
            this.conveyanceLeaseDeedDate = conveyanceLeaseDeedDate;
        }

        public String getOfferOfPossessionDate() {
            return offerOfPossessionDate;
        }

        public void setOfferOfPossessionDate(String offerOfPossessionDate) {
            this.offerOfPossessionDate = offerOfPossessionDate;
        }

        public float getCurrentPlotLength() {
            return currentPlotLength;
        }

        public void setCurrentPlotLength(float currentPlotLength) {
            this.currentPlotLength = currentPlotLength;
        }

        public float getCurrentPlotBreadth() {
            return currentPlotBreadth;
        }

        public void setCurrentPlotBreadth(float currentPlotBreadth) {
            this.currentPlotBreadth = currentPlotBreadth;
        }

        public float getCurrentPlotArea() {
            return currentPlotArea;
        }

        public void setCurrentPlotArea(float currentPlotArea) {
            this.currentPlotArea = currentPlotArea;
        }

        public Object getCurrentPlotDimension() {
            return currentPlotDimension;
        }

        public void setCurrentPlotDimension(Object currentPlotDimension) {
            this.currentPlotDimension = currentPlotDimension;
        }

        public String getTypeOfProperty() {
            return typeOfProperty;
        }

        public void setTypeOfProperty(String typeOfProperty) {
            this.typeOfProperty = typeOfProperty;
        }

        public Object getRentToBePaidBy() {
            return rentToBePaidBy;
        }

        public void setRentToBePaidBy(Object rentToBePaidBy) {
            this.rentToBePaidBy = rentToBePaidBy;
        }

        public String getTypeOfPropertyDesc() {
            return typeOfPropertyDesc;
        }

        public void setTypeOfPropertyDesc(String typeOfPropertyDesc) {
            this.typeOfPropertyDesc = typeOfPropertyDesc;
        }

        public float getEnhancementCost() {
            return enhancementCost;
        }

        public void setEnhancementCost(float enhancementCost) {
            this.enhancementCost = enhancementCost;
        }

        public String getChangedAreaDate() {
            return changedAreaDate;
        }

        public void setChangedAreaDate(String changedAreaDate) {
            this.changedAreaDate = changedAreaDate;
        }

        public String getAllotmentLetterMemoNumber() {
            return allotmentLetterMemoNumber;
        }

        public void setAllotmentLetterMemoNumber(String allotmentLetterMemoNumber) {
            this.allotmentLetterMemoNumber = allotmentLetterMemoNumber;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getMaritalStatus() {
            return maritalStatus;
        }

        public void setMaritalStatus(String maritalStatus) {
            this.maritalStatus = maritalStatus;
        }

        public Object getDateOfSpouseDeath() {
            return dateOfSpouseDeath;
        }

        public void setDateOfSpouseDeath(Object dateOfSpouseDeath) {
            this.dateOfSpouseDeath = dateOfSpouseDeath;
        }

        public Object getDateOfRemarriage() {
            return dateOfRemarriage;
        }

        public void setDateOfRemarriage(Object dateOfRemarriage) {
            this.dateOfRemarriage = dateOfRemarriage;
        }

    }


}
