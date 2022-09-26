package Javaovchipkaart;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Mainp2 {
    private static Connection conn;

    public static void main(String [] args){
        try {
            ReizigerDAOPsql rdaosql = new ReizigerDAOPsql(getConnection());
            testReizigerDAO(rdaosql);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    public static Connection getConnection() throws SQLException {
        if (conn == null)
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ovchip2", "postgres", "postgres");
        return conn;
    }
    public static void closeConnection() throws SQLException {
        if(conn != null) {
            conn.close();
            conn = null;
        }
    }

    private static void testReizigerDAO(ReizigerDAO rdao) throws SQLException {
        System.out.println("\n---------- Test ReizigerDAO -------------");

        // Haal alle reizigers op uit de database
        List<Reiziger> reizigers = rdao.findAll();
        System.out.println("[Test] ReizigerDAO.findAll() geeft de volgende reizigers:");
        for (Reiziger r : reizigers) {
            System.out.println(r);
        }
        System.out.println();

        String gbdatum = "1981-03-14";
        Reiziger sietske = new Reiziger(77, "S", "", "Boers", Date.valueOf(gbdatum));
        System.out.print("[Test] Eerst " + reizigers.size() + " reizigers, na ReizigerDAO.save() ");
        rdao.save(sietske);
        reizigers = rdao.findAll();
        System.out.println(reizigers.size() + " reizigers\n");


        System.out.println(sietske);
        sietske.setAchternaam("Vamos");
        rdao.update(sietske);
        System.out.println("De achternaam Sietske is geupdate: \n" + sietske + "\n");


        // Voeg aanvullende tests van de ontbrekende CRUD-operaties in.

        System.out.print("[Test] Eerst " + reizigers.size() + " reizigers, na ReizigerDAO.save() ");
        rdao.delete(sietske);
        reizigers = rdao.findAll();
        System.out.println(reizigers.size() + " reizigers\n");

        System.out.println("[Test] find by Id geeft: ");
        Reiziger reiziger = rdao.findById(1);
        System.out.println(reiziger + "\n");

        List<Reiziger> rgbd = rdao.findByGbdatum("2002-12-03");
        System.out.println("[Test] ReizigerDAO.findByGbdatum() geeft de volgende reizigers:");
        for (Reiziger r : rgbd) {
            System.out.println(r);
        }
        System.out.println();


    }



}