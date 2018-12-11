package assignment.ketan.com.assignmentketan.model.dto.assignment_result;

public class Location
{
    private Timezone timezone;

    private String street;

    private String state;

    private String postcode;

    private Coordinates coordinates;

    private String city;

    public Timezone getTimezone ()
    {
        return timezone;
    }

    public void setTimezone (Timezone timezone)
    {
        this.timezone = timezone;
    }

    public String getStreet ()
    {
        return street;
    }

    public void setStreet (String street)
    {
        this.street = street;
    }

    public String getState ()
    {
        return state;
    }

    public void setState (String state)
    {
        this.state = state;
    }

    public String getPostcode ()
    {
        return postcode;
    }

    public void setPostcode (String postcode)
    {
        this.postcode = postcode;
    }

    public Coordinates getCoordinates ()
    {
        return coordinates;
    }

    public void setCoordinates (Coordinates coordinates)
    {
        this.coordinates = coordinates;
    }

    public String getCity ()
    {
        return city;
    }

    public void setCity (String city)
    {
        this.city = city;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [timezone = "+timezone+", street = "+street+", state = "+state+", postcode = "+postcode+", coordinates = "+coordinates+", city = "+city+"]";
    }
}