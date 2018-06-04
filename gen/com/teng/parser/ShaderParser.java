// This is a generated file. Not intended for manual editing.
package com.teng.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.teng.psi.ShaderTypes.*;
import static com.teng.psi.ShaderParseUtil.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;
import static com.intellij.lang.WhitespacesBinders.*;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class ShaderParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t == CGPROGRAM_FIELD) {
      r = CGPROGRAMField(b, 0);
    }
    else if (t == ARGS) {
      r = args(b, 0);
    }
    else if (t == ASSIGN_STAT) {
      r = assignStat(b, 0);
    }
    else if (t == BINARY_EXPR) {
      r = binaryExpr(b, 0);
    }
    else if (t == BINARY_OP) {
      r = binaryOp(b, 0);
    }
    else if (t == CALL_EXPR) {
      r = callExpr(b, 0);
    }
    else if (t == DEFINE_STAT) {
      r = defineStat(b, 0);
    }
    else if (t == EMPTY_STAT) {
      r = emptyStat(b, 0);
    }
    else if (t == EXPR) {
      r = expr(b, 0);
    }
    else if (t == EXPR_LIST) {
      r = exprList(b, 0);
    }
    else if (t == EXPR_STAT) {
      r = exprStat(b, 0);
    }
    else if (t == FUNC_BODY) {
      r = funcBody(b, 0);
    }
    else if (t == FUNC_DEF) {
      r = funcDef(b, 0);
    }
    else if (t == GEN_IF_STAT) {
      r = genIfStat(b, 0);
    }
    else if (t == IF_DEF_EXPR) {
      r = ifDefExpr(b, 0);
    }
    else if (t == IF_N_DEF_EXPR) {
      r = ifNDefExpr(b, 0);
    }
    else if (t == IF_STAT) {
      r = ifStat(b, 0);
    }
    else if (t == INCLUDE_EXPR) {
      r = includeExpr(b, 0);
    }
    else if (t == INDEX_EXPR) {
      r = indexExpr(b, 0);
    }
    else if (t == LIST_ARGS) {
      r = listArgs(b, 0);
    }
    else if (t == LITERAL_EXPR) {
      r = literalExpr(b, 0);
    }
    else if (t == METHOD_BODY) {
      r = methodBody(b, 0);
    }
    else if (t == METHOD_CALL_EXPR) {
      r = methodCallExpr(b, 0);
    }
    else if (t == METHOD_DEF) {
      r = methodDef(b, 0);
    }
    else if (t == METHOD_PARAMETER) {
      r = methodParameter(b, 0);
    }
    else if (t == METHOD_PARAMETER_LIST) {
      r = methodParameterList(b, 0);
    }
    else if (t == NAME_DEF) {
      r = nameDef(b, 0);
    }
    else if (t == NAME_EXPR) {
      r = nameExpr(b, 0);
    }
    else if (t == PARAM_NAME_DEF) {
      r = paramNameDef(b, 0);
    }
    else if (t == PAREN_EXPR) {
      r = parenExpr(b, 0);
    }
    else if (t == PASS_CLASS) {
      r = passClass(b, 0);
    }
    else if (t == PRAGMA_EXPR) {
      r = pragmaExpr(b, 0);
    }
    else if (t == PROPERTIES_CLASS) {
      r = propertiesClass(b, 0);
    }
    else if (t == PROPERTIES_FIELD) {
      r = propertiesField(b, 0);
    }
    else if (t == PROPERTIES_FIELD_LIST) {
      r = propertiesFieldList(b, 0);
    }
    else if (t == RETURN_STAT) {
      r = returnStat(b, 0);
    }
    else if (t == SHADER_CLASS) {
      r = shaderClass(b, 0);
    }
    else if (t == SINGLE_ARG) {
      r = singleArg(b, 0);
    }
    else if (t == STRING_EXPR) {
      r = stringExpr(b, 0);
    }
    else if (t == STRUCT_CLASS) {
      r = structClass(b, 0);
    }
    else if (t == STRUCT_FIELD) {
      r = structField(b, 0);
    }
    else if (t == SUB_SHADER_CLASS) {
      r = subShaderClass(b, 0);
    }
    else if (t == TABLE_EXPR) {
      r = tableExpr(b, 0);
    }
    else if (t == TABLE_FIELD) {
      r = tableField(b, 0);
    }
    else if (t == TABLE_FIELD_SEP) {
      r = tableFieldSep(b, 0);
    }
    else if (t == TAGS_CLASS) {
      r = tagsClass(b, 0);
    }
    else if (t == TAGS_FIELD) {
      r = tagsField(b, 0);
    }
    else if (t == TAGS_FIELD_LIST) {
      r = tagsFieldList(b, 0);
    }
    else if (t == UNARY_EXPR) {
      r = unaryExpr(b, 0);
    }
    else if (t == UNARY_OP) {
      r = unaryOp(b, 0);
    }
    else if (t == VAR_DECLARE_EXPR) {
      r = varDeclareExpr(b, 0);
    }
    else if (t == VAR_DECLARE_EXPR_2) {
      r = varDeclareExpr2(b, 0);
    }
    else if (t == VAR_LIST) {
      r = varList(b, 0);
    }
    else if (t == VARIABLE_DECLARE) {
      r = variableDeclare(b, 0);
    }
    else if (t == VARIABLE_DECLARE_1) {
      r = variableDeclare1(b, 0);
    }
    else {
      r = parse_root_(t, b, 0);
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return shaderFile(b, l + 1);
  }

  /* ********************************************************** */
  // 'CGPROGRAM' expr* 'ENDCG'
  public static boolean CGPROGRAMField(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CGPROGRAMField")) return false;
    if (!nextTokenIs(b, CGPROGRAM)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CGPROGRAM);
    r = r && CGPROGRAMField_1(b, l + 1);
    r = r && consumeToken(b, ENDCG);
    exit_section_(b, m, CGPROGRAM_FIELD, r);
    return r;
  }

  // expr*
  private static boolean CGPROGRAMField_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CGPROGRAMField_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!expr(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "CGPROGRAMField_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // listArgs | singleArg{
  // }
  public static boolean args(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "args")) return false;
    if (!nextTokenIs(b, "<args>", LCURLY, STRING)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARGS, "<args>");
    r = listArgs(b, l + 1);
    if (!r) r = args_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // singleArg{
  // }
  private static boolean args_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "args_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = singleArg(b, l + 1);
    r = r && args_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // {
  // }
  private static boolean args_1_1(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // varExpr '=' expr{
  // }
  public static boolean assignStat(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignStat")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ASSIGN_STAT, "<assign stat>");
    r = varExpr(b, l + 1);
    r = r && consumeToken(b, ASSIGN);
    r = r && expr(b, l + 1);
    r = r && assignStat_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // {
  // }
  private static boolean assignStat_3(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // binaryOp expr
  // {
  // }
  public static boolean binaryExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binaryExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, BINARY_EXPR, "<binary expr>");
    r = binaryOp(b, l + 1);
    r = r && expr(b, l + 1);
    r = r && binaryExpr_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // {
  // }
  private static boolean binaryExpr_2(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // '+' | '-' | '*' | '/' | '^' | '%' | '<' | '<=' | '>' | '>=' | '==' | '!=' | '&&' | '||'
  //     | '|' | '&' | '>>' | '<<' | '~'
  public static boolean binaryOp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binaryOp")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BINARY_OP, "<binary op>");
    r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    if (!r) r = consumeToken(b, MULT);
    if (!r) r = consumeToken(b, DIV);
    if (!r) r = consumeToken(b, EXP);
    if (!r) r = consumeToken(b, MOD);
    if (!r) r = consumeToken(b, LT);
    if (!r) r = consumeToken(b, LE);
    if (!r) r = consumeToken(b, GT);
    if (!r) r = consumeToken(b, GE);
    if (!r) r = consumeToken(b, EQ);
    if (!r) r = consumeToken(b, NE);
    if (!r) r = consumeToken(b, AND);
    if (!r) r = consumeToken(b, OR);
    if (!r) r = consumeToken(b, BIT_OR);
    if (!r) r = consumeToken(b, BIT_AND);
    if (!r) r = consumeToken(b, BIT_RTRT);
    if (!r) r = consumeToken(b, BIT_LTLT);
    if (!r) r = consumeToken(b, BIT_TILDE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // args{
  // }
  public static boolean callExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "callExpr")) return false;
    if (!nextTokenIs(b, "<call expr>", LCURLY, STRING)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, CALL_EXPR, "<call expr>");
    r = args(b, l + 1);
    r = r && callExpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // {
  // }
  private static boolean callExpr_1(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // '#' 'define' expr expr
  public static boolean defineStat(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "defineStat")) return false;
    if (!nextTokenIs(b, GETN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, GETN, DEFINE);
    r = r && expr(b, l + 1);
    r = r && expr(b, l + 1);
    exit_section_(b, m, DEFINE_STAT, r);
    return r;
  }

  /* ********************************************************** */
  // ';'
  public static boolean emptyStat(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "emptyStat")) return false;
    if (!nextTokenIs(b, SEMI)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SEMI);
    exit_section_(b, m, EMPTY_STAT, r);
    return r;
  }

  /* ********************************************************** */
  // <<parseExpr>>
  // {
  // }
  public static boolean expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPR, "<expr>");
    r = parseExpr(b, l + 1);
    r = r && expr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // {
  // }
  private static boolean expr_1(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // expr (',' expr)*{
  // }
  public static boolean exprList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exprList")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPR_LIST, "<expr list>");
    r = expr(b, l + 1);
    r = r && exprList_1(b, l + 1);
    r = r && exprList_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (',' expr)*
  private static boolean exprList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exprList_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!exprList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "exprList_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' expr
  private static boolean exprList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exprList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // {
  // }
  private static boolean exprList_2(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // expr ';'{
  // }
  public static boolean exprStat(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exprStat")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPR_STAT, "<expr stat>");
    r = expr(b, l + 1);
    r = r && consumeToken(b, SEMI);
    r = r && exprStat_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // {
  // }
  private static boolean exprStat_2(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // (tableField (tableFieldSep tableField)* (tableFieldSep)?)?
  static boolean fieldList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fieldList")) return false;
    fieldList_0(b, l + 1);
    return true;
  }

  // tableField (tableFieldSep tableField)* (tableFieldSep)?
  private static boolean fieldList_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fieldList_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = tableField(b, l + 1);
    r = r && fieldList_0_1(b, l + 1);
    r = r && fieldList_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (tableFieldSep tableField)*
  private static boolean fieldList_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fieldList_0_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!fieldList_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "fieldList_0_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // tableFieldSep tableField
  private static boolean fieldList_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fieldList_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = tableFieldSep(b, l + 1);
    r = r && tableField(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (tableFieldSep)?
  private static boolean fieldList_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fieldList_0_2")) return false;
    fieldList_0_2_0(b, l + 1);
    return true;
  }

  // (tableFieldSep)
  private static boolean fieldList_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fieldList_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = tableFieldSep(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '('(parList)? ')' '{' <<lazyBlock>>? '}' {
  // }
  public static boolean funcBody(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "funcBody")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && funcBody_1(b, l + 1);
    r = r && consumeTokens(b, 0, RPAREN, LCURLY);
    r = r && funcBody_4(b, l + 1);
    r = r && consumeToken(b, RCURLY);
    r = r && funcBody_6(b, l + 1);
    exit_section_(b, m, FUNC_BODY, r);
    return r;
  }

  // (parList)?
  private static boolean funcBody_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "funcBody_1")) return false;
    funcBody_1_0(b, l + 1);
    return true;
  }

  // (parList)
  private static boolean funcBody_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "funcBody_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parList(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // <<lazyBlock>>?
  private static boolean funcBody_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "funcBody_4")) return false;
    lazyBlock(b, l + 1);
    return true;
  }

  // {
  // }
  private static boolean funcBody_6(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // ID funcBody {
  // }
  public static boolean funcDef(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "funcDef")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    r = r && funcBody(b, l + 1);
    r = r && funcDef_2(b, l + 1);
    exit_section_(b, m, FUNC_DEF, r);
    return r;
  }

  // {
  // }
  private static boolean funcDef_2(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // '#' 'if' expr
  public static boolean genIfStat(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "genIfStat")) return false;
    if (!nextTokenIs(b, GETN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, GETN, IF);
    r = r && expr(b, l + 1);
    exit_section_(b, m, GEN_IF_STAT, r);
    return r;
  }

  /* ********************************************************** */
  // '#' 'ifdef' ID
  public static boolean ifDefExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifDefExpr")) return false;
    if (!nextTokenIs(b, GETN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, GETN, IFDEF, ID);
    exit_section_(b, m, IF_DEF_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // '#' 'ifndef' ID
  public static boolean ifNDefExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifNDefExpr")) return false;
    if (!nextTokenIs(b, GETN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, GETN, IFNDEF, ID);
    exit_section_(b, m, IF_N_DEF_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // 'if' ID 'then' ID 'end'
  public static boolean ifStat(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifStat")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IF, ID);
    r = r && consumeToken(b, "then");
    r = r && consumeToken(b, ID);
    r = r && consumeToken(b, "end");
    exit_section_(b, m, IF_STAT, r);
    return r;
  }

  /* ********************************************************** */
  // '#' 'include' STRING
  public static boolean includeExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "includeExpr")) return false;
    if (!nextTokenIs(b, GETN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, GETN, INCLUDE, STRING);
    exit_section_(b, m, INCLUDE_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // '[' expr ']' | '.' ID{
  // }
  public static boolean indexExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "indexExpr")) return false;
    if (!nextTokenIs(b, "<index expr>", DOT, LBRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, INDEX_EXPR, "<index expr>");
    r = indexExpr_0(b, l + 1);
    if (!r) r = indexExpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '[' expr ']'
  private static boolean indexExpr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "indexExpr_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACKET);
    r = r && expr(b, l + 1);
    r = r && consumeToken(b, RBRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  // '.' ID{
  // }
  private static boolean indexExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "indexExpr_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOT, ID);
    r = r && indexExpr_1_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // {
  // }
  private static boolean indexExpr_1_2(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // tableExpr | stringExpr {
  // }
  public static boolean listArgs(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listArgs")) return false;
    if (!nextTokenIs(b, "<list args>", LCURLY, STRING)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LIST_ARGS, "<list args>");
    r = tableExpr(b, l + 1);
    if (!r) r = listArgs_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // stringExpr {
  // }
  private static boolean listArgs_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "listArgs_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = stringExpr(b, l + 1);
    r = r && listArgs_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // {
  // }
  private static boolean listArgs_1_1(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // null | false | true | NUMBER |STRING {
  // }
  public static boolean literalExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literalExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LITERAL_EXPR, "<literal expr>");
    r = consumeToken(b, NULL);
    if (!r) r = consumeToken(b, FALSE);
    if (!r) r = consumeToken(b, TRUE);
    if (!r) r = consumeToken(b, NUMBER);
    if (!r) r = literalExpr_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // STRING {
  // }
  private static boolean literalExpr_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literalExpr_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRING);
    r = r && literalExpr_4_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // {
  // }
  private static boolean literalExpr_4_1(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // '{' <<lazyBlock>>? '}'
  public static boolean methodBody(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "methodBody")) return false;
    if (!nextTokenIs(b, LCURLY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LCURLY);
    r = r && methodBody_1(b, l + 1);
    r = r && consumeToken(b, RCURLY);
    exit_section_(b, m, METHOD_BODY, r);
    return r;
  }

  // <<lazyBlock>>?
  private static boolean methodBody_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "methodBody_1")) return false;
    lazyBlock(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ID ('.' ID)* '(' listArgs ')'
  public static boolean methodCallExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "methodCallExpr")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    r = r && methodCallExpr_1(b, l + 1);
    r = r && consumeToken(b, LPAREN);
    r = r && listArgs(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, METHOD_CALL_EXPR, r);
    return r;
  }

  // ('.' ID)*
  private static boolean methodCallExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "methodCallExpr_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!methodCallExpr_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "methodCallExpr_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // '.' ID
  private static boolean methodCallExpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "methodCallExpr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOT, ID);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ID ID '('listArgs ')' ':' ID
  public static boolean methodDef(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "methodDef")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ID, ID, LPAREN);
    r = r && listArgs(b, l + 1);
    r = r && consumeTokens(b, 0, RPAREN, COLON, ID);
    exit_section_(b, m, METHOD_DEF, r);
    return r;
  }

  /* ********************************************************** */
  // ID ID
  public static boolean methodParameter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "methodParameter")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ID, ID);
    exit_section_(b, m, METHOD_PARAMETER, r);
    return r;
  }

  /* ********************************************************** */
  // methodParameter (',' methodParameter)*
  public static boolean methodParameterList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "methodParameterList")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = methodParameter(b, l + 1);
    r = r && methodParameterList_1(b, l + 1);
    exit_section_(b, m, METHOD_PARAMETER_LIST, r);
    return r;
  }

  // (',' methodParameter)*
  private static boolean methodParameterList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "methodParameterList_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!methodParameterList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "methodParameterList_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' methodParameter
  private static boolean methodParameterList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "methodParameterList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && methodParameter(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ID {
  // }
  public static boolean nameDef(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nameDef")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    r = r && nameDef_1(b, l + 1);
    exit_section_(b, m, NAME_DEF, r);
    return r;
  }

  // {
  // }
  private static boolean nameDef_1(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // ID
  public static boolean nameExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nameExpr")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    exit_section_(b, m, NAME_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // paramNameDef (',' paramNameDef)* {
  // }
  static boolean parList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parList")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = paramNameDef(b, l + 1);
    r = r && parList_1(b, l + 1);
    r = r && parList_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' paramNameDef)*
  private static boolean parList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parList_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!parList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "parList_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' paramNameDef
  private static boolean parList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && paramNameDef(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // {
  // }
  private static boolean parList_2(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // ID{
  // }
  public static boolean paramNameDef(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paramNameDef")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    r = r && paramNameDef_1(b, l + 1);
    exit_section_(b, m, PARAM_NAME_DEF, r);
    return r;
  }

  // {
  // }
  private static boolean paramNameDef_1(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // '(' expr ')'{
  // }
  public static boolean parenExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parenExpr")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && expr(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    r = r && parenExpr_3(b, l + 1);
    exit_section_(b, m, PAREN_EXPR, r);
    return r;
  }

  // {
  // }
  private static boolean parenExpr_3(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // 'Pass' '{' CGPROGRAMField '}'
  public static boolean passClass(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "passClass")) return false;
    if (!nextTokenIs(b, PASS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, PASS, LCURLY);
    r = r && CGPROGRAMField(b, l + 1);
    r = r && consumeToken(b, RCURLY);
    exit_section_(b, m, PASS_CLASS, r);
    return r;
  }

  /* ********************************************************** */
  // '#' 'pragma' (ID)*
  public static boolean pragmaExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pragmaExpr")) return false;
    if (!nextTokenIs(b, GETN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, GETN, PRAGMA);
    r = r && pragmaExpr_2(b, l + 1);
    exit_section_(b, m, PRAGMA_EXPR, r);
    return r;
  }

  // (ID)*
  private static boolean pragmaExpr_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pragmaExpr_2")) return false;
    int c = current_position_(b);
    while (true) {
      if (!consumeToken(b, ID)) break;
      if (!empty_element_parsed_guard_(b, "pragmaExpr_2", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // parenExpr | nameExpr | tableExpr | literalExpr
  static boolean prefixExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prefixExpr")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parenExpr(b, l + 1);
    if (!r) r = nameExpr(b, l + 1);
    if (!r) r = tableExpr(b, l + 1);
    if (!r) r = literalExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // prefixExpr(suffixExpr*)
  static boolean primaryExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryExpr")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = prefixExpr(b, l + 1);
    r = r && primaryExpr_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // suffixExpr*
  private static boolean primaryExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primaryExpr_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!suffixExpr(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "primaryExpr_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // 'Properties' '{' propertiesFieldList '}'{
  // }
  public static boolean propertiesClass(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "propertiesClass")) return false;
    if (!nextTokenIs(b, PROPERTIES)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, PROPERTIES, LCURLY);
    r = r && propertiesFieldList(b, l + 1);
    r = r && consumeToken(b, RCURLY);
    r = r && propertiesClass_4(b, l + 1);
    exit_section_(b, m, PROPERTIES_CLASS, r);
    return r;
  }

  // {
  // }
  private static boolean propertiesClass_4(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // ID '(' STRING ',' expr ')' '=' expr
  public static boolean propertiesField(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "propertiesField")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ID, LPAREN, STRING, COMMA);
    r = r && expr(b, l + 1);
    r = r && consumeTokens(b, 0, RPAREN, ASSIGN);
    r = r && expr(b, l + 1);
    exit_section_(b, m, PROPERTIES_FIELD, r);
    return r;
  }

  /* ********************************************************** */
  // propertiesField*
  public static boolean propertiesFieldList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "propertiesFieldList")) return false;
    Marker m = enter_section_(b, l, _NONE_, PROPERTIES_FIELD_LIST, "<properties field list>");
    int c = current_position_(b);
    while (true) {
      if (!propertiesField(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "propertiesFieldList", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // return expr ';'
  public static boolean returnStat(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "returnStat")) return false;
    if (!nextTokenIs(b, RETURN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RETURN);
    r = r && expr(b, l + 1);
    r = r && consumeToken(b, SEMI);
    exit_section_(b, m, RETURN_STAT, r);
    return r;
  }

  /* ********************************************************** */
  // 'Shader' ID tableExpr{
  // }
  public static boolean shaderClass(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "shaderClass")) return false;
    if (!nextTokenIs(b, SHADER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, SHADER, ID);
    r = r && tableExpr(b, l + 1);
    r = r && shaderClass_3(b, l + 1);
    exit_section_(b, m, SHADER_CLASS, r);
    return r;
  }

  // {
  // }
  private static boolean shaderClass_3(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // stat_semi*
  static boolean shaderFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "shaderFile")) return false;
    int c = current_position_(b);
    while (true) {
      if (!stat_semi(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "shaderFile", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // tableExpr | stringExpr
  public static boolean singleArg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "singleArg")) return false;
    if (!nextTokenIs(b, "<single arg>", LCURLY, STRING)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SINGLE_ARG, "<single arg>");
    r = tableExpr(b, l + 1);
    if (!r) r = stringExpr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // <<parseStatement>>
  static boolean stat_semi(PsiBuilder b, int l) {
    return parseStatement(b, l + 1);
  }

  /* ********************************************************** */
  // STRING{
  // }
  public static boolean stringExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stringExpr")) return false;
    if (!nextTokenIs(b, STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRING);
    r = r && stringExpr_1(b, l + 1);
    exit_section_(b, m, STRING_EXPR, r);
    return r;
  }

  // {
  // }
  private static boolean stringExpr_1(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // 'struct' ID '{' structField* '}' ';'
  public static boolean structClass(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "structClass")) return false;
    if (!nextTokenIs(b, STRUCT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, STRUCT, ID, LCURLY);
    r = r && structClass_3(b, l + 1);
    r = r && consumeTokens(b, 0, RCURLY, SEMI);
    exit_section_(b, m, STRUCT_CLASS, r);
    return r;
  }

  // structField*
  private static boolean structClass_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "structClass_3")) return false;
    int c = current_position_(b);
    while (true) {
      if (!structField(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "structClass_3", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // variableDeclare | expr
  public static boolean structField(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "structField")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STRUCT_FIELD, "<struct field>");
    r = variableDeclare(b, l + 1);
    if (!r) r = expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'SubShader' tableExpr{
  // }
  public static boolean subShaderClass(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "subShaderClass")) return false;
    if (!nextTokenIs(b, SUBSHADER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SUBSHADER);
    r = r && tableExpr(b, l + 1);
    r = r && subShaderClass_2(b, l + 1);
    exit_section_(b, m, SUB_SHADER_CLASS, r);
    return r;
  }

  // {
  // }
  private static boolean subShaderClass_2(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // indexExpr | callExpr
  static boolean suffixExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "suffixExpr")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = indexExpr(b, l + 1);
    if (!r) r = callExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '{'fieldList '}'
  // {
  // }
  public static boolean tableExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tableExpr")) return false;
    if (!nextTokenIs(b, LCURLY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LCURLY);
    r = r && fieldList(b, l + 1);
    r = r && consumeToken(b, RCURLY);
    r = r && tableExpr_3(b, l + 1);
    exit_section_(b, m, TABLE_EXPR, r);
    return r;
  }

  // {
  // }
  private static boolean tableExpr_3(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // tableField1 | tableField2 | expr{
  // }
  public static boolean tableField(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tableField")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TABLE_FIELD, "<table field>");
    r = tableField1(b, l + 1);
    if (!r) r = tableField2(b, l + 1);
    if (!r) r = tableField_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // expr{
  // }
  private static boolean tableField_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tableField_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expr(b, l + 1);
    r = r && tableField_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // {
  // }
  private static boolean tableField_2_1(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // '[' expr ']' '=' expr
  static boolean tableField1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tableField1")) return false;
    if (!nextTokenIs(b, LBRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACKET);
    r = r && expr(b, l + 1);
    r = r && consumeTokens(b, 0, RBRACKET, ASSIGN);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ID '=' expr
  static boolean tableField2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tableField2")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ID, ASSIGN);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ';'
  public static boolean tableFieldSep(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tableFieldSep")) return false;
    if (!nextTokenIs(b, SEMI)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SEMI);
    exit_section_(b, m, TABLE_FIELD_SEP, r);
    return r;
  }

  /* ********************************************************** */
  // 'Tags' '{' tagsFieldList '}'
  public static boolean tagsClass(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tagsClass")) return false;
    if (!nextTokenIs(b, TAGS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, TAGS, LCURLY);
    r = r && tagsFieldList(b, l + 1);
    r = r && consumeToken(b, RCURLY);
    exit_section_(b, m, TAGS_CLASS, r);
    return r;
  }

  /* ********************************************************** */
  // STRING  '=' STRING
  public static boolean tagsField(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tagsField")) return false;
    if (!nextTokenIs(b, STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, STRING, ASSIGN, STRING);
    exit_section_(b, m, TAGS_FIELD, r);
    return r;
  }

  /* ********************************************************** */
  // tagsField*
  public static boolean tagsFieldList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tagsFieldList")) return false;
    Marker m = enter_section_(b, l, _NONE_, TAGS_FIELD_LIST, "<tags field list>");
    int c = current_position_(b);
    while (true) {
      if (!tagsField(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "tagsFieldList", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // unaryOp (unaryExpr )
  public static boolean unaryExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unaryExpr")) return false;
    if (!nextTokenIs(b, "<unary expr>", NOT, MINUS)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, UNARY_EXPR, "<unary expr>");
    r = unaryOp(b, l + 1);
    r = r && unaryExpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (unaryExpr )
  private static boolean unaryExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unaryExpr_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = unaryExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '-' | '!'
  public static boolean unaryOp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unaryOp")) return false;
    if (!nextTokenIs(b, "<unary op>", NOT, MINUS)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, UNARY_OP, "<unary op>");
    r = consumeToken(b, MINUS);
    if (!r) r = consumeToken(b, NOT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ID  expr ';'
  public static boolean varDeclareExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "varDeclareExpr")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    r = r && expr(b, l + 1);
    r = r && consumeToken(b, SEMI);
    exit_section_(b, m, VAR_DECLARE_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // ID  expr ';'
  public static boolean varDeclareExpr2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "varDeclareExpr2")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ID);
    r = r && expr(b, l + 1);
    r = r && consumeToken(b, SEMI);
    exit_section_(b, m, VAR_DECLARE_EXPR_2, r);
    return r;
  }

  /* ********************************************************** */
  // primaryExpr
  static boolean varExpr(PsiBuilder b, int l) {
    return primaryExpr(b, l + 1);
  }

  /* ********************************************************** */
  // varExpr (',' varExpr)*{
  // }
  public static boolean varList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "varList")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VAR_LIST, "<var list>");
    r = varExpr(b, l + 1);
    r = r && varList_1(b, l + 1);
    r = r && varList_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (',' varExpr)*
  private static boolean varList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "varList_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!varList_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "varList_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  // ',' varExpr
  private static boolean varList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "varList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && varExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // {
  // }
  private static boolean varList_2(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // variableDeclare1 | varDeclareExpr2
  public static boolean variableDeclare(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variableDeclare")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = variableDeclare1(b, l + 1);
    if (!r) r = varDeclareExpr2(b, l + 1);
    exit_section_(b, m, VARIABLE_DECLARE, r);
    return r;
  }

  /* ********************************************************** */
  // ID ID ':' ID
  public static boolean variableDeclare1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variableDeclare1")) return false;
    if (!nextTokenIs(b, ID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ID, ID, COLON, ID);
    exit_section_(b, m, VARIABLE_DECLARE_1, r);
    return r;
  }

}
