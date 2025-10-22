public class Car {
    private boolean on;
    private int march;
    private int speed;

    public Car(){
        this.on = false;
        this.march = 0;
        this.speed = 0;
    }

    public boolean isOn(){
        return on;
    }

    public void setOn(boolean on){
        this.on = on;
    }

    public int getMarch(){
        return march;
    }

    public void setMarch(int march){
        this.march = march;
    }

    public int getSpeed(){
        return speed;
    }

    public void setSpeed(int speed){
        this.speed = speed;
    }


}
