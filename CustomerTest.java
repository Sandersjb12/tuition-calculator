//Jeremy Sanders
//Insy 4305-001

import java.util.*;
import javax.swing.*;

public class CustomerTest
{
	public static void main(String[] args)
	{
		ArrayList<Customer> customerList=new ArrayList<Customer>();
		String invoices="";

		customerList.add(new Customer("Jones",new Address("786 Cooper","Arlington","Texas",76019),12345));
		customerList.get(0).setCType(Customer.CustomerType.STUDENT);
		customerList.get(0).addCourse(new OnlineCourse("Java 1","Davis",125,new Date(1,1,2015),new Date(2,1,2015),"UTA",true,12));
		customerList.get(0).getCourseList().get(0).setCType(Course.CourseType.PROGRAMMING);
		customerList.get(0).addCourse(new OnlineCourse("Java 2","Davis",125,new Date(2,2,2015),new Date(3,1,2015),"UTA",true,12));
		customerList.get(0).getCourseList().get(1).setCType(Course.CourseType.PROGRAMMING);
		customerList.get(0).addCourse(new InClassCourse("Canon Pictures","Long",75,new Date(1,15,2015),new Date(2,3,2015),"COB 142",new Time(17,30),new Time(18,50)));
		customerList.get(0).getCourseList().get(2).setCType(Course.CourseType.PHOTOGRAPHY);

		customerList.add(new Customer("Smith",new Address("921 Bowen","Arlington","Texas",76006),65489));
		customerList.get(1).setCType(Customer.CustomerType.FACULTY);
		customerList.get(1).addCourse(new OnlineCourse("Relieve Stress","Jones",35,new Date(3,2,2015),new Date(3,31,2015),"None",false,5));
		customerList.get(1).getCourseList().get(0).setCType(Course.CourseType.MISC);
		customerList.get(1).addCourse(new InClassCourse("Play the Piano","Smith",40,new Date(4,1,2015),new Date(5,1,2015),"UH 105",new Time(13,30),new Time(15,30)));
		customerList.get(1).getCourseList().get(1).setCType(Course.CourseType.MUSIC);

		customerList.add(new Customer("Willis",new Address("123 Love Lane","Arlington","Texas",75550),27589));
		customerList.get(2).setCType(Customer.CustomerType.GOVERNMENT);
		customerList.get(2).addCourse(new OnlineCourse("Relieve Stress","Jones",35,new Date(3,2,2015),new Date(3,31,2015),"None",false,5));
		customerList.get(2).getCourseList().get(0).setCType(Course.CourseType.MISC);
		customerList.get(2).addCourse(new InClassCourse("Play the Piano","Smith",40,new Date(4,1,2015),new Date(5,1,2015),"UH 105",new Time(13,30),new Time(15,30)));
		customerList.get(2).getCourseList().get(1).setCType(Course.CourseType.MUSIC);

		for(Customer c:customerList)
		{
			System.out.println(c);
			System.out.println();
			invoices+=c.createInvoice();
		}

		JOptionPane.showMessageDialog(null,String.format("Name     Account     Charge%s",invoices));
	}
}