// DatabaseMetaData

import java.sql.*;

class DBMD extends MyConnection
{
  public static void main(String args[]) throws Exception	
  {
    connect("hr","manager");
    DatabaseMetaData dbmd=c.getMetaData();
    System.out.println(dbmd.getURL());
    System.out.println(dbmd.getUserName());
    System.out.println(dbmd.getDatabaseProductName());
    System.out.println(dbmd.getDatabaseProductVersion());
    System.out.println(dbmd.getDriverName());
    System.out.println(dbmd.getDriverVersion());
    System.out.println(dbmd.getMaxTableNameLength());

  }
}

   