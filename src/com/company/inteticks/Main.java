//package com.company.inteticks;
//
//import javax.swing.*;
//import javax.swing.tree.DefaultMutableTreeNode;
//import javax.swing.tree.DefaultTreeModel;
//import java.io.File;
//
//public class Main {
//
//    public static void main(String[] args) {
//        JFrame frame = new JFrame("File Browser");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        File fileRoot = new File("C:/");
//        var root = new DefaultMutableTreeNode(new FileNode(fileRoot));
//        var treeModel = new DefaultTreeModel(root);
//
//        var tree = new JTree(treeModel);
//        tree.setShowsRootHandles(true);
//        JScrollPane scrollPane = new JScrollPane(tree);
//
//        frame.add(scrollPane);
//        frame.setLocationByPlatform(true);
//        frame.setSize(640, 480);
//        frame.setVisible(true);
//
//        var ccn = new ChildNodesCreation(fileRoot, root);
//        new Thread(ccn).start();
//
//    }
//}
