package com.example.asmstringboot.api;

import com.example.asmstringboot.entity.Road;
import com.example.asmstringboot.service.RoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "api/v1/roads")
public class RoadApi {
    @Autowired
    RoadService roadService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Road>> findAll() {
        return ResponseEntity.ok(roadService.findAll());
    }

    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        Optional<Road> road = roadService.findById(id);
        if (!road.isPresent()) {
            ResponseEntity.badRequest().build();// khoong co du lieu tra ve
        }
        return ResponseEntity.ok(road.get());//cos du lieu tra ve
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Road> save(@RequestBody Road road) {
        return ResponseEntity.ok(roadService.save(road));
    }

    @RequestMapping(method = RequestMethod.PUT, path = "{id}")
    public ResponseEntity<Road> update(@PathVariable int id, @RequestBody Road updateRoad) {
        Optional<Road> road = roadService.findById(id);//tim product theo id
        if (!road.isPresent()) {
            ResponseEntity.badRequest().build();// khoong co du lieu tra ve
        }
        Road exitsRoad = road.get();
        exitsRoad.setCity(updateRoad.getCity());
        exitsRoad.setDistrict(updateRoad.getDistrict());
        exitsRoad.setWard(updateRoad.getWard());
        exitsRoad.setStreet(updateRoad.getStreet());

        exitsRoad.setDescription(updateRoad.getDescription());
        exitsRoad.setStatus(updateRoad.getStatus());
        return ResponseEntity.ok(roadService.save(exitsRoad));//cos du lieu tra ve
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        Optional<Road> road = roadService.findById(id);//tim product theo id
        if (!road.isPresent()) {
            ResponseEntity.badRequest().build();// khoong co du lieu tra ve
        }
        roadService.deleteById(id);
        return ResponseEntity.ok().build();//cos du lieu tra ve
    }
}
