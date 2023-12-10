package adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.comedor_uacm.ItemPlatillo;
import com.example.comedor_uacm.R;
import com.example.comedor_uacm.RecyclerViewInterface;

import java.util.List;

public class RecyclerAdapter1 extends RecyclerView.Adapter<RecyclerAdapter1.RecyclerHolder>{

    private final RecyclerViewInterface recyclerViewInterface;
    private List<ItemPlatillo> items;
    public RecyclerAdapter1(List<ItemPlatillo> item, RecyclerViewInterface recyclerViewInterface)
    { this.items = item;
        this.recyclerViewInterface = recyclerViewInterface; }

    @NonNull
    @Override
    public RecyclerAdapter1.RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main4,parent,false);
        return new RecyclerHolder(view,recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerHolder holder, int position) {
        ItemPlatillo item = items.get(position);
        holder.imgItemm.setImageResource(item.getImgResource1());
        holder.tvTituloo.setText(item.getTitulo1());
        holder.tvDescripcionn.setText(item.getDescripcion1());
    }


    @Override
    public int getItemCount() { return items.size(); }

    public static class RecyclerHolder extends RecyclerView.ViewHolder{
        private ImageView imgItemm;
        private TextView tvTituloo;
        private TextView tvDescripcionn;


        public RecyclerHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface){
            super(itemView);
            imgItemm = itemView.findViewById(R.id.imgItemm);
            tvTituloo = itemView.findViewById(R.id.tvTituloo);
            tvDescripcionn = itemView.findViewById(R.id.tvDescripcionn);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recyclerViewInterface != null){
                        int pos = getAdapterPosition();
                        if(pos != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick(pos);
                        }

                    }
                }
            });

        }
    }
}
