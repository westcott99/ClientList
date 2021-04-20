package com.example.clientlist;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.clientlist.data.AppDatabase;
import com.example.clientlist.data.RecyclingCenter;
import com.example.clientlist.data.RecyclingCenterDAO;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;

import java.util.List;

public class AddRecycler extends AppCompatActivity implements Validator.ValidationListener {

    @NotEmpty
    EditText name;
    @NotEmpty
    EditText address;
    @Email
    EditText email;
    @NotEmpty
    EditText phone;

    Validator validator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recycler);
        validator = new Validator(this);
        validator.setValidationListener(this);

        name = (EditText)findViewById(R.id.name);
        address = (EditText)findViewById(R.id.address);
        email = (EditText)findViewById(R.id.email);
        phone = (EditText)findViewById(R.id.phone);
    }

    public void add(View view){
        validator.validate();
    }
    private void insert(){
        AppDatabase database = Room.databaseBuilder(this, AppDatabase.class, "mydb").allowMainThreadQueries().build();
        RecyclingCenterDAO recyclingCenterDAO = database.getRecyclingCenterDAO();
        RecyclingCenter recyclingCenter = new RecyclingCenter();
        recyclingCenter.setName(name.getText().toString());
        recyclingCenter.setAddress(address.getText().toString());
        recyclingCenter.setEmail(email.getText().toString());
        recyclingCenter.setPhone(phone.getText().toString());
        recyclingCenterDAO.insert(recyclingCenter);
        finish();
    }

    @Override
    public void onValidationSucceeded() {
        insert();
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for(ValidationError error: errors){
            View view = error.getView();
            String message = error.getCollatedErrorMessage(this);
            if(view instanceof EditText){
                ((EditText)view).setError(message);
            }else {
                Toast.makeText(this, message, Toast.LENGTH_LONG).show();
            }
        }
    }
}
