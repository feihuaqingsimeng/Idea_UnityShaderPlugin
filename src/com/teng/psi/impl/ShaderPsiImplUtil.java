package com.teng.psi.impl;

import com.intellij.psi.PsiElement;

import com.intellij.psi.PsiNameIdentifierOwner;
import com.teng.psi.ShaderElementFactory;
import com.teng.psi.ShaderNameExpr;

public class ShaderPsiImplUtil {
    public static PsiElement getNameIdentifier(ShaderNameExpr expr)
    {
        return expr.getId();
    }

    public static PsiElement setName(PsiNameIdentifierOwner owner,String name) {
        PsiElement oldId = owner.getNameIdentifier();
        if (oldId != null) {
            PsiElement newId = ShaderElementFactory.createIdentifier(owner.getProject(), name);
            oldId.replace(newId);
            return newId;
        }
        return owner;
    }
    public static String getName(ShaderNameExpr expr){
        return expr.getText();
    }
}
