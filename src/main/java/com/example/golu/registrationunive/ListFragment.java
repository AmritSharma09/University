package com.example.golu.registrationunive;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {

    RecyclerView rec;
    MyAdapter myAdapter;
    MyDataBase myDataBase;
    Cursor cursor;
    public ListFragment() {
        // Required empty public constructor
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        myDataBase.close();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_list, container, false);
        rec=(RecyclerView)v.findViewById(R.id.rec);
        myAdapter=new MyAdapter();
        myDataBase=new MyDataBase(getActivity());
        myDataBase.open();
        cursor=myDataBase.queryStudent();
        rec.setAdapter(myAdapter);
        LinearLayoutManager mng=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL, false);
        rec.setLayoutManager(mng);

        return v;
    }




    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            //Load Row XML
            View view=getActivity().getLayoutInflater().inflate(R.layout.row,parent,false);
            //pass row xml to view holder
            ViewHolder viewHolder=new ViewHolder(view);

            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            cursor.moveToPosition(position);
            holder.tv1.setText(""+cursor.getInt(0));
            holder.tv2.setText(cursor.getString(2));
            holder.tv3.setText(cursor.getString(4));
            holder.tv4.setText(cursor.getString(3));
            holder.tv5.setText(cursor.getString(5));
            holder.tv6.setText(cursor.getString(7));
        }

        @Override
        public int getItemCount() {
            return cursor.getCount();
        }

        public class ViewHolder extends RecyclerView.ViewHolder{
            public TextView tv1,tv2,tv3,tv4,tv5,tv6;
            public CheckBox cb1;
            public ViewHolder(View itemView) {
                super(itemView);

                tv1=(TextView)itemView.findViewById(R.id.tv_count);
                tv2=(TextView)itemView.findViewById(R.id.tv_name);
                tv3=(TextView)itemView.findViewById(R.id.tv_mail);
                tv4=(TextView)itemView.findViewById(R.id.tv_mobile);
                tv5=(TextView)itemView.findViewById(R.id.tv_sub);
                tv6=(TextView)itemView.findViewById(R.id.tv_date);
            }
        }
    }
}
