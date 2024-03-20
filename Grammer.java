package prog;
import java.util.Scanner;

public class PROG {

    public static void main(String[] args) {
   
        String[] ozneListesi = {"Ben", "Sen", "Hasan", "Nurşah", "Elif", "Abdulrezzak", "Şehribanu", "Zeynelabidin", "Naki"};
        String[] nesneListesi = {"Bahçe", "Okul", "Park", "Sınıf", "Yarın", "Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma",
                "Cumartesi", "Pazar", "Merkez", "Ev", "Kitap", "Defter", "Güneş", "Beydağı"};
        String[] yuklemListesi = {"Gitmek", "Gelmek", "Okumak", "Yazmak", "Yürümek", "Görmek"};

      
        Scanner scanner = new Scanner(System.in);
        System.out.print("Cumleyi girin: ");
        String cumle = scanner.nextLine();
        scanner.close();

        
        cumle = cumle.replaceAll("\\s+", " ");

      
        String[] kelimeler = cumle.split(" ");

        boolean ozneVar = false;
        boolean nesneVar = false;
        boolean yuklemVar = false;

        for (String kelime : kelimeler) {
            for (String ozne : ozneListesi) {
                if (kelime.equals(ozne)) {
                    ozneVar = true;
                    break;
                }
            }

            for (String nesne : nesneListesi) {
                if (kelime.equals(nesne)) {
                    nesneVar = true;
                    break;
                }
            }

            for (String yuklem : yuklemListesi) {
                if (kelime.equals(yuklem)) {
                    yuklemVar = true;
                    break;
                }
            }
        }

        if (ozneVar && nesneVar && yuklemVar && kelimeler.length == 3) {
            System.out.println("evet");
        } else {
            System.out.println("hayır");
        }
    }
}
