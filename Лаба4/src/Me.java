public class Me extends Human{
    protected Me(String name) {
        super(name);
    }
    public String myself = " меня";
    public String inHang = " я взял себя в руки";
    public String after = " впоследствии ";
    public String I = " я ";
    @Override
    public String speech(String text) {
        System.out.println(text);
        return text;
    }
    public String action(String action){
        return action;
    }
    String japaniseName  = Country.JAPANISE.getName();
    public void remembered(Engaving engaving,Fudzi fudzi,String action){
        System.out.println(action+ getName()+ japaniseName+engaving.getName()+fudzi.saint(" священной "));

    }
    public void takePity(Paintings paintings,String action,String read){
        System.out.println(after+I+action+read+paintings.getDescription2());
    }
    public void after(Tropic tropic){
        System.out.print("после пребывания в "+ tropic.getName());
    }
}
