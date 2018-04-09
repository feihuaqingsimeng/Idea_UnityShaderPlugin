package com.teng.annotation;

import com.intellij.icons.AllIcons;
import com.intellij.lang.annotation.Annotation;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiLiteralExpression;
import com.sun.jna.platform.unix.solaris.LibKstat;
import com.teng.Util.ShaderUtil;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ShaderAnnotator implements Annotator {
    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {

    }
}
