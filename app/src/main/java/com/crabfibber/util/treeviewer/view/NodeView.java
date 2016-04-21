package com.crabfibber.util.treeviewer.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;

/**
 *
 * Created by fc on 2016/4/21.
 */
public class NodeView extends View {
	Paint paint=new Paint();

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
