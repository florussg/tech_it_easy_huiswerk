package nl.florus.novi.TIE.Dtos;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class TelevisionInputDto {

    //attributen zonder ID

    @NotBlank
    @Size(min=1, max=10)
    private String type;

    @NotBlank
    @Size(min=1, max=100)
    private String brand;

    @NotBlank
    @Size(min=1, max=100)
    private String uniqueName;
    private Double price;
    private Double availableSize;
    private Double refreshRate;
    private String screenType;
    private String screenQuality;
    private Boolean smartTv;
    private Boolean wifi;
    private Boolean voiceControl;
    private Boolean hdr;
    private Boolean bluetooth;
    private Boolean ambiLight;
    private Integer originalStock;
    private Integer sold;

    //setters, om je bij input enkel iets set

    public void setType(String type) {
        this.type = type;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setUniqueName(String uniqueName) {
        this.uniqueName = uniqueName;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setAvailableSize(Double availableSize) {
        this.availableSize = availableSize;
    }

    public void setRefreshRate(Double refreshRate) {
        this.refreshRate = refreshRate;
    }

    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    public void setScreenQuality(String screenQuality) {
        this.screenQuality = screenQuality;
    }

    public void setSmartTv(Boolean smartTv) {
        this.smartTv = smartTv;
    }

    public void setWifi(Boolean wifi) {
        this.wifi = wifi;
    }

    public void setVoiceControl(Boolean voiceControl) {
        this.voiceControl = voiceControl;
    }

    public void setHdr(Boolean hdr) {
        this.hdr = hdr;
    }

    public void setBluetooth(Boolean bluetooth) {
        this.bluetooth = bluetooth;
    }

    public void setAmbiLight(Boolean ambiLight) {
        this.ambiLight = ambiLight;
    }

    public void setOriginalStock(Integer originalStock) {
        this.originalStock = originalStock;
    }

    public void setSold(Integer sold) {
        this.sold = sold;
    }

    //GETTERS

    public String getType() {
        return type;
    }

    public String getBrand() {
        return brand;
    }

    public String getUniqueName() {
        return uniqueName;
    }

    public Double getPrice() {
        return price;
    }

    public Double getAvailableSize() {
        return availableSize;
    }

    public Double getRefreshRate() {
        return refreshRate;
    }

    public String getScreenType() {
        return screenType;
    }

    public String getScreenQuality() {
        return screenQuality;
    }

    public Boolean getSmartTv() {
        return smartTv;
    }

    public Boolean getWifi() {
        return wifi;
    }

    public Boolean getVoiceControl() {
        return voiceControl;
    }

    public Boolean getHdr() {
        return hdr;
    }

    public Boolean getBluetooth() {
        return bluetooth;
    }

    public Boolean getAmbiLight() {
        return ambiLight;
    }

    public Integer getOriginalStock() {
        return originalStock;
    }

    public Integer getSold() {
        return sold;
    }


    //Andere optie//
//    public Television toTelevision() {
//
//        var television = new Television();
//
//        television.setId(id);
//        television.setType(type);
//        television.setBrand(brand);
//        television.setName(name);
//        television.setPrice(price);
//        television.setAvailableSize(availableSize);
//        television.setRefreshRate(refreshRate);
//        television.setScreenType(screenType);
//        television.setScreenQuality(screenQuality);
//        television.setSmartTv(smartTv);
//        television.setWifi(wifi);
//        television.setVoiceControl(voiceControl);
//        television.setHdr(hdr);
//        television.setBluetooth(bluetooth);
//        television.setAmbiLight(ambiLight);
//        television.setOriginalStock(originalStock);
//        television.setSold(sold);
//
//        return television;
//    }


}
