// This is a generated file. Not intended for manual editing.
package com.teng.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.teng.psi.ShaderTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.teng.psi.*;

public class ShaderBinaryExprImpl extends ASTWrapperPsiElement implements ShaderBinaryExpr {

  public ShaderBinaryExprImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ShaderVisitor visitor) {
    visitor.visitBinaryExpr(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ShaderVisitor) accept((ShaderVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public ShaderBinaryOp getBinaryOp() {
    return findNotNullChildByClass(ShaderBinaryOp.class);
  }

  @Override
  @NotNull
  public ShaderExpr getExpr() {
    return findNotNullChildByClass(ShaderExpr.class);
  }

}
