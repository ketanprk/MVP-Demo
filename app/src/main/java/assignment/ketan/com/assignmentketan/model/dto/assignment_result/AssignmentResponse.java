package assignment.ketan.com.assignmentketan.model.dto.assignment_result;

import java.util.ArrayList;

public class AssignmentResponse {
    private ArrayList<Results> results;

    private Info info;

    public ArrayList<Results> getResults() {
        return results;
    }

    public void setResults(ArrayList<Results> results) {
        this.results = results;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "ClassPojo [results = " + results + ", info = " + info + "]";
    }
}