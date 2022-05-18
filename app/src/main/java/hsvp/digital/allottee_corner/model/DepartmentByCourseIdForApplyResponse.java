package hsvp.digital.allottee_corner.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class DepartmentByCourseIdForApplyResponse {


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

    public static class Datum {

        @SerializedName("department_Id")
        @Expose
        private int departmentId;
        @SerializedName("department")
        @Expose
        private String department;
        @SerializedName("course_Id")
        @Expose
        private int courseId;
        @SerializedName("courseName")
        @Expose
        private String courseName;
        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("courseLevel")
        @Expose
        private String courseLevel;
        @SerializedName("is_Degree_Courses")
        @Expose
        private String isDegreeCourses;
        @SerializedName("courseCategory")
        @Expose
        private String courseCategory;
        @SerializedName("courseDuration")
        @Expose
        private int courseDuration;

        public int getDepartmentId() {
            return departmentId;
        }

        public void setDepartmentId(int departmentId) {
            this.departmentId = departmentId;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
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

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getCourseLevel() {
            return courseLevel;
        }

        public void setCourseLevel(String courseLevel) {
            this.courseLevel = courseLevel;
        }

        public String getIsDegreeCourses() {
            return isDegreeCourses;
        }

        public void setIsDegreeCourses(String isDegreeCourses) {
            this.isDegreeCourses = isDegreeCourses;
        }

        public String getCourseCategory() {
            return courseCategory;
        }

        public void setCourseCategory(String courseCategory) {
            this.courseCategory = courseCategory;
        }

        public int getCourseDuration() {
            return courseDuration;
        }

        public void setCourseDuration(int courseDuration) {
            this.courseDuration = courseDuration;
        }

    }

}
