
package hsvp.digital.allottee_corner.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class HomePageResponse {


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

    public static class Banner {

        @SerializedName("id")
        @Expose
        private int id;
        @SerializedName("fileName")
        @Expose
        private String fileName;
        @SerializedName("filePath")
        @Expose
        private String filePath;
        @SerializedName("description")
        @Expose
        private String description;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public String getFilePath() {
            return filePath;
        }

        public void setFilePath(String filePath) {
            this.filePath = filePath;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

    }
    public class Data {

        @SerializedName("banners")
        @Expose
        private List<Banner> banners = new ArrayList<Banner>();
        @SerializedName("officers")
        @Expose
        private List<Officer> officers = new ArrayList<Officer>();
        @SerializedName("totalRegs")
        @Expose
        private List<TotalReg> totalRegs = new ArrayList<TotalReg>();

        @SerializedName("registrations")
        @Expose
        private List<Registration> registrations = new ArrayList<Registration>();

        @SerializedName("otherregistrations")
        @Expose
        private List<Otherregistration> otherregistrations = new ArrayList<Otherregistration>();


        public List<Otherregistration> getOtherregistrations() {
            return otherregistrations;
        }

        public void setOtherregistrations(List<Otherregistration> otherregistrations) {
            this.otherregistrations = otherregistrations;
        }

        public List<Registration> getRegistrations() {
            return registrations;
        }

        public void setRegistrations(List<Registration> registrations) {
            this.registrations = registrations;
        }
        public List<Banner> getBanners() {
            return banners;
        }

        public void setBanners(List<Banner> banners) {
            this.banners = banners;
        }

        public List<Officer> getOfficers() {
            return officers;
        }

        public void setOfficers(List<Officer> officers) {
            this.officers = officers;
        }

        public List<TotalReg> getTotalRegs() {
            return totalRegs;
        }

        public void setTotalRegs(List<TotalReg> totalRegs) {
            this.totalRegs = totalRegs;
        }

    }

    public class Otherregistration {

        @SerializedName("mobile")
        @Expose
        private String mobile;
        @SerializedName("isverified")
        @Expose
        private String isverified;

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getIsverified() {
            return isverified;
        }

        public void setIsverified(String isverified) {
            this.isverified = isverified;
        }

    }


    public class Registration {

        @SerializedName("mobileNo")
        @Expose
        private String mobileNo;
        @SerializedName("isverified")
        @Expose
        private String isverified;

        public String getMobileNo() {
            return mobileNo;
        }

        public void setMobileNo(String mobileNo) {
            this.mobileNo = mobileNo;
        }

        public String getIsverified() {
            return isverified;
        }

        public void setIsverified(String isverified) {
            this.isverified = isverified;
        }

    }
    public class Officer {

        @SerializedName("id")
        @Expose
        private int id;
        @SerializedName("imageName")
        @Expose
        private String imageName;
        @SerializedName("imagePath")
        @Expose
        private String imagePath;
        @SerializedName("designation")
        @Expose
        private String designation;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImageName() {
            return imageName;
        }

        public void setImageName(String imageName) {
            this.imageName = imageName;
        }

        public String getImagePath() {
            return imagePath;
        }

        public void setImagePath(String imagePath) {
            this.imagePath = imagePath;
        }

        public String getDesignation() {
            return designation;
        }

        public void setDesignation(String designation) {
            this.designation = designation;
        }

    }

    public class TotalReg {

        @SerializedName("totalRegistrations")
        @Expose
        private String totalRegistrations;
        @SerializedName("totalVerifiedRegistrations")
        @Expose
        private String totalVerifiedRegistrations;
        @SerializedName("totalUnverifiedRegistrations")
        @Expose
        private String totalUnverifiedRegistrations;

        public String getTotalRegistrations() {
            return totalRegistrations;
        }

        public void setTotalRegistrations(String totalRegistrations) {
            this.totalRegistrations = totalRegistrations;
        }

        public String getTotalVerifiedRegistrations() {
            return totalVerifiedRegistrations;
        }

        public void setTotalVerifiedRegistrations(String totalVerifiedRegistrations) {
            this.totalVerifiedRegistrations = totalVerifiedRegistrations;
        }

        public String getTotalUnverifiedRegistrations() {
            return totalUnverifiedRegistrations;
        }

        public void setTotalUnverifiedRegistrations(String totalUnverifiedRegistrations) {
            this.totalUnverifiedRegistrations = totalUnverifiedRegistrations;
        }

    }






}
