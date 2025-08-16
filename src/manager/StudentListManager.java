package manager;

import data.Students;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import util.Inputter;

public class StudentListManager {
    //Create array to store data
    private ArrayList<Students> studentList = new ArrayList<>();
    private boolean hasUnsavedChanges = false; //track
    private final String binaryFile = "registration.dat";//BINARYFILE
    
    
    //List of Viettel and VNPT, discount 35%
    private double calculateTuitionFee(String phoneNumber) {
        double baseFee = 6000000; // fee default
        
        // List phone
        String[] viettelPrefixes = {"086", "096", "097", "098", "032", "033", "034", "035", "036", "037", "038", "039"};
        String[] vnptPrefixes = {"088", "091", "094", "083", "084", "085", "081", "082", "056", "058"};
        
        String prefix = phoneNumber.substring(0, 3);
        
        // check discount
        for (String vt : viettelPrefixes) {
            if (prefix.equals(vt)) {
                return baseFee * 0.65; // discount 35%
            }
        }
        
        for (String vnpt : vnptPrefixes) {
            if (prefix.equals(vnpt)) {
                return baseFee * 0.65; // discount 35%
            }
        }
        
        return baseFee; // no discount
    }
    
    //check phone valid
    private boolean isValidVietnamesePhone(String phoneNumber) {
        
        String[] validPrefixes = {
            // Viettel
            "086", "096", "097", "098", "032", "033", "034", "035", "036", "037", "038", "039",
            // VNPT (VinaPhone & MobiFone)
            "088", "091", "094", "083", "084", "085", "081", "082", "056", "058",
            // Vietnamobile
            "092", "052", "053",
            // Gmobile
            "099", "059"
        };
        
        if (phoneNumber.length() != 10) return false;
        
        String prefix = phoneNumber.substring(0, 3);
        for (String validPrefix : validPrefixes) {
            if (prefix.equals(validPrefix)) {
                return true;
            }
        }
        return false;
    }
    
    
    //Create a new student registration
    public void addNewStudent(){
        System.out.println("ADD NEW STUDENT");
        //check duplicate
        String sId;
        while(true){
            sId = Inputter.getAString("Input student'ID: ", "Invalid student'ID ",
                                                            "^(SE|HE|DE|QE|CE)\\d{6}$");
            if(this.findStudentBySId(sId) != null){
                System.out.println("Student ID is duplicated, input again!!");
            }else{
                break;
            }
        }
        
        //name
        String nameOfStudent = Inputter.getAString("Input name of student: ",
                                                    "Name of student cannot be blank");
        if (nameOfStudent.length() < 2 || nameOfStudent.length() > 20) {
            System.out.println("Name length invalid.Input again!!");
            return;
        }
        //phone number
        String phoneNumber;
        do {
            phoneNumber = Inputter.getAString("Input phone number (10 digits): ",
                                                    "Phone number must be exactly 10 digits", "\\d{10}");
            if (!isValidVietnamesePhone(phoneNumber)) {
                System.out.println("Invalid Vietnamese phone number! Please enter a valid phone number.");
                phoneNumber = null;
            }
        } while (phoneNumber == null);
        //email
        String email = Inputter.getAString("Input email of student: ",
                "Email of student cannot be blank", "^[\\w+]+@gmail\\.com$");
        //mountainCode
        String mountainCode = Inputter.getAString("Input mountain code: ",
                                            "Mountain code cannot be blank", "^MT\\d{2}$");
        //fee
        double tuitionFee = calculateTuitionFee(phoneNumber);
        
        //đủ thông tin để đúc rồi
        Students newStudent = new Students(sId, nameOfStudent, phoneNumber, email, mountainCode, tuitionFee);
        studentList.add(newStudent);
        System.out.println("Add student successfully!!");
    }
    
    //Create function to search infor
    public Students findStudentBySId(String sId){
        for (Students student: studentList) {
            if(student.getsId().equals(sId)) return student;
        }
        return null;
    }
    
