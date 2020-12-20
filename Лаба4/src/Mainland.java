public class Mainland {
    private String Name;
    public void setName(String name) {
        this.Name = name;
    }
    public String getName() {
        return this.Name;
    }
    public String great=" великого ";
    public String unknown=" неведомого ";

        public static class End {
            private String onEnd;

            public String getOnEnd() {
                return onEnd= " на краю ";
            }
        }
    public void on(End end,Mountain mountain){
        System.out.print(mountain.getName()+" высилась"+ end.getOnEnd() +great+"и"+unknown+getName());
    }
}
