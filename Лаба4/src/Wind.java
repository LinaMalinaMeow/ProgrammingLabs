public class Wind implements Craft{
    private String name;
    private String action;
    private String action2;
    private String description;
    private String how;
    public final String notLong=" ненадолго";

    public class Sound{
        private String name;
        private String action;
        private String action2;
        private String action3;
        public Sound(String name,String action,String action2,String action3){
            this.name = name;
            this.action = action;
            this.action2 = action2;
            this.action3 = action3;
        }
        public String getAction() {
            return action == null ? "" : action;
        }
        public String getAction2() {
            return action2 == null ? "" : action2;
        }
        public String getAction3() {
            return action3 == null ? "" : action3;
        }
        public String getName() {
            return name;
        }
    }
    public Wind(String name, String description, String action,String action2,String how) {
        this.name = name;
        this.action = action;
        this.description = description;
        this.how = how;
        this.action2 = action2;

    }
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description == null ? "" : description;

    }

    public String getAction() {
        return action == null ? "" : action;
    }
    public String getAction2() {
        return action2 == null ? "" : action2;
    }

    public String getHow() {
        return how == null ? "" : how;
    }

    public static class Gust{
        private String Name="порывы";
        public String getName() {
            return this.Name;
        }
    }
}