    //Update registration information
    public void updateRegistrationInfor(){
        String sIdOfStu = Inputter.getAString("Input student'ID you want to update: ",
                                                "Student'ID cannot be blank.");
        Students student = this.findStudentBySId(sIdOfStu);
        //Student invalid
        if(student == null){
            System.out.println("This student has not registered yet.");
        }
        //Update
        System.out.println("Information of student before update");
        System.out.println("-------------------------------------------------------------");
        System.out.printf("%-10s | %-20s | %-10s | %-10s | %-10s\n", 
                          "Student ID", "Name", "Phone", "Mountain", "Fee");
        System.out.println("-------------------------------------------------------------");
        System.out.printf("%-10s | %-20s | %-10s | %-10s | %,.0f\n",
                        student.getsId(),
                        student.getName(),
                        student.getPhoneNumber(),
                        student.getMountainCode(),
                        student.getTuitionFee());
        //
        String newName = Inputter.getAString("Input new name: ",
                                        "Student'name cannot be blank");
        String newPhoneNumber = Inputter.getAString("Input new phone number: ",
                                        "Phone number must be 10 digit", "\\d{10}");
        String newEmail = Inputter.getAString("Input new email: ","Email cannot be blanl",
                                                    "^[\\w+]+@gmail\\.com$");
        String newMountainCode = Inputter.getAString("Input mountain code: ",
                                "Mountain code cannot be blank", "^MT\\d{2}$");
        //set
        if (newName.length() >= 2 && newName.length() <= 20) {
            student.setName(newName);
        }
        if (isValidVietnamesePhone(newPhoneNumber)) {
            student.setPhoneNumber(newPhoneNumber);
            // caculate fee phone number
            double newFee = calculateTuitionFee(newPhoneNumber);
            student.setTuitionFee(newFee);
        }
        student.setEmail(newEmail);
        student.setMountainCode(newMountainCode);
        //Notification
        System.out.println("Information student after update");
        System.out.println(student);
        System.out.println("Update successfully!!");
    }
    
    //Display registered list
    public void displayList(){
        System.out.println("-------------------------------------------------------------");
        System.out.printf("%-10s | %-20s | %-10s | %-10s | %-10s\n", 
                          "Student ID", "Name", "Phone", "Mountain", "Fee");
        System.out.println("-------------------------------------------------------------");
        for (Students student : studentList) {
            System.out.printf("%-10s | %-20s | %-10s | %-10s | %,.0f\n",
                        student.getsId(),
                        student.getName(),
                        student.getPhoneNumber(),
                        student.getMountainCode(),
                        student.getTuitionFee());
        }
        if(studentList.isEmpty()){
            System.out.println("No students have registered yet.");
        }
    }
    
    //Delete registration information
    public void deletaInformaion(){
        System.out.println("DELETE INFORMATION");
        String sIdOfStu = Inputter.getAString("Input ID of student, you want to delete: ",
                                        "ID cannot be blank");
        Students student = this.findStudentBySId(sIdOfStu);
        if(student == null){
            System.out.println("This student has not registered yet.");
        }
        System.out.println("Information of student before delete");
        System.out.println(student);
        //delete
        studentList.remove(student);
        System.out.println("The registration has been successfully deleted.");
    }
    
    //Create function to search infor by name
    public Students findStudentByName(String name){
        for (Students student: studentList) {
            if(student.getName().equals(name)) return student;
        }
        return null;
    }
    //Search participants by name
    public void searchInforByName(){
        System.out.println("SEARCH PARTICIPANTS");
        String nameOfStu = Inputter.getAString("Input name of student, you want to search: ",
                                                "Name cannot be blank");
        //check
        Students student = this.findStudentByName(nameOfStu);
        if(student == null){
            System.out.println("No one matches the search criteria!");
        }
        System.out.println("Information of student");
        System.out.println("-------------------------------------------------------------");
        System.out.printf("%-10s | %-20s | %-10s | %-10s | %-10s\n", 
                          "Student ID", "Name", "Phone", "Mountain", "Fee");
        System.out.println("-------------------------------------------------------------");
        System.out.printf("%-10s | %-20s | %-10s | %-10s | %,.0f\n",
                        student.getsId(),
                        student.getName(),
                        student.getPhoneNumber(),
                        student.getMountainCode(),
                        student.getTuitionFee());
    }
    
