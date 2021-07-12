package com.akbar.doolanzquiz.adapter;


import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cahyonoz.doolanzquiz.R;
import com.cahyonoz.doolanzquiz.model.ModelSoal;

import java.util.List;

public class AdapterSoal extends RecyclerView.Adapter<AdapterSoal.SoalViewHolder> {


        List<ModelSoal> soal;
        public  AdapterSoal(List<ModelSoal> soal){
            this.soal = soal;
        }


        @Override
        public SoalViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_soal,viewGroup,false);

            SoalViewHolder mhsViewHolder = new SoalViewHolder(v);
            return mhsViewHolder;
        }
        @Override
        public void onBindViewHolder(SoalViewHolder mhsViewHolder , int i){
            mhsViewHolder.jwbn1.setText(soal.get(i).getJawaban1());
            mhsViewHolder.jwbn2.setText(soal.get(i).getJawaban2());
            mhsViewHolder.jwbn3.setText(soal.get(i).getJawaban3());
            mhsViewHolder.namaSoal.setText(soal.get(i).getNama_soal());
        }
        @Override
        public int getItemCount(){
            return  soal.size();
        }
        public ModelSoal getItem(int position){
            return soal.get(position);
        }
        @Override
        public  void onAttachedToRecyclerView(RecyclerView recyclerView){
            super.onAttachedToRecyclerView(recyclerView);
        }

        public static class SoalViewHolder extends RecyclerView.ViewHolder{
            CardView cv;
            TextView namaSoal;
            TextView jwbn1;
            TextView jwbn2;
            TextView jwbn3;
            SoalViewHolder(View itemView){
                super(itemView);
                cv = (CardView) itemView.findViewById(R.id.cv);
                jwbn1 = (TextView) itemView.findViewById(R.id.textViewRowJwB);
                jwbn2 = (TextView) itemView.findViewById(R.id.textViewRowJwS);
                jwbn3 = (TextView) itemView.findViewById(R.id.textViewJwbns);
                namaSoal = (TextView) itemView.findViewById(R.id.textViewRowNs);

            }

        }
}
/Adapter soal menumenu yang ada dalam soal/
