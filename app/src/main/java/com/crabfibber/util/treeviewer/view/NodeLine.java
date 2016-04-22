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
		paint.setColor(Color.BLACK);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.drawLine(startView.getX()+25,startView.getY()+50,endView.getX()+25,endView.getY()+50,paint);
	}
}
