public class DeathWorld implements Staying {
    private String Name1;
    private String Name2;
    public void setName(String name,String name2) {
        this.Name1 = name;
        this.Name2 = name2;
    }
    public String getName() {
        return this.Name1+stay()+this.Name2;
    }
    public String secret=" таинственный ";
    @Override
    public String stay() {
        return " застывшей ";
    }
    public void getDescription(){
        System.out.println(secret+getName());
    }
}
