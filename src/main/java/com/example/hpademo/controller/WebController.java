package com.example.hpademo.controller;

import com.example.hpademo.models.SampleResponse;
import org.keycloak.representations.JsonWebToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @RequestMapping("/sample")
    public MemResponse Sample(@RequestParam(value = "name",
            defaultValue = "Robot") String name) {
        System.out.println("sample controller is executing");
        SampleResponse response = new SampleResponse();
        response.setId(1);
        response.setMessage("Your name is "+name);


        int mb = 1024*1024;
        byte b[] = new byte[20*mb];
        Example.v.add(b);
        MemResponse mem = new MemResponse();

        //Getting the runtime reference from system
        Runtime runtime = Runtime.getRuntime();
        System.out.println("##### Heap utilization statistics [MB] #####");
        mem.usedMemory = (runtime.totalMemory() - runtime.freeMemory()) / mb ;
        mem.freeMemory = runtime.freeMemory() / mb ;
        mem.totalMemory = runtime.totalMemory() / mb ;
        mem.maxMemory = runtime.maxMemory() / mb ;

        System.out.println("Used Memory:" + mem.usedMemory);
        System.out.println("Free Memory:" + mem.freeMemory);
        System.out.println("Total Memory:" + mem.totalMemory);
        System.out.println("Max Memory:" + mem.maxMemory);

        return mem;

    }


    @RequestMapping("/helloworld")
    public String Test(@RequestParam(value = "name",
            defaultValue = "Robot") String name) {
        System.out.println("Test XXXXXX") ;
        JsonWebToken tokenSentBack = new JsonWebToken();

        System.out.println("TokenSentBack is ");
        System.out.println(tokenSentBack);

        return "HEllo world ok with code 200";

    }


}