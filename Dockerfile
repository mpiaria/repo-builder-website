FROM adoptopenjdk:11-openj9
RUN mkdir /opt/app
COPY application/build/libs/*.jar /opt/app/app.jar
RUN adduser --group --system spring
USER spring:spring
CMD ["java", "-jar", "/opt/app/app.jar"]
