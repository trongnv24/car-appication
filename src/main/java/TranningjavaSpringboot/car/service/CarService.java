package TranningjavaSpringboot.car.service;

import TranningjavaSpringboot.car.dto.request.CarRequest;
import TranningjavaSpringboot.car.dto.response.CarResponse;

public interface CarService {
    CarResponse create(CarRequest request);

}
