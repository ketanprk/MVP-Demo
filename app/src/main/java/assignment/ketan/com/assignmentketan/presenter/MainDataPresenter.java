package assignment.ketan.com.assignmentketan.presenter;

import android.content.Context;
import assignment.ketan.com.assignmentketan.model.dto.FailureResponseEntity;
import assignment.ketan.com.assignmentketan.model.dto.assignment_result.AssignmentResponse;
import assignment.ketan.com.assignmentketan.model.interactor.IMainDataInteractor;
import assignment.ketan.com.assignmentketan.model.interactor.MainDataInteractor;
import assignment.ketan.com.assignmentketan.view.activities.home.IHomeViewListener;

public class MainDataPresenter implements IMainDataInteractor {
    private IHomeViewListener mViewListener;
    private MainDataInteractor mInteractor;


    public MainDataPresenter(IHomeViewListener mViewListener, Context mContext) {
        this.mViewListener = mViewListener;
        mInteractor = new MainDataInteractor(this, mContext);

    }

    public void fetchResults(int param) {

        mInteractor.fetchResults(param);

    }


    @Override
    public void onSuccess(AssignmentResponse mResponse) {

        mViewListener.onSuccess(mResponse);
    }

    @Override
    public void onFailure(FailureResponseEntity responseEntity) {

        mViewListener.onFailure(responseEntity);

    }

}
