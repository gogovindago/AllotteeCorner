package hsvp.digital.allottee_corner.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class LoginResponse {

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

        @SerializedName("ApplicationId")
        @Expose
        private String applicationId;
        @SerializedName("UserId")
        @Expose
        private String userId;
        @SerializedName("UserName")
        @Expose
        private String userName;
        @SerializedName("LoweredUserName")
        @Expose
        private String loweredUserName;
        @SerializedName("MobileAlias")
        @Expose
        private String mobileAlias;
        @SerializedName("IsAnonymous")
        @Expose
        private boolean isAnonymous;
        @SerializedName("LastActivityDate")
        @Expose
        private String lastActivityDate;
        @SerializedName("ApplicationId1")
        @Expose
        private String applicationId1;
        @SerializedName("UserId1")
        @Expose
        private String userId1;
        @SerializedName("Password")
        @Expose
        private String password;
        @SerializedName("PasswordFormat")
        @Expose
        private int passwordFormat;
        @SerializedName("PasswordSalt")
        @Expose
        private String passwordSalt;
        @SerializedName("MobilePIN")
        @Expose
        private String mobilePIN;
        @SerializedName("Email")
        @Expose
        private String email;
        @SerializedName("LoweredEmail")
        @Expose
        private String loweredEmail;
        @SerializedName("PasswordQuestion")
        @Expose
        private String passwordQuestion;
        @SerializedName("PasswordAnswer")
        @Expose
        private String passwordAnswer;
        @SerializedName("IsApproved")
        @Expose
        private boolean isApproved;
        @SerializedName("IsLockedOut")
        @Expose
        private boolean isLockedOut;
        @SerializedName("CreateDate")
        @Expose
        private String createDate;
        @SerializedName("LastLoginDate")
        @Expose
        private String lastLoginDate;
        @SerializedName("LastPasswordChangedDate")
        @Expose
        private String lastPasswordChangedDate;
        @SerializedName("LastLockoutDate")
        @Expose
        private String lastLockoutDate;
        @SerializedName("FailedPasswordAttemptCount")
        @Expose
        private int failedPasswordAttemptCount;
        @SerializedName("FailedPasswordAttemptWindowStart")
        @Expose
        private String failedPasswordAttemptWindowStart;
        @SerializedName("FailedPasswordAnswerAttemptCount")
        @Expose
        private int failedPasswordAnswerAttemptCount;
        @SerializedName("FailedPasswordAnswerAttemptWindowStart")
        @Expose
        private String failedPasswordAnswerAttemptWindowStart;
        @SerializedName("Comment")
        @Expose
        private String comment;
        
        
        @SerializedName("uEmail")
        @Expose
        private String uEmail;

        @SerializedName("uMobile")
        @Expose
        private String uMobile;

        @SerializedName("uName")
        @Expose
        private String uName;


        public boolean isAnonymous() {
            return isAnonymous;
        }

        public void setAnonymous(boolean anonymous) {
            isAnonymous = anonymous;
        }

        public boolean isApproved() {
            return isApproved;
        }

        public void setApproved(boolean approved) {
            isApproved = approved;
        }

        public boolean isLockedOut() {
            return isLockedOut;
        }

        public void setLockedOut(boolean lockedOut) {
            isLockedOut = lockedOut;
        }

        public String getuEmail() {
            return uEmail;
        }

        public void setuEmail(String uEmail) {
            this.uEmail = uEmail;
        }

        public String getuMobile() {
            return uMobile;
        }

        public void setuMobile(String uMobile) {
            this.uMobile = uMobile;
        }

        public String getuName() {
            return uName;
        }

        public void setuName(String uName) {
            this.uName = uName;
        }

        public String getApplicationId() {
            return applicationId;
        }

        public void setApplicationId(String applicationId) {
            this.applicationId = applicationId;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getLoweredUserName() {
            return loweredUserName;
        }

        public void setLoweredUserName(String loweredUserName) {
            this.loweredUserName = loweredUserName;
        }

        public String getMobileAlias() {
            return mobileAlias;
        }

        public void setMobileAlias(String mobileAlias) {
            this.mobileAlias = mobileAlias;
        }

        public boolean isIsAnonymous() {
            return isAnonymous;
        }

        public void setIsAnonymous(boolean isAnonymous) {
            this.isAnonymous = isAnonymous;
        }

        public String getLastActivityDate() {
            return lastActivityDate;
        }

        public void setLastActivityDate(String lastActivityDate) {
            this.lastActivityDate = lastActivityDate;
        }

        public String getApplicationId1() {
            return applicationId1;
        }

        public void setApplicationId1(String applicationId1) {
            this.applicationId1 = applicationId1;
        }

        public String getUserId1() {
            return userId1;
        }

        public void setUserId1(String userId1) {
            this.userId1 = userId1;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public int getPasswordFormat() {
            return passwordFormat;
        }

        public void setPasswordFormat(int passwordFormat) {
            this.passwordFormat = passwordFormat;
        }

        public String getPasswordSalt() {
            return passwordSalt;
        }

        public void setPasswordSalt(String passwordSalt) {
            this.passwordSalt = passwordSalt;
        }

        public String getMobilePIN() {
            return mobilePIN;
        }

        public void setMobilePIN(String mobilePIN) {
            this.mobilePIN = mobilePIN;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getLoweredEmail() {
            return loweredEmail;
        }

        public void setLoweredEmail(String loweredEmail) {
            this.loweredEmail = loweredEmail;
        }

        public String getPasswordQuestion() {
            return passwordQuestion;
        }

        public void setPasswordQuestion(String passwordQuestion) {
            this.passwordQuestion = passwordQuestion;
        }

        public String getPasswordAnswer() {
            return passwordAnswer;
        }

        public void setPasswordAnswer(String passwordAnswer) {
            this.passwordAnswer = passwordAnswer;
        }

        public boolean isIsApproved() {
            return isApproved;
        }

        public void setIsApproved(boolean isApproved) {
            this.isApproved = isApproved;
        }

        public boolean isIsLockedOut() {
            return isLockedOut;
        }

        public void setIsLockedOut(boolean isLockedOut) {
            this.isLockedOut = isLockedOut;
        }

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }

        public String getLastLoginDate() {
            return lastLoginDate;
        }

        public void setLastLoginDate(String lastLoginDate) {
            this.lastLoginDate = lastLoginDate;
        }

        public String getLastPasswordChangedDate() {
            return lastPasswordChangedDate;
        }

        public void setLastPasswordChangedDate(String lastPasswordChangedDate) {
            this.lastPasswordChangedDate = lastPasswordChangedDate;
        }

        public String getLastLockoutDate() {
            return lastLockoutDate;
        }

        public void setLastLockoutDate(String lastLockoutDate) {
            this.lastLockoutDate = lastLockoutDate;
        }

        public int getFailedPasswordAttemptCount() {
            return failedPasswordAttemptCount;
        }

        public void setFailedPasswordAttemptCount(int failedPasswordAttemptCount) {
            this.failedPasswordAttemptCount = failedPasswordAttemptCount;
        }

        public String getFailedPasswordAttemptWindowStart() {
            return failedPasswordAttemptWindowStart;
        }

        public void setFailedPasswordAttemptWindowStart(String failedPasswordAttemptWindowStart) {
            this.failedPasswordAttemptWindowStart = failedPasswordAttemptWindowStart;
        }

        public int getFailedPasswordAnswerAttemptCount() {
            return failedPasswordAnswerAttemptCount;
        }

        public void setFailedPasswordAnswerAttemptCount(int failedPasswordAnswerAttemptCount) {
            this.failedPasswordAnswerAttemptCount = failedPasswordAnswerAttemptCount;
        }

        public String getFailedPasswordAnswerAttemptWindowStart() {
            return failedPasswordAnswerAttemptWindowStart;
        }

        public void setFailedPasswordAnswerAttemptWindowStart(String failedPasswordAnswerAttemptWindowStart) {
            this.failedPasswordAnswerAttemptWindowStart = failedPasswordAnswerAttemptWindowStart;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }
    }

}
