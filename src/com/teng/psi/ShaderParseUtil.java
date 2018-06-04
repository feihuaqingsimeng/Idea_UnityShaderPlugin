package com.teng.psi;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;

import com.intellij.lang.parser.GeneratedParserUtilBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import com.teng.psi.parser.ShaderExpressionParser;
import com.teng.psi.parser.ShaderStatementParser;

public class ShaderParseUtil extends GeneratedParserUtilBase{
    private static TokenSet L_BINDERS;
    private static TokenSet R_BINDERS;
    private static TokenSet END_SET = TokenSet.create(ShaderTypes.RCURLY);
    static{
        L_BINDERS = TokenSet.create(ShaderTypes.ASSIGN_STAT);
        R_BINDERS = TokenSet.create(ShaderTypes.ASSIGN_STAT);
    }

    public static boolean parseExpr(PsiBuilder b,int l){

        return ShaderExpressionParser.Instance.parseExpr(b,l) != null;
    }
    public static boolean parseStatement(PsiBuilder b,int l)
    {
        return ShaderStatementParser.Instance.parseStatement(b,l) != null;
    }
    public static boolean lazyBlock(PsiBuilder b,int l){
        int i = 0;
        IElementType begin = b.rawLookup(--i);
        while(begin == TokenType.WHITE_SPACE) {
            begin = b.rawLookup(--i);
        }
        if (begin != null){
            //Marker marker = b.mark();
            //marker.setCustomEdgeTokenBinders(WhitespacesBinders.GREEDY_LEFT_BINDER,null);
            if (begin == ShaderTypes.LCURLY){
            }
            matchStart(true,b,0,begin);
            //marker.collapse(ShaderTypes.BLOCK);
            //marker.setCustomEdgeTokenBinders(null,WhitespacesBinders.GREEDY_RIGHT_BINDER);
        }
        return true;
    }
    private static boolean matchStart(boolean advance,PsiBuilder b,int l,IElementType begin ){
        if (begin == ShaderTypes.LCURLY ){
            return matchEnd(advance,b,l,TokenSet.EMPTY,END_SET);
        }
        return false;
    }
    private static boolean matchEnd(boolean advance ,PsiBuilder b,int l,TokenSet skips,TokenSet types )
    {
        if (!advance)
            b.advanceLexer();
        IElementType type = b.getTokenType();
        while(true){
            if (type == null || b.eof())
                return false;
            while( ! skips.contains(type)){
                if (types.contains(type)) {
                    if (l != 0)
                        b.advanceLexer();
                    return true;
                }
                boolean isMatch = matchStart(false,b,l+1,type);
                if(!isMatch)
                    break;
                type = b.getTokenType();
            }
            b.advanceLexer();
            type = b.getTokenType();
        }
    }
    public static final Marker expectExpr(PsiBuilder b,int l){
        Marker m = ShaderExpressionParser.Instance.parseExpr(b,l);
        if (m == null) b.error("Expression expected");
        return m;
    }
    public static final boolean expectError(PsiBuilder b, IElementType expectedType){
        if (b.getTokenType() == expectedType){
            b.advanceLexer();
            return true;
        }else{
            b.error( expectedType.toString() + " expected");
            return false;
        }

    }
    public static final boolean expectError(PsiBuilder b, IElementType expectedType,String error){
        if (b.getTokenType() == expectedType){
            b.advanceLexer();
            return true;
        }else{
            b.error( error);
            return false;
        }

    }
    public static final Marker expectExprList(PsiBuilder b,int l ){
        Marker firstExpr = ShaderExpressionParser.Instance.parseExprList(b,l);
        if (firstExpr != null){
            Marker m = firstExpr.precede();
            m.done(ShaderTypes.EXPR_LIST);
            return m;
        }else {
            b.error("Expression expected");
        }
        return null;
    }
    public static final boolean expect(PsiBuilder b,IElementType e){
        if (b.getTokenType() == e){
            b.advanceLexer();
            return true;
        }
        return false;
    }
    public static final void done(Marker m,IElementType type){
        m.done(type);

    }
}
