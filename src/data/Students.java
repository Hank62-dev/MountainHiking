package data;
import java.io.Serializable;

public class Students implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private String sId;
    private String name;
    private String phoneNumber;
    private String email;
    private String mountainCode;
    private double tuitionFee;
    
    //contructor

    public Students() {
        
    }

    public Students(String sId, String name, String phoneNumber, String email, String mountainCode, double tuitionFee) {
        this.sId = sId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.mountainCode = mountainCode;
        this.tuitionFee = tuitionFee;
    }
    
    //getter
    public String getsId() {
        return sId;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getMountainCode() {
        return mountainCode;
    }

    public double getTuitionFee() {
        return tuitionFee;
    }
    //setter

    public void setsId(String sId) {
        this.sId = sId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMountainCode(String mountainCode) {
        this.mountainCode = mountainCode;
    }

    public void setTuitionFee(double tuitionFee) {
        this.tuitionFee = tuitionFee;
    }
    
    //
    
    
    //showInfor
    public void showInfor(){
        String str = String.format("%-8s|%-20s|%-10s|%-25s|%-8s|%.0f",
                            sId, name, phoneNumber, email, mountainCode, tuitionFee);
        System.out.println(str);
    }
    @Override
    public String toString() {
        return String.format("%-8s|%-20s|%-10s|%-25s|%-8s|%.0f",
                sId, name, phoneNumber, email, mountainCode, tuitionFee);
    }
}
