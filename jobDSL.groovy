job('DSL Job'){
scm {
        git('https://github.com/BHAVESHRAJ/Jenkins-test-helloworld')
		 branch('master')
    }
	label('msbuild')
    triggers {
        scm('H/15 * * * *')
    }
	  steps {
        msBuild {
            msBuildInstallation('MSBuild 15.0')
            buildFile('HelloWorld.sln')
            continueOnBuildFailure()
        }
    }
}