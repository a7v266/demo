package com.example.demo.service;

import com.example.demo.model.Demo;
import com.example.demo.model.api.DemoRequest;
import com.example.demo.model.search.DemoSearch;

import java.util.Collection;

public interface DemoService {

    Collection<Demo> getDemoList(DemoSearch search);

    Demo readDemo(Long id);

    Demo createDemo(DemoRequest request);

    Demo updateDemo(Long id, DemoRequest request);

    Demo deleteDemo(Long id);
}
