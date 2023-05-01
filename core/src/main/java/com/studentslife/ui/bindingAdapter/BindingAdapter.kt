package com.studentslife.ui.bindingAdapter

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("android:visibility")
fun setVisibility(view: View, visible: Boolean?){
    view.visibility = if (visible == true) View.VISIBLE else View.GONE
}