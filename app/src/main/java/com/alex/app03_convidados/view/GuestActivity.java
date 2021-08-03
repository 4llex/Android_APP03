package com.alex.app03_convidados.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.alex.app03_convidados.R;
import com.alex.app03_convidados.constants.GuestConstants;
import com.alex.app03_convidados.model.Feedback;
import com.alex.app03_convidados.model.GuestModel;
import com.alex.app03_convidados.viewmodel.GuestViewModel;

public class GuestActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewHolder mViewHolder = new ViewHolder();
    private GuestViewModel mViewModel;
    private int mGuestId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest);

        this.mViewModel = new ViewModelProvider(this).get(GuestViewModel.class);

        this.mViewHolder.editName = findViewById(R.id.edit_name);
        this.mViewHolder.radioNotConfirmed = findViewById(R.id.radio_not_confirmed);
        this.mViewHolder.radioPresent = findViewById(R.id.radio_present);
        this.mViewHolder.radioAbsent = findViewById(R.id.radio_absent);
        this.mViewHolder.buttonSave = findViewById(R.id.button_save);
        this.mViewHolder.radioGroup = findViewById(R.id.radiogroup);

        this.setListeners();
        this.setObservers();

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            this.mGuestId = bundle.getInt(GuestConstants.GUESTID);
            this.mViewModel.load(this.mGuestId);
        }

    }

    private void setObservers() {
        this.mViewModel.gest.observe(this, new Observer<GuestModel>() {
            @Override
            public void onChanged(GuestModel guestModel) {
                mViewHolder.editName.setText(guestModel.getName());

                int conf = guestModel.getConfirmation();
                mViewHolder.radioNotConfirmed.setChecked(conf == GuestConstants.CONFIRMATION.NOT_CONFIRMED);
                mViewHolder.radioAbsent.setChecked(conf == GuestConstants.CONFIRMATION.ABSENT);
                mViewHolder.radioPresent.setChecked(conf == GuestConstants.CONFIRMATION.PRESENT);
            }
        });

        this.mViewModel.feedback.observe(this, new Observer<Feedback>() {
            @Override
            public void onChanged(Feedback feedback) {
                Toast.makeText(getApplicationContext(), feedback.getMessage(), Toast.LENGTH_SHORT).show();
                if (feedback.isSuccess()){
                    finish();
                }
            }
        });
    }


    private void setListeners(){
        this.mViewHolder.buttonSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button_save){
            this.handleSave();
        }
    }

    public void handleSave(){
        String name = this.mViewHolder.editName.getText().toString();

        int confirmation = 0;
        if (this.mViewHolder.radioPresent.isChecked()){
            confirmation = GuestConstants.CONFIRMATION.PRESENT;
        } else if (this.mViewHolder.radioAbsent.isChecked()){
            confirmation = GuestConstants.CONFIRMATION.ABSENT;
        }

        GuestModel guest = new GuestModel(this.mGuestId, name, confirmation);
        this.mViewModel.save(guest);

    }

    private static class ViewHolder{
        EditText editName;
        RadioButton radioNotConfirmed;
        RadioButton radioPresent;
        RadioButton radioAbsent;
        Button buttonSave;
        RadioGroup radioGroup;
    }
}