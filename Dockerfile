FROM java:8
EXPOSE 9000
ADD /target/online-vending-machine-0.0.1-SNAPSHOT.jar online-vending-machine-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/online-vending-machine-0.0.1-SNAPSHOT.jar"]
