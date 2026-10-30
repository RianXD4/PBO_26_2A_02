public class WalkingZombie extends Zombie{
    public WalkingZombie(int hlt, int lvl){
        health = hlt;
        level = lvl;
    }
    @Override 
    public void heal(){
        double heal = 0;
        switch (level) {
            case 1:
                heal = (health*1.1);
                break;
            case 2:
                heal = (health*1.3);
                break;
            case 3:
                heal = (health*1.4);
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
        health-=(health*0.2);
    }

    public String getZombieInfo(){
        return "Walking Zombie Info \n"+super.getZombieinfo();
    }
}
