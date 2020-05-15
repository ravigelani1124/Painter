package com.gelu.painter.utility.Edittext;


import android.content.Context;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatEditText;

public class EditText_bold extends AppCompatEditText {


    public EditText_bold(Context context) {
        super(context);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Montserrat-Bold.ttf"));
        this.addTextChangedListener(mTextWatcher);
    }

    public EditText_bold(Context context, AttributeSet attrs) {
        super(context, attrs);
        //this.setBackgroundColor(Color.parseColor("#fff"));
        this.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Montserrat-Bold.ttf"));
        this.addTextChangedListener(mTextWatcher);
    }

    @Override
    public void setTypeface(Typeface tf) {
        super.setTypeface(tf);
    }

    TextWatcher mTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if(s.length()>0){
                setError(null);
            }
        }
    };

}