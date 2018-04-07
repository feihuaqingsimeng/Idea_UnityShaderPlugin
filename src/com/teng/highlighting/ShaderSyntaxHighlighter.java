package com.teng.highlighting;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.teng.lexer.ShaderFlexAdapter;
import com.teng.psi.ShaderTokenType;
import com.teng.psi.ShaderTypes;
import org.jetbrains.annotations.NotNull;

public class ShaderSyntaxHighlighter extends SyntaxHighlighterBase {

    public static final TextAttributesKey SEPARATOR = TextAttributesKey.createTextAttributesKey("SHADER_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey KEY = TextAttributesKey.createTextAttributesKey("SHADER_KEY", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey VALUE = TextAttributesKey.createTextAttributesKey("SHADER_VALUE", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey COMMENT = TextAttributesKey.createTextAttributesKey("SHADER_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey BAD_CHARACTER = TextAttributesKey.createTextAttributesKey("SHADER_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);

    private  static final TextAttributesKey[] SEPARATOR_KEYS = new TextAttributesKey[]{SEPARATOR};
    private  static final TextAttributesKey[] KEY_KEYS = new TextAttributesKey[]{KEY};
    private  static final TextAttributesKey[] VALUE_KEYS = new TextAttributesKey[]{VALUE};
    private  static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private  static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    private  static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {

        return new ShaderFlexAdapter();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(ShaderTypes.SEPARATOR))
        {
            return SEPARATOR_KEYS;
        }else if (tokenType.equals(ShaderTypes.KEY))
        {
            return KEY_KEYS;
        }else if (tokenType.equals(ShaderTypes.VALUE))
        {
            return VALUE_KEYS;
        }else if (tokenType.equals(ShaderTypes.COMMENT))
        {
            return COMMENT_KEYS;
        }else if (tokenType.equals(TokenType.BAD_CHARACTER))
        {
            return BAD_CHAR_KEYS;
        }else{
            return EMPTY_KEYS;
        }
    }


}
