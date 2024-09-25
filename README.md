MCVE for replicating issues when working with Quarkus, gRPC and a multi-subproject Gradle build.

### IMPORTANT!

To replicate my local environment where I encountered these issues, there are no dependency repositories defined in the Gradle files. The company where 
I work use a company-private artifact repository for all dependencies, and since that requires credentials to be specified that is defined in our
home directories: ~/.gradle/init.gradle.

#### **Therefore, you will need to either define your own init.gradle file that configures repositories for all Gradle projects, or add repository definitions to this project to reproduce the issue in question.**

The current error is:
```
> Task :driven-adapters:generateProto FAILED
Execution failed for task ':driven-adapters:generateProto'.
> java.io.IOException: Cannot run program "protoc": CreateProcess error=2, The system cannot find the file specified
```