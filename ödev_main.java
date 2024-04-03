/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog;



  import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class progödev3 {

   
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Dosya adi giriniz: ");
        String dosyaAdi = scan.nextLine();
        int sS = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(dosyaAdi))) {
            while (reader.readLine() != null)
                sS++;
        }

        int[] dizi = new int[sS];

        try (BufferedReader reader = new BufferedReader(new FileReader(dosyaAdi))) {
            int indeks = 0;
            String dosyaSatir;
            while ((dosyaSatir = reader.readLine()) != null)
                dizi[indeks++] = Integer.parseInt(dosyaSatir);
        }
        
        int n = dizi.length;
        bagliListe[] bagliliste1 = new bagliListe[n];
        bagliListe[] bagliliste2 = new bagliListe[n];

        for (int i = 0; i < n; i++){
            bagliliste1[i] = new bagliListe(dizi[i], i);
            bagliliste2[i] = new bagliListe(dizi[i], i);
        }

        bagliListe[] temp = new bagliListe[n];

        for (int i = 0; i < n; i++) 
            temp[i] = bagliliste1[i];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (temp[j].veri > temp[j + 1].veri) {
                    bagliListe t = temp[j];
                    temp[j] = temp[j + 1];
                    temp[j + 1] = t;
                }
            }
        }

        int adres = temp[0].adres;
        
        for (int i = 0; i < n - 1; i++) 
            temp[i].adres = temp[i + 1].adres;

        temp[n - 1].adres = adres;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (temp[j].veri == bagliliste1[i].veri) 
                    bagliliste1[i].adres = temp[j].adres;
            }
        }
        
     
        for(int i = 0; i < n; i++){
            System.out.println(bagliliste2[i].veri + " ---- " + bagliliste2[i].adres + "        " + bagliliste1[i].veri + " ---- " + bagliliste1[i].adres);
        }
    }
}
