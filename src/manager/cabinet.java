package manager;
//nơi chứa các hàm dùng cho Program
public class cabinet {
    private StudentListManager stuManager = new StudentListManager();
    public void task1(){
        stuManager.addNewStudent();
    }
    public void task2(){
        stuManager.updateRegistrationInfor();
    }
    public void task3(){
        stuManager.displayList();
    }
    public void task4(){
        stuManager.deletaInformaion();
    }
    public void task5(){
        stuManager.searchInforByName();
    }
    public void task6(){
        stuManager.filterByCampus();
    }
    public void task7(){
        stuManager.showStatisticsByLocation();
    }
    public void task8(){
        stuManager.saveDataToBinaryFile();
    }
}
