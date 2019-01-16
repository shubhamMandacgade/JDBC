// program to get ResultSetMetaData for the given Query/table
import java.sql.*;
import java.util.*;

class RSMD extends MyConnection
{
  public static void main(String args[]) throws Exception
  {
 // Scanner sc=new Scanner(System.in);
    connect("hr","manager");
    Statement s=c.createStatement();
    String q="select employee_id, first_name, salary*12.5/100 as Bonus, hire_date from employees";

    ResultSet rs=s.executeQuery(q);
    ResultSetMetaData rsmd=rs.getMetaData();
//  System.out.println("Table Name is "+rsmd.getTableName(1));

    int n=rsmd.getColumnCount();
    for(int i=1;i<=n;i++)
    {
      System.out.println(rsmd.getColumnName(i)+"\t"+rsmd.getColumnTypeName(i)+"\t"+rsmd.getColumnLabel(i)+"\t"+rsmd.getPrecision(i)+"\t"+rsmd.getScale(i));
    }

  }
}