package employeecrud;

import java.util.Scanner;

public class EmployeeService
{
	private EmployeeRepository repo=new EmployeeRepository(); //
	Scanner sc= new Scanner (System.in);//import class object which is pre-defined
	public void insertRecord()
	{	
		System.out.println("--------------------------");
		System.out.println("Enter Employee id:");
		int eid=sc.nextInt();
		if(repo.isExist(eid))
		{
			System.out.println("Employee with id "+eid+" already exist");
			System.out.println("------------------------------");
			return;
		}
		System.out.println("Enter Employee name:");
		sc.nextLine();
		String name=sc.nextLine();
		System.out.println("Enter Employee Dept:");
		String dept=sc.nextLine();
		System.out.println("Enter Employee Salary:");
		int sal=sc.nextInt();
		System.out.println("--------------------------");
		repo.saveRecord(eid, name, dept, sal);
		System.out.println("Employee Record have been saved successfully");
		System.out.println("-------------------------------------------");
	}
	public void showEmployeeList() 
	{
		repo.showAllRecords();
	}
	public void showRecordByID()
	{
		System.out.println("--------------------------");
		System.out.println("Enter employee id :");
		int eid=sc.nextInt();
		repo.showRecordByID(eid);
	}
	public void showRecordByName()
	{	
		System.out.println("--------------------------");
		System.out.println("Enter employee Name :");
		String name=sc.nextLine();
		repo.showRecordByName(name);
	}
	public void showRecordByDept() 
	{
		System.out.println("--------------------------");
		System.out.println("Enter employee Department :");
		String dept=sc.nextLine();
		repo.showRecordByDept(dept);
	}
	public void deleteRecord() 
	{	
		System.out.println("--------------------------");
		System.out.println("Enter employee id :");
		int eid=sc.nextInt();
		repo.deleteEmployeeRecord(eid);
	}
	public void updateRecord() 
	{
		System.out.println("--------------------------");
		System.out.println("Enter Employee id:");
		int eid=sc.nextInt();
		if(!repo.isExist(eid))
		{
			System.out.println("Employee with id "+eid+" doesn't exist");
			System.out.println("----------------------------------");
			return;
		}
		System.out.println("Enter new/old name:");
		sc.nextLine();
		String name=sc.nextLine();
		System.out.println("Enter new/old Dept:");
		String dept=sc.nextLine();
		System.out.println("Enter new/old Salary:");
		int sal=sc.nextInt();
		System.out.println("--------------------------");
		repo.updateRecord(eid, name, dept, sal);
		System.out.println("Employee Record have been updated successfully");
		System.out.println("-------------------------------------------");
	}
}
