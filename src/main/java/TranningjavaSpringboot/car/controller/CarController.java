package TranningjavaSpringboot.car.controller;

import TranningjavaSpringboot.car.dto.request.CarRequest;
import TranningjavaSpringboot.car.dto.response.CarResponse;
import TranningjavaSpringboot.car.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/car")
@Slf4j
public class CarController {
  private final CarService service;

    public CarController(CarService service) {
        this.service = service;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CarResponse create (@RequestBody CarRequest request) {
        log.info("===Start api create new car ===");
        log.info("=== Request Body :{}", request);
        CarResponse response = service.create(request);
        log.info("=== Finish api create car. Car id {} :  === ", response.getId()) ;
        return response;
    }
}
