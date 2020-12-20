public class AtmosphericPhenomena {
    private String Name;
    public void setName(String name) {
        this.Name = name;
    }
    public String getName() {
        return this.Name;
    }
    public void wow(Me me){
        System.out.println(getName()+" удивляли "+ me.myself);
    }
    public static class Miraje{
        private String clear="четкий";
        private String Name=" мираж ";
        public void wow2(Me me){
            System.out.println("особенно"+me.myself+" поражал "+clear+Name+": ");
        }
    }
}
