job('DSL Job'){
scm {
        git('https://github.com/BHAVESHRAJ/Jenkins-test-helloworld')
    }
    triggers {
        scm('H/15 * * * *')
    }
}