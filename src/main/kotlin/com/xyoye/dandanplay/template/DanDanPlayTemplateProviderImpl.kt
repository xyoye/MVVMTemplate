package com.xyoye.dandanplay.template

import com.android.tools.idea.wizard.template.*
import com.xyoye.dandanplay.template.activity.activityTemplateSetup
import com.xyoye.dandanplay.template.fragment.fragmentTemplateSetup

class DanDanPlayTemplateProviderImpl : WizardTemplateProvider() {

    companion object {
        private const val MIN_API = 16
    }

    override fun getTemplates(): List<Template> = listOf(activityTemplate, fragmentTemplate)

    private val activityTemplate: Template
        get() = template {
            name = "DanDanPlayActivity"
            description = "快速创建DanDanPlay项目的Activity模板"
            category = Category.Activity
            formFactor = FormFactor.Mobile
            minApi = MIN_API
            screens = listOf(
                WizardUiContext.ActivityGallery,
                WizardUiContext.MenuEntry,
                WizardUiContext.NewProject,
                WizardUiContext.NewModule
            )

            widgets(
                TextFieldWidget(folderName),
                TextFieldWidget(activityName),
                TextFieldWidget(activityViewModelName),
                TextFieldWidget(activityLayoutName)
            )

            recipe = { data: TemplateData ->
                activityTemplateSetup(
                    this@DanDanPlayTemplateProviderImpl,
                    data as ModuleTemplateData
                )
            }
        }

    private val fragmentTemplate: Template
        get() = template {
            name = "DanDanPlayFragment"
            description = "快速创建DanDanPlay项目的Fragment模板"
            category = Category.Fragment
            formFactor = FormFactor.Mobile
            minApi = MIN_API
            screens = listOf(
                WizardUiContext.FragmentGallery,
                WizardUiContext.MenuEntry,
                WizardUiContext.NewProject,
                WizardUiContext.NewModule
            )

            widgets(
                TextFieldWidget(folderName),
                TextFieldWidget(fragmentName),
                TextFieldWidget(fragmentViewModelName),
                TextFieldWidget(fragmentLayoutName)
            )

            recipe = { data: TemplateData ->
                fragmentTemplateSetup(
                    this@DanDanPlayTemplateProviderImpl,
                    data as ModuleTemplateData
                )
            }
        }

    val folderName = stringParameter {
        name = "文件夹名称（小写）"
        default = "main"
        help = "文件夹名称"
        constraints = listOf(Constraint.NONEMPTY, Constraint.PACKAGE)
    }

    //-------------activity------------

    val activityName = stringParameter {
        name = "Activity名称"
        default = "MainActivity"
        help = "Activity名称"
        constraints = listOf(Constraint.NONEMPTY)
        suggest = { layoutToActivity(folderName.value) }
    }

    val activityViewModelName = stringParameter {
        name = "ViewModel名称"
        default = "MainViewModel"
        help = "ViewModel名称"
        constraints = listOf(Constraint.NONEMPTY)
        suggest = { "${underscoreToCamelCase(classToResource(folderName.value))}ViewModel" }
    }

    val activityLayoutName = stringParameter {
        name = "Activity布局名称"
        default = "activity_main"
        help = "Activity布局名称"
        constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
        suggest = { activityToLayout(folderName.value) }
    }

    //-------------fragment------------

    val fragmentName = stringParameter {
        name = "Fragment名称"
        default = "MainFragment"
        help = "Fragment名称"
        constraints = listOf(Constraint.NONEMPTY)
        suggest = { layoutToFragment(folderName.value) }
    }

    val fragmentViewModelName = stringParameter {
        name = "FragmentViewModel名称"
        default = "MainFragmentViewModel"
        help = "FragmentViewModel名称"
        constraints = listOf(Constraint.NONEMPTY)
        suggest = { "${layoutToFragment(folderName.value)}ViewModel" }
    }

    val fragmentLayoutName = stringParameter {
        name = "Fragment布局名称"
        default = "fragment_main"
        help = "Fragment布局名称"
        constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
        suggest = { fragmentToLayout(folderName.value) }
    }
}