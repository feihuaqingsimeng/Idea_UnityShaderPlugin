package com.teng.psi.parser;

import com.intellij.codeInsight.template.postfix.templates.ElseExpressionPostfixTemplateBase;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import com.teng.Util.TokenUtil;
import com.teng.psi.ShaderParseUtil;
import com.teng.psi.ShaderTypes;

import java.util.HashMap;


public class ShaderExpressionParser {
    enum ExprType {
        T_OR,
        T_AND,
        T_CONDITION,
        T_BIT_OR,
        T_BIT_TILDE,
        T_BIT_AND,
        T_BIT_SHIFT,
        T_ADDITIVE,
        T_MULTIPLICATIVE,
        T_UNARY,
        T_EXP,
        T_VALUE,
    }

    HashMap<ExprType, TokenSet> exprTypeDic = new HashMap<>();

    public static ShaderExpressionParser Instance = new ShaderExpressionParser();

    private ShaderExpressionParser() {
        exprTypeDic.put(ExprType.T_OR, TokenSet.create(new IElementType[]{ShaderTypes.OR}));
        exprTypeDic.put(ExprType.T_AND, TokenSet.create(new IElementType[]{ShaderTypes.AND}));
        exprTypeDic.put(ExprType.T_CONDITION, TokenSet.create(new IElementType[]{ShaderTypes.GT, ShaderTypes.LT, ShaderTypes.GE, ShaderTypes.LE, ShaderTypes.NE, ShaderTypes.EQ}));
        exprTypeDic.put(ExprType.T_BIT_OR, TokenSet.create(new IElementType[]{ShaderTypes.BIT_OR}));
        exprTypeDic.put(ExprType.T_BIT_TILDE, TokenSet.create(new IElementType[]{ShaderTypes.BIT_TILDE}));
        exprTypeDic.put(ExprType.T_BIT_AND, TokenSet.create(new IElementType[]{ShaderTypes.BIT_AND}));
        exprTypeDic.put(ExprType.T_BIT_SHIFT, TokenSet.create(new IElementType[]{ShaderTypes.BIT_LTLT, ShaderTypes.BIT_RTRT}));
        exprTypeDic.put(ExprType.T_ADDITIVE, TokenSet.create(new IElementType[]{ShaderTypes.PLUS, ShaderTypes.MINUS}));
        exprTypeDic.put(ExprType.T_MULTIPLICATIVE, TokenSet.create(new IElementType[]{ShaderTypes.MULT, ShaderTypes.DIV, ShaderTypes.MOD}));
        exprTypeDic.put(ExprType.T_UNARY, TokenSet.create(new IElementType[]{ShaderTypes.NOT, ShaderTypes.MINUS}));
        exprTypeDic.put(ExprType.T_EXP, TokenSet.create(new IElementType[]{ShaderTypes.EXP}));
    }

    public Marker parseExpr(PsiBuilder b, int l) {
        return parseExpr(b, ExprType.T_OR, l ) ;
    }

