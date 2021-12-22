# Parsing json logging with Openshift Cluster Logging
This sample project contains a rest api with a json responde and a simple log sysout.

The base of the project is to show how to set up the ClusterLogForwader to parse the log json message into the structured fields. 

## Running the application in dev mode

You can run/deploy your application on the Openshift using the command:
```shell script
./mvnw clean package -Dquarkus.kubernetes.deploy=true
```

## ClusterLogForwader instance
```yaml
apiVersion: logging.openshift.io/v1
kind: ClusterLogForwarder
metadata:
  name: instance
  namespace: openshift-logging
spec:
  outputDefaults:
    elasticsearch:
      structuredTypeKey: kubernetes.labels.app
  pipelines:
  - inputRefs:
    - infrastructure
    - application
    name: parse-all-json
    outputRefs:
    - default
    parse: json

```


