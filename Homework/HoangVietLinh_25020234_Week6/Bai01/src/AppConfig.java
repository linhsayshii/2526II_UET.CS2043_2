public class AppConfig {
    private static volatile AppConfig instance;
    private String appName;
    private String version;
    private String logLevel;
    private AppConfig() {
        this.appName = "AppConfig";
        this.version = "1.0";
        this.logLevel = "INFO";
    }
    public static AppConfig getInstance() {
        if (instance == null) {
            synchronized(AppConfig.class) {
                if (instance == null) {
                    instance = new AppConfig();
                }
            }
        }
        return instance;
    }
    public String getAppName() {return appName;}
    public String getVersion() {return version;}
    public String getLogLevel() {return logLevel;}
}
