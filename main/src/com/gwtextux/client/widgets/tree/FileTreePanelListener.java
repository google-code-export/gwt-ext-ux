package com.gwtextux.client.widgets.tree;

import com.gwtext.client.core.ExtElement;
import com.gwtext.client.widgets.tree.TreeNode;
import com.gwtext.client.widgets.tree.event.TreePanelListener;

public interface FileTreePanelListener extends TreePanelListener{

	/**
	 * Fires before file open. Return false to cancel the event
	 * @param fileTreePanel
	 * @param filename name of the file being opened
	 * @param url of the file being opened
	 * @param mode open mode
	 * @return true to proceed or false to cancel event
	 */
	public boolean onBeforeOpen(FileTreePanel fileTreePanel, String filename, String url, String mode);
	
	/**
	 * Fires after file open has been initiated
	 * @param fileTreePanel
	 * @param filename name of the file being opened
	 * @param url of the file being opened
	 * @param mode open mode
	 */
	public void onOpen(FileTreePanel fileTreePanel, String filename, String url, String mode);
	
	/**
	 * Fires after the user completes file name editing 
	 * but before the file is renamed. Return false to cancel the event
	 * @param fileTreePanel
	 * @param treeNode node that has been renamed
	 * @param newName newPath including file name 
	 * @param oldName oldPath including file name 
	 * @return true to proceed or false to cancel event
	 */
	public boolean onBeforeRename(FileTreePanel fileTreePanel, TreeNode treeNode, String newName, String oldName);
	
	/**
	 * Fires after the file has been successfully renamed
	 * @param fileTreePanel
	 * @param treeNode node that has been renamed
	 * @param newName newPath including file name 
	 * @param oldName oldPath including file name 
	 * @return true to proceed or false to cancel event
	 */
	public void onRename(FileTreePanel fileTreePanel, TreeNode treeNode, String newName, String oldName);

	/**
	 * Fires after a failure when renaming file
	 * @param fileTreePanel
	 * @param treeNode node that has been renamed
	 * @param newName newPath including file name 
	 * @param oldName oldPath including file name 
	 */
	public void onRenameFailure(FileTreePanel fileTreePanel, TreeNode treeNode, String newName, String oldName);

	/**
	 * Fires before a file or directory is deleted. Return false to cancel the event.
	 * @param fileTreePanel
	 * @param treeNode node being deleted
	 * @return true to proceed or false to cancel event
	 */
	public boolean onBeforeDelete(FileTreePanel fileTreePanel, TreeNode treeNode);
	
	/**
	 * Fires after a file or directory has been deleted
	 * @param fileTreePanel
	 * @param path including file name that has been deleted
	 */
	public void onDelete(FileTreePanel fileTreePanel, String path);
	
	/**
	 * Fires if node delete failed
	 * @param fileTreePanel
	 * @param treeNode node delete of which failed
	 */
	public void onDeleteFailure(FileTreePanel fileTreePanel, TreeNode treeNode);
	
	/**
	 * Fires before new directory is created. Return false to cancel the event
	 * @param fileTreePanel
	 * @param treeNode node under which the new directory is being created
	 * @return true to proceed or false to cancel event
	 */
	public boolean onBeforeNewDir(FileTreePanel fileTreePanel, TreeNode treeNode);
	
	/**
	 * Fires after the new directory has been successfully created
	 * @param fileTreePanel
	 * @param treeNode new node/directory that has been created
	 */
	public void onNewDir(FileTreePanel fileTreePanel, TreeNode treeNode);

	/**
	 * Fires if creation of new directory failed
	 * @param fileTreePanel
	 * @param path path creation of which failed
	 */
	public void onNewDirFailure(FileTreePanel fileTreePanel, String path);
	
	/**
	 * Fires before the file is added to store. Return false to cancel the add
	 * @param fileTreePanel
	 * @param element input (type=file) being added
	 * @return true to proceed or false to cancel event
	 */
	public boolean onBeforeFileAdd(FileTreePanel fileTreePanel, ExtElement element);
	
}
