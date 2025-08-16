package runtime;

import manager.StudentListManager;
import manager.cabinet;
import util.Inputter;
import util.Menu;

public class Program {

    public static void main(String[] args) {
        
         StudentListManager manager = new StudentListManager();
        
        // Load existing data if available
        manager.loadDataFromBinaryFile();
        
        Menu mainMenu = new Menu("=========Mountain Hiking Challenge Registration========");
        mainMenu.addAnOption("New Registration");
        mainMenu.addAnOption("Update Registration Information");
        mainMenu.addAnOption("Display Registered List");
        mainMenu.addAnOption("Delete Registration Information");
        mainMenu.addAnOption("Search Participants by Name");
        mainMenu.addAnOption("Filter Data by Campus");
        mainMenu.addAnOption("Statistics of Registration Numbers by Location");
        mainMenu.addAnOption("Save Data to File");
        mainMenu.addAnOption("Exit the Program");
        cabinet cabinet = new cabinet();
        
        while(true){
            mainMenu.print();
            int choice = Inputter.getAnInteger("Input your choice",
                                "Choice must be integer between 1 and 9", 1, 9);
            switch(choice){
                case 1:{
                    cabinet.task1();
                    break;
                }
                case 2:{
                    cabinet.task2();
                    break;
                }
                case 3:{
                    cabinet.task3();
                    break;
                }
                case 4:{
                    cabinet.task4();
                    break;
                }
                case 5:{
                    cabinet.task5();
                    break;
                }
                case 6:{
                    cabinet.task6();
                    break;
                }
                case 7:{
                    cabinet.task7();
                    break;
                }
                case 8:{
                    cabinet.task8();
                    break;
                }
                case 9:{
                    if (manager.hasUnsavedChanges()) {
                        System.out.println("You have unsaved changes!");
                        String saveChoice = Inputter.getAString(
                            "Do you want to save the changes before exiting? (Y/N): ",
                            "Please enter Y or N", "[YyNn]");
                        
                        if (saveChoice.equalsIgnoreCase("Y")) {
                            manager.saveDataToBinaryFile();
                            System.out.println("Data saved successfully!");
                        } else {
                            String confirmExit = Inputter.getAString(
                                "Are you sure you want to exit without saving? (Y/N): ",
                                "Please enter Y or N", "[YyNn]");
                            
                            if (confirmExit.equalsIgnoreCase("N")) {
                                continue; // Back to main menu
                            }
                        }
                    }
                    
                    System.out.println("Thank you for using Mountain Hiking Challenge Registration System!");
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
                }
                default:{
                    System.out.println("Choice between 1 and 9. Input again, thanks.");
                    break;
                }
            }
            
        }
        
    }
    
}
