	package com.nt.test;
	
	import org.springframework.beans.factory.BeanFactory;
	import org.springframework.beans.factory.xml.XmlBeanFactory;
	import org.springframework.core.io.ClassPathResource;
	
	import com.nt.beans.Employee;
	import com.nt.beans.Marks;
	import com.nt.beans.Student;
	
	public class ResolvingConstructorInjectionTest {
		
		public static void main(String[] args) {
			BeanFactory factory = null;
			Marks marks = null;
			Employee employee = null;
			Student student = null;
			//Create BeanFactory [IoC] container
			factory = new XmlBeanFactory(new ClassPathResource("com/nt/cfgs/applicationContext.xml"));
			//get Marks class object
			marks = factory.getBean("mark", Marks.class);
			System.out.println(marks);
			System.out.println("---------------------------");
			employee = factory.getBean("emp", Employee.class);
			System.out.println(employee);
			System.out.println("---------------------------");
			student = factory.getBean("stud", Student.class);
			System.out.println(student);
		} 
	
	}
