package DefiningClasses.Exc.RawData;

public class Tire {
    private double TirePressure;
    private int TireAge;

    public Tire(double tirePressure, int tireAge) {
        this.TirePressure = tirePressure;
        this.TireAge = tireAge;

    }

    public double getTirePressure() {
        return TirePressure;
    }

    public void setTirePressure(double tirePressure) {
        TirePressure = tirePressure;
    }

    public int getTireAge() {
        return TireAge;
    }

    public void setTireAge(int tireAge) {
        TireAge = tireAge;
    }
}

