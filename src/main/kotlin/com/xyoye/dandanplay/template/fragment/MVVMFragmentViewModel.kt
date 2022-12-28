package com.xyoye.dandanplay.template.fragment

/**
 * Created by xyoye on 2021/1/16.
 */

fun mvvmFragmentViewModel(
    packageName: String,
    folderName: String,
    viewModelName: String
) = """package ${packageName}.ui.fragment.${folderName}

import com.xyoye.common_component.base.BaseViewModel

class $viewModelName : BaseViewModel() {

}"""