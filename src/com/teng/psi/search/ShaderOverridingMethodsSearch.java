package com.teng.psi.search;

import com.intellij.psi.search.searches.ExtensibleQueryFactory;

public class ShaderOverridingMethodsSearch extends ExtensibleQueryFactory {
    public static ShaderOverridingMethodsSearch Instance = new ShaderOverridingMethodsSearch();

    private ShaderOverridingMethodsSearch()
    {
        super("com.teng");
    }


}
