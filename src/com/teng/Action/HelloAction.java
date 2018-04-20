package com.teng.Action;

import com.intellij.ide.highlighter.JavaFileType;
import com.intellij.ide.projectWizard.ModuleTypeCategory;
import com.intellij.lang.LanguageParserDefinitions;
import com.intellij.lang.java.JavaLanguage;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.psi.*;
import com.intellij.psi.util.PsiTreeUtil;
import com.teng.Language.ShaderFileType;
import org.jetbrains.java.generate.element.ElementFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HelloAction extends AnAction {
    @Override
    public void actionPerformed(AnActionEvent e) {
        Project project = e.getData(PlatformDataKeys.PROJECT);
        PsiFile file = e.getData(PlatformDataKeys.PSI_FILE);

        Editor editor = e.getData(PlatformDataKeys.EDITOR);
        String text = file.getText();//editor.getSelectionModel().getSelectedText();
        //PsiElement element = file.findElementAt(editor.getCaretModel().getOffset());
        System.out.println("text:"+text);
        String s = "[a-zA-Z_][a-zA-Z_0-9]*\\s*:\\s*[a-zA-Z_]*\\s*\\(.*\\)\\s*\\{[\\s\\S]*?}";
        Pattern pat = Pattern.compile(s);
        Matcher m = pat.matcher(text);
        System.out.println("=============================");
        while(m.find())
        {

            System.out.println(m.group());
            System.out.println("=============================");
        }
        Pattern pattern = Pattern.compile("[_a-zA-Z][_a-zA-Z0-9]*( )*=( )*[_a-zA-Z0-9]");
        Matcher mat = pattern.matcher(text);
        if(!mat.find())
        {
            return;
        }
        PsiFile f = PsiFileFactory.getInstance(project).createFileFromText("test", JavaLanguage.INSTANCE,"\nfunction a:test()  \nend\n");
        WriteCommandAction.Simple simple = new WriteCommandAction.Simple(project) {
            @Override
            protected void run() throws Throwable {
                file.add(f);
            }
        };
        simple.execute();
        //String txt= Messages.showInputDialog(project, "name?", "Input your name", Messages.getQuestionIcon());
        //Messages.showMessageDialog(project, "Hello, " + txt + "!\n ", "Information", Messages.getInformationIcon());
    }
}
