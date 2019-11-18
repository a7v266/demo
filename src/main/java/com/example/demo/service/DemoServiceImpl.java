package com.example.demo.service;

import com.example.demo.model.Demo;
import com.example.demo.model.api.DemoRequest;
import com.example.demo.model.exception.NotFoundException;
import com.example.demo.model.search.DemoSearch;
import com.example.demo.utils.Messages;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class DemoServiceImpl implements DemoService {

    private AtomicLong id;
    private Map<Long, Demo> demos;

    @PostConstruct
    public void init() {
        id = new AtomicLong();
        demos = new HashMap<>();
        demos.computeIfAbsent(id.incrementAndGet(), id -> new Demo(id, "Mr.First"));
        demos.computeIfAbsent(id.incrementAndGet(), id -> new Demo(id, "Ms.Second"));
    }

    @Override
    public Collection<Demo> getDemoList(DemoSearch search) {
        return demos.values();
    }

    @Override
    public Demo readDemo(Long id) {
        Demo demo = demos.get(id);
        if (demo == null) {
            throw new NotFoundException(Messages.ERROR_DEMO_NOT_FOUND, id);
        }
        return demo;
    }

    @Override
    public Demo createDemo(DemoRequest request) {
        Demo demo = request.createDemo();
        demo.setId(id.incrementAndGet());
        demos.put(demo.getId(), demo);
        return demo;
    }

    @Override
    public Demo updateDemo(Long id, DemoRequest request) {
        Demo demo = demos.get(id);
        if (demo == null) {
            throw new NotFoundException(Messages.ERROR_DEMO_NOT_FOUND, id);
        }
        return request.updateProblem(demo);
    }

    @Override
    public Demo deleteDemo(Long id) {
        Demo demo = demos.get(id);
        if (demo == null) {
            throw new NotFoundException(Messages.ERROR_DEMO_NOT_FOUND, id);
        }
        return demos.remove(id);
    }
}
