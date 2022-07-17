package com.org.cts.service;

import com.org.cts.model.Bus;
import com.org.cts.repository.BusRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BusServiceImplTest {
    @InjectMocks
    private  BusServiceImpl busServiceImpl;
    @Mock
    private BusRepo busRepo;

    @Test
    void createBus() {
        Bus bus = new Bus();
        bus.setBusNo(1234);
        bus.setName("apsrtc");
        bus.setColor("green");
        bus.setNoOfSeats(45);
        busServiceImpl.createBus(bus);
        Mockito.verify(busRepo,Mockito.times(1)).save(bus);
    }

    @Test
    void updateBus() {
        Bus bus = new Bus();
        bus.setBusNo(4567);
        bus.setName("tsrtc");
        bus.setColor("pink");
        bus.setNoOfSeats(35);
        busServiceImpl.updateBus(bus);
        Mockito.verify(busRepo,Mockito.times(1)).save(bus);
    }

    @Test
    void getAll() {
        List<Bus> lb = new ArrayList<>();
        Bus bus = new Bus();
        bus.setBusNo(1234);
        bus.setName("apsrtc");
        bus.setColor("green");
        bus.setNoOfSeats(45);
        lb.add(bus);
        Bus bus1 = new Bus();
        bus1.setBusNo(4567);
        bus1.setName("tsrtc");
        bus1.setColor("pink");
        bus1.setNoOfSeats(35);
        lb.add(bus1);
        Mockito.when(busRepo.findAll()).thenReturn(lb);
        List<Bus> lb1 = busServiceImpl.getAll();
        Assertions.assertEquals(lb.size(),lb1.size());
    }
    @Test
    void getById() {
        int busNo=1234;
        Bus bus = new Bus();
        bus.setBusNo(1234);
        bus.setColour("green");
        Optional<Bus> optional = Optional.of(bus);
        Mockito.when(busRepo.findById(busNo)).thenReturn(optional);
        Optional<Bus> optional2 = busServiceImpl.getById(busNo);
        Assertions.assertEquals(optional,optional2);
    }
    @Test
    void deleteById() {
        int busNo=1234;
        String s1 = "success";
        String s2 = busServiceImpl.deleteById(busNo);
        Mockito.verify(busRepo,Mockito.times(1)).deleteById(busNo);
        Assertions.assertEquals(s1,s2);
    }
    @Test
    void updateColorBasedOnBusNo() {
        int busNo=1234;
        String color = "green";
        Bus bus = new Bus();
        bus.setBusNo(1234);
        bus.setColour("green");
        Optional<Bus> optional = Optional.of(bus);
        Mockito.when(busRepo.findById(busNo)).thenReturn(optional);
        String s = busServiceImpl.updateColorBasedOnBusNo(busNo,color);
        String s1 = "success";
        Assertions.assertEquals(s,s1);
    }
}

















