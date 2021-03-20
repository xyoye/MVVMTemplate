package other.template.fragment

/**
 * Created by xyoye on 2021/1/16.
 */

fun MVVMFragmentViewModel(
        packageName: String,
        folderName: String,
        viewModelName: String
) = """package ${packageName}.ui.fragment.${folderName.toLowerCase()}

import com.xyoye.common_component.base.BaseViewModel

class ${viewModelName} : BaseViewModel() {

}"""