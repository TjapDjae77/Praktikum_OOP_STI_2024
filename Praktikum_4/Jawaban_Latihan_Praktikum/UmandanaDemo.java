import java.util.Scanner;

public class UmandanaDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String bahasaMuthe = sc.nextLine();

        System.out.println("==============================");

        String umandana = Umandana.toUmandana(bahasaMuthe);
        
        System.out.println(umandana);

        System.out.println("==============================");

        String deUmandana = Umandana.deUmandana(umandana);

        System.out.println(deUmandana);

        System.out.println("==============================");

        String hashElla = Ucrypt.hash(deUmandana).toString();

        System.out.println(hashElla);

        System.out.println("==============================");

        System.out.println("APAKAH HASH SUDAH BERHASIL: " + Ucrypt.compare(deUmandana, hashElla));

        System.out.println("==============================");
        
        AccountManager accountManager = new AccountManager();

        accountManager.addAccount("ellaklepon123", "sengkuni4848");
        accountManager.addAccount("ellaklepon123", "sengkuni1234");
        
        sc.close();
    }
}
