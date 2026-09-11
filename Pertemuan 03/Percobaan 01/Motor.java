public class Motor {
    private int kecepatan = 0;
    private  boolean kontakOn = false;
    
    public void nyalaknMesin(){
        kontakOn = true;
    }

    public void matikanMesin(){
        kontakOn = false;
        kecepatan = 0;
    }

    public void tambahKecepatan(){
        if (kontakOn) {
            if (kecepatan < 100) {
            kecepatan += 5;   
            } else {
                System.out.println("Kecepatan Maksimal 100");
            }
        } else {
            System.out.println("Kecepatan tidak bisa bertambah karena mesin OFF! \n");
        }
    }

    public void kurangiKecepatan(){
        if (kontakOn) {
            kecepatan -= 5;
        } else {
            System.out.println("Kecepatan tidak bisa berkurang karena mesin OFF! \n");
        }
    }
    
    public void printStatus(){
        if (kontakOn) {
            System.out.println("Konta On");
        } else {
            System.out.println("Kontak Off");
        }
        System.out.println("Kecepatan "+kecepatan);
    }
}
