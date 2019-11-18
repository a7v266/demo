package com.example.demo.model.api;

import com.example.demo.model.Demo;
import com.example.demo.utils.Format;
import com.example.demo.utils.Messages;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

public class DemoRequest {

    @JsonProperty
    @NotEmpty(message = Messages.ERROR_DEMO_NAME_EMPTY)
    @Length(max = Format.LENGTH_DEFAULT, message = Messages.ERROR_DEMO_NAME_MAX_LENGTH)
    private String name;


    public Demo createDemo() {
        return updateProblem(new Demo());
    }

    public Demo updateProblem(Demo demo) {
        demo.setName(name);
        return demo;
    }


}
