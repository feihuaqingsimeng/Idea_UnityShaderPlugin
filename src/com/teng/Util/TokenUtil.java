package com.teng.Util;

import com.intellij.psi.tree.TokenSet;
import com.teng.psi.ShaderTypes;

import static com.teng.psi.ShaderTypes.*;
public class TokenUtil {
    //实参类型

    public static TokenSet actualParameterSet = TokenSet.create(ID,NUMBER,STRING,TRUE,FALSE);
    //
    public static TokenSet literalSet = TokenSet.create(NUMBER ,STRING ,NULL,FALSE);
    public static TokenSet stringSet = TokenSet.create( STRING );
    public static TokenSet basicDataTypeSet = TokenSet.create(ID);
    public static TokenSet methodTypeSet = TokenSet.create(VOID,ID);

    public static TokenSet commentSet = TokenSet.create(ShaderTypes.SHORT_COMMENT,ShaderTypes.BLOCK_COMMENT);
}
