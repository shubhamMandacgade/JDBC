import java.sql.*;
import java.util.Scanner;

class OperationUsingPreparedResultSet extends Myconnection
{
   void insert() throws Exception
    {
        int id,salary,ch;
        String name,q;
        Scanner sc=new Scanner(System.in);
        q="insert into Empoperation VALUES(?,?,?)";
        PreparedStatement ps=conn.prepareStatement(q);  
     do{
         System.out.println("\nInsert EMP_ID   EMP_NAME   EMP_SALARY");
         id=Integer.parseInt(sc.nextLine());
         name=sc.nextLine();
         salary=Integer.parseInt(sc.nextLine());
         ps.setInt(1,id);
         ps.setString(2,name);
         ps.setInt(3,salary);
         ps.execute();
         System.out.println("\nOne row inserted...");
         System.out.println("\nType 1 to repeat or any other number to exit...");
         ch=Integer.parseInt(sc.nextLine());
      }while(ch==1);
    }
  
   void delete() throws Exception
    {
       int id,ch;
       String q;
       Scanner sc=new Scanner(System.in);
       q="delete from Empoperation where empid=?";
       PreparedStatement ps=conn.prepareStatement(q);  
     do{
         System.out.println("\nInsert EMP_ID to delete record");
         id=Integer.parseInt(sc.nextLine());
         ps.setInt(1,id);
         ps.execute();
         System.out.println("\nOne row deleted...");
         System.out.println("\nType 1 to repeat or any other number to exit...");
         ch=Integer.parseInt(sc.nextLine());
      }while(ch==1);
    }

   
   void update() throws Exception
    {
        int id,salary,ch;
        String q;
        Scanner sc=new Scanner(System.in);
        q="update Empoperation set empsalary=? where empid=?";
        PreparedStatement ps=conn.prepareStatement(q);  
     do{
         System.out.println("\nInsert EMP_ID   EMP_SALARY to update salary");
         id=Integer.parseInt(sc.nextLine());
         salary=Integer.parseInt(sc.nextLine());
         ps.setInt(1,salary);
         ps.setInt(2,id);
         ps.execute();
         System.out.println("\nOne row updated...");
         System.out.println("\nType 1 to repeat or any other number to exit...");
         ch=Integer.parseInt(sc.nextLine());
      }while(ch==1);
    }
 
   void show() throws Exception
   {
        int id,salary,ch;
        String q,name;
        Scanner sc=new Scanner(System.in);
        ResultSet rs;
        q="select * from Empoperation where empid=?";
        PreparedStatement ps=conn.prepareStatement(q); 
     do{
        System.out.println("\nInsert EMP_ID to retrive data\n");
        id=sc.nextInt();
        ps.setInt(1,id);
        rs=ps.executeQuery();
           if(rs.next()==false)
              System.out.println("No rows found...");
           else
              System.out.println("____________________________\n");
              System.out.println(rs.getInt(1)+"|"+rs.getString(2)+"|"+rs.getInt(3));
           
           System.out.println("\nType 1 to repeat or any other number to exit...");
           ch=sc.nextInt();
     }while(ch==1);
   }
   

   public static void main(String args[]) throws Exception
   {
     Scanner sc=new Scanner(System.in);
     Myconnection cn=new Myconnection();
     connect();
     OperationUsingPreparedResultSet op=new OperationUsingPreparedResultSet();
     int choise;
     do{
         System.out.println("\n1.Insertion\n2.Deletion\n3.Updation\n4.Show\n5.Exit");
         System.out.println("\nEnter your choise:-");
         choise=Integer.parseInt(sc.nextLine());
         switch(choise){
               case 1: op.insert();
               break;
               case 2: op.delete();
               break;
               case 3: op.update();
               break;
               case 4: op.show();
               break;
               case 5: System.out.println("End of operations...");
               break;
               default: System.out.println("Invalid choise...");
        }
    }while(choise!=5);
  }  


}