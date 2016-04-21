package com.crabfibber.util.treeviewer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.crabfibber.util.treeviewer.data.ConstructData;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

	@Bind(R.id.draw_tree) Button drawTree;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ButterKnife.bind(this);

	}

	@OnClick(R.id.draw_tree) void clickDrawTree(){
		Intent intent =new Intent(this,ParsingResultActivity.class);
		intent.putParcelableArrayListExtra("nodes",ConstructData.getTreeData());
		startActivity(intent);
	}


}
