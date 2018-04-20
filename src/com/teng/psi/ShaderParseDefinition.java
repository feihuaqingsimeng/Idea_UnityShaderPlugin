package com.teng.psi;

import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import com.teng.Language.ShaderLanguage;
import com.teng.lexer.ShaderFlexAdapter;
import com.teng.parser.ShaderParser;
import org.jetbrains.annotations.NotNull;

public class ShaderParseDefinition implements ParserDefinition {

    public static final TokenSet WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE);
    public static final TokenSet COMMENT = TokenSet.create(ShaderTypes.SHORT_COMMENT,ShaderTypes.BLOCK_COMMENT,ShaderTypes.REGION,ShaderTypes.ENDREGION);
    public static final TokenSet STRING = TokenSet.create(ShaderTypes.STRING);
    public static final IFileElementType FILE = new IFileElementType(ShaderLanguage.Instance);
    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new ShaderFlexAdapter();
    }

    @Override
    public PsiParser createParser(Project project) {
        return new ShaderParser();
    }

    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    @NotNull
    @Override
    public TokenSet getWhitespaceTokens() {
        return WHITE_SPACES;
    }

    @NotNull
    @Override
    public TokenSet getCommentTokens() {
        return COMMENT;
    }

    @NotNull
    @Override
    public TokenSet getStringLiteralElements() {
        return STRING;
    }

    @NotNull
    @Override
    public PsiElement createElement(ASTNode node) {
        return ShaderTypes.Factory.createElement(node);
    }

    @Override
    public PsiFile createFile(FileViewProvider viewProvider) {
        return new ShaderFile(viewProvider);
    }

    @Override
    public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode left, ASTNode right) {
        return SpaceRequirements.MAY;
    }


}
