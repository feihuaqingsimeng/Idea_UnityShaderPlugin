package com.teng.completion;


import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.openapi.util.Key;

import java.util.HashSet;

public class CompletionSession {

    private CompletionParameters parameters;
    private CompletionResultSet resultSet;
    private boolean isSuggestWords ;
    private HashSet words;

    public static Key KEY = Key.create("shader.CompletionSession");
    public CompletionSession(CompletionParameters parameters, CompletionResultSet resultSet){
        this.parameters = parameters;
        this.resultSet = resultSet;
        this.isSuggestWords = true;
        this.words = new HashSet();
    }
    public boolean addWord(String word){
        return words.add(word);
    }
    public CompletionResultSet getResultSet(){
        return resultSet;
    }

    public boolean containsWord(String word){
        return words.contains(word);
    }
    public static CompletionSession get(CompletionParameters parameters){
        return (CompletionSession) parameters.getEditor().getUserData(KEY);
    }
}
