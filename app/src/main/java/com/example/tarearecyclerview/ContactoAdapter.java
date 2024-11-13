package com.example.tarearecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ContactoAdapter extends RecyclerView.Adapter<ContactoAdapter.ContactoViewHolder> {

    private ArrayList<Contacto> listaContactos;

    public ContactoAdapter(ArrayList<Contacto> listaContactos) {
        this.listaContactos = listaContactos;
    }

    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        return new ContactoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder holder, int position) {
        Contacto contacto = listaContactos.get(position);
        holder.nombre.setText(contacto.getNombre());
        holder.apellidos.setText(contacto.getApellidos());
        holder.email.setText(contacto.getEmail());
        holder.telefono.setText(contacto.getTelefono());
        holder.foto.setImageResource(contacto.getFoto());
    }

    @Override
    public int getItemCount() {
        return listaContactos.size();
    }

    public class ContactoViewHolder extends RecyclerView.ViewHolder {
        ImageView foto;
        TextView nombre, apellidos, email, telefono;

        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);
            foto = itemView.findViewById(R.id.contacto_foto);
            nombre = itemView.findViewById(R.id.contacto_nombre);
            apellidos = itemView.findViewById(R.id.contacto_apellidos);
            email = itemView.findViewById(R.id.contacto_email);
            telefono = itemView.findViewById(R.id.contacto_telefono);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(),
                            listaContactos.get(getAdapterPosition()).toString(),
                            Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
