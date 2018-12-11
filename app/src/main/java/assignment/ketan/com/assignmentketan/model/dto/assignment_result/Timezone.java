package assignment.ketan.com.assignmentketan.model.dto.assignment_result;

public class Timezone
{
    private String description;

    private String offset;

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getOffset ()
    {
        return offset;
    }

    public void setOffset (String offset)
    {
        this.offset = offset;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [description = "+description+", offset = "+offset+"]";
    }
}
			