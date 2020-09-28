
public class Main {
    public static void main(String[] args) throws InterruptedException {
        
        System.out.println("Sabiha Gökçen Havalimanına Hoşgeldiniz..");
        
        String sartlar = "Yurt Dışı Çıkış Kuralları \n"
                       + "Herhangi Bir Siyasi Yasağınız Bulunmaması Gerekiyor\n"
                       + "15 TL Harç Bedelinizi Tam Olarak Yatırmanız Gerekiyor\n"
                       + "Gideceğiniz Ülkeye Vizenizin Bulunması Gerekiyor";
        String message = "Yurt Dışı Şartlarından Hepsini Sağlamanız Gerekiyor";
        
        while(true) {
            System.out.println("******************************");
            System.out.println(sartlar);
            System.out.println("******************************");
      
            Yolcu yolcu = new Yolcu();
            
            System.out.println("Harç Bedeli Kontrol Ediliyor..");
              Thread.sleep(3000);
              
            if (yolcu.yurtdisiHariciKontrol() == false) {
                
                System.out.println(message);
                continue;
                
            }
            System.out.println("Siyasi Yasak Kontrol Edilyor..");
            Thread.sleep(3000);
            
            if (yolcu.siyasiYasakKontrol() == false) {
                
                System.out.println(message);
                continue;
                
            }
            System.out.println("Vize Durumu Kontrol Ediliyor..");
            Thread.sleep(3000);
            
            if (yolcu.vizeDurumuKontrol() == false) {
                
                System.out.println(message);
                continue;
                
            }
            System.out.println("İşlemleriniz Tamam ! Yurt Dışına Çıkabilirsiniz..");
            break;
            
            
        }
    }
}
