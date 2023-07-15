package com.restpractise.demo.controller;

import java.util.*;

import com.restpractise.demo.entity.DataObject;
import com.restpractise.demo.repository.DataObjectRepository;
import com.restpractise.demo.service.Calculations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api")
public class FetchController {
    private final DataObjectRepository objRepo;

    @Autowired
    private Calculations calculations;

    @Autowired
    private DataObjectController doc;

    public FetchController(DataObjectRepository objRepo) {
        this.objRepo = objRepo;
    }

    @GetMapping("/FetchNextNumber/{categoryCode}")
    public Map<String, Integer> FetchNextNumber(@PathVariable String categoryCode) {
        Map<String, Integer> result = new HashMap<>();
        DataObject obj = doc.getObject(categoryCode);

        int oldValue = obj.getValue();
        result.put("oldValue", oldValue);
        result.put("newValue", calculations.calculate(oldValue));

//        Optional<DataObject> obj = objRepo.findById(categoryCode);
//        if(obj.isPresent()) {
//            int oldValue = obj.get().getValue();
//            result.put("oldValue", oldValue);
//            System.out.println("In function!" + result);
//            Calculations calculations = new Calculations();
//            result.put("newValue", calculations.calculate(oldValue));
//
//        } else {
//            result.put("oldValue", 0);
//            result.put("newValue", 0);
//        }
        DataObject newObj = new DataObject(categoryCode, result.get("newValue"));
        doc.updateObject(newObj);
        return result;
    }

}
