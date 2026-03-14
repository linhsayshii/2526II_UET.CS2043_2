public class VIPRoom extends Room {
    public VIPRoom() {
        setPrice(2000000);
    }
    public double getPrice(int numberOfNights) {
        return 2000000 * numberOfNights;
    }
}
