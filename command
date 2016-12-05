$ Command Sets

cd workspace/example5/jcmc/src/main/java
javac -cp .:/home/mdy/workspace/example5/6367Test/lib/asm-all-5.0.3.jar:/usr/share/java/junit4.jar: jcmc/*.java
jar -cfm MyAgent.jar jcmc/agtinfo jcmc/Agent.class
java -javaagent:MyAgent.jar=jcmc -cp .:/home/mdy/workspace/example5/6367Test/lib/asm-all-5.0.3.jar:/usr/share/java/junit4.jar: org.junit.runner.JUnitCore jcmc.t1
java jcmc.CoverageCalculation
java jcmc.DeleteCoverageInformation

cd workspace/example5/jcmc/src/main/java
javac -cp .:/home/mdy/workspace/jcmc/target/jcmc-0.0.1-SNAPSHOT.jar: jcmc/*.java
java -javaagent:/home/mdy/workspace/jcmc/target/jcmc-0.0.1-SNAPSHOT.jar=jcmc -cp .:/home/mdy/workspace/jcmc/target/jcmc-0.0.1-SNAPSHOT.jar: org.junit.runner.JUnitCore jcmc.t1

$ Reference
http://stackoverflow.com/questions/23287228/how-do-i-pass-arguments-to-a-java-instrumentation-agent