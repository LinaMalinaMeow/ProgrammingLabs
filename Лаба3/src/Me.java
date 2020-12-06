public class Me extends Human{
    protected Me(String name) {
        super(name);
    }

    @Override
    public void speech(String text) {
        System.out.println(text);
    }
    public String action(String action){
        return action;
    }
    String japaniseName  = Country.JAPANISE.getName();
    public void remembered(Engaving engaving,Fudzi fudzi,String action){
        System.out.println(action+ getName()+ japaniseName+engaving.getName()+fudzi.saint(" священной "));

    }
}
