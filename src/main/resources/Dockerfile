FROM centos

RUN yum install -y java
VOLUME /tmp
ADD /energy-0.0.1 myapp.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/myapp.jar"]
