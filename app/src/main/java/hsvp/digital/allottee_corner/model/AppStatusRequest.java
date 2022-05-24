package hsvp.digital.allottee_corner.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AppStatusRequest {

    @SerializedName("plotID")
    @Expose
    private String plotID;

    @SerializedName("option")
    @Expose
    private String option;

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getPlotID() {
        return plotID;
    }

    public void setPlotID(String plotID) {
        this.plotID = plotID;
    }
}
