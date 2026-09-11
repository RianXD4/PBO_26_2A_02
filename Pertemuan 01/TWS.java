public class TWS extends Earphone {
    boolean bluetooth;

    public void turn_On_Bluetooth(){
        bluetooth = true;
        System.out.println("Bluetooth berhasil dinyalakan");
    }

    public void turn_Off_Bluetooth(){
        bluetooth = false;
        System.out.println("Bluetooth berhasil dimatikan");
    }

    @Override
    public void tampil_Info(){
        super.tampil_Info();
        System.out.println("Bluetooth\t:"+bluetooth);
    }

    public void turn_On(){
        plugged = true;
        System.out.println("Earphone berhasil tersambung");
    }
}
