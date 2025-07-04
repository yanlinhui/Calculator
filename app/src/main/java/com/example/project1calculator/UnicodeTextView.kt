package com.example.project1calculator

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class UnicodeTextView(context:Context,attrs:AttributeSet?):AppCompatTextView(context,attrs) {
    init {
         typeface = Typeface.createFromAsset(context.assets,"iconfont.ttf")
    }
}