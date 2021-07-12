//package com.akbar.doolanzquiz.api;
//
//import com.akbar.doolanzquiz.model.Value;
//
//import retrofit2.Call;
//import retrofit2.http.Field;
//import retrofit2.http.FormUrlEncoded;
//import retrofit2.http.POST;
//
//public interface PanggilApi {
//    @FormUrlEncoded
//    @POST("register.php")
//    Call<Value>daftar(@Field("nama") String nama,
//                      @Field("username_reg") String username_reg,
//                      @Field("password_reg") String password_reg);
//
//    @FormUrlEncoded
//    @POST("login.php")
//    Call<Value>login(@Field("username_reg") String username_reg,
//                     @Field("password_reg") String password_reg);
//}
/Panggil menu api melalui java/