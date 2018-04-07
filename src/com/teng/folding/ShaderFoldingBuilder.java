package com.teng.folding;

import com.intellij.lang.ASTNode;
import com.intellij.lang.folding.FoldingBuilderEx;
import com.intellij.lang.folding.FoldingDescriptor;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.FoldingGroup;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiLiteralExpression;
import com.intellij.psi.util.PsiTreeUtil;
import com.teng.Util.ShaderUtil;
import com.teng.psi.ShaderProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ShaderFoldingBuilder extends FoldingBuilderEx {
    @NotNull
    @Override
    public FoldingDescriptor[] buildFoldRegions(@NotNull PsiElement root, @NotNull Document document, boolean quick) {
        FoldingGroup group = FoldingGroup.newGroup("simple");
        List<FoldingDescriptor> descriptors = new ArrayList<>();
        Collection<PsiLiteralExpression> literalExpressions = PsiTreeUtil.findChildrenOfType(root,PsiLiteralExpression.class);
        for (final PsiLiteralExpression exp : literalExpressions){
            String value = (String) exp.getValue();
            if(value != null && value.startsWith("simple:")){
                Project project = exp.getProject();
                String key = value.substring(7);
                descriptors.add(new FoldingDescriptor(exp.getNode(),new TextRange(exp.getTextRange().getStartOffset() + 1,exp.getTextRange().getEndOffset() -1),group){
                    @Nullable
                    @Override
                    public String getPlaceholderText() {
                        return "...";
                    }
                });
            }
        }
        return descriptors.toArray(new FoldingDescriptor[descriptors.size()]);
    }

    @Nullable
    @Override
    public String getPlaceholderText(@NotNull ASTNode node) {
        return "...";
    }

    @Override
    public boolean isCollapsedByDefault(@NotNull ASTNode node) {
        return true;
    }
}
