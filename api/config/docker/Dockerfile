# ビルド用コンテナ
FROM amazoncorretto:20.0.2-alpine as builder

ENV LANG C.UTF-8
ENV TZ Asia/Tokyo

WORKDIR /var/api

RUN apk add --update --no-cache \
      tzdata

ADD . .

RUN ./gradlew assemble

# 実行用コンテナ
FROM amazoncorretto:20.0.2-alpine

ENV LANG C.UTF-8
ENV TZ Asia/Tokyo

WORKDIR /var/api

RUN apk add --update --no-cache \
      ca-certificates

COPY --from=builder /var/api/build/libs/api-0.0.1-SNAPSHOT.jar ./api.jar
COPY --from=builder /usr/share/zoneinfo/Asia/Tokyo /usr/share/zoneinfo/Asia/Tokyo

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "./api.jar"]
