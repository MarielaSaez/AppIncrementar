package com.dev.appincrementar;

import android.os.Bundle;
import android.util.Log;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.dev.appincrementar.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private IncrementarViewModel incrementarViewModel;
    private int res = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // Inicializamos nuestro ViewModel
        incrementarViewModel = new ViewModelProvider(this).get(IncrementarViewModel.class);
        Log.d("TAG1", "onCreate()");
        // Mostrar el valor de los  editText ya que este método se ejecutará varias veces
        binding.tvResCon.setText("Con ViewModel: "+incrementarViewModel.getResultado());
        binding.tvResSin.setText("Sin ViewModel: "+res );
        tarea();
    }
    public void tarea() {
        binding.btIIcrementarSin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Actualizar solo la variable local (no se mantiene tras rotación)
                res = Incrementar.incrementar(res);
                binding.tvResSin.setText("Sin ViewModel: "+res );
            }
        });
        binding.btIncrementarCon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Incrementar el valor almacenado en el ViewModel (se mantiene tras rotación)
                incrementarViewModel.setResultado(Incrementar.incrementar(incrementarViewModel.getResultado()));
                binding.tvResCon.setText("Con ViewModel: "+incrementarViewModel.getResultado());
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TAG1", "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TAG1", "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TAG1", "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TAG1", "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TAG1", "onDestroy()");
    }
}

