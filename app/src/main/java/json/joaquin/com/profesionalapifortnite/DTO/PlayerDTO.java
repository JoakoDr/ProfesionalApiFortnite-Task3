package json.joaquin.com.profesionalapifortnite.DTO;

public class PlayerDTO {
    private StatsDTO stats;
    private String accountId;
    private String platformId;
    private String platformName;
    private String epicUserHandle;
    private String platformNameLong;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getPlatformNameLong() {
        return platformNameLong;
    }

    public void setPlatformNameLong(String platformNameLong) {
        this.platformNameLong = platformNameLong;
    }

    public String getEpicUserHandle() {
        return epicUserHandle;
    }

    public void setEpicUserHandle(String epicUserHandle) {
        this.epicUserHandle = epicUserHandle;
    }

    public PlayerDTO()
    {
        this.stats = stats;
    }

    public StatsDTO getStats() {
        return stats;
    }

    public void setStats(StatsDTO stats) {
        this.stats = stats;
    }





}
