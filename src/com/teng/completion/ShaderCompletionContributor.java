package com.teng.completion;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.lang.cacheBuilder.WordOccurrence;
import com.intellij.lang.cacheBuilder.WordsScanner;
import com.intellij.lang.findUsages.LanguageFindUsages;
import com.intellij.openapi.editor.Document;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import com.intellij.util.Processor;
import com.teng.Language.ShaderLanguage;
import com.teng.Util.IconUtil;
import com.teng.psi.ShaderFile;
import org.jetbrains.annotations.NotNull;

public class ShaderCompletionContributor extends CompletionContributor {
    public ShaderCompletionContributor(){

    }

    @Override
    public void fillCompletionVariants(@NotNull CompletionParameters parameters, @NotNull CompletionResultSet result) {
        CompletionSession session = new CompletionSession(parameters,result);
        parameters.getEditor().putUserData(CompletionSession.KEY,session);
        super.fillCompletionVariants(parameters,result);
        if(!result.isStopped()){
            suggestWordsInFile(parameters);
        }
    }

    @Override
    public void beforeCompletion(@NotNull CompletionInitializationContext context) {
        PsiFile file = context.getFile();
        if (file instanceof ShaderFile){
            PsiElement element = file.findElementAt(context.getCaret().getOffset() -1);
            if(element != null){
                IElementType type = element.getNode().getElementType();

            }
        }
        super.beforeCompletion(context);
    }
    private static void suggestWordsInFile(CompletionParameters parameters){
        CompletionSession session = CompletionSession.get(parameters);
        PsiElement originPosition = parameters.getOriginalPosition();
        if(originPosition != null){
            session.addWord(originPosition.getText());
        }
        WordsScanner scanner = LanguageFindUsages.INSTANCE.forLanguage(ShaderLanguage.Instance).getWordsScanner();
        if (scanner != null){
            Document document = parameters.getEditor().getDocument();
            scanner.processWords(document.getCharsSequence(), new Processor<WordOccurrence>() {
                public final boolean process(WordOccurrence it) {
                    String word = it.getBaseText().subSequence(it.getStart(), it.getEnd()).toString();
                    if (session.addWord(word)) {
                        session.getResultSet().addElement(PrioritizedLookupElement.withPriority((LookupElement) LookupElementBuilder.create(word).withIcon(IconUtil.FILE), -1.0));
                    }

                    return true;
                }
            });

        }
    }
}
