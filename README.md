# jcmc
# Java Class-File Manupulation and Coverage-Collection
#
# Preparations needed before using jcmc tool:
# 1. in MethodTransformVisitor.java file, in line 45 & line 82, change "~/Z_coverage/c_path.txt" to your specified "directory/c_path.txt"
# 2. in MethodTransformVisitor.java file, in line 125, change "~/Z_coverage/t_path.txt" to your specified "directory/t_path.txt"
# 3. in terminal ("ubuntu linux for example"), to jcmc directory, run mvn clean install to install jcmc to your local repository, log the directory for the .jar file
# 4. in the subject, add maven-surefire-plugin in the bulid setting if it dose not include in the original version, specify <argLine>-javaagent:~/jcmc/jcmc/0.0.1-SNAPSHOT/jcmc-0.0.1-SNAPSHOT.jar=package_name</argLine> in the configuration
