package com.example.myfirstapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

@SuppressLint("AppCompatCustomView")
public class RoskiImageButton extends ImageButton {

    private static final int[] STATE_REGULAR = {R.attr.state_regular};
    private static final int[] STATE_EATED = {R.attr.state_eated};
    private static final int[] STATE_2_EATED = {R.attr.state_two_eated};
    private static final int[] STATE_3_EATED = {R.attr.state_three_eated};
    private static final int[] STATE_4_EATED = {R.attr.state_four_eated};
    private static final int[] STATE_5_EATED = {R.attr.state_five_eated};

    public void setRegular() {
        this.mRegular = true;
        this.mEated = false;
        this.m2Eated = false;
        this.m3Eated = false;
        this.m4Eated = false;
        this.m5Eated = false;
    }

    public void setEated() {
        this.mRegular = false;
        this.mEated = true;
        this.m2Eated = false;
        this.m3Eated = false;
        this.m4Eated = false;
        this.m5Eated = false;
    }

    public void set2Eated() {
        this.mRegular = false;
        this.mEated = false;
        this.m2Eated = true;
        this.m3Eated = false;
        this.m4Eated = false;
        this.m5Eated = false;
    }

    public void set3Eated() {
        this.mRegular = false;
        this.mEated = false;
        this.m2Eated = false;
        this.m3Eated = true;
        this.m4Eated = false;
        this.m5Eated = false;
    }

    public void set4Eated() {
        this.mRegular = false;
        this.mEated = false;
        this.m2Eated = false;
        this.m3Eated = false;
        this.m4Eated = true;
        this.m5Eated = false;
    }

    public void set5Eated() {
        this.mRegular = false;
        this.mEated = false;
        this.m2Eated = false;
        this.m3Eated = false;
        this.m4Eated = false;
        this.m5Eated = true;
    }

    private boolean mRegular = false;
    private boolean mEated = false;
    private boolean m2Eated = false;
    private boolean m3Eated = false;
    private boolean m4Eated = false;
    private boolean m5Eated = false;


    public RoskiImageButton(Context context) {
        this(context, null);
    }

    public RoskiImageButton(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.imageButtonStyle);
    }

    public RoskiImageButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setFocusable(true);
        setLongClickable(true);
    }

    @Override
    public int[] onCreateDrawableState(int extraSpace) {
        final int[] drawableState = super.onCreateDrawableState(extraSpace + 2);
         if (mRegular) {
            mergeDrawableStates(drawableState, STATE_REGULAR);
        }
        if (mEated) {
            mergeDrawableStates(drawableState, STATE_EATED);
        }
        if (m2Eated) {
            mergeDrawableStates(drawableState, STATE_2_EATED);
        }
        if (m3Eated) {
            mergeDrawableStates(drawableState, STATE_3_EATED);
        }
        if (m4Eated) {
            mergeDrawableStates(drawableState, STATE_4_EATED);
        }
        if (m5Eated) {
            mergeDrawableStates(drawableState, STATE_5_EATED);
        }
        return drawableState;
    }
}