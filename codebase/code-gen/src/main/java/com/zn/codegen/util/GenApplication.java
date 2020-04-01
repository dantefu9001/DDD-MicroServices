package com.zn.codegen.util;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
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
            String root = System.getProperty("user.dir");
            File cwd = new File(root);
            File parent = null;
            if (cwd.isDirectory()) {
                parent = cwd.getParentFile();
            }
            assert parent != null;
            String parentPath = parent.getPath();
            parentPath += "/DDDDemo/src/main/java/";
            for (String template : templatePaths) {
                Integer firstSlash = template.indexOf("/");
                Integer lastSlash = template.lastIndexOf("/");
                Integer lastDot = template.lastIndexOf(".");
                String filePath = template.substring(firstSlash, lastSlash + 1);
                String javaFileName = template.substring(lastSlash + 1, lastDot);
                String packageBase = "com.tw.ddd";
                packageBase += filePath.replace("/", ".");
                String fullPath = parentPath + packageBase.replace(".", "/");
                VelocityEngineBuilder.startWithDefault()
                        .withTemplatePath(() -> template)
                        .withContextBuild()
                        .setKV("package", packageBase)
                        .setKV("className", "Test")
                        .setKV("Object", "Value")
                        .toFile(fullPath + javaFileName)
                        .finish();
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
