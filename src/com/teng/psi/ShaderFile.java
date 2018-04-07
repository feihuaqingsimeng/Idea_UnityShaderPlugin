package com.teng.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.teng.Language.ShaderFileType;
import com.teng.Language.ShaderLanguage;
import org.jetbrains.annotations.NotNull;

public class ShaderFile extends PsiFileBase {

    public ShaderFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, ShaderLanguage.Instance);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return ShaderFileType.Instance;
    }
}
