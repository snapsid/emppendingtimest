package com.example.employabilitytracking;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class ChatListAdapter extends BaseAdapter {

    private Activity mActivity;
    private DatabaseReference mDatabaseReference;
    private String mDisplayName;
    private ArrayList<DataSnapshot> mSnapshotLists;
    public static String aadh11;

    public static Long timecheck=null;


    private ChildEventListener mListener=new ChildEventListener() {
        @Override
        public void onChildAdded(DataSnapshot dataSnapshot, String s) {

            mSnapshotLists.add(dataSnapshot);
            notifyDataSetChanged();
        }

        @Override
        public void onChildChanged(DataSnapshot dataSnapshot, String s) {

        }

        @Override
        public void onChildRemoved(DataSnapshot dataSnapshot) {

        }

        @Override
        public void onChildMoved(DataSnapshot dataSnapshot, String s) {

        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    };

    public ChatListAdapter(Activity activity, DatabaseReference ref, String name){

        mActivity=activity;
        mDisplayName=name;
        mDatabaseReference=ref.child("candidate");
        mDatabaseReference.addChildEventListener(mListener);

        timecheck = System.currentTimeMillis();
        Log.d("timecheck", timecheck.toString());

        mSnapshotLists=new ArrayList<>();
    }

    static  class ViewHolder{
        TextView authorName;
        TextView body;
        LinearLayout.LayoutParams params;

        TextView aadh;
        LinearLayout mLinearLayout;
        Button update;
    }
    @Override
    public int getCount() {
        return mSnapshotLists.size();
    }

    @Override
    public InstandMessage getItem(int i) {

        DataSnapshot snapshot=mSnapshotLists.get(i);
        return snapshot.getValue(InstandMessage.class);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view==null)
        {
            LayoutInflater inflater=(LayoutInflater) mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(R.layout.chat_msg_row, viewGroup, false);

            final ViewHolder holder=new ViewHolder();
            holder.authorName=(TextView) view.findViewById(R.id.author);
            holder.body=(TextView) view.findViewById(R.id.message);
            holder.params=(LinearLayout.LayoutParams) holder.authorName.getLayoutParams();
            holder.aadh=(TextView) view.findViewById(R.id.aadharid);
            holder.mLinearLayout=(LinearLayout) view.findViewById(R.id.linearid);
            holder.update=(Button) view.findViewById(R.id.updatebutid);


            view.setTag(holder);
        }

        final InstandMessage message=getItem(i);
        final ViewHolder holder=(ViewHolder) view.getTag();

        //boolean isMe=message.getAuthor().equals(mDisplayName);
        //setChatRowApperance(isMe, holder);

//        String author=message.getAuthor();
//        holder.authorName.setText(author);


        String msg=message.getName();

        String aadhar=message.getAadhar();


        Log.d("aadhar", aadhar);


        String time11="n";

        time11=message.getTimestamp();

        Long timeoffilling=Long.valueOf(time11);

        Log.d("xxx3", timeoffilling.toString());
        timeoffilling = timeoffilling + Long.valueOf(2*60*1000);

        Log.d("xxx1", timeoffilling.toString());
        Log.d("xxx2", timecheck.toString());

        Log.d("time11", timeoffilling.toString());

        if (timecheck > timeoffilling) {
            Log.d("check1", "yes");
           holder.body.setText("Name: "+msg);
           holder.aadh.setText("Aadhar: "+aadhar);
           holder.mLinearLayout.setVisibility(View.VISIBLE);


           holder.update.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   aadh11=holder.aadh.getText().toString();
                   aadh11=aadh11.substring(8);
                   Log.d("newaad", aadh11);

                    Intent intent=new Intent(mActivity, after3months1.class);
                    mActivity.startActivity(intent);
               }
           });
        }



        return view;
    }


    private void setChatRowApperance(boolean isItMe, ViewHolder holder){

        if(isItMe){
            holder.params.gravity= Gravity.END;
            holder.authorName.setTextColor(Color.BLUE);
        }
        else{
            holder.params.gravity= Gravity.START;
            holder.authorName.setTextColor(Color.RED);
        }

        holder.authorName.setLayoutParams(holder.params);
        holder.body.setLayoutParams(holder.params);
    }
    void  cleanup() {
        mDatabaseReference.removeEventListener(mListener);
    }
}
