package com.example.datepicker;

import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.DatePicker;
import android.widget.Toast;

/**
 * Created by tom on 6/21/2016.
 */
public class DateSettings implements DatePickerDialog.OnDateSetListener
{
    Context context;
    public DateSettings(Context context)
    {
        this.context = context;
    }
    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        Toast.makeText(context,
                "Selected date: "+monthOfYear+ " / "+dayOfMonth+ " / "+year,
                Toast.LENGTH_LONG).show();
    }
}
