package com.zn.codegen.util;

import org.apache.velocity.Template;

import java.util.List;

public class GenInfrastructure implements BuildFile{
    List<Template> templates;

    @Override
    public boolean build() {
        return false;
    }
}
