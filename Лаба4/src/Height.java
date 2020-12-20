
public class Height {
    private String Name;
    public void setName(String name) {
        this.Name = name;
    }
    public String getName() {
        return this.Name;
    }

    String height2Name = Fut.HAIGTH2.getName();
    String height1Name = Fut.height1.getName();

    public void provade(){
        System.out.print(getName()+"ой"+ height1Name);
    }

    public String equal(TerrorImplExtinct terrorImplExtinct){
        return getName()+"a"+terrorImplExtinct.getName()+ "="+height2Name;


    }
}

