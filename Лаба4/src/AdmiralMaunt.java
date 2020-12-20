public class AdmiralMaunt extends Place implements Info,DiscoveredByRoss{
    public AdmiralMaunt(String name) {
        setName(name);
    }

    @Override
    public String byRoss() {
        return "открытые Россом "+getName();
    }

    @Override
    public String info(String info) {
        return info;
    }
}
