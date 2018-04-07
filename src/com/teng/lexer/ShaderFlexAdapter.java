package com.teng.lexer;

import com.intellij.lexer.FlexAdapter;

public class ShaderFlexAdapter extends FlexAdapter {

    public ShaderFlexAdapter()
    {
        super(new ShaderLexer());
    }
}
