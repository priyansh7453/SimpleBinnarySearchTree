package Main;
import implementation.mybinary;

public class MainClass {
    public static void main(String[] args) {
        mybinary obj = new mybinary();
        obj.insert(55);
        obj.insert(23);
        obj.insert(11);
        obj.insert(77);
        obj.insert(00);
        obj.insert(67);
        System.out.println("input data" + obj);
        obj.isEmpty();
        obj.search(23);
    }
}