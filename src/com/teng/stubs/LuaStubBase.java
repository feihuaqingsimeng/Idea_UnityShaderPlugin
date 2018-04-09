package com.teng.stubs;

import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.intellij.psi.PsiElement;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.stubs.StubElement;
import com.teng.Language.ShaderLanguage;
import com.teng.psi.ShaderBlock;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class LuaStubBase {
}
abstract class ShaderStubElementType<StubT extends StubElement, PsiT extends PsiElement> extends IStubElementType{

    public ShaderStubElementType(@NotNull String debugName) {
        super(debugName, ShaderLanguage.Instance);
    }

    protected final boolean createStubIfParentIsStub(@NotNull ASTNode node){
        ASTNode parent = node.getTreeParent();
        if (parent.getPsi() instanceof ShaderBlock){
            parent = parent.getTreeParent();
        }
        return true;
    }
}
