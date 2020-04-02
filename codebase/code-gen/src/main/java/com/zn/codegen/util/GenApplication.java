package com.zn.codegen.util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenApplication implements BuildFile {

    private Set<String> templatePaths = new HashSet<>();

    public GenApplication() {
        String root = System.getProperty("user.dir") + "/src/main/resources/";
        templatePaths.addAll(TemplatesLister.findTemplate(new File(root + "template/application")));
        templatePaths.addAll(TemplatesLister.findTemplate(new File(root + "template/domain")));
        templatePaths.addAll(TemplatesLister.findTemplate(new File(root + "template/infrastructure")));
        templatePaths.addAll(TemplatesLister.findTemplate(new File(root + "template/representation")));
    }

    @Override
    public boolean build() {
        return build(templatePaths);
    }

}
