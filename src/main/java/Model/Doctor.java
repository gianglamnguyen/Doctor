
package Model;

public class Doctor implements Comparable<Doctor>{
    private String code;
    private String name;
    private String spec;
    private int avail;

    public Doctor(String code, String name, String spec, int avail) {
        this.code = code;
        this.name = name;
        this.spec = spec;
        this.avail = avail;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public int getAvail() {
        return avail;
    }

    public void setAvail(int avail) {
        this.avail = avail;
    }
    
    @Override
    public int compareTo(Doctor o) {
        return Integer.compare(this.avail, o.avail);
    }

    @Override
    public String toString() {
        return String.format("%-8s%-10s%-20s%-15s", code, name, spec, avail);
    }
    
    
}
