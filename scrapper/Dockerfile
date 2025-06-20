FROM openjdk:21
# Создание рабочей директории
COPY ./target/scrapper.jar /app/scrapper.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/scrapper.jar"]
