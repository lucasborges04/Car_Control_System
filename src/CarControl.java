public record CarControl(Car car) {

    public void turnOn() {
        if (car.isOn()) {
            System.out.print("O carro já está ligado.");
            return;
        }
        car.setOn(true);
        System.out.println("Carro ligado com sucesso.");
    }

    public void turnOff() {
        if (!car.isOn()) {
            System.out.println("O carro já está desligado.");
            return;
        }

        if (car.getMarch() != 0 || car.getSpeed() != 0) {
            System.out.println("Para desligar o carro, ele deve estar no ponto morto e parado.");
            return;
        }

        car.setOn(false);
        System.out.println("Carro desligado com sucesso.");
    }

    public void speedUp() {
        if (!car.isOn()) {
            System.out.println("O carro está desligado. Ligue o carro primeiro para acelerar.");
            return;
        }

        if (car.getMarch() == 0) {
            System.out.println("O carro está em ponto morto e não pode acelerar.");
            return;
        }

        int newSpeed = car.getSpeed() + 1;

        if (newSpeed > 120) {
            System.out.println("Valocidade máxima atingida (120km/h).");
            return;
        }

        if (!permittedSpeed(newSpeed, car.getMarch())) {
            System.out.println("Velocidade fora do limete permitido para a marcha atual.");
            return;
        }

        car.setSpeed(newSpeed);
        System.out.println("Acelerando... Velocidade atual: " + car.getSpeed() + "km/h");
    }

    public void slowDown() {
        if (!car.isOn()) {
            System.out.println("O carro está desligado.");
            return;
        }

        int newSpeed = car.getSpeed() - 1;
        if (newSpeed < 0) newSpeed = 0;

        car.setSpeed(newSpeed);
        System.out.println("Desacelerando... Velocidade atual: " + car.getSpeed() + "km/h");
    }

    //  Gear também é uma tradução de Marcha
    public void chanceGear(int newMarch) {
        if (!car.isOn()) {
            System.out.println("O carro está desligado.");
            return;
        }

        int currentGear = car.getMarch();

        if (Math.abs(newMarch - currentGear) > 1) {
            System.out.println("Não é permitido pular marchas.");
            return;
        }

        if (newMarch < 0 || newMarch > 6) {
            System.out.println("Marcha inválida.");
            return;
        }

        if (!permittedSpeed(car.getSpeed(), newMarch)) {
            System.out.println("A velocidade atual não é compatível com essa marcha.");
            return;
        }

        car.setMarch(newMarch);
        System.out.println("Marcha alterada para: " + newMarch + ".");
    }

    public void toTurn(String direction) {
        if (!car.isOn()) {
            System.out.println("O carro está desligado.");
            return;
        }

        int speed = car.getSpeed();
        if (speed < 1 || speed > 40) {
            System.out.println("A velocidade deve estar entre 1km/h e 40km/h para virar.");
            return;
        }

        System.out.println("Virando para " + direction + "...");
    }

    public void checkSpeed() {
        System.out.println("Velocidade atual: " + car.getSpeed() + "km/h.");
        System.out.println("Marcha atual " + car.getMarch());
        System.out.println("Status: " + (car.isOn() ? "Ligado" : "Desligado"));
    }

    private boolean permittedSpeed(int speed, int march) {
        if (march == 0) {
            return speed == 0; // Ponto morto só pode ter velocidade 0
        } else if (march == 1) {
            return speed >= 0 && speed <= 20;
        } else if (march == 2) {
            return speed >= 20 && speed <= 40;
        } else if (march == 3) {
            return speed >= 40 && speed <= 60;
        } else if (march == 4) {
            return speed >= 60 && speed <= 80;
        } else if (march == 5) {
            return speed >= 80 && speed <= 100;
        } else if (march == 6) {
            return speed >= 100 && speed <= 120;
        } else {
            return false;
        }
    }
}
