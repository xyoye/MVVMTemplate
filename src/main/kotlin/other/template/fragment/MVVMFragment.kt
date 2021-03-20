package other.template.fragment

import com.android.tools.idea.wizard.template.classToResource
import com.android.tools.idea.wizard.template.underscoreToCamelCase

/**
 * Created by xyoye on 2021/1/16.
 */

fun MVVMFragment(
        packageName: String,
        folderName: String,
        layoutName: String,
        fragmentName: String,
        viewModelName: String
) = """package ${packageName}.ui.fragment.${folderName.toLowerCase()}

import com.xyoye.common_component.base.BaseFragment

import ${packageName}.BR
import ${packageName}.R
import ${packageName}.databinding.Fragment${underscoreToCamelCase(classToResource(folderName))}Binding

class ${fragmentName} : BaseFragment<${viewModelName}, Fragment${underscoreToCamelCase(classToResource(folderName))}Binding>() {

    override fun initViewModel() =
        ViewModelInit(
            BR.viewModel,
            ${viewModelName}::class.java
        )

    override fun getLayoutId() = R.layout.${layoutName}

    override fun initView() {

    }
}"""