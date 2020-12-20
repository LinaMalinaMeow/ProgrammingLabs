public class Challenge implements Harsh{
    private String Name;
    public void setName(String name) {
        this.Name = name;
    }
    public String getName() {
        return this.Name;
    }

    @Override
    public void harsh() {
        System.out.println("суровых "+getName());
    }
}
