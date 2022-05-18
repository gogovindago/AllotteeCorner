package hsvp.digital.allottee_corner.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class GetMemberbasicdetailsfromFIDUIDResponse {

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

    public static class Dropdown {

        @SerializedName("value")
        @Expose
        private String value;
        @SerializedName("text")
        @Expose
        private String text;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

    }

    public static class Result {

        @SerializedName("dropdown")
        @Expose
        private List<Dropdown> dropdown = new ArrayList<Dropdown>();
        @SerializedName("fam")
        @Expose
        private String fam;

        public List<Dropdown> getDropdown() {
            return dropdown;
        }

        public void setDropdown(List<Dropdown> dropdown) {
            this.dropdown = dropdown;
        }

        public String getFam() {
            return fam;
        }

        public void setFam(String fam) {
            this.fam = fam;
        }

    }

}
