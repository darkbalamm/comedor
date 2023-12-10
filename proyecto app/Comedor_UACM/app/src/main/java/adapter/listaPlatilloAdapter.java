package adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comedor_uacm.Lista_platillo;
import com.example.comedor_uacm.R;
import com.example.comedor_uacm.UPlatillo;
import com.example.comedor_uacm.entidades.Platillos;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class listaPlatilloAdapter extends RecyclerView.Adapter<listaPlatilloAdapter.PlatillotoViewHolder> {

    ArrayList<Platillos> listaplatillos;
    public listaPlatilloAdapter(ArrayList<Platillos> listaplatillos){
        this.listaplatillos=listaplatillos;
    }
    @NonNull
    @Override
    public PlatillotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_platillo,null,false);
        return new PlatillotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlatillotoViewHolder holder, int position) {
        holder.id_platillo.setText(Integer.toString(listaplatillos.get(position).getId()));
        holder.nombre_platillo.setText(listaplatillos.get(position).getNombre());

    }

    @Override
    public int getItemCount() {
         return listaplatillos.size();
    }

    public class PlatillotoViewHolder extends RecyclerView.ViewHolder {
        TextView id_platillo,nombre_platillo;
        public PlatillotoViewHolder(@NonNull View itemView) {
            super(itemView);
            id_platillo=itemView.findViewById(R.id.id_platillo);
            nombre_platillo= itemView.findViewById((R.id.nombre_platillo));

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = itemView.getContext();
                    Intent i=new Intent(context, UPlatillo.class);
                    i.putExtra("id_platillo",listaplatillos.get(getAdapterPosition()).getId());
                    context.startActivity(i);
                }
            });

        }
    }
}
