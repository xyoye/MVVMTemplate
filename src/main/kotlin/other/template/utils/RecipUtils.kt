package other.template.utils

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.github.xyoye.template.listeners.MyProjectManagerListener
import com.intellij.openapi.roots.ModuleRootManager
import com.intellij.psi.PsiDirectory
import com.intellij.psi.PsiManager
import org.jetbrains.kotlin.idea.util.projectStructure.allModules
import org.jetbrains.kotlin.konan.file.File

/**
 * Created by xyoye on 2021/1/17.
 */

fun getModuleDir(moduleData: ModuleTemplateData): Pair<PsiDirectory?, PsiDirectory?> {
    val emptyPair = Pair<PsiDirectory?, PsiDirectory?>(null, null)

    val project = MyProjectManagerListener.projectInstance ?: return emptyPair

    val module = project.allModules().find { it.name == moduleData.name } ?: return emptyPair
    val moduleFiles = ModuleRootManager.getInstance(module).getSourceRoots(false)

    val srcPath = moduleData.srcDir.absolutePath.replace(File.separator, "/")
    val resPath = moduleData.resDir.absolutePath.replace(File.separator, "/")

    val virtualSrc = moduleFiles.find { srcPath.contains(it.path) } ?: return emptyPair
    val virtualRes = moduleFiles.find { it.path == resPath } ?: virtualSrc.parent.createChildDirectory(null, "res")

    val srcDirectory = PsiManager.getInstance(project).findDirectory(virtualSrc)
    val resDirectory = PsiManager.getInstance(project).findDirectory(virtualRes)
    return Pair(srcDirectory, resDirectory)
}
