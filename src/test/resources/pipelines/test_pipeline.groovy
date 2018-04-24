package pipelines

node() {
    stage("Get code") {
        git 'https://github.com/troe88/spbstu2018TA'
    }

    stage("Compile") {
        sh 'mvn clean compile test-compile'
    }

    stage("Smoke tests") {
        sh 'mvn clean test site -P simple_selenide'
    }

    stage('report') {
        script {
            allure([
                    results: [[path: 'target/allure-results']]
            ])
        }

        if (!failedJobName.isEmpty())
            error "Build has failed on job: ${failedJobName} !"
    }
}