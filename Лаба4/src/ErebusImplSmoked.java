

public class ErebusImplSmoked extends Place implements Smoked{
    public ErebusImplSmoked(String name) {
        setName(name);
    }
    protected final String near = " у";
    @Override
    public String smokeing(String condition) {
        return near + condition + getName();
    }

    @Override
    public String getSmoke(String gust, String action) {
        return getName()+action+gust;
    }

    public static class Ander {
        private String Name=" подножья вулкана Эребус";
        private String near=" у";

        public String getName() {
            return near+this.Name;
        }
    }
}
