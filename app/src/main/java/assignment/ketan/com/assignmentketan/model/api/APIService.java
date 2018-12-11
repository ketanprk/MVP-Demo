package assignment.ketan.com.assignmentketan.model.api;


import assignment.ketan.com.assignmentketan.model.dto.assignment_result.AssignmentResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface APIService {

    ///All the functions with parameters here//


    @GET("/api/")
    Call<AssignmentResponse> getResults(@Query("results") int param1);
}
