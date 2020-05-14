# SportsApp

### Jenkins integration

For linux systems run commands below:
1. `docker pull jenkins/jenkins`
2. `sudo docker build --tag="your_build_name" /path_to_docker_file` 
3. `sudo docker run -p 9090:8080 -p 50000:50000 -v /your_directory/:/var/jenkins_home jenkins/jenkins`
 OR
 `sudo docker run -u root --rm -d -p 9090:8080 -p 50000:50000 -v jenkins-data:/var/jenkins_home/custom -v /var/run/docker.sock:/var/run/docker.sock customjenkinswithmaven`

Docker will run on port 9090. After getting http://localhost:9090/ for the first time you might need to install plugins.
After that you might use and configure jenkins for you purposes.
All configuration files will be stored in `your_path:/var/jenkins_home`. Running jenkins container once again will load previous configuration.

