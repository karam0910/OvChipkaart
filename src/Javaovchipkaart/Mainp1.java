package Javaovchipkaart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Mainp1 {
    public static void main(String [] args){

        try {

            Connection myConnection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ovchip2", "postgres", "postgres");

            String sqlquery = "select * from reiziger;";

            PreparedStatement myStmt = myConnection.prepareStatement(sqlquery);

            ResultSet myRs = myStmt.executeQuery();

            System.out.println("Alle reizigers: ");

            while (myRs.next()) {
                String tussenvoegsel = myRs.getString("tussenvoegsel");
                if (tussenvoegsel == null) {
                    tussenvoegsel = "";
                } else {
                    tussenvoegsel = tussenvoegsel + " ";
                }
                System.out.println("#" + myRs.getString("reiziger_id") + ":" + " " + myRs.getString("voorletters")
                            + "." + " " + tussenvoegsel + myRs.getString("achternaam") +
                             " " + "(" + myRs.getString("geboortedatum") + ")");

            }

            myConnection.close();
            myRs.close();
            myStmt.close();
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }


    }
}
