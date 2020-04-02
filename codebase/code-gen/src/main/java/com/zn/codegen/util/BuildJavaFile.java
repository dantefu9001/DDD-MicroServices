package com.zn.codegen.util;

import java.util.Map;
import java.util.Set;

public interface BuildJavaFile {

    boolean build();

    default boolean build(Set<String> templatePaths) {
        try {
            Map<String, String> packageMap = PackageResolver.getPackageBase();
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
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
