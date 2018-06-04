package com.teng.codeInsight;

import com.intellij.codeInsight.daemon.LineMarkerInfo;
import com.intellij.codeInsight.daemon.LineMarkerProvider;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ShaderLineMarkerProvider implements LineMarkerProvider {
    @Nullable
    @Override
    public LineMarkerInfo getLineMarkerInfo(@NotNull PsiElement element) {
        return null;
    }

    @Override
    public void collectSlowLineMarkers(@NotNull List<PsiElement> elements, @NotNull Collection<LineMarkerInfo> result) {
        Iterator it = elements.iterator();
        while(it.hasNext()){
            PsiElement ele = (PsiElement) it.next();
            ProgressManager.checkCanceled();
            collectNavigationMarkers(ele,result);
        }
    }
    private void collectNavigationMarkers(PsiElement element,Collection<LineMarkerInfo> collection ){

    }
}
