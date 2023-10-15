
import java.util.Scanner;

public class Main {

    private static Kart[][] kartlar = new Kart[4][4];

    public static void main(String[] args) {
        kartlar[0][0] = new Kart('A');
        kartlar[0][1] = new Kart('B');
        kartlar[0][2] = new Kart('C');
        kartlar[0][3] = new Kart('D');
        kartlar[1][0] = new Kart('E');
        kartlar[1][1] = new Kart('F');
        kartlar[1][2] = new Kart('G');
        kartlar[1][3] = new Kart('H');
        kartlar[2][0] = new Kart('A');
        kartlar[2][1] = new Kart('B');
        kartlar[2][2] = new Kart('C');
        kartlar[2][3] = new Kart('D');
        kartlar[3][0] = new Kart('E');
        kartlar[3][1] = new Kart('F');
        kartlar[3][2] = new Kart('G');
        kartlar[3][3] = new Kart('H');

        while (oyun_bitti_mi() == false) {

            oyun_tahtasi();
            tahmin_et();

        }

    }

    public static void oyun_tahtasi() {
        System.out.println("-------------------------------------------------------------------------------------");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

                if (kartlar[i][j].isTahmin()) {
                    System.out.print(" |" + kartlar[i][j].getDeger() + "| ");
                } else {
                    System.out.print(" | | ");

                }
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------------------------------------------------");
    }

    public static boolean oyun_bitti_mi() {

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (kartlar[i][j].isTahmin() == false) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void tahmin_et() {
        Scanner input = new Scanner(System.in);

        System.out.println("birinci karti seciniz: ");
        int a1 = input.nextInt();
        int b1 = input.nextInt();

        kartlar[a1][b1].setTahmin(true);
        oyun_tahtasi();

        System.out.println("ikinci karti seciniz: ");
        int a2 = input.nextInt();
        int b2 = input.nextInt();

        if (kartlar[a1][b1].getDeger() == kartlar[a2][b2].getDeger()) {
            System.out.println("dogru tahmin");
            kartlar[a2][b2].setTahmin(true);
        } else {
            System.out.println("yanlis tahmin");
            kartlar[a1][b1].setTahmin(false);
        }
    }

}
