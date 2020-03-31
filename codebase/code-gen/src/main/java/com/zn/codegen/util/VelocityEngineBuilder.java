package com.zn.codegen.util;

import org.apache.velocity.Template;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.File;
import java.io.FileWriter;
import java.io.StringWriter;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class VelocityEngineBuilder {

    private VelocityEngine velocityEngine;


    private VelocityEngineBuilder(VelocityEngine velocityEngine) {
        this.velocityEngine = velocityEngine;
    }

    public static VelocityEngineBuilder startWith(VelocityEngine velocityEngine) {
        Objects.requireNonNull("velocityEngine", "velocityEngine 不能为 null");
        return new VelocityEngineBuilder(velocityEngine);
    }

    public static VelocityEngineBuilder startWithDefault() {
        VelocityEngine ve = new VelocityEngine();
        // 设置资源路径
        ve.setProperty(org.apache.velocity.runtime.RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        // 初始化
        ve.init();
        return new VelocityEngineBuilder(ve);
    }

    public VelocityTemplate withTemplatePath(Supplier<String> resourcePath) {
        Template template = velocityEngine.getTemplate(resourcePath.get());

        return new VelocityTemplate(velocityEngine, template);
    }


    public VelocityTemplate withTemplate(Supplier<Template> template) {
        Objects.requireNonNull("template", "velocity template 不能为 null");

        return new VelocityTemplate(velocityEngine, template.get());
    }


    public static class VelocityTemplate {
        private VelocityEngine velocityEngine;
        private Template template;

        public VelocityTemplate(VelocityEngine velocityEngine, Template template) {
            this.velocityEngine = velocityEngine;
            this.template = template;
        }

        public VelocityContext withContextBuild() {
            org.apache.velocity.VelocityContext ctx = new org.apache.velocity.VelocityContext();
            return new VelocityContext(template, ctx);
        }

        public VelocityContext withContextBuild(Map<String, Object> map) {
            org.apache.velocity.VelocityContext ctx = new org.apache.velocity.VelocityContext(map);
            return new VelocityContext(template, ctx);
        }
    }


    public static class VelocityContext {
        private Template template;
        private org.apache.velocity.VelocityContext context;

        public VelocityContext(Template template, org.apache
                .velocity.VelocityContext context) {
            this.template = template;
            this.context = context;
        }

        public VelocityContext setKV(String k, String v) {
            context.put(k, v);
            return this;
        }

        public VelocityFile toFile(String filePath) {
            StringWriter sw = new StringWriter();
            template.merge(context, sw);
            String result = sw.toString();
            return new VelocityFile(result, filePath);
        }

        public VelocityFile toFile(String filePath, Consumer<Throwable> throwableConsumer) {
            StringWriter sw = new StringWriter();
            template.merge(context, sw);
            String result = sw.toString();
            return new VelocityFile(result, filePath, throwableConsumer);
        }

    }

    public static class VelocityFile {

        private String result;
        private String filePath;
        private Consumer<Throwable> consumer;

        public VelocityFile(String result, String filePath) {
            this.result = result;
            this.filePath = filePath;
        }

        public VelocityFile(String result, String filePath, Consumer<Throwable> consumer) {
            this.result = result;
            this.filePath = filePath;
            this.consumer = consumer;
        }

        public void finish() {

            try {

                File file = new File(filePath);
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.append(result);
                fileWriter.flush();
                fileWriter.close();

            } catch (Throwable e) {
                if (consumer != null) {
                    consumer.accept(e);
                }
            }
        }
    }

}
