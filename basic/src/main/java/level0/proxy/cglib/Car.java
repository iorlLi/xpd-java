package level0.proxy.cglib;

public class Car {
    private String name;
    private String prise;

    public Car(String name, String prise) {
        this.name = name;
        this.prise = prise;
    }

    public Car() {
        this.name = "car";
        this.prise = "3";
    }

    public void name(){
        System.out.println("Car: just a car");
    }
}
