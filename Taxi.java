// Taxi.java
public class Taxi {
    private String id;
    private String jenis;
    private double tarifPerKm;

    public Taxi(String id, String jenis, double tarifPerKm) {
        this.id = id;
        this.jenis = jenis;
        this.tarifPerKm = tarifPerKm;
    }

    public double getTarifPerKm() {
        return tarifPerKm;
    }

    public String getJenis() {
        return jenis;
    }

    @Override
    public String toString() {
        return jenis + " - Tarif: Rp " + tarifPerKm + "/km";
    }
}
