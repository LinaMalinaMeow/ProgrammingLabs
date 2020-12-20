public class PictureOf {
    private String name;
    private String about;
    private String description;

    public PictureOf(String name,String description,String about){
        this.name = name;
        this.about = about;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description == null ? "" : description;

    }

    public String getAbout() {
        return about == null ? "" : about;
    }
}
