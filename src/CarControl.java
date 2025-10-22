public class CarControl {
    private Car car;

    public CarControl(Car car){
        this.car = car;
    }

    public void turnOn(){
        if(car.isOn()){
            System.out.print("O carro já está ligado.");
            return;
        }
        car.setOn(true);
        System.out.println("Carro ligado com sucesso.");
    }

    public void turnOff(){
        if(!car.isOn()){
            System.out.println("O carro já está desligado.");
            return;
        }

        if(car.getMarch() != 0 || car.getSpeed() != 0){
            System.out.println("Para desligar o carro, ele deve estar no ponto morto e parado.");
            return;
        }

        car.setOn(false);
        System.out.println("Carro desligado com sucesso.");
    }

    public void speedUp(){
        if(!car.isOn()){
            System.out.println("O carro está desligado. Ligue o carro primeiro para acelerar.");
            return;
        }

        if(car.getMarch() == 0){
            System.out.println("O carro está em ponto morto e não pode acelerar.");
            return;
        }

        int newSpeed = car.getSpeed() + 1;

        if(newSpeed > 120){
            System.out.println("Valocidade máxima atingida (120km/h).");
            return;
        }

        if(!permittedSpeed(newSpeed, car.getMarch())){
            System.out.println("Velocidade fora do limete permitido para a marcha atual.");
            return;
        }

        car.setSpeed(newSpeed);
        System.out.println("Acelerando... Velocidade atual: " + car.getSpeed() + "km/h");
    }

    public void slowDown(){
        if(!car.isOn()){
            System.out.println("O carro está desligado.");
            return;
        }

        int newSpeed = car.getSpeed() - 1;
        if(newSpeed < 0) newSpeed = 0;

        car.setSpeed(newSpeed);
        System.out.println("Desacelerando... Velocidade atual: " + car.getSpeed() + "km/h");
    }

//  Gear também é uma tradução de Marcha
    public void chanceGear(int newMarch){
        if(!car.isOn()){
            System.out.println("O carro está desligado.");
            return;
        }

        if(newMarch < 0 || newMarch > 6){
            System.out.println("Marcha inválida.");
            return;
        }

        if(Math.abs(newMarch - car.getMarch()) > 1){
            System.out.println("Não é permitido pular marchas.");
        }

        if(!permittedSpeed(car.getSpeed(), newMarch)){
            System.out.println("A velocidade atual não é compatível com essa marcha.");
            return;
        }

        car.setMarch(newMarch);
        System.out.println("Marcha alterada para: " + newMarch + ".");
    }

    
}
