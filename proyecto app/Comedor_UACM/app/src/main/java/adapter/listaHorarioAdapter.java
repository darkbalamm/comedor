package adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.comedor_uacm.R;
import com.example.comedor_uacm.VerHorario;
import com.example.comedor_uacm.entidades.Horario;

import java.util.ArrayList;

public class listaHorarioAdapter extends RecyclerView.Adapter<listaHorarioAdapter.HorariotoViewHolder>{


    ArrayList<Horario> lista_horarios;
    public listaHorarioAdapter(ArrayList<Horario> lista_horarios){
        this.lista_horarios=lista_horarios;
    }
    @NonNull
    @Override
    public HorariotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_horario,null,false);
        return new HorariotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorariotoViewHolder holder, int position) {
        holder.id_horario.setText(Integer.toString(lista_horarios.get(position).getId()));
        holder.i_nombre_horario.setText(lista_horarios.get(position).getNombre());
        holder.i_h_i.setText(Integer.toString(lista_horarios.get(position).getH_i()));
        holder.i_m_i.setText(Integer.toString(lista_horarios.get(position).getM_i()));
        holder.i_h_f.setText(Integer.toString(lista_horarios.get(position).getH_f()));
        holder.i_m_f.setText(Integer.toString(lista_horarios.get(position).getM_f()));


    }

    @Override
    public int getItemCount() {
        return lista_horarios.size();
    }

    public class HorariotoViewHolder extends RecyclerView.ViewHolder {
        TextView id_horario,i_nombre_horario,i_h_i,i_m_i,i_h_f,i_m_f;
        public HorariotoViewHolder(@NonNull View itemView) {
            super(itemView);
            id_horario = itemView.findViewById(R.id.id_i_horario);
            i_nombre_horario= itemView.findViewById(R.id.i_nombre_horario);
            i_h_i=itemView.findViewById(R.id.i_h_hi);
            i_m_i=itemView.findViewById(R.id.i_h_mi);
            i_h_f=itemView.findViewById(R.id.i_h_hf);
            i_m_f=itemView.findViewById(R.id.i_h_mf);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent i=new Intent(context, VerHorario.class);
                    i.putExtra("id_horario",lista_horarios.get(getAdapterPosition()).getId());
                    context.startActivity(i);

                }
            });

        }
    }
}
