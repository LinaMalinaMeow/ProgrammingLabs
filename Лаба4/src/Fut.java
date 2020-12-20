
public enum Fut {
    HAIGHT1(" 12700 футов"),
    HAIGTH2(" 10900 футов"),
    HAIGHT3(" 200 футов");


    private final String name;

    Fut(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
