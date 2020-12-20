
import java.util.Scanner;

public class Move {
    public int a1;
    public int a2;

    void movement1() {
        System.out.println("Выбирите действие: что сказал Квебек?");
    }

    void choice1() {
        System.out.println("идти нельзя(1) или идти можно(2) ");

    }

    void movement2() {
        System.out.println("Хотите закончить историю?");
    }

    void choice2() {
        System.out.println("да(1) или нет(2) ");

    }

    public void a2Void() {
        Scanner scanner = new Scanner(System.in);
        a2 = scanner.nextInt();
    }

    public void aVoid() {
        Scanner scanner = new Scanner(System.in);
        a1 = scanner.nextInt();
    }

    public void vvod(KvebekkaImplSay kvebekkaImplSay, int n) throws GoException {
        if (a1 == 2) {
            n = 2;
            throw new GoException(kvebekkaImplSay.getName() + " сказал не это ");
        }
        if (a1!=1){
            throw new GoException("Пользователь дурак!");
        }
        }
    }
