package TranningjavaSpringboot.car.service.mapping;

import TranningjavaSpringboot.car.dto.request.CarRequest;
import TranningjavaSpringboot.car.dto.response.CarResponse;
import TranningjavaSpringboot.car.entity.CarEntity;

public class CarMapping {

    public static CarEntity convertDtoToEntity(CarRequest dto) {
        CarEntity entity =new CarEntity();
        entity.setBrand(dto.getBrand());
        entity.setYear(dto.getYear());
        entity.setColor(dto.getColor());
        entity.setPrice(dto.getPrice());
        return entity;

    }
    public static CarResponse convertEntityToUserResponse(CarEntity entity) {
        CarResponse dto = new CarResponse();
        dto.setId(entity.getId());
        dto.setBrand(entity.getBrand());
        dto.setColor(entity.getColor());
        dto.setPrice(entity.getPrice());
        dto.setYear(entity.getYear());
        return dto;
    }
}
