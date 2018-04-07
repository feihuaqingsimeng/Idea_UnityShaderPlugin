package com.teng.Language;

import com.intellij.openapi.fileTypes.LanguageFileType;
import com.teng.Util.IconUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

import static com.teng.Util.IconUtil.*;

public class ShaderFileType extends LanguageFileType {

    public static final ShaderFileType Instance = new ShaderFileType();
    protected ShaderFileType() {
        super(ShaderLanguage.Instance);
    }

    @NotNull
    @Override
    public String getName() {
        return "shader";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "shader language description";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "shader";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return IconUtil.FILE;
    }
}
