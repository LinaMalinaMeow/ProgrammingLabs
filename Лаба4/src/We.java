public class We extends Human{
    protected We(String name) {
        super(name);
    }
    public String ourselves = " нас ";
    public String us = " нам ";
    @Override
    public String speech(String text) {
        System.out.println(text);
        return text;
    }

    public String stayOn(Ship.Anchor anchor, String action){
        return action + anchor.getName();
        }

    public String action(String action){
        return action;
    }

}
