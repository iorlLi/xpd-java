package level0.proxy.cglib;

public class SchoolBus extends Car{
    @Override
    public void name() {
        System.out.println("SchoolBus : for kid");
    }

    public String getName(){
        return "just SchoolBus ";
    }
}
