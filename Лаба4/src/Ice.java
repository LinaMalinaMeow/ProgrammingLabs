public class Ice {
    private String Name;
    public void setName(String name) {
        this.Name = name;
    }
    public String getName() {
        return this.Name;
    }
    public String fault(Fault fault){
        return getName()+"c"+fault.open+fault.getName();
    }
    public static class Fault{
        private String Name;
        private String open=" открытыми ";
        public void setName(String name) {
            this.Name = name;
        }
        public String getName() {
            return this.Name;
        }
    }
}
