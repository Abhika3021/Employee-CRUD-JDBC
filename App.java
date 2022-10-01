package employeecrud;

import java.util.*;

public class App
{
    //class app and EmployeeService will play the role of front end
	//EmployeeRepository will play the role of back end
	public static void main(String[] args)
	{
		EmployeeService service = new EmployeeService();
		Scanner sc=new Scanner(System.in); //object create and to call constructor
		do
		{
			System.out.println("Employee Management System");
			System.out.println("----------------------------");
			System.out.println("1: Insert Record");
			System.out.println("2: Show All Record");
			System.out.println("3: Delete Record");
			System.out.println("4: Update Record");
			System.out.println("5: Show Record by ID");
			System.out.println("6: Show record by Name");
			System.out.println("7: Show record by Department");
			System.out.println("8: Quit");
			System.out.println("----------------------------");
			System.out.println("Enter your Choice :");
			int ch=sc.nextInt();
			if(ch==1)
			{
				service.insertRecord();
			}
			else if(ch==2)
			{
				service.showEmployeeList();
			}
			else if(ch==3)
			{
				service.deleteRecord();
			}
			else if(ch==4)
			{
				service.updateRecord();
			}
			else if(ch==5)
			{
				service.showRecordByID();
			}
			else if(ch==6)
			{
				service.showRecordByName();
			}
			else if(ch==7)
			{
				service.showRecordByDept();
			}
			else if(ch==8)
			{
				System.out.println("Thank You, Your session is over");
				System.out.println("----------------------------");
				break;
			}
		}
		while(true);
	}

}
