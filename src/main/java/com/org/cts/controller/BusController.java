package com.org.cts.controller;

import com.org.cts.model.Bus;
import com.org.cts.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BusController {
    @Autowired
    BusService busService;
    @PostMapping("/create")
    public  void createBus(@RequestBody Bus bus){
        busService.createBus(bus);
    }
    @PostMapping("/update")
    public  void updateBus(@RequestBody Bus bus){
        busService.updateBus(bus);
    }
    @GetMapping("/getAll")
    public List<Bus> getAll(){
        List<Bus> lb = busService.getAll();
        return lb;
    }
    @GetMapping("/getById/{busNo}")
    public Optional<Bus> getById(@PathVariable Integer busNo){
       Optional<Bus> ob1 =  busService.getById(busNo);
       return ob1;
    }
    @DeleteMapping("/deleteById/{busNo}")
    public String deleteById(@PathVariable Integer busNo){
        busService.deleteById(busNo);
        return "success";
    }
    @PatchMapping("/updateColorBasedOnBusNo/{busNo}/{color}")
    public String updateColorBasedOnBusNo(@RequestBody Integer busNo, @RequestBody String color){
       String s = busService.updateColorBasedOnBusNo(busNo, color);
       return s;
    }
}