    public Marker parseExpr(PsiBuilder builder, ExprType type, int l) {
        PsiBuilder.Marker marker = null;
        TokenSet tSet = exprTypeDic.get(type);
        switch (type) {
            case T_OR:
                marker = this.parseBinary(builder, tSet, ExprType.T_AND, l);
                break;
            case T_AND:
                marker = this.parseBinary(builder, tSet, ExprType.T_CONDITION, l);
                break;
            case T_CONDITION:
                marker = this.parseBinary(builder, tSet, ExprType.T_BIT_OR, l);
                break;
            case T_BIT_OR:
                marker = this.parseBinary(builder, tSet, ExprType.T_BIT_TILDE, l);
                break;
            case T_BIT_TILDE:
                marker = this.parseBinary(builder, tSet, ExprType.T_BIT_AND, l);
                break;
            case T_BIT_AND:
                marker = this.parseBinary(builder, tSet, ExprType.T_BIT_SHIFT, l);
                break;
            case T_BIT_SHIFT:
                marker = this.parseBinary(builder, tSet, ExprType.T_ADDITIVE, l);
                break;
            case T_ADDITIVE:
                marker = this.parseBinary(builder, tSet, ExprType.T_MULTIPLICATIVE, l);
                break;
            case T_MULTIPLICATIVE:
                marker = this.parseBinary(builder, tSet, ExprType.T_EXP, l);
                break;
            case T_EXP:
                marker = this.parseBinary(builder, tSet, ExprType.T_UNARY, l);
                break;
            case T_UNARY:
                marker = this.parseUnary(builder, tSet, ExprType.T_VALUE, l);
                break;
            case T_VALUE:
                marker = this.parseValue(builder, l);
                break;
        }
        return marker;
    }
    private final Marker parseBinary(PsiBuilder b,TokenSet ops,ExprType next,int l)
    {
        Marker marker = parseExpr(b,next,l+1);
        if (marker == null){
            return null;
        }
        while (ops.contains(b.getTokenType())){
            Marker m = b.mark();
            b.advanceLexer();
            m.done(ShaderTypes.BINARY_OP);
            Marker right = parseUnary(b,ops,next,l);
            if (right == null)
                error(b,"Expression expected");
            marker = marker.precede();
            marker.done(ShaderTypes.BINARY_EXPR);
            if (right == null)
                break;
        }
        return marker;
    }
    private final Marker parseUnary(PsiBuilder builder,TokenSet ops,ExprType next,int l){
        boolean isUnary = ops.contains(builder.getTokenType());
        if (isUnary){
            Marker m = builder.mark();
            Marker opM = builder.mark();
            builder.advanceLexer();
            opM.done(ShaderTypes.UNARY_OP);
            Marker right = parseUnary(builder,ops,next,l);
            if (right == null)
                error(builder,"Expression expected");
            m.done(ShaderTypes.UNARY_EXPR);
            return m;
        }else{
            return parseExpr(builder,next,l);
        }
    }
    private final Marker parseValue(PsiBuilder b,int l)
    {
        Marker m = parsePrimaryExpr(b,l+1);
        return m != null ? m : parseClosureExpr(b, l+1);
    }
    private final Marker parsePrimaryExpr(PsiBuilder b,int l){
        Marker prefix ;
        Marker suffix;
        IElementType token = b.getTokenType();
        if (token == ShaderTypes.RETURN){
            Marker m = b.mark();
            b.advanceLexer();
            ShaderParseUtil.expectExpr(b,l+1);
            ShaderParseUtil.expectError(b,ShaderTypes.SEMI);
            m.done(ShaderTypes.RETURN_STAT);
            return m;
        }else if (token == ShaderTypes.ID){
            Marker m = parseVariableDeclareExpr(b,l+1);
            if(m != null)  return m;
        }
        for(prefix = parsePrefixExpr(b,l + 1);prefix != null; prefix = suffix){

            Marker m = parseIndexExpr(prefix,b,l+1);
            if (m == null){
                m = parseCallExpr(prefix,b,l+1);

            }
            suffix = m;
            if (suffix == null)
                break;
        }
        return prefix;
    }
    private final Marker parseClosureExpr (PsiBuilder b,int l){
        if(b.getTokenType() == ShaderTypes.STRUCT){
            return StructExpParser.Instance.parseClass(b,l);
        }
        return null;
    }
    private final Marker parseIndexExpr(Marker prefix,PsiBuilder b, int l){
        IElementType token = b.getTokenType();
        IElementType t;
        Marker m;
        if (token == ShaderTypes.DOT){
            b.advanceLexer();
            t = ShaderTypes.ID;
            ShaderParseUtil.expectError(b,t);
            m = prefix.precede();
            m.done(ShaderTypes.INDEX_EXPR);
            return m;
        }else if(token == ShaderTypes.LBRACKET){
            b.advanceLexer();
            parseExprList(b,l+1);
            //ShaderParseUtil.expectExpr(b, l+ 1);
            ShaderParseUtil.expectError(b,ShaderTypes.RBRACKET);
            m = prefix.precede();
            m.done(ShaderTypes.INDEX_EXPR);
            return m;
        }else{
            return null;
        }
    }
    public Marker parseMethodCallExpr(PsiBuilder b,int l){
        if(b.getTokenType() == ShaderTypes.ID){
            Marker m = b.mark();
            b.advanceLexer();
            if(b.getTokenType() == ShaderTypes.DOT){
                b.advanceLexer();
                Marker m2 = parseMethodCallExpr(b,l);
                if (m2 != null){
                    m.done(ShaderTypes.METHOD_CALL_EXPR);
                    return m;
                }else{
                    m.rollbackTo();
                    return null;
                }

            }else if (b.getTokenType() == ShaderTypes.LPAREN){
                parseSingleParameterList(b,l+1);
                m.done(ShaderTypes.METHOD_CALL_EXPR);
                return m;
            }else{
                m.rollbackTo();
                return null;

            }

        }
        return null;
    }
    public Marker parseSingleParameterList(PsiBuilder b,int l){
        if (b.getTokenType() == ShaderTypes.LPAREN){
            Marker m = b.mark();
            b.advanceLexer();
            boolean has = parseSingleParameter(b,l);
            while (has){
                if(b.eof() || b.getTokenType() == ShaderTypes.RPAREN){
                    break;
                }
                ShaderParseUtil.expectError(b,ShaderTypes.COMMA);
                boolean hasParam = parseSingleParameter(b,l);
                if (!hasParam){
                    if (b.getTokenType() == ShaderTypes.RPAREN){
                        b.error(", unexpected");
                    }else{
                        b.error(b.getTokenText() + " unexpected");
                        b.advanceLexer();
                    }

                }
            }
            ShaderParseUtil.expectError(b,ShaderTypes.RPAREN);
            m.done(ShaderTypes.LIST_ARGS);
            return m;
        }
        return null;
    }
    public boolean parseSingleParameter(PsiBuilder b,int l){
        if (TokenUtil.actualParameterSet.contains(b.getTokenType())){
            b.advanceLexer();
            return true;
        }
        return false;
    }
    private  final Marker parseCallExpr(Marker prefix,PsiBuilder b,int l){
        IElementType token = b.getTokenType();
        Marker tableExpr ;
        Marker m;
        if (token == ShaderTypes.LPAREN){ // '(' (arg_expr_list)? ')'
            tableExpr = b.mark();
            b.advanceLexer();
            //parseExprList(b,l+1);
            parseParameterList(b,l+1);
            ShaderParseUtil.expectError(b,ShaderTypes.RPAREN);
            tableExpr.done(ShaderTypes.LIST_ARGS);
            m = prefix.precede();
            m.done(ShaderTypes.CALL_EXPR);
            return m;
        }else if (token == ShaderTypes.STRING){
            tableExpr = b.mark();
            b.advanceLexer();
            tableExpr.done(ShaderTypes.LITERAL_EXPR);
            tableExpr.precede().done(ShaderTypes.SINGLE_ARG);
            m = prefix.precede();
            m.done(ShaderTypes.CALL_EXPR);
            return m;
        }else if(token == ShaderTypes.LCURLY){
            tableExpr = parseTableExpr(b,l);

            return tableExpr;
        }else{
            return null;
        }
    }

