package adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comedor_uacm.R;
import com.example.comedor_uacm.Ver_Ingrediente;
import com.example.comedor_uacm.entidades.Ingrediente;

import java.util.ArrayList;

public class listaIngredienteAdapter extends RecyclerView.Adapter<listaIngredienteAdapter.ingredientetoViewHolder> {

    ArrayList<Ingrediente> listaIngrediente;

    public listaIngredienteAdapter(ArrayList<Ingrediente> listaIngrediente) {
        this.listaIngrediente = listaIngrediente;
    }

    @NonNull
    @Override
    public ingredientetoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_ingrediente,null,false);
        return new ingredientetoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ingredientetoViewHolder holder, int position) {
        holder.id_ingrediente.setText(Integer.toString(listaIngrediente.get(position).getId()));
        holder.nombre_ingrediente.setText(listaIngrediente.get(position).getNombre());

    }

    @Override
    public int getItemCount() {
        return listaIngrediente.size();
    }

    public class ingredientetoViewHolder extends RecyclerView.ViewHolder {

        TextView id_ingrediente, nombre_ingrediente;
        public ingredientetoViewHolder(@NonNull View itemView) {
            super(itemView);
            id_ingrediente=itemView.findViewById(R.id.Id_i_ingrediente);
            nombre_ingrediente=itemView.findViewById(R.id.id_i_nomIngr);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context= itemView.getContext();
                    Intent i=new Intent(context, Ver_Ingrediente.class);
                    i.putExtra("id_ingrediente",listaIngrediente.get(getAdapterPosition()).getId());
                    context.startActivity(i);
                }
            });

        }
    }
}
