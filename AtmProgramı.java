
import java.util.Scanner;


public class AtmProgramı {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        
        int giris_hakki = 3;
        String sys_kullanici_adi = "Oguz";
        String sys_parola = "12345";
        
        System.out.println("********************************");
        System.out.println("**                            **");
        System.out.println("**    - ZİRAAT BANKASI -      **");
        System.out.println("**                            **");
        System.out.println("********************************");
        
        while (true) {
            System.out.print("Kullanıcı Adı : ");
            String kullanici = scanner.nextLine();
            System.out.print("Parola : ");
            String parola = scanner.nextLine();
            
            if(kullanici.equals(sys_kullanici_adi ) && parola.equals(sys_parola)) {
                System.out.println("Bankamıza Hoşgeldiniz " + kullanici + " Bey");
                System.out.println("Yapmak İstediğiniz İşlem Nedir ? ");
              int bakiye = 1000;
        String islemler ="1. İşlem : Bakiye Öğrenme\n"
                         +"2. İşlem : Para Çekme\n"
                         +"3. İşlem : Para Yatırma\n"
                         +"4. İşlem : Çıkış İçin q'a Basınız";
        
        System.out.println("********************************");
        System.out.println(islemler);
        System.out.println("********************************");
        
        while(true) {
            System.out.print("İşlemi Şeçiniz :");
            String islem = scanner.nextLine();
            
            if (islem.equals("q")) {
             
                System.out.println("Programdan Çıkılıyor..");
                break;
            }
            else if (islem.equals("1")) {
                System.out.println("Bakiyeniz : " + bakiye );
            }
            else if (islem.equals("2")) {
                System.out.print("Çekmek İstediğiniz Tutar :");
                int tutar = scanner.nextInt();
                scanner.nextLine();
                
               if (bakiye - tutar < 0) {
                   
                   System.out.println("Yeterli Bakiye Yok . Bakiyeniz : " + bakiye);
               }
               else {
                   bakiye -= tutar;
                   System.out.println("Yeni Bakiyeniz : " + bakiye);
                   
               }
            }
            
            else if (islem.equals("3")) {
                System.out.print("Yatırmak İstediğiniz Tutar : ");
            int tutar = scanner.nextInt();
            scanner.nextLine();
            
            bakiye += tutar;
            
                System.out.println("Yeni Bakiyeniz : " + bakiye);
               
            }
            else {
                System.out.println("Geçersiz İşlem..");
            }
        }
    
                break;
            }
            else if(kullanici.equals(sys_kullanici_adi ) && !parola.equals(sys_parola)) {
                System.out.println("Parolanız Yanlış !! ");
                giris_hakki -= 1;
            }
            else if(!kullanici.equals(sys_kullanici_adi ) && parola.equals(sys_parola)) {
                System.out.println("Kulanıcı Adınız Yanlış !! ");
                giris_hakki -= 1;
            }
            else {
                System.out.println("Kullanıcı Adınız Ve Parolanız Yanlış !!");
            
            giris_hakki -= 1;
        }
        if (giris_hakki == 0) {
            System.out.println("Giriş Hakkınız Bitti !!");
            break;
        
        
        }
        }
    }
}
