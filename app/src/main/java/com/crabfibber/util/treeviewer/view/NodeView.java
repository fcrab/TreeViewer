package com.crabfibber.util.treeviewer.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;

import com.crabfibber.util.treeviewer.R;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by fc on 2016/4/21.
 */
public class NodeView extends View {
	Paint paint=new Paint();
	Rect bounds=new Rect();

	public void setNodeText(String nodeText) {
		this.nodeText = nodeText;
	}

	String nodeText;


	public NodeView(Context context) {
		super(context);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		float pxDensity = getContext().getResources().getDisplayMetrics().scaledDensity;

		//背景部分
		paint.setAntiAlias(true);
		paint.setColor(getResources().getColor(android.R.color.transparent));       //背景透明
		canvas.drawRect(0,0,60*pxDensity,60*pxDensity,paint);

		//圆形背景
		paint.setColor(getResources().getColor(colorList.get(5)));
		paint.setStyle(Paint.Style.FILL);
		canvas.drawCircle(30*pxDensity,30*pxDensity,30*pxDensity,paint);

		paint.setColor(Color.WHITE);
		paint.setTextSize(10*pxDensity);
		paint.setTypeface(Typeface.DEFAULT_BOLD);       //黑体

		paint.getTextBounds(nodeText, 0, nodeText.length(), bounds);
		float textWidth= paint.measureText(nodeText);
		int xPos=(canvas.getWidth()/2-(int)(textWidth/2f));
		int yPos = (int) ((canvas.getHeight() / 2) - ((paint.descent() + paint.ascent()) / 2));
		canvas.drawText(nodeText, xPos, yPos, paint);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		float pxDensity = getContext().getResources().getDisplayMetrics().scaledDensity;

		setMeasuredDimension((int) (60*pxDensity),(int) (60*pxDensity));
	}

	private static final List<Integer> colorList = new ArrayList<Integer>() {{
		add(R.color.avatar_0);
		add(R.color.avatar_1);
		add(R.color.avatar_2);
		add(R.color.avatar_3);
		add(R.color.avatar_4);
		add(R.color.avatar_5);
		add(R.color.avatar_6);
	}};
}
