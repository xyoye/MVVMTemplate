package com.xyoye.dandanplay.plugin.services

import com.xyoye.dandanplay.plugin.MyBundle
import com.intellij.openapi.project.Project

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
