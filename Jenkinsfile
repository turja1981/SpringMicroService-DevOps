node {
   echo 'Hello World'
   stage('Checkout') {
    checkout scm   
   }

   stage('Build Angular'){
       sh 'pwd'
       dir ('AngularApp') {
            sh 'pwd'
            sh 'npm install -f'
            sh 'npm run build'
        }
     //  sh 'cd AngularApp'

   }

stage('Copy Node'){
    dir('/home/ec2-user/GitWS/NodeApp/'){
        sh 'rm -rf /home/ec2-user/GitWS/NodeApp/*'
        dir('/root/.jenkins/workspace/test/NodeApp'){
           sh 'pwd'
           sh 'mv -f * /home/ec2-user/GitWS/NodeApp/'           
        }
        sh 'npm i'
    }       
}

   stage('Copy Angular to Node'){
       dir('/home/ec2-user/AngularBuildDir'){
           sh 'pwd'
           sh 'mv -f * /home/ec2-user/GitWS/NodeApp/resources/'
       }
   }

   stage('Execute NODE Unit Test'){
       dir('/home/ec2-user/GitWS/NodeApp/test'){
           sh 'pwd'
           sh 'npm test'
       }
   }


    stage('Build Docker Image for Web Application'){
        dir('/home/ec2-user/GitWS/NodeApp'){
            sh 'docker build . -t node-web-app'
        }
    }


    stage('Run Docker Image of the Web Application'){
        sh 'docker run -p 9090:9090 --net="host" -d node-web-app'
    }

   
}