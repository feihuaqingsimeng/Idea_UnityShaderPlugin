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
    if (t == BINARY_EXPR) {
      r = binaryExpr(b, 0);
    }
    else if (t == BINARY_OP) {
      r = binaryOp(b, 0);
    }
    else if (t == EXPR) {
      r = expr(b, 0);
    }
    else if (t == IF_STAT) {
      r = ifStat(b, 0);
    }
    else if (t == LITERAL_EXPR) {
      r = literalExpr(b, 0);
    }
    else if (t == NAME_DEF) {
      r = nameDef(b, 0);
    }
    else if (t == NAME_EXPR) {
      r = nameExpr(b, 0);
    }
    else if (t == TABLE_EXPR) {
      r = tableExpr(b, 0);
    }
    else if (t == UNARY_EXPR) {
      r = unaryExpr(b, 0);
    }
    else if (t == UNARY_OP) {
      r = unaryOp(b, 0);
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
  // binaryOp expr
  public static boolean binaryExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binaryExpr")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _LEFT_, BINARY_EXPR, "<binary expr>");
    r = binaryOp(b, l + 1);
    p = r; // pin = 1
    r = r && expr(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
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
  // <<parseExpr primaryExpr closureExpr>>
  public static boolean expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPR, "<expr>");
    r = parseExpr(b, l + 1, PRIMARYEXPR_parser_, CLOSUREEXPR_parser_);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'if' ID 'then' ID 'end'{}
  public static boolean ifStat(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifStat")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IF, ID);
    r = r && consumeToken(b, "then");
    r = r && consumeToken(b, ID);
    r = r && consumeToken(b, "end");
    r = r && ifStat_5(b, l + 1);
    exit_section_(b, m, IF_STAT, r);
    return r;
  }

  // {}
  private static boolean ifStat_5(PsiBuilder b, int l) {
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
  // expr
  static boolean stat_impl(PsiBuilder b, int l) {
    return expr(b, l + 1);
  }

  /* ********************************************************** */
  // stat_impl ';' ?
  static boolean stat_semi(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stat_semi")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = stat_impl(b, l + 1);
    r = r && stat_semi_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ';' ?
  private static boolean stat_semi_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stat_semi_1")) return false;
    consumeToken(b, SEMI);
    return true;
  }

  /* ********************************************************** */
  // '{'ID '}'
  // {
  // }
  public static boolean tableExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tableExpr")) return false;
    if (!nextTokenIs(b, LCURLY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LCURLY, ID, RCURLY);
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

  final static Parser CLOSUREEXPR_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return consumeToken(b, CLOSUREEXPR);
    }
  };
  final static Parser PRIMARYEXPR_parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return consumeToken(b, PRIMARYEXPR);
    }
  };
}
