package com.teng.highlighting;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import com.teng.lexer.ShaderFlexAdapter;
import com.teng.psi.ShaderTypes;
import org.jetbrains.annotations.NotNull;
import sun.security.provider.SHA;

import java.util.HashMap;
import java.util.Map;

public class ShaderSyntaxHighlighter extends SyntaxHighlighterBase {

    private static TokenSet KEYWORD = TokenSet.create(
            ShaderTypes.AND, ShaderTypes.BREAK, ShaderTypes.DO, ShaderTypes.ELSE, ShaderTypes.FOR, ShaderTypes.IF, ShaderTypes.IN, ShaderTypes.NOT,
            ShaderTypes.OR, ShaderTypes.RETURN, ShaderTypes.WHILE,ShaderTypes.OUT,ShaderTypes.NULL, ShaderTypes.TRUE,ShaderTypes.FALSE,
            ShaderTypes.CONTINUE);
    private static TokenSet SHADER_KEYWORD = TokenSet.create(ShaderTypes.SHADER,ShaderTypes.PROPERTIES,ShaderTypes.SUBSHADER,
            ShaderTypes.TAGS, ShaderTypes.PASS,ShaderTypes.CGPROGRAM,ShaderTypes.ENDCG,ShaderTypes.PRAGMA,ShaderTypes.STRUCT,
            ShaderTypes.INCLUDE);

    private static TokenSet NAME = TokenSet.create(ShaderTypes.ID);
    private static TokenSet NUMBER = TokenSet.create(ShaderTypes.NUMBER);
    private static TokenSet STRING = TokenSet.create(ShaderTypes.STRING);
    private static TokenSet COMMENT = TokenSet.create(ShaderTypes.BLOCK_COMMENT,ShaderTypes.SHORT_COMMENT);
    private static TokenSet PUNCTUATION = TokenSet.create(ShaderTypes.COMMA,ShaderTypes.DOT,ShaderTypes.SEMI);

    private static HashMap<TokenSet,TextAttributesKey[]> outMap = new HashMap<>(10);
    static {
        outMap.put(KEYWORD,ShaderHighlighterData.keywords);
        outMap.put(SHADER_KEYWORD,ShaderHighlighterData.shader_keywords);
        outMap.put(NAME,ShaderHighlighterData.names);
        outMap.put(NUMBER,ShaderHighlighterData.numbers);
        outMap.put(STRING,ShaderHighlighterData.strings);
        outMap.put(COMMENT,ShaderHighlighterData.comments);
        outMap.put(NAME,ShaderHighlighterData.names);
        outMap.put(PUNCTUATION,ShaderHighlighterData.punctuations);
    }
    @NotNull
    @Override
    public Lexer getHighlightingLexer() {

        return new ShaderFlexAdapter();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        for(Map.Entry<TokenSet,TextAttributesKey[]> entity : outMap.entrySet()) {
            if (entity.getKey().contains(tokenType)){
                return entity.getValue();
            }
        }
        return ShaderHighlighterData.EMPTY_KEYS;

    }


}
