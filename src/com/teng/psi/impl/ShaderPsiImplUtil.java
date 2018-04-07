package com.teng.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.teng.psi.ShaderElementFactory;
import com.teng.psi.ShaderProperty;
import com.teng.psi.ShaderTypes;

public class ShaderPsiImplUtil {
    public static String getName(ShaderProperty element){
        return getKey(element);
    }
    public static PsiElement setName(ShaderProperty element,String name){
        ASTNode node = element.getNode().findChildByType(ShaderTypes.KEY);
        if (node != null){
            ShaderProperty property = ShaderElementFactory.createProperty(element.getProject(),name);
            ASTNode newKeyNode = property.getFirstChild().getNode();
            element.getNode().replaceChild(node,newKeyNode);
        }
        return element;
    }
    public static PsiElement getNameIdentifier(ShaderProperty element){
        ASTNode keyNode = element.getNode().findChildByType(ShaderTypes.KEY);
        if (keyNode != null){
            return keyNode.getPsi();
        }
        return null;
    }
    public static String getKey(ShaderProperty element) {
        ASTNode keyNode = element.getNode().findChildByType(ShaderTypes.KEY);
        if (keyNode != null){
            return keyNode.getText().replaceAll("\\\\"," ");
        }else{
            return null;
        }
    }
    public static String getValue(ShaderProperty element){
        ASTNode node = element.getNode().findChildByType(ShaderTypes.VALUE);
        if (node != null){
            return node.getText();
        }else{
            return null;
        }
    }
}
