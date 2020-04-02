package com.zn.codegen.util;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class PackageResolver {

    public static Map<String,String> getPackageBase(){
        Map<String, String> packageBaseMap = new HashMap<>(2);
        String root = System.getProperty("user.dir");
        File cwd = new File(root);
        File parent = null;
        if (cwd.isDirectory()) {
            parent = cwd.getParentFile();
        }
        assert parent != null;
        String parentPath = parent.getPath();
        // TODO: 2020/4/1 get paths from files
        parentPath += "/DDDDemo/src/main/java/";
        String packagePath = "com.tw.ddd";
        packageBaseMap.put("parentPath", parentPath);
        packageBaseMap.put("packagePath", packagePath);
        return packageBaseMap;
    }
}
