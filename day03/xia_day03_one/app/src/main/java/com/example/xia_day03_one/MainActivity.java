package com.example.xia_day03_one;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private XRecyclerView mXrv;
    private MyAdapter myAdapter;
    private List<User> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initmore();
    }

    private void initmore() {
        List<User> show = Mydao.show();
        list.clear();
        list.addAll(show);
        myAdapter.notifyDataSetChanged();
    }

    private void initView() {
        mXrv = (XRecyclerView) findViewById(R.id.xrv);
        mXrv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        list = new ArrayList<>();
        myAdapter = new MyAdapter(this, list);
        for (int i = 0; i <20 ; i++) {
            User user = new User();
            user.setDesc("我爱Android"+i);
            user.setUrl(R.mipmap.ic_launcher);
            Mydao.insert(user);

        }

        mXrv.setAdapter(myAdapter);
        myAdapter.setOnClick(new MyAdapter.OnClick() {
            @Override
            public void OnClick(int psoition) {
                User user = list.get(psoition);
                list.remove(user);
                myAdapter.notifyDataSetChanged();
                Mydao.dalete(user);
                Toast.makeText(MainActivity.this, "删除成功", Toast.LENGTH_SHORT).show();
            }
        });
        mXrv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mXrv.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                mXrv.loadMoreComplete();
            }
        });
    }
}
