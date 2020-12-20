public class Po  extends Human{
    private String action;
    protected Po(String name, String action) {
        super(name);
        this.action= action;
    }
    @Override
    public String speech(String text) {
        return text;
    }
    public String getAction(){
        return action;
    }
}
