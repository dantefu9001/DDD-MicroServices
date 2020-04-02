package com.zn.codegen.util;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class TemplatesLister {

    public static Set<String> templates = new HashSet<>();

    public static Set<String> getTemplates(File file) {
        File[] files = file.listFiles();
        for (File aFile : files) {
            if (aFile.isFile() && aFile.getAbsolutePath().endsWith(".java.vm")) {
                String path = aFile.getAbsolutePath();
                path = path.substring(path.lastIndexOf("template"));
                templates.add(path);
            }
            if (aFile.isDirectory()) {
                getTemplates(aFile);
            }
        }
        return templates;
    }

}
