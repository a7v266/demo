package com.example.demo.controller;

import com.example.demo.model.Demo;
import com.example.demo.model.api.DemoRequest;
import com.example.demo.model.search.DemoSearch;
import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Map;

@RestController
public class DemoApi {

    public static final String PATH_DEMO = "/demo";
    public static final String PATH_DEMO_ID = "/demo/{id}";

    @Autowired
    private DemoService demoService;

    @GetMapping(path = PATH_DEMO)
    public Collection<Demo> getDemoList(@RequestParam Map<String, String> parameters) {
        return demoService.getDemoList(new DemoSearch(parameters));
    }

    @PostMapping(path = PATH_DEMO)
    public Demo createDemo(@RequestBody @Valid DemoRequest demoRequest) {
        return demoService.createDemo(demoRequest);
    }

    @GetMapping(path = PATH_DEMO_ID)
    public Demo readDemo(@PathVariable Long id) {
        return demoService.readDemo(id);
    }

    @PutMapping(path = PATH_DEMO_ID)
    public Demo updateDemo(@PathVariable Long id, @RequestBody @Valid DemoRequest request) {
        return demoService.updateDemo(id, request);
    }

    @DeleteMapping(path = PATH_DEMO_ID)
    public Demo deleteDemo(@PathVariable Long id) {
        return demoService.deleteDemo(id);
    }
}
