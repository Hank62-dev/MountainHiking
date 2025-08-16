
package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public abstract class FileHandler<T> {
    //load: biến nội dung trong file thành list
    public boolean load(String url, ArrayList<T> Tlist){
        Tlist.clear();// xóa trước khi nhét vào
        File f = new File(url);//biến từ url thành file
        try{
            BufferedReader reader = new BufferedReader(new FileReader(f));
            String line = reader.readLine();
            while(line != null){
                //xử lý dòng trả về T
                T newT = handerLine(line);
                //được obj
                Tlist.add(newT);
                //đọc line tiếp theo
                line = reader.readLine();//dọc line tiếp theo
            }
            return true;
        }catch(IOException | NumberFormatException e){//tìm kh thấy file,  và ép kiểu sai
            System.out.println("File error");
            return false;
            
        }
    }
    //save: Lưu những gì trong list vào file
    public abstract T handerLine(String line);
    
    
    
    public boolean save(ArrayList<T> list, String url){
        File f = new File(url);
        try{
            
            FileOutputStream os = new FileOutputStream(f);
            OutputStreamWriter writer = new OutputStreamWriter(os);
            for (T item : list) {
                writer.write(item.toString());
                writer.write("\n");
                
            }
            writer.flush();//save file
            return true;    
        }catch(Exception e){
            System.out.println("File error");
            return false;
        }
    }
    
    
    
    
}
