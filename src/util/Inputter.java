package util;
//inputter là cái rương chứa tool
//các tool này để static để không bị phân bảng

import java.util.Scanner;

//static có nghĩa là thuộc về class
//ta không cần tạo obj để sài đc tool, mình truy cập trực típ qua class luôn
public class Inputter {
    private static Scanner sc = new Scanner(System.in);
    
    //tạo hàm ép nhập số nguyên
    public static int getAnInteger(String inputMsg, String errorMsg){
        while(true){
            try{
                System.out.println(inputMsg);//mời nhập
                int number =  Integer.parseInt(sc.nextLine());
                return number;
            }catch(Exception e){
                System.out.println(errorMsg);
            }
        }
    }

    public static int getAnInteger(String inputMsg, String errorMsg,
                                    int lowerBound, int upperBound){
        while(true){
            try{
                System.out.println(inputMsg);//mời nhập
                int number =  Integer.parseInt(sc.nextLine());
                if(number < lowerBound || number > upperBound){
                    throw new Exception();
                }
                return number;
            }catch(Exception e){
                System.out.println(errorMsg);
            }
        }
    }
    //tạo hàm ép nhập chuỗi, không được bỏ trống
    public static String getAString(String inputMsg, String errorMsg){
        while(true){
            try{
                System.out.println(inputMsg);//mời nhập
                String str = sc.nextLine();
                if(str.isEmpty()){
                    throw new Exception();
                }    
                return str;
            }catch(Exception e){
                System.out.println(errorMsg);
            }
        }
    }
     //tạo hàm ép nhập chuỗi, phải đúng regex
    public static String getAString(String inputMsg, String errorMsg, 
                                    String regex){
        while(true){
            try{
                System.out.println(inputMsg);//mời nhập
                String str = sc.nextLine();
                if(str.isEmpty() || !str.matches(regex)){
                    throw new Exception();
                }    
                return str;
            }catch(Exception e){
                System.out.println(errorMsg);
            }
        }
    }
    //
    
    //tạo hàm ép nhập số thực
    public static double getADouble(String inputMsg, String errorMsg){
        while(true){
            try{
                System.out.println(inputMsg);//mời nhập
                double number =  Double.parseDouble(sc.nextLine());
                return number;
            }catch(Exception e){
                System.out.println(errorMsg);
            }
        }
    }

    public static double  getADouble(String inputMsg, String errorMsg,
                                    double lowerBound, double upperBound){
        while(true){
            try{
                System.out.println(inputMsg);//mời nhập
                double number = Double.parseDouble(sc.nextLine());
                if(number < lowerBound || number > upperBound){
                    throw new Exception();
                }
                return number;
            }catch(Exception e){
                System.out.println(errorMsg);
            }
        }
    }
}
