public abstract class Place {
    private String Name;
    public void setName(String name) {
        this.Name = name;
    }
    public String getName() {
        return this.Name;
    }

    public String setLocation(Human human,String action){
        return human.getName()+ action+Name ;
    }
}
