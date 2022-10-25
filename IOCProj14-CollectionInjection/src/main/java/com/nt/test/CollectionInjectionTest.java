package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.College;
import com.nt.beans.ContactsInfo;
import com.nt.beans.MarksInfo;
import com.nt.beans.UniversityInfo;

public class CollectionInjectionTest {

	public static void main(String[] args) {
		DefaultListableBeanFactory factory = null;
		XmlBeanDefinitionReader reader = null;
		MarksInfo marks = null;
		College college = null;
		ContactsInfo contact = null;
		UniversityInfo university = null;
		//Create IoC container
		factory = new DefaultListableBeanFactory();
		reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//get MarksInfo class object
		marks = factory.getBean("marksBean", MarksInfo.class);
		System.out.println(marks);
		System.out.println("--------------------------");
		//get College class obejct
		college = factory.getBean("collegeBean", College.class);
		System.out.println(college);
		System.out.println("--------------------------");
		//get ContactsInfo class obejct
		contact = factory.getBean("contactBean", ContactsInfo.class);
		System.out.println(contact);
		System.out.println("--------------------------");
		//get ContactsInfo class obejct
		university = factory.getBean("universityBean", UniversityInfo.class);
		System.out.println(university);
	}

}
