public class laptop {
    private String merk;
    private Processor proc;

    public laptop(){

    }
    public laptop(String merk, Processor proc){// menunjukkan relasi
        this.merk = merk;
        this.proc = proc;
    }

    public void setMerk(String merk){
        this.merk = merk;
    }
    public String getMerk(){
        return merk;
    }
    public void setProc(Processor proc){
        this.proc = proc;
    }
    public Processor getProc(){
        return proc;
    }
    public void info(){
        System.out.println("Merk Laptop = "+merk);
        proc.info();
    }
}
