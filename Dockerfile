# Build
FROM eclipse-temurin:21-jdk-alpine as build
RUN mkdir /valkyrie
COPY . /valkyrie
WORKDIR /valkyrie
RUN ./gradlew clean build

# Optimize JRE
FROM eclipse-temurin:21-jdk-alpine as customjre
RUN mkdir /work
COPY --from=build /valkyrie/app/build/libs/app-0.0.1-SNAPSHOT.jar /work/valkyrie.jar
WORKDIR /work
RUN jar xf valkyrie.jar
# find modules dependencies
RUN jdeps --ignore-missing-deps -q  \
    --recursive  \
    --multi-release 21  \
    --print-module-deps  \
    --class-path 'BOOT-INF/lib/*' \
    valkyrie.jar > deps.info
# create a custom jre
RUN jlink \
    --add-modules $(cat deps.info) \
    --strip-debug \
    --compress 2 \
    --no-header-files \
    --no-man-pages \
    --output /customjre

FROM node:current-alpine as front
COPY ./front-vue /work
WORKDIR /work
RUN npm ci
RUN npm run build

# Slim image
FROM alpine as valkyrie
ENV JAVA_HOME /jre
ENV PATH $JAVA_HOME/bin:$PATH
ENV PAGES_DIRECTORY file:/pages/
COPY --from=front /work/dist /pages
COPY --from=customjre /customjre $JAVA_HOME
RUN mkdir /libs
COPY --from=customjre /work/valkyrie.jar /libs/valkyrie.jar
WORKDIR /libs
ENTRYPOINT java -jar valkyrie.jar
