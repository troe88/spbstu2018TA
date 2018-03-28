node() {
    stage("Get code") {
        git 'https://github.com/troe88/spbstu2018TA'
    }

    stage("Compile") {
        sh 'mvn clean compile test-compile'
    }

    stage("Smoke tests") {
        sh 'mvn clean test -P simple_selenium'
    }
}