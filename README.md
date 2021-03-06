# Parsing json logging with Openshift Cluster Logging
This sample project contains a rest api with a json response and a simple sysout json log.

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
## Kibana Structured field
![important](https://github.com/rafamqrs/parse-logging-ocp/blob/master/kibana-view.png)

## Samples
![samples](https://github.com/rafamqrs/parse-logging-ocp/blob/master/parse-samples.png)

## Important
![important](https://github.com/rafamqrs/parse-logging-ocp/blob/master/important.png)



# Multiline Error Openshift Cluster Logging
Sometimes you wish the stack traces be sent to ElasticSearch as a single log line, by default each line of the log is created in differents lines and stack traces are shown on multiple lines in Kibana.

### Environment
    - Red Hat OpenShift Container Platform (RHOCP) 4.8 and later
    - Red Hat OpenShift Logging (RHOL)
    - 5.3

KCS reference: https://access.redhat.com/solutions/5507871

```yaml
apiVersion: logging.openshift.io/v1
kind: ClusterLogForwarder
metadata:
  name: instance 
  namespace: openshift-logging 
spec:
...
  pipelines:
   - name: forward-to-fluentd-secure 
      detectMultilineErrors: true
      inputRefs:  
      ...
```


