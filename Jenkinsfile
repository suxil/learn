def git_address = "http://192.168.159.136:31241/kube-learn/learn.git"
def git_auth = "89132536-495f-460f-abf2-5295782dc137"

podTemplate(cloud: 'kubernetes',
    containers: [
        containerTemplate(name: 'maven', image: '192.168.159.137:31003/learn/maven:3.6.3-jdk-8-openj9', ttyEnabled: true, command: 'cat'),
        containerTemplate(name: 'docker', image: '192.168.159.137:31003/learn/docker:19.03.8', ttyEnabled: true, command: 'cat'),
    ],
    volumes: [
        hostPathVolume(mountPath: '/var/run/docker.sock', hostPath: '/var/run/docker.sock'),
        hostPathVolume(mountPath: '/usr/bin/docker', hostPath: '/usr/bin/docker'),
        nfsVolume(mountPath: '/root/.m2', serverAddress: '192.168.159.138', serverPath: '/data/jenkins-slave-data/maven', readOnly: false),
    ],
)
{
    node(POD_LABEL) {
        // 第一步
        stage('拉取代码') {
            checkout([$class: 'GitSCM', branches: [[name: 'develop']],
            userRemoteConfigs: [[credentialsId: "${git_auth}", url: "${git_address}"]]])
        }
        // 第二步
        stage('代码编译') {
            container('maven') {
                stage('编译maven项目') {
                    sh 'mvn -version'
                    sh 'mvn clean install -DskipTests'
                }
                stage('打包上传镜像') {
                    sh 'cd ./auth-service && mvn dockerfile:build'
                    sh 'cd ./auth-service && mvn dockerfile:push'
                }
            }
        }
        // 第三步
        stage("SonarQube 代码检查") {
            container('maven') {
                stage('代码检查') {
                    sh 'mvn sonar:sonar -Dsonar.projectKey=learn_project -Dsonar.sources=src -Dsonar.tests=src -Dsonar.host.url=http://192.168.159.136:30425 -Dsonar.login=admin -Dsonar.password=admin -Dsonar.language=java -Dsonar.java.binaries=target/classes -Dsonar.sourceEncoding=UTF-8 -Dsonar.scm.provider=git -Dsonar.test.inclusions=**/*Test*/** -Dsonar.exclusions=**/*Test*/**,**/test/**,**/generate/**,**/rsql/parser/**,**/converter/**,**/domain/**,**/dto/**,**/vo/**'
                }
            }
        }
    }
}
