package util;
//cái khuôn chuyên đúc menu

import java.util.ArrayList;


public class Menu<E> {
    private String title;
    private ArrayList<String> opsList;
    //contructor
    public Menu(String title) {
        this.opsList = new ArrayList<>();
    }
    public void addAnOption(String opt){
        this.opsList.add(opt);
    }
    
    public void print(){
        int count = 1;
        for (String opt : opsList) {
            System.out.println(count + "."+ opt);
            count++;
        }
    }
    
    public int getChoice(){
        return Inputter.getAnInteger("Vui lòng nhập lựa chọn: ", "Lựa chọn phải từ 1 đến "
                + opsList.size(), 1, opsList.size());
        //mời người dùng nhập, chỉ được nhập từ 1 đến size của opsList
        //kh đúng thì chửi và ép nhập lại
        //đúng thì anh sẽ return số em đã nhập
    }
    
    public E ref_getChoice(ArrayList<E> options){
        //E mà cô nói là Brand
        //options ở đây là ArrayList<Brand> tức là BrandList
        //hiển thị options dưới dạng menu co số
        for(int i = 0; i <= options.size() - 1; i++){
            System.out.println((i + 1) +". " + options.get(i).toString());
        }
        int choice = Inputter.getAnInteger("Input your choice: ",
                "Your choice must be between 1 and "+ options.size(), 1, options.size());
        
        return options.get(choice - 1);
    }
    
}
