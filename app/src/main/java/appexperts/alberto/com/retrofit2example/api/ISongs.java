package appexperts.alberto.com.retrofit2example.api;

import appexperts.alberto.com.retrofit2example.Model.Song;
import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by alber on 29/02/2016.
 */
public interface ISongs {

    @GET("/search?term=classick&amp;media=music&amp;entity=song&amp;limit=50")
    Call<Song> getSongs();


}
