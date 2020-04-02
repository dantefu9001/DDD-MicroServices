package com.zn.codegen;

import com.zn.codegen.util.gen.GenApplication;
import com.zn.codegen.util.gen.GenMain;

public class CodeGen  {

    public static void main(String[] args) {
        GenApplication genApplication = new GenApplication();
        genApplication.build();
        GenMain genMain = new GenMain();
        genMain.build();
    }
}
