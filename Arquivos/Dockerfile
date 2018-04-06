FROM registry.access.redhat.com/jboss-eap-7/eap71-openshift
COPY redhat-0.1.war $JBOSS_HOME/standalone/deployments/
USER root
RUN chown jboss:jboss $JBOSS_HOME/standalone/deployments/redhat-0.1.war
USER jboss
