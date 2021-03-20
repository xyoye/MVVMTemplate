package other.template.activity

import com.android.tools.idea.wizard.template.classToResource
import com.android.tools.idea.wizard.template.underscoreToCamelCase

/**
 * Created by xyoye on 2021/1/16.
 */

fun MVVMActivity(
        packageName: String,
        folderName: String,
        layoutName: String,
        activityName: String,
        viewModelName: String
) = """package $packageName.ui.activities.${folderName.toLowerCase()}

import com.xyoye.common_component.base.BaseActivity

import $packageName.BR
import $packageName.R
import $packageName.databinding.Activity${underscoreToCamelCase(classToResource(folderName))}Binding

class $activityName : BaseActivity<$viewModelName, Activity${underscoreToCamelCase(classToResource(folderName))}Binding>() {

    override fun initViewModel() =
        ViewModelInit(
            BR.viewModel,
            $viewModelName::class.java
        )

    override fun getLayoutId() = R.layout.$layoutName

    override fun initView() {

    }
}"""