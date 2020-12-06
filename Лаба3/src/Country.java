

public enum Country {
    JAPANISE(" японские "),
    CHINISE(" китайские ");
    private final String name;

    Country(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
