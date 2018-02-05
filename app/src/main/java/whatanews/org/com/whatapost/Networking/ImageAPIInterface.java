package whatanews.org.com.whatapost.Networking;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by mobileprogramming on 05/02/18.
 */

public interface ImageAPIInterface {

    @GET("feed/")
    Call<List<ImageURLInfoBean>> geImagesResponseCall();
}
