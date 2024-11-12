package com.example.tarearecyclerview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ContactoAdapter contactoAdapter;
    private ArrayList<Contacto> listaContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        listaContactos = new ArrayList<>();
        listaContactos.add(new Contacto("Carlos", "Pérez", "carlos@hotmail.com", "988251001", R.drawable.carlos));
        listaContactos.add(new Contacto("María", "López", "maria@hotmail.com", "988251002", R.drawable.maria));
        listaContactos.add(new Contacto("Luis", "García", "luis@hotmail.com", "988251003", R.drawable.luis));
        listaContactos.add(new Contacto("Ana", "Martínez", "ana@hotmail.com", "988251004", R.drawable.ana));
        listaContactos.add(new Contacto("Pedro", "Rodríguez", "pedro@hotmail.com", "988251005", R.drawable.pedro));
        listaContactos.add(new Contacto("Elena", "Fernández", "elena@hotmail.com", "988251006", R.drawable.elena));
        listaContactos.add(new Contacto("Javier", "Sánchez", "javier@hotmail.com", "988251007", R.drawable.javier));

        contactoAdapter = new ContactoAdapter(listaContactos);
        recyclerView.setAdapter(contactoAdapter);
    }
}