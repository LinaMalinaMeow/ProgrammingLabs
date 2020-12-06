import java.util.Scanner;
public class Move {
    public int a1;
    public boolean may;
    void movement1(){
        System.out.println("Выберите действие: что сказал Квебекка?");
    }
    void choice1(){
        System.out.println("идти нельзя(1) или идти можно(2) ");

    }
    void vvod(){
        Scanner scanner = new Scanner(System.in);
        a1 = scanner.nextInt();
       if ( a1 == 1) {
            may = false;
        }else {
            may=true;
        }
    }
}
