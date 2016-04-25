package com.crabfibber.util.treeviewer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;


import com.crabfibber.util.treeviewer.datastruct.PureNodeInfo;
import com.crabfibber.util.treeviewer.view.NodeLine;
import com.crabfibber.util.treeviewer.view.NodeView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParsingResultActivity extends AppCompatActivity {

	RelativeLayout layout;

	ArrayList<PureNodeInfo> nodes;

	PureNodeInfo vertex;

	View vertexView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_parsing_result);

		nodes=getIntent().getParcelableArrayListExtra("nodes");

		//找出树形控件的顶点
		if(nodes!=null){
			for(PureNodeInfo node:nodes){
				if(node.getParentKey()==null){
					vertex=node;
					break;
				}
			}

			layout=(RelativeLayout)findViewById(R.id.content);

			vertexView=addNodes(null,null,vertex);
			recursionDrawnodes(vertex.getChildKeyList(),vertexView,null);

		}

	}

	//循环画线
	private View recursionDrawnodes(List<String> nodeKeys,View parent,@Nullable View leftSide){
		Map<String,View> viewMap=new HashMap<>();
		View cView=null;
		if(leftSide!=null){
			cView=leftSide;
		}
		for(String key:nodeKeys){
			for(PureNodeInfo aNode:nodes){
				if(aNode.getKey().equals(key)){
					View current=addNodes(parent,cView,aNode);
					addLine(parent,current);
					viewMap.put(key,current);
					cView=current;
					break;
				}
			}
		}

		View childLeft=null;
		for(String key:nodeKeys){
			for(PureNodeInfo aNode:nodes){
				if(aNode.getKey().equals(key)){
					childLeft=recursionDrawnodes(aNode.getChildKeyList(),viewMap.get(key),childLeft);
					break;
				}
			}
		}
		return cView;
	}


	//添加点
	private NodeView addNodes(@Nullable View parent,@Nullable View brother, PureNodeInfo node){
		NodeView treeView=new NodeView(this);
		treeView.setId(View.generateViewId());
		treeView.setNodeText(node.getType());

		RelativeLayout.LayoutParams nodeParams= new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
		nodeParams.setMargins(50,50,50,50);
		if(parent !=null){
			nodeParams.addRule(RelativeLayout.BELOW,parent.getId());
		}
		if(brother!=null){
			nodeParams.addRule(RelativeLayout.RIGHT_OF,brother.getId());
		}
		//顶点
		layout.addView(treeView,nodeParams);
		return treeView;
	}

	//添加线
	private void addLine(View startView,View endView){
		NodeLine line= new NodeLine(this,startView,endView);
//		RelativeLayout.LayoutParams lineParams= new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
		layout.addView(line);
	}
}
