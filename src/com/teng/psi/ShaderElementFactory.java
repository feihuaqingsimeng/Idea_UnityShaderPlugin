package com.teng.psi;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFileFactory;
import com.intellij.psi.util.PsiTreeUtil;
import com.teng.Language.ShaderFileType;

public class ShaderElementFactory {

    public static ShaderFile createFile(Project project,String text){
        String name = "dummy.shader";
        return (ShaderFile) PsiFileFactory.getInstance(project).createFileFromText(name, ShaderFileType.Instance,text);
    }
    public static PsiElement createIdentifier(Project project,String name){
        String content = "local" + name + " = 0";
        ShaderFile file = createFile(project,content);
        PsiElement element = PsiTreeUtil.findChildOfType(file,ShaderNameDef.class);
        return element.getFirstChild();
    }
}
