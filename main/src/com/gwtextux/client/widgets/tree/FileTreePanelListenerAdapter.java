package com.gwtextux.client.widgets.tree;

import com.gwtext.client.core.ExtElement;
import com.gwtext.client.widgets.tree.TreeNode;
import com.gwtext.client.widgets.tree.event.TreePanelListenerAdapter;

public class FileTreePanelListenerAdapter extends TreePanelListenerAdapter implements
		FileTreePanelListener {

	public boolean onBeforeDelete(FileTreePanel fileTreePanel,
			TreeNode treeNode) { 
		return true;
	}

	public boolean onBeforeNewDir(FileTreePanel fileTreePanel,
			TreeNode treeNode) {
		return true;
	}

	public boolean onBeforeOpen(FileTreePanel fileTreePanel, String filename,
			String url, String mode) {
		return true;
	}

	public boolean onBeforeRename(FileTreePanel fileTreePanel,
			TreeNode treeNode, String newName, String oldName) {
		return true;
	}

	public void onDelete(FileTreePanel fileTreePanel, String path) {
	}

	public void onDeleteFailure(FileTreePanel fileTreePanel,
			TreeNode treeNode) {
	}

	public void onNewDir(FileTreePanel fileTreePanel, TreeNode treeNode) {
	}

	public void onNewDirFailure(FileTreePanel fileTreePanel, String path) {
	}

	public void onOpen(FileTreePanel fileTreePanel, String filename,
			String url, String mode) {
	}

	public void onRename(FileTreePanel fileTreePanel,
			TreeNode treeNode, String newName, String oldName) {
	}

	public void onRenameFailure(FileTreePanel fileTreePanel,
			TreeNode treeNode, String newName, String oldName) {
	}

	public boolean onBeforeFileAdd(FileTreePanel fileTreePanel, ExtElement element){
		return true;
	}
	
	public String onOpenNodePath(FileTreePanel fileTreePanel, TreeNode treeNode, String path, String mode){
		return path;
	}
}
