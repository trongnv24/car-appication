package TranningjavaSpringboot.car.service.Impl;

import TranningjavaSpringboot.car.dto.request.CarRequest;
import TranningjavaSpringboot.car.dto.response.CarResponse;
import TranningjavaSpringboot.car.entity.CarEntity;
import TranningjavaSpringboot.car.repository.CarRepository;
import TranningjavaSpringboot.car.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static TranningjavaSpringboot.car.service.mapping.CarMapping.convertDtoToEntity;
import static TranningjavaSpringboot.car.service.mapping.CarMapping.convertEntityToUserResponse;

@Service
@Slf4j
public class CarServiceImpl implements CarService  {

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository repository) {
        this.carRepository = repository;
    }

    @Override
    public CarResponse create(CarRequest request) {
        log.info("=== Start api create new create ===");
        log.info("=== Request body:{} === ",request);
        CarEntity carEntity = convertDtoToEntity(request);
        carEntity = carRepository.save(carEntity);
        CarResponse response = convertEntityToUserResponse(carEntity);
        log.info(" === Complete the new car creation apo . Car id ===",response.getId());
        return response;

    }
    @Override
    public CarResponse getById(String id) {
        log.info(" === Start api getById car");
        log.info(" === String id:{} === ", id);
        Optional<CarEntity> optionalCar = carRepository.findById(id);
        if (!optionalCar.isPresent()) {
            throw new RuntimeException();
        }
        CarEntity carEntity = optionalCar.get();
        CarResponse response = convertEntityToUserResponse(carEntity);
        log.info(" === Finish api getById car. Car id {} : === ",response.getId());
        return response;
    }
    @Override
    public CarResponse update (CarRequest request , String id) {
        log.info(" === Start api update car === ");
        log.info(" === Request Body {} :, String id {}: ", request ,id);
        Optional<CarEntity> optionalCar = carRepository.findById(id);
        if(!optionalCar.isPresent()) {
            throw  new RuntimeException();
        }
        CarEntity carEntity = optionalCar.get();
        carEntity.setBrand(request.getBrand());
        carEntity.setYear(request.getYear());
        carEntity.setColor(request.getColor());
        carEntity.setPrice(request.getPrice());
        carEntity = carRepository.save(carEntity);
        CarResponse response = convertEntityToUserResponse(carEntity);
        log.info(" === Finish api update car. Car id {}: ", response.getId());
        return response;
    }
}
