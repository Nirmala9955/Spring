abstract class Mark{
  abstract float getPercentage();
}

//--------------------------------

class Student_A extends Mark {
    
    int sub1;
    int sub2;
    int sub3;

    public Student_A(int sub1, int sub2, int sub3){
      this.sub1=sub1;
      this.sub2=sub2;
      this.sub3=sub3;
    }

    public float getPercentage(){
		return ((float)(sub1+sub2+sub3)/300)*100;
	}
  
  }

  class Student_B extends Mark {
    
    int sub1;
    int sub2;
    int sub3;
    int sub4;

    public Student_B(int sub1, int sub2, int sub3, int sub4){
      this.sub1=sub1;
      this.sub2=sub2;
      this.sub3=sub3;
      this.sub4=sub4;
    }

    public float getPercentage(){
		return ((float)(sub1+sub2+sub3+sub4)/400)*100;
    }
   

  }

  public class Test {

    public static void main(String[] args) {
      Student_A sa= new Student_A(87,65,94);
      Student_B sb= new Student_B(45,87,56,80);
       System.out.println(sa.getPercentage());
      System.out.println(sb.getPercentage());
    }

  }