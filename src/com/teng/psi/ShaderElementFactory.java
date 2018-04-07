package com.teng.psi;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFileFactory;
import com.teng.Language.ShaderFileType;

public class ShaderElementFactory {
    public static ShaderProperty createProperty(Project project, String name){
        final  ShaderFile file = createFile(project,name);
        return (ShaderProperty) file.getFirstChild();
    }
    public static ShaderFile createFile(Project project,String text){
        String name = "dummy.simple";
        return (ShaderFile) PsiFileFactory.getInstance(project).createFileFromText(name, ShaderFileType.Instance,text);
    }
}
