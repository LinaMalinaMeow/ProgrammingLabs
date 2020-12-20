
public class KvebekkaImplSay extends Human {
    protected KvebekkaImplSay(String name) {
        super(name);
    }


    @Override
    public String speech(String text) {
        System.out.println(text);
        return text;
    }
}
