package com.teng.psi;

import com.intellij.psi.tree.IElementType;
import com.teng.Language.ShaderLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class ShaderElementType extends IElementType {
    public ShaderElementType(@NotNull @NonNls String debugName)
    {
        super(debugName, ShaderLanguage.Instance);
    }
}
