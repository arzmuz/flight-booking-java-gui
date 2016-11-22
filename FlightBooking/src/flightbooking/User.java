
package flightbooking;

public class User {
    
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String DOB;
    private char gender;
    
    public static int countUsers = 0;
    
    public User(){
        firstName = "-";
        lastName = "-";
        userName = "-";
        password = "-";
        DOB = "-";
        gender = '-';
        
        countUsers++;
    }
    
    public User(String firstName, String lastName, String userName, String password, String DOB, char gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.DOB = DOB;
        this.gender = gender;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getDOB() {
        return DOB;
    }

    public char getGender() {
        return gender;
    }
}
