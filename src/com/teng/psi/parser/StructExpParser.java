package com.teng.psi.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import com.teng.psi.ShaderParseUtil;
import com.teng.psi.ShaderTypes;

public class StructExpParser {
    public static final StructExpParser Instance;
    static {
        Instance = new StructExpParser();
    }

    public PsiBuilder.Marker parseClass(PsiBuilder b, int l){
        Marker m = b.mark();
        b.advanceLexer();
        ShaderParseUtil.expectError(b,ShaderTypes.ID);
        parseTableExpr(b,l+1);
        ShaderParseUtil.expectError(b,ShaderTypes.SEMI);
        m.done(ShaderTypes.STRUCT_CLASS);
        return m;
    }
    private void parseTableExpr(PsiBuilder b,int l){
        if (b.getTokenType() == ShaderTypes.LCURLY){
            b.advanceLexer();
            parseStatementList(b,l);
            ShaderParseUtil.expectError(b,ShaderTypes.RCURLY);
        }

    }
    private void parseStatementList(PsiBuilder b,int l){
        while(true){
            parseStatement(b,l);
            if (b.eof() || b.getTokenType() == ShaderTypes.RCURLY)
                break;
        }
    }

    private Marker parseStatement(PsiBuilder b,int l){
        Marker m = ShaderExpressionParser.Instance.parseMethodCallExpr(b,l+1);
        if (m != null){
            Marker mm = m.precede();
            ShaderParseUtil.expectError(b,ShaderTypes.SEMI);
            mm.done(ShaderTypes.EXPR_STAT);
            return mm;
        }
        if (b.getTokenType() == ShaderTypes.ID){
            m = b.mark();
            b.advanceLexer();
            ShaderParseUtil.expectError(b,ShaderTypes.ID);
            ShaderParseUtil.expectError(b,ShaderTypes.COLON);
            ShaderParseUtil.expectError(b,ShaderTypes.ID);
            m.done(ShaderTypes.VARIABLE_DECLARE);
            ShaderParseUtil.expectError(b,ShaderTypes.SEMI);
            Marker mm = m.precede();
            mm.done(ShaderTypes.EXPR_STAT);
            return m;

        }else{
            b.error(b.getTokenText() + " unexpected");
            b.advanceLexer();
        }
        return null;
    }
}
