Introduction
============
I have hacked the BPEL Say Hello quickstart to include a JMS gateway binding in addition 
to the SOAP gateway binding.

Running the quickstart
======================

JBoss AS 7
----------
1. Build the quickstart:
    mvn clean install
2. Start JBoss AS 7 in standalone-preview mode:
    ${AS}/bin/standalone.sh --server-config=standalone-full.xml
3. Start JBoss CLI and connect: 
    ./jboss-admin.sh --connect
4. Create the JMS Queue using CLI:
    add-jms-queue --name=HelloRequestQueue --entries=HelloRequestQueue
    add-jms-queue --name=HelloReplyQueue --entries=HelloReplyQueue
5. Deploy the quickstart
    cp target/switchyard-quickstart-bpel-service-say-hello.jar ${AS7}/standalone/deployments
6. Execute HornetQClient
    mvn exec:java -Dexec.mainClass="org.switchyard.quickstart.bpel.service.hello.HornetQClient" -Dexec.args="Skippy"
7. Watch the command output for the reply message.


