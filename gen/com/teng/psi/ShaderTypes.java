// This is a generated file. Not intended for manual editing.
package com.teng.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.teng.psi.impl.*;

public interface ShaderTypes {

  IElementType PROPERTY = new ShaderElementType("PROPERTY");

  IElementType COMMENT = new ShaderTokenType("COMMENT");
  IElementType CRLF = new ShaderTokenType("CRLF");
  IElementType KEY = new ShaderTokenType("KEY");
  IElementType SEPARATOR = new ShaderTokenType("SEPARATOR");
  IElementType VALUE = new ShaderTokenType("VALUE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == PROPERTY) {
        return new ShaderPropertyImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
