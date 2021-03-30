package com.example.calciusingexp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.mozilla.javascript.Script;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity {
    EditText ett;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ett = findViewById(R.id.et1);
        ett.setInputType(InputType.TYPE_NULL);
    }

    public void calc(View view) {
        String operation = ett.getText().toString();
        ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("rhino");
        try {
            Object res = scriptEngine.eval(operation);
            ett.setText(" "+ res);
        }
        catch (ScriptException e)
        {
            ett.setText("Syntax Error");
        }
    }
    public void addc(View view) {
        ett.setText("");
    }
    public void updateText(View view)
    {
        Button b = (Button) view;
        String u = ett.getText()+ (b.getText().toString());
        ett.setText(u);
    }

}