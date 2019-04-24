job('DSL Job'){
 description('This job is created for building the Hello world .net sample project')
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
            onlyIfSuccessful()
        }
    }
}