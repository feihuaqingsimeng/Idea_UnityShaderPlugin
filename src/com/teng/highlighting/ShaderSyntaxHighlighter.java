package com.teng.highlighting;

import com.intellij.ide.highlighter.custom.CustomHighlighterColors;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import com.teng.lexer.ShaderFlexAdapter;
import com.teng.psi.ShaderTokenType;
import com.teng.psi.ShaderTypes;
import org.jetbrains.annotations.NotNull;
import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.HashMap;

public class ShaderSyntaxHighlighter extends SyntaxHighlighterBase {

    public static TokenSet KEYWORD_TOKENS = TokenSet.create(
            ShaderTypes.AND, ShaderTypes.BREAK, ShaderTypes.DO, ShaderTypes.ELSE, ShaderTypes.FOR, ShaderTypes.IF, ShaderTypes.IN, ShaderTypes.NOT, ShaderTypes.OR, ShaderTypes.RETURN, ShaderTypes.WHILE);

    public static TokenSet NAME = TokenSet.create(ShaderTypes.ID);
    public static TokenSet NUMBER = TokenSet.create(ShaderTypes.NUMBER);
    public static TokenSet STRING = TokenSet.create(ShaderTypes.STRING);
    public static TokenSet COMMENT = TokenSet.create(ShaderTypes.BLOCK_COMMENT,ShaderTypes.SHORT_COMMENT,ShaderTypes.REGION,ShaderTypes.ENDREGION);
    public static final TextAttributesKey keyword = TextAttributesKey.createTextAttributesKey("SHADER_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);

    public static final TextAttributesKey name = TextAttributesKey.createTextAttributesKey("SHADER_name",  DefaultLanguageHighlighterColors.CONSTANT);
    public static final TextAttributesKey number = TextAttributesKey.createTextAttributesKey("SHADER_number", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey string = TextAttributesKey.createTextAttributesKey("SHADER_string", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey comment = TextAttributesKey.createTextAttributesKey("SHADER_comment", DefaultLanguageHighlighterColors.BLOCK_COMMENT);

    public static final TextAttributesKey BAD_CHARACTER = TextAttributesKey.createTextAttributesKey("SHADER_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);


    private  static final TextAttributesKey[] NEW_keyword = new TextAttributesKey[]{keyword};
    private  static final TextAttributesKey[] NEW_name = new TextAttributesKey[]{name};
    private  static final TextAttributesKey[] NEW_number = new TextAttributesKey[]{number};
    private  static final TextAttributesKey[] NEW_string = new TextAttributesKey[]{string};
    private  static final TextAttributesKey[] NEW_comment = new TextAttributesKey[]{comment};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];
    @NotNull
    @Override
    public Lexer getHighlightingLexer() {

        return new ShaderFlexAdapter();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if (KEYWORD_TOKENS.contains(tokenType)){
            return NEW_keyword;
        }else if(NAME.contains(tokenType)){
            return NEW_name;
        }else if (NUMBER.contains(tokenType)){
            return NEW_number;
        }else if(STRING.contains(tokenType)){
            return NEW_string;
        }else if(COMMENT.contains(tokenType)){
            return NEW_comment;
        }
        return EMPTY_KEYS;

    }


}
