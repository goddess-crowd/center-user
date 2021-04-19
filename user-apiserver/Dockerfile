FROM java:8
ARG JAR_FILE
ADD target/${JAR_FILE} app.jar
COPY --from=hengyunabc/arthas:latest /opt/arthas/arthas-boot.jar /arthas.jar
# 对外端口
EXPOSE 12003
ENTRYPOINT ["java", "-jar", "/app.jar"]
