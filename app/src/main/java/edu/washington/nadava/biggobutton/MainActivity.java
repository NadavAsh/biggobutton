package edu.washington.nadava.biggobutton;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {
    public static final String CLICK_COUNT = "clickcount";

    private Button bigButton;
    private int numClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bigButton = (Button)findViewById(R.id.big_button);
        bigButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++numClicked;
                String numText = String.format(getString(R.string.button_num_clicked), numClicked);
                bigButton.setText(numText);
            }
        });

        if (savedInstanceState != null && savedInstanceState.containsKey(CLICK_COUNT)) {
            numClicked = savedInstanceState.getInt(CLICK_COUNT);
            bigButton.callOnClick();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("MainActivity", "Called onSaveInstanceState");

        outState.putInt(CLICK_COUNT, numClicked);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
