package com.xyoye.dandanplay.template.fragment

/**
 * Created by xyoye on 2021/1/16.
 */

fun mvvmFragmentLayout(
    packageName: String,
    folderName: String,
    viewModelName: String
) = """<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:android="http://schemas.android.com/apk/res/android">

    <data>

        <import type="${packageName}.ui.fragment.${folderName}.${viewModelName}" />

        <variable
            name="viewModel"
            type="${packageName}.ui.fragment.${folderName}.${viewModelName}" />
    </data>

    <androidx.constraintlayout.widget.ConstraintLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent">

    </androidx.constraintlayout.widget.ConstraintLayout>
</layout>"""