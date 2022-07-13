FROM se2beta/vaadin-builder:ubi
ARG JAR_FILE=target/*.jar
ENV BOT_NAME=teko_practice_tgbot
ENV BOT_TOKEN=5555254173:AAGE6liapeVMENnvRTl_4gPmlGrxWdzpzPI
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}", "-jar", "/app.jar"]