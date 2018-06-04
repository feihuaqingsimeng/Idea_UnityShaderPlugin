// This is a generated file. Not intended for manual editing.
package com.teng.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.teng.Util.ShaderUtil;
import com.teng.psi.impl.*;

public interface ShaderTypes {

  IElementType ARGS = ShaderUtil.createType("ARGS");
  IElementType ASSIGN_STAT = ShaderUtil.createType("ASSIGN_STAT");
  IElementType BINARY_EXPR = ShaderUtil.createType("BINARY_EXPR");
  IElementType BINARY_OP = ShaderUtil.createType("BINARY_OP");
  IElementType CALL_EXPR = ShaderUtil.createType("CALL_EXPR");
  IElementType CGPROGRAM_FIELD = ShaderUtil.createType("CGPROGRAM_FIELD");
  IElementType DEFINE_STAT = ShaderUtil.createType("DEFINE_STAT");
  IElementType EMPTY_STAT = ShaderUtil.createType("EMPTY_STAT");
  IElementType EXPR = ShaderUtil.createType("EXPR");
  IElementType EXPR_LIST = ShaderUtil.createType("EXPR_LIST");
  IElementType EXPR_STAT = ShaderUtil.createType("EXPR_STAT");
  IElementType FUNC_BODY = ShaderUtil.createType("FUNC_BODY");
  IElementType FUNC_DEF = ShaderUtil.createType("FUNC_DEF");
  IElementType GEN_IF_STAT = ShaderUtil.createType("GEN_IF_STAT");
  IElementType IF_DEF_EXPR = ShaderUtil.createType("IF_DEF_EXPR");
  IElementType IF_N_DEF_EXPR = ShaderUtil.createType("IF_N_DEF_EXPR");
  IElementType IF_STAT = ShaderUtil.createType("IF_STAT");
  IElementType INCLUDE_EXPR = ShaderUtil.createType("INCLUDE_EXPR");
  IElementType INDEX_EXPR = ShaderUtil.createType("INDEX_EXPR");
  IElementType LIST_ARGS = ShaderUtil.createType("LIST_ARGS");
  IElementType LITERAL_EXPR = ShaderUtil.createType("LITERAL_EXPR");
  IElementType METHOD_BODY = ShaderUtil.createType("METHOD_BODY");
  IElementType METHOD_CALL_EXPR = ShaderUtil.createType("METHOD_CALL_EXPR");
  IElementType METHOD_DEF = ShaderUtil.createType("METHOD_DEF");
  IElementType METHOD_PARAMETER = ShaderUtil.createType("METHOD_PARAMETER");
  IElementType METHOD_PARAMETER_LIST = ShaderUtil.createType("METHOD_PARAMETER_LIST");
  IElementType NAME_DEF = ShaderUtil.createType("NAME_DEF");
  IElementType NAME_EXPR = ShaderUtil.createType("NAME_EXPR");
  IElementType PARAM_NAME_DEF = ShaderUtil.createType("PARAM_NAME_DEF");
  IElementType PAREN_EXPR = ShaderUtil.createType("PAREN_EXPR");
  IElementType PASS_CLASS = ShaderUtil.createType("PASS_CLASS");
  IElementType PRAGMA_EXPR = ShaderUtil.createType("PRAGMA_EXPR");
  IElementType PROPERTIES_CLASS = ShaderUtil.createType("PROPERTIES_CLASS");
  IElementType PROPERTIES_FIELD = ShaderUtil.createType("PROPERTIES_FIELD");
  IElementType PROPERTIES_FIELD_LIST = ShaderUtil.createType("PROPERTIES_FIELD_LIST");
  IElementType RETURN_STAT = ShaderUtil.createType("RETURN_STAT");
  IElementType SHADER_CLASS = ShaderUtil.createType("SHADER_CLASS");
  IElementType SINGLE_ARG = ShaderUtil.createType("SINGLE_ARG");
  IElementType STRING_EXPR = ShaderUtil.createType("STRING_EXPR");
  IElementType STRUCT_CLASS = ShaderUtil.createType("STRUCT_CLASS");
  IElementType STRUCT_FIELD = ShaderUtil.createType("STRUCT_FIELD");
  IElementType SUB_SHADER_CLASS = ShaderUtil.createType("SUB_SHADER_CLASS");
  IElementType TABLE_EXPR = ShaderUtil.createType("TABLE_EXPR");
  IElementType TABLE_FIELD = ShaderUtil.createType("TABLE_FIELD");
  IElementType TABLE_FIELD_SEP = ShaderUtil.createType("TABLE_FIELD_SEP");
  IElementType TAGS_CLASS = ShaderUtil.createType("TAGS_CLASS");
  IElementType TAGS_FIELD = ShaderUtil.createType("TAGS_FIELD");
  IElementType TAGS_FIELD_LIST = ShaderUtil.createType("TAGS_FIELD_LIST");
  IElementType UNARY_EXPR = ShaderUtil.createType("UNARY_EXPR");
  IElementType UNARY_OP = ShaderUtil.createType("UNARY_OP");
  IElementType VARIABLE_DECLARE = ShaderUtil.createType("VARIABLE_DECLARE");
  IElementType VARIABLE_DECLARE_1 = ShaderUtil.createType("VARIABLE_DECLARE_1");
  IElementType VAR_DECLARE_EXPR = ShaderUtil.createType("VAR_DECLARE_EXPR");
  IElementType VAR_DECLARE_EXPR_2 = ShaderUtil.createType("VAR_DECLARE_EXPR_2");
  IElementType VAR_LIST = ShaderUtil.createType("VAR_LIST");

