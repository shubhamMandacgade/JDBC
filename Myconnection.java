import java.sql.*;

public class Myconnection 
  {
    static Connection conn=null;
    
    static void connect() throws Exception
      {

           
       String driverclass="com.microsoft.sqlserver.jdbc.SQLServerDriver";
       String url ="jdbc:sqlserver://Lenovo\\instanceName=MSDBA;portNumber=53367;databaseName=BASIC;integratedSecurity=true";
                  
                  Class.forName(driverclass);
                  conn = DriverManager.getConnection(url);
                  System.out.println("================================");

                  System.out.println("Database Successfully connected");

                  System.out.println("================================");
      }

                 
     
 }



