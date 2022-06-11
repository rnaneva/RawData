package DefiningClasses.Exc.RawData;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new LinkedList<>();

        while (n-- > 0) {
            String[] details = scanner.nextLine().split("\\s+");
            String model = details[0];

            int engineSpeed = Integer.parseInt(details[1]);
            int enginePower = Integer.parseInt(details[2]);
            Engine engine = new Engine(engineSpeed, enginePower);

            int cargoWeight = Integer.parseInt(details[3]);
            String cargoType = details[4];
            Cargo cargo = new Cargo(cargoWeight, cargoType);

            List<Tire> tires = new ArrayList<>();

            for (int i = 5; i < details.length; i += 2) {
                double tirePressure = Double.parseDouble(details[i]);
                int tireAge = Integer.parseInt(details[i + 1]);
                Tire tire = new Tire(tirePressure, tireAge);
                tires.add(tire);
            }

            Car car = new Car(model, engine, cargo, tires);
            cars.add(car);

        }
        String command = scanner.nextLine();

        switch (command) {
            case "fragile":
                cars.stream().filter(car -> car.getCargo().getCargoType().equals("fragile")).
                        filter(car -> car.getTires().stream().anyMatch(tyre -> tyre.getTirePressure() < 1))
                        .forEach(car -> System.out.println(car.getModel()));

                break;
            case "flamable":
                cars.stream().filter(car -> car.getCargo().getCargoType().equals("flamable")).
                        filter(car -> car.getEngine().getEnginePower() > 250)
                        .forEach(car -> System.out.println(car.getModel()));
                break;
            default:
                throw new IllegalArgumentException("Unknown command " + command);
        }

    }
}
