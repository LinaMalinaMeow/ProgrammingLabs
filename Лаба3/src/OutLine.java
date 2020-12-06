
public class OutLine {
    private String Name;
    public void setName(String name) {
        this.Name = name;
    }
    public String getName() {
        return this.Name;
    }
    protected String clear = "четкие";
    protected String unclear = "нечеткие";
    public void lined(boolean l,Gigant gigant){
        if(l=true){
            System.out.print(clear+getName()+ gigant.getName()+"а");
        }
        else{
            System.out.print(unclear+getName()+ gigant.getName()+"а");
        }
    }
}
