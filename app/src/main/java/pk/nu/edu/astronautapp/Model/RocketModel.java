package pk.nu.edu.astronautapp.Model;

public class RocketModel {

   private String direction , rocketNo ;
   private  String lunchtime ;
   private int speed;
    private float fuel , oygenlevel;

    public RocketModel() {
    }

    public RocketModel(String direction, String rocketNo, String lunchtime, int speed, float fuel, float oygenlevel) {
        this.direction = direction;
        this.rocketNo = rocketNo;
        this.lunchtime = lunchtime;
        this.speed = speed;
        this.fuel = fuel;
        this.oygenlevel = oygenlevel;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getRocketNo() {
        return rocketNo;
    }

    public void setRocketNo(String rocketNo) {
        this.rocketNo = rocketNo;
    }

    public String getLunchtime() {
        return lunchtime;
    }

    public void setLunchtime(String lunchtime) {
        this.lunchtime = lunchtime;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public float getFuel() {
        return fuel;
    }

    public void setFuel(float fuel) {
        this.fuel = fuel;
    }

    public float getOygenlevel() {
        return oygenlevel;
    }

    public void setOygenlevel(float oygenlevel) {
        this.oygenlevel = oygenlevel;
    }
}
