//Test.java


class A {
	static void m1(){
		System.out.println("3");
	}
}
class B extends A {
	static void m1() {
		System.out.println("2");
	}
}
public class Test_EXtends {

	public void main(String[] args) {
	   	A.m1();
	}

}
