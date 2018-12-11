package assignment.ketan.com.assignmentketan.view.activities.home;

import assignment.ketan.com.assignmentketan.model.dto.FailureResponseEntity;
import assignment.ketan.com.assignmentketan.model.dto.assignment_result.AssignmentResponse;

public interface IHomeViewListener {
    void onSuccess(AssignmentResponse mResponse);

    void onFailure(FailureResponseEntity responseEntity);
}
