package com.zn.codegen.util;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GenApplication implements BuildFile {

    private List<String> templatePaths = new ArrayList<>();

    public GenApplication() {
        templatePaths.add("template/application/command/BaseCommand.java.vm");
        templatePaths.add("template/application/domainService/DomainService.java.vm");
    }

    @Override
    public boolean build() {
        try {
            Map<String,String> packageMap = PackageResolver.getPackageBase();
            for (String template : templatePaths) {
                Integer firstSlash = template.indexOf("/");
                Integer lastSlash = template.lastIndexOf("/");
                Integer lastDot = template.lastIndexOf(".");

                String filePath = template.substring(firstSlash, lastSlash + 1);
                String javaFileName = template.substring(lastSlash + 1, lastDot);

                String packageBase = packageMap.get("packagePath");
                String parentPath = packageMap.get("parentPath");

                packageBase += filePath.replace("/", ".");
                String fullPath = parentPath + packageBase.replace(".", "/");
                VelocityEngineBuilder.startWithDefault()
                        .withTemplatePath(() -> template)
                        .withContextBuild()
                        .setKV("package", packageBase)
                        .toFile(fullPath + javaFileName)
                        .finish();
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
