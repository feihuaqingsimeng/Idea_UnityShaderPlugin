// This is a generated file. Not intended for manual editing.
package com.teng.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.teng.psi.ShaderTypes.*;
import com.teng.psi.*;

public class ShaderPropertyImpl extends ShaderNameElementImpl implements ShaderProperty {

  public ShaderPropertyImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ShaderVisitor visitor) {
    visitor.visitProperty(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ShaderVisitor) accept((ShaderVisitor)visitor);
    else super.accept(visitor);
  }

  public String getKey() {
    return ShaderPsiImplUtil.getKey(this);
  }

  public String getValue() {
    return ShaderPsiImplUtil.getValue(this);
  }

  public String getName() {
    return ShaderPsiImplUtil.getName(this);
  }

  public PsiElement setName(String name) {
    return ShaderPsiImplUtil.setName(this, name);
  }

  public PsiElement getNameIdentifier() {
    return ShaderPsiImplUtil.getNameIdentifier(this);
  }

}
