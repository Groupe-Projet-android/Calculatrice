package com.example.calculatrice;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.calculatrice.databinding.ActivityMainBinding;

import java.text.DecimalFormat;

import static java.lang.Math.exp;
import static java.lang.Math.sqrt;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char POURCENTAGE='%';
    private static final char EXPOSANT= 'E';
    private static final char RACINE = '√';

    private char CURRENT_ACTION;

    private double valueOne = Double.NaN;
    private double valueTwo=0;

    private DecimalFormat decimalFormat;
    private void Calcul(){
        if (!Double.isNaN(valueOne)) {
            valueTwo = Double.parseDouble(binding.editText.getText().toString());
            binding.editText.setText(null);

            if (CURRENT_ACTION == ADDITION)
                valueOne = this.valueOne + valueTwo;
            else if (CURRENT_ACTION == SUBTRACTION)
                valueOne = this.valueOne - valueTwo;
            else if (CURRENT_ACTION == MULTIPLICATION)
                valueOne = this.valueOne * valueTwo;
            else if (CURRENT_ACTION == DIVISION)
                valueOne = this.valueOne / valueTwo;
            else if(CURRENT_ACTION == POURCENTAGE)
                valueOne = (this.valueOne/100);
            else if(CURRENT_ACTION == EXPOSANT)
                valueOne = (this.valueOne*this.valueOne);
            else if(CURRENT_ACTION == RACINE)
                valueOne = sqrt(this.valueOne);
        }
        else {
            try {
                valueOne = Double.parseDouble(binding.editText.getText().toString());
            } catch (Exception e) {
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        decimalFormat = new DecimalFormat("#.##########");

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.buttonPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + ".");
            }
        });
        binding.buttonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + "0");
            }
        });
        binding.buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + "1");
            }
        });

        binding.buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + "2");
            }
        });
        binding.buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + "3");
            }
        });
        binding.buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + "4");
            }
        });

        binding.buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + "5");
            }
        });
        binding.buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + "6");
            }
        });
        binding.buttonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + "7");
            }
        });

        binding.buttonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + "8");
            }
        });
        binding.buttonNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText() + "9");
            }
        });

        binding.buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calcul();
                CURRENT_ACTION = ADDITION;
                binding.infoTextView.setText(decimalFormat.format(valueOne) + "+");
                binding.editText.setText(null);
            }
        });
        binding.buttonMoins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calcul();
                CURRENT_ACTION = SUBTRACTION;
                binding.infoTextView.setText(decimalFormat.format(valueOne) + "-");
                binding.editText.setText(null);
            }
        });
        binding.buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calcul();
                CURRENT_ACTION = DIVISION;
                binding.infoTextView.setText(decimalFormat.format(valueOne) + "/");
                binding.editText.setText(null);
            }
        });
        binding.buttonPourcentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calcul();
                CURRENT_ACTION = POURCENTAGE;
                binding.infoTextView.setText(decimalFormat.format(valueOne) + "%");

            }
        });
        binding.ButtonExp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calcul();
                CURRENT_ACTION = EXPOSANT;
                binding.infoTextView.setText("exp("+decimalFormat.format(valueOne)+")");

            }
        });
        binding.buttonRacine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calcul();
                CURRENT_ACTION = RACINE;
                binding.infoTextView.setText("√"+decimalFormat.format(valueOne));

            }
        });

        binding.buttonEgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calcul();
                binding.infoTextView.setText(binding.infoTextView.getText().toString() +
                        decimalFormat.format(valueTwo) + " = " + decimalFormat.format(valueOne));
                valueOne = 0;
                CURRENT_ACTION = '0';
            }
        });
        binding.buttonEffacer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.editText.getText().length() > 0) {
                    CharSequence currentText = binding.editText.getText();
                    binding.editText.setText(currentText.subSequence(0, currentText.length() - 1));
                } else {
                    valueOne = Double.NaN;
                    valueTwo = Double.NaN;
                    binding.editText.setText("");
                    binding.infoTextView.setText("");
                }
            }
        });


    }

    }
