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
        log.info("=== Finish api new create car. Car id {} :  === ", response.getId()) ;
        return response;
    }
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public CarResponse getById ( @PathVariable("id") String id) {
        log.info(" === Start api getById new car === ");
        log.info(" === String id : {} === ", id);
        CarResponse response = service.getById(id);
        log.info(" === Finish api getById car. Car id {} : === ", response.getId()) ;
        return response;
    }
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public CarResponse update (@RequestBody CarRequest request, @PathVariable("id") String id) {
        log.info("=== Start api update car === ");
        log.info(" === Request Body {} :, String id {} : ===" , request, id);
        CarResponse response = service.update(request,id);
        log.info("=== Finish api update car . Car id {} : === ", response.getId());
        return response;
    }
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById (@PathVariable("id") String id) {
        log.info("=== Start api update cart === ");
        log.info("=== String id {}:  ==== ", id);
        log.info("=== Finish api delete car . Car id {} : === ");
        service.deleteById(id);
    }
}
