package other.template.activity

/**
 * Created by xyoye on 2021/1/16.
 */

fun MVVMActivityViewModel(
        packageName: String,
        folderName: String,
        viewModelName: String
) = """package $packageName.ui.activities.${folderName.toLowerCase()}

import com.xyoye.common_component.base.BaseViewModel

class $viewModelName : BaseViewModel() {

}"""