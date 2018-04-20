package com.teng.psi;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.WhitespacesBinders;
import com.intellij.lang.parser.GeneratedParserUtilBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import static com.teng.psi.ShaderTypes.*;

public class ShaderParseUtil extends GeneratedParserUtilBase{

    public static boolean parseExpr(PsiBuilder b,int l, Parser primaryExprParser, Parser closureExprParser){

        return ShaderExpressionParser.Instance.parse(b,l,primaryExprParser,closureExprParser);
    }
}
