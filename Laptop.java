package Java_Homeworks.Homework6_2;

public class Laptop {
    int id;
    String proc;
    double scrn;
    Integer mem;
    Integer stor;
    String os;

    static Integer count = 550;

    public Laptop (String processor, double screen, Integer ram, Integer hdd, String operationSystem) {
        this.id = count;
        count++;
        this.proc = processor;
        this.scrn = screen;
        this.mem = ram;
        this.stor = hdd;
        this.os = operationSystem;
    }

    // public Integer generalID(Integer count) {
    //     return ++count;
    // }

    
    public static void main(String[] args) {

    }
    
}
