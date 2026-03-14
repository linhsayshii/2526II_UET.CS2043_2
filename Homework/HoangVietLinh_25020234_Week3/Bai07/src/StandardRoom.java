public class StandardRoom extends Room {
    public StandardRoom() {
        setPrice(500000);
    }
    public double getPrice(int numberOfNights) {
        if (numberOfNights > 3) {
            return 500000 * numberOfNights * 0.95; // Apply 20% discount
        }
        return 500000 * numberOfNights;
    }
}
