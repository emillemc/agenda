package com.example.emillemartins.agendinha;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

// o recycle tem o viewholder que possui mais velocidade e melhor peformance

// o adapter serve para ligar a view dos itens da lista com as info que tao no objeto que serão utilizados
//listados la no conteudo


/**
 * Created by emillemartins on 16/03/17.
 */

public class RecyclerTesteAdapter extends RecyclerView.Adapter<RecyclerTesteAdapter.RecyclerTesteViewHolder> {

    public static ClickRecyclerView_Interface clickRecyclerViewInterface;
    Context mctx;
    private List<Pessoa> mList;

    public RecyclerTesteAdapter(Context ctx, List<Pessoa> list, ClickRecyclerView_Interface clickRecyclerViewInterface) {
        this.mctx = ctx;
        this.mList = list;
        this.clickRecyclerViewInterface = clickRecyclerViewInterface;
    }

    @Override
    public RecyclerTesteViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_lista, viewGroup, false);
        return new RecyclerTesteViewHolder(itemView);
    }

    //onde  é pego o objeto da lista e passado para a view,
    //onde será mostrado os dados daquele objeto.
    @Override
    public void onBindViewHolder(RecyclerTesteViewHolder viewHolder, int i) {
        Pessoa pessoa = mList.get(i);

        viewHolder.viewNome.setText(pessoa.getNome());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    //aonde declara as views que serão usadas no onBindViewholder
    // e que estarão no arquivo item_lista.xml.


    protected class RecyclerTesteViewHolder extends RecyclerView.ViewHolder {

        protected TextView viewNome;

        public RecyclerTesteViewHolder(final View itemView) {
            super(itemView);

            viewNome = (TextView) itemView.findViewById(R.id.textview_nome);

            //Setup the click listener
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    clickRecyclerViewInterface.onCustomClick(mList.get(getLayoutPosition()));

                }
            });
        }
    }
}