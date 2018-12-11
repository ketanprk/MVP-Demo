package assignment.ketan.com.assignmentketan.view.activities.home;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import assignment.ketan.com.assignmentketan.R;
import assignment.ketan.com.assignmentketan.model.dto.FailureResponseEntity;
import assignment.ketan.com.assignmentketan.model.dto.assignment_result.AssignmentResponse;
import assignment.ketan.com.assignmentketan.model.dto.assignment_result.Results;
import assignment.ketan.com.assignmentketan.model.interactor.IMainDataInteractor;
import assignment.ketan.com.assignmentketan.model.interactor.MainDataInteractor;
import assignment.ketan.com.assignmentketan.utiities.AppUtils;
import assignment.ketan.com.assignmentketan.view.activities.home.adapter.ItemAdapter;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements IMainDataInteractor {

    private ProgressDialog progressDialog;
    private Dialog mDialog;

    ArrayList<Results> mResults;
    private LinearLayoutManager mLayoutManager;

    RecyclerView rv_result_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_result_list = (RecyclerView) findViewById(R.id.rv_result_list);
        init();
    }

    private void init() {

        setupToolbar();
        setupTypeFace();
        setupListeners();
        setupData();
    }


    private void setupData() {

        progressDialog = AppUtils.createProgressDialog(this, "Fetching Details.", "Please Wait..");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
        MainDataInteractor mainDataInteractor = new MainDataInteractor(this, getApplicationContext());
        mainDataInteractor.fetchResults(10);

    }

    private void setUpRecyclerView() {
        mLayoutManager = new LinearLayoutManager(this);
        rv_result_list.setLayoutManager(mLayoutManager);
        rv_result_list.setAdapter(new ItemAdapter(this, mResults));
        rv_result_list.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

    }

    private void setupToolbar() {
    }

    private void setupTypeFace() {

    }

    private void setupListeners() {


    }

    @Override
    public void onSuccess(AssignmentResponse mResponse) {

        progressDialog.dismiss();
        if (mResponse != null) {
            mResults = mResponse.getResults();
            setUpRecyclerView();
        }


    }

    @Override
    public void onFailure(FailureResponseEntity responseEntity) {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        String message = responseEntity.getFailureMessage();
        mDialog = AppUtils.showAlertDialog(this, message, "", "Ok",
                null, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mDialog != null)
                            mDialog.dismiss();
                    }
                });
    }

}
