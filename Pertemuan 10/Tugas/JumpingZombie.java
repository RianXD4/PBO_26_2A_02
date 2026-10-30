public class JumpingZombie extends Zombie{
     public JumpingZombie(int hlt, int lvl){
        health = hlt;
        level = lvl;
    }
    @Override 
    public void heal(){
        double heal = 0;
        switch (level) {
            case 1:
                heal = (health*1.3);
                break;
            case 2:
                heal = (health*1.4);
                break;
            case 3:
                heal = (health*1.5);
                break;
            default:
                System.out.println("Invalid Level");
                break;
        }
        health+=heal;
        if (health > 100) {
            health = 100;
        }
    }

    @Override 
    public void destroyed(){
        health-=(health * 0.1);
    }
    
     public String getZombieInfo(){
        return "Jumping Zombie Info \n"+super.getZombieinfo();
    }
}
