package com.example.android.myapplication;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AlertDialogLayout;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {


    SeekBar myseekBar;
    View blueView;
    View redView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        myseekBar = findViewById(R.id.seekBar);
        blueView = findViewById(R.id.blue);
        redView = findViewById(R.id.bigred);
        myseekBar.setOnSeekBarChangeListener(seekBarChangeListener);

    }


    private SeekBar.OnSeekBarChangeListener seekBarChangeListener
            = new SeekBar.OnSeekBarChangeListener() {

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress,
                                      boolean fromUser) {
            updateBackground();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    };

    private void updateBackground() {
        int seekR;
        seekR = myseekBar.getProgress();
        blueView.setBackgroundColor(
                0xff055bcc
                        + seekR * 0x60);
        redView.setBackgroundColor(
                0xffcd3227
                        + seekR * 0x60);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.moreInfo){
        ShowMessage();
        }
        return super.onOptionsItemSelected(item);
    }
    private void ShowMessage() {
        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.alert_dia, null);
        final TextView message = alertLayout.findViewById(R.id.moreInfo);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(alertLayout);
        builder.setNegativeButton("NOT NOW", null);
        builder.setPositiveButton("VISIT FORUMS", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://macdiscussions.udacity.com/t/training-task-3-for-students-who-completed-the-user-input-part/102430"));
                startActivity(intent);
            }
        });
        builder.show();

    }
}