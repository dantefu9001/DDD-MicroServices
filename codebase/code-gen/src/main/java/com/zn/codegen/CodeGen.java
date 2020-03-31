package com.zn.codegen;

import com.zn.codegen.util.GenApplication;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

public class CodeGen {

    public static void main(String[] args) throws IOException {
//        VelocityEngine engine = new VelocityEngine();
//        engine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
//        engine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
//        engine.init();
//
//        Template template = engine.getTemplate("template/domain.java.vm");
//
//        System.out.println(CodeGen.class.getPackage().getName());
//        VelocityContext context = new VelocityContext();
//        context.put("package", "com.zenan.domain");
//        context.put("className", "Test");
//        context.put("Object", "Value");
//        StringWriter writer = new StringWriter();
//        template.merge(context, writer);
//        String string = writer.toString();
//        String pwd = System.getProperty("user.dir");
//        File cwd = new File(pwd);
//        File parent = null;
//        if (cwd.isDirectory()) {
//            parent = cwd.getParentFile();
//        }
//        assert parent != null;
//        String parentPath = parent.getPath();
//        String packagePath = "com/zn/codegen/model/";
//        parentPath += "/DDD/src/main/java/";
//        parentPath += packagePath;
//        File packageDir = new File(parentPath);
//        if (packageDir.mkdirs()) {
//            File file = new File(parentPath + "TestDomain.java");
//            FileWriter fileWriter = new FileWriter(file);
//            fileWriter.append(string);
//            fileWriter.flush();
//            fileWriter.close();
//        }
        GenApplication genApplication = new GenApplication();
        genApplication.build();

    }
}
