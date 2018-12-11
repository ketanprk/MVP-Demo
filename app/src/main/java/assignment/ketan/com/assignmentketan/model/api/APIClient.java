package assignment.ketan.com.assignmentketan.model.api;


import android.content.Context;
import assignment.ketan.com.assignmentketan.constants.AppConstants;
import assignment.ketan.com.assignmentketan.model.api.api_utils.ConnectivityInterceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {
    private static Retrofit.Builder builder;

    private static Retrofit retrofit;

    private static APIService REST_CLIENT;
    private Context mContext;



    static {

    }

    public APIClient() {
    }

    public static Retrofit.Builder getBuilder() {
        return builder;
    }

    public static void setBuilder(Retrofit.Builder builder) {
        APIClient.builder = builder;
    }

    public static Retrofit getRetrofit() {
        return retrofit;
    }

    public static void setRetrofit(Retrofit retrofit) {
        APIClient.retrofit = retrofit;
    }

    public APIService get(Context mContext) {
        this.mContext = mContext;

        return setupRestClient();
    }


    public APIService setupRestClient() {

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        /**
         * Configured OkHttp Client To Authenticatell
         */
        final OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new ConnectivityInterceptor(mContext)).addNetworkInterceptor(httpLoggingInterceptor).build();

        builder = new Retrofit.Builder().baseUrl(AppConstants.BASE_URL).client(client).addConverterFactory(GsonConverterFactory.create());
        retrofit = builder.build();
        REST_CLIENT = retrofit.create(APIService.class);

        return REST_CLIENT;
    }
}
