package appexperts.alberto.com.retrofit2example;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.google.gson.Gson;
import java.util.List;

import appexperts.alberto.com.retrofit2example.Model.Result;
import appexperts.alberto.com.retrofit2example.Model.Song;
import appexperts.alberto.com.retrofit2example.api.ISongs;
import appexperts.alberto.com.retrofit2example.api.RestClient;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ProgressDialog dialog = ProgressDialog.show(this, "", "loading...");
        RestClient restClient = new RestClient();
        ISongs service = restClient.getClient();

        Call<Song> call = service.getSongs();
        call.enqueue(new Callback<Song>() {
            @Override
            public void onResponse(Response<Song> response) {
                List<Result> list = response.body().getResults();
                Log.d("Artist name: ", list.get(0).getArtistName() );
                Log.d("Artist name: ", list.get(1).getArtistName() );
                Log.d("Artist name: ", list.get(2).getArtistName() );
                Log.d("Artist name: ", list.get(3).getArtistName() );
                dialog.dismiss();
            }

            @Override
            public void onFailure(Throwable t) {
                dialog.dismiss();
            }
        });
    }
}
