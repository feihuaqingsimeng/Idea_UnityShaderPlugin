package com.teng.psi.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import com.intellij.psi.tree.IElementType;
import com.teng.psi.ShaderParseUtil;
import com.teng.psi.ShaderTypes;

public class SubShaderExpParser {

    public static final SubShaderExpParser Instance;
    static {
        Instance = new SubShaderExpParser();
    }

    public Marker parseClass(PsiBuilder b,int l){
        Marker m = b.mark();
        b.advanceLexer();
        parseTableExpr(b,l+1);
        m.done(ShaderTypes.SUB_SHADER_CLASS);
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
    private Marker parseTableField(PsiBuilder b,int l){
        IElementType token = b.getTokenType();
        Marker m;
        if(token == ShaderTypes.ID ){
            m = b.mark();
            b.advanceLexer();
            ShaderParseUtil.expectExpr(b,l+1);
            m.done(ShaderTypes.TABLE_FIELD);
            return m;
        }else if( token == ShaderTypes.TAGS){
            return TagsExpParser.Instance.parseClass(b,l+1);
        }else if (token == ShaderTypes.PASS){
            return PassExpParser.Instance.parseClass(b,l+1);
        }else{
            b.error(token + " unexpected");
            b.advanceLexer();
            return null;
        }
    }
}
