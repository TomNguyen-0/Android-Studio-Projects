package com.example.captureavideo;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private final int VIDEO_REQUEST_CODE = 100;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.textView);
        textView.setVisibility(View.GONE);
    }

    public void captureVideo(View view)
    {
        Intent camera_intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        File video_file = getFilepath();
        Uri video_uri = Uri.fromFile(video_file);
        camera_intent.putExtra(MediaStore.EXTRA_OUTPUT,video_uri);
        camera_intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY,1); //1 means maximum qauilty, 0 means minimum quality.
        startActivityForResult(camera_intent,VIDEO_REQUEST_CODE);
    }

    public File getFilepath()
    {
        File folder = new File("sdcard/video_app");
        if(!folder.exists())
        {
            folder.mkdir();
        }
        File video_file = new File(folder,"sample_video.mp4");//(parent folder, then file name.
        return video_file;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == VIDEO_REQUEST_CODE)
        {
            if(resultCode == RESULT_OK)
            {
                Toast.makeText(getApplicationContext(),"Video Successful Recorded",Toast.LENGTH_SHORT).show();
                textView.setText("File saved to sdcard/video_app/sample_video.mp4");
                textView.setVisibility(View.VISIBLE);
            }
            else
            {
                Toast.makeText(getApplicationContext(),"Video capture failed...",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
