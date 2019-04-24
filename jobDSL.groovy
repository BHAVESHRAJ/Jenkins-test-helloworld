job('DSL Job'){
scm {
        git('https://github.com/BHAVESHRAJ/Jenkins-test-helloworld','master')
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
	publishers {
        archiveArtifacts {
            pattern('HelloWorld/bin/Debug/*.exe')
            pattern('HelloWorld/bin/Debug/*.pdp')
            onlyIfSuccessful()
        }
    }
}