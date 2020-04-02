package com.zn.codegen.util.gen;

import com.zn.codegen.util.BuildJavaFile;
import org.apache.velocity.Template;

import java.util.List;

public class GenRepresentation implements BuildJavaFile {

    List<Template> templates;

    @Override
    public boolean build() {
        return false;
    }
}
