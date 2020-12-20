public class Victoria extends Place {
    public Victoria(String name) {
        setName(name);
    }
    public void get(Eastbeach eastbeach){
        System.out.print(eastbeach.getEastbeach()+getName());
    }
    public static class Eastbeach{
       public String getEastbeach(){
           return " восточного берега";
       }
    }
}
