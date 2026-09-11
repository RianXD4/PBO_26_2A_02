import java.util.Scanner;

public class TestLogistik {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int muatan;
        Kontainer kontainerAlfa = new Kontainer("REQ-9988", "PT. Maju Bersama", 5000);
        System.out.println("Nama Pemilik Konteiner: "+kontainerAlfa.getNamaPemilik());
        System.out.println("Kapasitas Maksimal: "+kontainerAlfa.getKapasitasMakasimal()+" kg");
        int pil = 0;
         do {
            System.out.println("1. Naik Muatan");
            System.out.println("2. Turunkan Muatan");
            System.out.println("0. Exit");
            System.out.print("Pilihan: ");
            pil = scan.nextInt();
            switch (pil) {
                case 1:
                    System.out.print("Masukkan Muatan yang ingin ditambah: ");
                    muatan = scan.nextInt();
                    kontainerAlfa.tambahMuatan(muatan);
                    System.out.println("Muatan Saat Ini: "+kontainerAlfa.getMuatanSaatIni());
                    break;
                case 2:
                    System.out.print("Masukkan Muatan yang ingin diturunkan: ");
                    muatan = scan.nextInt();
                    kontainerAlfa.turunkanMuatan(muatan);
                    System.out.println("Muatan Saat Ini: "+kontainerAlfa.getMuatanSaatIni());
                    break;
                case 0:
                    
                    break;
                default:
                    System.out.println("\nPilihan tidak valid coba lagi\n");
                    break;
            }
        }while (pil != 0);
        scan.close();
    }
}
