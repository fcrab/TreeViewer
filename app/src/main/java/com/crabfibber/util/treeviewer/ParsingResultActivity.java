package com.crabfibber.util.treeviewer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;


import com.crabfibber.util.treeviewer.datastruct.PureNodeInfo;
import com.crabfibber.util.treeviewer.view.NodeView;

import java.util.ArrayList;

public class ParsingResultActivity extends AppCompatActivity {

	RelativeLayout layout;

	ArrayList<PureNodeInfo> nodes;

	PureNodeInfo vertex;

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

			NodeView treeView=new NodeView(this);
			treeView.setNodeText(vertex.getType());
			treeView.setMinimumHeight(400);
			treeView.setMinimumWidth(400);
			layout.addView(treeView);
		}

	}

}
