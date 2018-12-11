package assignment.ketan.com.assignmentketan.model.dto.assignment_result;


public class Results {
    private Picture picture;

    private Id id;

    private String phone;

    private String email;

    private Location location;

    private Registered registered;

    private String cell;

    private Dob dob;

    private Name name;

    private String gender;

    private String nat;

    private Login login;

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Registered getRegistered() {
        return registered;
    }

    public void setRegistered(Registered registered) {
        this.registered = registered;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public Dob getDob() {
        return dob;
    }

    public void setDob(Dob dob) {
        this.dob = dob;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNat() {
        return nat;
    }

    public void setNat(String nat) {
        this.nat = nat;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "ClassPojo [picture = " + picture + ", id = " + id + ", phone = " + phone + ", email = " + email + ", location = " + location + ", registered = " + registered + ", cell = " + cell + ", dob = " + dob + ", name = " + name + ", gender = " + gender + ", nat = " + nat + ", login = " + login + "]";
    }
}
			
			