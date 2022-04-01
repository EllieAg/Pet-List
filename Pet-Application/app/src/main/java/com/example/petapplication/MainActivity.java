package com.example.petapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btn_viewAll, btn_add;
    EditText name, breed, weight, description;
    ListView lv_pets;

    ArrayAdapter petArrayAdapter;
    petDatabase pdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // assign
        // buttons
        btn_viewAll = (Button) findViewById(R.id.et_viewAll);
        btn_add = (Button) findViewById(R.id.et_Add);
        // edit text
        name = (EditText) findViewById(R.id.et_petName);
        breed = (EditText) findViewById(R.id.et_breed);
        weight = (EditText) findViewById(R.id.et_weight);
        description = (EditText) findViewById(R.id.et_decs);
        // listView
        lv_pets = (ListView) findViewById(R.id.lv_pets);


        btn_viewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                petDatabase databasePet = new petDatabase(MainActivity.this);
                List<Pet> allPets = databasePet.getAllPet();

                ArrayAdapter petArrayAdapter = new ArrayAdapter<Pet>(MainActivity.this, android.R.layout.simple_list_item_1, allPets);
                lv_pets.setAdapter(petArrayAdapter);
            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Pet pet;

                try{
                    pet = new Pet(-1, name.getText().toString(), breed.getText().toString(),
                            Integer.parseInt(weight.getText().toString()), description.getText().toString());

                    Toast.makeText(MainActivity.this, pet.toString(), Toast.LENGTH_SHORT).show();

                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "Error Creating Customer", Toast.LENGTH_SHORT).show();
                    pet = new Pet(-1, "error", "", 0, "");
                }

                petDatabase pd = new petDatabase(MainActivity.this);

                boolean success = pd.addOne(pet);

                Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();

            }
        });
    }
}