package assignment.ketan.com.assignmentketan.model.interactor;

import assignment.ketan.com.assignmentketan.model.dto.FailureResponseEntity;
import assignment.ketan.com.assignmentketan.model.dto.assignment_result.AssignmentResponse;

public interface IMainDataInteractor {
    void onSuccess(AssignmentResponse mResponse);

    void onFailure(FailureResponseEntity responseEntity);
}

