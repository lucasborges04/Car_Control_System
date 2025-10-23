import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Car car = new Car();
        CarControl control = new CarControl(car);

        int option;
        do{
            System.out.println("\n=== MENU CARRO ===");
            System.out.println("1 - Ligar o carro");
            System.out.println("2 - Desligar carro");
            System.out.println("3 - Acelerar");
            System.out.println("4 - Diminuir velocidade");
            System.out.println("5 - Trocar marcha");
            System.out.println("6 - Virar");
            System.out.println("7 - Verificar velocidade");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção:");
            option = scanner.nextInt();

            switch (option){
                case 1 -> control.turnOn();
                case 2 -> control.turnOff();
                case 3 -> control.speedUp();
                case 4 -> control.slowDown();
                case 5 -> {
                    System.out.print("Digite a nova marcha: ");
                    int march = scanner.nextInt();
                    control.chanceGear(march);
                }
                case 6 -> {
                    System.out.print("Informe a direção (esquerda/direita): ");
                    String direction = scanner.next();
                    control.toTurn(direction);
                }
                case 7 -> control.checkSpeed();
                case 0 -> System.out.println("Encerrando o programa...");
                default -> System.out.println("Opção inválida.");
            }
        } while (option != 0);

        scanner.close();
    }
}
