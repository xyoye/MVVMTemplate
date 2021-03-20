package other.template

import com.android.tools.idea.wizard.template.*
import other.template.activity.activityTemplateSetup
import other.template.fragment.fragmentTemplateSetup
import other.template.utils.TemplateType

val MVVMTemplateData
    get() = template {
        revision = 2
        name = "MVVMTemplate"
        description = "Create a new DanDanPlay MVVM module from template"
        minApi = 16
        minBuildApi = 16
        category = Category.Other // Check other categories
        formFactor = FormFactor.Mobile
        screens = listOf(WizardUiContext.FragmentGallery, WizardUiContext.MenuEntry,
                WizardUiContext.NewProject, WizardUiContext.NewModule)

        val templateType = enumParameter<TemplateType> {
            name = "Template Type"
            default = TemplateType.Activity
            help = "模板类型"
        }

        val folderName = stringParameter {
            name = "Folder Name"
            default = "main"
            help = "文件夹名称"
            constraints = listOf(Constraint.NONEMPTY, Constraint.PACKAGE)
        }

        //-------------activity------------

        val activityName = stringParameter {
            name = "Activity Name"
            default = "MainActivity"
            help = "Activity名称"
            constraints = listOf(Constraint.NONEMPTY)
            suggest = { layoutToActivity(folderName.value) }
            visible = { templateType.value == TemplateType.Activity }
        }

        val activityViewModelName = stringParameter {
            name = "ViewModel Name"
            default = "MainViewModel"
            help = "ViewModel名称"
            constraints = listOf(Constraint.NONEMPTY)
            suggest = { "${underscoreToCamelCase(classToResource(folderName.value))}ViewModel" }
            visible = { templateType.value == TemplateType.Activity }
        }

        val activityLayoutName = stringParameter {
            name = "Layout Name"
            default = "activity_main"
            help = "Activity布局名称"
            constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
            suggest = { activityToLayout(folderName.value) }
            visible = { templateType.value == TemplateType.Activity }
        }

        //-------------fragment------------

        val fragmentName = stringParameter {
            name = "Fragment Name"
            default = "MainFragment"
            help = "Fragment名称"
            constraints = listOf(Constraint.NONEMPTY)
            suggest = { layoutToFragment(folderName.value) }
            visible = { templateType.value == TemplateType.Fragment }
        }

        val fragmentViewModelName = stringParameter {
            name = "Fragment ViewModel Name"
            default = "MainFragmentViewModel"
            help = "FragmentViewModel名称"
            constraints = listOf(Constraint.NONEMPTY)
            suggest = { "${layoutToFragment(folderName.value)}ViewModel" }
            visible = { templateType.value == TemplateType.Fragment }
        }

        val fragmentLayoutName = stringParameter {
            name = "Layout Name"
            default = "fragment_main"
            help = "Fragment布局名称"
            constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
            suggest = { fragmentToLayout(folderName.value) }
            visible = { templateType.value == TemplateType.Fragment }
        }

        widgets(
                EnumWidget(templateType),
                TextFieldWidget(folderName),
                TextFieldWidget(activityName),
                TextFieldWidget(activityViewModelName),
                TextFieldWidget(activityLayoutName),
                TextFieldWidget(fragmentName),
                TextFieldWidget(fragmentViewModelName),
                TextFieldWidget(fragmentLayoutName)
        )

        recipe = { data: TemplateData ->
            if (templateType.value == TemplateType.Activity) {
                activityTemplateSetup(
                        data as ModuleTemplateData,
                        folderName.value,
                        activityName.value,
                        activityViewModelName.value,
                        activityLayoutName.value
                )
            } else {
                fragmentTemplateSetup(
                        data as ModuleTemplateData,
                        folderName.value,
                        fragmentName.value,
                        fragmentViewModelName.value,
                        fragmentLayoutName.value
                )
            }
        }
    }