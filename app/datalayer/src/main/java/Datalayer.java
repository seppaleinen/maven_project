public class Datalayer {
    private Object obj;

    public Datalayer(){}

    public void persist(Object obj){
        this.obj = obj;
        System.out.println(obj.toString() + " persisted");
    }

    public Object find(Object obje){
        this.obj = obje;
        return obj;
    }
}