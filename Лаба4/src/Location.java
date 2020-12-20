public enum Location {
    South(" южной широты "),
    North(" северной широты "),
    East(" западной долготы "),
    West(" восточной долготы "),
    South1(" на юге"),
    North1(" на севере "),
    East1(" на западес"),
    West1(" на востоке ");
    private final String name;

    Location(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getLocation(String where,int value){return where+value+name;}
}
