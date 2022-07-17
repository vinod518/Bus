package com.org.cts.service;

import com.org.cts.model.Bus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface BusService {
    public  void createBus( Bus bus);
    public  void updateBus( Bus bus);
    public List<Bus> getAll();
    public Optional<Bus> getById( Integer busNo);
    public String deleteById( Integer busNo);
    public String updateColorBasedOnBusNo( Integer busNo,  String color);
}
