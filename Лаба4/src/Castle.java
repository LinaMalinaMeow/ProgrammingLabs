public class Castle implements Fantastic{
        private String Name;
        public void setName(String name) {
            this.Name = name;
        }
        public String getName() {
            return this.Name;
        }

    @Override
    public String fantastic() {
        return "фантастическими "+getName();
    }


    public  static class Wall implements Sharp{
            private String Name;
            public void setName(String name) {
                this.Name = name;
            }
            public String getName() {
                return this.Name;
            }

        @Override
        public String sharp() {
            return " с зубчатыми "+getName();
        }
    }
}
