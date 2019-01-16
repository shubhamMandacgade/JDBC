import java.sql.*;
import java.util.Scanner;

class Operation extends Myconnection
{
   void insert() throws Exception
    {
            int id,salary,ch;
            String name,q;
            Scanner sc=new Scanner(System.in);
            Statement s=conn.createStatement();
         do{
             System.out.println("\nInsert EMP_ID   EMP_NAME   EMP_SALARY");
             id=Integer.parseInt(sc.nextLine());
             name=sc.nextLine();
             salary=Integer.parseInt(sc.nextLine());
             q =("INSERT INTO Empoperation VALUES("+id+", '"+name+"', "+salary+")");
             s.executeUpdate(q);
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
            Statement s=conn.createStatement();
         do{
             System.out.println("\nInsert EMP_ID to delete record:-");
             id=Integer.parseInt(sc.nextLine());
             q ="delete from Empoperation where empid="+id;
             s.executeUpdate(q);
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
            Statement s=conn.createStatement();
         do{
             System.out.println("\nInsert EMP_ID and INCREMENTED SALARY to update record:-");
             id=Integer.parseInt(sc.nextLine());
             salary=Integer.parseInt(sc.nextLine());
             q ="update Empoperation set empsalary="+salary+ "where empid="+id;
             s.executeUpdate(q);
             System.out.println("\nOne row updated...");
             System.out.println("\nType 1 to repeat or any other number to exit...");
             ch=Integer.parseInt(sc.nextLine());
         }while(ch==1);
    }
  
   void show() throws Exception
    {
            int id,salarych,ch;
            String q,name;
            Scanner sc=new Scanner(System.in);
            Statement s=conn.createStatement();
         do{
             System.out.println("\nInsert EMP_ID to search record:-");
             id=Integer.parseInt(sc.nextLine());
             q ="select * from Empoperation where empid="+id;
             ResultSet rs=s.executeQuery(q);
             int n=0;
             while(rs.next())
               {
                 n++;
                 System.out.println("EmpId:-"+rs.getInt(1));
                 System.out.println("EmpName:-"+rs.getString(2));
                 System.out.println("EmpSalary:-"+rs.getInt(3));  
               }
             if(n==0)
               System.out.println("\nNo rows found...");
             else
               System.out.println(n+ "rows found...");
             
             System.out.println("\nType 1 to repeat or any other number to exit...");
             ch=Integer.parseInt(sc.nextLine());
         }while(ch==1);
    }
  
   public static void main(String args[]) throws Exception
     {
     Scanner sc=new Scanner(System.in);
     Myconnection cn=new Myconnection();
     connect();
     Operation op=new Operation();
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
            


























 