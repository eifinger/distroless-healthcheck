# distroless-healthcheck

Demonstrates how to use healtchecks with
[distroless](https://github.com/GoogleContainerTools/distroless) images for Java.

Additionally, it uses [jib](https://github.com/GoogleContainerTools/jib) to build the image.

## Usage

1. Build the image to a local Docker daemon
    ```bash
    ./gradlew jibDockerBuild
    ```
2. Run the image
    ```bash
    docker run -p 8080:8080 --name distroless-healthcheck -d eifinger/distroless-healthcheck:latest
    ```
3. Check the healthcheck
    ```bash
    docker exec -it distroless-healthcheck java -cp @/app/jib-classpath-file de.eifinger.distrolesshealthcheck.DistrolessHealthcheckApplicationKt --healthcheck
    ```
