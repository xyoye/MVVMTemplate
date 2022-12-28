package com.xyoye.dandanplay.template.activity

/**
 * Created by xyoye on 2021/1/16.
 */

fun mvvmActivityLayout(
        packageName: String,
        folderName: String,
        viewModelName: String
) = """<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:android="http://schemas.android.com/apk/res/android">

    <data>

        <import type="$packageName.ui.activities.${folderName}.$viewModelName" />

        <variable
            name="viewModel"
            type="$packageName.ui.activities.${folderName}.$viewModelName" />
    </data>

    <androidx.constraintlayout.widget.ConstraintLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent">

    </androidx.constraintlayout.widget.ConstraintLayout>
</layout>"""