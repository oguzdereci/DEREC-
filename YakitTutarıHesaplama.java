
import java.util.Scanner;


public class Test {
    public static void main(String[] args) {
        
        /*
        
        Bir aracın kilometrede ne kadar yaktığı ve kaç kilometre yol yaptığı bilgilerini alın ve
        sürücünün toplam ne kadar ödemesi gerektiğini hesaplayın.
        
        */
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Aracınız Kilometre de kaç kuruş yakıyor? (Örnek : 0,32):");
        
        double kurus = scanner.nextDouble();
        
        System.out.print("Aracınızla Kaç Kilometre Gittiniz ? :");
        
        int km = scanner.nextInt();
        
        System.out.println("Toplam ödemeniz gereken tutar : " + (kurus * km) + " TL dir..");
                
        
   }
}