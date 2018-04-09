package com.teng.psi;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import com.intellij.lang.parser.GeneratedParserUtilBase.Parser;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;

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
    private static Parser primaryExprParser;
    private static Parser closureExprParser;

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
        //exprTypeDic.put(ExprType.T_VALUE,TokenSet.create(new IElementType[]{TokenSet.EMPTY}));
    }

    public boolean parse(PsiBuilder b, int l, Parser primaryExprParser, Parser closureExprParser) {
        this.primaryExprParser = primaryExprParser;
        this.closureExprParser = closureExprParser;
        return parseExpr(b, ExprType.T_OR, l + 1) != null;
    }

    public PsiBuilder.Marker parseExpr(PsiBuilder builder, ExprType type, int l) {
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
        if (primaryExprParser == null || closureExprParser == null )
            return null;
        boolean r = primaryExprParser.parse(b,l + 1);
        r = r || closureExprParser.parse(b,l + 1);
        return r ? (Marker)b.getLatestDoneMarker() : null;
    }
    private final void error(PsiBuilder builder, String message) {
        builder.mark().error(message);
    }
}
