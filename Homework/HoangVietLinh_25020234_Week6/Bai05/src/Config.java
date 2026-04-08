public class Config implements Cloneable {
    private String ipAddress;
    private int port;
    public Config(String ipAddress, int port) {
        this.ipAddress = ipAddress;
        this.port = port;
    }
    @Override
    public Config clone() {
        try {
            Config clone = (Config) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
    public void setIpAddress(String ipAddress) {this.ipAddress = ipAddress;}
    public void setPort(int port) {this.port = port;}

    @Override
    public String toString() {
        return "Config [ipAddress=" + ipAddress + ":" + port + "]";
    }
}