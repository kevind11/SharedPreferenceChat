package com.example.d2j_00.uts_a11201508751;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by D2J-00 on 01/11/2017.
 */
public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatAdapterViewHolder> {

    private List<Chat> mData;
    public ChatAdapter(List<Chat> data){
        mData = data;
    }
    @Override
    public ChatAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View content = LayoutInflater.from(context).inflate(R.layout.item_chat, parent, false);
        return new ChatAdapterViewHolder(content);
    }

    @Override
    public void onBindViewHolder(ChatAdapterViewHolder holder, int position) {
        holder.mTanggal.setText(mData.get(position).getmTanggal());
        holder.mPengirim.setText(mData.get(position).getmPengirim());
        holder.mPesan.setText(mData.get(position).getmPesan());
        holder.mImage.setImageResource(mData.get(position).getmImagaView());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
    public void addChat(Chat chat){
        mData.add(chat);
        notifyItemInserted(mData.size()-1);
    }
    public class ChatAdapterViewHolder extends RecyclerView.ViewHolder{
        private TextView mTanggal;
        private TextView mPengirim;
        private TextView mPesan;
        private ImageView mImage;
        public ChatAdapterViewHolder(View itemView) {
            super(itemView);
            mTanggal = (TextView) itemView.findViewById(R.id.mTanggal);
            mPengirim = (TextView) itemView.findViewById(R.id.mPengirim);
            mPesan = (TextView) itemView.findViewById(R.id.mPesan);
            mImage = (ImageView) itemView.findViewById(R.id.mImageView);
        }

    }
}
