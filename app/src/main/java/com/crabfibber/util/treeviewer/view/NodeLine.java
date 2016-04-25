package com.crabfibber.util.treeviewer.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * line
 * Created by fc on 2016/4/22.
 */
public class NodeLine extends View{

	Paint paint=new Paint();
	View startView;
	View endView;

	public NodeLine(Context context) {
		super(context);
	}

	public NodeLine(Context context,View startView,View endView){
		super(context);
		this.startView=startView;
		this.endView=endView;
		paint.setStrokeWidth(2);
		paint.setColor(Color.BLACK);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		float pxDensity = getContext().getResources().getDisplayMetrics().scaledDensity;
		canvas.drawLine(startView.getX()+30*pxDensity,startView.getY()+60*pxDensity,endView.getX()+30*pxDensity,endView.getY(),paint);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		float pxDensity = getContext().getResources().getDisplayMetrics().scaledDensity;
		setMeasuredDimension((int) (endView.getX()+30*pxDensity), (int) endView.getY());
	}
}
