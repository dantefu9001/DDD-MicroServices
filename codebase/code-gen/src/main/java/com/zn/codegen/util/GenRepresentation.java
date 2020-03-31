package com.zn.codegen.util;

import org.apache.velocity.Template;

import java.util.List;

public class GenRepresentation implements BuildFile{

    List<Template> templates;

    @Override
    public boolean build() {
        return false;
    }
}
