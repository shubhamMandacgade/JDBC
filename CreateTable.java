import java.sql.*;
import java.util.*;

class CreateTable extends MyConnection
{
  public static void main(String args[]) throws Exception
  {
    connect("hr","manager");
    Statement s=c.createStatement();
    System.out.println("enter table name ");
    Scanner sc=new Scanner(System.in);
    String tname=sc.nextLine();

    String q="create table "+tname+"(sno number(4), name varchar2(10),phno number(10))";
    s.executeUpdate(q);

  }
}
