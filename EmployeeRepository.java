package employeecrud;
import java.sql.*;
public class EmployeeRepository
{
	private PreparedStatement insert,byid,byname,bydept,delete,update;
	private Statement st;
	public EmployeeRepository()
	{
		createConnection();
	}
	public void saveRecord(int eid, String name, String dept, int sal) 
	{
		try {
			insert.setInt(1, eid); // to set the values 
			insert.setString(2,name);
			insert.setString(3,dept);
			insert.setInt(4, sal);
			insert.executeUpdate();//to execute the query
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
	public void showAllRecords()
	{
		try
		{
			ResultSet rst=st.executeQuery("select * from employeeinfo");
			System.out.println("------------------------------------------------------");
			while(rst.next())
			{
				int v1=rst.getInt(1); //It will return the value of resultSet object's first row first column
				String v2=rst.getString(2);
				String v3=rst.getString(3);
				int v4=rst.getInt(4);
				System.out.println("Employee[Eid="+v1+", Name="+v2+", Department="+v3+", Salary="+v4+"]");
			}
			System.out.println("------------------------------------------------------");
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
	public void showRecordByID(int eid)
	{
		try {
			byid.setInt(1, eid); // to set the values 
			ResultSet rst=byid.executeQuery();//to execute the query
			System.out.println("-------------------------------");
			if(rst.next())//to call next method
			{
				System.out.println("Employee Id:"+rst.getInt(1));
				System.out.println("Employee Name:"+rst.getString(2));
				System.out.println("Employee Department:"+rst.getString(3));
				System.out.println("Employee Salary:"+rst.getInt(4));
			}
			else
			{
				System.out.println("Employee with Id "+eid+ " doesn't exist..");
			}
			System.out.println("------------------------------------");
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
	public void showRecordByName(String name)
	{
		try {
			byname.setString(1, name); // to set the string 
			ResultSet rst=byname.executeQuery();//to execute the query
			System.out.println("------------------------------------------------------");
			boolean exist=false;
			while(rst.next())//to show the record using employee name
			{
				exist=true;
				int v1=rst.getInt(1); //It will return the value of resultSet object's first row first column
				String v2=rst.getString(2);
				String v3=rst.getString(3);
				int v4=rst.getInt(4);
				System.out.println("Employee[Eid="+v1+", Name="+v2+", Department="+v3+", Salary="+v4+"]");
			}
			if(!exist)
			{
				System.out.println("Employee with Name "+name+ " doesn't exist..");
			}
			System.out.println("------------------------------------------------------");
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
	public void showRecordByDept(String dept)
	{
		try {
			bydept.setString(1, dept); // to set the string 
			ResultSet rst=bydept.executeQuery();//to execute the query
			System.out.println("------------------------------------------------------");
			boolean exist=false;
			while(rst.next())//to show the record using employee name
			{
				exist=true;
				int v1=rst.getInt(1); //It will return the value of resultSet object's first row first column
				String v2=rst.getString(2);
				String v3=rst.getString(3);
				int v4=rst.getInt(4);
				System.out.println("Employee[Eid="+v1+", Name="+v2+", Department="+v3+", Salary="+v4+"]");
			}
			if(!exist)
			{
				System.out.println("Sorry, Department "+dept+ " doesn't exist..");
			}
			System.out.println("------------------------------------------------------");
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
	public boolean isExist(int eid)
	{
		try {
			byid.setInt(1, eid); // to set the values 
			ResultSet rst=byid.executeQuery();//to execute the query
			return rst.next();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		return false;
	}
	public void deleteEmployeeRecord(int eid)
	 {
		try {
			delete.setInt(1, eid); // to set the values 
			int n=delete.executeUpdate();
			System.out.println("-------------------------------");
			if(n>=1)	
			{
				System.out.println("Employee record has been deleted successfully..");
			}
			else
			{
				System.out.println("Employee with Id "+eid+ " doesn't exist..");
			}
			System.out.println("------------------------------------");
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
	public void updateRecord(int eid, String name, String dept, int sal) 
	{	
		try {
			update.setInt(4, eid); // to set the values 
			update.setString(1,name);
			update.setString(2,dept);
			update.setInt(3, sal);
			update.executeUpdate();//to execute the query
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
	private void createConnection()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cn=DriverManager.getConnection("jdbc:mysql://localhost/jdbc10","root","ABHIKA301021");
			insert=cn.prepareStatement("insert into employeeinfo values(?,?,?,?)");
			st=cn.createStatement();
			byid=cn.prepareStatement("select * from employeeinfo where eid=? ");
			byname=cn.prepareStatement("select * from employeeinfo where name=? ");
			bydept=cn.prepareStatement("select * from employeeinfo where department=? ");
			delete=cn.prepareStatement("delete from employeeinfo where eid=? ");
			update=cn.prepareStatement("update employeeinfo set name=?,department=?,salary=? where eid=? ");
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
}
