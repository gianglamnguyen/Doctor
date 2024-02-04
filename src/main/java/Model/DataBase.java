
package Model;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBase {
    private String fileName = "doctor.dat";
    private DoctorHash dh;

    public DataBase(DoctorHash dh) {
        this.dh = dh;
    }
    
    public void load () {
        try {
            Scanner sc = new Scanner (new FileReader(fileName));
            while (sc.hasNextLine()) {
                String s = sc.nextLine();
                String[] si = s.split("\\,");
                int ava = Integer.parseInt(si[3]);
                if (si.length == 4) {
                    dh.doAdd(new Doctor(si[0], si[1], si[2], ava));
                }
            }
            System.out.println("File read successfully");
            sc.close();
        } catch (Exception ex) {
            System.out.println("File read failed");
        }
    }
    
    public void save(){
        try {
            FileWriter w = new FileWriter(fileName);
            for (HashMap.Entry<String, Doctor> entry : dh.entrySet()){
            Doctor d = entry.getValue();
            String line = String.format("%s,%s,%s,%s%n", 
                    d.getCode(),
                    d.getName(),
                    d.getSpec(),
                    d.getAvail());
            w.write(line);
            }
            w.close();
            System.out.println("File save succesfully");
        } catch (IOException ex) {
            System.out.println("File save failed");
        }
        
    }
}
