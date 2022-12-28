package com.xyoye.dandanplay.template.activity

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.xyoye.dandanplay.template.DanDanPlayTemplateProviderImpl
import com.xyoye.dandanplay.template.formattedPackageName
import java.io.File


fun RecipeExecutor.activityTemplateSetup(
    provider: DanDanPlayTemplateProviderImpl,
    moduleData: ModuleTemplateData
) {
    val folderName = provider.folderName.value.lowercase()
    val activityName = provider.activityName.value
    val viewModelName = provider.activityViewModelName.value
    val layoutName = provider.activityLayoutName.value

    val packageName = moduleData.formattedPackageName()
    val folderPath = "src.main.java.$packageName.ui.activities.$folderName".replace('.', '/')

    mergeXml(
        manifest(folderName, activityName),
        File(moduleData.manifestDir, "AndroidManifest.xml")
    )
    save(
        mvvmActivity(packageName, folderName, layoutName, activityName, viewModelName),
        File(moduleData.rootDir, "$folderPath/$activityName.kt").also {
            open(it)
        }
    )
    save(
        mvvmActivityLayout(packageName, folderName, viewModelName),
        File(moduleData.resDir, "layout/$layoutName.xml")
    )
    save(
        mvvmActivityViewModel(packageName, folderName, viewModelName),
        File(moduleData.rootDir, "$folderPath/$viewModelName.kt")
    )
}