package com.teng.highlighting;

import com.intellij.lexer.LayeredLexer;
import com.teng.lexer.ShaderFlexAdapter;

public class ShaderFileLexer extends LayeredLexer{

    public ShaderFileLexer()
    {
        super(new ShaderFlexAdapter());
    }
}
