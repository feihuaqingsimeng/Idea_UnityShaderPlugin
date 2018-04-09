// This is a generated file. Not intended for manual editing.
package com.teng.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class ShaderVisitor extends PsiElementVisitor {

  public void visitBinaryExpr(@NotNull ShaderBinaryExpr o) {
  }

  public void visitBinaryOp(@NotNull ShaderBinaryOp o) {
    visitPsiElement(o);
  }

  public void visitExpr(@NotNull ShaderExpr o) {
  }

  public void visitIfStat(@NotNull ShaderIfStat o) {
    visitPsiElement(o);
  }

  public void visitProperty(@NotNull ShaderProperty o) {
    visitPsiElement(o);
  }

  public void visitUnaryExpr(@NotNull ShaderUnaryExpr o) {
    visitPsiElement(o);
  }

  public void visitUnaryOp(@NotNull ShaderUnaryOp o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
