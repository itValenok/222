package web.service;

import org.springframework.stereotype.Component;
import web.controller.CarController;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarServiceImpl implements CarService {
    private List<Car> carList;

    {
        carList = new ArrayList<>();
        carList.add(new Car("BMW", 200, "Red"));
        carList.add(new Car("Запорожец", 320, "Green"));
        carList.add(new Car("Зил", 200, "Blue"));
        carList.add(new Car("Тойота", 200, "Black"));
        carList.add(new Car("Mercedes", 200, "White"));

    }

    @Override
    public List<Car> getCars(int carCount) {
        int i = 0;
        List<Car> cars = new ArrayList<>();
        if (carCount >= carList.size()) {
            return carList;
        } else {
            while (i < carCount) {
                cars.add(carList.get(i));
                i++;
            }
            return cars;
        }
    }
}
