package com.shaojie.demo.simplebottomsheet;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.shaojie.demo.simplebottomsheet.widget.BottomSheet;


/**
 * 底部弹出框-测试
 *
 * @author Shaojie
 * @date 2016-04-15 11:18
 */
public class TestBottomSheet extends BottomSheet {

    public TestBottomSheet(Activity activity) {
        super(activity);
    }

    @Override
    public int getContentLayoutId() {
        return R.layout.bottom_sheet_test;
    }

    @Override
    public void initView(View root) {
        TestAdapter adapter = new TestAdapter(mActivity);
        ListView list = (ListView) root.findViewById(R.id.bs_test_list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                dismiss();
            }
        });

        final View closeText = root.findViewById(R.id.bs_test_close);
        final Button goBtn = (Button) root.findViewById(R.id.bs_test_go);
        closeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        goBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    /**
     * 重写高度占比
     *
     * @return 40%
     */
    @Override
    public float heightPercent() {
        return 0.4f;
    }

    public static class TestAdapter extends BaseAdapter {

        private static final String[] ITEMS = {"A", "B", "C", "D", "E", "F"};

        private Context mContext;

        public TestAdapter(Context context) {
            mContext = context;
        }

        @Override
        public int getCount() {
            return ITEMS.length;
        }

        @Override
        public Object getItem(int position) {
            return ITEMS[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            ViewHolder viewholder;
            if (view == null) {
                view = LayoutInflater.from(mContext).inflate(R.layout.list_item_test, null);
                viewholder = new ViewHolder();
                viewholder.name = (TextView) view.findViewById(R.id.list_item_demo_name);
                view.setTag(viewholder);
            } else {
                viewholder = (ViewHolder) view.getTag();
            }
            viewholder.name.setText(ITEMS[position]);
            return view;
        }

        private static class ViewHolder {
            TextView name;
        }
    }

}
