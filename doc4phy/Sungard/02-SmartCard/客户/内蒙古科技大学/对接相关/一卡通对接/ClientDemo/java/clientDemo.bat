@echo on
set CURRENT_DIR=%~dp0
set INSTALL_HOME=%CURRENT_DIR%..\..
set JAVA_HOME=%INSTALL_HOME%\common\jre

set _RUNJAVA="%JAVA_HOME%\bin\java"
set _RUNJAVAW="%JAVA_HOME%\bin\javaw"

"%JAVA_HOME%\bin\java" -classpath "%CURRENT_DIR%\clientDemo.jar;%CURRENT_DIR%\axiom-api.jar;%CURRENT_DIR%\axiom-dom.jar;%CURRENT_DIR%\axiom-impl.jar;%CURRENT_DIR%\axis2-adb.jar;%CURRENT_DIR%\axis2-codegen.jar;%CURRENT_DIR%\axis2-kernel.jar;%CURRENT_DIR%\backport-util-concurrent.jar;%CURRENT_DIR%\bcprov-jdk15.jar;%CURRENT_DIR%\commons-codec.jar;%CURRENT_DIR%\commons-httpclient.jar;%CURRENT_DIR%\commons-httpclient-contrib.jar;%CURRENT_DIR%\commons-lang.jar;%CURRENT_DIR%\commons-logging.jar;%CURRENT_DIR%\geronimo-activation.jar;%CURRENT_DIR%\geronimo-stax-api.jar;%CURRENT_DIR%\jaxen.jar;%CURRENT_DIR%\mex-impl.jar;%CURRENT_DIR%\neethi.jar;%CURRENT_DIR%\opensaml.jar;%CURRENT_DIR%\rampart-core.jar;%CURRENT_DIR%\rampart-policy.jar;%CURRENT_DIR%\rampart-trust.jar;%CURRENT_DIR%\woden-api.jar;%CURRENT_DIR%\woden-impl-dom.jar;%CURRENT_DIR%\wsdl4j.jar;%CURRENT_DIR%\wss4j.jar;%CURRENT_DIR%\wstx-asl.jar;%CURRENT_DIR%\xalan.jar;%CURRENT_DIR%\XmlSchema.jar;%CURRENT_DIR%\xmlsec.jar;" com.h3c.imc.acmws.acmuserservice.client.AcmUserWsClient %1 %2 %3
