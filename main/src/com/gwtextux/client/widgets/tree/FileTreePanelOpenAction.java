package com.gwtextux.client.widgets.tree;

import com.gwtext.client.widgets.tree.TreeNode;

public class FileTreePanelOpenAction {

	/**
	 * Fires before any open event so that the path can be changed
	 * @param fileTreePanel
	 * @param treeNode the node been opened
	 * @param path the current path that will be used
	 * @param mode of opening: popup, _self, _blank, download
	 * @return the new path to be used
	 */
	public String onOpenNodePath(FileTreePanel fileTreePanel, TreeNode treeNode, String path, String mode){
		return path;
	}

}
