// This is a generated file. Not intended for manual editing.
package com.teng.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class ShaderVisitor extends PsiElementVisitor {

  public void visitProperty(@NotNull ShaderProperty o) {
    visitNameElement(o);
  }

  public void visitNameElement(@NotNull ShaderNameElement o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}