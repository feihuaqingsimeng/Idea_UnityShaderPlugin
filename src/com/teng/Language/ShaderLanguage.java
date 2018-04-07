package com.teng.Language;

import com.intellij.lang.Language;

public class ShaderLanguage extends Language {

    protected ShaderLanguage(){
        super("shader");
    }
    public static final ShaderLanguage Instance = new ShaderLanguage();

}
