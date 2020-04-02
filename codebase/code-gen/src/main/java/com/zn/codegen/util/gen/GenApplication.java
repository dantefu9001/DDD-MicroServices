package com.zn.codegen.util.gen;

import com.zn.codegen.util.BuildJavaFile;
import com.zn.codegen.util.TemplatesLister;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class GenApplication implements BuildJavaFile {

    private Set<String> templatePaths = new HashSet<>();

    public GenApplication() {
        String root = System.getProperty("user.dir") + "/src/main/resources/";
        templatePaths.addAll(TemplatesLister.getTemplates(new File(root + "template/application")));
        templatePaths.addAll(TemplatesLister.getTemplates(new File(root + "template/domain")));
        templatePaths.addAll(TemplatesLister.getTemplates(new File(root + "template/infrastructure")));
        templatePaths.addAll(TemplatesLister.getTemplates(new File(root + "template/representation")));
    }

    @Override
    public boolean build() {
        return build(templatePaths);
    }

}
