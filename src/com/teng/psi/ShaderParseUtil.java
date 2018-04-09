package com.teng.psi;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.parser.GeneratedParserUtilBase;
import org.jetbrains.annotations.NotNull;

public class ShaderParseUtil extends GeneratedParserUtilBase{
    public static boolean parseExpr(PsiBuilder b,int l, Parser primaryExprParser, Parser closureExprParser){

        return ShaderExpressionParser.Instance.parse(b,l,primaryExprParser,closureExprParser);
    }
}
