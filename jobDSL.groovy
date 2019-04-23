job('DSL Job'){
scm {
        git('https://github.com/BHAVESHRAJ/Jenkins-test-helloworld')
    }
    triggers {
        scm('H/15 * * * *')
    }
	  steps {
        msBuild {
            msBuildInstallation('MSBuild 1.8')
            buildFile('dir1/build.proj')
            args('check')
            args('another')
            passBuildVariables()
            continueOnBuildFailure()
            unstableIfWarnings()
        }
    }
}