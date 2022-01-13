package pk.nu.edu.astronautapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class NewEntryActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner;
    private static final String[] paths = {"Food Box", "Remaining Water", };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_entry);





            spinner = (Spinner)findViewById(R.id.spinner);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(NewEntryActivity.this,
                    android.R.layout.simple_spinner_item,paths);

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
            spinner.setOnItemSelectedListener(this);

        }

    @Override
        public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

            switch (position) {
                case 0:
                    // Whatever you want to happen when the first item gets selected
                    break;
                case 1:
                    // Whatever you want to happen when the second item gets selected
                    break;
                case 2:
                    // Whatever you want to happen when the thrid item gets selected
                    break;

            }
        }

    @Override
        public void onNothingSelected(AdapterView<?> parent) {
            // TODO Auto-generated method stub
        }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}