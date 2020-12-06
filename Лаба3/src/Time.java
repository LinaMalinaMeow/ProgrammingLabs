public enum Time {
    ATNOON("В полдень "),
    ATAFTERNOON("под вечер ");

    private final String name;

    Time(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
