package vn.edu.poly.animation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private SharedPreferences sharedPreferences;
    private TextView tvText;
    private Button btnLoad;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tvText = findViewById(R.id.tvText);
        btnLoad = findViewById(R.id.btnLoad);
        btnSave = findViewById(R.id.btnSave);


        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadListCache();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createFileCache();
            }
        });

        sharedPreferences = getSharedPreferences("DATA", MODE_PRIVATE);

        // save du lieu
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("NAME", "HUY NGUYEN");

        editor.apply();


        // load du lieu ra

        String name = sharedPreferences.getString("NAME", "CHUA LUU");

        Toast.makeText(this, name, Toast.LENGTH_LONG).show();


    }

    public void createFileCache() {

        // lay ra duong dan cua cache file
        File pathCacheDir = getCacheDir();

        // dat ten file cache
        String strCacheFileName = "myCacheFile" + new Random().nextInt() + ".cache";

        // tao du lieu de luu
        String strFileContents = "Hello World";

        // khoi tao 1 file moi voi duong dan la cachefile va noi dung da khoi tao
        File newCacheFile = new File(pathCacheDir, strCacheFileName);
        try {
            newCacheFile.createNewFile();
            FileOutputStream foCache = new FileOutputStream(newCacheFile.getAbsolutePath());
            foCache.write(strFileContents.getBytes());
            foCache.close();
            Toast.makeText(
                    MainActivity.this, "Save successful!!!", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(
                    MainActivity.this, "Somethings wrong!!!", Toast.LENGTH_LONG).show();

        }


    }

    public void loadListCache() {
        File pathFile = getCacheDir();
        File[] listCache = pathFile.listFiles();
        Toast.makeText(
                MainActivity.this, listCache.length + "", Toast.LENGTH_LONG).show();
        for (File file : listCache) {

        }
    }
}
