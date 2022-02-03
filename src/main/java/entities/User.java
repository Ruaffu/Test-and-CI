package entities;

public class User {
    private String fName;
    private String lName;
    private String password;
    private String phone;
    private String address;

    public User(String fName, String lName, String password, String phone, String address) {
        this.fName = fName;
        this.lName = lName;
        this.password = password;
        this.phone = phone;
        this.address = address;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
