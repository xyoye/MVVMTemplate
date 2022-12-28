package com.xyoye.dandanplay.template.activity

/**
 * Created by xyoye on 2021/1/16.
 */

fun mvvmActivityViewModel(
        packageName: String,
        folderName: String,
        viewModelName: String
) = """package $packageName.ui.activities.${folderName}

import com.xyoye.common_component.base.BaseViewModel

class $viewModelName : BaseViewModel() {

}"""