  IElementType AND = ShaderUtil.createToken("&&");
  IElementType ASSIGN = ShaderUtil.createToken("=");
  IElementType BIT_AND = ShaderUtil.createToken("&");
  IElementType BIT_LTLT = ShaderUtil.createToken("<<");
  IElementType BIT_OR = ShaderUtil.createToken("|");
  IElementType BIT_RTRT = ShaderUtil.createToken(">>");
  IElementType BIT_TILDE = ShaderUtil.createToken("~");
  IElementType BLOCK_COMMENT = ShaderUtil.createToken("BLOCK_COMMENT");
  IElementType BREAK = ShaderUtil.createToken("break");
  IElementType CGPROGRAM = ShaderUtil.createToken("CGPROGRAM");
  IElementType COLON = ShaderUtil.createToken(":");
  IElementType COMMA = ShaderUtil.createToken(",");
  IElementType CONTINUE = ShaderUtil.createToken("continue");
  IElementType DEFINE = ShaderUtil.createToken("define");
  IElementType DIV = ShaderUtil.createToken("/");
  IElementType DO = ShaderUtil.createToken("do");
  IElementType DOT = ShaderUtil.createToken(".");
  IElementType ELSE = ShaderUtil.createToken("else");
  IElementType ENDCG = ShaderUtil.createToken("ENDCG");
  IElementType ENDIF = ShaderUtil.createToken("endif");
  IElementType EQ = ShaderUtil.createToken("==");
  IElementType EXP = ShaderUtil.createToken("^");
  IElementType FALSE = ShaderUtil.createToken("false");
  IElementType FOR = ShaderUtil.createToken("for");
  IElementType GE = ShaderUtil.createToken(">=");
  IElementType GETN = ShaderUtil.createToken("#");
  IElementType GT = ShaderUtil.createToken(">");
  IElementType ID = ShaderUtil.createToken("ID");
  IElementType IF = ShaderUtil.createToken("if");
  IElementType IFDEF = ShaderUtil.createToken("ifdef");
  IElementType IFNDEF = ShaderUtil.createToken("ifndef");
  IElementType IN = ShaderUtil.createToken("in");
  IElementType INCLUDE = ShaderUtil.createToken("include");
  IElementType INLINE = ShaderUtil.createToken("inline");
  IElementType INOUT = ShaderUtil.createToken("inout");
  IElementType LBRACKET = ShaderUtil.createToken("[");
  IElementType LCURLY = ShaderUtil.createToken("{");
  IElementType LE = ShaderUtil.createToken("<=");
  IElementType LPAREN = ShaderUtil.createToken("(");
  IElementType LT = ShaderUtil.createToken("<");
  IElementType MINUS = ShaderUtil.createToken("-");
  IElementType MOD = ShaderUtil.createToken("%");
  IElementType MULT = ShaderUtil.createToken("*");
  IElementType NE = ShaderUtil.createToken("!=");
  IElementType NOT = ShaderUtil.createToken("!");
  IElementType NULL = ShaderUtil.createToken("null");
  IElementType NUMBER = ShaderUtil.createToken("NUMBER");
  IElementType OR = ShaderUtil.createToken("||");
  IElementType OUT = ShaderUtil.createToken("out");
  IElementType PASS = ShaderUtil.createToken("Pass");
  IElementType PLUS = ShaderUtil.createToken("+");
  IElementType PRAGMA = ShaderUtil.createToken("pragma");
  IElementType PROPERTIES = ShaderUtil.createToken("Properties");
  IElementType RBRACKET = ShaderUtil.createToken("]");
  IElementType RCURLY = ShaderUtil.createToken("}");
  IElementType RETURN = ShaderUtil.createToken("return");
  IElementType RPAREN = ShaderUtil.createToken(")");
  IElementType SEMI = ShaderUtil.createToken(";");
  IElementType SHADER = ShaderUtil.createToken("Shader");
  IElementType SHORT_COMMENT = ShaderUtil.createToken("SHORT_COMMENT");
  IElementType STRING = ShaderUtil.createToken("STRING");
  IElementType STRUCT = ShaderUtil.createToken("struct");
  IElementType SUBSHADER = ShaderUtil.createToken("SubShader");
  IElementType TAGS = ShaderUtil.createToken("Tags");
  IElementType TRUE = ShaderUtil.createToken("true");
  IElementType VOID = ShaderUtil.createToken("void");
  IElementType WHILE = ShaderUtil.createToken("while");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == ARGS) {
        return new ShaderArgsImpl(node);
      }
      else if (type == ASSIGN_STAT) {
        return new ShaderAssignStatImpl(node);
      }
      else if (type == BINARY_EXPR) {
        return new ShaderBinaryExprImpl(node);
      }
      else if (type == BINARY_OP) {
        return new ShaderBinaryOpImpl(node);
      }
      else if (type == CALL_EXPR) {
        return new ShaderCallExprImpl(node);
      }
      else if (type == CGPROGRAM_FIELD) {
        return new ShaderCGPROGRAMFieldImpl(node);
      }
      else if (type == DEFINE_STAT) {
        return new ShaderDefineStatImpl(node);
      }
      else if (type == EMPTY_STAT) {
        return new ShaderEmptyStatImpl(node);
      }
      else if (type == EXPR) {
        return new ShaderExprImpl(node);
      }
      else if (type == EXPR_LIST) {
        return new ShaderExprListImpl(node);
      }
      else if (type == EXPR_STAT) {
        return new ShaderExprStatImpl(node);
      }
      else if (type == FUNC_BODY) {
        return new ShaderFuncBodyImpl(node);
      }
      else if (type == FUNC_DEF) {
        return new ShaderFuncDefImpl(node);
      }
      else if (type == GEN_IF_STAT) {
        return new ShaderGenIfStatImpl(node);
      }
      else if (type == IF_DEF_EXPR) {
        return new ShaderIfDefExprImpl(node);
      }
      else if (type == IF_N_DEF_EXPR) {
        return new ShaderIfNDefExprImpl(node);
      }
      else if (type == IF_STAT) {
        return new ShaderIfStatImpl(node);
      }
      else if (type == INCLUDE_EXPR) {
        return new ShaderIncludeExprImpl(node);
      }
      else if (type == INDEX_EXPR) {
        return new ShaderIndexExprImpl(node);
      }
      else if (type == LIST_ARGS) {
        return new ShaderListArgsImpl(node);
      }
      else if (type == LITERAL_EXPR) {
        return new ShaderLiteralExprImpl(node);
      }
      else if (type == METHOD_BODY) {
        return new ShaderMethodBodyImpl(node);
      }
      else if (type == METHOD_CALL_EXPR) {
        return new ShaderMethodCallExprImpl(node);
      }
      else if (type == METHOD_DEF) {
        return new ShaderMethodDefImpl(node);
      }
      else if (type == METHOD_PARAMETER) {
        return new ShaderMethodParameterImpl(node);
      }
      else if (type == METHOD_PARAMETER_LIST) {
        return new ShaderMethodParameterListImpl(node);
      }
      else if (type == NAME_DEF) {
        return new ShaderNameDefImpl(node);
      }
      else if (type == NAME_EXPR) {
        return new ShaderNameExprImpl(node);
      }
      else if (type == PARAM_NAME_DEF) {
        return new ShaderParamNameDefImpl(node);
      }
      else if (type == PAREN_EXPR) {
        return new ShaderParenExprImpl(node);
      }
      else if (type == PASS_CLASS) {
        return new ShaderPassClassImpl(node);
      }
      else if (type == PRAGMA_EXPR) {
        return new ShaderPragmaExprImpl(node);
      }
      else if (type == PROPERTIES_CLASS) {
        return new ShaderPropertiesClassImpl(node);
      }
      else if (type == PROPERTIES_FIELD) {
        return new ShaderPropertiesFieldImpl(node);
      }
      else if (type == PROPERTIES_FIELD_LIST) {
        return new ShaderPropertiesFieldListImpl(node);
      }
      else if (type == RETURN_STAT) {
        return new ShaderReturnStatImpl(node);
      }
      else if (type == SHADER_CLASS) {
        return new ShaderShaderClassImpl(node);
      }
      else if (type == SINGLE_ARG) {
        return new ShaderSingleArgImpl(node);
      }
      else if (type == STRING_EXPR) {
        return new ShaderStringExprImpl(node);
      }
      else if (type == STRUCT_CLASS) {
        return new ShaderStructClassImpl(node);
      }
      else if (type == STRUCT_FIELD) {
        return new ShaderStructFieldImpl(node);
      }
      else if (type == SUB_SHADER_CLASS) {
        return new ShaderSubShaderClassImpl(node);
      }
      else if (type == TABLE_EXPR) {
        return new ShaderTableExprImpl(node);
      }
      else if (type == TABLE_FIELD) {
        return new ShaderTableFieldImpl(node);
      }
      else if (type == TABLE_FIELD_SEP) {
        return new ShaderTableFieldSepImpl(node);
      }
      else if (type == TAGS_CLASS) {
        return new ShaderTagsClassImpl(node);
      }
      else if (type == TAGS_FIELD) {
        return new ShaderTagsFieldImpl(node);
      }
      else if (type == TAGS_FIELD_LIST) {
        return new ShaderTagsFieldListImpl(node);
      }
      else if (type == UNARY_EXPR) {
        return new ShaderUnaryExprImpl(node);
      }
      else if (type == UNARY_OP) {
        return new ShaderUnaryOpImpl(node);
      }
      else if (type == VARIABLE_DECLARE) {
        return new ShaderVariableDeclareImpl(node);
      }
      else if (type == VARIABLE_DECLARE_1) {
        return new ShaderVariableDeclare1Impl(node);
      }
      else if (type == VAR_DECLARE_EXPR) {
        return new ShaderVarDeclareExprImpl(node);
      }
      else if (type == VAR_DECLARE_EXPR_2) {
        return new ShaderVarDeclareExpr2Impl(node);
      }
      else if (type == VAR_LIST) {
        return new ShaderVarListImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
