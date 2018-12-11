package assignment.ketan.com.assignmentketan.model.dto;

public class FailureResponseEntity {

    private String failureMessage, responseCode;
    private Object responseObject;

    public FailureResponseEntity(String message) {

        this.failureMessage = message;
    }

    public FailureResponseEntity() {

    }

    public Object getResponseObject() {
        return responseObject;
    }

    public void setResponseObject(Object responseObject) {
        this.responseObject = responseObject;
    }

    public String getFailureMessage() {
        return failureMessage;
    }

    public void setFailureMessage(String failureMessage) {
        this.failureMessage = failureMessage;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }
}