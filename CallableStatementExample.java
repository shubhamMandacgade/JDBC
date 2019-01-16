import java.sql.*;
import java.util.Scanner;

class Callsum extends Myconnection
{
  public static void main(String args[]) throws Exception
    {
     Myconnection cn=new Myconnection();
     
     connect();
    
     CallableStatement cs=null;
  
     int first,second,third,sum;
     Scanner sc=new Scanner(System.in);
     cs=conn.prepareCall("{?=Call fnComputeSumM1(?,?,?)}");
     cs.registerOutParameter(1,Types.INTEGER);
     
     System.out.println("Enter three numbers:-");

     first=sc.nextInt();
     second=sc.nextInt();
     third=sc.nextInt();
     
     cs.setInt(2,first);
     cs.setInt(3,second);
     cs.setInt(4,third);
     cs.execute();
     Integer output = cs.getInt(1);
     System.out.println(output+" is addition of above numbers");
   }
}
     
     