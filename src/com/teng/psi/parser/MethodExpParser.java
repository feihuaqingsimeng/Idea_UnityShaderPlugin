package com.teng.psi.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import com.teng.Util.TokenUtil;
import com.teng.psi.ShaderParseUtil;
import com.teng.psi.ShaderTypes;
import org.yaml.snakeyaml.error.Mark;

public class MethodExpParser {
    public static final MethodExpParser Instance;
    static {
        Instance = new MethodExpParser();
    }

    public Marker parseMethod(PsiBuilder b,int l){
        Marker m = b.mark();
        if(b.getTokenType() == ShaderTypes.INLINE){
            b.advanceLexer();
        }
        if (TokenUtil.methodTypeSet.contains(b.getTokenType())){
            b.advanceLexer();
            ShaderParseUtil.expectError(b,ShaderTypes.ID);
            parseMethodDefParameterList(b,l);
            parseMethodBody(b,l);
            m.done(ShaderTypes.METHOD_DEF);
            return m;
        }
        m.drop();
        return null;
    }

    public Marker parseMethodDefParameterList(PsiBuilder b,int l){
        if (b.getTokenType() == ShaderTypes.LPAREN){
            Marker m = b.mark();
            b.advanceLexer();
            while(true){
                if (b.eof() || b.getTokenType() == ShaderTypes.RPAREN){
                    break;
                }
                parseMethodDefParameter(b,l);
            }
            ShaderParseUtil.expectError(b,ShaderTypes.RPAREN);
            m.done(ShaderTypes.METHOD_PARAMETER_LIST);
            return m;
        }
        return null;
    }
    public Marker parseMethodDefParameter(PsiBuilder b,int l){
        Marker m = b.mark();
        if (b.getTokenType() == ShaderTypes.IN  || b.getTokenType() == ShaderTypes.OUT || b.getTokenType() == ShaderTypes.INOUT){
            b.advanceLexer();
        }
        if(TokenUtil.basicDataTypeSet.contains(b.getTokenType())){
            b.advanceLexer();
            ShaderParseUtil.expectError(b,ShaderTypes.ID);
            m.done(ShaderTypes.METHOD_PARAMETER);
            return m;
        }
        if(b.getTokenType() != ShaderTypes.RPAREN){
            b.error(b.getTokenText() + " unexpected");
            b.advanceLexer();
        }
        m.drop();
        return null;
    }
    public Marker parseMethodBody(PsiBuilder b,int l){
        if(b.getTokenType() == ShaderTypes.LCURLY){
            Marker m = b.mark();
            b.advanceLexer();
            ShaderParseUtil.lazyBlock(b,l);
            ShaderParseUtil.expectError(b,ShaderTypes.RCURLY);
            m.done(ShaderTypes.METHOD_BODY);
            return m;
        }
        return null;
    }
}
