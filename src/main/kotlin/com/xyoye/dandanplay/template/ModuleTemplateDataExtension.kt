package com.xyoye.dandanplay.template

import com.android.tools.idea.wizard.template.ModuleTemplateData


fun ModuleTemplateData.formattedPackageName(): String {
    val packages = packageName.split(".")
    if (packages.size > 3) {
        return "${packages[0]}.${packages[1]}.${packages[2]}"
    }
    return packageName
}