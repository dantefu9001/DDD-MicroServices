package com.zn.codegen.util;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class TemplatesLister {

    public static Set<String> templates = new HashSet<>();

    public static Set<String> findTemplate(File file) {
        File[] files = file.listFiles();
        for (File aFile : files) {
            if (aFile.isFile() && aFile.getAbsolutePath().endsWith(".java.vm")) {
                System.out.println(aFile.getAbsolutePath());
                String path = aFile.getAbsolutePath();
                path = path.substring(path.lastIndexOf("template"));
                templates.add(path);
            }
            if (aFile.isDirectory()) {
                findTemplate(aFile);
            }
        }
        return templates;
    }

//    public static void main(String[] args) {
//        String root = System.getProperty("user.dir");
//
//        File file=new File(root+"/src/main/resources/template");
//        showDirectory(file);
//    }
}