    //Filter data by Campus 
    public void filterByCampus() {
        String campusCode = Inputter.getAString("Enter campus code (CE, DE, HE, SE, QE): ",
                                        "Campus code cannot be blank").toUpperCase().trim();
        // check campus code
        if (!campusCode.matches("CE|DE|HE|SE|QE")) {
            System.out.println("Invalid campus code!");
            return;
        }

        boolean found = false;
        System.out.printf("Registered Students Under Campus %s:\n", campusCode);
        System.out.println("-------------------------------------------------------------");
        System.out.printf("%-10s | %-20s | %-10s | %-10s | %-10s\n", 
                          "Student ID", "Name", "Phone", "Mountain", "Fee");
        System.out.println("-------------------------------------------------------------");

        for (Students student : studentList) {
            if (student.getsId().startsWith(campusCode)) {
                System.out.printf("%-10s | %-20s | %-10s | %-10s | %,.0f\n",
                        student.getsId(),
                        student.getName(),
                        student.getPhoneNumber(),
                        student.getMountainCode(),
                        student.getTuitionFee());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No students have registered under this campus.");
        }
    }

    //Statistics of registration number by Location
    public void showStatisticsByLocation() {
        if (studentList.isEmpty()) {
            System.out.println("No registration data available for statistics.");
            return;
        }
        // Sử dụng HashMap để đếm số lượng và tính tổng phí theo từng mountain code
        Map<String, Integer> mountainCount = new HashMap<>();
        Map<String, Double> mountainTotalFee = new HashMap<>();
        // 
        for (Students student : studentList) {
            String mountainCode = student.getMountainCode();
            // count
            mountainCount.put(mountainCode, mountainCount.getOrDefault(mountainCode, 0) + 1);
            // caculate total fee
            mountainTotalFee.put(mountainCode, 
                mountainTotalFee.getOrDefault(mountainCode, 0.0) + student.getTuitionFee());
        }
        //
        System.out.println("Statistics of Registration by Mountain Peak:");
        System.out.println("-----------------------------------------------------------------");
        System.out.printf("%-10s | %-22s | %s\n", 
                          "Peak Code", "Number of Participants", "Total Cost");
        System.out.println("-----------------------------------------------------------------");
        // Duyệt qua tất cả các mountain code có sinh viên đăng ký
        for (Map.Entry<String, Integer> entry : mountainCount.entrySet()) {
            String mountainCode = entry.getKey();
            int participantCount = entry.getValue();
            double totalCost = mountainTotalFee.get(mountainCode);
            
            System.out.printf("%-10s | %-20d | %,.0f VND\n", 
                              mountainCode, participantCount, totalCost);
        }
        System.out.println("-----------------------------------------------------------------");
    }
    
    //Save dato to file
    public void saveDataToBinaryFile(){
        if (studentList.isEmpty()) {
            System.out.println("No data to save!");
            return;
        }
        
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(binaryFile))) {
            oos.writeObject(studentList);
            hasUnsavedChanges = false; // Reset unsaved changes flag
            System.out.println("Registration data has been successfully saved to `" + binaryFile + "`.");
            System.out.println("Total " + studentList.size() + " student records saved.");
            
        } catch (IOException e) {
            System.out.println("Error occurred while saving data: " + e.getMessage());
        }
    }
    // Load data from binary file
    @SuppressWarnings("unchecked")
    public void loadDataFromBinaryFile() {
        File file = new File(binaryFile);
        if (!file.exists()) {
            System.out.println("No saved data file found. Starting with empty database.");
            return;
        }
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(binaryFile))) {
            Object obj = ois.readObject();
            if (obj instanceof ArrayList<?>) {
                studentList = (ArrayList<Students>) obj;
                hasUnsavedChanges = false;
                System.out.println("Data loaded successfully from `" + binaryFile + "`.");
                System.out.println("Total " + studentList.size() + " student records loaded.");
            }
            
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error occurred while loading data: " + e.getMessage());
            System.out.println("Starting with empty database.");
            studentList = new ArrayList<>();
        }
    }
    
    // Check if there are unsaved changes
    public boolean hasUnsavedChanges() {
        return hasUnsavedChanges;
    }
    
    // Get total number of students (for statistics)
    public int getTotalStudents() {
        return studentList.size();
    }
}
