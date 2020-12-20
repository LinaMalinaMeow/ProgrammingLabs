
public class Ship {
    private String Name;
    public void setName(String name) {
        this.Name = name;
    }
    public String getName() {
        return this.Name;
    }

    public void canGo(String can){
        System.out.println("что "+getName()+ can);
    }

    public static class Anchor {
        private String Name;
        public void setName(String name) {
            this.Name = name;
        }
        public String getName() {
            return this.Name;
        }

    }
}


