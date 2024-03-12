package com.example.texteditorcode;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.texteditorcode.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    ArrayAdapter<String> colorAdapter;
    ArrayAdapter<String> styleAdapter;
    ArrayAdapter<String> fontAdapter;
    String[] colorsArray = {"RED", "GREEN", "BLUE", "NONE"};
    String[] stylesArray = {"Bold", "Italics", "Bold Italic", "Underline", "Normal"};
    String[] fontsArray = {"Caveat", "Inconsolata", "Montserrat", "Pacifico", "Roboto", "Default"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        // Color Through Autocomplete Text View
        colorAdapter = new ArrayAdapter<>(this, R.layout.item_atv_list, colorsArray);
        binding.autoTvSelectColor.setAdapter(colorAdapter);

        binding.autoTvSelectColor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String pos = parent.getItemAtPosition(position).toString();

                switch (pos) {
                    case "RED":
                        binding.editColorText.setTextColor(Color.RED);
                        break;
                    case "GREEN":
                        binding.editColorText.setTextColor(Color.GREEN);
                        break;
                    case "BLUE":
                        binding.editColorText.setTextColor(Color.BLUE);
                        break;
                    case "NONE":
                        binding.editColorText.setTextColor(Color.BLACK);
                        break;
                }

            }
        });

        // Style Through Autocomplete Text View
        styleAdapter = new ArrayAdapter<>(this, R.layout.item_atv_list, stylesArray);
        binding.autoTvSelectStyle.setAdapter(styleAdapter);

        binding.autoTvSelectStyle.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String pos = parent.getItemAtPosition(position).toString();

                SpannableString spannableString = new SpannableString(binding.editColorText.getText());

                switch (pos) {
                    case "Bold":
                        spannableString.setSpan(new StyleSpan(Typeface.BOLD), 0, spannableString.length(), 0);
                        binding.editColorText.setText(spannableString);
                        break;
                    case "Italics":
                        spannableString.setSpan(new StyleSpan(Typeface.ITALIC), 0, spannableString.length(), 0);
                        binding.editColorText.setText(spannableString);
                        break;
                    case "Bold Italic":
                        spannableString.setSpan(new StyleSpan(Typeface.BOLD_ITALIC), 0, spannableString.length(), 0);
                        binding.editColorText.setText(spannableString);
                        break;
                    case "Underline":
                        spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 0);
                        binding.editColorText.setText(spannableString);
                        break;
                    case "Normal":
                        spannableString.setSpan(new StyleSpan(Typeface.NORMAL), 0, spannableString.length(), 0);
                        binding.editColorText.setText(spannableString);
                        break;
                }

            }
        });

        // Font Through Autocomplete Text View
        fontAdapter = new ArrayAdapter<>(this, R.layout.item_atv_list, fontsArray);
        binding.autoTvSelectFont.setAdapter(fontAdapter);

        binding.autoTvSelectFont.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String pos = parent.getItemAtPosition(position).toString();

                switch (pos) {
                    case "Caveat":
                        Typeface typeface1 = Typeface.createFromAsset(getAssets(), "font/caveat_regular.ttf");
                        binding.editColorText.setTypeface(typeface1);
                        break;
                    case "Inconsolata":
                        Typeface typeface2 = Typeface.createFromAsset(getAssets(), "font/inconsolata_regular.ttf");
                        binding.editColorText.setTypeface(typeface2);
                        break;
                    case "Montserrat":
                        Typeface typeface3 = Typeface.createFromAsset(getAssets(), "font/montserrat_regular.ttf");
                        binding.editColorText.setTypeface(typeface3);
                        break;
                    case "Pacifico":
                        Typeface typeface4 = Typeface.createFromAsset(getAssets(), "font/pacifico_regular.ttf");
                        binding.editColorText.setTypeface(typeface4);
                        break;
                    case "Roboto":
                        Typeface typeface5 = Typeface.createFromAsset(getAssets(), "font/roboto_regular.ttf");
                        binding.editColorText.setTypeface(typeface5);
                        break;
                    case "Default":
                        Typeface typeface6 = Typeface.DEFAULT;
                        binding.editColorText.setTypeface(typeface6);
                        break;
                }

            }
        });

        // Change Color through buttons
        binding.redButton.setOnClickListener(v -> {
            binding.editColorText.setTextColor(Color.RED);
        });

        binding.greenButton.setOnClickListener(v -> {
            binding.editColorText.setTextColor(Color.GREEN);
        });

        binding.blueButton.setOnClickListener(v -> {
            binding.editColorText.setTextColor(Color.BLUE);
        });

        binding.noneButton.setOnClickListener(v -> {
            binding.editColorText.setTextColor(Color.BLACK);
        });

    }
}