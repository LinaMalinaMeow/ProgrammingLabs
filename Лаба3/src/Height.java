public class Height {
    private String Name;
    public void setName(String name) {
        this.Name = name;
    }
    public String getName() {
        return this.Name;
    }

    String haight2Name = Fut.HAIGTH2.getName();
    String haight1Name = Fut.HAIGHT1.getName();

    public void provide(){
        System.out.print(getName()+"ой"+ haight1Name);
    }

    public String equal(TerrorImplExtinct terrorImplExtinct){
        return getName()+"a"+terrorImplExtinct.getName()+ "="+haight2Name;


    }
}

