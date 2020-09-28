
import java.util.Scanner;


public class Yolcu implements YurtDisiKurallari {
    
    private int harc;
    private boolean siyasiYasak;
    private boolean vizeDurumu;

    public Yolcu() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Yatırdığınız Harç Bedeli : ");
        this.harc = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Herhangi Bir Siyasi Yasağınız Bulunuyor Mu?(evet yada hayır) : ");
        
        String cevap = scanner.nextLine();
        
        if (cevap.equals("evet")) {
           
            this.siyasiYasak = true;
            
        }
        else {
            this.siyasiYasak = false;
            
        }
        System.out.print("Vizeniz Bulunuyor mu?(evet yada hayır) : ");
        
        String cevap2 = scanner.nextLine();
        
        if (cevap2.equals("evet")) {
            
            this.vizeDurumu = true;
            
        }
        else {
            this.vizeDurumu = false;
            
        }
    }
    
    @Override
    public boolean yurtdisiHariciKontrol() {
       
        if (this.harc < 15) {
            
       System.out.println("Lütfen Yurtdışı Çıkış Harcını Tam Yatırınız!");
       return false;
       
        }
        else {
            System.out.println("Yurt Dışı Harcı İşlemi Tamam");
            return true;
            
        }
        
    }

    @Override
    public boolean siyasiYasakKontrol() {
        
        if (this.siyasiYasak == true) {
            
            System.out.println("Siyasi Yasağınız Bulunuyor.. Yurt Dışına Çıkamazsınız");
            return false;
            
        }
        else {
            System.out.println("Siyasi Yasağınız Bulunmuyor");
            return true;
            
        }
    }
    
    @Override
    public boolean vizeDurumuKontrol() {
        
        if (this.vizeDurumu == true) {
            
            System.out.println("Vize İşlemleri Tamam");
            return true;
            
        }
        else {
            
            System.out.println("Vizeniz Gidiceğiniz Ülkeye Bulunmamaktadır");
            return false;
            
        }

    }           
}

