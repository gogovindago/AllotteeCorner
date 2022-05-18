package hsvp.digital.allottee_corner.retrofitinterface;

import hsvp.digital.allottee_corner.model.GetAadharnoFromMemIDRequest;
import hsvp.digital.allottee_corner.model.GetAadharnoFromMemIDResponse;
import hsvp.digital.allottee_corner.model.GetMemberbasicdetailsfromFIDUIDRequest;
import hsvp.digital.allottee_corner.model.GetMemberbasicdetailsfromFIDUIDResponse;
import hsvp.digital.allottee_corner.model.OTPRequestforMEMIDRequest;
import hsvp.digital.allottee_corner.model.OTPRequestforMEMIDResponse;
import hsvp.digital.allottee_corner.model.VerifyOTPRequestforMEMIDRequest;
import hsvp.digital.allottee_corner.model.VerifyOTPRequestforMEMIDResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface2 {

    //http://164.100.137.245/PPPapi/api/Account/GetMemberbasicdetailsfromFIDUID
    @POST("GetMemberbasicdetailsfromFIDUID")
    Call<GetMemberbasicdetailsfromFIDUIDResponse> GetMemberbasicdetailsfromFIDUID(@Body GetMemberbasicdetailsfromFIDUIDRequest request);

    //http://164.100.137.245/PPPapi/api/Account/OTPRequestforMEMID
    @POST("OTPRequestforMEMID")
    Call<OTPRequestforMEMIDResponse> GetOTPRequestforMEMID(@Body OTPRequestforMEMIDRequest request);


    //http://164.100.137.245/PPPapi/api/Account/VerifyOTPRequestforMEMID
    @POST("VerifyOTPRequestforMEMID")
    Call<VerifyOTPRequestforMEMIDResponse> GetVerifyOTPRequestforMEMID(@Body VerifyOTPRequestforMEMIDRequest request);


    //http://164.100.137.245/PPPapi/api/Account/GetAadharnoFromMemID
    @POST("GetAadharnoFromMemID")
    Call<GetAadharnoFromMemIDResponse> GetAadharnoFromMemID(@Body GetAadharnoFromMemIDRequest request);





/*public string FamilyID { get; set; } 46
        public string memberID { get; set; }
        public string firstName { get; set; }
        public string lastName { get; set; }
        public string fullName { get; set; }
        public string fatherFullName { get; set; }
        public string motherFullName { get; set; }
        public string gender { get; set; }
        public string houseNo { get; set; }
        public string streetNo { get; set; }
        public string address_LandMark { get; set; }
        public string pinCode { get; set; }
        public string dCode { get; set; }
        public string btCode { get; set; }
        public string wvCode { get; set; }
        public string districtName { get; set; }
        public string btName { get; set; }
        public string wvName { get; set; }



        public string aadhaarNo { get; set; }
        public string dob { get; set; }
        public string mobileNo { get; set; }
        public string casteCategory { get; set; }
        public string familyIncome { get; set; }
        public string email { get; set; }
        public string bpl { get; set; }
        public string bplCardNO { get; set; }
        public string dCodeLGD { get; set; }
        public string btCodeLGD { get; set; }
        public string wvCodeLGD { get; set; }
        public string casteCategoryName { get; set; }
        public string disabilityType { get; set; }
        public string isDivyang { get; set; }
        public string divyangPercentage { get; set; }
        public string IsDenotifiedTribe { get; set; }
        public string isDOBVerified { get; set; }
        public string isCasteVerified { get; set; }
        public string isIncomeVerified { get; set; }
        public string isBPLVerified { get; set; }
        public string isDivyangVerified { get; set; }
        public string subCaste_code { get; set; }
        public string subCaste_name { get; set; }
        public string casteDescription { get; set; }
        public string divyangCategory { get; set; }
        public string deprived { get; set; }
        public string Religion { get; set; }
        public string AuthPwd { get; set; }


https://cmapi.highereduhry.ac.in/api/commonapi/StudentRegistration


 @FormUrlEncoded
    @POST("StudentRegistration")
    Call<StudentRegistrationResponse> StudentRegistration_Api(@Field("Registration_Id") String Registration_Id,
                                                                             @Field("Description") String Description,
                                                                             @Field("Longitude") String Longitude,
                                                                             @Field("Latitude") String Latitude,
                                                                             @Field("ImageDate") String ImageDate,
                                                                             @Field("ImagePath") String ImagePath);




        */










































/*


 @FormUrlEncoded
    @POST("student")
    Call<StudentEventDataSaveResponse> STUDENT_EVENT_DATA_SAVE_RESPONSE_CALL(@Field("Registration_Id") String Registration_Id,
                                                                             @Field("Description") String Description,
                                                                             @Field("Longitude") String Longitude,
                                                                             @Field("Latitude") String Latitude,
                                                                             @Field("ImageDate") String ImageDate,
                                                                             @Field("ImagePath") String ImagePath);


    @GET("Dashboard/")
    Call<AdminDataResponse> adminDataAPi(@Header("Authorization") String token);


    //http://112.196.99.107:81/api/commonapi/GetAllHomeImages/1
    @GET("GetAllHomeImages/{typeId}")
    Call<ViewAllResponse> getAllDataAPi(@Path("typeId") String s);

    //https://localhost:44375/api/commonapi/GetLibrariesByTypeId/1
    @GET("GetLibrariesByTypeId/{typeId}")
    Call<LibraryTypeByIdResponse> getLibraryTypeByIdDataAPi(@Path("typeId") String s);


    @GET("GetAllLibrariesType")
    Call<LibraryTypeAndCoutResponse> getAllLibraryTypeAPi();

    @GET("DivyangjanSubjectVisuallyImapired")
    Call<DivyangjanSubjectVisuallyImapiredResponse> getAllDivyangjanSubjectVisuallyImapiredAPi();

    //"http://112.196.99.107:81/api/commonapi/DivyangjanGetListByDistrictID/2"
    @GET("DivyangjanGetListByDistrictID/{DistrictIDORCastIDORCOurseID}")
    Call<RegisteredListResponse> FilteredListDataAPi(@Path("DistrictIDORCastIDORCOurseID") String s);


    @GET("DivyangjanGetAllCourse")
    Call<FilterAllCourseResponse> GetFilterAllCourseDataAPi();

    //http://divyangjanapi.highereduhry.ac.in/api/commonapi/DivyangjanCourseSugham
    @GET("DivyangjanCourseSugham")
    Call<DivyangjanCourseSughamResponse> DivyangjanGetCourseClassDataAPi();


    @GET("DivyangjanGetDistrict")
    Call<DivyangjanGetDistrictResponse> DivyangjanGetDistrictDataAPi();

    //DivyangjanAPI.highereduhry.ac.in/api/commonapi/DivyangjanHeadingVisuallyImapired

    @POST("DivyangjanHeadingVisuallyImapired")
    Call<HeadingVisuallyImapiredResponse> HeadingVisuallyImapiredListDataAPi(@Body HeadingVisuallyImapiredRequest sughamRequest);


    @GET("DivyangjanCourseHearing")
    Call<CourseHearingResponse> CourseHearingListDataAPi();


    @POST("CreateUser")
    Call<RegisterResponse> CreateUserDataAPi(@Body RegisterRequest request);


    @POST("DivyangjanSubjectHearing")
    Call<SubjectHearingResponse> SubjectHearingListDataAPi(@Body DivyangjanSubjectHearingRequest request);


    @POST("DivyangjanSubjectSugham")
    Call<DivyangjanSubjectSughamResponse> SubjectSughamListDataAPi(@Body DivyangjanSubjectSughamRequest sughamRequest);


    @POST("DivyangjanGetVisuallyImapired")
    Call<VisualyImapiredcontentResponse> VisuallyImapiredListDataAPi(@Body DivyangjanvisuallyImparedRequest request);


    @POST("DivyangjanHearing")
    Call<HearingContentResponse> HearingContentListDataAPi(@Body DivyangjanHearingContentRequest request);


    @POST("DivyangjanSughamLibrary")
    Call<DivyangjanSughamLibraryResponse> SughamLibraryListDataAPi(@Body DivyangjanSughamLibraryRequest request);


    //DivyangjanAPI.highereduhry.ac.in/api/commonapi/DivyangjanGetAllList/19/Y
    @GET("DivyangjanGetAllList/{CollegeId}/{VerificattionStatus}")
    Call<RegisteredListResponse> RegisteredListDataAPi(@Path("CollegeId") String CollegeId, @Path("VerificattionStatus") String VerificattionStatus);

    @GET("DivyangjanGetCasteCategory")
    Call<CastCategoryResponse> CastCategoryDataAPi();


    //http://112.196.99.107:81/api/commonapi/GetProfile/9499486861
    @GET("GetProfile/{MobileNo}")
    Call<ProfileDataResponse> getProfileDataAPi(@Path("MobileNo") String s);


    @GET("DivyangjanGetHomeImages/{UserMobileNo}")
    Call<HomePageResponse> getHomePageDataAPi(@Path("UserMobileNo") String s);


    //http://112.196.99.107:81/api/commonapi/GetHearingSpeechimpairedData
    @GET("GetHearingSpeechimpairedData")
    Call<HearingSpeechimpairedDataResponse> getAllGetHearingSpeechimpairedDataAPi();


    //http://112.196.99.107:81/DigitalLibrary/api/commonapi/UserLogin/7018401817/1234
    @POST("DivyangjanLogin")
    Call<LoginResponse> LoginUser(@Body LoginRequest request);

    // http://112.196.99.107:81/api/commonapi/ForgetPassword
    @POST("ForgetPassword")
    Call<ForgotPasswordResponse> ForgetPasswordUser(@Body ForgotPasswordRequest request);


    @POST("ChangePassword")
    Call<ResetPasswordResponse> ResetforgotPassword(@Body ResetPasswordRequest request);


    //http://112.196.99.107:81/api/commonapi/VerifyOTP
    @POST("VerifyOTP")
    Call<VerifyOtpResponse> verifyOTP(@Body VerifyOtpRequest request);


    @GET("DivyangjanGetAllState")
    Call<StateResponse> StateResponseDataAPi();


    @GET("DivyangjanGetDisability")
    Call<DisabilityTypeResponse> DivyangjanGetDisabilityTypeOthersUserDataAPi();


    @Multipart
    @POST("DivyangjanOtherRegistration")
    Call<RegistrationRespone> completeRegistrationByOtherStudent(
            @Part("StudentId") RequestBody StudentId,
            @Part("MobileNo") RequestBody MobileNo,
            @Part MultipartBody.Part CertificatePath);

    @Multipart
    @POST("DivyangjanRegistration")
    Call<RegistrationRespone> completeRegistrationByHryStudent(
            @Part("District") RequestBody District_Id,
            @Part("College") RequestBody college,
            @Part("Course") RequestBody Course,
            @Part("Section") RequestBody Section,
            @Part("Combination") RequestBody Combination,
            @Part("RollNo") RequestBody RollNo,
            @Part("StudentName") RequestBody StudentName,
            @Part("FatherName") RequestBody FatherName,
            @Part("DOB") RequestBody DOB,
            @Part("Gender") RequestBody Gender,
            @Part("MobileNo") RequestBody MobileNo,
            @Part("ParentMobileNo") RequestBody ParentMobileNo,
            @Part("PercentageOfDisability") RequestBody PercentageOfDisability,
            @Part("DifferentlyAbledCategory") RequestBody DifferentlyAbledCategory,
            @Part("Disabiltyid") RequestBody Diabiltyid,
            @Part("DifferentlyAskedCategory") RequestBody DifferentlyAskedCategory,
            @Part("CasteCategory") RequestBody CasteCategory,
            @Part("Address") RequestBody Address,
            @Part("Password") RequestBody confirmpassword,
            @Part("StateId") RequestBody StateId,
            @Part("Email") RequestBody EmailID,
            @Part("FCMToken") RequestBody FcmToken_Id,
            @Part("Usertype") RequestBody userType,
            @Part("Sem") RequestBody Sem,
            @Part("OtherCollege") RequestBody OtherCollege,
            @Part("OtherCourse") RequestBody OtherCourse,
            @Part("OtherSection") RequestBody OtherSection,
            @Part("OtherSubjectCombination") RequestBody OtherSubjectCombination,
            @Part("StudentId") RequestBody StudentId,
            @Part MultipartBody.Part FilePath,
            @Part MultipartBody.Part CertificatePath);


    @GET("DivyangjanGetCollegeByDistrictID/{DistrictID}")
    Call<CollegeListResponse> CollegeDataAPi(@Path("DistrictID") String s);


    @GET("DivyangjanGetCourseByCollegeID/{collegeID}")
    Call<CourseByCollegeIDResponse> CourseDataAPi(@Path("collegeID") String s);
    // DivyangjanGetSectioneByCollegeIDANDCourseID/{CollegeID}/{CourseID}

    @GET("DivyangjanGetSectioneByCollegeIDANDCourseID/{CollegeID}/{CourseID}")
    Call<SectionResponse> SectionDataAPi(@Path("CollegeID") String CollegeID, @Path("CourseID") String s);

    //"http://112.196.99.107:81/api/commonapi/DivyangjanGetSubjectCombinationByCollegeIDANDCourseIDAndSectionId/2/3/4"
    @GET("DivyangjanGetSubjectCombinationByCollegeIDANDCourseIDAndSectionId/{CollegeID}/{CourseID}/{SectionId}")
    Call<SubjectCombinationResponse> SubjectCombinationAPi(@Path("CollegeID") String CollegeID, @Path("CourseID") String CourseID, @Path("SectionId") String SectionId);

*/

}
