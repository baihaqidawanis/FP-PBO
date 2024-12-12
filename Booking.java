
public class Booking {
    private Taxi taxi;
    private double jarak;
    private double totalHarga;

    public Booking(Taxi taxi, double jarak) {
        this.taxi = taxi;
        this.jarak = jarak;
        hitungHarga();
    }

    public void hitungHarga() {
        this.totalHarga = jarak * taxi.getTarifPerKm();
    }

    public String getBookingDetails() {
        return "Taksi: " + taxi.getJenis() + "\n" +
                "Jarak: " + jarak + " Km\n" +
                "Total Harga: Rp " + totalHarga;
    }
}
