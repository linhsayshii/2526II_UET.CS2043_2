import java.util.ArrayList;
import java.util.List;

// === CODE GỐC (trước refactor) ===
public class BeforeParkingCustomer {
    private final String name;
    private final List<BeforeParkingTicket> tickets = new ArrayList<>();

    public BeforeParkingCustomer(String name) {
        this.name = name;
    }

    public void addTicket(BeforeParkingTicket ticket) {
        tickets.add(ticket);
    }

    public String receipt() {
        double totalFee = 0;
        int bonusPoints = 0;
        String result = "Parking Receipt for " + name + "\n";

        for (BeforeParkingTicket each : tickets) {
            double thisFee = 0;

            switch (each.getVehicle().getType()) {
                case BeforeVehicle.CAR:
                    thisFee += 10;
                    if (each.getHours() > 2) {
                        thisFee += (each.getHours() - 2) * 3;
                    }
                    break;
                case BeforeVehicle.BIKE:
                    thisFee += 5;
                    if (each.getHours() > 3) {
                        thisFee += (each.getHours() - 3) * 2;
                    }
                    break;
                case BeforeVehicle.TRUCK:
                    thisFee += 15 + each.getHours() * 4;
                    break;
            }

            totalFee += thisFee;

            bonusPoints++;
            if (each.getVehicle().getType() == BeforeVehicle.TRUCK && each.getHours() > 5) {
                bonusPoints++;
            }

            result += "\t" + each.getVehicle().getPlate() + "\t" + thisFee + "\n";
        }

        result += "Total fee is " + totalFee + "\n";
        result += "You earned " + bonusPoints + " bonus points";
        return result;
    }
}
