public class Sun {
    private String Name;
    private String early=" раньше ";
    private String lately = "позже ";
    public void setName(String name) {
        this.Name = name;
    }
    public String getName() {
        return this.Name;
    }
    public void sunset(String go, byte t){
        if (t==1)
            System.out.print(getName()+lately+go+" -- ");
        else System.out.print(getName()+early+go +" -- ");
    }
    public static class Rays extends Landshaft{

        public Rays(String name, String description, String action,String how) {
            super(name, description, action, how);
        }
    }
}
