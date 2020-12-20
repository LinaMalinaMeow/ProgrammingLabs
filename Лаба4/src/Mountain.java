public class Mountain {
    private String Name;
    private  String huge=" огромная";
    private String snowy=" заснеженная ";
    private String endless=" бесконечная ";
    public void setName(String name) {
        this.Name = name;
    }
    public String getName() {
        return this.Name;
    }
    public String getDiscription() {
        return huge+snowy+endless+this.Name;
    }
    public String disappear(String from){
        return " исчезла "+from;
    }
    public String lay(String act){
        return act;
    }
    public static class WhiteLine {
        private String Name=" белая полоса ";
        public void setName(String name) {
            this.Name = name;
        }
        public String getName() {
            return this.Name;
        }
        public void appear(){
            System.out.print(Location.South1.getName()+" появилась "+getName());
        }
    }

}

