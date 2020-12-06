public class Volcano {
    private String name;
    public Volcano(String name){
        this.name=name;
    }
    public void toGrowWhite(boolean extinct){
        if(extinct){
            System.out.print("сразу же за ним призрачно белел потухший "+name+" Террор,");
        }
        else {
            System.out.print("сразу же за ним призрачно белел не потухший "+name+" Террор,");
        }
    }
}
