package cn.heshw.entity;

public class TSpuDetail {
    private Long spuId;

    private String configInfo;

    private String configOption;

    private String accessoriesList;

    private String afterSale;

    private String description;

    public Long getSpuId() {
        return spuId;
    }

    public void setSpuId(Long spuId) {
        this.spuId = spuId;
    }

    public String getConfigInfo() {
        return configInfo;
    }

    public void setConfigInfo(String configInfo) {
        this.configInfo = configInfo;
    }

    public String getConfigOption() {
        return configOption;
    }

    public void setConfigOption(String configOption) {
        this.configOption = configOption;
    }

    public String getAccessoriesList() {
        return accessoriesList;
    }

    public void setAccessoriesList(String accessoriesList) {
        this.accessoriesList = accessoriesList;
    }

    public String getAfterSale() {
        return afterSale;
    }

    public void setAfterSale(String afterSale) {
        this.afterSale = afterSale;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}