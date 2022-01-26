package nl.florus.novi.TIE.Dtos;
import nl.florus.novi.TIE.Models.RemoteController;

public class RemoteControllerDto {

    //attributen
    public Long id;

    public String compatibleWith;

    public String batteryType;

    public String name;

    public String brand;

    public double price;

    public int originalStock;

    //getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompatibleWith() {
        return compatibleWith;
    }

    public void setCompatibleWith(String compatibleWith) {
        this.compatibleWith = compatibleWith;
    }

    public String getBatteryType() {
        return batteryType;
    }

    public void setBatteryType(String batteryType) {
        this.batteryType = batteryType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getOriginalStock() {
        return originalStock;
    }

    public void setOriginalStock(int originalStock) {
        this.originalStock = originalStock;
    }
}


//    public static RemoteControllerDto remoteControllerGetDto (RemoteController remoteController) {
//
//        var dto = new RemoteControllerDto();
//
//        dto.id = remoteController.getId();
//        dto.compatibleWith = remoteController.getCompatibleWith();
//        dto.batteryType = remoteController.getBatteryType();
//        dto.name = remoteController.getName();
//        dto.brand = remoteController.getBrand();
//        dto.price = remoteController.getPrice();
//        dto.originalStock = remoteController.getOriginalStock();
//
//        return dto;
//    }
//
//    public RemoteControllerDto remoteControllerSetDto (RemoteController remoteController) {
//
//        var dto = new RemoteControllerDto();
//
//       remoteController.setId(id);
//       remoteController.setCompatibleWith(compatibleWith);
//       remoteController.setBatteryType(batteryType);
//       remoteController.setName(name);
//       remoteController.setBrand(brand);
//       remoteController.setPrice(price);
//       remoteController.setOriginalStock(originalStock);
//
//        return dto;
//    }





