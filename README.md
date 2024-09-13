MCVE for replicating an UnsatisfiedResolutionException issue when working with Quarkus in a multi-subproject Gradle build.

### IMPORTANT!

To replicate my local environment where I encountered the issue, there are no dependency repositories defined in the Gradle files. The company where 
I work use a company-private artifact repository for all dependencies, and since that requires credentials to be specified, they are defined in our
home directories: ~/.gradle/init.gradle.

**Therefore you will need to either define your own init.gradle file that configures repositories for all Gradle projects, or add repository
definitions to this project to reproduce the issue in question.**

The error is logged out as:
```
Execution failed for task ':driving-adapters:quarkusAppPartsBuild'.
> There was a failure while executing work items
   > A failure occurred while executing io.quarkus.gradle.tasks.worker.BuildWorker
      > io.quarkus.builder.BuildException: Build failure: Build failed due to errors
        	[error]: Build step io.quarkus.arc.deployment.ArcProcessor#validate threw an exception: jakarta.enterprise.inject.spi.DeploymentException: jakarta.enterprise.inject.UnsatisfiedResolutionException: Unsatisfied dependency for type com.example.domain.ports.outgoing.DummyRepository and qualifiers [@Default]
        	- injection target: parameter 'dummyRepository' of com.example.domain.ports.ingoing.DummyUseCase constructor
        	- declared on CLASS bean [types=[java.lang.Object, com.example.domain.ports.ingoing.DummyUseCase], qualifiers=[@Default, @Any], target=com.example.domain.ports.ingoing.DummyUseCase]
        	at io.quarkus.arc.processor.BeanDeployment.processErrors(BeanDeployment.java:1529)
        	at io.quarkus.arc.processor.BeanDeployment.init(BeanDeployment.java:332)
        	at io.quarkus.arc.processor.BeanProcessor.initialize(BeanProcessor.java:166)
        	at io.quarkus.arc.deployment.ArcProcessor.validate(ArcProcessor.java:488)
        	at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)
        	at java.base/java.lang.reflect.Method.invoke(Method.java:580)
        	at io.quarkus.deployment.ExtensionLoader$3.execute(ExtensionLoader.java:849)
        	at io.quarkus.builder.BuildContext.run(BuildContext.java:256)
        	at org.jboss.threads.ContextHandler$1.runWith(ContextHandler.java:18)
        	at org.jboss.threads.EnhancedQueueExecutor$Task.doRunWith(EnhancedQueueExecutor.java:2516)
        	at org.jboss.threads.EnhancedQueueExecutor$Task.run(EnhancedQueueExecutor.java:2495)
        	at org.jboss.threads.EnhancedQueueExecutor$ThreadBody.run(EnhancedQueueExecutor.java:1521)
        	at java.base/java.lang.Thread.run(Thread.java:1583)
        	at org.jboss.threads.JBossThread.run(JBossThread.java:483)
        Caused by: jakarta.enterprise.inject.UnsatisfiedResolutionException: Unsatisfied dependency for type com.example.domain.ports.outgoing.DummyRepository and qualifiers [@Default]
        	- injection target: parameter 'dummyRepository' of com.example.domain.ports.ingoing.DummyUseCase constructor
        	- declared on CLASS bean [types=[java.lang.Object, com.example.domain.ports.ingoing.DummyUseCase], qualifiers=[@Default, @Any], target=com.example.domain.ports.ingoing.DummyUseCase]
        	at io.quarkus.arc.processor.Beans.resolveInjectionPoint(Beans.java:519)
        	at io.quarkus.arc.processor.BeanInfo.init(BeanInfo.java:642)
        	at io.quarkus.arc.processor.BeanDeployment.init(BeanDeployment.java:317)
        	... 12 more
```