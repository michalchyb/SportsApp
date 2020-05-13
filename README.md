# SportsApp

### Jenkins integration

For linux systems run commands below:
1. `docker pull jenkins/jenkins`
2. `sudo docker run -p 9090:8080 -p 50000:50000 -v /home/michalch/Pulpit/Jenkins/log:/var/jenkins_home jenkins/jenkins`

Docker will run on port 9090. After getting http://localhost:9090/ fro the first time you might need to install plugins.
After that you might use and configure jenkins for you purposes.
All configuration files will be stored in `/home/michalch/Pulpit/Jenkins/log:/var/jenkins_home`. Running jenkins container once again will load previous configuration