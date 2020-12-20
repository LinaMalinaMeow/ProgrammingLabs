public class Temperature {
    private String Name;

    public void setName(String name) {
        this.Name = name;
    }

    public String getName() {
        return this.Name;
    }

    public static class Down {
        private String Name = " спад ";

        public String getDown(Temperature temperature) {
            return this.Name + temperature.getName();
        }

        public String torment(Me me) {
            return "мучал "+ me.myself;
        }
    }
}