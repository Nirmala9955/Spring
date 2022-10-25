public class Test_Main {  
     public static void main(String []args){  
        try{  
            int a = 1;   
            System.out.println(a/0);  
        }  
        finally  
        {  
            System.out.println("rest of the code...");  
        }  
     }  
}  