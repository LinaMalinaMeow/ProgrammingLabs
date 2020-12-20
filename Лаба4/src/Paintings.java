public class Paintings implements Craft{
    private String name;
    private String action;
    private String description;
    private String description2;
    public Paintings(String name,String action,String description,String description2){
        this.name = name;
        this.action = action;
        this.description = description;
        this.description2 = description2;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description == null ? "" : description;
    }
    public String getDescription2() {
        return description2 == null ? "" : description2;
    }
    public String getAction() {
        return action == null ? "" : action;
    }
}
