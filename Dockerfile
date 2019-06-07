FROM openjdk:8-jdk-alpine

EXPOSE 50051

ADD java-grpc /java-grpc

ENTRYPOINT exec ./java-grpc/bin/java-grpc