    public Marker parseVariableDeclareExpr( PsiBuilder b,int l){
        if (b.getTokenType() == ShaderTypes.ID){
            if(b.lookAhead(1) == ShaderTypes.ID && b.lookAhead(2) == ShaderTypes.COLON){
                Marker m = b.mark();
                b.advanceLexer();
                b.advanceLexer();
                b.advanceLexer();
                ShaderParseUtil.expectError(b,ShaderTypes.ID);

                m.done(ShaderTypes.VARIABLE_DECLARE);
                return m;
            }else if(b.lookAhead(1) == ShaderTypes.ID && b.lookAhead(2) == ShaderTypes.SEMI){
                Marker m = b.mark();
                b.advanceLexer();
                b.advanceLexer();
                m.done(ShaderTypes.VARIABLE_DECLARE);
                return m;
            }
        }
        return null;
    }
    //解析参数列表
    public Marker parseParameterList(PsiBuilder b,int l){
        Marker expr = parseExpr(b,l);
        boolean isFormal = b.getTokenType() == ShaderTypes.ID || b.getTokenType() == ShaderTypes.STRING; //是否是形参(两个参数)
        boolean isActual = b.getTokenType() == ShaderTypes.COMMA;//是否是时参(一个参数)
        while(expr!= null && (isFormal || isActual)){
            if(isActual){
                b.advanceLexer();
                ShaderParseUtil.expectExpr(b,l+1);
                isActual = b.getTokenType() == ShaderTypes.COMMA;
            }else if(isFormal){
                b.advanceLexer();
                isFormal = b.getTokenType() == ShaderTypes.COMMA;
                if (isFormal){
                    b.advanceLexer();
                    ShaderParseUtil.expectExpr(b,l+1);
                    isFormal = b.getTokenType() == ShaderTypes.ID || b.getTokenType() == ShaderTypes.STRING;
                }

            }
        }
        return expr;
    }
    public final Marker parseExprList(PsiBuilder b,int l){
        Marker expr = parseExpr(b,l);
        while(expr != null && b.getTokenType() == ShaderTypes.COMMA){
            b.advanceLexer();
            ShaderParseUtil.expectExpr(b,l+1);
        }
        return expr;
    }
    public final Marker parseTableExpr(PsiBuilder b,int l){
        if (b.getTokenType() == ShaderTypes.LCURLY){
            Marker m = b.mark();
            b.advanceLexer();
            parseStatementList(b,l);
            ShaderParseUtil.expectError(b,ShaderTypes.RCURLY);
            m.done(ShaderTypes.TABLE_FIELD);
            return m;
        }
        return null;
    }
    private final Marker parsePrefixExpr(PsiBuilder b,int l){
        IElementType token = b.getTokenType();
        Marker m;
        if (token == ShaderTypes.LPAREN){
            m = b.mark();
            b.advanceLexer();
            //ShaderParseUtil.expectExpr(b,l+1);
            parseExprList(b,l+1);
            ShaderParseUtil.expectError(b,ShaderTypes.RPAREN);
            m.done(ShaderTypes.PAREN_EXPR);
            return m;
        }else if(token == ShaderTypes.ID ) {
            m = b.mark();
            b.advanceLexer();
            m.done(ShaderTypes.NAME_EXPR);
            return m;
        }
        //else if(token == ShaderTypes.LCURLY){
        //    return parseTableExpr(b,l);
        //}
        else if(TokenUtil.literalSet.contains(token) ){
            m = b.mark();
            b.advanceLexer();
            m.done(ShaderTypes.LITERAL_EXPR);
            return m;
        }else if(token == ShaderTypes.RETURN){
            m = b.mark();
            b.advanceLexer();
            return m;
        }
        return null;
    }
    public void parseStatementList(PsiBuilder b, int l){
        Marker statement ;
        while(true){
            statement = parseStatement(b,l+1);
            if (statement== null){
                break;
            }
        }
    }

    public Marker parseStatement(PsiBuilder b,int l){
        IElementType token = b.getTokenType();
        if (token == ShaderTypes.ID){
            if(b.lookAhead(1) == ShaderTypes.ID && b.lookAhead(2) == ShaderTypes.SEMI){
                Marker m = b.mark();
                b.advanceLexer();
                b.advanceLexer();
                b.advanceLexer();
                m.done(ShaderTypes.VARIABLE_DECLARE);
                return m;
            }else{
                Marker m = parseExpr(b,l) ;
                if (b.getTokenType() == ShaderTypes.ASSIGN){
                    b.advanceLexer();
                    ShaderParseUtil.expectExpr(b,l) ;
                    ShaderParseUtil.expectError(b,ShaderTypes.SEMI);
                    Marker mm = m.precede();
                    mm.done(ShaderTypes.ASSIGN_STAT);
                    return mm ;
                }else{
                    ShaderParseUtil.expectError(b,ShaderTypes.SEMI);
                    return m;
                }
            }
        }else{
            b.error(b.getTokenText() + " unexpected");
            return null;
        }
    }

    private final void error(PsiBuilder builder, String message) {
        builder.mark().error(message);
    }
}
