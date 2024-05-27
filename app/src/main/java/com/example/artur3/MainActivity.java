package com.example.artur3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    private ImageView cameraView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cameraView = findViewById(R.id.cameraView);

        // Load the camera stream
        loadCameraStream();
    }

    private void loadCameraStream() {
        String url = "http://192.168.13.24/stream";
        Picasso.get().load(url).into(cameraView);
    }
}
