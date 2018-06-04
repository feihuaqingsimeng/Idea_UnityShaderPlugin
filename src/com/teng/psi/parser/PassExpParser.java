package com.teng.psi.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;

import com.intellij.psi.tree.IElementType;
import com.teng.psi.ShaderParseUtil;
import com.teng.psi.ShaderTypes;

public class PassExpParser {
    public static final PassExpParser Instance;
    static {
        Instance = new PassExpParser();
    }

    public Marker parseClass(PsiBuilder b, int l){
        Marker m = b.mark();
        b.advanceLexer();

        parseTableExpr(b,l+1);

        m.done(ShaderTypes.PASS_CLASS);
        return m;
    }
    private void parseTableExpr(PsiBuilder b,int l){
        if (b.getTokenType() == ShaderTypes.LCURLY){
            b.advanceLexer();
            parseTableFieldList(b,l);
            ShaderParseUtil.expectError(b,ShaderTypes.RCURLY);
        }

    }
    private void parseTableFieldList(PsiBuilder b,int l){
        Marker m = b.mark();
        ShaderParseUtil.expectError(b,ShaderTypes.CGPROGRAM);
        while(true){
            parseTableField(b,l);
            if (b.eof() || b.getTokenType() == ShaderTypes.ENDCG || b.getTokenType() == ShaderTypes.RCURLY)
                break;
        }
        ShaderParseUtil.expectError(b,ShaderTypes.ENDCG);
        m.done(ShaderTypes.CGPROGRAM_FIELD);
    }
    private Marker parseTableField(PsiBuilder b,int l){
        IElementType token = b.getTokenType();
        if (token == ShaderTypes.GETN){
            Marker m = b.mark();
            b.advanceLexer();
            if(b.getTokenType() == ShaderTypes.PRAGMA){
                b.advanceLexer();
                ShaderParseUtil.expectError(b,ShaderTypes.ID);
                if (b.getTokenType() == ShaderTypes.ID){
                    b.advanceLexer();

                }
                m.done(ShaderTypes.PRAGMA_EXPR);
                return m;
            }else if(b.getTokenType() == ShaderTypes.INCLUDE){
                b.advanceLexer();
                ShaderParseUtil.expectError(b,ShaderTypes.STRING);
                m.done(ShaderTypes.INCLUDE_EXPR);
                return m;
            }else{
                m.rollbackTo();
                b.error( "express expect");
                return null;
            }
        }else if(b.getTokenType() == ShaderTypes.SEMI){
            Marker m = b.mark();
            b.advanceLexer();
            m.done(ShaderTypes.EMPTY_STAT);
            return m;
        }else if(b.getTokenType() == ShaderTypes.STRUCT){
            return StructExpParser.Instance.parseClass(b,l);
        }else{
            //ShaderExpressionParser.Instance.parseStatement(b,l);
            Marker m = ShaderExpressionParser.Instance.parseExpr(b,l) ;
            if (m != null)
                return m;
            b.error(b.getTokenText() + " unexpected");
            b.advanceLexer();
            return null;
        }
    }
}
