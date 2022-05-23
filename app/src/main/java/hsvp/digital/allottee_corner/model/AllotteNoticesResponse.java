package hsvp.digital.allottee_corner.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class AllotteNoticesResponse {
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

        @SerializedName("PlotId")
        @Expose
        private int plotId;
        @SerializedName("NoticeSectionNumber")
        @Expose
        private String noticeSectionNumber;
        @SerializedName("NoticeDate")
        @Expose
        private String noticeDate;
        @SerializedName("SurveyDate")
        @Expose
        private String surveyDate;
        @SerializedName("ActionStatus")
        @Expose
        private String actionStatus;
        @SerializedName("NoticeMemoNumber")
        @Expose
        private String noticeMemoNumber;
        @SerializedName("PenaltyAmount")
        @Expose
        private float penaltyAmount;

        public int getPlotId() {
            return plotId;
        }

        public void setPlotId(int plotId) {
            this.plotId = plotId;
        }

        public String getNoticeSectionNumber() {
            return noticeSectionNumber;
        }

        public void setNoticeSectionNumber(String noticeSectionNumber) {
            this.noticeSectionNumber = noticeSectionNumber;
        }

        public String getNoticeDate() {
            return noticeDate;
        }

        public void setNoticeDate(String noticeDate) {
            this.noticeDate = noticeDate;
        }

        public String getSurveyDate() {
            return surveyDate;
        }

        public void setSurveyDate(String surveyDate) {
            this.surveyDate = surveyDate;
        }

        public String getActionStatus() {
            return actionStatus;
        }

        public void setActionStatus(String actionStatus) {
            this.actionStatus = actionStatus;
        }

        public String getNoticeMemoNumber() {
            return noticeMemoNumber;
        }

        public void setNoticeMemoNumber(String noticeMemoNumber) {
            this.noticeMemoNumber = noticeMemoNumber;
        }

        public float getPenaltyAmount() {
            return penaltyAmount;
        }

        public void setPenaltyAmount(float penaltyAmount) {
            this.penaltyAmount = penaltyAmount;
        }

    }
}
