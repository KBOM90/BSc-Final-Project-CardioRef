package com.example.cardioref_homepage.adaptors;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cardioref_homepage.R;
import com.example.cardioref_homepage.model.TypesOfCVDs;

import java.util.List;

public class CvdAdaptor extends RecyclerView.Adapter<CvdAdaptor.MyViewHolder> {
    Context context;
    List<TypesOfCVDs> cvdList;
    private OnClickListener onClickListener;

    public CvdAdaptor(Context context, List<TypesOfCVDs> cvdList) {
        this.context = context;
        this.cvdList = cvdList;
    }

    @NonNull
    @Override
    public CvdAdaptor.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate
                (R.layout.one_line_cvds, parent, false);
        return new CvdAdaptor.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CvdAdaptor.MyViewHolder holder,  int position) {
        holder.tv_cvd_short_hand.setText(cvdList.get(position).getCvdShorthand());
        holder.tv_cvd_type.setText(cvdList.get(position).getCvdType());
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onClickListener.onClick(position);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return cvdList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_cvd_short_hand, tv_cvd_type;
        ConstraintLayout parent;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_cvd_short_hand = itemView.findViewById(R.id.tv_short_hand);
            tv_cvd_type = itemView.findViewById(R.id.tv_cvd_types);
            parent = itemView.findViewById(R.id.one_cvd);
            itemView.setOnClickListener(v -> {
                onClickListener.onClick(getAdapterPosition());
            });
        }
    }


    public interface OnClickListener {
        void onClick(int position);

    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

}
