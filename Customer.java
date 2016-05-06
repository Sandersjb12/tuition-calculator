//Jeremy Sanders
//Insy 4305-001

import java.util.*;

public class Customer implements Invoice
{
	private String name;
	private Address address;
	private int accountNumber;
	public enum CustomerType{STUDENT,FACULTY,GOVERNMENT};
	private CustomerType cType;
	private ArrayList<Course> courseList=new ArrayList<Course>();
	private double charge;

	public Customer()
	{
		this("None",new Address(),-1);
	}

	public Customer(String name, Address address, int accountNumber)
	{
		setName(name);
		setAddress(address);
		setAccountNumber(accountNumber);
	}

	public void setName(String name)
	{
		this.name=name;
	}

	public void setAddress(Address address)
	{
		this.address=address;
	}

	public void setAccountNumber(int accountNumber)
	{
		this.accountNumber=accountNumber;
	}

	public void setCType(CustomerType cType)
	{
		this.cType=cType;
	}

	public void addCourse(Course course)
	{
		courseList.add(course);
	}

	public String getName()
	{
		return name;
	}

	public Address getAddress()
	{
		return address;
	}

	public CustomerType getCType()
	{
		return cType;
	}

	public ArrayList<Course> getCourseList()
	{
		return courseList;
	}

	public String createInvoice()
	{
		charge=0;

		switch (getCType())
		{
			case STUDENT:
				charge+=25;
				break;

			case FACULTY:
				charge+=50;
				break;

			case GOVERNMENT:
				charge+=35;
				break;

			default:
				System.out.println("ERROR: Customer.createInvoice");
				break;
		}

		for(Course c:courseList)
			charge+=c.calculateCharge(getCType());

		return String.format("\n%s     %d     $%.2f",getName(),accountNumber,charge);
	}

	public String toString()
	{
		return String.format("Name: %s\nAddress: %s\nAccount Number: %d\nCustomer Type: %s\nCourses: %s",getName(),getAddress(),accountNumber,getCType(),getCourseList());
	}
}