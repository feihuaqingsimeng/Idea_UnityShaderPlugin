// This is a generated file. Not intended for manual editing.
package com.teng.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.teng.Util.ShaderUtil;
import com.teng.psi.impl.*;

public interface ShaderTypes {

  IElementType BINARY_EXPR = ShaderUtil.createType("BINARY_EXPR");
  IElementType BINARY_OP = ShaderUtil.createType("BINARY_OP");
  IElementType EXPR = ShaderUtil.createType("EXPR");
  IElementType IF_STAT = ShaderUtil.createType("IF_STAT");
  IElementType PROPERTY = ShaderUtil.createType("PROPERTY");
  IElementType UNARY_EXPR = ShaderUtil.createType("UNARY_EXPR");
  IElementType UNARY_OP = ShaderUtil.createType("UNARY_OP");

  IElementType AND = ShaderUtil.createToken("&&");
  IElementType ASSIGN = ShaderUtil.createToken("=");
  IElementType BIT_AND = ShaderUtil.createToken("&");
  IElementType BIT_LTLT = ShaderUtil.createToken("<<");
  IElementType BIT_OR = ShaderUtil.createToken("|");
  IElementType BIT_RTRT = ShaderUtil.createToken(">>");
  IElementType BIT_TILDE = ShaderUtil.createToken("~");
  IElementType BLOCK_COMMENT = ShaderUtil.createToken("BLOCK_COMMENT");
  IElementType BREAK = ShaderUtil.createToken("break");
  IElementType CLOSUREEXPR = ShaderUtil.createToken("closureExpr");
  IElementType COMMA = ShaderUtil.createToken(",");
  IElementType COMMENT = ShaderUtil.createToken("COMMENT");
  IElementType CRLF = ShaderUtil.createToken("CRLF");
  IElementType DIV = ShaderUtil.createToken("/");
  IElementType DOT = ShaderUtil.createToken(".");
  IElementType ELSE = ShaderUtil.createToken("else");
  IElementType ENDREGION = ShaderUtil.createToken("ENDREGION");
  IElementType EQ = ShaderUtil.createToken("==");
  IElementType EXP = ShaderUtil.createToken("^");
  IElementType FOR = ShaderUtil.createToken("for");
  IElementType GE = ShaderUtil.createToken(">=");
  IElementType GETN = ShaderUtil.createToken("#");
  IElementType GT = ShaderUtil.createToken(">");
  IElementType ID = ShaderUtil.createToken("ID");
  IElementType IF = ShaderUtil.createToken("if");
  IElementType IN = ShaderUtil.createToken("in");
  IElementType KEY = ShaderUtil.createToken("KEY");
  IElementType LBRACKET = ShaderUtil.createToken("[");
  IElementType LE = ShaderUtil.createToken("<=");
  IElementType LPAREN = ShaderUtil.createToken("(");
  IElementType LT = ShaderUtil.createToken("<");
  IElementType MINUS = ShaderUtil.createToken("-");
  IElementType MOD = ShaderUtil.createToken("%");
  IElementType MULT = ShaderUtil.createToken("*");
  IElementType NE = ShaderUtil.createToken("!=");
  IElementType NOT = ShaderUtil.createToken("!");
  IElementType NUMBER = ShaderUtil.createToken("NUMBER");
  IElementType OR = ShaderUtil.createToken("||");
  IElementType OUT = ShaderUtil.createToken("out");
  IElementType PLUS = ShaderUtil.createToken("+");
  IElementType PRIMARYEXPR = ShaderUtil.createToken("primaryExpr");
  IElementType RBRACKET = ShaderUtil.createToken("]");
  IElementType RCURLY = ShaderUtil.createToken("{");
  IElementType REGION = ShaderUtil.createToken("REGION");
  IElementType RPAREN = ShaderUtil.createToken(")");
  IElementType SEMI = ShaderUtil.createToken(";");
  IElementType SEPARATOR = ShaderUtil.createToken("SEPARATOR");
  IElementType STRING = ShaderUtil.createToken("STRING");
  IElementType VALUE = ShaderUtil.createToken("VALUE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == BINARY_EXPR) {
        return new ShaderBinaryExprImpl(node);
      }
      else if (type == BINARY_OP) {
        return new ShaderBinaryOpImpl(node);
      }
      else if (type == EXPR) {
        return new ShaderExprImpl(node);
      }
      else if (type == IF_STAT) {
        return new ShaderIfStatImpl(node);
      }
      else if (type == PROPERTY) {
        return new ShaderPropertyImpl(node);
      }
      else if (type == UNARY_EXPR) {
        return new ShaderUnaryExprImpl(node);
      }
      else if (type == UNARY_OP) {
        return new ShaderUnaryOpImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
