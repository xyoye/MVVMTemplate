package com.xyoye.dandanplay.template.activity

fun manifest(folderName: String, activityName: String) = """
<manifest xmlns:android="http://schemas.android.com/apk/res/android">
    <application>
${
    """
        <activity 
            android:name=".ui.activities.$folderName.$activityName"
            android:configChanges="orientation|screenSize" />
    """
}
    </application>
</manifest>
"""