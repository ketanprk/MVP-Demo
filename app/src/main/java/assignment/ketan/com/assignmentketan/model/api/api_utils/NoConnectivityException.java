package assignment.ketan.com.assignmentketan.model.api.api_utils;

import java.io.IOException;


public class NoConnectivityException extends IOException {

    @Override
    public String getMessage() {
        return "No Internet Connection";
    }
}