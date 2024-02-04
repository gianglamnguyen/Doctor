
package Controller;

import Common.Library;
import Model.DataBase;
import Model.Doctor;
import Model.DoctorHash;
import View.View;
import static java.lang.System.out;
import java.util.HashMap;
import view.Menu;

public class Controller extends Menu{

    private static String[] mc = {"Add Doctor", "Update Doctor", "Delete Doctor","Search Doctor" , "Exit"};
    private DoctorHash dMap;
    private Library lib;
    private View v;
    private DataBase db;
    
    public Controller(){
        super("========= Doctor Management ==========", mc);
        lib = new Library();
        dMap = new DoctorHash();
        db = new DataBase(dMap);
        v = new View();
        db.load();
    }

    @Override
    public void execute(int n) {
        switch(n){
            case 1:
            {
                try {
                    addDoctor();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
                break;

            case 2:
            {
                try {
                    updateDoctor();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
                break;

            case 3:
            {
                try {
                    deleteDoctor();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());                
                }
            }
                break;

            case 4:
            {
                try {
                    searchDoctor();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
                break;

            case 5:
                db.save();
                System.exit(0);
        }
    }
    
    public void addDoctor() throws Exception{
        System.out.println("--------- Add Doctor ----------");
        String c = lib.getString("Enter Code: ");
        String n = lib.getString("Enter Name: ");
        String s = lib.getString("Enter Specialization: ");
        int a = lib.getInt("Enter Availability: ");
        dMap.doAdd(new Doctor(c, n, s, a));
        v.printAll(dMap);
        System.out.println("\n");
    }
    
    public void updateDoctor() throws Exception{
        System.out.println("--------- Update Doctor -------");
        String c = lib.getString("Enter Code: ");
        String n = lib.getString("Enter Name: ");
        String s = lib.getString("Enter Specialization: ");
        int a = lib.getInt("Enter Availability: ");
        dMap.doEdit(new Doctor(c, n, s, a));
        v.print(dMap, c);
        System.out.println("\n");
    }

    
    public void deleteDoctor() throws Exception{
        System.out.println("--------- Delete Doctor -------");
        String c = lib.getString("Enter Code: ");
        dMap.doDelete(dMap.get(c));
        System.out.println("Deleted");
        System.out.println("\n");
    }
    
    public void searchDoctor() throws Exception{
        System.out.println("---------- Search Doctor --------");
        String cc = lib.getString("Enter text: ");
        v.printAll(dMap.doSearch(cc));
        System.out.println("\n");
    }
}