# 1. Aşama: Uygulamayı Gradle ile derleme (Builder)
FROM gradle:7.5.1-jdk17 as builder
WORKDIR /app
COPY . /app
RUN gradle build -x test

# 2. Aşama: Canlıda çalışacak hafif ve güvenli runtime ortamı
FROM amazoncorretto:17-alpine
WORKDIR /app

# Derlenen jar dosyasını builder aşamasından kopyalıyoruz
COPY --from=builder /app/build/libs/ilican-special-education-0.0.1-SNAPSHOT.jar /app/app.jar

# Uygulamanın dış dünyaya açılacağı port
EXPOSE 8080

# Uygulamayı ayağa kaldıran komut
ENTRYPOINT ["java", "-jar", "/app/app.jar"]