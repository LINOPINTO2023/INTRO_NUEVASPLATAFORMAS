package com.example.fragmentexample;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);  // Habilita el modo Edge-to-Edge
        setContentView(R.layout.activity_main);

        // Configura el padding para acomodar las barras del sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Encuentra el botón en el layout y establece un listener para cargar el primer fragmento
        Button btnLoadFragment1 = findViewById(R.id.btnLoadFragment1);
        btnLoadFragment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new Fragment1());
            }
        });

        // Encuentra el botón en el layout y establece un listener para cargar el segundo fragmento
        Button btnLoadFragment2 = findViewById(R.id.btnLoadFragment2);
        btnLoadFragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new Fragment2());
            }
        });
    }

    /**
     * Método para cargar un fragmento en el contenedor de fragmentos.
     * @param fragment El fragmento que se va a cargar.
     */
    private void loadFragment(Fragment fragment) {
        // Obtiene el administrador de fragmentos
        FragmentManager fragmentManager = getSupportFragmentManager();
        // Inicia una transacción de fragmento
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        // Reemplaza el fragmento actual en el contenedor con el nuevo fragmento
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        // Confirma la transacción
        fragmentTransaction.commit();
    }
}
