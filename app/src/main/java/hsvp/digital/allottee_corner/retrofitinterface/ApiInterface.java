package hsvp.digital.allottee_corner.retrofitinterface;

import hsvp.digital.allottee_corner.model.AadharnoFromMemIDResponse;
import hsvp.digital.allottee_corner.model.AcademicSessionResponse;
import hsvp.digital.allottee_corner.model.AdminDashboardResponse;
import hsvp.digital.allottee_corner.model.AllDepartmentResponse;
import hsvp.digital.allottee_corner.model.AllDistrictsResponse;
import hsvp.digital.allottee_corner.model.AllotteCurrentOutStandingResponse;
import hsvp.digital.allottee_corner.model.AllottefutureOutStandingResponse;
import hsvp.digital.allottee_corner.model.AllotteplotdetailsResponse;
import hsvp.digital.allottee_corner.model.CheckApplicationExistResponse;
import hsvp.digital.allottee_corner.model.CheckStudentAlreadyExistResponse;
import hsvp.digital.allottee_corner.model.CollegeDashboardResponse;
import hsvp.digital.allottee_corner.model.CollegeListResponse;
import hsvp.digital.allottee_corner.model.CourseYearResponse;
import hsvp.digital.allottee_corner.model.CoursesListResponse;
import hsvp.digital.allottee_corner.model.CoursesTypeResponse;
import hsvp.digital.allottee_corner.model.DepartmentByCourseIdForApplyResponse;
import hsvp.digital.allottee_corner.model.DepartmentDashboardResponse;
import hsvp.digital.allottee_corner.model.FetchAllottedetailsResponse;
import hsvp.digital.allottee_corner.model.ForgotPasswordRequest;
import hsvp.digital.allottee_corner.model.ForgotPasswordResponse;
import hsvp.digital.allottee_corner.model.GetAllCoursesResponse;
import hsvp.digital.allottee_corner.model.GetApplicationStatusByAadharResponse;
import hsvp.digital.allottee_corner.model.GetScholarshipSchemesResponse;
import hsvp.digital.allottee_corner.model.LoginRequest;
import hsvp.digital.allottee_corner.model.LoginResponse;
import hsvp.digital.allottee_corner.model.NodalBodyDHEDashboardResponse;
import hsvp.digital.allottee_corner.model.OtpForgotPasswordResponse;
import hsvp.digital.allottee_corner.model.PlotIdRequest;
import hsvp.digital.allottee_corner.model.ScholarshipSchemesResponse;
import hsvp.digital.allottee_corner.model.StudentRegistrationResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("CoursesType")
    Call<CoursesTypeResponse> GetCoursesTypeDataAPi();

    @GET("Get_AllCourses")
    Call<GetAllCoursesResponse> GetAllCoursesForApplyListDataAPi();

    @GET("Get_ScholarshipSchemes")
    Call<GetScholarshipSchemesResponse> getAllScholarshipSchemesListDataAPi();

    @GET("AllDepartment")
    Call<AllDepartmentResponse> getAllDepartmentListDataAPi();


    @GET("AllDistricts")
    Call<AllDistrictsResponse> getAllDistrictsListDataAPi();


    @GET("CoursesList")
    Call<CoursesListResponse> getCoursesListDataAPi();


    @GET("AcademicSession")
    Call<AcademicSessionResponse> getAcademicSessionDataAPi();

    @GET("ScholarshipSchemes")
    Call<ScholarshipSchemesResponse> getScholarshipSchemesDataAPi();


    // https://cmapi.highereduhry.ac.in/api/commonapi/Check_ApplicationExist/110365/2021-22/1

    @POST("Check_ApplicationExist/{StudentId}/{academicSession}/{schemeId}")
    Call<CheckApplicationExistResponse> CheckApplicationExistAPi(@Path("StudentId") String StudentId, @Path("academicSession") String academicSession, @Path("schemeId") String schemeId);


    // https://cmapi.highereduhry.ac.in/api/commonapi/Get_Course_Year/150/2021-22/172/1

    @GET("Get_Course_Year/{StudentId}/{academicSession}/{CourseId}/{schemeId}")
    Call<CourseYearResponse> getCourse_YearAPi(@Path("StudentId") String StudentId, @Path("academicSession") String academicSession, @Path("CourseId") String CourseId, @Path("schemeId") String schemeId);


    // https://cmapi.highereduhry.ac.in/api/commonapi/Bind_Department_By_CourseId/350

    @GET("Bind_Department_By_CourseId/{CourseId}")
    Call<DepartmentByCourseIdForApplyResponse> getDepartmentByCourseIdAPi(@Path("CourseId") String CourseId);


    // https://cmapi.highereduhry.ac.in/api/commonapi/Get_DashboardNodalBodyDHE/1/2020-21/1  Get_DashboardNodalBodyDHE/{NodalBody_Id}/{AcademicSession}/{SchemeId}

    @GET("Get_DashboardNodalBodyDHE/{NodalBody_Id}/{AcademicSession}/{schemeId}")
    Call<NodalBodyDHEDashboardResponse> getNodalBodyDHEDashboardAPi(@Path("NodalBody_Id") String NodalBody_Id,
                                                                    @Path("AcademicSession") String AcademicSession,
                                                                    @Path("schemeId") String schemeId);


    // https://cmapi.highereduhry.ac.in/api/commonapi/GetPMSDashboardAdmin/SC/2020-21/1

    @GET("GetPMSDashboardAdmin/{CastName}/{session}/{schemeId}")
    Call<AdminDashboardResponse> getPMSDashboardAdminAPi(@Path("CastName") String CastName,
                                                         @Path("session") String session,
                                                         @Path("schemeId") String schemeId);

    //https://cmapi.highereduhry.ac.in/api/commonapi/Get_DashboardNodalBody/1/2020-21  Get_DashboardNodalBody/{NodalBody_Id}/{AcademicSession}

    @GET("Get_DashboardNodalBody/{NodalBody_Id}/{session}")
    Call<CollegeDashboardResponse> getNodalBodyDashboardAPi(
            @Path("NodalBody_Id") String NodalBody_Id,
            @Path("session") String session);

    //https://cmapi.highereduhry.ac.in/api/commonapi/Get_DashboardCollege/1/2020-21

    @GET("Get_DashboardCollege/{DepartmentId}/{session}")
    Call<CollegeDashboardResponse> getCollegeDashboarAPi(
            @Path("session") String session,
            @Path("DepartmentId") String DepartmentId);


    // http://cmapi.highereduhry.ac.in/api/commonapi/Get_PMS_DashboardDepartment/SC/2020-21/1

    @GET("Get_PMS_DashboardDepartment/{CastName}/{session}/{DepartmentId}")
    Call<DepartmentDashboardResponse> getPMSDashboarDepartmentAPi(@Path("CastName") String CastName,
                                                                  @Path("session") String session,
                                                                  @Path("DepartmentId") String DepartmentId);

    // https://cmapi.highereduhry.ac.in/api/commonapi/CollegesList/8/1

    @GET("CollegesList/{DistrictsId}/{DepartmentId}")
    Call<CollegeListResponse> getCollegesListDataAPi(@Path("DistrictsId") String DistrictsId,
                                                     @Path("DepartmentId") String DepartmentId);
    // https://cmapi.highereduhry.ac.in/api/commonapi/PMSCollegesByDistrictId_DepartmentId_Session/8/1/2021-22

    @GET("PMSCollegesByDistrictId_DepartmentId_Session/{DistrictsId}/{DepartmentId}/{userAcademicSession}")
    Call<CollegeListResponse> getCollegesListPMSDataAPi(@Path("DistrictsId") String DistrictsId,
                                                        @Path("DepartmentId") String DepartmentId,
                                                        @Path("userAcademicSession") String userAcademicSession);

    // http://cmapi.highereduhry.ac.in/api/commonapi/GetApplicationStatusByAadhar/483817819463/1/2020-21

    @GET("GetApplicationStatusByAadhar/{AadharNumber}/{schemeId}/{SessionName}")
    Call<GetApplicationStatusByAadharResponse> getApplicationStatusDataAPi(@Path("AadharNumber") String AadharNumber,
                                                                           @Path("schemeId") String schemeId, @Path("SessionName") String SessionName);


    /*
https://cmapi.highereduhry.ac.in/api/commonapi/UserLogin
{
    "AuthID":"superadmin",
    "Password":"12345",
    "FCMToken":"ccvcvcvcvcv"
    }
*/

    @POST("Login")
    Call<LoginResponse> LoginUser(@Body LoginRequest request);

    @POST("allotteCurrentOutStanding")
    Call<AllotteCurrentOutStandingResponse> allotteCurrentOutStandingApi(@Body PlotIdRequest request);



    @POST("allotteplotdetails")
    Call<AllotteplotdetailsResponse> allotteplotdetailsAPi(@Body PlotIdRequest request);


    @POST("allottefutureOutStanding")
    Call<AllottefutureOutStandingResponse> allottefutureOutStandingAPi(@Body PlotIdRequest request);



    @POST("FetchAllottedetails")
    Call<FetchAllottedetailsResponse> FetchAllottedetailsAPi(@Body PlotIdRequest request);






    //https://cmapi.highereduhry.ac.in/api/commonapi/CheckStudentAlreadyExist/23456789
    @GET("CheckStudentAlreadyExist/{MemberId}")
    Call<CheckStudentAlreadyExistResponse> getCheckStudentAlreadyExistAPi(@Path("MemberId") String MemberId);


    // https://cmapi.highereduhry.ac.in/api/commonapi/SendOTP/8269970959/23456789
    @GET("SendOTP/{MobileNo}/{MemberId}")
    Call<OtpForgotPasswordResponse> SendOTPFogotPasswordAPi(@Path("MobileNo") String MobileNo, @Path("MemberId") String MemberId);

    //http://cmapi.highereduhry.ac.in/api/commonapi/GetAadharnoFromMemID/JKZF2471
    @POST("GetAadharnoFromMemID/{MemberId}")
    Call<AadharnoFromMemIDResponse> GetAadharnoFromMemIDAPi(@Path("MemberId") String MemberId);


    //https://cmapi.highereduhry.ac.in/api/commonapi/UpdatePassword


    @POST("UpdatePassword")
    Call<ForgotPasswordResponse> UpdatePassword(@Body ForgotPasswordRequest request);


    //  https://cmapi.highereduhry.ac.in/api/commonapi/StudentRegistration


    @FormUrlEncoded
    @POST("StudentRegistration")
    Call<StudentRegistrationResponse> StudentRegistration_Api(@Field("RegistrationIp") String RegistratioIp,
                                                              @Field("FCMToken") String FCMToken,
                                                              @Field("FamilyID") String FamilyID,
                                                              @Field("memberID") String memberID,
                                                              @Field("firstName") String firstName,
                                                              @Field("lastName") String lastName,
                                                              @Field("fullName") String fullName,
                                                              @Field("fatherFullName") String fatherFullName,
                                                              @Field("motherFullName") String motherFullName,
                                                              @Field("gender") String gender,
                                                              @Field("houseNo") String houseNo,
                                                              @Field("streetNo") String streetNo,
                                                              @Field("address_LandMark") String address_LandMark,
                                                              @Field("pinCode") String pinCode,
                                                              @Field("dCode") String dCode,
                                                              @Field("btCode") String btCode,
                                                              @Field("btCodeLGD") String btCodeLGD,
                                                              @Field("wvCode") String wvCode,
                                                              @Field("districtName") String districtName,
                                                              @Field("btName") String btName,
                                                              @Field("wvName") String wvName,
                                                              @Field("aadhaarNo") String aadhaarNo,
                                                              @Field("dob") String dob,
                                                              @Field("mobileNo") String mobileNo,
                                                              @Field("casteCategory") String casteCategory,
                                                              @Field("familyIncome") String familyIncome,
                                                              @Field("email") String email,
                                                              @Field("bpl") String bpl,
                                                              @Field("bplCardNO") String bplCardNO,
                                                              @Field("dCodeLGD") String dCodeLGD,
                                                              @Field("wvCodeLGD") String wvCodeLGD,
                                                              @Field("casteCategoryName") String casteCategoryName,
                                                              @Field("disabilityType") String disabilityType,
                                                              @Field("isDivyang") String isDivyang,
                                                              @Field("divyangPercentage") String divyangPercentage,
                                                              @Field("IsDenotifiedTribe") String IsDenotifiedTribe,
                                                              @Field("isDOBVerified") String isDOBVerified,
                                                              @Field("isCasteVerified") String isCasteVerified,
                                                              @Field("isIncomeVerified") String isIncomeVerified,
                                                              @Field("isBPLVerified") String isBPLVerified,
                                                              @Field("isDivyangVerified") String isDivyangVerified,
                                                              @Field("subCaste_code") String subCaste_code,
                                                              @Field("subCaste_name") String subCaste_name,
                                                              @Field("casteDescription") String casteDescription,
                                                              @Field("divyangCategory") String divyangCategory,
                                                              @Field("deprived") String deprived,
                                                              @Field("Religion") String Religion,
                                                              @Field("AuthPwd") String AuthPwd);













































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
