package appexperts.alberto.com.retrofit2example.api;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Response;
import java.io.IOException;

import appexperts.alberto.com.retrofit2example.Contants.Constant;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by alber on 29/02/2016.
 */
public class RestClient {

    private static ISongs iSongs;

    public static ISongs getClient(){
        if(iSongs == null){

            OkHttpClient okClient = new OkHttpClient();
            okClient.interceptors().add(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Response response = chain.proceed(chain.request());
                    return response;
                }
            });

            Retrofit client = new Retrofit.Builder()
                    .baseUrl(Constant.BASE_URL)
                    .client(okClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            iSongs = client.create(ISongs.class);
        }

        return iSongs;
    }

}
