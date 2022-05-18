package hsvp.digital.allottee_corner.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AcademicSessionResponse {

    @SerializedName("response")
    @Expose
    private int response;
    @SerializedName("sys_message")
    @Expose
    private String sysMessage;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

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

    public static class Datum {

        @SerializedName("academicSession")
        @Expose
        private String academicSession;
        @SerializedName("academicSessionId")
        @Expose
        private int academicSessionid;

        public int getAcademicSessionid() {
            return academicSessionid;
        }

        public void setAcademicSessionid(int academicSessionid) {
            this.academicSessionid = academicSessionid;
        }

        public String getAcademicSession() {
            return academicSession;
        }

        public void setAcademicSession(String academicSession) {
            this.academicSession = academicSession;
        }

    }
}
