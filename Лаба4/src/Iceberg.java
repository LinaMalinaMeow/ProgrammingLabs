public class Iceberg implements Flat {
    private String Name;

    public void setName(String name) {
        this.Name = name;
    }

    public String getName() {
        return this.Name;
    }

    public String seem() {
        return getName() + " показались ";
    }

    @Override
    public void flat() {
        System.out.println(" плоские " + getName());
    }

    public static class Wall implements Vertical {
        private String Name;

        public void setName(String name) {
            this.Name = name;
        }

        public String getName() {
            return this.Name;
        }

        @Override
        public void vertical() {
            System.out.println(" с вертикальными " + getName());
        }
    }
}
