FROM openjdk:17
ARG JAR_FILE=target/*.jar
ENV BOT_NAME=teko_practice_tgbot
ENV BOT_TOKEN=5555254173:AAGE6liapeVMENnvRTl_4gPmlGrxWdzpzPI
ENV BOT_DB_USERNAME=tgbot_db_user
ENV BOT_DB_PASSWORD=tgbot_db_password
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Dspring.datasource.password=${BOT_DB_PASSWORD}", "-Dbot.username=${BOT_NAME}", "-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}", "-jar", "/app.jar"]