package TranningjavaSpringboot.car.dto.response;

import TranningjavaSpringboot.car.dto.request.CarRequest;

public class CarResponse extends CarRequest {
    private String id;

    public CarResponse() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CarResponse{" +
                "id='" + id + '\'' +
                ", brand='" + getBrand() + '\'' +
                ", year=" + getYear() +
                ", color='" + getColor() + '\'' +
                ", price=" + getPrice() +
                '}';
    }
}
