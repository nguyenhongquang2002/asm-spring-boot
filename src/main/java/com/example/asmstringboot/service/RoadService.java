package com.example.asmstringboot.service;

import com.example.asmstringboot.entity.Road;
import com.example.asmstringboot.repository.RoadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoadService {
    @Autowired
    RoadRepository roadRepository;

    public Road save(Road road){
        return roadRepository.save(road);
    }

    public List<Road> findAll(){return roadRepository.findAll();}

    public Optional<Road> findById(int id){return roadRepository.findById(id);}

    public void deleteById(int id){roadRepository.deleteById(id);}
}
