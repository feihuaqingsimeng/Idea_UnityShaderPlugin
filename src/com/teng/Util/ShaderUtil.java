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

import com.teng.psi.ShaderTokenType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ShaderUtil {

    public static IElementType createType(String string){
        return new ShaderElementType(string);
    }
    public static IElementType createToken(String string){
        return new ShaderTokenType(string);
    }
}
