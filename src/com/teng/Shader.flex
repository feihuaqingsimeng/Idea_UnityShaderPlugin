package com.teng.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;
import static com.teng.psi.ShaderTypes.*;
%%
%{
    public ShaderLexer()
    {
        this(null);
    }
%}
%public
%class  ShaderLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType


EOL = "\r"|"\n" | "\r\n"
LINE_WS = [\ \t\f]
WHITE_SPACE = ({LINE_WS} | {EOL})+

ID = [:jletter:] [:jletterdigit:]* | 2D
//number
n = [0-9]+
h = [0-9a-fA-F]+
exp = [Ee]([+-]?{n})?
ppp = [Pp][+-]{n}
NUMBER = (0[xX]({h}|{h}[.]{h})({exp}|{ppp})?|({n}|{n}[.]{n}){exp}?|[.]{n}|{n}[.])

//comments
BLOCK_COMMENT = "/*"[\s\S]*("*/")?
SHORT_COMMENT = "//".*
STRING = \"([^\\\"]|\\\S\\[\r\n])*\"?

%%
<YYINITIAL> {
    {WHITE_SPACE}       {return TokenType.WHITE_SPACE;}


    {BLOCK_COMMENT}     {return BLOCK_COMMENT;}
    {SHORT_COMMENT}     {return SHORT_COMMENT;}
    {STRING}  {return STRING;}

    "||"                 { return OR; }
    "&&"                 { return AND; }
    "break"              { return BREAK; }
    "return"             { return RETURN; }
    "continue"           { return CONTINUE; }
    "do"                 { return DO; }
    "while"              { return WHILE; }
    "if"                 { return IF; }
    "else"               { return ELSE; }
    "for"                { return FOR; }
    "in"                 { return IN; }
    "out"                { return OUT; }
    "inout"              { return INOUT; }
    "!"                  { return NOT; }
    "=="                 { return EQ; }
    ">="                 { return GE; }
    "<="                 { return LE; }
    "!="                 { return NE; }
    "-"                  { return MINUS; }
    "+"                  { return PLUS; }
    "*"                  { return MULT; }
    "%"                  { return MOD; }
    "/"                  { return DIV; }
    "="                  { return ASSIGN; }
    ">"                  { return GT; }
    "<"                  { return LT; }
    "("                  { return LPAREN; }
    ")"                  { return RPAREN; }
    "["                  { return LBRACKET; }
    "]"                  { return RBRACKET; }
    "{"                  { return LCURLY; }
    "}"                  { return RCURLY; }
    "#"                  { return GETN; }
    ","                  { return COMMA; }
    ";"                  { return SEMI; }
    ":"                  {return COLON;}
    "."                  { return DOT; }
    "^"                  { return EXP; }
    "|"                  { return BIT_OR; }
    "&"                  { return BIT_AND; }
    "~"                  { return BIT_TILDE; }
    "<<"                 { return BIT_LTLT; }
    ">>"                 { return BIT_RTRT; }
    "Shader"             { return SHADER; }
    "Properties"         { return PROPERTIES; }
    "SubShader"          { return SUBSHADER; }
    "Tags"               { return TAGS; }
    "Pass"               { return PASS; }
    "CGPROGRAM"          { return CGPROGRAM; }
    "ENDCG"              { return ENDCG; }
    "include"            { return INCLUDE; }
    "pragma"             { return PRAGMA; }
    "struct"             { return STRUCT; }
    "define"             { return DEFINE; }
    "ifndef"             { return IFNDEF; }
    "ifdef"              { return IFDEF; }
    "endif"              { return ENDIF; }
    "inline"             { return INLINE; }
    "void"               { return VOID; }
    {ID}                {return ID;}
    {NUMBER}            {return NUMBER;}


}
[^]                 {return TokenType.BAD_CHARACTER;}
/*CRLF=\R
WHITE_SPACE=[\ \n\t\f]
FIRST_VALUE_CHARACTER=[^ \n\f\\] | "\\"{CRLF} | "\\".
VALUE_CHARACTER=[^\n\f\\] | "\\"{CRLF} | "\\".
END_OF_LINE_COMMENT=("#"|"!")[^\r\n]*
SEPARATOR=[:=]
KEY_CHARACTER=[^:=\ \n\t\f\\] | "\\ "

%state WAITING_VALUE

%%

<YYINITIAL> {END_OF_LINE_COMMENT}                           { yybegin(YYINITIAL); return ShaderTypes.COMMENT; }

<YYINITIAL> {KEY_CHARACTER}+                                { yybegin(YYINITIAL); return ShaderTypes.KEY; }

<YYINITIAL> {SEPARATOR}                                     { yybegin(WAITING_VALUE); return ShaderTypes.SEPARATOR; }

<WAITING_VALUE> {CRLF}({CRLF}|{WHITE_SPACE})+               { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

<WAITING_VALUE> {WHITE_SPACE}+                              { yybegin(WAITING_VALUE); return TokenType.WHITE_SPACE; }

<WAITING_VALUE> {FIRST_VALUE_CHARACTER}{VALUE_CHARACTER}*   { yybegin(YYINITIAL); return ShaderTypes.VALUE; }

({CRLF}|{WHITE_SPACE})+                                     { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

.                                                           { return TokenType.BAD_CHARACTER; }
*/