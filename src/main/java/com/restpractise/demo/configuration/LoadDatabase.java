package com.restpractise.demo.configuration;

import com.restpractise.demo.entity.DataObject;
import com.restpractise.demo.repository.DataObjectRepository;
import com.restpractise.demo.service.Calculations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(DataObjectRepository repo) {
        return args -> {
            log.info("Preloading --> " + repo.save(new DataObject("catc0", 0)));
            log.info("Preloading --> " + repo.save(new DataObject("catc1", 1)));
        };
    }

    @Bean
    @DependsOn({"initDatabase"})
    Calculations readDataBase(DataObjectRepository repo) {
        List<DataObject> list = repo.findAll();
        if(list != null || !list.isEmpty()) {
            Set<Integer> set = new HashSet<>();
            list.forEach((obj) -> set.add(obj.getValue()));
            return new Calculations(set);
        } else {
            return new Calculations();
        }
    }
}
