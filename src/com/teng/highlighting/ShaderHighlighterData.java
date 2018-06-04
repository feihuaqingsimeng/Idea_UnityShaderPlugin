package com.teng.highlighting;

import com.intellij.ide.highlighter.custom.CustomHighlighterColors;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;

public class ShaderHighlighterData {

    public static final TextAttributesKey keyword = TextAttributesKey.createTextAttributesKey("SHADER_keyword", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey shader_keyword = TextAttributesKey.createTextAttributesKey("SHADER_keyword2",  DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey shader_semantic= TextAttributesKey.createTextAttributesKey("SHADER_semantic", CustomHighlighterColors.CUSTOM_KEYWORD3_ATTRIBUTES);


    public static final TextAttributesKey name = TextAttributesKey.createTextAttributesKey("SHADER_name",  DefaultLanguageHighlighterColors.CONSTANT);
    public static final TextAttributesKey number = TextAttributesKey.createTextAttributesKey("SHADER_number", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey string = TextAttributesKey.createTextAttributesKey("SHADER_string", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey comment = TextAttributesKey.createTextAttributesKey("SHADER_comment", DefaultLanguageHighlighterColors.BLOCK_COMMENT);
    public static final TextAttributesKey punctuation = TextAttributesKey.createTextAttributesKey("SHADER_punctuation", DefaultLanguageHighlighterColors.COMMA);

    public  static final TextAttributesKey[] keywords = new TextAttributesKey[]{keyword};
    public  static final TextAttributesKey[] shader_keywords = new TextAttributesKey[]{shader_keyword};
    public  static final TextAttributesKey[] shader_semantics = new TextAttributesKey[]{shader_semantic};
    public  static final TextAttributesKey[] names = new TextAttributesKey[]{name};
    public  static final TextAttributesKey[] numbers = new TextAttributesKey[]{number};
    public  static final TextAttributesKey[] strings = new TextAttributesKey[]{string};
    public  static final TextAttributesKey[] comments = new TextAttributesKey[]{comment};
    public  static final TextAttributesKey[] punctuations = new TextAttributesKey[]{punctuation};
    public  static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];
}
