# RawData
Define a class Car that holds information about the model, engine, cargo, and a collection of exactly 4 tires. The engine, cargo, and tire should be separate classes, create a constructor that receives all information about the Car and creates and initializes its inner components (engine, cargo, and tires).
After the N lines, you will receive a single line with one of 2 commands "fragile" or "flamable", if the command is "fragile" print all cars whose Cargo Type is "fragile" with a tire whose pressure is  < 1 if the command is "flamable" print all cars whose Cargo Type is "flamable" and have Engine Power > 250.
package ObjectsAndClasses;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P02RawData2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Car> autos = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split(" ");
            String model = data[0];
            int engineSpeed = Integer.parseInt(data[1]);
            int enginePower = Integer.parseInt(data[2]);
            int cargoWeight = Integer.parseInt(data[3]);
            String cargoType = data[4];
            double tyreOnePressure = Double.parseDouble(data[5]);
            int tyreOneAge = Integer.parseInt(data[6]);
            double tyreTwoPressure = Double.parseDouble(data[7]);
            int tyreTwoAge = Integer.parseInt(data[8]);
            double tyreThreePressure = Double.parseDouble(data[9]);
            int tyreThreeAge = Integer.parseInt(data[10]);
            double tyreFourPressure = Double.parseDouble(data[11]);
            int tyreFourAge = Integer.parseInt(data[12]);

            Car car = new Car(model, engineSpeed, enginePower, cargoWeight, cargoType, tyreOnePressure, tyreOneAge, tyreTwoPressure, tyreTwoAge, tyreThreePressure,
                    tyreThreeAge, tyreFourPressure, tyreFourAge );


            autos.put(model, car);


        }
        String command = scanner.nextLine();
        switch (command) {
            case "fragile":
                autos.entrySet().stream().filter(k -> k.getValue().cargoType.equals(command))
                        .filter(v-> v.getValue().tyreOnePressure <1 || v.getValue().tyreTwoPressure <1
                                || v.getValue().tyreThreePressure <1 || v.getValue().tyreFourPressure <1 )
                        .forEach( e-> System.out.println(e.getKey()));
                break;
            case "flamable":
                autos.entrySet().stream().filter((k -> k.getValue().cargoType.equals(command)))
                        .filter(v-> v.getValue().enginePower >250)
                        .forEach(e -> System.out.println(e.getKey()));
                break;
            default:
                throw new IllegalStateException("unnown command " + command);
        }
    }

    public static class Car {
        String model;
        int engineSpeed;
        int enginePower;
        int cargoWeight;
        String cargoType;
        double tyreOnePressure;
        int tyreOneAge;
        double tyreTwoPressure;
        int tyreTwoAge;
        double tyreThreePressure;
        int tyreThreeAge;
        double tyreFourPressure;
        int tyreFourAge;

        public Car(String model, int engineSpeed, int enginePower, int cargoWeight, String cargoType, double tyreOnePressure, int tyreOneAge, double tyreTwoPressure, int tyreTwoAge, double tyreThreePressure, int tyreThreeAge, double tyreFourPressure, int tyreFourAge) {
            this.model = model;
            this.engineSpeed = engineSpeed;
            this.enginePower = enginePower;
            this.cargoWeight = cargoWeight;
            this.cargoType = cargoType;
            this.tyreOnePressure = tyreOnePressure;
            this.tyreOneAge = tyreOneAge;
            this.tyreTwoPressure = tyreTwoPressure;
            this.tyreTwoAge = tyreTwoAge;
            this.tyreThreePressure = tyreThreePressure;
            this.tyreThreeAge = tyreThreeAge;
            this.tyreFourPressure = tyreFourPressure;
            this.tyreFourAge = tyreFourAge;
        }


        public static class Engine extends Car {
            int engineSpeed;
            int enginePower;

            public Engine(String model, int engineSpeed, int enginePower, int cargoWeight, String cargoType, double tyreOnePressure, int tyreOneAge, double tyreTwoPressure, int tyreTwoAge, double tyreThreePressure, int tyreThreeAge, double tyreFourPressure, int tyreFourAge, int engineSpeed1, int enginePower1) {
                super(model, engineSpeed, enginePower, cargoWeight, cargoType, tyreOnePressure, tyreOneAge, tyreTwoPressure, tyreTwoAge, tyreThreePressure, tyreThreeAge, tyreFourPressure, tyreFourAge);
                this.engineSpeed = engineSpeed1;
                this.enginePower = enginePower1;
            }

            public int getEngineSpeed() {
                return engineSpeed;
            }

            public void setEngineSpeed(int engineSpeed) {
                this.engineSpeed = engineSpeed;
            }

            public int getEnginePower() {
                return enginePower;
            }

            public void setEnginePower(int enginePower) {
                this.enginePower = enginePower;
            }
        }
        public static class Cargo extends Car {
            int cargoWeight;
            String cargoType;

            public Cargo(String model, int engineSpeed, int enginePower, int cargoWeight, String cargoType, double tyreOnePressure, int tyreOneAge, double tyreTwoPressure, int tyreTwoAge, double tyreThreePressure, int tyreThreeAge, double tyreFourPressure, int tyreFourAge, int cargoWeight1, String cargoType1) {
                super(model, engineSpeed, enginePower, cargoWeight, cargoType, tyreOnePressure, tyreOneAge, tyreTwoPressure, tyreTwoAge, tyreThreePressure, tyreThreeAge, tyreFourPressure, tyreFourAge);
                this.cargoWeight = cargoWeight1;
                this.cargoType = cargoType1;
            }

            public int getCargoWeight() {
                return cargoWeight;
            }

            public void setCargoWeight(int cargoWeight) {
                this.cargoWeight = cargoWeight;
            }

            public String getCargoType() {
                return cargoType;
            }

            public void setCargoType(String cargoType) {
                this.cargoType = cargoType;
            }
        }

        public static class Tyre extends Car {
            double tyreOnePressure;
            int tyreOneAge;
            double tyreTwoPressure;
            int tyreTwoAge;
            double tyreThreePressure;
            int tyreThreeAge;
            double tyreFourPressure;
            int tyreFourAge;

            public Tyre(String model, int engineSpeed, int enginePower, int cargoWeight, String cargoType, double tyreOnePressure, int tyreOneAge, double tyreTwoPressure, int tyreTwoAge, double tyreThreePressure, int tyreThreeAge, double tyreFourPressure, int tyreFourAge, double tyreOnePressure1, int tyreOneAge1, double tyreTwoPressure1, int tyreTwoAge1, double tyreThreePressure1, int tyreThreeAge1, double tyreFourPressure1, int tyreFourAge1) {
                super(model, engineSpeed, enginePower, cargoWeight, cargoType, tyreOnePressure, tyreOneAge, tyreTwoPressure, tyreTwoAge, tyreThreePressure, tyreThreeAge, tyreFourPressure, tyreFourAge);
                this.tyreOnePressure = tyreOnePressure1;
                this.tyreOneAge = tyreOneAge1;
                this.tyreTwoPressure = tyreTwoPressure1;
                this.tyreTwoAge = tyreTwoAge1;
                this.tyreThreePressure = tyreThreePressure1;
                this.tyreThreeAge = tyreThreeAge1;
                this.tyreFourPressure = tyreFourPressure1;
                this.tyreFourAge = tyreFourAge1;
            }

            public double getTyreOnePressure() {
                return tyreOnePressure;
            }

            public void setTyreOnePressure(double tyreOnePressure) {
                this.tyreOnePressure = tyreOnePressure;
            }

            public int getTyreOneAge() {
                return tyreOneAge;
            }

            public void setTyreOneAge(int tyreOneAge) {
                this.tyreOneAge = tyreOneAge;
            }

            public double getTyreTwoPressure() {
                return tyreTwoPressure;
            }

            public void setTyreTwoPressure(double tyreTwoPressure) {
                this.tyreTwoPressure = tyreTwoPressure;
            }

            public int getTyreTwoAge() {
                return tyreTwoAge;
            }

            public void setTyreTwoAge(int tyreTwoAge) {
                this.tyreTwoAge = tyreTwoAge;
            }

            public double getTyreThreePressure() {
                return tyreThreePressure;
            }

            public void setTyreThreePressure(double tyreThreePressure) {
                this.tyreThreePressure = tyreThreePressure;
            }

            public int getTyreThreeAge() {
                return tyreThreeAge;
            }

            public void setTyreThreeAge(int tyreThreeAge) {
                this.tyreThreeAge = tyreThreeAge;
            }

            public double getTyreFourPressure() {
                return tyreFourPressure;
            }

            public void setTyreFourPressure(double tyreFourPressure) {
                this.tyreFourPressure = tyreFourPressure;
            }

            public int getTyreFourAge() {
                return tyreFourAge;
            }

            public void setTyreFourAge(int tyreFourAge) {
                this.tyreFourAge = tyreFourAge;
            }
        }
    }
}



