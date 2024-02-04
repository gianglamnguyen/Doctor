
package Model;

import java.util.HashMap;

public class DoctorHash extends HashMap<String, Doctor>{

    public DoctorHash() {
    }
    
    public void doAdd(Doctor d) throws Exception{
        if (this.containsKey(d.getCode())) throw new Exception("Doctor code " + d.getCode() +" is duplicate");
        if (d == null) throw new Exception("Data does not exist");
        this.put(d.getCode(), d);
    }
    
    public void doEdit(Doctor d) throws Exception{
        if (this.isEmpty()) throw new Exception ("Database does not exist");
        if (!this.containsKey(d.getCode())) throw new Exception("Doctor code does not exist");
        if (d == null) throw new Exception("Data does not exist");
        this.replace(d.getCode(), d);
    }
    
    public void doDelete(Doctor d) throws Exception{
        if (this.isEmpty()) throw new Exception ("Database does not exist");
        if (!this.containsKey(d.getCode())) throw new Exception("Doctor code does not exist");
        if (d == null) throw new Exception("Data does not exist");
        this.remove(d.getCode());
    }
    
    public HashMap<String, Doctor> doSearch(String data) throws Exception{
        if (this.isEmpty()) throw new Exception ("Database does not exist");
        HashMap<String, Doctor> rs = new HashMap<>();
        for (HashMap.Entry<String, Doctor> entry : this.entrySet()){
            Doctor d = entry.getValue();
            if (d.getCode().contains(data) ||
                d.getName().contains(data) ||
                d.getSpec().contains(data)) rs.put(entry.getKey(), d);
        }
        return rs;
    }
}