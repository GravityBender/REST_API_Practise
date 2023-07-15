package com.restpractise.demo.controller;

import com.restpractise.demo.entity.DataObject;
import com.restpractise.demo.exception.DataObjectNotFoundException;
import com.restpractise.demo.repository.DataObjectRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dataObject")
public class DataObjectController {

    private final DataObjectRepository objRepo;

    public DataObjectController(DataObjectRepository objRepo) {
        this.objRepo = objRepo;
    }

    @GetMapping("/getObject/{categoryCode}")
    public DataObject getObject(@PathVariable String categoryCode) {
        return objRepo.findById(categoryCode)
                        .orElseThrow(()-> new DataObjectNotFoundException("No data object found with categoryCode: " + categoryCode));
    }
    @GetMapping("/getAll")
    public List<DataObject> getAll() {
        return objRepo.findAll();
    }

    @PostMapping("/insertObject")
    DataObject insertObject(@RequestBody DataObject obj) {
        return objRepo.save(obj);
    }

    @PutMapping("/updateObject")
    DataObject updateObject(@RequestBody DataObject obj) {
        String categoryCode = obj.getCategoryCode();
        return objRepo.findById(categoryCode)
                .map(dataObject -> {
                    dataObject.setCategoryCode(obj.getCategoryCode());
                    dataObject.setValue(obj.getValue());
                    return objRepo.save(dataObject);
                })
                .orElseGet(()->{
                    return objRepo.save(obj);
                });
    }

    @DeleteMapping("/deleteObject")
    void deleteObject(@PathVariable String categoryCode) {
        objRepo.deleteById(categoryCode);
    }


}
