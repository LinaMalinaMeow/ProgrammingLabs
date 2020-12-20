

public enum Time {
    ATNOON("в полдень "),
    ATAFTERNOON("под вечер "),
    MORNING(" утром"),
    NOON(" к полудню");
    private final String name;

    Time(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
