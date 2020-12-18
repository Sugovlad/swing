package com.company.inteticks;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.io.File;

public class MyTree extends JTree {
    public MyTree() {
        super();
        this.addTreeSelectionListener(new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent e) {
                Object object = e.getPath().getLastPathComponent();
                if (object instanceof File){
                    File file = (File) object;
                    System.out.println(file.getAbsolutePath());
                }
            }
        });
    }
}