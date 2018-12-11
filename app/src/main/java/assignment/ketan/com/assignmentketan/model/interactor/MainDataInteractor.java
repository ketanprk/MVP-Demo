package assignment.ketan.com.assignmentketan.model.interactor;

import android.content.Context;
import assignment.ketan.com.assignmentketan.R;
import assignment.ketan.com.assignmentketan.model.api.APIClient;
import assignment.ketan.com.assignmentketan.model.api.APIService;
import assignment.ketan.com.assignmentketan.model.api.api_utils.NoConnectivityException;
import assignment.ketan.com.assignmentketan.model.dto.FailureResponseEntity;
import assignment.ketan.com.assignmentketan.model.dto.assignment_result.AssignmentResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.HashMap;

public class MainDataInteractor {
    private IMainDataInteractor mInteractor;
    private APIService api;
    private Context mContext;


    public MainDataInteractor(IMainDataInteractor mInteractor, Context mContext) {
        this.mInteractor = mInteractor;
        this.mContext = mContext;
        api = new APIClient().get(mContext);

    }

    public void fetchResults(int param) {
        Call<AssignmentResponse> loginRequestCall = api.getResults(param);
        loginRequestCall.enqueue(new Callback<AssignmentResponse>() {
            @Override
            public void onResponse(Call<AssignmentResponse> call, Response<AssignmentResponse> response) {

                if (response.body() != null) {
                    mInteractor.onSuccess(response.body());
                } else if (response.errorBody() != null) {


                    /*try {
                        LoginErrorResponse mErrorResponse = new Gson().fromJson(response.errorBody().string(), LoginErrorResponse.class);


                        onError(mErrorResponse.getError(), "", false);
                    } catch (IOException e) {
                        e.printStackTrace();

                        onError("", "", true);
                    }
*/
                    onError("", "", true);
                } else {

                    onError("", "", true);

                }
            }

            @Override
            public void onFailure(Call<AssignmentResponse> call, Throwable t) {

                if (t instanceof NoConnectivityException) {
                    onError(t.getMessage(), "", false);
                } else {
                    onError("", "", true);
                }

            }
        });


    }

    private void onError(String errorMessage, String statusCode, boolean isGenericError) {
        FailureResponseEntity mEntity = new FailureResponseEntity();
        if (isGenericError) {
            mEntity.setFailureMessage(mContext.getResources().getString(R.string.common_error));
        } else {
            mEntity.setResponseCode(statusCode);
            mEntity.setFailureMessage(errorMessage);
        }

        mInteractor.onFailure(mEntity);

    }
}