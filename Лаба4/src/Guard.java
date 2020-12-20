public class Guard {
    private String Name;
    public void setName(String name) {
        this.Name = name;
    }
    public String getName() {
        return this.Name;
    }
    public void onPost(){
        System.out.println(", словно "+getName()+" на посту,");
    }
    public void guarding(){
        System.out.print(" охраняя ");
    }
}
