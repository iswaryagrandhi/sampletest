package patches.buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.ScriptBuildStep
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2019_2.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, change the buildType with id = 'Build'
accordingly, and delete the patch script.
*/
changeBuildType(RelativeId("Build")) {
    expectSteps {
        script {
            scriptContent = """echo "helloworld" >sampletext.txt"""
        }
        script {
            name = "test2"
            scriptContent = """echo "test2""""
        }
    }
    steps {
        insert(0) {
            maven {
                goals = "clean test"
                pomLocation = "helloworld/pom.xml"
                runnerArgs = "-Dmaven.test.failure.ignore=true"
                jdkHome = "%env.JDK_1_8%"
            }
        }
        update<ScriptBuildStep>(1) {
            enabled = false
            clearConditions()
        }
        items.removeAt(2)
    }
}
