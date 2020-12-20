
public class ThePeninsulaOfRossImplInfo extends Place implements Info{
    public ThePeninsulaOfRossImplInfo(String name) {
        setName(name);
    }
    @Override
    public String info(String info){
        return info+getName();

    }
}
