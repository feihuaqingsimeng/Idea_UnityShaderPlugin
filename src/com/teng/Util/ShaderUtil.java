package com.teng.Util;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.indexing.FileBasedIndex;
import com.teng.Language.ShaderFileType;
import com.teng.psi.ShaderElementType;
import com.teng.psi.ShaderFile;
import com.teng.psi.ShaderProperty;
import com.teng.psi.ShaderTokenType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ShaderUtil {
    public static List<ShaderProperty> findProperties(Project project,String key){
        List<ShaderProperty> result = null;
        Collection<VirtualFile> virtualFiles = FileBasedIndex.getInstance().getContainingFiles(
                FileTypeIndex.NAME, ShaderFileType.Instance, GlobalSearchScope.allScope(project)
        );
        for(VirtualFile virtualFile : virtualFiles){
            ShaderFile shaderFile = (ShaderFile) PsiManager.getInstance(project).findFile(virtualFile);
            if(shaderFile != null){
                ShaderProperty[] properties = PsiTreeUtil.getChildrenOfType(shaderFile,ShaderProperty.class);
                if (properties != null){
                    for(ShaderProperty property : properties){
                        if(key.equals(property.getKey())){
                            if (result == null) {
                                result = new ArrayList<>();
                            }
                            result.add(property);
                        }
                    }
                }
            }
        }
        return result != null ? result : Collections.<ShaderProperty>emptyList();
    }
    public static IElementType createType(String string){
        return new ShaderElementType(string);
    }
    public static IElementType createToken(String string){
        return new ShaderTokenType(string);
    }
}
