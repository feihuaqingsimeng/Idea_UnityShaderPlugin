package com.teng.psi.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import com.intellij.psi.tree.IElementType;
import com.teng.psi.ShaderParseUtil;
import com.teng.psi.ShaderTypes;

public class TagsExpParser {

    public static final TagsExpParser Instance;
    static {
        Instance = new TagsExpParser();
    }

    public Marker parseClass(PsiBuilder b,int l){
        Marker m = b.mark();
        b.advanceLexer();
        parseTableExpr(b,l+1);
        m.done(ShaderTypes.TAGS_CLASS);
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

        if (b.getTokenType() == ShaderTypes.STRING){
            Marker m = b.mark();
            b.advanceLexer();
            ShaderParseUtil.expectError(b,ShaderTypes.ASSIGN);
            ShaderParseUtil.expectError(b,ShaderTypes.STRING);
            m.done(ShaderTypes.TAGS_FIELD);
            return m;
        }
        b.error(b.getTokenType() + " unexpected");
        b.advanceLexer();
        return null;
    }
}
