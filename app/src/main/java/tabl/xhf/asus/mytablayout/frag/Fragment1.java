package tabl.xhf.asus.mytablayout.frag;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import tabl.xhf.asus.mytablayout.R;
import tabl.xhf.asus.mytablayout.adapter.MyFr1Adapter;
import tabl.xhf.asus.mytablayout.bean.DataB;
import tabl.xhf.asus.mytablayout.tool.URL;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment {

    @BindView(R.id.fr1_gv)
    GridView gv;
    private View view;
    private List<DataB.DataBean.ForumListBean.GroupBean> glist;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragmen1, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        new Thread(){
            @Override
            public void run() {
                super.run();
                getData();
            }
        }.start();
    }

    private void getData() {
        RequestQueue rQueue = Volley.newRequestQueue(getActivity());
        StringRequest request = new StringRequest(Request.Method.GET, URL.path, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("tag","response"+response);
                Gson gson = new Gson();
                DataB bean = gson.fromJson(response,DataB.class);
                glist = bean.getData().getForum_list().get(0).getGroup();
                System.out.println("glist ==" + glist.toString());
                gv.setAdapter(new MyFr1Adapter(getActivity(),glist));
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        rQueue.add(request);
        rQueue.start();
    }
}
