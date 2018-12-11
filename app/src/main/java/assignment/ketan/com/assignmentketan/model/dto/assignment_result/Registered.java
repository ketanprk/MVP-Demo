package assignment.ketan.com.assignmentketan.model.dto.assignment_result;

public class Registered {
    private String age;

    private String date;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ClassPojo [age = " + age + ", date = " + date + "]";
    }
}
	