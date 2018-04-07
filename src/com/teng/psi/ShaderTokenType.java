package com.teng.psi;

import com.intellij.psi.tree.IElementType;
import com.teng.Language.ShaderLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class ShaderTokenType extends IElementType {


    public ShaderTokenType(@NotNull @NonNls String debugName)
    {
        super(debugName, ShaderLanguage.Instance);

    }
    @Override
    public String toString() {
        return "ShaderTokenType." + super.toString();
    }
}
