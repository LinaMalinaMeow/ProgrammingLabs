public class Fudzi extends Place implements Saint {
    public Fudzi(String name) {
        setName(name);
    }

    public String saint(String saint) {
        return saint+getName();

    }
}
