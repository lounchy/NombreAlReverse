package com.example.lounchy.nombrealreverse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.generar_button);
        EscuchaButton escuchaButton = new EscuchaButton(this);
        button.setOnClickListener(escuchaButton);
    }
}
