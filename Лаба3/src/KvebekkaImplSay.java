public class KvebekkaImplSay extends Human {
    protected KvebekkaImplSay(String name) {
        super(name);
    }


    @Override
    public void speech(String text) {
        System.out.println(text);
    }
}
