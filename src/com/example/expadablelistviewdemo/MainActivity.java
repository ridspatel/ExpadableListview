package com.example.expadablelistviewdemo;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ExpandableListView;

public class MainActivity extends Activity {

	private ExpandListAdapter ExpAdapter;
	private ArrayList<Group> ExpListItems;
	private ExpandableListView ExpandList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ExpandList = (ExpandableListView) findViewById(R.id.expandableListview);
		ExpListItems = SetStandardGroups();
		ExpAdapter = new ExpandListAdapter(MainActivity.this, ExpListItems);
		ExpandList.setAdapter(ExpAdapter);
	}

	public ArrayList<Group> SetStandardGroups() {

		String group_names[] = { "GROUP A", "GROUP B" };

		String country_names[] = { "A Title", "B Title", "C Title", "D Title",
				"E Title", "F Title", "G Title", "H Title" };

		int Images[] = { R.drawable.one, R.drawable.two, R.drawable.three,
				R.drawable.four, R.drawable.five, R.drawable.six,
				R.drawable.seven, R.drawable.eight };

		ArrayList<Group> list = new ArrayList<Group>();

		ArrayList<Child> ch_list;

		int size = 4;
		int j = 0;

		for (String group_name : group_names) {
			Group gru = new Group();
			gru.setName(group_name);

			ch_list = new ArrayList<Child>();
			for (j = 0; j < size; j++) {
				Child ch = new Child();
				ch.setName(country_names[j]);
				ch.setImage(Images[j]);
				ch_list.add(ch);
			}
			gru.setItems(ch_list);
			list.add(gru);

//			size = size + 2;
		}

		return list;
	}

}
