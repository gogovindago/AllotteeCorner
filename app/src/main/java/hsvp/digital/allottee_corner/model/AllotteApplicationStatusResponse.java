package hsvp.digital.allottee_corner.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class AllotteApplicationStatusResponse {


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

        @SerializedName("EstateOfficeName")
        @Expose
        private String estateOfficeName;
        @SerializedName("UrbanEstateName")
        @Expose
        private String urbanEstateName;
        @SerializedName("CategoryName")
        @Expose
        private String categoryName;
        @SerializedName("SubCategoryName")
        @Expose
        private String subCategoryName;
        @SerializedName("SectorId")
        @Expose
        private String sectorId;
        @SerializedName("PlotNumber")
        @Expose
        private String plotNumber;
        @SerializedName("ProcessName")
        @Expose
        private String processName;
        @SerializedName("ApplicationNumber")
        @Expose
        private String applicationNumber;
        @SerializedName("ApplicationStatus")
        @Expose
        private String applicationStatus;
        @SerializedName("ProcessingOfficialDesignation")
        @Expose
        private String processingOfficialDesignation;
        @SerializedName("ProcessingDate")
        @Expose
        private String processingDate;
        @SerializedName("ProcessingDateToSort")
        @Expose
        private String processingDateToSort;

        public String getEstateOfficeName() {
            return estateOfficeName;
        }

        public void setEstateOfficeName(String estateOfficeName) {
            this.estateOfficeName = estateOfficeName;
        }

        public String getUrbanEstateName() {
            return urbanEstateName;
        }

        public void setUrbanEstateName(String urbanEstateName) {
            this.urbanEstateName = urbanEstateName;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public String getSubCategoryName() {
            return subCategoryName;
        }

        public void setSubCategoryName(String subCategoryName) {
            this.subCategoryName = subCategoryName;
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

        public String getProcessName() {
            return processName;
        }

        public void setProcessName(String processName) {
            this.processName = processName;
        }

        public String getApplicationNumber() {
            return applicationNumber;
        }

        public void setApplicationNumber(String applicationNumber) {
            this.applicationNumber = applicationNumber;
        }

        public String getApplicationStatus() {
            return applicationStatus;
        }

        public void setApplicationStatus(String applicationStatus) {
            this.applicationStatus = applicationStatus;
        }

        public String getProcessingOfficialDesignation() {
            return processingOfficialDesignation;
        }

        public void setProcessingOfficialDesignation(String processingOfficialDesignation) {
            this.processingOfficialDesignation = processingOfficialDesignation;
        }

        public String getProcessingDate() {
            return processingDate;
        }

        public void setProcessingDate(String processingDate) {
            this.processingDate = processingDate;
        }

        public String getProcessingDateToSort() {
            return processingDateToSort;
        }

        public void setProcessingDateToSort(String processingDateToSort) {
            this.processingDateToSort = processingDateToSort;
        }

    }
}
