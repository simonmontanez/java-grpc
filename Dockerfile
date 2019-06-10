FROM gcr.io/google_appengine/openjdk8

EXPOSE 50051

ADD ./build/dependency/java-grpc /java-grpc

ENTRYPOINT exec ./java-grpc/bin/java-grpc