package com.teng.completion;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.util.ProcessingContext;
import com.teng.Language.ShaderLanguage;
import com.teng.psi.ShaderTypes;
import org.jetbrains.annotations.NotNull;


public class ShaderCompletionContributor extends CompletionContributor {
    public ShaderCompletionContributor(){
        extend(CompletionType.BASIC, PlatformPatterns.psiElement(ShaderTypes.VALUE).withLanguage(ShaderLanguage.Instance),
                new CompletionProvider<CompletionParameters>() {
                    @Override
                    protected void addCompletions(@NotNull CompletionParameters parameters, ProcessingContext context, @NotNull CompletionResultSet result) {
                        result.addElement(LookupElementBuilder.create("hello"));
                    }
                });
    }
}
