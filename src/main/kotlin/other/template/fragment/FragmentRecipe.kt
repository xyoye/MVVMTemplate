package other.template.fragment

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.addAllKotlinDependencies
import com.github.xyoye.template.listeners.MyProjectManagerListener.Companion.projectInstance
import com.intellij.openapi.roots.ModuleRootManager
import com.intellij.psi.PsiManager
import org.jetbrains.kotlin.idea.util.projectStructure.allModules
import org.jetbrains.kotlin.konan.file.File
import other.template.fragment.MVVMFragment
import other.template.fragment.MVVMFragmentLayout
import other.template.fragment.MVVMFragmentViewModel
import other.template.utils.getModuleDir
import other.template.utils.save


fun RecipeExecutor.fragmentTemplateSetup(
        moduleData: ModuleTemplateData,
        folderName: String,
        fragmentName: String,
        fragmentViewModelName: String,
        fragmentLayoutName: String
) {
    addAllKotlinDependencies(moduleData)

    val packageName = moduleData.packageName

    val folderPath = "$packageName.ui.fragment.$folderName"

    val moduleDir = getModuleDir(moduleData)
    val directorySrc = moduleDir.first ?: return
    val directoryRes = moduleDir.second ?: return

    //create and save file
    MVVMFragment(packageName, folderName, fragmentLayoutName, fragmentName, fragmentViewModelName)
            .save(directorySrc, folderPath, "${fragmentName}.kt")
    MVVMFragmentViewModel(packageName, folderName, fragmentViewModelName)
            .save(directorySrc, folderPath, "${fragmentViewModelName}.kt")
    MVVMFragmentLayout(packageName, folderName, fragmentViewModelName)
            .save(directoryRes, "layout", "${fragmentLayoutName}.xml")
}