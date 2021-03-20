package other.template.activity

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.addAllKotlinDependencies
import other.template.activity.MVVMActivity
import other.template.activity.MVVMActivityLayout
import other.template.activity.MVVMActivityViewModel
import other.template.utils.getModuleDir
import other.template.utils.save


fun RecipeExecutor.activityTemplateSetup(
        moduleData: ModuleTemplateData,
        folderName: String,
        activityName: String,
        activityViewModelName: String,
        activityLayoutName: String
) {
    addAllKotlinDependencies(moduleData)

    val packageName = moduleData.packageName

    val folderPath = "$packageName.ui.activities.$folderName"

    val moduleDir = getModuleDir(moduleData)
    val directorySrc = moduleDir.first ?: return
    val directoryRes = moduleDir.second ?: return

    //create and save file
    MVVMActivity(packageName, folderName, activityLayoutName, activityName, activityViewModelName)
            .save(directorySrc, folderPath, "${activityName}.kt")
    MVVMActivityViewModel(packageName, folderName, activityViewModelName)
            .save(directorySrc, folderPath, "${activityViewModelName}.kt")
    MVVMActivityLayout(packageName, folderName, activityViewModelName)
            .save(directoryRes, "layout", "${activityLayoutName}.xml")
}