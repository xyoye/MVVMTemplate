package com.xyoye.dandanplay.template.fragment

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.xyoye.dandanplay.template.DanDanPlayTemplateProviderImpl
import com.xyoye.dandanplay.template.formattedPackageName
import java.io.File


fun RecipeExecutor.fragmentTemplateSetup(
    provider: DanDanPlayTemplateProviderImpl,
    moduleData: ModuleTemplateData
) {
    val folderName = provider.folderName.value.lowercase()
    val fragmentName = provider.fragmentName.value
    val viewModelName = provider.fragmentViewModelName.value
    val layoutName = provider.fragmentLayoutName.value

    val packageName = moduleData.formattedPackageName()
    val folderPath = "src.main.java.$packageName.ui.fragment.$folderName".replace('.', '/')
    save(
        mvvmFragment(packageName, folderName, layoutName, fragmentName, viewModelName),
        File(moduleData.rootDir, "$folderPath/$fragmentName.kt")
    )
    save(
        mvvmFragmentLayout(packageName, folderName, viewModelName),
        File(moduleData.resDir, "layout/$layoutName.xml")
    )
    save(
        mvvmFragmentViewModel(packageName, folderName, viewModelName),
        File(moduleData.rootDir, "$folderPath/$viewModelName.kt")
    )
}