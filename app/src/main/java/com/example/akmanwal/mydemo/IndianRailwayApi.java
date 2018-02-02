package com.example.akmanwal.mydemo;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Deepak on 12/25/2017.
 */
public class IndianRailwayApi {

    private static final String MYAPIKEY = "82s4hdhhyz";
    private static final String BASE_URL = "https://api.railwayapi.com/v2/";

    public static SeatAvailabilityService seatAvailabilityService = null;
    public static FareEstimationService fareEstimationService = null;


    public static SeatAvailabilityService getSeatAvailabilityService() {
        if (seatAvailabilityService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                    .build();

            seatAvailabilityService = retrofit.create(SeatAvailabilityService.class);
        }
        return seatAvailabilityService;
    }

    public interface SeatAvailabilityService {
        //https://api.railwayapi.com/v2/check-seat/train/<train number>/source/<stn code>/dest/<dest code>/date/<dd-mm-yyyy>/pref/<class code>/quota/<quota code>/apikey/<apikey>/
        //http://api.railwayapi.com/v2/check-seat/train/12001/source/BPL/dest/NDLS/date/16-03-2018/pref/CC/quota/GN/apikey/82s4hdhhyz/
        @GET("check-seat/train/{trainCode}/source/{sourceCode}/dest/{destCode}/date/{trainDate}/pref/{classCode}/quota/GN/apikey/" + MYAPIKEY)
        Call<SeatAvailability> getAvailability(@Path("trainCode") String trainCode, @Path("sourceCode") String sourceCode, @Path("destCode") String destCode, @Path("trainDate") String trainDate, @Path("classCode") String classCode);

    }


    public static FareEstimationService getFareEstimationService() {
        if (fareEstimationService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                    .build();

            fareEstimationService = retrofit.create(FareEstimationService.class);
        }
        return fareEstimationService;
    }

    public interface FareEstimationService {
        //http://api.railwayapi.com/v2/fare/train/12904/source/nzm/dest/kota/age/18/pref/SL/quota/PT/date/15-03-2018/apikey/f3zb4h0d7p/
        //https://api.railwayapi.com/v2/fare/train/12555/source/gkp/dest/ndls/age/18/pref/SL/quota/GN/date/15-03-2018/apikey/82s4hdhhyz/
        @GET("fare/train/{trainCode}/source/{sourceCode}/dest/{destCode}/age/{Age}/pref/{classCode}/quota/GN/date/{trainDate}/apikey/" + MYAPIKEY)
        Call<FareEstimation> getFare(@Path("trainCode") String trainCode, @Path("sourceCode") String sourceCode, @Path("destCode") String destCode,
                                     @Path("Age") String page, @Path("classCode") String trainClass, @Path("trainDate") String trainDate);
    }
}