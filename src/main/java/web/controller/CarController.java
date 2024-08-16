package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;
import web.service.CarServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {
    @Autowired
    private CarService carService;

    public CarController() {
        carService = new CarServiceImpl();
    }

    @GetMapping(value = "/cars")
    public String printCars(@RequestParam(value = "count", defaultValue = "5") int id, ModelMap model) {
        List<Car> carList = new ArrayList<>(carService.getCars(id));
//        List<Car> carList = new ArrayList<>();
//        carList.add(new Car("BMW", 200, "Black"));
//        carList.add(new Car("Mercedes", 200, "White"));
//        carList.add(new Car("id", id, "Red"));
        model.addAttribute("carList", carList);
        return "cars";
    }

}
