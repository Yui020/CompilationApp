package com.example.mycompilation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mycompilation.GuidedAct.EighthGuided;
import com.example.mycompilation.GuidedAct.EleventhGuided;
import com.example.mycompilation.GuidedAct.EleventhGuided2;
import com.example.mycompilation.GuidedAct.FifthGuided;
import com.example.mycompilation.GuidedAct.FirstGuided;
import com.example.mycompilation.GuidedAct.FourthGuided;
import com.example.mycompilation.GuidedAct.NinthGuided;
import com.example.mycompilation.GuidedAct.SecondGuided;
import com.example.mycompilation.GuidedAct.SeventhGuided;
import com.example.mycompilation.GuidedAct.SixthGuided;
import com.example.mycompilation.GuidedAct.TenthGuided;
import com.example.mycompilation.GuidedAct.ThirdGuided;
import com.example.mycompilation.GuidedAct.ThirteenthGuided;
import com.example.mycompilation.GuidedAct.TwelvethGuided;
import com.example.mycompilation.MachineAct.FifthMachine;
import com.example.mycompilation.MachineAct.FourthMachine;
import com.example.mycompilation.MachineAct.SecondMachine;
import com.example.mycompilation.MachineAct.SixthMachineAct;

import java.util.ArrayList;

public class VPAdapter extends RecyclerView.Adapter<VPAdapter.ViewHolder> {

    ArrayList<CardVPLayout> cardVPLayoutArrayList;
    OnItemClickListener mListener;
    private Context context;

    // Interface for item click events
    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    // Method to set the listener
    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public VPAdapter(Context context, ArrayList<CardVPLayout> cardVPLayoutArrayList) {
        this.context = context;
        this.cardVPLayoutArrayList = cardVPLayoutArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_vp_layout,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        CardVPLayout viewPagerItem = cardVPLayoutArrayList.get(position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent();
                    switch (position) {
                        case 0:
                            intent = new Intent(context, SecondMachine.class);
                            break;
                        case 1:
                            intent = new Intent(context, FourthMachine.class);
                            break;
                        case 2:
                            intent = new Intent(context, FifthMachine.class);
                            break;
                        case 3:
                            intent = new Intent(context, SixthMachineAct.class);
                            break;
                        case 4:
                            intent = new Intent(context, FirstGuided.class);
                            break;
                        case 5:
                            intent = new Intent(context, SecondGuided.class);
                            break;
                        case 6:
                            intent = new Intent(context, ThirdGuided.class);
                            break;
                        case 7:
                            intent = new Intent(context, FourthGuided.class);
                            break;
                        case 8:
                            intent = new Intent(context, FifthGuided.class);
                            break;
                        //GUIDED ACTIVITY 6, 7, 8, 9, 10
                        case 9:
                            intent = new Intent(context, SixthGuided.class);
                            break;
                        case 10:
                            intent = new Intent(context, SeventhGuided.class);
                            break;
                        case 11:
                            intent = new Intent(context, EighthGuided.class);
                            break;
                        case 12:
                            intent = new Intent(context, NinthGuided.class);
                            break;
                        case 13:
                            intent = new Intent(context, TenthGuided.class);
                            break;

                        //GUIDED ACTIVITY 11, 12, 13 & 14
                        case 14:
                            intent = new Intent(context, EleventhGuided2.class);
                            break;
                        case 15:
                            intent = new Intent(context, EleventhGuided.class);
                            break;
                        case 16:
                            intent = new Intent(context, TwelvethGuided.class);
                            break;
                        case 17:
                            intent = new Intent(context, ThirteenthGuided.class);
                            break;
                        default:
                            break;
                    }
                    context.startActivity(intent);
                }
        });
        holder.txtheading.setText(viewPagerItem.heading);
    }

    @Override
    public int getItemCount() {
        return cardVPLayoutArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtheading;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtheading = itemView.findViewById(R.id.txt_display);

            // Set click listener for the item
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
