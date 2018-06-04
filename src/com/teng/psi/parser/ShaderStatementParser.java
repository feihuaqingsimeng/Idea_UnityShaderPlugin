package com.teng.psi.parser;

import com.intellij.codeInsight.template.postfix.templates.ElseExpressionPostfixTemplateBase;
import com.intellij.lang.ASTNode;
import com.intellij.lang.LighterASTNode;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.teng.psi.ShaderParseUtil;
import com.teng.psi.ShaderTypes;
import org.yaml.snakeyaml.error.Mark;

public class ShaderStatementParser {
    public static final ShaderStatementParser Instance;
    static {
        Instance = new ShaderStatementParser();
    }
    public final Marker parseStatement(PsiBuilder b, int l){
        b.setDebugMode(true);
        IElementType type = b.getTokenType();
        if (type == ShaderTypes.SEMI) {
            return parseEmptyStatement(b);
        }else if(type == ShaderTypes.RETURN){
          return parseReturnStatement(b,l);

        }else if(type == ShaderTypes.SHADER){
            return parseShaderClass(b,l);
        }else if(type == ShaderTypes.STRUCT){
            return StructExpParser.Instance.parseClass(b,l);
        }else if(type == ShaderTypes.GETN){
            return parsGen(b,l);
        }else if(type == ShaderTypes.INLINE){
            return MethodExpParser.Instance.parseMethod(b,l);
        } else{
            return parseOtherStatement(b,l);
        }


    }
    private Marker parseEmptyStatement(PsiBuilder b){
        Marker m = b.mark();
        while (b.getTokenType() == ShaderTypes.SEMI) {
            b.advanceLexer() ;// ;
        }
        m.done(ShaderTypes.EMPTY_STAT);
        return m;
    }
    private Marker parseReturnStatement(PsiBuilder b,int l){
        Marker m = b.mark();
        b.advanceLexer();
        ShaderParseUtil.expectExpr(b,l);
        m.done(ShaderTypes.RETURN_STAT);
        return m;
    }
    private Marker parseShaderClass(PsiBuilder b,int l){
        b.setDebugMode(true);
        Marker m = b.mark();
        b.advanceLexer();
        ShaderParseUtil.expectError(b,ShaderTypes.STRING,"need a name");
        ShaderParseUtil.expectError(b,ShaderTypes.LCURLY);

        while(true){
            if(b.getTokenType() == ShaderTypes.PROPERTIES){
                PropertiesExpParser.Instance.parseClass(b,l+1);
            }else if(b.getTokenType() == ShaderTypes.SUBSHADER){
                SubShaderExpParser.Instance.parseClass(b,l+1);
            }else if (b.eof() || b.getTokenType() == ShaderTypes.RCURLY){
                break;
            }else{
                b.error(b.getTokenText()+" unexpected");
                b.advanceLexer();
            }
        }
        ShaderParseUtil.expectError(b,ShaderTypes.RCURLY);
        m.done(ShaderTypes.SHADER_CLASS);
        return m;
    }
    private Marker parsGen(PsiBuilder b,int l){

        Marker m = b.mark();
        b.advanceLexer();
        if(b.getTokenType() == ShaderTypes.DEFINE){
            b.advanceLexer();
            ShaderParseUtil.expectExpr(b,l);
            LighterASTNode node = b.getLatestDoneMarker();
            if( (node.getTokenType() != ShaderTypes.IF_DEF_EXPR && node.getTokenType() != ShaderTypes.IF_N_DEF_EXPR)){
                ShaderParseUtil.parseExpr(b,l);
            }
            m.done(ShaderTypes.DEFINE_STAT);
            return m;

        }else if(b.getTokenType() == ShaderTypes.IFNDEF){
            b.advanceLexer();
            ShaderParseUtil.expectError(b,ShaderTypes.ID);
            m.done(ShaderTypes.IF_N_DEF_EXPR);
            return m;
        }else if(b.getTokenType() == ShaderTypes.INCLUDE){
            b.advanceLexer();
            ShaderParseUtil.expectError(b,ShaderTypes.STRING);
            m.done(ShaderTypes.INCLUDE_EXPR);
            return m;
        }else if(b.getTokenType() == ShaderTypes.IFDEF){
            b.advanceLexer();
            ShaderParseUtil.expectError(b,ShaderTypes.ID);
            m.done(ShaderTypes.IF_DEF_EXPR);
            return m;
        }else if(b.getTokenType() == ShaderTypes.ELSE){
            b.advanceLexer();
            m.done(ShaderTypes.DEFINE_STAT);
            return m;
        }else if(b.getTokenType() == ShaderTypes.ENDIF){
            b.advanceLexer();
            m.done(ShaderTypes.DEFINE_STAT);
            return m;
        }else if(b.getTokenType() == ShaderTypes.IF){
            b.advanceLexer();
            ShaderParseUtil.expectExpr(b,l);
            m.done(ShaderTypes.GEN_IF_STAT);
            return m;
        }
        m.drop();
        return parseOtherStatement(b,l);
    }
    private final Marker parseOtherStatement(PsiBuilder b, int l){
        Marker expr = ShaderExpressionParser.Instance.parseExpr(b,l+1);
        if (expr != null){
            LighterASTNode last = b.getLatestDoneMarker();
            IElementType token = last != null ? last.getTokenType() : null;
            if (token == ShaderTypes.NAME_EXPR || token == ShaderTypes.INDEX_EXPR){
                Marker c = expr;
                boolean isAssignment = false;
                while(b.getTokenType() == ShaderTypes.COMMA){
                    isAssignment = true;
                    b.advanceLexer();
                    ShaderParseUtil.expectExpr(b,l+1);
                    if (isAssignment){
                        c = expr.precede();
                        c.done(ShaderTypes.VAR_LIST);
                        ShaderParseUtil.expectError(b,ShaderTypes.ASSIGN);
                    }else if(b.getTokenType() == ShaderTypes.ASSIGN){
                        c = expr.precede();
                        c.done(ShaderTypes.VAR_LIST);
                        b.advanceLexer();
                        isAssignment = true;
                    }
                    if (isAssignment){
                        ShaderParseUtil.expectExprList(b,l);
                        Marker m = c.precede();
                        doneStat(b,m,ShaderTypes.ASSIGN_STAT);
                        return m;
                    }
                }
            }
            //Marker m = expr.precede();
            //doneStat(b,m,ShaderTypes.EXPR_STAT);
            return expr;
        }
        return null;
    }
    public final void doneStat(PsiBuilder b,Marker m,IElementType type){
        IElementType var = ShaderTypes.SEMI;
        ShaderParseUtil.expect(b,var);
        ShaderParseUtil.done(m,type);
    }
}
