FROM openjdk
EXPOSE 8080
ADD ./target/TheAkatsukiServer-1.0-jar-with-dependencies.jar /srv/TheAkatsukiServer-1.0-jar-with-dependencies.jar
CMD java -jar /srv/TheAkatsukiServer-1.0-jar-with-dependencies.jar
