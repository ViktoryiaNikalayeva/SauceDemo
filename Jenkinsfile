tools {
   // Install the Maven version configured as "M3" and add it to the path.
   maven "M3"
}
parameters {
 gitParameter branchFilter: 'origin/(.*)', defaultValue: 'master', name: 'BRANCH', type: 'PT_BRANCH'
}
triggers {
        cron('0 8 * * *')
    }
    parameters {
        gitParameter branchFilter: 'origin/(.*)', defaultValue: 'master', name: 'BRANCH', type: 'PT_BRANCH'
    }
stages {
  stage('Run test') {
     steps {
        // Get some code from a GitHub repository
        git branch: "${params.BRANCH}", url: 'https://github.com/ViktoryiaNikalayeva/SauceDemo/tree/feature/30/10.git'
     }
  }
}