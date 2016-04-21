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

			TreeView treeView=new TreeView(this);
			treeView.setNodeText(vertex.getType());
			treeView.setMinimumHeight(400);
			treeView.setMinimumWidth(400);
			layout.addView(treeView);
		}

	}

	class TreeView extends View {

		Paint paint=new Paint();

		public void setNodeText(String nodeText) {
			this.nodeText = nodeText;
		}

		String nodeText;


		public TreeView(Context context) {
			super(context);

		}

		@Override
		protected void onDraw(Canvas canvas) {
			super.onDraw(canvas);
			float pxDensity = getContext().getResources().getDisplayMetrics().scaledDensity;

			paint.setAntiAlias(true);
			paint.setColor(Color.BLACK);
			paint.setStrokeWidth(2);
			paint.setStyle(Paint.Style.FILL);
			canvas.drawCircle(50,50,20*pxDensity,paint);
//			canvas.drawRect(20,20,60*pxDensity,60*pxDensity,paint);

			paint.setColor(Color.WHITE);
			paint.setTextSize(10 * pxDensity);
			paint.setTypeface(Typeface.DEFAULT_BOLD);       //黑体

			Rect bounds = new Rect();
			paint.getTextBounds(nodeText, 0, nodeText.length(), bounds);

			canvas.drawText(nodeText, 30, 30, paint);
		}
	}

	private void constructTreeView(){

	}

	private void drawView(){

	}

	private void drawNode(){
		Paint paint=new Paint();

	}
}
