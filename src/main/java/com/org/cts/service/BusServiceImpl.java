package com.org.cts.service;

import com.org.cts.model.Bus;
import com.org.cts.repository.BusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusServiceImpl implements BusService{
    @Autowired
    BusRepo busRepo;
    @Override
    public void createBus(Bus bus) {
        busRepo.save(bus);
    }

    @Override
    public void updateBus(Bus bus) {
        busRepo.save(bus);
    }

    @Override
    public List<Bus> getAll() {
        List<Bus> lb = busRepo.findAll();
        return lb;
    }

    @Override
    public Optional<Bus> getById(Integer busNo) {
        Optional<Bus> ob = busRepo.findById(busNo);
        return ob;
    }

    @Override
    public String deleteById(Integer busNo) {
        busRepo.deleteById(busNo);
        return "success";
    }

    @Override
    public String updateColorBasedOnBusNo(Integer busNo, String color) {
        Optional<Bus> ob1 = busRepo.findById(busNo);
        Bus bus = ob1.get();
        bus.setColor(color);
        busRepo.save(bus);
        return "success";
    }
}
