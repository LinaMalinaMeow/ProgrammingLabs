public class Dendorf extends Human{
    private String Name;
    private String notise;
    private String on;
    private String add;
    @Override
    public String speech(String text) {
        return text;
    }
    protected Dendorf(String name) {
        super(name);
    }
    public String getNotise() {
        return this.notise;
    }
    public String getOn() {
        return this.on;
    }
    public String getAdd() {
        return this.add;
    }
    public Dendorf(String name,String notise,String on,String add){
        this(name);
        this.notise = notise;
        this.on=on;
        this.add=add;
    }
}
