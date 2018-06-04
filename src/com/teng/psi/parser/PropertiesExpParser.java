package com.teng.psi.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import com.intellij.psi.tree.IElementType;
import com.teng.psi.ShaderParseUtil;
import com.teng.psi.ShaderTypes;

public class PropertiesExpParser {
    public static final PropertiesExpParser Instance;
    static {
        Instance = new PropertiesExpParser();
    }

    public Marker parseClass(PsiBuilder b,int l){
        Marker m = b.mark();
        b.advanceLexer();
        parseTableExpr(b,l+1);
        m.done(ShaderTypes.PROPERTIES_CLASS);
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
        while(true){
           parseTableField(b,l);
            if (b.eof() || b.getTokenType() == ShaderTypes.RCURLY)
                break;
        }
    }
    private final Marker parseTableField(PsiBuilder b,int l){
        IElementType token = b.getTokenType();
        Marker m;
        if(token == ShaderTypes.ID){
            m = b.mark();
            b.advanceLexer();
            ShaderParseUtil.expectError(b,ShaderTypes.LPAREN);
            ShaderParseUtil.expectError(b,ShaderTypes.STRING);
            ShaderParseUtil.expectError(b,ShaderTypes.COMMA);
            ShaderParseUtil.expectExpr(b,l+1);
            ShaderParseUtil.expectError(b,ShaderTypes.RPAREN);
            ShaderParseUtil.expectError(b,ShaderTypes.ASSIGN);
            ShaderParseUtil.expectExpr(b,l+1);
            m.done(ShaderTypes.PROPERTIES_FIELD);
            return m;
        }
        b.error(token + " unexpected");
        b.advanceLexer();
        return null;
    }
}
