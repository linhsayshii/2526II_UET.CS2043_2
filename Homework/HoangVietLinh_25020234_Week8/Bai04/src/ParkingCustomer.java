import java.util.ArrayList;
import java.util.List;

// === SAU REFACTOR ===
// receipt() giờ chỉ ghép chuỗi, không còn logic tính toán
public class ParkingCustomer {
    private final String name;
    private final List<ParkingTicket> tickets = new ArrayList<>();

    public ParkingCustomer(String name) {
        this.name = name;
    }

    public void addTicket(ParkingTicket ticket) {
        tickets.add(ticket);
    }

    // Replace Temp with Query cho totalFee và bonusPoints
    private double getTotalFee() {
        double total = 0;
        for (ParkingTicket ticket : tickets) {
            total += ticket.getFee();
        }
        return total;
    }

    private int getTotalBonusPoints() {
        int points = 0;
        for (ParkingTicket ticket : tickets) {
            points += ticket.getBonusPoints();
        }
        return points;
    }

    public String receipt() {
        String result = "Parking Receipt for " + name + "\n";

        for (ParkingTicket ticket : tickets) {
            result += "\t" + ticket.getVehicle().getPlate() + "\t" + ticket.getFee() + "\n";
        }

        result += "Total fee is " + getTotalFee() + "\n";
        result += "You earned " + getTotalBonusPoints() + " bonus points";
        return result;
    }
}
