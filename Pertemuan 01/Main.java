public class Main {
    public static void main(String[] args) {
        Earphone earphone1 = new Earphone();
        TWS tws1 = new TWS();

        earphone1.input(5, true);
        earphone1.tampil_Info();
        earphone1.turn_On();
        earphone1.turn_off();
        earphone1.tampil_Info();

        System.out.println("\n\n");

        tws1.input(0, false);
        tws1.tampil_Info();
        tws1.turn_On();
        tws1.turn_On_Bluetooth();
        tws1.tampil_Info();

        System.out.println("\n\n\n");

        Kipas_Angin kipas1 = new Kipas_Angin();
        Kipas_Gantung kipas2 = new Kipas_Gantung();

        kipas1.input(3);
        kipas1.tampil_Info();
        kipas1.auto_turn_on();
        kipas1.tampil_Info();

        System.out.println("\n\n");

        kipas2.input(2);
        kipas2.tampil_Info();
        kipas2.winter_Mode();
        kipas2.tampil_Info();
    }
}