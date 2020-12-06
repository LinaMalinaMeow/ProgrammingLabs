

public class ErebusImplSmoked extends Place implements Smoked{
    public ErebusImplSmoked(String name) {
        setName(name);
    }
    private String near = " у";
    @Override
    public String smoking(String condition) {
        return near+condition + getName();

    }
}
