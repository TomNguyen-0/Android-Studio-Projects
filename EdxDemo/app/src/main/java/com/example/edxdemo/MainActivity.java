package com.example.edxdemo;

                import android.graphics.Bitmap;
                import android.graphics.BitmapFactory;
                import android.support.v7.app.AppCompatActivity;
                import android.os.Bundle;
                import android.widget.ImageView;

                import java.io.InputStream;
                import java.net.URL;
                import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

                    @Override
                    protected void onCreate(Bundle savedInstanceState) {
                        super.onCreate(savedInstanceState);
                        setContentView(R.layout.activity_main);


                        Thread t = new Thread() {
                            public void run() {
                                try {
                                    URL url = new URL("https://cdn.syntheticloud.com/media/slider/lite.jpg");

                                    URLConnection con = url.openConnection();
                                    InputStream is = con.getInputStream();
                                    final Bitmap b = BitmapFactory.decodeStream(is);

                                    Runnable r = new Runnable() {
                                        public void run() {
                                            ImageView iv = (ImageView)findViewById(R.id.downloadedImage);
                                                iv.setImageBitmap(b);
                                        }
                                    };
                                    runOnUiThread(r);
                                }
                                catch(Exception e){
                                    e.printStackTrace();
                                }
                            }
                        };
                        t.start();

                    }
}
