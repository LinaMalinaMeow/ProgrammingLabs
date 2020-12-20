public class Dendorf extends Human{
    private String Name;
    private String notice;
    private String on;
    private String add;
    @Override
    public String speech(String text) {
        return text;
    }
    protected Dendorf(String name) {
        super(name);
    }
    public String getNotice() {
        return this.notice;
    }
    public String getOn() {
        return this.on;
    }
    public String getAdd() {
        return this.add;
    }
    public Dendorf(String name,String notice,String on,String add){
        this(name);
        this.notice = notice;
        this.on=on;
        this.add=add;
    }
}
