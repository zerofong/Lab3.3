package my.edu.tarc.lab33;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinnerAge;
    private RadioGroup radioGroupGender;
    private RadioButton radioButtonMale,radioButtonFemale;
    private CheckBox checkBoxSmoker;
    private TextView textViewPremium;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Linking UI to program
        spinnerAge = (Spinner)findViewById(R.id.spinnerAge);
        radioGroupGender=(RadioGroup)findViewById(R.id.radioGroupGender);
        radioButtonMale=(RadioButton)findViewById(R.id.radioButtonMale);
        radioButtonFemale=(RadioButton)findViewById(R.id.radioButtonFemale);
        checkBoxSmoker = (CheckBox)findViewById(R.id.checkBoxSmoker);
        textViewPremium = (TextView)findViewById(R.id.textViewPremium);

        //create an adaptor
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.age_group,android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAge.setOnItemSelectedListener(this);
        spinnerAge.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,"Position:"+position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void calculatePremium(View view){
        int pos;
        pos = spinnerAge.getSelectedItemPosition();

        int premium[]={50,55,60,70,120,160,200,250};
        int extra[]={0,0,50,100,100,50,0,0};
        int smoker[]={0,0,0,100,150,150,250,250};
        int total=0;
        //Determine the gender of user
        int indexGender;
        indexGender = radioGroupGender.getCheckedRadioButtonId();
        if(indexGender==R.id.radioButtonMale){
            //TODO: calculate premium for male
            for(int i =0;i<7;i++){
                total=premium[i]+smoker[i]+extra[i];
            }
        }
        else{
            //TODO: calculate premium for female
            for(int i =0;i<7;i++){
                total=premium[i]+smoker[i];
            }
        }

        //check smoker
        if(checkBoxSmoker.isChecked()){

        }

        //Display Premium
        textViewPremium.setText(getString(R.string.premium)+premium);
    }
}
