package com.zn.codegen.util;

import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class GenApplication implements BuildFile {

    private List<String> templatePaths = new ArrayList<>();

    public GenApplication() {
        templatePaths.add("template/application/command/BaseCommand.java.vm");
        templatePaths.add("template/application/domainService/DomainService.java.vm");
    }

    @Override
    public boolean build() {
        try {
            for (String template : templatePaths) {
                VelocityEngineBuilder.startWithDefault()
                        .withTemplatePath(() -> template)
                        .withContextBuild()
                        .setKV("package", "com.example.lx.springbootdemo.Velocity")
                        .setKV("className", "Test")
                        .setKV("Object", "Value")
                        .toFile(System.getProperty("user.dir")+"/" + RandomUtils.nextInt() + "TestDomain.java")
                        .finish();
            }

        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
