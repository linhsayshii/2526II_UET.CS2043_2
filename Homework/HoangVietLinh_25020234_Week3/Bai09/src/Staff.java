public abstract class Staff implements IPayable {
    private String id;
    private String name;
    public Staff(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public abstract double getPaymentAmount();
}
interface IPayable {
    double getPaymentAmount();
    String getName();
    String getType();
}
