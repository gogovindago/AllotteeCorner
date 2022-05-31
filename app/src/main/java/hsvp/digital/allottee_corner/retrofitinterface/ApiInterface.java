package hsvp.digital.allottee_corner.retrofitinterface;

import hsvp.digital.allottee_corner.model.AlloteeHistoryResponse;
import hsvp.digital.allottee_corner.model.AllotteApplicationStatusResponse;
import hsvp.digital.allottee_corner.model.AllotteCurrentOutStandingResponse;
import hsvp.digital.allottee_corner.model.AllotteNoticesResponse;
import hsvp.digital.allottee_corner.model.AllottePaymentReceivedDetailsResponse;
import hsvp.digital.allottee_corner.model.AllottePaymentReceivedResponse;
import hsvp.digital.allottee_corner.model.AllottePlotInfoResponse;
import hsvp.digital.allottee_corner.model.AllottefutureOutStandingDetailsResponse;
import hsvp.digital.allottee_corner.model.AllottefutureOutStandingResponse;
import hsvp.digital.allottee_corner.model.AllotteplotdetailsResponse;
import hsvp.digital.allottee_corner.model.AppStatusRequest;
import hsvp.digital.allottee_corner.model.FetchAllottedetailsResponse;
import hsvp.digital.allottee_corner.model.FetchJointHolderDetailsResponse;
import hsvp.digital.allottee_corner.model.ForgotPasswordRequest;
import hsvp.digital.allottee_corner.model.ForgotPasswordResponse;
import hsvp.digital.allottee_corner.model.LoginRequest;
import hsvp.digital.allottee_corner.model.LoginResponse;
import hsvp.digital.allottee_corner.model.PaymentReceivedDetailsRequest;
import hsvp.digital.allottee_corner.model.PlotIdRequest;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {

    /*
https://cmapi.highereduhry.ac.in/api/commonapi/UserLogin
{
    "AuthID":"superadmin",
    "Password":"12345",
    "FCMToken":"ccvcvcvcvcv"

    }




8269970959

*/

    @POST("Login")
    Call<LoginResponse> LoginUser(@Body LoginRequest request);

    @POST("allotteCurrentOutStanding")
    Call<AllotteCurrentOutStandingResponse> allotteCurrentOutStandingApi(@Body PlotIdRequest request);


    @POST("allotteCurrentOutStandingDetails")
    Call<AllotteCurrentOutStandingResponse> allotteCurrentOutStandingDetailsApi(@Body PlotIdRequest request);


    @POST("allotteplotdetails")
    Call<AllotteplotdetailsResponse> allotteplotdetailsAPi(@Body PlotIdRequest request);


    @POST("allottefutureOutStanding")
    Call<AllottefutureOutStandingResponse> allottefutureOutStandingAPi(@Body PlotIdRequest request);


    @POST("FetchAllottedetails")
    Call<FetchAllottedetailsResponse> FetchAllottedetailsAPi(@Body PlotIdRequest request);


    @POST("FetchJointHolderDetails")
    Call<FetchJointHolderDetailsResponse> FetchJointHolderDetailsAPi(@Body PlotIdRequest request);


    @POST("allotteNotices")
    Call<AllotteNoticesResponse> allotteNoticesAPi(@Body PlotIdRequest request);


    @POST("allotteHistory")
    Call<AlloteeHistoryResponse> allotteHistoryAPi(@Body PlotIdRequest request);

    @POST("allottePlotInfo")
    Call<AllottePlotInfoResponse> allottePlotInfoAPi(@Body PlotIdRequest request);


    @POST("allotteAppl")
    Call<AllotteApplicationStatusResponse> allotteAppStatusAPi(@Body AppStatusRequest request);


    @POST("allottefutureOutStandingDetails")
    Call<AllottefutureOutStandingDetailsResponse> allottefutureOutStandingDetailsPi(@Body PlotIdRequest request);


    @POST("allottePaymentReceived")
    Call<AllottePaymentReceivedResponse> allottePaymentReceivedPi(@Body PlotIdRequest request);


    @POST("allottePaymentReceivedDetails")
    Call<AllottePaymentReceivedDetailsResponse> allottePaymentReceivedDetailsPi(@Body PaymentReceivedDetailsRequest request);


    //https://cmapi.highereduhry.ac.in/api/commonapi/UpdatePassword


    @POST("UpdatePassword")
    Call<ForgotPasswordResponse> UpdatePassword(@Body ForgotPasswordRequest request);


    //  https://cmapi.highereduhry.ac.in/api/commonapi/StudentRegistration








/*

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
