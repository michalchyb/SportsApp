FROM jenkins/jenkins:lts

USER root

RUN apt-get install -y wget

RUN wget --no-verbose -O /tmp/apache-maven-3.6.3.bin.tar.gz http://ftp.man.poznan.pl/apache/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.tar.gz

RUN tar xzf /tmp/apache-maven-3.6.3.bin.tar.gz -C /opt/
RUN ln -s /opt/apache-maven-3.6.3 /opt/maven
RUN ln -s /opt/maven/bin/mvn /usr/local/bin
RUN rm -f /tmp/apache-maven-3.6.3-bin.tar.gz
ENV MAVEN_HOME /opt/maven

RUN chown -R jenkins:jenkins /opt/maven

RUN apt-get clean

USER jenkins


