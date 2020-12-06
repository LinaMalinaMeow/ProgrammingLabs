public class We extends Human{
    protected We(String name) {
        super(name);
    }
    @Override
    public void speech(String text) {
        System.out.println(text);
    }

  ///  String atnoonName = Time.ATNOON.getName();
  // String atafternoonName = Time.ATAFTERNOON.getName();

    public void stayOn(Anchor anchor, String action){
            System.out.print(action+ anchor.getName());
        }


    public String action(String action){
        return action;
    }

}
