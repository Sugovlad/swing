package com.company.inteticks;

import javax.swing.*;
import javax.swing.event.TreeModelListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.stream.Collectors;

public class FileBrowser implements TreeModel {

    /**
     * Creating an object of this class and setting its root to the provided
     * File object.
     * <p>
     * The root is the highest directory available in an object of this class.
     *
     * @param file - an object of type File, giving the root directory for an
     *             object of type FileTreeModel.
     */
    public FileBrowser(File file) {
        this.root = file;
    }

    @Override
    public Object getRoot() {
        return this.root;
    }

    @Override
    public Object getChild(Object parent, int index) {
        File f = (File) parent;
        return f.listFiles()[index];
    }

    @Override
    public int getChildCount(Object parent) {
        File f = (File) parent;

        try {
            if (!f.isDirectory() && f.list() != null) {
                return 0;
            } else {
                return f.list().length;
            }
        } catch (NullPointerException ex) {
            return 0;
        }
    }

    @Override
    public boolean isLeaf(Object node) {
        File f = (File) node;
        return !f.isDirectory();
    }

    @Override
    public void valueForPathChanged(TreePath path, Object newValue) {
        // TODO Auto-generated method stub

    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        File par = (File) parent;
        File ch = (File) child;
        return Arrays.asList(par.listFiles()).indexOf(ch);
    }

    @Override
    public void addTreeModelListener(TreeModelListener l) {
        // TODO Auto-generated method stub
    }

    @Override
    public void removeTreeModelListener(TreeModelListener l) {
        // TODO Auto-generated method stub
    }


    private File root;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Smth");
        JTextArea textArea = new JTextArea();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        TreeModel fileModel = new FileBrowser(File.listRoots()[0]);

        frame.getContentPane().setLayout(new GridLayout(0, 3));
        frame.setSize(500, 400);
        JScrollPane scrollPane = new JScrollPane();
        var srcDirTree = new JTree(fileModel);
        srcDirTree.addTreeSelectionListener(e -> {
            Object object = e.getPath().getLastPathComponent();
            if (object instanceof File) {
                File file = (File) object;
                if (!file.isDirectory() && file.canRead()) {
                    System.out.println(file.getAbsolutePath());
                    try {
                        var actual = Files.readAllLines(file.toPath());
                        textArea.setText(String.join("\n", actual));
                        System.out.println(actual);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        });
        scrollPane.setViewportView(srcDirTree);
        frame.getContentPane().add(scrollPane);

        frame.getContentPane().add(textArea);


        frame.setVisible(true);
    }

}

