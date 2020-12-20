

public class TerrorImplExtinct extends Place implements Extinct{
    public TerrorImplExtinct(String name) {
        setName(name);
    }
    public static void ghostly(){
        System.out.print(" призрачно ");
    }

    @Override
    public void extincting(String extinct) {

        System.out.println(extinct+ getName());
    }

    @FunctionalInterface
    interface whiteing {
        String reverse();
    }
}
