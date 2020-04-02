package com.zn.codegen.util.gen;

import com.zn.codegen.util.BuildJavaFile;
import com.zn.codegen.util.TemplatesLister;

import java.io.File;
import java.util.HashSet;

public class GenMain implements BuildJavaFile {

    @Override
    public boolean build() {
        String path = System.getProperty("user.dir") + "/src/main/resources/";
        path += "template/main";
        HashSet<String> templates = new HashSet<>(TemplatesLister.getTemplates(new File(path)));
        return build(templates);
    }
}
