package com.crabfibber.util.treeviewer.data;

import android.support.annotation.Nullable;

import com.crabfibber.util.treeviewer.datastruct.PureNodeInfo;

import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * Created by fc on 2016/4/21.
 */
public class ConstructData {

	public static ArrayList<PureNodeInfo> getTreeData(){
		//TODO:for test
		ArrayList<PureNodeInfo> nodes=new ArrayList<>();

		//vertex
		nodes.add(newANode(null,"xnode"));

		//first floor
		nodes.add(newANode(nodes.get(0),"xanode"));
		nodes.add(newANode(nodes.get(0),"xbnode"));
		nodes.add(newANode(nodes.get(0),"xcnode"));

		//second floor
		nodes.add(newANode(nodes.get(1),"xaanode"));
		nodes.add(newANode(nodes.get(1),"xabnode"));
		nodes.add(newANode(nodes.get(2),"xbanode"));
		nodes.add(newANode(nodes.get(2),"xbbnode"));
		nodes.add(newANode(nodes.get(3),"xcanode"));
		nodes.add(newANode(nodes.get(3),"xcbnode"));

		return nodes;
	}

	private static PureNodeInfo newANode(@Nullable PureNodeInfo parent, String type){
		PureNodeInfo node=new PureNodeInfo();
		node.setType(type);
		node.setKey(UUID.randomUUID().toString());
		if(parent!=null){
			node.setParentKey(parent.getKey());
			parent.getChildKeyList().add(node.getKey());
		}
		return node;
	}

}
