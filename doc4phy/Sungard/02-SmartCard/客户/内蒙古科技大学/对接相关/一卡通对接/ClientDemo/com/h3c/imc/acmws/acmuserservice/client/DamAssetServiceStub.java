
/**
 * DamAssetServiceStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:35 LKT)
 */
        package com.h3c.imc.acmws.acmuserservice.client;



        /*
        *  DamAssetServiceStub java implementation
        */


        public class DamAssetServiceStub extends org.apache.axis2.client.Stub
        {
        protected org.apache.axis2.description.AxisOperation[] _operations;

        //hashmaps to keep the fault mapping
        public java.util.HashMap faultExceptionNameMap = new java.util.HashMap();
        public java.util.HashMap faultExceptionClassNameMap = new java.util.HashMap();
        public java.util.HashMap faultMessageMap = new java.util.HashMap();

        public static int counter = 0;

        public static synchronized String getUniqueSuffix(){
            // reset the counter if it is greater than 99999
            if (counter > 99999){
                counter = 0;
            }
            counter = counter + 1;
            return Long.toString(System.currentTimeMillis()) + "_" + counter;
        }


    public void populateAxisService() throws org.apache.axis2.AxisFault {

     //creating the Service with a unique name
     _service = new org.apache.axis2.description.AxisService("DamAssetService" + getUniqueSuffix());
     addAnonymousOperations();

        //creating the operations
        org.apache.axis2.description.AxisOperation __operation;

        _operations = new org.apache.axis2.description.AxisOperation[6];

                   __operation = new org.apache.axis2.description.OutInAxisOperation();


            __operation.setName(new javax.xml.namespace.QName("http://dam.imc.h3c.com/damAssetService", "queryAsset"));
	    _service.addOperation(__operation);




            _operations[0]=__operation;


                   __operation = new org.apache.axis2.description.OutInAxisOperation();


            __operation.setName(new javax.xml.namespace.QName("http://dam.imc.h3c.com/damAssetService", "queryAssetGroup"));
	    _service.addOperation(__operation);




            _operations[1]=__operation;


                   __operation = new org.apache.axis2.description.OutInAxisOperation();


            __operation.setName(new javax.xml.namespace.QName("http://dam.imc.h3c.com/damAssetService", "deleteAsset"));
	    _service.addOperation(__operation);




            _operations[2]=__operation;


                   __operation = new org.apache.axis2.description.OutInAxisOperation();


            __operation.setName(new javax.xml.namespace.QName("http://dam.imc.h3c.com/damAssetService", "modifyAsset"));
	    _service.addOperation(__operation);




            _operations[3]=__operation;


                   __operation = new org.apache.axis2.description.OutInAxisOperation();


            __operation.setName(new javax.xml.namespace.QName("http://dam.imc.h3c.com/damAssetService", "queryAssetDetail"));
	    _service.addOperation(__operation);




            _operations[4]=__operation;


                   __operation = new org.apache.axis2.description.OutInAxisOperation();


            __operation.setName(new javax.xml.namespace.QName("http://dam.imc.h3c.com/damAssetService", "addAsset"));
	    _service.addOperation(__operation);




            _operations[5]=__operation;


        }

    //populates the faults
    public void populateFaults(){



    }

    /**
      *Constructor that takes in a configContext
      */

    public DamAssetServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext,
       java.lang.String targetEndpoint)
       throws org.apache.axis2.AxisFault {
         this(configurationContext,targetEndpoint,false);
   }


   /**
     * Constructor that takes in a configContext  and useseperate listner
     */
   public DamAssetServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext,
        java.lang.String targetEndpoint, boolean useSeparateListener)
        throws org.apache.axis2.AxisFault {
         //To populate AxisService
         populateAxisService();
         populateFaults();

        _serviceClient = new org.apache.axis2.client.ServiceClient(configurationContext,_service);


        configurationContext = _serviceClient.getServiceContext().getConfigurationContext();

        _serviceClient.getOptions().setTo(new org.apache.axis2.addressing.EndpointReference(
                targetEndpoint));
        _serviceClient.getOptions().setUseSeparateListener(useSeparateListener);

            //Set the soap version
            _serviceClient.getOptions().setSoapVersionURI(org.apache.axiom.soap.SOAP12Constants.SOAP_ENVELOPE_NAMESPACE_URI);


    }

    /**
     * Default Constructor
     */
    public DamAssetServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext) throws org.apache.axis2.AxisFault {

                    this(configurationContext,"http://localhost:8080/imcws/services/damAsetService" );

    }

    /**
     * Default Constructor
     */
    public DamAssetServiceStub() throws org.apache.axis2.AxisFault {

                    this("http://localhost:8080/imcws/services/damAsetService" );

    }

    /**
     * Constructor taking the target endpoint
     */
    public DamAssetServiceStub(java.lang.String targetEndpoint) throws org.apache.axis2.AxisFault {
        this(null,targetEndpoint);
    }




                    /**
                     * Auto generated method signature
                     *
                     * @see com.h3c.imc.acmws.acmuserservice.client.DamAssetService#queryAsset
                     * @param queryAsset10

                     */



                            public  com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.RetAssetInfoList queryAsset(

                            com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.AssetQueryInfo param011)


                    throws java.rmi.RemoteException

                    {
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
              _operationClient.getOptions().setAction("urn:queryAsset");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);



                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");


              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();



              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.QueryAsset dummyWrappedType = null;
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    param011,
                                                    dummyWrappedType,
                                                    optimizeContent(new javax.xml.namespace.QName("http://dam.imc.h3c.com/damAssetService",
                                                    "queryAsset")));

        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);


               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();


                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.QueryAssetResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));


                                        return getQueryAssetResponse_return((com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.QueryAssetResponse)object);

         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});


                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }

                /**
                * Auto generated method signature for Asynchronous Invocations
                *
                * @see com.h3c.imc.acmws.acmuserservice.client.DamAssetService#startqueryAsset
                    * @param queryAsset10

                */
                public  void startqueryAsset(

                 com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.AssetQueryInfo param011,

                  final com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
             _operationClient.getOptions().setAction("urn:queryAsset");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);



                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");



              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();


                                    //Style is Doc.
                                    com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.QueryAsset dummyWrappedType = null;
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    param011,
                                                     dummyWrappedType,
                                                    optimizeContent(new javax.xml.namespace.QName("http://dam.imc.h3c.com/damAssetService",
                                                    "queryAsset")));

        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);



                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.QueryAssetResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultqueryAsset(
                                            getQueryAssetResponse_return((com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.QueryAssetResponse)object));

                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorqueryAsset(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(faultElt.getQName())){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.Exception ex=
														(java.lang.Exception) exceptionClass.newInstance();
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});


										            callback.receiveErrorqueryAsset(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorqueryAsset(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorqueryAsset(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorqueryAsset(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorqueryAsset(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorqueryAsset(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorqueryAsset(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorqueryAsset(f);
                                            }
									    } else {
										    callback.receiveErrorqueryAsset(f);
									    }
									} else {
									    callback.receiveErrorqueryAsset(f);
									}
								} else {
								    callback.receiveErrorqueryAsset(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErrorqueryAsset(axisFault);
                                }
                            }
                });


          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[0].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[0].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }

                    /**
                     * Auto generated method signature
                     *
                     * @see com.h3c.imc.acmws.acmuserservice.client.DamAssetService#queryAssetGroup
                     */



                            public  com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.RetAssetGroupInfoList queryAssetGroup(

                            )


                    throws java.rmi.RemoteException

                    {
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[1].getName());
              _operationClient.getOptions().setAction("urn:queryAssetGroup");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);



                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");


              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();



              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;

                                    //Style is taken to be "document". No input parameters
                                    // according to the WS-Basic profile in this case we have to send an empty soap message
                                    org.apache.axiom.soap.SOAPFactory factory = getFactory(_operationClient.getOptions().getSoapVersionURI());
                                    env = factory.getDefaultEnvelope();

        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);


               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();


                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.QueryAssetGroupResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));


                                        return getQueryAssetGroupResponse_return((com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.QueryAssetGroupResponse)object);

         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});


                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }

                /**
                * Auto generated method signature for Asynchronous Invocations
                *
                * @see com.h3c.imc.acmws.acmuserservice.client.DamAssetService#startqueryAssetGroup
                */
                public  void startqueryAssetGroup(



                  final com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[1].getName());
             _operationClient.getOptions().setAction("urn:queryAssetGroup");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);



                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");



              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();


                                    //Style is taken to be "document". No input parameters
                                    // according to the WS-Basic profile in this case we have to send an empty soap message
                                    org.apache.axiom.soap.SOAPFactory factory = getFactory(_operationClient.getOptions().getSoapVersionURI());
                                    env = factory.getDefaultEnvelope();

        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);



                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.QueryAssetGroupResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultqueryAssetGroup(
                                            getQueryAssetGroupResponse_return((com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.QueryAssetGroupResponse)object));

                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorqueryAssetGroup(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(faultElt.getQName())){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.Exception ex=
														(java.lang.Exception) exceptionClass.newInstance();
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});


										            callback.receiveErrorqueryAssetGroup(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorqueryAssetGroup(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorqueryAssetGroup(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorqueryAssetGroup(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorqueryAssetGroup(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorqueryAssetGroup(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorqueryAssetGroup(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorqueryAssetGroup(f);
                                            }
									    } else {
										    callback.receiveErrorqueryAssetGroup(f);
									    }
									} else {
									    callback.receiveErrorqueryAssetGroup(f);
									}
								} else {
								    callback.receiveErrorqueryAssetGroup(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErrorqueryAssetGroup(axisFault);
                                }
                            }
                });


          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[1].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[1].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }

                    /**
                     * Auto generated method signature
                     *
                     * @see com.h3c.imc.acmws.acmuserservice.client.DamAssetService#deleteAsset
                     * @param deleteAsset17

                     */



                            public  com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.WSCommonResult deleteAsset(

                            long param018)


                    throws java.rmi.RemoteException

                    {
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[2].getName());
              _operationClient.getOptions().setAction("urn:deleteAsset");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);



                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");


              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();



              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.DeleteAsset dummyWrappedType = null;
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    param018,
                                                    dummyWrappedType,
                                                    optimizeContent(new javax.xml.namespace.QName("http://dam.imc.h3c.com/damAssetService",
                                                    "deleteAsset")));

        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);


               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();


                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.DeleteAssetResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));


                                        return getDeleteAssetResponse_return((com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.DeleteAssetResponse)object);

         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});


                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }

                /**
                * Auto generated method signature for Asynchronous Invocations
                *
                * @see com.h3c.imc.acmws.acmuserservice.client.DamAssetService#startdeleteAsset
                    * @param deleteAsset17

                */
                public  void startdeleteAsset(

                 long param018,

                  final com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[2].getName());
             _operationClient.getOptions().setAction("urn:deleteAsset");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);



                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");



              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();


                                    //Style is Doc.
                                    com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.DeleteAsset dummyWrappedType = null;
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    param018,
                                                     dummyWrappedType,
                                                    optimizeContent(new javax.xml.namespace.QName("http://dam.imc.h3c.com/damAssetService",
                                                    "deleteAsset")));

        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);



                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.DeleteAssetResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultdeleteAsset(
                                            getDeleteAssetResponse_return((com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.DeleteAssetResponse)object));

                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrordeleteAsset(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(faultElt.getQName())){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.Exception ex=
														(java.lang.Exception) exceptionClass.newInstance();
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});


										            callback.receiveErrordeleteAsset(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrordeleteAsset(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrordeleteAsset(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrordeleteAsset(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrordeleteAsset(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrordeleteAsset(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrordeleteAsset(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrordeleteAsset(f);
                                            }
									    } else {
										    callback.receiveErrordeleteAsset(f);
									    }
									} else {
									    callback.receiveErrordeleteAsset(f);
									}
								} else {
								    callback.receiveErrordeleteAsset(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErrordeleteAsset(axisFault);
                                }
                            }
                });


          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[2].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[2].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }

                    /**
                     * Auto generated method signature
                     *
                     * @see com.h3c.imc.acmws.acmuserservice.client.DamAssetService#modifyAsset
                     * @param modifyAsset21

                     */



                            public  com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.WSCommonResult modifyAsset(

                            com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.ModifyAssetInfo param022)


                    throws java.rmi.RemoteException

                    {
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[3].getName());
              _operationClient.getOptions().setAction("urn:modifyAsset");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);



                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");


              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();



              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.ModifyAsset dummyWrappedType = null;
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    param022,
                                                    dummyWrappedType,
                                                    optimizeContent(new javax.xml.namespace.QName("http://dam.imc.h3c.com/damAssetService",
                                                    "modifyAsset")));

        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);


               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();


                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.ModifyAssetResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));


                                        return getModifyAssetResponse_return((com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.ModifyAssetResponse)object);

         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});


                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }

                /**
                * Auto generated method signature for Asynchronous Invocations
                *
                * @see com.h3c.imc.acmws.acmuserservice.client.DamAssetService#startmodifyAsset
                    * @param modifyAsset21

                */
                public  void startmodifyAsset(

                 com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.ModifyAssetInfo param022,

                  final com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[3].getName());
             _operationClient.getOptions().setAction("urn:modifyAsset");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);



                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");



              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();


                                    //Style is Doc.
                                    com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.ModifyAsset dummyWrappedType = null;
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    param022,
                                                     dummyWrappedType,
                                                    optimizeContent(new javax.xml.namespace.QName("http://dam.imc.h3c.com/damAssetService",
                                                    "modifyAsset")));

        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);



                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.ModifyAssetResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultmodifyAsset(
                                            getModifyAssetResponse_return((com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.ModifyAssetResponse)object));

                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrormodifyAsset(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(faultElt.getQName())){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.Exception ex=
														(java.lang.Exception) exceptionClass.newInstance();
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});


										            callback.receiveErrormodifyAsset(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrormodifyAsset(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrormodifyAsset(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrormodifyAsset(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrormodifyAsset(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrormodifyAsset(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrormodifyAsset(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrormodifyAsset(f);
                                            }
									    } else {
										    callback.receiveErrormodifyAsset(f);
									    }
									} else {
									    callback.receiveErrormodifyAsset(f);
									}
								} else {
								    callback.receiveErrormodifyAsset(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErrormodifyAsset(axisFault);
                                }
                            }
                });


          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[3].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[3].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }

                    /**
                     * Auto generated method signature
                     *
                     * @see com.h3c.imc.acmws.acmuserservice.client.DamAssetService#queryAssetDetail
                     * @param queryAssetDetail25

                     */



                            public  com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.RetAssetDetailInfo queryAssetDetail(

                            long param026)


                    throws java.rmi.RemoteException

                    {
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[4].getName());
              _operationClient.getOptions().setAction("urn:queryAssetDetail");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);



                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");


              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();



              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.QueryAssetDetail dummyWrappedType = null;
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    param026,
                                                    dummyWrappedType,
                                                    optimizeContent(new javax.xml.namespace.QName("http://dam.imc.h3c.com/damAssetService",
                                                    "queryAssetDetail")));

        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);


               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();


                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.QueryAssetDetailResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));


                                        return getQueryAssetDetailResponse_return((com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.QueryAssetDetailResponse)object);

         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});


                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }

                /**
                * Auto generated method signature for Asynchronous Invocations
                *
                * @see com.h3c.imc.acmws.acmuserservice.client.DamAssetService#startqueryAssetDetail
                    * @param queryAssetDetail25

                */
                public  void startqueryAssetDetail(

                 long param026,

                  final com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[4].getName());
             _operationClient.getOptions().setAction("urn:queryAssetDetail");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);



                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");



              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();


                                    //Style is Doc.
                                    com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.QueryAssetDetail dummyWrappedType = null;
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    param026,
                                                     dummyWrappedType,
                                                    optimizeContent(new javax.xml.namespace.QName("http://dam.imc.h3c.com/damAssetService",
                                                    "queryAssetDetail")));

        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);



                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.QueryAssetDetailResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultqueryAssetDetail(
                                            getQueryAssetDetailResponse_return((com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.QueryAssetDetailResponse)object));

                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorqueryAssetDetail(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(faultElt.getQName())){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.Exception ex=
														(java.lang.Exception) exceptionClass.newInstance();
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});


										            callback.receiveErrorqueryAssetDetail(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorqueryAssetDetail(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorqueryAssetDetail(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorqueryAssetDetail(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorqueryAssetDetail(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorqueryAssetDetail(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorqueryAssetDetail(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorqueryAssetDetail(f);
                                            }
									    } else {
										    callback.receiveErrorqueryAssetDetail(f);
									    }
									} else {
									    callback.receiveErrorqueryAssetDetail(f);
									}
								} else {
								    callback.receiveErrorqueryAssetDetail(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErrorqueryAssetDetail(axisFault);
                                }
                            }
                });


          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[4].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[4].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }

                    /**
                     * Auto generated method signature
                     *
                     * @see com.h3c.imc.acmws.acmuserservice.client.DamAssetService#addAsset
                     * @param addAsset29

                     */



                            public  com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.WSCommonResult addAsset(

                            com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.AddAssetInfo param030)


                    throws java.rmi.RemoteException

                    {
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[5].getName());
              _operationClient.getOptions().setAction("urn:addAsset");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);



                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");


              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();



              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.AddAsset dummyWrappedType = null;
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    param030,
                                                    dummyWrappedType,
                                                    optimizeContent(new javax.xml.namespace.QName("http://dam.imc.h3c.com/damAssetService",
                                                    "addAsset")));

        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);


               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();


                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.AddAssetResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));


                                        return getAddAssetResponse_return((com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.AddAssetResponse)object);

         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});


                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }

                /**
                * Auto generated method signature for Asynchronous Invocations
                *
                * @see com.h3c.imc.acmws.acmuserservice.client.DamAssetService#startaddAsset
                    * @param addAsset29

                */
                public  void startaddAsset(

                 com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.AddAssetInfo param030,

                  final com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[5].getName());
             _operationClient.getOptions().setAction("urn:addAsset");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);



                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");



              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();


                                    //Style is Doc.
                                    com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.AddAsset dummyWrappedType = null;
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    param030,
                                                     dummyWrappedType,
                                                    optimizeContent(new javax.xml.namespace.QName("http://dam.imc.h3c.com/damAssetService",
                                                    "addAsset")));

        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);



                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();

                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.AddAssetResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultaddAsset(
                                            getAddAssetResponse_return((com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.AddAssetResponse)object));

                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErroraddAsset(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(faultElt.getQName())){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.Exception ex=
														(java.lang.Exception) exceptionClass.newInstance();
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});


										            callback.receiveErroraddAsset(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErroraddAsset(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErroraddAsset(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErroraddAsset(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErroraddAsset(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErroraddAsset(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErroraddAsset(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErroraddAsset(f);
                                            }
									    } else {
										    callback.receiveErroraddAsset(f);
									    }
									} else {
									    callback.receiveErroraddAsset(f);
									}
								} else {
								    callback.receiveErroraddAsset(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErroraddAsset(axisFault);
                                }
                            }
                });


          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[5].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[5].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }



       /**
        *  A utility method that copies the namepaces from the SOAPEnvelope
        */
       public java.util.Map getEnvelopeNamespaces(org.apache.axiom.soap.SOAPEnvelope env){
        java.util.Map returnMap = new java.util.HashMap();
        java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
        while (namespaceIterator.hasNext()) {
            org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
            returnMap.put(ns.getPrefix(),ns.getNamespaceURI());
        }
       return returnMap;
    }



    public javax.xml.namespace.QName[] opNameArray = null;
    public boolean optimizeContent(javax.xml.namespace.QName opName) {


        if (opNameArray == null) {
            return false;
        }
        for (int i = 0; i < opNameArray.length; i++) {
            if (opName.equals(opNameArray[i])) {
                return true;
            }
        }
        return false;
    }
     //http://localhost:8080/imcws/services/damAsetService
        public static class RetAssetInfo
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = RetAssetInfo
                Namespace URI = http://asset.damws.imc.h3c.com/xsd
                Namespace Prefix = ns2
                */


        public static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://asset.damws.imc.h3c.com/xsd")){
                return "ns2";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }



                        /**
                        * field for AssetId
                        */


                                    protected long localAssetId ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAssetIdTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return long
                           */
                           public  long getAssetId(){
                               return localAssetId;
                           }



                            /**
                               * Auto generated setter method
                               * @param param AssetId
                               */
                               public void setAssetId(long param){

                                       // setting primitive attribute tracker to true

                                               if (param==java.lang.Long.MIN_VALUE) {
                                           localAssetIdTracker = true;

                                       } else {
                                          localAssetIdTracker = true;
                                       }

                                            this.localAssetId=param;


                               }


                        /**
                        * field for AssetName
                        */


                                    protected java.lang.String localAssetName ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAssetNameTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getAssetName(){
                               return localAssetName;
                           }



                            /**
                               * Auto generated setter method
                               * @param param AssetName
                               */
                               public void setAssetName(java.lang.String param){

                                       if (param != null){
                                          //update the setting tracker
                                          localAssetNameTracker = true;
                                       } else {
                                          localAssetNameTracker = true;

                                       }

                                            this.localAssetName=param;


                               }


                        /**
                        * field for AssetNumber
                        */


                                    protected java.lang.String localAssetNumber ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAssetNumberTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getAssetNumber(){
                               return localAssetNumber;
                           }



                            /**
                               * Auto generated setter method
                               * @param param AssetNumber
                               */
                               public void setAssetNumber(java.lang.String param){

                                       if (param != null){
                                          //update the setting tracker
                                          localAssetNumberTracker = true;
                                       } else {
                                          localAssetNumberTracker = true;

                                       }

                                            this.localAssetNumber=param;


                               }


                        /**
                        * field for GroupId
                        */


                                    protected long localGroupId ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localGroupIdTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return long
                           */
                           public  long getGroupId(){
                               return localGroupId;
                           }



                            /**
                               * Auto generated setter method
                               * @param param GroupId
                               */
                               public void setGroupId(long param){

                                       // setting primitive attribute tracker to true

                                               if (param==java.lang.Long.MIN_VALUE) {
                                           localGroupIdTracker = true;

                                       } else {
                                          localGroupIdTracker = true;
                                       }

                                            this.localGroupId=param;


                               }


                        /**
                        * field for JoinDate
                        */


                                    protected java.util.Calendar localJoinDate ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localJoinDateTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getJoinDate(){
                               return localJoinDate;
                           }



                            /**
                               * Auto generated setter method
                               * @param param JoinDate
                               */
                               public void setJoinDate(java.util.Calendar param){

                                       if (param != null){
                                          //update the setting tracker
                                          localJoinDateTracker = true;
                                       } else {
                                          localJoinDateTracker = true;

                                       }

                                            this.localJoinDate=param;


                               }


                        /**
                        * field for Responser
                        */


                                    protected java.lang.String localResponser ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localResponserTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getResponser(){
                               return localResponser;
                           }



                            /**
                               * Auto generated setter method
                               * @param param Responser
                               */
                               public void setResponser(java.lang.String param){

                                       if (param != null){
                                          //update the setting tracker
                                          localResponserTracker = true;
                                       } else {
                                          localResponserTracker = true;

                                       }

                                            this.localResponser=param;


                               }


                        /**
                        * field for Status
                        */


                                    protected int localStatus ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localStatusTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getStatus(){
                               return localStatus;
                           }



                            /**
                               * Auto generated setter method
                               * @param param Status
                               */
                               public void setStatus(int param){

                                       // setting primitive attribute tracker to true

                                               if (param==java.lang.Integer.MIN_VALUE) {
                                           localStatusTracker = true;

                                       } else {
                                          localStatusTracker = true;
                                       }

                                            this.localStatus=param;


                               }


                        /**
                        * field for Type
                        */


                                    protected java.lang.String localType ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localTypeTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getType(){
                               return localType;
                           }



                            /**
                               * Auto generated setter method
                               * @param param Type
                               */
                               public void setType(java.lang.String param){

                                       if (param != null){
                                          //update the setting tracker
                                          localTypeTracker = true;
                                       } else {
                                          localTypeTracker = true;

                                       }

                                            this.localType=param;


                               }


     /**
     * isReaderMTOMAware
     * @return true if the reader supports MTOM
     */
   public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
        boolean isReaderMTOMAware = false;

        try{
          isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
        }catch(java.lang.IllegalArgumentException e){
          isReaderMTOMAware = false;
        }
        return isReaderMTOMAware;
   }


        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{



               org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,parentQName){

                 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                       RetAssetInfo.this.serialize(parentQName,factory,xmlWriter);
                 }
               };
               return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
               parentQName,factory,dataSource);

       }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       final org.apache.axiom.om.OMFactory factory,
                                       org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,factory,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               final org.apache.axiom.om.OMFactory factory,
                               org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{




                java.lang.String prefix = null;
                java.lang.String namespace = null;


                    prefix = parentQName.getPrefix();
                    namespace = parentQName.getNamespaceURI();

                    if ((namespace != null) && (namespace.trim().length() > 0)) {
                        java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                        if (writerPrefix != null) {
                            xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                        } else {
                            if (prefix == null) {
                                prefix = generatePrefix(namespace);
                            }

                            xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                            xmlWriter.writeNamespace(prefix, namespace);
                            xmlWriter.setPrefix(prefix, namespace);
                        }
                    } else {
                        xmlWriter.writeStartElement(parentQName.getLocalPart());
                    }

                  if (serializeType){


                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://asset.damws.imc.h3c.com/xsd");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":RetAssetInfo",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "RetAssetInfo",
                           xmlWriter);
                   }


                   }
                if (localAssetIdTracker){
                                    namespace = "http://asset.damws.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"assetId", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"assetId");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("assetId");
                                    }

                                               if (localAssetId==java.lang.Long.MIN_VALUE) {

                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAssetId));
                                               }

                                   xmlWriter.writeEndElement();
                             } if (localAssetNameTracker){
                                    namespace = "http://asset.damws.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"assetName", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"assetName");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("assetName");
                                    }


                                          if (localAssetName==null){
                                              // write the nil attribute

                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                          }else{


                                                   xmlWriter.writeCharacters(localAssetName);

                                          }

                                   xmlWriter.writeEndElement();
                             } if (localAssetNumberTracker){
                                    namespace = "http://asset.damws.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"assetNumber", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"assetNumber");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("assetNumber");
                                    }


                                          if (localAssetNumber==null){
                                              // write the nil attribute

                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                          }else{


                                                   xmlWriter.writeCharacters(localAssetNumber);

                                          }

                                   xmlWriter.writeEndElement();
                             } if (localGroupIdTracker){
                                    namespace = "http://asset.damws.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"groupId", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"groupId");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("groupId");
                                    }

                                               if (localGroupId==java.lang.Long.MIN_VALUE) {

                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localGroupId));
                                               }

                                   xmlWriter.writeEndElement();
                             } if (localJoinDateTracker){
                                    namespace = "http://asset.damws.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"joinDate", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"joinDate");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("joinDate");
                                    }


                                          if (localJoinDate==null){
                                              // write the nil attribute

                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                          }else{


                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localJoinDate));

                                          }

                                   xmlWriter.writeEndElement();
                             } if (localResponserTracker){
                                    namespace = "http://asset.damws.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"responser", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"responser");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("responser");
                                    }


                                          if (localResponser==null){
                                              // write the nil attribute

                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                          }else{


                                                   xmlWriter.writeCharacters(localResponser);

                                          }

                                   xmlWriter.writeEndElement();
                             } if (localStatusTracker){
                                    namespace = "http://asset.damws.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"status", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"status");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("status");
                                    }

                                               if (localStatus==java.lang.Integer.MIN_VALUE) {

                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localStatus));
                                               }

                                   xmlWriter.writeEndElement();
                             } if (localTypeTracker){
                                    namespace = "http://asset.damws.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"type", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"type");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("type");
                                    }


                                          if (localType==null){
                                              // write the nil attribute

                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                          }else{


                                                   xmlWriter.writeCharacters(localType);

                                          }

                                   xmlWriter.writeEndElement();
                             }
                    xmlWriter.writeEndElement();


        }

         /**
          * Util method to write an attribute with the ns prefix
          */
          public void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
              if (xmlWriter.getPrefix(namespace) == null) {
                       xmlWriter.writeNamespace(prefix, namespace);
                       xmlWriter.setPrefix(prefix, namespace);

              }

              xmlWriter.writeAttribute(namespace,attName,attValue);

         }

        /**
          * Util method to write an attribute without the ns prefix
          */
          public void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
                if (namespace.equals(""))
              {
                  xmlWriter.writeAttribute(attName,attValue);
              }
              else
              {
                  registerPrefix(xmlWriter, namespace);
                  xmlWriter.writeAttribute(namespace,attName,attValue);
              }
          }


           /**
             * Util method to write an attribute without the ns prefix
             */
            public void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        public void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        public void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


         /**
         * Register a namespace prefix
         */
         public java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                        prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                    }

                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }

                return prefix;
            }



        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{



                 java.util.ArrayList elementList = new java.util.ArrayList();
                 java.util.ArrayList attribList = new java.util.ArrayList();

                 if (localAssetIdTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                      "assetId"));

                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAssetId));
                            } if (localAssetNameTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                      "assetName"));

                                         elementList.add(localAssetName==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAssetName));
                                    } if (localAssetNumberTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                      "assetNumber"));

                                         elementList.add(localAssetNumber==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAssetNumber));
                                    } if (localGroupIdTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                      "groupId"));

                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localGroupId));
                            } if (localJoinDateTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                      "joinDate"));

                                         elementList.add(localJoinDate==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localJoinDate));
                                    } if (localResponserTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                      "responser"));

                                         elementList.add(localResponser==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localResponser));
                                    } if (localStatusTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                      "status"));

                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localStatus));
                            } if (localTypeTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                      "type"));

                                         elementList.add(localType==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localType));
                                    }

                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());



        }



     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{




        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static RetAssetInfo parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            RetAssetInfo object =
                new RetAssetInfo();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();


                if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
                  java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                        "type");
                  if (fullTypeName!=null){
                    java.lang.String nsPrefix = null;
                    if (fullTypeName.indexOf(":") > -1){
                        nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
                    }
                    nsPrefix = nsPrefix==null?"":nsPrefix;

                    java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);

                            if (!"RetAssetInfo".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (RetAssetInfo)ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }


                  }


                }




                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();




                    reader.next();


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","assetId").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setAssetId(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToLong(content));

                                       } else {


                                                   object.setAssetId(java.lang.Long.MIN_VALUE);

                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                               object.setAssetId(java.lang.Long.MIN_VALUE);

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","assetName").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setAssetName(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                                       } else {


                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","assetNumber").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setAssetNumber(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                                       } else {


                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","groupId").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setGroupId(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToLong(content));

                                       } else {


                                                   object.setGroupId(java.lang.Long.MIN_VALUE);

                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                               object.setGroupId(java.lang.Long.MIN_VALUE);

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","joinDate").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setJoinDate(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));

                                       } else {


                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","responser").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setResponser(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                                       } else {


                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","status").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setStatus(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));

                                       } else {


                                                   object.setStatus(java.lang.Integer.MIN_VALUE);

                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                               object.setStatus(java.lang.Integer.MIN_VALUE);

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","type").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setType(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                                       } else {


                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                    }

                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();

                                if (reader.isStartElement())
                                // A start element we are not expecting indicates a trailing invalid property
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());




            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class



        }


        public static class QueryAssetGroupResponse
        implements org.apache.axis2.databinding.ADBBean{

                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://dam.imc.h3c.com/damAssetService",
                "queryAssetGroupResponse",
                "ns3");



        public static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://dam.imc.h3c.com/damAssetService")){
                return "ns3";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }



                        /**
                        * field for _return
                        */


                                    protected RetAssetGroupInfoList local_return ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean local_returnTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return RetAssetGroupInfoList
                           */
                           public  RetAssetGroupInfoList get_return(){
                               return local_return;
                           }



                            /**
                               * Auto generated setter method
                               * @param param _return
                               */
                               public void set_return(RetAssetGroupInfoList param){

                                       if (param != null){
                                          //update the setting tracker
                                          local_returnTracker = true;
                                       } else {
                                          local_returnTracker = true;

                                       }

                                            this.local_return=param;


                               }


     /**
     * isReaderMTOMAware
     * @return true if the reader supports MTOM
     */
   public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
        boolean isReaderMTOMAware = false;

        try{
          isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
        }catch(java.lang.IllegalArgumentException e){
          isReaderMTOMAware = false;
        }
        return isReaderMTOMAware;
   }


        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{



                org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,MY_QNAME){

                 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                       QueryAssetGroupResponse.this.serialize(MY_QNAME,factory,xmlWriter);
                 }
               };
               return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
               MY_QNAME,factory,dataSource);

       }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       final org.apache.axiom.om.OMFactory factory,
                                       org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,factory,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               final org.apache.axiom.om.OMFactory factory,
                               org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{




                java.lang.String prefix = null;
                java.lang.String namespace = null;


                    prefix = parentQName.getPrefix();
                    namespace = parentQName.getNamespaceURI();

                    if ((namespace != null) && (namespace.trim().length() > 0)) {
                        java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                        if (writerPrefix != null) {
                            xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                        } else {
                            if (prefix == null) {
                                prefix = generatePrefix(namespace);
                            }

                            xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                            xmlWriter.writeNamespace(prefix, namespace);
                            xmlWriter.setPrefix(prefix, namespace);
                        }
                    } else {
                        xmlWriter.writeStartElement(parentQName.getLocalPart());
                    }

                  if (serializeType){


                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://dam.imc.h3c.com/damAssetService");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":queryAssetGroupResponse",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "queryAssetGroupResponse",
                           xmlWriter);
                   }


                   }
                if (local_returnTracker){
                                    if (local_return==null){

                                            java.lang.String namespace2 = "http://dam.imc.h3c.com/damAssetService";

                                        if (! namespace2.equals("")) {
                                            java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                                            if (prefix2 == null) {
                                                prefix2 = generatePrefix(namespace2);

                                                xmlWriter.writeStartElement(prefix2,"return", namespace2);
                                                xmlWriter.writeNamespace(prefix2, namespace2);
                                                xmlWriter.setPrefix(prefix2, namespace2);

                                            } else {
                                                xmlWriter.writeStartElement(namespace2,"return");
                                            }

                                        } else {
                                            xmlWriter.writeStartElement("return");
                                        }


                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     local_return.serialize(new javax.xml.namespace.QName("http://dam.imc.h3c.com/damAssetService","return"),
                                        factory,xmlWriter);
                                    }
                                }
                    xmlWriter.writeEndElement();


        }

         /**
          * Util method to write an attribute with the ns prefix
          */
          public void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
              if (xmlWriter.getPrefix(namespace) == null) {
                       xmlWriter.writeNamespace(prefix, namespace);
                       xmlWriter.setPrefix(prefix, namespace);

              }

              xmlWriter.writeAttribute(namespace,attName,attValue);

         }

        /**
          * Util method to write an attribute without the ns prefix
          */
          public void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
                if (namespace.equals(""))
              {
                  xmlWriter.writeAttribute(attName,attValue);
              }
              else
              {
                  registerPrefix(xmlWriter, namespace);
                  xmlWriter.writeAttribute(namespace,attName,attValue);
              }
          }


           /**
             * Util method to write an attribute without the ns prefix
             */
            public void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        public void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        public void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


         /**
         * Register a namespace prefix
         */
         public java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                        prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                    }

                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }

                return prefix;
            }



        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{



                 java.util.ArrayList elementList = new java.util.ArrayList();
                 java.util.ArrayList attribList = new java.util.ArrayList();

                 if (local_returnTracker){
                            elementList.add(new javax.xml.namespace.QName("http://dam.imc.h3c.com/damAssetService",
                                                                      "return"));


                                    elementList.add(local_return==null?null:
                                    local_return);
                                }

                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());



        }



     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{




        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static QueryAssetGroupResponse parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            QueryAssetGroupResponse object =
                new QueryAssetGroupResponse();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();


                if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
                  java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                        "type");
                  if (fullTypeName!=null){
                    java.lang.String nsPrefix = null;
                    if (fullTypeName.indexOf(":") > -1){
                        nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
                    }
                    nsPrefix = nsPrefix==null?"":nsPrefix;

                    java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);

                            if (!"queryAssetGroupResponse".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (QueryAssetGroupResponse)ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }


                  }


                }




                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();




                    reader.next();


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://dam.imc.h3c.com/damAssetService","return").equals(reader.getName())){

                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.set_return(null);
                                          reader.next();

                                            reader.next();

                                      }else{

                                                object.set_return(RetAssetGroupInfoList.Factory.parse(reader));

                                        reader.next();
                                    }
                              }  // End of if for expected property start element

                                    else {

                                    }

                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();

                                if (reader.isStartElement())
                                // A start element we are not expecting indicates a trailing invalid property
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());




            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class



        }


        public static class ModifyAssetInfo
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = ModifyAssetInfo
                Namespace URI = http://asset.damws.imc.h3c.com/xsd
                Namespace Prefix = ns2
                */


        public static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://asset.damws.imc.h3c.com/xsd")){
                return "ns2";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }



                        /**
                        * field for AssetId
                        */


                                    protected long localAssetId ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAssetIdTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return long
                           */
                           public  long getAssetId(){
                               return localAssetId;
                           }



                            /**
                               * Auto generated setter method
                               * @param param AssetId
                               */
                               public void setAssetId(long param){

                                       // setting primitive attribute tracker to true

                                               if (param==java.lang.Long.MIN_VALUE) {
                                           localAssetIdTracker = true;

                                       } else {
                                          localAssetIdTracker = true;
                                       }

                                            this.localAssetId=param;


                               }


                        /**
                        * field for AssetName
                        */


                                    protected java.lang.String localAssetName ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAssetNameTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getAssetName(){
                               return localAssetName;
                           }



                            /**
                               * Auto generated setter method
                               * @param param AssetName
                               */
                               public void setAssetName(java.lang.String param){

                                       if (param != null){
                                          //update the setting tracker
                                          localAssetNameTracker = true;
                                       } else {
                                          localAssetNameTracker = true;

                                       }

                                            this.localAssetName=param;


                               }


                        /**
                        * field for AssetNumber
                        */


                                    protected java.lang.String localAssetNumber ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAssetNumberTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getAssetNumber(){
                               return localAssetNumber;
                           }



                            /**
                               * Auto generated setter method
                               * @param param AssetNumber
                               */
                               public void setAssetNumber(java.lang.String param){

                                       if (param != null){
                                          //update the setting tracker
                                          localAssetNumberTracker = true;
                                       } else {
                                          localAssetNumberTracker = true;

                                       }

                                            this.localAssetNumber=param;


                               }


                        /**
                        * field for ComputerType
                        */


                                    protected java.lang.String localComputerType ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localComputerTypeTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getComputerType(){
                               return localComputerType;
                           }



                            /**
                               * Auto generated setter method
                               * @param param ComputerType
                               */
                               public void setComputerType(java.lang.String param){

                                       if (param != null){
                                          //update the setting tracker
                                          localComputerTypeTracker = true;
                                       } else {
                                          localComputerTypeTracker = true;

                                       }

                                            this.localComputerType=param;


                               }


                        /**
                        * field for ComputerVariety
                        */


                                    protected java.lang.String localComputerVariety ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localComputerVarietyTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getComputerVariety(){
                               return localComputerVariety;
                           }



                            /**
                               * Auto generated setter method
                               * @param param ComputerVariety
                               */
                               public void setComputerVariety(java.lang.String param){

                                       if (param != null){
                                          //update the setting tracker
                                          localComputerVarietyTracker = true;
                                       } else {
                                          localComputerVarietyTracker = true;

                                       }

                                            this.localComputerVariety=param;


                               }


                        /**
                        * field for PhysicalPos
                        */


                                    protected java.lang.String localPhysicalPos ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPhysicalPosTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getPhysicalPos(){
                               return localPhysicalPos;
                           }



                            /**
                               * Auto generated setter method
                               * @param param PhysicalPos
                               */
                               public void setPhysicalPos(java.lang.String param){

                                       if (param != null){
                                          //update the setting tracker
                                          localPhysicalPosTracker = true;
                                       } else {
                                          localPhysicalPosTracker = true;

                                       }

                                            this.localPhysicalPos=param;


                               }


                        /**
                        * field for Remark
                        */


                                    protected java.lang.String localRemark ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localRemarkTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getRemark(){
                               return localRemark;
                           }



                            /**
                               * Auto generated setter method
                               * @param param Remark
                               */
                               public void setRemark(java.lang.String param){

                                       if (param != null){
                                          //update the setting tracker
                                          localRemarkTracker = true;
                                       } else {
                                          localRemarkTracker = true;

                                       }

                                            this.localRemark=param;


                               }


                        /**
                        * field for ResponserId
                        */


                                    protected long localResponserId ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localResponserIdTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return long
                           */
                           public  long getResponserId(){
                               return localResponserId;
                           }



                            /**
                               * Auto generated setter method
                               * @param param ResponserId
                               */
                               public void setResponserId(long param){

                                       // setting primitive attribute tracker to true

                                               if (param==java.lang.Long.MIN_VALUE) {
                                           localResponserIdTracker = true;

                                       } else {
                                          localResponserIdTracker = true;
                                       }

                                            this.localResponserId=param;


                               }


                        /**
                        * field for SerialVersionUID
                        */


                                    protected long localSerialVersionUID ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localSerialVersionUIDTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return long
                           */
                           public  long getSerialVersionUID(){
                               return localSerialVersionUID;
                           }



                            /**
                               * Auto generated setter method
                               * @param param SerialVersionUID
                               */
                               public void setSerialVersionUID(long param){

                                       // setting primitive attribute tracker to true

                                               if (param==java.lang.Long.MIN_VALUE) {
                                           localSerialVersionUIDTracker = false;

                                       } else {
                                          localSerialVersionUIDTracker = true;
                                       }

                                            this.localSerialVersionUID=param;


                               }


                        /**
                        * field for Type
                        */


                                    protected java.lang.String localType ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localTypeTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getType(){
                               return localType;
                           }



                            /**
                               * Auto generated setter method
                               * @param param Type
                               */
                               public void setType(java.lang.String param){

                                       if (param != null){
                                          //update the setting tracker
                                          localTypeTracker = true;
                                       } else {
                                          localTypeTracker = true;

                                       }

                                            this.localType=param;


                               }


     /**
     * isReaderMTOMAware
     * @return true if the reader supports MTOM
     */
   public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
        boolean isReaderMTOMAware = false;

        try{
          isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
        }catch(java.lang.IllegalArgumentException e){
          isReaderMTOMAware = false;
        }
        return isReaderMTOMAware;
   }


        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{



               org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,parentQName){

                 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                       ModifyAssetInfo.this.serialize(parentQName,factory,xmlWriter);
                 }
               };
               return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
               parentQName,factory,dataSource);

       }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       final org.apache.axiom.om.OMFactory factory,
                                       org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,factory,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               final org.apache.axiom.om.OMFactory factory,
                               org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{




                java.lang.String prefix = null;
                java.lang.String namespace = null;


                    prefix = parentQName.getPrefix();
                    namespace = parentQName.getNamespaceURI();

                    if ((namespace != null) && (namespace.trim().length() > 0)) {
                        java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                        if (writerPrefix != null) {
                            xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                        } else {
                            if (prefix == null) {
                                prefix = generatePrefix(namespace);
                            }

                            xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                            xmlWriter.writeNamespace(prefix, namespace);
                            xmlWriter.setPrefix(prefix, namespace);
                        }
                    } else {
                        xmlWriter.writeStartElement(parentQName.getLocalPart());
                    }

                  if (serializeType){


                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://asset.damws.imc.h3c.com/xsd");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":ModifyAssetInfo",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "ModifyAssetInfo",
                           xmlWriter);
                   }


                   }
                if (localAssetIdTracker){
                                    namespace = "http://asset.damws.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"assetId", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"assetId");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("assetId");
                                    }

                                               if (localAssetId==java.lang.Long.MIN_VALUE) {

                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAssetId));
                                               }

                                   xmlWriter.writeEndElement();
                             } if (localAssetNameTracker){
                                    namespace = "http://asset.damws.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"assetName", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"assetName");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("assetName");
                                    }


                                          if (localAssetName==null){
                                              // write the nil attribute

                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                          }else{


                                                   xmlWriter.writeCharacters(localAssetName);

                                          }

                                   xmlWriter.writeEndElement();
                             } if (localAssetNumberTracker){
                                    namespace = "http://asset.damws.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"assetNumber", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"assetNumber");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("assetNumber");
                                    }


                                          if (localAssetNumber==null){
                                              // write the nil attribute

                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                          }else{


                                                   xmlWriter.writeCharacters(localAssetNumber);

                                          }

                                   xmlWriter.writeEndElement();
                             } if (localComputerTypeTracker){
                                    namespace = "http://asset.damws.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"computerType", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"computerType");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("computerType");
                                    }


                                          if (localComputerType==null){
                                              // write the nil attribute

                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                          }else{


                                                   xmlWriter.writeCharacters(localComputerType);

                                          }

                                   xmlWriter.writeEndElement();
                             } if (localComputerVarietyTracker){
                                    namespace = "http://asset.damws.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"computerVariety", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"computerVariety");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("computerVariety");
                                    }


                                          if (localComputerVariety==null){
                                              // write the nil attribute

                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                          }else{


                                                   xmlWriter.writeCharacters(localComputerVariety);

                                          }

                                   xmlWriter.writeEndElement();
                             } if (localPhysicalPosTracker){
                                    namespace = "http://asset.damws.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"physicalPos", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"physicalPos");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("physicalPos");
                                    }


                                          if (localPhysicalPos==null){
                                              // write the nil attribute

                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                          }else{


                                                   xmlWriter.writeCharacters(localPhysicalPos);

                                          }

                                   xmlWriter.writeEndElement();
                             } if (localRemarkTracker){
                                    namespace = "http://asset.damws.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"remark", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"remark");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("remark");
                                    }


                                          if (localRemark==null){
                                              // write the nil attribute

                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                          }else{


                                                   xmlWriter.writeCharacters(localRemark);

                                          }

                                   xmlWriter.writeEndElement();
                             } if (localResponserIdTracker){
                                    namespace = "http://asset.damws.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"responserId", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"responserId");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("responserId");
                                    }

                                               if (localResponserId==java.lang.Long.MIN_VALUE) {

                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localResponserId));
                                               }

                                   xmlWriter.writeEndElement();
                             } if (localSerialVersionUIDTracker){
                                    namespace = "http://asset.damws.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"serialVersionUID", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"serialVersionUID");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("serialVersionUID");
                                    }

                                               if (localSerialVersionUID==java.lang.Long.MIN_VALUE) {

                                                         throw new org.apache.axis2.databinding.ADBException("serialVersionUID cannot be null!!");

                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSerialVersionUID));
                                               }

                                   xmlWriter.writeEndElement();
                             } if (localTypeTracker){
                                    namespace = "http://asset.damws.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"type", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"type");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("type");
                                    }


                                          if (localType==null){
                                              // write the nil attribute

                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                          }else{


                                                   xmlWriter.writeCharacters(localType);

                                          }

                                   xmlWriter.writeEndElement();
                             }
                    xmlWriter.writeEndElement();


        }

         /**
          * Util method to write an attribute with the ns prefix
          */
          public void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
              if (xmlWriter.getPrefix(namespace) == null) {
                       xmlWriter.writeNamespace(prefix, namespace);
                       xmlWriter.setPrefix(prefix, namespace);

              }

              xmlWriter.writeAttribute(namespace,attName,attValue);

         }

        /**
          * Util method to write an attribute without the ns prefix
          */
          public void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
                if (namespace.equals(""))
              {
                  xmlWriter.writeAttribute(attName,attValue);
              }
              else
              {
                  registerPrefix(xmlWriter, namespace);
                  xmlWriter.writeAttribute(namespace,attName,attValue);
              }
          }


           /**
             * Util method to write an attribute without the ns prefix
             */
            public void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        public void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        public void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


         /**
         * Register a namespace prefix
         */
         public java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                        prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                    }

                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }

                return prefix;
            }



        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{



                 java.util.ArrayList elementList = new java.util.ArrayList();
                 java.util.ArrayList attribList = new java.util.ArrayList();

                 if (localAssetIdTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                      "assetId"));

                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAssetId));
                            } if (localAssetNameTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                      "assetName"));

                                         elementList.add(localAssetName==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAssetName));
                                    } if (localAssetNumberTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                      "assetNumber"));

                                         elementList.add(localAssetNumber==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAssetNumber));
                                    } if (localComputerTypeTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                      "computerType"));

                                         elementList.add(localComputerType==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localComputerType));
                                    } if (localComputerVarietyTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                      "computerVariety"));

                                         elementList.add(localComputerVariety==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localComputerVariety));
                                    } if (localPhysicalPosTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                      "physicalPos"));

                                         elementList.add(localPhysicalPos==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPhysicalPos));
                                    } if (localRemarkTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                      "remark"));

                                         elementList.add(localRemark==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRemark));
                                    } if (localResponserIdTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                      "responserId"));

                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localResponserId));
                            } if (localSerialVersionUIDTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                      "serialVersionUID"));

                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSerialVersionUID));
                            } if (localTypeTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                      "type"));

                                         elementList.add(localType==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localType));
                                    }

                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());



        }



     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{




        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static ModifyAssetInfo parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            ModifyAssetInfo object =
                new ModifyAssetInfo();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();


                if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
                  java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                        "type");
                  if (fullTypeName!=null){
                    java.lang.String nsPrefix = null;
                    if (fullTypeName.indexOf(":") > -1){
                        nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
                    }
                    nsPrefix = nsPrefix==null?"":nsPrefix;

                    java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);

                            if (!"ModifyAssetInfo".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (ModifyAssetInfo)ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }


                  }


                }




                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();




                    reader.next();


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","assetId").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setAssetId(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToLong(content));

                                       } else {


                                                   object.setAssetId(java.lang.Long.MIN_VALUE);

                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                               object.setAssetId(java.lang.Long.MIN_VALUE);

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","assetName").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setAssetName(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                                       } else {


                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","assetNumber").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setAssetNumber(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                                       } else {


                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","computerType").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setComputerType(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                                       } else {


                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","computerVariety").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setComputerVariety(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                                       } else {


                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","physicalPos").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setPhysicalPos(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                                       } else {


                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","remark").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setRemark(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                                       } else {


                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","responserId").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setResponserId(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToLong(content));

                                       } else {


                                                   object.setResponserId(java.lang.Long.MIN_VALUE);

                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                               object.setResponserId(java.lang.Long.MIN_VALUE);

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","serialVersionUID").equals(reader.getName())){

                                    java.lang.String content = reader.getElementText();

                                              object.setSerialVersionUID(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToLong(content));

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                               object.setSerialVersionUID(java.lang.Long.MIN_VALUE);

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","type").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setType(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                                       } else {


                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                    }

                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();

                                if (reader.isStartElement())
                                // A start element we are not expecting indicates a trailing invalid property
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());




            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class



        }


        public static class AddAssetResponse
        implements org.apache.axis2.databinding.ADBBean{

                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://dam.imc.h3c.com/damAssetService",
                "addAssetResponse",
                "ns3");



        public static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://dam.imc.h3c.com/damAssetService")){
                return "ns3";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }



                        /**
                        * field for _return
                        */


                                    protected WSCommonResult local_return ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean local_returnTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return WSCommonResult
                           */
                           public  WSCommonResult get_return(){
                               return local_return;
                           }



                            /**
                               * Auto generated setter method
                               * @param param _return
                               */
                               public void set_return(WSCommonResult param){

                                       if (param != null){
                                          //update the setting tracker
                                          local_returnTracker = true;
                                       } else {
                                          local_returnTracker = true;

                                       }

                                            this.local_return=param;


                               }


     /**
     * isReaderMTOMAware
     * @return true if the reader supports MTOM
     */
   public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
        boolean isReaderMTOMAware = false;

        try{
          isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
        }catch(java.lang.IllegalArgumentException e){
          isReaderMTOMAware = false;
        }
        return isReaderMTOMAware;
   }


        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{



                org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,MY_QNAME){

                 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                       AddAssetResponse.this.serialize(MY_QNAME,factory,xmlWriter);
                 }
               };
               return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
               MY_QNAME,factory,dataSource);

       }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       final org.apache.axiom.om.OMFactory factory,
                                       org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,factory,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               final org.apache.axiom.om.OMFactory factory,
                               org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{




                java.lang.String prefix = null;
                java.lang.String namespace = null;


                    prefix = parentQName.getPrefix();
                    namespace = parentQName.getNamespaceURI();

                    if ((namespace != null) && (namespace.trim().length() > 0)) {
                        java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                        if (writerPrefix != null) {
                            xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                        } else {
                            if (prefix == null) {
                                prefix = generatePrefix(namespace);
                            }

                            xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                            xmlWriter.writeNamespace(prefix, namespace);
                            xmlWriter.setPrefix(prefix, namespace);
                        }
                    } else {
                        xmlWriter.writeStartElement(parentQName.getLocalPart());
                    }

                  if (serializeType){


                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://dam.imc.h3c.com/damAssetService");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":addAssetResponse",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "addAssetResponse",
                           xmlWriter);
                   }


                   }
                if (local_returnTracker){
                                    if (local_return==null){

                                            java.lang.String namespace2 = "http://dam.imc.h3c.com/damAssetService";

                                        if (! namespace2.equals("")) {
                                            java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                                            if (prefix2 == null) {
                                                prefix2 = generatePrefix(namespace2);

                                                xmlWriter.writeStartElement(prefix2,"return", namespace2);
                                                xmlWriter.writeNamespace(prefix2, namespace2);
                                                xmlWriter.setPrefix(prefix2, namespace2);

                                            } else {
                                                xmlWriter.writeStartElement(namespace2,"return");
                                            }

                                        } else {
                                            xmlWriter.writeStartElement("return");
                                        }


                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     local_return.serialize(new javax.xml.namespace.QName("http://dam.imc.h3c.com/damAssetService","return"),
                                        factory,xmlWriter);
                                    }
                                }
                    xmlWriter.writeEndElement();


        }

         /**
          * Util method to write an attribute with the ns prefix
          */
          public void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
              if (xmlWriter.getPrefix(namespace) == null) {
                       xmlWriter.writeNamespace(prefix, namespace);
                       xmlWriter.setPrefix(prefix, namespace);

              }

              xmlWriter.writeAttribute(namespace,attName,attValue);

         }

        /**
          * Util method to write an attribute without the ns prefix
          */
          public void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
                if (namespace.equals(""))
              {
                  xmlWriter.writeAttribute(attName,attValue);
              }
              else
              {
                  registerPrefix(xmlWriter, namespace);
                  xmlWriter.writeAttribute(namespace,attName,attValue);
              }
          }


           /**
             * Util method to write an attribute without the ns prefix
             */
            public void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        public void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        public void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


         /**
         * Register a namespace prefix
         */
         public java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                        prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                    }

                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }

                return prefix;
            }



        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{



                 java.util.ArrayList elementList = new java.util.ArrayList();
                 java.util.ArrayList attribList = new java.util.ArrayList();

                 if (local_returnTracker){
                            elementList.add(new javax.xml.namespace.QName("http://dam.imc.h3c.com/damAssetService",
                                                                      "return"));


                                    elementList.add(local_return==null?null:
                                    local_return);
                                }

                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());



        }



     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{




        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static AddAssetResponse parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            AddAssetResponse object =
                new AddAssetResponse();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();


                if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
                  java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                        "type");
                  if (fullTypeName!=null){
                    java.lang.String nsPrefix = null;
                    if (fullTypeName.indexOf(":") > -1){
                        nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
                    }
                    nsPrefix = nsPrefix==null?"":nsPrefix;

                    java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);

                            if (!"addAssetResponse".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (AddAssetResponse)ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }


                  }


                }




                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();




                    reader.next();


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://dam.imc.h3c.com/damAssetService","return").equals(reader.getName())){

                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.set_return(null);
                                          reader.next();

                                            reader.next();

                                      }else{

                                                object.set_return(WSCommonResult.Factory.parse(reader));

                                        reader.next();
                                    }
                              }  // End of if for expected property start element

                                    else {

                                    }

                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();

                                if (reader.isStartElement())
                                // A start element we are not expecting indicates a trailing invalid property
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());




            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class



        }


        public static class RetAssetGroupInfo
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = RetAssetGroupInfo
                Namespace URI = http://asset.damws.imc.h3c.com/xsd
                Namespace Prefix = ns2
                */


        public static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://asset.damws.imc.h3c.com/xsd")){
                return "ns2";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }



                        /**
                        * field for GroupDescription
                        */


                                    protected java.lang.String localGroupDescription ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localGroupDescriptionTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getGroupDescription(){
                               return localGroupDescription;
                           }



                            /**
                               * Auto generated setter method
                               * @param param GroupDescription
                               */
                               public void setGroupDescription(java.lang.String param){

                                       if (param != null){
                                          //update the setting tracker
                                          localGroupDescriptionTracker = true;
                                       } else {
                                          localGroupDescriptionTracker = true;

                                       }

                                            this.localGroupDescription=param;


                               }


                        /**
                        * field for GroupId
                        */


                                    protected long localGroupId ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localGroupIdTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return long
                           */
                           public  long getGroupId(){
                               return localGroupId;
                           }



                            /**
                               * Auto generated setter method
                               * @param param GroupId
                               */
                               public void setGroupId(long param){

                                       // setting primitive attribute tracker to true

                                               if (param==java.lang.Long.MIN_VALUE) {
                                           localGroupIdTracker = true;

                                       } else {
                                          localGroupIdTracker = true;
                                       }

                                            this.localGroupId=param;


                               }


                        /**
                        * field for GroupName
                        */


                                    protected java.lang.String localGroupName ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localGroupNameTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getGroupName(){
                               return localGroupName;
                           }



                            /**
                               * Auto generated setter method
                               * @param param GroupName
                               */
                               public void setGroupName(java.lang.String param){

                                       if (param != null){
                                          //update the setting tracker
                                          localGroupNameTracker = true;
                                       } else {
                                          localGroupNameTracker = true;

                                       }

                                            this.localGroupName=param;


                               }


     /**
     * isReaderMTOMAware
     * @return true if the reader supports MTOM
     */
   public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
        boolean isReaderMTOMAware = false;

        try{
          isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
        }catch(java.lang.IllegalArgumentException e){
          isReaderMTOMAware = false;
        }
        return isReaderMTOMAware;
   }


        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{



               org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,parentQName){

                 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                       RetAssetGroupInfo.this.serialize(parentQName,factory,xmlWriter);
                 }
               };
               return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
               parentQName,factory,dataSource);

       }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       final org.apache.axiom.om.OMFactory factory,
                                       org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,factory,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               final org.apache.axiom.om.OMFactory factory,
                               org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{




                java.lang.String prefix = null;
                java.lang.String namespace = null;


                    prefix = parentQName.getPrefix();
                    namespace = parentQName.getNamespaceURI();

                    if ((namespace != null) && (namespace.trim().length() > 0)) {
                        java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                        if (writerPrefix != null) {
                            xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                        } else {
                            if (prefix == null) {
                                prefix = generatePrefix(namespace);
                            }

                            xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                            xmlWriter.writeNamespace(prefix, namespace);
                            xmlWriter.setPrefix(prefix, namespace);
                        }
                    } else {
                        xmlWriter.writeStartElement(parentQName.getLocalPart());
                    }

                  if (serializeType){


                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://asset.damws.imc.h3c.com/xsd");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":RetAssetGroupInfo",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "RetAssetGroupInfo",
                           xmlWriter);
                   }


                   }
                if (localGroupDescriptionTracker){
                                    namespace = "http://asset.damws.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"groupDescription", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"groupDescription");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("groupDescription");
                                    }


                                          if (localGroupDescription==null){
                                              // write the nil attribute

                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                          }else{


                                                   xmlWriter.writeCharacters(localGroupDescription);

                                          }

                                   xmlWriter.writeEndElement();
                             } if (localGroupIdTracker){
                                    namespace = "http://asset.damws.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"groupId", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"groupId");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("groupId");
                                    }

                                               if (localGroupId==java.lang.Long.MIN_VALUE) {

                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localGroupId));
                                               }

                                   xmlWriter.writeEndElement();
                             } if (localGroupNameTracker){
                                    namespace = "http://asset.damws.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"groupName", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"groupName");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("groupName");
                                    }


                                          if (localGroupName==null){
                                              // write the nil attribute

                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                          }else{


                                                   xmlWriter.writeCharacters(localGroupName);

                                          }

                                   xmlWriter.writeEndElement();
                             }
                    xmlWriter.writeEndElement();


        }

         /**
          * Util method to write an attribute with the ns prefix
          */
          public void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
              if (xmlWriter.getPrefix(namespace) == null) {
                       xmlWriter.writeNamespace(prefix, namespace);
                       xmlWriter.setPrefix(prefix, namespace);

              }

              xmlWriter.writeAttribute(namespace,attName,attValue);

         }

        /**
          * Util method to write an attribute without the ns prefix
          */
          public void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
                if (namespace.equals(""))
              {
                  xmlWriter.writeAttribute(attName,attValue);
              }
              else
              {
                  registerPrefix(xmlWriter, namespace);
                  xmlWriter.writeAttribute(namespace,attName,attValue);
              }
          }


           /**
             * Util method to write an attribute without the ns prefix
             */
            public void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        public void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        public void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


         /**
         * Register a namespace prefix
         */
         public java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                        prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                    }

                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }

                return prefix;
            }



        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{



                 java.util.ArrayList elementList = new java.util.ArrayList();
                 java.util.ArrayList attribList = new java.util.ArrayList();

                 if (localGroupDescriptionTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                      "groupDescription"));

                                         elementList.add(localGroupDescription==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localGroupDescription));
                                    } if (localGroupIdTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                      "groupId"));

                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localGroupId));
                            } if (localGroupNameTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                      "groupName"));

                                         elementList.add(localGroupName==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localGroupName));
                                    }

                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());



        }



     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{




        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static RetAssetGroupInfo parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            RetAssetGroupInfo object =
                new RetAssetGroupInfo();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();


                if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
                  java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                        "type");
                  if (fullTypeName!=null){
                    java.lang.String nsPrefix = null;
                    if (fullTypeName.indexOf(":") > -1){
                        nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
                    }
                    nsPrefix = nsPrefix==null?"":nsPrefix;

                    java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);

                            if (!"RetAssetGroupInfo".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (RetAssetGroupInfo)ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }


                  }


                }




                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();




                    reader.next();


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","groupDescription").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setGroupDescription(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                                       } else {


                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","groupId").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setGroupId(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToLong(content));

                                       } else {


                                                   object.setGroupId(java.lang.Long.MIN_VALUE);

                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                               object.setGroupId(java.lang.Long.MIN_VALUE);

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","groupName").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setGroupName(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                                       } else {


                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                    }

                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();

                                if (reader.isStartElement())
                                // A start element we are not expecting indicates a trailing invalid property
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());




            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class



        }


        public static class QueryAsset
        implements org.apache.axis2.databinding.ADBBean{

                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://dam.imc.h3c.com/damAssetService",
                "queryAsset",
                "ns3");



        public static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://dam.imc.h3c.com/damAssetService")){
                return "ns3";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }



                        /**
                        * field for Param0
                        */


                                    protected AssetQueryInfo localParam0 ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localParam0Tracker = false ;


                           /**
                           * Auto generated getter method
                           * @return AssetQueryInfo
                           */
                           public  AssetQueryInfo getParam0(){
                               return localParam0;
                           }



                            /**
                               * Auto generated setter method
                               * @param param Param0
                               */
                               public void setParam0(AssetQueryInfo param){

                                       if (param != null){
                                          //update the setting tracker
                                          localParam0Tracker = true;
                                       } else {
                                          localParam0Tracker = true;

                                       }

                                            this.localParam0=param;


                               }


     /**
     * isReaderMTOMAware
     * @return true if the reader supports MTOM
     */
   public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
        boolean isReaderMTOMAware = false;

        try{
          isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
        }catch(java.lang.IllegalArgumentException e){
          isReaderMTOMAware = false;
        }
        return isReaderMTOMAware;
   }


        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{



                org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,MY_QNAME){

                 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                       QueryAsset.this.serialize(MY_QNAME,factory,xmlWriter);
                 }
               };
               return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
               MY_QNAME,factory,dataSource);

       }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       final org.apache.axiom.om.OMFactory factory,
                                       org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,factory,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               final org.apache.axiom.om.OMFactory factory,
                               org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{




                java.lang.String prefix = null;
                java.lang.String namespace = null;


                    prefix = parentQName.getPrefix();
                    namespace = parentQName.getNamespaceURI();

                    if ((namespace != null) && (namespace.trim().length() > 0)) {
                        java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                        if (writerPrefix != null) {
                            xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                        } else {
                            if (prefix == null) {
                                prefix = generatePrefix(namespace);
                            }

                            xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                            xmlWriter.writeNamespace(prefix, namespace);
                            xmlWriter.setPrefix(prefix, namespace);
                        }
                    } else {
                        xmlWriter.writeStartElement(parentQName.getLocalPart());
                    }

                  if (serializeType){


                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://dam.imc.h3c.com/damAssetService");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":queryAsset",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "queryAsset",
                           xmlWriter);
                   }


                   }
                if (localParam0Tracker){
                                    if (localParam0==null){

                                            java.lang.String namespace2 = "http://dam.imc.h3c.com/damAssetService";

                                        if (! namespace2.equals("")) {
                                            java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                                            if (prefix2 == null) {
                                                prefix2 = generatePrefix(namespace2);

                                                xmlWriter.writeStartElement(prefix2,"param0", namespace2);
                                                xmlWriter.writeNamespace(prefix2, namespace2);
                                                xmlWriter.setPrefix(prefix2, namespace2);

                                            } else {
                                                xmlWriter.writeStartElement(namespace2,"param0");
                                            }

                                        } else {
                                            xmlWriter.writeStartElement("param0");
                                        }


                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localParam0.serialize(new javax.xml.namespace.QName("http://dam.imc.h3c.com/damAssetService","param0"),
                                        factory,xmlWriter);
                                    }
                                }
                    xmlWriter.writeEndElement();


        }

         /**
          * Util method to write an attribute with the ns prefix
          */
          public void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
              if (xmlWriter.getPrefix(namespace) == null) {
                       xmlWriter.writeNamespace(prefix, namespace);
                       xmlWriter.setPrefix(prefix, namespace);

              }

              xmlWriter.writeAttribute(namespace,attName,attValue);

         }

        /**
          * Util method to write an attribute without the ns prefix
          */
          public void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
                if (namespace.equals(""))
              {
                  xmlWriter.writeAttribute(attName,attValue);
              }
              else
              {
                  registerPrefix(xmlWriter, namespace);
                  xmlWriter.writeAttribute(namespace,attName,attValue);
              }
          }


           /**
             * Util method to write an attribute without the ns prefix
             */
            public void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        public void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        public void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


         /**
         * Register a namespace prefix
         */
         public java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                        prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                    }

                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }

                return prefix;
            }



        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{



                 java.util.ArrayList elementList = new java.util.ArrayList();
                 java.util.ArrayList attribList = new java.util.ArrayList();

                 if (localParam0Tracker){
                            elementList.add(new javax.xml.namespace.QName("http://dam.imc.h3c.com/damAssetService",
                                                                      "param0"));


                                    elementList.add(localParam0==null?null:
                                    localParam0);
                                }

                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());



        }



     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{




        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static QueryAsset parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            QueryAsset object =
                new QueryAsset();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();


                if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
                  java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                        "type");
                  if (fullTypeName!=null){
                    java.lang.String nsPrefix = null;
                    if (fullTypeName.indexOf(":") > -1){
                        nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
                    }
                    nsPrefix = nsPrefix==null?"":nsPrefix;

                    java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);

                            if (!"queryAsset".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (QueryAsset)ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }


                  }


                }




                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();




                    reader.next();


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://dam.imc.h3c.com/damAssetService","param0").equals(reader.getName())){

                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setParam0(null);
                                          reader.next();

                                            reader.next();

                                      }else{

                                                object.setParam0(AssetQueryInfo.Factory.parse(reader));

                                        reader.next();
                                    }
                              }  // End of if for expected property start element

                                    else {

                                    }

                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();

                                if (reader.isStartElement())
                                // A start element we are not expecting indicates a trailing invalid property
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());




            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class



        }


        public static class RetAssetInfoList extends WSCommonResult
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = RetAssetInfoList
                Namespace URI = http://asset.damws.imc.h3c.com/xsd
                Namespace Prefix = ns2
                */


        public static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://asset.damws.imc.h3c.com/xsd")){
                return "ns2";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }



                        /**
                        * field for RetAssetList
                        * This was an Array!
                        */


                                    protected RetAssetInfo[] localRetAssetList ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localRetAssetListTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return RetAssetInfo[]
                           */
                           public  RetAssetInfo[] getRetAssetList(){
                               return localRetAssetList;
                           }






                              /**
                               * validate the array for RetAssetList
                               */
                              protected void validateRetAssetList(RetAssetInfo[] param){

                              }


                             /**
                              * Auto generated setter method
                              * @param param RetAssetList
                              */
                              public void setRetAssetList(RetAssetInfo[] param){

                                   validateRetAssetList(param);


                                          if (param != null){
                                             //update the setting tracker
                                             localRetAssetListTracker = true;
                                          } else {
                                             localRetAssetListTracker = true;

                                          }

                                      this.localRetAssetList=param;
                              }



                             /**
                             * Auto generated add method for the array for convenience
                             * @param param RetAssetInfo
                             */
                             public void addRetAssetList(RetAssetInfo param){
                                   if (localRetAssetList == null){
                                   localRetAssetList = new RetAssetInfo[]{};
                                   }


                                 //update the setting tracker
                                localRetAssetListTracker = true;


                               java.util.List list =
                            org.apache.axis2.databinding.utils.ConverterUtil.toList(localRetAssetList);
                               list.add(param);
                               this.localRetAssetList =
                             (RetAssetInfo[])list.toArray(
                            new RetAssetInfo[list.size()]);

                             }


     /**
     * isReaderMTOMAware
     * @return true if the reader supports MTOM
     */
   public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
        boolean isReaderMTOMAware = false;

        try{
          isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
        }catch(java.lang.IllegalArgumentException e){
          isReaderMTOMAware = false;
        }
        return isReaderMTOMAware;
   }


        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{



               org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,parentQName){

                 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                       RetAssetInfoList.this.serialize(parentQName,factory,xmlWriter);
                 }
               };
               return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
               parentQName,factory,dataSource);

       }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       final org.apache.axiom.om.OMFactory factory,
                                       org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,factory,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               final org.apache.axiom.om.OMFactory factory,
                               org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{




                java.lang.String prefix = null;
                java.lang.String namespace = null;


                    prefix = parentQName.getPrefix();
                    namespace = parentQName.getNamespaceURI();

                    if ((namespace != null) && (namespace.trim().length() > 0)) {
                        java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                        if (writerPrefix != null) {
                            xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                        } else {
                            if (prefix == null) {
                                prefix = generatePrefix(namespace);
                            }

                            xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                            xmlWriter.writeNamespace(prefix, namespace);
                            xmlWriter.setPrefix(prefix, namespace);
                        }
                    } else {
                        xmlWriter.writeStartElement(parentQName.getLocalPart());
                    }


                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://asset.damws.imc.h3c.com/xsd");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":RetAssetInfoList",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "RetAssetInfoList",
                           xmlWriter);
                   }

                if (localDescriptionTracker){
                                    namespace = "http://ws.common.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"description", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"description");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("description");
                                    }


                                          if (localDescription==null){
                                              // write the nil attribute

                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                          }else{


                                                   xmlWriter.writeCharacters(localDescription);

                                          }

                                   xmlWriter.writeEndElement();
                             } if (localErrorCodeTracker){
                                    namespace = "http://ws.common.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"errorCode", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"errorCode");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("errorCode");
                                    }

                                               if (localErrorCode==java.lang.Integer.MIN_VALUE) {

                                                         throw new org.apache.axis2.databinding.ADBException("errorCode cannot be null!!");

                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localErrorCode));
                                               }

                                   xmlWriter.writeEndElement();
                             } if (localErrorMsgTracker){
                                    namespace = "http://ws.common.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"errorMsg", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"errorMsg");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("errorMsg");
                                    }


                                          if (localErrorMsg==null){
                                              // write the nil attribute

                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                          }else{


                                                   xmlWriter.writeCharacters(localErrorMsg);

                                          }

                                   xmlWriter.writeEndElement();
                             } if (localRetAssetListTracker){
                                       if (localRetAssetList!=null){
                                            for (int i = 0;i < localRetAssetList.length;i++){
                                                if (localRetAssetList[i] != null){
                                                 localRetAssetList[i].serialize(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","retAssetList"),
                                                           factory,xmlWriter);
                                                } else {

                                                            // write null attribute
                                                            java.lang.String namespace2 = "http://asset.damws.imc.h3c.com/xsd";
                                                            if (! namespace2.equals("")) {
                                                                java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                                                                if (prefix2 == null) {
                                                                    prefix2 = generatePrefix(namespace2);

                                                                    xmlWriter.writeStartElement(prefix2,"retAssetList", namespace2);
                                                                    xmlWriter.writeNamespace(prefix2, namespace2);
                                                                    xmlWriter.setPrefix(prefix2, namespace2);

                                                                } else {
                                                                    xmlWriter.writeStartElement(namespace2,"retAssetList");
                                                                }

                                                            } else {
                                                                xmlWriter.writeStartElement("retAssetList");
                                                            }

                                                           // write the nil attribute
                                                           writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                           xmlWriter.writeEndElement();

                                                }

                                            }
                                     } else {

                                                // write null attribute
                                                java.lang.String namespace2 = "http://asset.damws.imc.h3c.com/xsd";
                                                if (! namespace2.equals("")) {
                                                    java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                                                    if (prefix2 == null) {
                                                        prefix2 = generatePrefix(namespace2);

                                                        xmlWriter.writeStartElement(prefix2,"retAssetList", namespace2);
                                                        xmlWriter.writeNamespace(prefix2, namespace2);
                                                        xmlWriter.setPrefix(prefix2, namespace2);

                                                    } else {
                                                        xmlWriter.writeStartElement(namespace2,"retAssetList");
                                                    }

                                                } else {
                                                    xmlWriter.writeStartElement("retAssetList");
                                                }

                                               // write the nil attribute
                                               writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                               xmlWriter.writeEndElement();

                                    }
                                 }
                    xmlWriter.writeEndElement();


        }

         /**
          * Util method to write an attribute with the ns prefix
          */
          public void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
              if (xmlWriter.getPrefix(namespace) == null) {
                       xmlWriter.writeNamespace(prefix, namespace);
                       xmlWriter.setPrefix(prefix, namespace);

              }

              xmlWriter.writeAttribute(namespace,attName,attValue);

         }

        /**
          * Util method to write an attribute without the ns prefix
          */
          public void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
                if (namespace.equals(""))
              {
                  xmlWriter.writeAttribute(attName,attValue);
              }
              else
              {
                  registerPrefix(xmlWriter, namespace);
                  xmlWriter.writeAttribute(namespace,attName,attValue);
              }
          }


           /**
             * Util method to write an attribute without the ns prefix
             */
            public void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        public void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        public void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


         /**
         * Register a namespace prefix
         */
         public java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                        prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                    }

                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }

                return prefix;
            }



        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{



                 java.util.ArrayList elementList = new java.util.ArrayList();
                 java.util.ArrayList attribList = new java.util.ArrayList();


                    attribList.add(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema-instance","type"));
                    attribList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","RetAssetInfoList"));
                 if (localDescriptionTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://ws.common.imc.h3c.com/xsd",
                                                                      "description"));

                                         elementList.add(localDescription==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDescription));
                                    } if (localErrorCodeTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://ws.common.imc.h3c.com/xsd",
                                                                      "errorCode"));

                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localErrorCode));
                            } if (localErrorMsgTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://ws.common.imc.h3c.com/xsd",
                                                                      "errorMsg"));

                                         elementList.add(localErrorMsg==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localErrorMsg));
                                    } if (localRetAssetListTracker){
                             if (localRetAssetList!=null) {
                                 for (int i = 0;i < localRetAssetList.length;i++){

                                    if (localRetAssetList[i] != null){
                                         elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                          "retAssetList"));
                                         elementList.add(localRetAssetList[i]);
                                    } else {

                                                elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                          "retAssetList"));
                                                elementList.add(null);

                                    }

                                 }
                             } else {

                                        elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                          "retAssetList"));
                                        elementList.add(localRetAssetList);

                             }

                        }

                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());



        }



     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{




        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static RetAssetInfoList parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            RetAssetInfoList object =
                new RetAssetInfoList();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();


                if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
                  java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                        "type");
                  if (fullTypeName!=null){
                    java.lang.String nsPrefix = null;
                    if (fullTypeName.indexOf(":") > -1){
                        nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
                    }
                    nsPrefix = nsPrefix==null?"":nsPrefix;

                    java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);

                            if (!"RetAssetInfoList".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (RetAssetInfoList)ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }


                  }


                }




                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();




                    reader.next();

                        java.util.ArrayList list4 = new java.util.ArrayList();


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.common.imc.h3c.com/xsd","description").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setDescription(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                                       } else {


                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.common.imc.h3c.com/xsd","errorCode").equals(reader.getName())){

                                    java.lang.String content = reader.getElementText();

                                              object.setErrorCode(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                               object.setErrorCode(java.lang.Integer.MIN_VALUE);

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.common.imc.h3c.com/xsd","errorMsg").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setErrorMsg(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                                       } else {


                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","retAssetList").equals(reader.getName())){



                                    // Process the array and step past its final element's end.

                                                          nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                                          if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                                              list4.add(null);
                                                              reader.next();
                                                          } else {
                                                        list4.add(RetAssetInfo.Factory.parse(reader));
                                                                }
                                                        //loop until we find a start element that is not part of this array
                                                        boolean loopDone4 = false;
                                                        while(!loopDone4){
                                                            // We should be at the end element, but make sure
                                                            while (!reader.isEndElement())
                                                                reader.next();
                                                            // Step out of this element
                                                            reader.next();
                                                            // Step to next element event.
                                                            while (!reader.isStartElement() && !reader.isEndElement())
                                                                reader.next();
                                                            if (reader.isEndElement()){
                                                                //two continuous end elements means we are exiting the xml structure
                                                                loopDone4 = true;
                                                            } else {
                                                                if (new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","retAssetList").equals(reader.getName())){

                                                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                                                          list4.add(null);
                                                                          reader.next();
                                                                      } else {
                                                                    list4.add(RetAssetInfo.Factory.parse(reader));
                                                                        }
                                                                }else{
                                                                    loopDone4 = true;
                                                                }
                                                            }
                                                        }
                                                        // call the converter utility  to convert and set the array

                                                        object.setRetAssetList((RetAssetInfo[])
                                                            org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                                                RetAssetInfo.class,
                                                                list4));

                              }  // End of if for expected property start element

                                    else {

                                    }

                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();

                                if (reader.isStartElement())
                                // A start element we are not expecting indicates a trailing invalid property
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());




            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class



        }


        public static class WSCommonResult
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = WSCommonResult
                Namespace URI = http://ws.common.imc.h3c.com/xsd
                Namespace Prefix = ns1
                */


        public static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://ws.common.imc.h3c.com/xsd")){
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }



                        /**
                        * field for Description
                        */


                                    protected java.lang.String localDescription ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDescriptionTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getDescription(){
                               return localDescription;
                           }



                            /**
                               * Auto generated setter method
                               * @param param Description
                               */
                               public void setDescription(java.lang.String param){

                                       if (param != null){
                                          //update the setting tracker
                                          localDescriptionTracker = true;
                                       } else {
                                          localDescriptionTracker = true;

                                       }

                                            this.localDescription=param;


                               }


                        /**
                        * field for ErrorCode
                        */


                                    protected int localErrorCode ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localErrorCodeTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getErrorCode(){
                               return localErrorCode;
                           }



                            /**
                               * Auto generated setter method
                               * @param param ErrorCode
                               */
                               public void setErrorCode(int param){

                                       // setting primitive attribute tracker to true

                                               if (param==java.lang.Integer.MIN_VALUE) {
                                           localErrorCodeTracker = false;

                                       } else {
                                          localErrorCodeTracker = true;
                                       }

                                            this.localErrorCode=param;


                               }


                        /**
                        * field for ErrorMsg
                        */


                                    protected java.lang.String localErrorMsg ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localErrorMsgTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getErrorMsg(){
                               return localErrorMsg;
                           }



                            /**
                               * Auto generated setter method
                               * @param param ErrorMsg
                               */
                               public void setErrorMsg(java.lang.String param){

                                       if (param != null){
                                          //update the setting tracker
                                          localErrorMsgTracker = true;
                                       } else {
                                          localErrorMsgTracker = true;

                                       }

                                            this.localErrorMsg=param;


                               }


     /**
     * isReaderMTOMAware
     * @return true if the reader supports MTOM
     */
   public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
        boolean isReaderMTOMAware = false;

        try{
          isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
        }catch(java.lang.IllegalArgumentException e){
          isReaderMTOMAware = false;
        }
        return isReaderMTOMAware;
   }


        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{



               org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,parentQName){

                 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                       WSCommonResult.this.serialize(parentQName,factory,xmlWriter);
                 }
               };
               return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
               parentQName,factory,dataSource);

       }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       final org.apache.axiom.om.OMFactory factory,
                                       org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,factory,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               final org.apache.axiom.om.OMFactory factory,
                               org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{




                java.lang.String prefix = null;
                java.lang.String namespace = null;


                    prefix = parentQName.getPrefix();
                    namespace = parentQName.getNamespaceURI();

                    if ((namespace != null) && (namespace.trim().length() > 0)) {
                        java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                        if (writerPrefix != null) {
                            xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                        } else {
                            if (prefix == null) {
                                prefix = generatePrefix(namespace);
                            }

                            xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                            xmlWriter.writeNamespace(prefix, namespace);
                            xmlWriter.setPrefix(prefix, namespace);
                        }
                    } else {
                        xmlWriter.writeStartElement(parentQName.getLocalPart());
                    }

                  if (serializeType){


                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://ws.common.imc.h3c.com/xsd");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":WSCommonResult",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "WSCommonResult",
                           xmlWriter);
                   }


                   }
                if (localDescriptionTracker){
                                    namespace = "http://ws.common.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"description", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"description");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("description");
                                    }


                                          if (localDescription==null){
                                              // write the nil attribute

                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                          }else{


                                                   xmlWriter.writeCharacters(localDescription);

                                          }

                                   xmlWriter.writeEndElement();
                             } if (localErrorCodeTracker){
                                    namespace = "http://ws.common.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"errorCode", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"errorCode");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("errorCode");
                                    }

                                               if (localErrorCode==java.lang.Integer.MIN_VALUE) {

                                                         throw new org.apache.axis2.databinding.ADBException("errorCode cannot be null!!");

                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localErrorCode));
                                               }

                                   xmlWriter.writeEndElement();
                             } if (localErrorMsgTracker){
                                    namespace = "http://ws.common.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"errorMsg", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"errorMsg");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("errorMsg");
                                    }


                                          if (localErrorMsg==null){
                                              // write the nil attribute

                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                          }else{


                                                   xmlWriter.writeCharacters(localErrorMsg);

                                          }

                                   xmlWriter.writeEndElement();
                             }
                    xmlWriter.writeEndElement();


        }

         /**
          * Util method to write an attribute with the ns prefix
          */
          public void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
              if (xmlWriter.getPrefix(namespace) == null) {
                       xmlWriter.writeNamespace(prefix, namespace);
                       xmlWriter.setPrefix(prefix, namespace);

              }

              xmlWriter.writeAttribute(namespace,attName,attValue);

         }

        /**
          * Util method to write an attribute without the ns prefix
          */
          public void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
                if (namespace.equals(""))
              {
                  xmlWriter.writeAttribute(attName,attValue);
              }
              else
              {
                  registerPrefix(xmlWriter, namespace);
                  xmlWriter.writeAttribute(namespace,attName,attValue);
              }
          }


           /**
             * Util method to write an attribute without the ns prefix
             */
            public void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        public void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        public void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


         /**
         * Register a namespace prefix
         */
         public java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                        prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                    }

                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }

                return prefix;
            }



        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{



                 java.util.ArrayList elementList = new java.util.ArrayList();
                 java.util.ArrayList attribList = new java.util.ArrayList();

                 if (localDescriptionTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://ws.common.imc.h3c.com/xsd",
                                                                      "description"));

                                         elementList.add(localDescription==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDescription));
                                    } if (localErrorCodeTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://ws.common.imc.h3c.com/xsd",
                                                                      "errorCode"));

                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localErrorCode));
                            } if (localErrorMsgTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://ws.common.imc.h3c.com/xsd",
                                                                      "errorMsg"));

                                         elementList.add(localErrorMsg==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localErrorMsg));
                                    }

                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());



        }



     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{




        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static WSCommonResult parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            WSCommonResult object =
                new WSCommonResult();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();


                if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
                  java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                        "type");
                  if (fullTypeName!=null){
                    java.lang.String nsPrefix = null;
                    if (fullTypeName.indexOf(":") > -1){
                        nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
                    }
                    nsPrefix = nsPrefix==null?"":nsPrefix;

                    java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);

                            if (!"WSCommonResult".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (WSCommonResult)ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }


                  }


                }




                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();




                    reader.next();


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.common.imc.h3c.com/xsd","description").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setDescription(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                                       } else {


                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.common.imc.h3c.com/xsd","errorCode").equals(reader.getName())){

                                    java.lang.String content = reader.getElementText();

                                              object.setErrorCode(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                               object.setErrorCode(java.lang.Integer.MIN_VALUE);

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.common.imc.h3c.com/xsd","errorMsg").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setErrorMsg(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                                       } else {


                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                    }

                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();

                                if (reader.isStartElement())
                                // A start element we are not expecting indicates a trailing invalid property
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());




            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class



        }


        public static class ExtensionMapper{

          public static java.lang.Object getTypeObject(java.lang.String namespaceURI,
                                                       java.lang.String typeName,
                                                       javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{


                  if (
                  "http://asset.damws.imc.h3c.com/xsd".equals(namespaceURI) &&
                  "RetAssetInfo".equals(typeName)){

                            return  RetAssetInfo.Factory.parse(reader);


                  }


                  if (
                  "http://asset.damws.imc.h3c.com/xsd".equals(namespaceURI) &&
                  "ModifyAssetInfo".equals(typeName)){

                            return  ModifyAssetInfo.Factory.parse(reader);


                  }


                  if (
                  "http://asset.damws.imc.h3c.com/xsd".equals(namespaceURI) &&
                  "AddAssetInfo".equals(typeName)){

                            return  AddAssetInfo.Factory.parse(reader);


                  }


                  if (
                  "http://asset.damws.imc.h3c.com/xsd".equals(namespaceURI) &&
                  "RetAssetGroupInfoList".equals(typeName)){

                            return  RetAssetGroupInfoList.Factory.parse(reader);


                  }


                  if (
                  "http://asset.damws.imc.h3c.com/xsd".equals(namespaceURI) &&
                  "RetAssetDetailInfo".equals(typeName)){

                            return  RetAssetDetailInfo.Factory.parse(reader);


                  }


                  if (
                  "http://asset.damws.imc.h3c.com/xsd".equals(namespaceURI) &&
                  "RetAssetGroupInfo".equals(typeName)){

                            return  RetAssetGroupInfo.Factory.parse(reader);


                  }


                  if (
                  "http://asset.damws.imc.h3c.com/xsd".equals(namespaceURI) &&
                  "RetAssetInfoList".equals(typeName)){

                            return  RetAssetInfoList.Factory.parse(reader);


                  }


                  if (
                  "http://asset.damws.imc.h3c.com/xsd".equals(namespaceURI) &&
                  "AssetQueryInfo".equals(typeName)){

                            return  AssetQueryInfo.Factory.parse(reader);


                  }


                  if (
                  "http://ws.common.imc.h3c.com/xsd".equals(namespaceURI) &&
                  "WSCommonResult".equals(typeName)){

                            return  WSCommonResult.Factory.parse(reader);


                  }


             throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
          }

        }

        public static class QueryAssetDetailResponse
        implements org.apache.axis2.databinding.ADBBean{

                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://dam.imc.h3c.com/damAssetService",
                "queryAssetDetailResponse",
                "ns3");



        public static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://dam.imc.h3c.com/damAssetService")){
                return "ns3";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }



                        /**
                        * field for _return
                        */


                                    protected RetAssetDetailInfo local_return ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean local_returnTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return RetAssetDetailInfo
                           */
                           public  RetAssetDetailInfo get_return(){
                               return local_return;
                           }



                            /**
                               * Auto generated setter method
                               * @param param _return
                               */
                               public void set_return(RetAssetDetailInfo param){

                                       if (param != null){
                                          //update the setting tracker
                                          local_returnTracker = true;
                                       } else {
                                          local_returnTracker = true;

                                       }

                                            this.local_return=param;


                               }


     /**
     * isReaderMTOMAware
     * @return true if the reader supports MTOM
     */
   public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
        boolean isReaderMTOMAware = false;

        try{
          isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
        }catch(java.lang.IllegalArgumentException e){
          isReaderMTOMAware = false;
        }
        return isReaderMTOMAware;
   }


        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{



                org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,MY_QNAME){

                 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                       QueryAssetDetailResponse.this.serialize(MY_QNAME,factory,xmlWriter);
                 }
               };
               return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
               MY_QNAME,factory,dataSource);

       }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       final org.apache.axiom.om.OMFactory factory,
                                       org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,factory,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               final org.apache.axiom.om.OMFactory factory,
                               org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{




                java.lang.String prefix = null;
                java.lang.String namespace = null;


                    prefix = parentQName.getPrefix();
                    namespace = parentQName.getNamespaceURI();

                    if ((namespace != null) && (namespace.trim().length() > 0)) {
                        java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                        if (writerPrefix != null) {
                            xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                        } else {
                            if (prefix == null) {
                                prefix = generatePrefix(namespace);
                            }

                            xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                            xmlWriter.writeNamespace(prefix, namespace);
                            xmlWriter.setPrefix(prefix, namespace);
                        }
                    } else {
                        xmlWriter.writeStartElement(parentQName.getLocalPart());
                    }

                  if (serializeType){


                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://dam.imc.h3c.com/damAssetService");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":queryAssetDetailResponse",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "queryAssetDetailResponse",
                           xmlWriter);
                   }


                   }
                if (local_returnTracker){
                                    if (local_return==null){

                                            java.lang.String namespace2 = "http://dam.imc.h3c.com/damAssetService";

                                        if (! namespace2.equals("")) {
                                            java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                                            if (prefix2 == null) {
                                                prefix2 = generatePrefix(namespace2);

                                                xmlWriter.writeStartElement(prefix2,"return", namespace2);
                                                xmlWriter.writeNamespace(prefix2, namespace2);
                                                xmlWriter.setPrefix(prefix2, namespace2);

                                            } else {
                                                xmlWriter.writeStartElement(namespace2,"return");
                                            }

                                        } else {
                                            xmlWriter.writeStartElement("return");
                                        }


                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     local_return.serialize(new javax.xml.namespace.QName("http://dam.imc.h3c.com/damAssetService","return"),
                                        factory,xmlWriter);
                                    }
                                }
                    xmlWriter.writeEndElement();


        }

         /**
          * Util method to write an attribute with the ns prefix
          */
          public void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
              if (xmlWriter.getPrefix(namespace) == null) {
                       xmlWriter.writeNamespace(prefix, namespace);
                       xmlWriter.setPrefix(prefix, namespace);

              }

              xmlWriter.writeAttribute(namespace,attName,attValue);

         }

        /**
          * Util method to write an attribute without the ns prefix
          */
          public void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
                if (namespace.equals(""))
              {
                  xmlWriter.writeAttribute(attName,attValue);
              }
              else
              {
                  registerPrefix(xmlWriter, namespace);
                  xmlWriter.writeAttribute(namespace,attName,attValue);
              }
          }


           /**
             * Util method to write an attribute without the ns prefix
             */
            public void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        public void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        public void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


         /**
         * Register a namespace prefix
         */
         public java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                        prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                    }

                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }

                return prefix;
            }



        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{



                 java.util.ArrayList elementList = new java.util.ArrayList();
                 java.util.ArrayList attribList = new java.util.ArrayList();

                 if (local_returnTracker){
                            elementList.add(new javax.xml.namespace.QName("http://dam.imc.h3c.com/damAssetService",
                                                                      "return"));


                                    elementList.add(local_return==null?null:
                                    local_return);
                                }

                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());



        }



     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{




        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static QueryAssetDetailResponse parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            QueryAssetDetailResponse object =
                new QueryAssetDetailResponse();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();


                if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
                  java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                        "type");
                  if (fullTypeName!=null){
                    java.lang.String nsPrefix = null;
                    if (fullTypeName.indexOf(":") > -1){
                        nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
                    }
                    nsPrefix = nsPrefix==null?"":nsPrefix;

                    java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);

                            if (!"queryAssetDetailResponse".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (QueryAssetDetailResponse)ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }


                  }


                }




                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();




                    reader.next();


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://dam.imc.h3c.com/damAssetService","return").equals(reader.getName())){

                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.set_return(null);
                                          reader.next();

                                            reader.next();

                                      }else{

                                                object.set_return(RetAssetDetailInfo.Factory.parse(reader));

                                        reader.next();
                                    }
                              }  // End of if for expected property start element

                                    else {

                                    }

                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();

                                if (reader.isStartElement())
                                // A start element we are not expecting indicates a trailing invalid property
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());




            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class



        }


        public static class DeleteAsset
        implements org.apache.axis2.databinding.ADBBean{

                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://dam.imc.h3c.com/damAssetService",
                "deleteAsset",
                "ns3");



        public static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://dam.imc.h3c.com/damAssetService")){
                return "ns3";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }



                        /**
                        * field for Param0
                        */


                                    protected long localParam0 ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localParam0Tracker = false ;


                           /**
                           * Auto generated getter method
                           * @return long
                           */
                           public  long getParam0(){
                               return localParam0;
                           }



                            /**
                               * Auto generated setter method
                               * @param param Param0
                               */
                               public void setParam0(long param){

                                       // setting primitive attribute tracker to true

                                               if (param==java.lang.Long.MIN_VALUE) {
                                           localParam0Tracker = false;

                                       } else {
                                          localParam0Tracker = true;
                                       }

                                            this.localParam0=param;


                               }


     /**
     * isReaderMTOMAware
     * @return true if the reader supports MTOM
     */
   public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
        boolean isReaderMTOMAware = false;

        try{
          isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
        }catch(java.lang.IllegalArgumentException e){
          isReaderMTOMAware = false;
        }
        return isReaderMTOMAware;
   }


        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{



                org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,MY_QNAME){

                 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                       DeleteAsset.this.serialize(MY_QNAME,factory,xmlWriter);
                 }
               };
               return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
               MY_QNAME,factory,dataSource);

       }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       final org.apache.axiom.om.OMFactory factory,
                                       org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,factory,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               final org.apache.axiom.om.OMFactory factory,
                               org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{




                java.lang.String prefix = null;
                java.lang.String namespace = null;


                    prefix = parentQName.getPrefix();
                    namespace = parentQName.getNamespaceURI();

                    if ((namespace != null) && (namespace.trim().length() > 0)) {
                        java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                        if (writerPrefix != null) {
                            xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                        } else {
                            if (prefix == null) {
                                prefix = generatePrefix(namespace);
                            }

                            xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                            xmlWriter.writeNamespace(prefix, namespace);
                            xmlWriter.setPrefix(prefix, namespace);
                        }
                    } else {
                        xmlWriter.writeStartElement(parentQName.getLocalPart());
                    }

                  if (serializeType){


                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://dam.imc.h3c.com/damAssetService");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":deleteAsset",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "deleteAsset",
                           xmlWriter);
                   }


                   }
                if (localParam0Tracker){
                                    namespace = "http://dam.imc.h3c.com/damAssetService";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"param0", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"param0");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("param0");
                                    }

                                               if (localParam0==java.lang.Long.MIN_VALUE) {

                                                         throw new org.apache.axis2.databinding.ADBException("param0 cannot be null!!");

                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localParam0));
                                               }

                                   xmlWriter.writeEndElement();
                             }
                    xmlWriter.writeEndElement();


        }

         /**
          * Util method to write an attribute with the ns prefix
          */
          public void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
              if (xmlWriter.getPrefix(namespace) == null) {
                       xmlWriter.writeNamespace(prefix, namespace);
                       xmlWriter.setPrefix(prefix, namespace);

              }

              xmlWriter.writeAttribute(namespace,attName,attValue);

         }

        /**
          * Util method to write an attribute without the ns prefix
          */
          public void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
                if (namespace.equals(""))
              {
                  xmlWriter.writeAttribute(attName,attValue);
              }
              else
              {
                  registerPrefix(xmlWriter, namespace);
                  xmlWriter.writeAttribute(namespace,attName,attValue);
              }
          }


           /**
             * Util method to write an attribute without the ns prefix
             */
            public void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        public void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        public void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


         /**
         * Register a namespace prefix
         */
         public java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                        prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                    }

                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }

                return prefix;
            }



        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{



                 java.util.ArrayList elementList = new java.util.ArrayList();
                 java.util.ArrayList attribList = new java.util.ArrayList();

                 if (localParam0Tracker){
                                      elementList.add(new javax.xml.namespace.QName("http://dam.imc.h3c.com/damAssetService",
                                                                      "param0"));

                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localParam0));
                            }

                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());



        }



     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{




        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static DeleteAsset parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            DeleteAsset object =
                new DeleteAsset();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();


                if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
                  java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                        "type");
                  if (fullTypeName!=null){
                    java.lang.String nsPrefix = null;
                    if (fullTypeName.indexOf(":") > -1){
                        nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
                    }
                    nsPrefix = nsPrefix==null?"":nsPrefix;

                    java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);

                            if (!"deleteAsset".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (DeleteAsset)ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }


                  }


                }




                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();




                    reader.next();


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://dam.imc.h3c.com/damAssetService","param0").equals(reader.getName())){

                                    java.lang.String content = reader.getElementText();

                                              object.setParam0(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToLong(content));

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                               object.setParam0(java.lang.Long.MIN_VALUE);

                                    }

                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();

                                if (reader.isStartElement())
                                // A start element we are not expecting indicates a trailing invalid property
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());




            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class



        }


        public static class QueryAssetDetail
        implements org.apache.axis2.databinding.ADBBean{

                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://dam.imc.h3c.com/damAssetService",
                "queryAssetDetail",
                "ns3");



        public static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://dam.imc.h3c.com/damAssetService")){
                return "ns3";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }



                        /**
                        * field for Param0
                        */


                                    protected long localParam0 ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localParam0Tracker = false ;


                           /**
                           * Auto generated getter method
                           * @return long
                           */
                           public  long getParam0(){
                               return localParam0;
                           }



                            /**
                               * Auto generated setter method
                               * @param param Param0
                               */
                               public void setParam0(long param){

                                       // setting primitive attribute tracker to true

                                               if (param==java.lang.Long.MIN_VALUE) {
                                           localParam0Tracker = false;

                                       } else {
                                          localParam0Tracker = true;
                                       }

                                            this.localParam0=param;


                               }


     /**
     * isReaderMTOMAware
     * @return true if the reader supports MTOM
     */
   public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
        boolean isReaderMTOMAware = false;

        try{
          isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
        }catch(java.lang.IllegalArgumentException e){
          isReaderMTOMAware = false;
        }
        return isReaderMTOMAware;
   }


        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{



                org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,MY_QNAME){

                 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                       QueryAssetDetail.this.serialize(MY_QNAME,factory,xmlWriter);
                 }
               };
               return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
               MY_QNAME,factory,dataSource);

       }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       final org.apache.axiom.om.OMFactory factory,
                                       org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,factory,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               final org.apache.axiom.om.OMFactory factory,
                               org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{




                java.lang.String prefix = null;
                java.lang.String namespace = null;


                    prefix = parentQName.getPrefix();
                    namespace = parentQName.getNamespaceURI();

                    if ((namespace != null) && (namespace.trim().length() > 0)) {
                        java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                        if (writerPrefix != null) {
                            xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                        } else {
                            if (prefix == null) {
                                prefix = generatePrefix(namespace);
                            }

                            xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                            xmlWriter.writeNamespace(prefix, namespace);
                            xmlWriter.setPrefix(prefix, namespace);
                        }
                    } else {
                        xmlWriter.writeStartElement(parentQName.getLocalPart());
                    }

                  if (serializeType){


                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://dam.imc.h3c.com/damAssetService");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":queryAssetDetail",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "queryAssetDetail",
                           xmlWriter);
                   }


                   }
                if (localParam0Tracker){
                                    namespace = "http://dam.imc.h3c.com/damAssetService";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"param0", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"param0");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("param0");
                                    }

                                               if (localParam0==java.lang.Long.MIN_VALUE) {

                                                         throw new org.apache.axis2.databinding.ADBException("param0 cannot be null!!");

                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localParam0));
                                               }

                                   xmlWriter.writeEndElement();
                             }
                    xmlWriter.writeEndElement();


        }

         /**
          * Util method to write an attribute with the ns prefix
          */
          public void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
              if (xmlWriter.getPrefix(namespace) == null) {
                       xmlWriter.writeNamespace(prefix, namespace);
                       xmlWriter.setPrefix(prefix, namespace);

              }

              xmlWriter.writeAttribute(namespace,attName,attValue);

         }

        /**
          * Util method to write an attribute without the ns prefix
          */
          public void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
                if (namespace.equals(""))
              {
                  xmlWriter.writeAttribute(attName,attValue);
              }
              else
              {
                  registerPrefix(xmlWriter, namespace);
                  xmlWriter.writeAttribute(namespace,attName,attValue);
              }
          }


           /**
             * Util method to write an attribute without the ns prefix
             */
            public void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        public void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        public void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


         /**
         * Register a namespace prefix
         */
         public java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                        prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                    }

                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }

                return prefix;
            }



        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{



                 java.util.ArrayList elementList = new java.util.ArrayList();
                 java.util.ArrayList attribList = new java.util.ArrayList();

                 if (localParam0Tracker){
                                      elementList.add(new javax.xml.namespace.QName("http://dam.imc.h3c.com/damAssetService",
                                                                      "param0"));

                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localParam0));
                            }

                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());



        }



     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{




        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static QueryAssetDetail parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            QueryAssetDetail object =
                new QueryAssetDetail();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();


                if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
                  java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                        "type");
                  if (fullTypeName!=null){
                    java.lang.String nsPrefix = null;
                    if (fullTypeName.indexOf(":") > -1){
                        nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
                    }
                    nsPrefix = nsPrefix==null?"":nsPrefix;

                    java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);

                            if (!"queryAssetDetail".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (QueryAssetDetail)ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }


                  }


                }




                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();




                    reader.next();


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://dam.imc.h3c.com/damAssetService","param0").equals(reader.getName())){

                                    java.lang.String content = reader.getElementText();

                                              object.setParam0(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToLong(content));

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                               object.setParam0(java.lang.Long.MIN_VALUE);

                                    }

                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();

                                if (reader.isStartElement())
                                // A start element we are not expecting indicates a trailing invalid property
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());




            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class



        }


        public static class AddAssetInfo
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = AddAssetInfo
                Namespace URI = http://asset.damws.imc.h3c.com/xsd
                Namespace Prefix = ns2
                */


        public static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://asset.damws.imc.h3c.com/xsd")){
                return "ns2";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }



                        /**
                        * field for AssetName
                        */


                                    protected java.lang.String localAssetName ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAssetNameTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getAssetName(){
                               return localAssetName;
                           }



                            /**
                               * Auto generated setter method
                               * @param param AssetName
                               */
                               public void setAssetName(java.lang.String param){

                                       if (param != null){
                                          //update the setting tracker
                                          localAssetNameTracker = true;
                                       } else {
                                          localAssetNameTracker = true;

                                       }

                                            this.localAssetName=param;


                               }


                        /**
                        * field for AssetNumber
                        */


                                    protected java.lang.String localAssetNumber ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAssetNumberTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getAssetNumber(){
                               return localAssetNumber;
                           }



                            /**
                               * Auto generated setter method
                               * @param param AssetNumber
                               */
                               public void setAssetNumber(java.lang.String param){

                                       if (param != null){
                                          //update the setting tracker
                                          localAssetNumberTracker = true;
                                       } else {
                                          localAssetNumberTracker = true;

                                       }

                                            this.localAssetNumber=param;


                               }


                        /**
                        * field for ComputerType
                        */


                                    protected java.lang.String localComputerType ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localComputerTypeTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getComputerType(){
                               return localComputerType;
                           }



                            /**
                               * Auto generated setter method
                               * @param param ComputerType
                               */
                               public void setComputerType(java.lang.String param){

                                       if (param != null){
                                          //update the setting tracker
                                          localComputerTypeTracker = true;
                                       } else {
                                          localComputerTypeTracker = true;

                                       }

                                            this.localComputerType=param;


                               }


                        /**
                        * field for ComputerVariety
                        */


                                    protected java.lang.String localComputerVariety ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localComputerVarietyTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getComputerVariety(){
                               return localComputerVariety;
                           }



                            /**
                               * Auto generated setter method
                               * @param param ComputerVariety
                               */
                               public void setComputerVariety(java.lang.String param){

                                       if (param != null){
                                          //update the setting tracker
                                          localComputerVarietyTracker = true;
                                       } else {
                                          localComputerVarietyTracker = true;

                                       }

                                            this.localComputerVariety=param;


                               }


                        /**
                        * field for GroupId
                        */


                                    protected long localGroupId ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localGroupIdTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return long
                           */
                           public  long getGroupId(){
                               return localGroupId;
                           }



                            /**
                               * Auto generated setter method
                               * @param param GroupId
                               */
                               public void setGroupId(long param){

                                       // setting primitive attribute tracker to true

                                               if (param==java.lang.Long.MIN_VALUE) {
                                           localGroupIdTracker = true;

                                       } else {
                                          localGroupIdTracker = true;
                                       }

                                            this.localGroupId=param;


                               }


                        /**
                        * field for PhysicalPos
                        */


                                    protected java.lang.String localPhysicalPos ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPhysicalPosTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getPhysicalPos(){
                               return localPhysicalPos;
                           }



                            /**
                               * Auto generated setter method
                               * @param param PhysicalPos
                               */
                               public void setPhysicalPos(java.lang.String param){

                                       if (param != null){
                                          //update the setting tracker
                                          localPhysicalPosTracker = true;
                                       } else {
                                          localPhysicalPosTracker = true;

                                       }

                                            this.localPhysicalPos=param;


                               }


                        /**
                        * field for Remark
                        */


                                    protected java.lang.String localRemark ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localRemarkTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getRemark(){
                               return localRemark;
                           }



                            /**
                               * Auto generated setter method
                               * @param param Remark
                               */
                               public void setRemark(java.lang.String param){

                                       if (param != null){
                                          //update the setting tracker
                                          localRemarkTracker = true;
                                       } else {
                                          localRemarkTracker = true;

                                       }

                                            this.localRemark=param;


                               }


                        /**
                        * field for ResponserId
                        */


                                    protected long localResponserId ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localResponserIdTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return long
                           */
                           public  long getResponserId(){
                               return localResponserId;
                           }



                            /**
                               * Auto generated setter method
                               * @param param ResponserId
                               */
                               public void setResponserId(long param){

                                       // setting primitive attribute tracker to true

                                               if (param==java.lang.Long.MIN_VALUE) {
                                           localResponserIdTracker = true;

                                       } else {
                                          localResponserIdTracker = true;
                                       }

                                            this.localResponserId=param;


                               }


                        /**
                        * field for SerialVersionUID
                        */


                                    protected long localSerialVersionUID ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localSerialVersionUIDTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return long
                           */
                           public  long getSerialVersionUID(){
                               return localSerialVersionUID;
                           }



                            /**
                               * Auto generated setter method
                               * @param param SerialVersionUID
                               */
                               public void setSerialVersionUID(long param){

                                       // setting primitive attribute tracker to true

                                               if (param==java.lang.Long.MIN_VALUE) {
                                           localSerialVersionUIDTracker = false;

                                       } else {
                                          localSerialVersionUIDTracker = true;
                                       }

                                            this.localSerialVersionUID=param;


                               }


                        /**
                        * field for Type
                        */


                                    protected java.lang.String localType ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localTypeTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getType(){
                               return localType;
                           }



                            /**
                               * Auto generated setter method
                               * @param param Type
                               */
                               public void setType(java.lang.String param){

                                       if (param != null){
                                          //update the setting tracker
                                          localTypeTracker = true;
                                       } else {
                                          localTypeTracker = true;

                                       }

                                            this.localType=param;


                               }


     /**
     * isReaderMTOMAware
     * @return true if the reader supports MTOM
     */
   public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
        boolean isReaderMTOMAware = false;

        try{
          isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
        }catch(java.lang.IllegalArgumentException e){
          isReaderMTOMAware = false;
        }
        return isReaderMTOMAware;
   }


        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{



               org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,parentQName){

                 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                       AddAssetInfo.this.serialize(parentQName,factory,xmlWriter);
                 }
               };
               return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
               parentQName,factory,dataSource);

       }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       final org.apache.axiom.om.OMFactory factory,
                                       org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,factory,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               final org.apache.axiom.om.OMFactory factory,
                               org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{




                java.lang.String prefix = null;
                java.lang.String namespace = null;


                    prefix = parentQName.getPrefix();
                    namespace = parentQName.getNamespaceURI();

                    if ((namespace != null) && (namespace.trim().length() > 0)) {
                        java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                        if (writerPrefix != null) {
                            xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                        } else {
                            if (prefix == null) {
                                prefix = generatePrefix(namespace);
                            }

                            xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                            xmlWriter.writeNamespace(prefix, namespace);
                            xmlWriter.setPrefix(prefix, namespace);
                        }
                    } else {
                        xmlWriter.writeStartElement(parentQName.getLocalPart());
                    }

                  if (serializeType){


                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://asset.damws.imc.h3c.com/xsd");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":AddAssetInfo",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "AddAssetInfo",
                           xmlWriter);
                   }


                   }
                if (localAssetNameTracker){
                                    namespace = "http://asset.damws.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"assetName", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"assetName");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("assetName");
                                    }


                                          if (localAssetName==null){
                                              // write the nil attribute

                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                          }else{


                                                   xmlWriter.writeCharacters(localAssetName);

                                          }

                                   xmlWriter.writeEndElement();
                             } if (localAssetNumberTracker){
                                    namespace = "http://asset.damws.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"assetNumber", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"assetNumber");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("assetNumber");
                                    }


                                          if (localAssetNumber==null){
                                              // write the nil attribute

                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                          }else{


                                                   xmlWriter.writeCharacters(localAssetNumber);

                                          }

                                   xmlWriter.writeEndElement();
                             } if (localComputerTypeTracker){
                                    namespace = "http://asset.damws.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"computerType", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"computerType");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("computerType");
                                    }


                                          if (localComputerType==null){
                                              // write the nil attribute

                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                          }else{


                                                   xmlWriter.writeCharacters(localComputerType);

                                          }

                                   xmlWriter.writeEndElement();
                             } if (localComputerVarietyTracker){
                                    namespace = "http://asset.damws.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"computerVariety", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"computerVariety");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("computerVariety");
                                    }


                                          if (localComputerVariety==null){
                                              // write the nil attribute

                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                          }else{


                                                   xmlWriter.writeCharacters(localComputerVariety);

                                          }

                                   xmlWriter.writeEndElement();
                             } if (localGroupIdTracker){
                                    namespace = "http://asset.damws.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"groupId", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"groupId");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("groupId");
                                    }

                                               if (localGroupId==java.lang.Long.MIN_VALUE) {

                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localGroupId));
                                               }

                                   xmlWriter.writeEndElement();
                             } if (localPhysicalPosTracker){
                                    namespace = "http://asset.damws.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"physicalPos", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"physicalPos");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("physicalPos");
                                    }


                                          if (localPhysicalPos==null){
                                              // write the nil attribute

                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                          }else{


                                                   xmlWriter.writeCharacters(localPhysicalPos);

                                          }

                                   xmlWriter.writeEndElement();
                             } if (localRemarkTracker){
                                    namespace = "http://asset.damws.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"remark", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"remark");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("remark");
                                    }


                                          if (localRemark==null){
                                              // write the nil attribute

                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                          }else{


                                                   xmlWriter.writeCharacters(localRemark);

                                          }

                                   xmlWriter.writeEndElement();
                             } if (localResponserIdTracker){
                                    namespace = "http://asset.damws.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"responserId", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"responserId");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("responserId");
                                    }

                                               if (localResponserId==java.lang.Long.MIN_VALUE) {

                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localResponserId));
                                               }

                                   xmlWriter.writeEndElement();
                             } if (localSerialVersionUIDTracker){
                                    namespace = "http://asset.damws.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"serialVersionUID", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"serialVersionUID");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("serialVersionUID");
                                    }

                                               if (localSerialVersionUID==java.lang.Long.MIN_VALUE) {

                                                         throw new org.apache.axis2.databinding.ADBException("serialVersionUID cannot be null!!");

                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSerialVersionUID));
                                               }

                                   xmlWriter.writeEndElement();
                             } if (localTypeTracker){
                                    namespace = "http://asset.damws.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"type", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"type");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("type");
                                    }


                                          if (localType==null){
                                              // write the nil attribute

                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                          }else{


                                                   xmlWriter.writeCharacters(localType);

                                          }

                                   xmlWriter.writeEndElement();
                             }
                    xmlWriter.writeEndElement();


        }

         /**
          * Util method to write an attribute with the ns prefix
          */
          public void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
              if (xmlWriter.getPrefix(namespace) == null) {
                       xmlWriter.writeNamespace(prefix, namespace);
                       xmlWriter.setPrefix(prefix, namespace);

              }

              xmlWriter.writeAttribute(namespace,attName,attValue);

         }

        /**
          * Util method to write an attribute without the ns prefix
          */
          public void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
                if (namespace.equals(""))
              {
                  xmlWriter.writeAttribute(attName,attValue);
              }
              else
              {
                  registerPrefix(xmlWriter, namespace);
                  xmlWriter.writeAttribute(namespace,attName,attValue);
              }
          }


           /**
             * Util method to write an attribute without the ns prefix
             */
            public void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        public void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        public void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


         /**
         * Register a namespace prefix
         */
         public java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                        prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                    }

                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }

                return prefix;
            }



        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{



                 java.util.ArrayList elementList = new java.util.ArrayList();
                 java.util.ArrayList attribList = new java.util.ArrayList();

                 if (localAssetNameTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                      "assetName"));

                                         elementList.add(localAssetName==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAssetName));
                                    } if (localAssetNumberTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                      "assetNumber"));

                                         elementList.add(localAssetNumber==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAssetNumber));
                                    } if (localComputerTypeTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                      "computerType"));

                                         elementList.add(localComputerType==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localComputerType));
                                    } if (localComputerVarietyTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                      "computerVariety"));

                                         elementList.add(localComputerVariety==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localComputerVariety));
                                    } if (localGroupIdTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                      "groupId"));

                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localGroupId));
                            } if (localPhysicalPosTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                      "physicalPos"));

                                         elementList.add(localPhysicalPos==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPhysicalPos));
                                    } if (localRemarkTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                      "remark"));

                                         elementList.add(localRemark==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRemark));
                                    } if (localResponserIdTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                      "responserId"));

                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localResponserId));
                            } if (localSerialVersionUIDTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                      "serialVersionUID"));

                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSerialVersionUID));
                            } if (localTypeTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                      "type"));

                                         elementList.add(localType==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localType));
                                    }

                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());



        }



     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{




        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static AddAssetInfo parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            AddAssetInfo object =
                new AddAssetInfo();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();


                if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
                  java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                        "type");
                  if (fullTypeName!=null){
                    java.lang.String nsPrefix = null;
                    if (fullTypeName.indexOf(":") > -1){
                        nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
                    }
                    nsPrefix = nsPrefix==null?"":nsPrefix;

                    java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);

                            if (!"AddAssetInfo".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (AddAssetInfo)ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }


                  }


                }




                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();




                    reader.next();


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","assetName").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setAssetName(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                                       } else {


                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","assetNumber").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setAssetNumber(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                                       } else {


                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","computerType").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setComputerType(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                                       } else {


                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","computerVariety").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setComputerVariety(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                                       } else {


                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","groupId").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setGroupId(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToLong(content));

                                       } else {


                                                   object.setGroupId(java.lang.Long.MIN_VALUE);

                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                               object.setGroupId(java.lang.Long.MIN_VALUE);

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","physicalPos").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setPhysicalPos(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                                       } else {


                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","remark").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setRemark(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                                       } else {


                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","responserId").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setResponserId(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToLong(content));

                                       } else {


                                                   object.setResponserId(java.lang.Long.MIN_VALUE);

                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                               object.setResponserId(java.lang.Long.MIN_VALUE);

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","serialVersionUID").equals(reader.getName())){

                                    java.lang.String content = reader.getElementText();

                                              object.setSerialVersionUID(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToLong(content));

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                               object.setSerialVersionUID(java.lang.Long.MIN_VALUE);

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","type").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setType(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                                       } else {


                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                    }

                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();

                                if (reader.isStartElement())
                                // A start element we are not expecting indicates a trailing invalid property
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());




            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class



        }


        public static class ModifyAssetResponse
        implements org.apache.axis2.databinding.ADBBean{

                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://dam.imc.h3c.com/damAssetService",
                "modifyAssetResponse",
                "ns3");



        public static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://dam.imc.h3c.com/damAssetService")){
                return "ns3";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }



                        /**
                        * field for _return
                        */


                                    protected WSCommonResult local_return ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean local_returnTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return WSCommonResult
                           */
                           public  WSCommonResult get_return(){
                               return local_return;
                           }



                            /**
                               * Auto generated setter method
                               * @param param _return
                               */
                               public void set_return(WSCommonResult param){

                                       if (param != null){
                                          //update the setting tracker
                                          local_returnTracker = true;
                                       } else {
                                          local_returnTracker = true;

                                       }

                                            this.local_return=param;


                               }


     /**
     * isReaderMTOMAware
     * @return true if the reader supports MTOM
     */
   public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
        boolean isReaderMTOMAware = false;

        try{
          isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
        }catch(java.lang.IllegalArgumentException e){
          isReaderMTOMAware = false;
        }
        return isReaderMTOMAware;
   }


        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{



                org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,MY_QNAME){

                 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                       ModifyAssetResponse.this.serialize(MY_QNAME,factory,xmlWriter);
                 }
               };
               return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
               MY_QNAME,factory,dataSource);

       }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       final org.apache.axiom.om.OMFactory factory,
                                       org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,factory,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               final org.apache.axiom.om.OMFactory factory,
                               org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{




                java.lang.String prefix = null;
                java.lang.String namespace = null;


                    prefix = parentQName.getPrefix();
                    namespace = parentQName.getNamespaceURI();

                    if ((namespace != null) && (namespace.trim().length() > 0)) {
                        java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                        if (writerPrefix != null) {
                            xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                        } else {
                            if (prefix == null) {
                                prefix = generatePrefix(namespace);
                            }

                            xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                            xmlWriter.writeNamespace(prefix, namespace);
                            xmlWriter.setPrefix(prefix, namespace);
                        }
                    } else {
                        xmlWriter.writeStartElement(parentQName.getLocalPart());
                    }

                  if (serializeType){


                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://dam.imc.h3c.com/damAssetService");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":modifyAssetResponse",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "modifyAssetResponse",
                           xmlWriter);
                   }


                   }
                if (local_returnTracker){
                                    if (local_return==null){

                                            java.lang.String namespace2 = "http://dam.imc.h3c.com/damAssetService";

                                        if (! namespace2.equals("")) {
                                            java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                                            if (prefix2 == null) {
                                                prefix2 = generatePrefix(namespace2);

                                                xmlWriter.writeStartElement(prefix2,"return", namespace2);
                                                xmlWriter.writeNamespace(prefix2, namespace2);
                                                xmlWriter.setPrefix(prefix2, namespace2);

                                            } else {
                                                xmlWriter.writeStartElement(namespace2,"return");
                                            }

                                        } else {
                                            xmlWriter.writeStartElement("return");
                                        }


                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     local_return.serialize(new javax.xml.namespace.QName("http://dam.imc.h3c.com/damAssetService","return"),
                                        factory,xmlWriter);
                                    }
                                }
                    xmlWriter.writeEndElement();


        }

         /**
          * Util method to write an attribute with the ns prefix
          */
          public void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
              if (xmlWriter.getPrefix(namespace) == null) {
                       xmlWriter.writeNamespace(prefix, namespace);
                       xmlWriter.setPrefix(prefix, namespace);

              }

              xmlWriter.writeAttribute(namespace,attName,attValue);

         }

        /**
          * Util method to write an attribute without the ns prefix
          */
          public void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
                if (namespace.equals(""))
              {
                  xmlWriter.writeAttribute(attName,attValue);
              }
              else
              {
                  registerPrefix(xmlWriter, namespace);
                  xmlWriter.writeAttribute(namespace,attName,attValue);
              }
          }


           /**
             * Util method to write an attribute without the ns prefix
             */
            public void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        public void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        public void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


         /**
         * Register a namespace prefix
         */
         public java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                        prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                    }

                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }

                return prefix;
            }



        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{



                 java.util.ArrayList elementList = new java.util.ArrayList();
                 java.util.ArrayList attribList = new java.util.ArrayList();

                 if (local_returnTracker){
                            elementList.add(new javax.xml.namespace.QName("http://dam.imc.h3c.com/damAssetService",
                                                                      "return"));


                                    elementList.add(local_return==null?null:
                                    local_return);
                                }

                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());



        }



     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{




        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static ModifyAssetResponse parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            ModifyAssetResponse object =
                new ModifyAssetResponse();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();


                if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
                  java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                        "type");
                  if (fullTypeName!=null){
                    java.lang.String nsPrefix = null;
                    if (fullTypeName.indexOf(":") > -1){
                        nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
                    }
                    nsPrefix = nsPrefix==null?"":nsPrefix;

                    java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);

                            if (!"modifyAssetResponse".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (ModifyAssetResponse)ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }


                  }


                }




                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();




                    reader.next();


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://dam.imc.h3c.com/damAssetService","return").equals(reader.getName())){

                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.set_return(null);
                                          reader.next();

                                            reader.next();

                                      }else{

                                                object.set_return(WSCommonResult.Factory.parse(reader));

                                        reader.next();
                                    }
                              }  // End of if for expected property start element

                                    else {

                                    }

                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();

                                if (reader.isStartElement())
                                // A start element we are not expecting indicates a trailing invalid property
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());




            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class



        }


        public static class RetAssetGroupInfoList extends WSCommonResult
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = RetAssetGroupInfoList
                Namespace URI = http://asset.damws.imc.h3c.com/xsd
                Namespace Prefix = ns2
                */


        public static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://asset.damws.imc.h3c.com/xsd")){
                return "ns2";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }



                        /**
                        * field for RetAssetGroupInfoList
                        * This was an Array!
                        */


                                    protected RetAssetGroupInfo[] localRetAssetGroupInfoList ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localRetAssetGroupInfoListTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return RetAssetGroupInfo[]
                           */
                           public  RetAssetGroupInfo[] getRetAssetGroupInfoList(){
                               return localRetAssetGroupInfoList;
                           }






                              /**
                               * validate the array for RetAssetGroupInfoList
                               */
                              protected void validateRetAssetGroupInfoList(RetAssetGroupInfo[] param){

                              }


                             /**
                              * Auto generated setter method
                              * @param param RetAssetGroupInfoList
                              */
                              public void setRetAssetGroupInfoList(RetAssetGroupInfo[] param){

                                   validateRetAssetGroupInfoList(param);


                                          if (param != null){
                                             //update the setting tracker
                                             localRetAssetGroupInfoListTracker = true;
                                          } else {
                                             localRetAssetGroupInfoListTracker = true;

                                          }

                                      this.localRetAssetGroupInfoList=param;
                              }



                             /**
                             * Auto generated add method for the array for convenience
                             * @param param RetAssetGroupInfo
                             */
                             public void addRetAssetGroupInfoList(RetAssetGroupInfo param){
                                   if (localRetAssetGroupInfoList == null){
                                   localRetAssetGroupInfoList = new RetAssetGroupInfo[]{};
                                   }


                                 //update the setting tracker
                                localRetAssetGroupInfoListTracker = true;


                               java.util.List list =
                            org.apache.axis2.databinding.utils.ConverterUtil.toList(localRetAssetGroupInfoList);
                               list.add(param);
                               this.localRetAssetGroupInfoList =
                             (RetAssetGroupInfo[])list.toArray(
                            new RetAssetGroupInfo[list.size()]);

                             }


     /**
     * isReaderMTOMAware
     * @return true if the reader supports MTOM
     */
   public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
        boolean isReaderMTOMAware = false;

        try{
          isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
        }catch(java.lang.IllegalArgumentException e){
          isReaderMTOMAware = false;
        }
        return isReaderMTOMAware;
   }


        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{



               org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,parentQName){

                 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                       RetAssetGroupInfoList.this.serialize(parentQName,factory,xmlWriter);
                 }
               };
               return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
               parentQName,factory,dataSource);

       }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       final org.apache.axiom.om.OMFactory factory,
                                       org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,factory,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               final org.apache.axiom.om.OMFactory factory,
                               org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{




                java.lang.String prefix = null;
                java.lang.String namespace = null;


                    prefix = parentQName.getPrefix();
                    namespace = parentQName.getNamespaceURI();

                    if ((namespace != null) && (namespace.trim().length() > 0)) {
                        java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                        if (writerPrefix != null) {
                            xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                        } else {
                            if (prefix == null) {
                                prefix = generatePrefix(namespace);
                            }

                            xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                            xmlWriter.writeNamespace(prefix, namespace);
                            xmlWriter.setPrefix(prefix, namespace);
                        }
                    } else {
                        xmlWriter.writeStartElement(parentQName.getLocalPart());
                    }


                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://asset.damws.imc.h3c.com/xsd");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":RetAssetGroupInfoList",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "RetAssetGroupInfoList",
                           xmlWriter);
                   }

                if (localDescriptionTracker){
                                    namespace = "http://ws.common.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"description", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"description");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("description");
                                    }


                                          if (localDescription==null){
                                              // write the nil attribute

                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                          }else{


                                                   xmlWriter.writeCharacters(localDescription);

                                          }

                                   xmlWriter.writeEndElement();
                             } if (localErrorCodeTracker){
                                    namespace = "http://ws.common.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"errorCode", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"errorCode");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("errorCode");
                                    }

                                               if (localErrorCode==java.lang.Integer.MIN_VALUE) {

                                                         throw new org.apache.axis2.databinding.ADBException("errorCode cannot be null!!");

                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localErrorCode));
                                               }

                                   xmlWriter.writeEndElement();
                             } if (localErrorMsgTracker){
                                    namespace = "http://ws.common.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"errorMsg", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"errorMsg");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("errorMsg");
                                    }


                                          if (localErrorMsg==null){
                                              // write the nil attribute

                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                          }else{


                                                   xmlWriter.writeCharacters(localErrorMsg);

                                          }

                                   xmlWriter.writeEndElement();
                             } if (localRetAssetGroupInfoListTracker){
                                       if (localRetAssetGroupInfoList!=null){
                                            for (int i = 0;i < localRetAssetGroupInfoList.length;i++){
                                                if (localRetAssetGroupInfoList[i] != null){
                                                 localRetAssetGroupInfoList[i].serialize(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","retAssetGroupInfoList"),
                                                           factory,xmlWriter);
                                                } else {

                                                            // write null attribute
                                                            java.lang.String namespace2 = "http://asset.damws.imc.h3c.com/xsd";
                                                            if (! namespace2.equals("")) {
                                                                java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                                                                if (prefix2 == null) {
                                                                    prefix2 = generatePrefix(namespace2);

                                                                    xmlWriter.writeStartElement(prefix2,"retAssetGroupInfoList", namespace2);
                                                                    xmlWriter.writeNamespace(prefix2, namespace2);
                                                                    xmlWriter.setPrefix(prefix2, namespace2);

                                                                } else {
                                                                    xmlWriter.writeStartElement(namespace2,"retAssetGroupInfoList");
                                                                }

                                                            } else {
                                                                xmlWriter.writeStartElement("retAssetGroupInfoList");
                                                            }

                                                           // write the nil attribute
                                                           writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                           xmlWriter.writeEndElement();

                                                }

                                            }
                                     } else {

                                                // write null attribute
                                                java.lang.String namespace2 = "http://asset.damws.imc.h3c.com/xsd";
                                                if (! namespace2.equals("")) {
                                                    java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                                                    if (prefix2 == null) {
                                                        prefix2 = generatePrefix(namespace2);

                                                        xmlWriter.writeStartElement(prefix2,"retAssetGroupInfoList", namespace2);
                                                        xmlWriter.writeNamespace(prefix2, namespace2);
                                                        xmlWriter.setPrefix(prefix2, namespace2);

                                                    } else {
                                                        xmlWriter.writeStartElement(namespace2,"retAssetGroupInfoList");
                                                    }

                                                } else {
                                                    xmlWriter.writeStartElement("retAssetGroupInfoList");
                                                }

                                               // write the nil attribute
                                               writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                               xmlWriter.writeEndElement();

                                    }
                                 }
                    xmlWriter.writeEndElement();


        }

         /**
          * Util method to write an attribute with the ns prefix
          */
          public void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
              if (xmlWriter.getPrefix(namespace) == null) {
                       xmlWriter.writeNamespace(prefix, namespace);
                       xmlWriter.setPrefix(prefix, namespace);

              }

              xmlWriter.writeAttribute(namespace,attName,attValue);

         }

        /**
          * Util method to write an attribute without the ns prefix
          */
          public void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
                if (namespace.equals(""))
              {
                  xmlWriter.writeAttribute(attName,attValue);
              }
              else
              {
                  registerPrefix(xmlWriter, namespace);
                  xmlWriter.writeAttribute(namespace,attName,attValue);
              }
          }


           /**
             * Util method to write an attribute without the ns prefix
             */
            public void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        public void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        public void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


         /**
         * Register a namespace prefix
         */
         public java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                        prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                    }

                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }

                return prefix;
            }



        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{



                 java.util.ArrayList elementList = new java.util.ArrayList();
                 java.util.ArrayList attribList = new java.util.ArrayList();


                    attribList.add(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema-instance","type"));
                    attribList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","RetAssetGroupInfoList"));
                 if (localDescriptionTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://ws.common.imc.h3c.com/xsd",
                                                                      "description"));

                                         elementList.add(localDescription==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDescription));
                                    } if (localErrorCodeTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://ws.common.imc.h3c.com/xsd",
                                                                      "errorCode"));

                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localErrorCode));
                            } if (localErrorMsgTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://ws.common.imc.h3c.com/xsd",
                                                                      "errorMsg"));

                                         elementList.add(localErrorMsg==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localErrorMsg));
                                    } if (localRetAssetGroupInfoListTracker){
                             if (localRetAssetGroupInfoList!=null) {
                                 for (int i = 0;i < localRetAssetGroupInfoList.length;i++){

                                    if (localRetAssetGroupInfoList[i] != null){
                                         elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                          "retAssetGroupInfoList"));
                                         elementList.add(localRetAssetGroupInfoList[i]);
                                    } else {

                                                elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                          "retAssetGroupInfoList"));
                                                elementList.add(null);

                                    }

                                 }
                             } else {

                                        elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                          "retAssetGroupInfoList"));
                                        elementList.add(localRetAssetGroupInfoList);

                             }

                        }

                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());



        }



     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{




        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static RetAssetGroupInfoList parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            RetAssetGroupInfoList object =
                new RetAssetGroupInfoList();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();


                if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
                  java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                        "type");
                  if (fullTypeName!=null){
                    java.lang.String nsPrefix = null;
                    if (fullTypeName.indexOf(":") > -1){
                        nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
                    }
                    nsPrefix = nsPrefix==null?"":nsPrefix;

                    java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);

                            if (!"RetAssetGroupInfoList".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (RetAssetGroupInfoList)ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }


                  }


                }




                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();




                    reader.next();

                        java.util.ArrayList list4 = new java.util.ArrayList();


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.common.imc.h3c.com/xsd","description").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setDescription(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                                       } else {


                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.common.imc.h3c.com/xsd","errorCode").equals(reader.getName())){

                                    java.lang.String content = reader.getElementText();

                                              object.setErrorCode(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                               object.setErrorCode(java.lang.Integer.MIN_VALUE);

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.common.imc.h3c.com/xsd","errorMsg").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setErrorMsg(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                                       } else {


                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","retAssetGroupInfoList").equals(reader.getName())){



                                    // Process the array and step past its final element's end.

                                                          nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                                          if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                                              list4.add(null);
                                                              reader.next();
                                                          } else {
                                                        list4.add(RetAssetGroupInfo.Factory.parse(reader));
                                                                }
                                                        //loop until we find a start element that is not part of this array
                                                        boolean loopDone4 = false;
                                                        while(!loopDone4){
                                                            // We should be at the end element, but make sure
                                                            while (!reader.isEndElement())
                                                                reader.next();
                                                            // Step out of this element
                                                            reader.next();
                                                            // Step to next element event.
                                                            while (!reader.isStartElement() && !reader.isEndElement())
                                                                reader.next();
                                                            if (reader.isEndElement()){
                                                                //two continuous end elements means we are exiting the xml structure
                                                                loopDone4 = true;
                                                            } else {
                                                                if (new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","retAssetGroupInfoList").equals(reader.getName())){

                                                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                                                          list4.add(null);
                                                                          reader.next();
                                                                      } else {
                                                                    list4.add(RetAssetGroupInfo.Factory.parse(reader));
                                                                        }
                                                                }else{
                                                                    loopDone4 = true;
                                                                }
                                                            }
                                                        }
                                                        // call the converter utility  to convert and set the array

                                                        object.setRetAssetGroupInfoList((RetAssetGroupInfo[])
                                                            org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                                                RetAssetGroupInfo.class,
                                                                list4));

                              }  // End of if for expected property start element

                                    else {

                                    }

                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();

                                if (reader.isStartElement())
                                // A start element we are not expecting indicates a trailing invalid property
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());




            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class



        }


        public static class RetAssetDetailInfo extends WSCommonResult
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = RetAssetDetailInfo
                Namespace URI = http://asset.damws.imc.h3c.com/xsd
                Namespace Prefix = ns2
                */


        public static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://asset.damws.imc.h3c.com/xsd")){
                return "ns2";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }



                        /**
                        * field for AssetName
                        */


                                    protected java.lang.String localAssetName ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAssetNameTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getAssetName(){
                               return localAssetName;
                           }



                            /**
                               * Auto generated setter method
                               * @param param AssetName
                               */
                               public void setAssetName(java.lang.String param){

                                       if (param != null){
                                          //update the setting tracker
                                          localAssetNameTracker = true;
                                       } else {
                                          localAssetNameTracker = true;

                                       }

                                            this.localAssetName=param;


                               }


                        /**
                        * field for AssetNumber
                        */


                                    protected java.lang.String localAssetNumber ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAssetNumberTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getAssetNumber(){
                               return localAssetNumber;
                           }



                            /**
                               * Auto generated setter method
                               * @param param AssetNumber
                               */
                               public void setAssetNumber(java.lang.String param){

                                       if (param != null){
                                          //update the setting tracker
                                          localAssetNumberTracker = true;
                                       } else {
                                          localAssetNumberTracker = true;

                                       }

                                            this.localAssetNumber=param;


                               }


                        /**
                        * field for ComputerType
                        */


                                    protected java.lang.String localComputerType ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localComputerTypeTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getComputerType(){
                               return localComputerType;
                           }



                            /**
                               * Auto generated setter method
                               * @param param ComputerType
                               */
                               public void setComputerType(java.lang.String param){

                                       if (param != null){
                                          //update the setting tracker
                                          localComputerTypeTracker = true;
                                       } else {
                                          localComputerTypeTracker = true;

                                       }

                                            this.localComputerType=param;


                               }


                        /**
                        * field for ComputerVariety
                        */


                                    protected java.lang.String localComputerVariety ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localComputerVarietyTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getComputerVariety(){
                               return localComputerVariety;
                           }



                            /**
                               * Auto generated setter method
                               * @param param ComputerVariety
                               */
                               public void setComputerVariety(java.lang.String param){

                                       if (param != null){
                                          //update the setting tracker
                                          localComputerVarietyTracker = true;
                                       } else {
                                          localComputerVarietyTracker = true;

                                       }

                                            this.localComputerVariety=param;


                               }


                        /**
                        * field for GroupName
                        */


                                    protected java.lang.String localGroupName ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localGroupNameTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getGroupName(){
                               return localGroupName;
                           }



                            /**
                               * Auto generated setter method
                               * @param param GroupName
                               */
                               public void setGroupName(java.lang.String param){

                                       if (param != null){
                                          //update the setting tracker
                                          localGroupNameTracker = true;
                                       } else {
                                          localGroupNameTracker = true;

                                       }

                                            this.localGroupName=param;


                               }


                        /**
                        * field for PhysicalPos
                        */


                                    protected java.lang.String localPhysicalPos ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPhysicalPosTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getPhysicalPos(){
                               return localPhysicalPos;
                           }



                            /**
                               * Auto generated setter method
                               * @param param PhysicalPos
                               */
                               public void setPhysicalPos(java.lang.String param){

                                       if (param != null){
                                          //update the setting tracker
                                          localPhysicalPosTracker = true;
                                       } else {
                                          localPhysicalPosTracker = true;

                                       }

                                            this.localPhysicalPos=param;


                               }


                        /**
                        * field for Remark
                        */


                                    protected java.lang.String localRemark ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localRemarkTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getRemark(){
                               return localRemark;
                           }



                            /**
                               * Auto generated setter method
                               * @param param Remark
                               */
                               public void setRemark(java.lang.String param){

                                       if (param != null){
                                          //update the setting tracker
                                          localRemarkTracker = true;
                                       } else {
                                          localRemarkTracker = true;

                                       }

                                            this.localRemark=param;


                               }


                        /**
                        * field for ResponserId
                        */


                                    protected long localResponserId ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localResponserIdTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return long
                           */
                           public  long getResponserId(){
                               return localResponserId;
                           }



                            /**
                               * Auto generated setter method
                               * @param param ResponserId
                               */
                               public void setResponserId(long param){

                                       // setting primitive attribute tracker to true

                                               if (param==java.lang.Long.MIN_VALUE) {
                                           localResponserIdTracker = false;

                                       } else {
                                          localResponserIdTracker = true;
                                       }

                                            this.localResponserId=param;


                               }


                        /**
                        * field for ResponserName
                        */


                                    protected java.lang.String localResponserName ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localResponserNameTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getResponserName(){
                               return localResponserName;
                           }



                            /**
                               * Auto generated setter method
                               * @param param ResponserName
                               */
                               public void setResponserName(java.lang.String param){

                                       if (param != null){
                                          //update the setting tracker
                                          localResponserNameTracker = true;
                                       } else {
                                          localResponserNameTracker = true;

                                       }

                                            this.localResponserName=param;


                               }


                        /**
                        * field for Type
                        */


                                    protected java.lang.String localType ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localTypeTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getType(){
                               return localType;
                           }



                            /**
                               * Auto generated setter method
                               * @param param Type
                               */
                               public void setType(java.lang.String param){

                                       if (param != null){
                                          //update the setting tracker
                                          localTypeTracker = true;
                                       } else {
                                          localTypeTracker = true;

                                       }

                                            this.localType=param;


                               }


     /**
     * isReaderMTOMAware
     * @return true if the reader supports MTOM
     */
   public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
        boolean isReaderMTOMAware = false;

        try{
          isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
        }catch(java.lang.IllegalArgumentException e){
          isReaderMTOMAware = false;
        }
        return isReaderMTOMAware;
   }


        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{



               org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,parentQName){

                 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                       RetAssetDetailInfo.this.serialize(parentQName,factory,xmlWriter);
                 }
               };
               return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
               parentQName,factory,dataSource);

       }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       final org.apache.axiom.om.OMFactory factory,
                                       org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,factory,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               final org.apache.axiom.om.OMFactory factory,
                               org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{




                java.lang.String prefix = null;
                java.lang.String namespace = null;


                    prefix = parentQName.getPrefix();
                    namespace = parentQName.getNamespaceURI();

                    if ((namespace != null) && (namespace.trim().length() > 0)) {
                        java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                        if (writerPrefix != null) {
                            xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                        } else {
                            if (prefix == null) {
                                prefix = generatePrefix(namespace);
                            }

                            xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                            xmlWriter.writeNamespace(prefix, namespace);
                            xmlWriter.setPrefix(prefix, namespace);
                        }
                    } else {
                        xmlWriter.writeStartElement(parentQName.getLocalPart());
                    }


                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://asset.damws.imc.h3c.com/xsd");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":RetAssetDetailInfo",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "RetAssetDetailInfo",
                           xmlWriter);
                   }

                if (localDescriptionTracker){
                                    namespace = "http://ws.common.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"description", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"description");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("description");
                                    }


                                          if (localDescription==null){
                                              // write the nil attribute

                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                          }else{


                                                   xmlWriter.writeCharacters(localDescription);

                                          }

                                   xmlWriter.writeEndElement();
                             } if (localErrorCodeTracker){
                                    namespace = "http://ws.common.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"errorCode", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"errorCode");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("errorCode");
                                    }

                                               if (localErrorCode==java.lang.Integer.MIN_VALUE) {

                                                         throw new org.apache.axis2.databinding.ADBException("errorCode cannot be null!!");

                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localErrorCode));
                                               }

                                   xmlWriter.writeEndElement();
                             } if (localErrorMsgTracker){
                                    namespace = "http://ws.common.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"errorMsg", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"errorMsg");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("errorMsg");
                                    }


                                          if (localErrorMsg==null){
                                              // write the nil attribute

                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                          }else{


                                                   xmlWriter.writeCharacters(localErrorMsg);

                                          }

                                   xmlWriter.writeEndElement();
                             } if (localAssetNameTracker){
                                    namespace = "http://asset.damws.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"assetName", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"assetName");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("assetName");
                                    }


                                          if (localAssetName==null){
                                              // write the nil attribute

                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                          }else{


                                                   xmlWriter.writeCharacters(localAssetName);

                                          }

                                   xmlWriter.writeEndElement();
                             } if (localAssetNumberTracker){
                                    namespace = "http://asset.damws.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"assetNumber", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"assetNumber");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("assetNumber");
                                    }


                                          if (localAssetNumber==null){
                                              // write the nil attribute

                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                          }else{


                                                   xmlWriter.writeCharacters(localAssetNumber);

                                          }

                                   xmlWriter.writeEndElement();
                             } if (localComputerTypeTracker){
                                    namespace = "http://asset.damws.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"computerType", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"computerType");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("computerType");
                                    }


                                          if (localComputerType==null){
                                              // write the nil attribute

                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                          }else{


                                                   xmlWriter.writeCharacters(localComputerType);

                                          }

                                   xmlWriter.writeEndElement();
                             } if (localComputerVarietyTracker){
                                    namespace = "http://asset.damws.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"computerVariety", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"computerVariety");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("computerVariety");
                                    }


                                          if (localComputerVariety==null){
                                              // write the nil attribute

                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                          }else{


                                                   xmlWriter.writeCharacters(localComputerVariety);

                                          }

                                   xmlWriter.writeEndElement();
                             } if (localGroupNameTracker){
                                    namespace = "http://asset.damws.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"groupName", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"groupName");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("groupName");
                                    }


                                          if (localGroupName==null){
                                              // write the nil attribute

                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                          }else{


                                                   xmlWriter.writeCharacters(localGroupName);

                                          }

                                   xmlWriter.writeEndElement();
                             } if (localPhysicalPosTracker){
                                    namespace = "http://asset.damws.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"physicalPos", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"physicalPos");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("physicalPos");
                                    }


                                          if (localPhysicalPos==null){
                                              // write the nil attribute

                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                          }else{


                                                   xmlWriter.writeCharacters(localPhysicalPos);

                                          }

                                   xmlWriter.writeEndElement();
                             } if (localRemarkTracker){
                                    namespace = "http://asset.damws.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"remark", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"remark");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("remark");
                                    }


                                          if (localRemark==null){
                                              // write the nil attribute

                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                          }else{


                                                   xmlWriter.writeCharacters(localRemark);

                                          }

                                   xmlWriter.writeEndElement();
                             } if (localResponserIdTracker){
                                    namespace = "http://asset.damws.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"responserId", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"responserId");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("responserId");
                                    }

                                               if (localResponserId==java.lang.Long.MIN_VALUE) {

                                                         throw new org.apache.axis2.databinding.ADBException("responserId cannot be null!!");

                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localResponserId));
                                               }

                                   xmlWriter.writeEndElement();
                             } if (localResponserNameTracker){
                                    namespace = "http://asset.damws.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"responserName", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"responserName");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("responserName");
                                    }


                                          if (localResponserName==null){
                                              // write the nil attribute

                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                          }else{


                                                   xmlWriter.writeCharacters(localResponserName);

                                          }

                                   xmlWriter.writeEndElement();
                             } if (localTypeTracker){
                                    namespace = "http://asset.damws.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"type", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"type");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("type");
                                    }


                                          if (localType==null){
                                              // write the nil attribute

                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                          }else{


                                                   xmlWriter.writeCharacters(localType);

                                          }

                                   xmlWriter.writeEndElement();
                             }
                    xmlWriter.writeEndElement();


        }

         /**
          * Util method to write an attribute with the ns prefix
          */
          public void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
              if (xmlWriter.getPrefix(namespace) == null) {
                       xmlWriter.writeNamespace(prefix, namespace);
                       xmlWriter.setPrefix(prefix, namespace);

              }

              xmlWriter.writeAttribute(namespace,attName,attValue);

         }

        /**
          * Util method to write an attribute without the ns prefix
          */
          public void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
                if (namespace.equals(""))
              {
                  xmlWriter.writeAttribute(attName,attValue);
              }
              else
              {
                  registerPrefix(xmlWriter, namespace);
                  xmlWriter.writeAttribute(namespace,attName,attValue);
              }
          }


           /**
             * Util method to write an attribute without the ns prefix
             */
            public void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        public void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        public void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


         /**
         * Register a namespace prefix
         */
         public java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                        prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                    }

                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }

                return prefix;
            }



        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{



                 java.util.ArrayList elementList = new java.util.ArrayList();
                 java.util.ArrayList attribList = new java.util.ArrayList();


                    attribList.add(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema-instance","type"));
                    attribList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","RetAssetDetailInfo"));
                 if (localDescriptionTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://ws.common.imc.h3c.com/xsd",
                                                                      "description"));

                                         elementList.add(localDescription==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDescription));
                                    } if (localErrorCodeTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://ws.common.imc.h3c.com/xsd",
                                                                      "errorCode"));

                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localErrorCode));
                            } if (localErrorMsgTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://ws.common.imc.h3c.com/xsd",
                                                                      "errorMsg"));

                                         elementList.add(localErrorMsg==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localErrorMsg));
                                    } if (localAssetNameTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                      "assetName"));

                                         elementList.add(localAssetName==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAssetName));
                                    } if (localAssetNumberTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                      "assetNumber"));

                                         elementList.add(localAssetNumber==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAssetNumber));
                                    } if (localComputerTypeTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                      "computerType"));

                                         elementList.add(localComputerType==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localComputerType));
                                    } if (localComputerVarietyTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                      "computerVariety"));

                                         elementList.add(localComputerVariety==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localComputerVariety));
                                    } if (localGroupNameTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                      "groupName"));

                                         elementList.add(localGroupName==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localGroupName));
                                    } if (localPhysicalPosTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                      "physicalPos"));

                                         elementList.add(localPhysicalPos==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPhysicalPos));
                                    } if (localRemarkTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                      "remark"));

                                         elementList.add(localRemark==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRemark));
                                    } if (localResponserIdTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                      "responserId"));

                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localResponserId));
                            } if (localResponserNameTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                      "responserName"));

                                         elementList.add(localResponserName==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localResponserName));
                                    } if (localTypeTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                      "type"));

                                         elementList.add(localType==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localType));
                                    }

                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());



        }



     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{




        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static RetAssetDetailInfo parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            RetAssetDetailInfo object =
                new RetAssetDetailInfo();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();


                if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
                  java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                        "type");
                  if (fullTypeName!=null){
                    java.lang.String nsPrefix = null;
                    if (fullTypeName.indexOf(":") > -1){
                        nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
                    }
                    nsPrefix = nsPrefix==null?"":nsPrefix;

                    java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);

                            if (!"RetAssetDetailInfo".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (RetAssetDetailInfo)ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }


                  }


                }




                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();




                    reader.next();


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.common.imc.h3c.com/xsd","description").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setDescription(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                                       } else {


                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.common.imc.h3c.com/xsd","errorCode").equals(reader.getName())){

                                    java.lang.String content = reader.getElementText();

                                              object.setErrorCode(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                               object.setErrorCode(java.lang.Integer.MIN_VALUE);

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://ws.common.imc.h3c.com/xsd","errorMsg").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setErrorMsg(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                                       } else {


                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","assetName").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setAssetName(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                                       } else {


                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","assetNumber").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setAssetNumber(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                                       } else {


                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","computerType").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setComputerType(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                                       } else {


                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","computerVariety").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setComputerVariety(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                                       } else {


                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","groupName").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setGroupName(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                                       } else {


                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","physicalPos").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setPhysicalPos(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                                       } else {


                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","remark").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setRemark(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                                       } else {


                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","responserId").equals(reader.getName())){

                                    java.lang.String content = reader.getElementText();

                                              object.setResponserId(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToLong(content));

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                               object.setResponserId(java.lang.Long.MIN_VALUE);

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","responserName").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setResponserName(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                                       } else {


                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","type").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setType(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                                       } else {


                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                    }

                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();

                                if (reader.isStartElement())
                                // A start element we are not expecting indicates a trailing invalid property
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());




            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class



        }


        public static class DeleteAssetResponse
        implements org.apache.axis2.databinding.ADBBean{

                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://dam.imc.h3c.com/damAssetService",
                "deleteAssetResponse",
                "ns3");



        public static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://dam.imc.h3c.com/damAssetService")){
                return "ns3";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }



                        /**
                        * field for _return
                        */


                                    protected WSCommonResult local_return ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean local_returnTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return WSCommonResult
                           */
                           public  WSCommonResult get_return(){
                               return local_return;
                           }



                            /**
                               * Auto generated setter method
                               * @param param _return
                               */
                               public void set_return(WSCommonResult param){

                                       if (param != null){
                                          //update the setting tracker
                                          local_returnTracker = true;
                                       } else {
                                          local_returnTracker = true;

                                       }

                                            this.local_return=param;


                               }


     /**
     * isReaderMTOMAware
     * @return true if the reader supports MTOM
     */
   public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
        boolean isReaderMTOMAware = false;

        try{
          isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
        }catch(java.lang.IllegalArgumentException e){
          isReaderMTOMAware = false;
        }
        return isReaderMTOMAware;
   }


        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{



                org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,MY_QNAME){

                 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                       DeleteAssetResponse.this.serialize(MY_QNAME,factory,xmlWriter);
                 }
               };
               return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
               MY_QNAME,factory,dataSource);

       }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       final org.apache.axiom.om.OMFactory factory,
                                       org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,factory,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               final org.apache.axiom.om.OMFactory factory,
                               org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{




                java.lang.String prefix = null;
                java.lang.String namespace = null;


                    prefix = parentQName.getPrefix();
                    namespace = parentQName.getNamespaceURI();

                    if ((namespace != null) && (namespace.trim().length() > 0)) {
                        java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                        if (writerPrefix != null) {
                            xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                        } else {
                            if (prefix == null) {
                                prefix = generatePrefix(namespace);
                            }

                            xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                            xmlWriter.writeNamespace(prefix, namespace);
                            xmlWriter.setPrefix(prefix, namespace);
                        }
                    } else {
                        xmlWriter.writeStartElement(parentQName.getLocalPart());
                    }

                  if (serializeType){


                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://dam.imc.h3c.com/damAssetService");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":deleteAssetResponse",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "deleteAssetResponse",
                           xmlWriter);
                   }


                   }
                if (local_returnTracker){
                                    if (local_return==null){

                                            java.lang.String namespace2 = "http://dam.imc.h3c.com/damAssetService";

                                        if (! namespace2.equals("")) {
                                            java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                                            if (prefix2 == null) {
                                                prefix2 = generatePrefix(namespace2);

                                                xmlWriter.writeStartElement(prefix2,"return", namespace2);
                                                xmlWriter.writeNamespace(prefix2, namespace2);
                                                xmlWriter.setPrefix(prefix2, namespace2);

                                            } else {
                                                xmlWriter.writeStartElement(namespace2,"return");
                                            }

                                        } else {
                                            xmlWriter.writeStartElement("return");
                                        }


                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     local_return.serialize(new javax.xml.namespace.QName("http://dam.imc.h3c.com/damAssetService","return"),
                                        factory,xmlWriter);
                                    }
                                }
                    xmlWriter.writeEndElement();


        }

         /**
          * Util method to write an attribute with the ns prefix
          */
          public void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
              if (xmlWriter.getPrefix(namespace) == null) {
                       xmlWriter.writeNamespace(prefix, namespace);
                       xmlWriter.setPrefix(prefix, namespace);

              }

              xmlWriter.writeAttribute(namespace,attName,attValue);

         }

        /**
          * Util method to write an attribute without the ns prefix
          */
          public void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
                if (namespace.equals(""))
              {
                  xmlWriter.writeAttribute(attName,attValue);
              }
              else
              {
                  registerPrefix(xmlWriter, namespace);
                  xmlWriter.writeAttribute(namespace,attName,attValue);
              }
          }


           /**
             * Util method to write an attribute without the ns prefix
             */
            public void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        public void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        public void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


         /**
         * Register a namespace prefix
         */
         public java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                        prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                    }

                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }

                return prefix;
            }



        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{



                 java.util.ArrayList elementList = new java.util.ArrayList();
                 java.util.ArrayList attribList = new java.util.ArrayList();

                 if (local_returnTracker){
                            elementList.add(new javax.xml.namespace.QName("http://dam.imc.h3c.com/damAssetService",
                                                                      "return"));


                                    elementList.add(local_return==null?null:
                                    local_return);
                                }

                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());



        }



     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{




        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static DeleteAssetResponse parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            DeleteAssetResponse object =
                new DeleteAssetResponse();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();


                if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
                  java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                        "type");
                  if (fullTypeName!=null){
                    java.lang.String nsPrefix = null;
                    if (fullTypeName.indexOf(":") > -1){
                        nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
                    }
                    nsPrefix = nsPrefix==null?"":nsPrefix;

                    java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);

                            if (!"deleteAssetResponse".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (DeleteAssetResponse)ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }


                  }


                }




                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();




                    reader.next();


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://dam.imc.h3c.com/damAssetService","return").equals(reader.getName())){

                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.set_return(null);
                                          reader.next();

                                            reader.next();

                                      }else{

                                                object.set_return(WSCommonResult.Factory.parse(reader));

                                        reader.next();
                                    }
                              }  // End of if for expected property start element

                                    else {

                                    }

                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();

                                if (reader.isStartElement())
                                // A start element we are not expecting indicates a trailing invalid property
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());




            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class



        }


        public static class ModifyAsset
        implements org.apache.axis2.databinding.ADBBean{

                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://dam.imc.h3c.com/damAssetService",
                "modifyAsset",
                "ns3");



        public static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://dam.imc.h3c.com/damAssetService")){
                return "ns3";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }



                        /**
                        * field for Param0
                        */


                                    protected ModifyAssetInfo localParam0 ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localParam0Tracker = false ;


                           /**
                           * Auto generated getter method
                           * @return ModifyAssetInfo
                           */
                           public  ModifyAssetInfo getParam0(){
                               return localParam0;
                           }



                            /**
                               * Auto generated setter method
                               * @param param Param0
                               */
                               public void setParam0(ModifyAssetInfo param){

                                       if (param != null){
                                          //update the setting tracker
                                          localParam0Tracker = true;
                                       } else {
                                          localParam0Tracker = true;

                                       }

                                            this.localParam0=param;


                               }


     /**
     * isReaderMTOMAware
     * @return true if the reader supports MTOM
     */
   public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
        boolean isReaderMTOMAware = false;

        try{
          isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
        }catch(java.lang.IllegalArgumentException e){
          isReaderMTOMAware = false;
        }
        return isReaderMTOMAware;
   }


        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{



                org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,MY_QNAME){

                 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                       ModifyAsset.this.serialize(MY_QNAME,factory,xmlWriter);
                 }
               };
               return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
               MY_QNAME,factory,dataSource);

       }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       final org.apache.axiom.om.OMFactory factory,
                                       org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,factory,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               final org.apache.axiom.om.OMFactory factory,
                               org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{




                java.lang.String prefix = null;
                java.lang.String namespace = null;


                    prefix = parentQName.getPrefix();
                    namespace = parentQName.getNamespaceURI();

                    if ((namespace != null) && (namespace.trim().length() > 0)) {
                        java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                        if (writerPrefix != null) {
                            xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                        } else {
                            if (prefix == null) {
                                prefix = generatePrefix(namespace);
                            }

                            xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                            xmlWriter.writeNamespace(prefix, namespace);
                            xmlWriter.setPrefix(prefix, namespace);
                        }
                    } else {
                        xmlWriter.writeStartElement(parentQName.getLocalPart());
                    }

                  if (serializeType){


                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://dam.imc.h3c.com/damAssetService");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":modifyAsset",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "modifyAsset",
                           xmlWriter);
                   }


                   }
                if (localParam0Tracker){
                                    if (localParam0==null){

                                            java.lang.String namespace2 = "http://dam.imc.h3c.com/damAssetService";

                                        if (! namespace2.equals("")) {
                                            java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                                            if (prefix2 == null) {
                                                prefix2 = generatePrefix(namespace2);

                                                xmlWriter.writeStartElement(prefix2,"param0", namespace2);
                                                xmlWriter.writeNamespace(prefix2, namespace2);
                                                xmlWriter.setPrefix(prefix2, namespace2);

                                            } else {
                                                xmlWriter.writeStartElement(namespace2,"param0");
                                            }

                                        } else {
                                            xmlWriter.writeStartElement("param0");
                                        }


                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localParam0.serialize(new javax.xml.namespace.QName("http://dam.imc.h3c.com/damAssetService","param0"),
                                        factory,xmlWriter);
                                    }
                                }
                    xmlWriter.writeEndElement();


        }

         /**
          * Util method to write an attribute with the ns prefix
          */
          public void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
              if (xmlWriter.getPrefix(namespace) == null) {
                       xmlWriter.writeNamespace(prefix, namespace);
                       xmlWriter.setPrefix(prefix, namespace);

              }

              xmlWriter.writeAttribute(namespace,attName,attValue);

         }

        /**
          * Util method to write an attribute without the ns prefix
          */
          public void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
                if (namespace.equals(""))
              {
                  xmlWriter.writeAttribute(attName,attValue);
              }
              else
              {
                  registerPrefix(xmlWriter, namespace);
                  xmlWriter.writeAttribute(namespace,attName,attValue);
              }
          }


           /**
             * Util method to write an attribute without the ns prefix
             */
            public void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        public void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        public void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


         /**
         * Register a namespace prefix
         */
         public java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                        prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                    }

                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }

                return prefix;
            }



        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{



                 java.util.ArrayList elementList = new java.util.ArrayList();
                 java.util.ArrayList attribList = new java.util.ArrayList();

                 if (localParam0Tracker){
                            elementList.add(new javax.xml.namespace.QName("http://dam.imc.h3c.com/damAssetService",
                                                                      "param0"));


                                    elementList.add(localParam0==null?null:
                                    localParam0);
                                }

                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());



        }



     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{




        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static ModifyAsset parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            ModifyAsset object =
                new ModifyAsset();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();


                if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
                  java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                        "type");
                  if (fullTypeName!=null){
                    java.lang.String nsPrefix = null;
                    if (fullTypeName.indexOf(":") > -1){
                        nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
                    }
                    nsPrefix = nsPrefix==null?"":nsPrefix;

                    java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);

                            if (!"modifyAsset".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (ModifyAsset)ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }


                  }


                }




                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();




                    reader.next();


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://dam.imc.h3c.com/damAssetService","param0").equals(reader.getName())){

                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setParam0(null);
                                          reader.next();

                                            reader.next();

                                      }else{

                                                object.setParam0(ModifyAssetInfo.Factory.parse(reader));

                                        reader.next();
                                    }
                              }  // End of if for expected property start element

                                    else {

                                    }

                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();

                                if (reader.isStartElement())
                                // A start element we are not expecting indicates a trailing invalid property
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());




            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class



        }


        public static class QueryAssetResponse
        implements org.apache.axis2.databinding.ADBBean{

                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://dam.imc.h3c.com/damAssetService",
                "queryAssetResponse",
                "ns3");



        public static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://dam.imc.h3c.com/damAssetService")){
                return "ns3";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }



                        /**
                        * field for _return
                        */


                                    protected RetAssetInfoList local_return ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean local_returnTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return RetAssetInfoList
                           */
                           public  RetAssetInfoList get_return(){
                               return local_return;
                           }



                            /**
                               * Auto generated setter method
                               * @param param _return
                               */
                               public void set_return(RetAssetInfoList param){

                                       if (param != null){
                                          //update the setting tracker
                                          local_returnTracker = true;
                                       } else {
                                          local_returnTracker = true;

                                       }

                                            this.local_return=param;


                               }


     /**
     * isReaderMTOMAware
     * @return true if the reader supports MTOM
     */
   public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
        boolean isReaderMTOMAware = false;

        try{
          isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
        }catch(java.lang.IllegalArgumentException e){
          isReaderMTOMAware = false;
        }
        return isReaderMTOMAware;
   }


        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{



                org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,MY_QNAME){

                 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                       QueryAssetResponse.this.serialize(MY_QNAME,factory,xmlWriter);
                 }
               };
               return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
               MY_QNAME,factory,dataSource);

       }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       final org.apache.axiom.om.OMFactory factory,
                                       org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,factory,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               final org.apache.axiom.om.OMFactory factory,
                               org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{




                java.lang.String prefix = null;
                java.lang.String namespace = null;


                    prefix = parentQName.getPrefix();
                    namespace = parentQName.getNamespaceURI();

                    if ((namespace != null) && (namespace.trim().length() > 0)) {
                        java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                        if (writerPrefix != null) {
                            xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                        } else {
                            if (prefix == null) {
                                prefix = generatePrefix(namespace);
                            }

                            xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                            xmlWriter.writeNamespace(prefix, namespace);
                            xmlWriter.setPrefix(prefix, namespace);
                        }
                    } else {
                        xmlWriter.writeStartElement(parentQName.getLocalPart());
                    }

                  if (serializeType){


                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://dam.imc.h3c.com/damAssetService");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":queryAssetResponse",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "queryAssetResponse",
                           xmlWriter);
                   }


                   }
                if (local_returnTracker){
                                    if (local_return==null){

                                            java.lang.String namespace2 = "http://dam.imc.h3c.com/damAssetService";

                                        if (! namespace2.equals("")) {
                                            java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                                            if (prefix2 == null) {
                                                prefix2 = generatePrefix(namespace2);

                                                xmlWriter.writeStartElement(prefix2,"return", namespace2);
                                                xmlWriter.writeNamespace(prefix2, namespace2);
                                                xmlWriter.setPrefix(prefix2, namespace2);

                                            } else {
                                                xmlWriter.writeStartElement(namespace2,"return");
                                            }

                                        } else {
                                            xmlWriter.writeStartElement("return");
                                        }


                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     local_return.serialize(new javax.xml.namespace.QName("http://dam.imc.h3c.com/damAssetService","return"),
                                        factory,xmlWriter);
                                    }
                                }
                    xmlWriter.writeEndElement();


        }

         /**
          * Util method to write an attribute with the ns prefix
          */
          public void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
              if (xmlWriter.getPrefix(namespace) == null) {
                       xmlWriter.writeNamespace(prefix, namespace);
                       xmlWriter.setPrefix(prefix, namespace);

              }

              xmlWriter.writeAttribute(namespace,attName,attValue);

         }

        /**
          * Util method to write an attribute without the ns prefix
          */
          public void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
                if (namespace.equals(""))
              {
                  xmlWriter.writeAttribute(attName,attValue);
              }
              else
              {
                  registerPrefix(xmlWriter, namespace);
                  xmlWriter.writeAttribute(namespace,attName,attValue);
              }
          }


           /**
             * Util method to write an attribute without the ns prefix
             */
            public void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        public void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        public void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


         /**
         * Register a namespace prefix
         */
         public java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                        prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                    }

                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }

                return prefix;
            }



        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{



                 java.util.ArrayList elementList = new java.util.ArrayList();
                 java.util.ArrayList attribList = new java.util.ArrayList();

                 if (local_returnTracker){
                            elementList.add(new javax.xml.namespace.QName("http://dam.imc.h3c.com/damAssetService",
                                                                      "return"));


                                    elementList.add(local_return==null?null:
                                    local_return);
                                }

                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());



        }



     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{




        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static QueryAssetResponse parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            QueryAssetResponse object =
                new QueryAssetResponse();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();


                if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
                  java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                        "type");
                  if (fullTypeName!=null){
                    java.lang.String nsPrefix = null;
                    if (fullTypeName.indexOf(":") > -1){
                        nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
                    }
                    nsPrefix = nsPrefix==null?"":nsPrefix;

                    java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);

                            if (!"queryAssetResponse".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (QueryAssetResponse)ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }


                  }


                }




                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();




                    reader.next();


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://dam.imc.h3c.com/damAssetService","return").equals(reader.getName())){

                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.set_return(null);
                                          reader.next();

                                            reader.next();

                                      }else{

                                                object.set_return(RetAssetInfoList.Factory.parse(reader));

                                        reader.next();
                                    }
                              }  // End of if for expected property start element

                                    else {

                                    }

                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();

                                if (reader.isStartElement())
                                // A start element we are not expecting indicates a trailing invalid property
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());




            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class



        }


        public static class AddAsset
        implements org.apache.axis2.databinding.ADBBean{

                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://dam.imc.h3c.com/damAssetService",
                "addAsset",
                "ns3");



        public static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://dam.imc.h3c.com/damAssetService")){
                return "ns3";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }



                        /**
                        * field for Param0
                        */


                                    protected AddAssetInfo localParam0 ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localParam0Tracker = false ;


                           /**
                           * Auto generated getter method
                           * @return AddAssetInfo
                           */
                           public  AddAssetInfo getParam0(){
                               return localParam0;
                           }



                            /**
                               * Auto generated setter method
                               * @param param Param0
                               */
                               public void setParam0(AddAssetInfo param){

                                       if (param != null){
                                          //update the setting tracker
                                          localParam0Tracker = true;
                                       } else {
                                          localParam0Tracker = true;

                                       }

                                            this.localParam0=param;


                               }


     /**
     * isReaderMTOMAware
     * @return true if the reader supports MTOM
     */
   public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
        boolean isReaderMTOMAware = false;

        try{
          isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
        }catch(java.lang.IllegalArgumentException e){
          isReaderMTOMAware = false;
        }
        return isReaderMTOMAware;
   }


        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{



                org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,MY_QNAME){

                 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                       AddAsset.this.serialize(MY_QNAME,factory,xmlWriter);
                 }
               };
               return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
               MY_QNAME,factory,dataSource);

       }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       final org.apache.axiom.om.OMFactory factory,
                                       org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,factory,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               final org.apache.axiom.om.OMFactory factory,
                               org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{




                java.lang.String prefix = null;
                java.lang.String namespace = null;


                    prefix = parentQName.getPrefix();
                    namespace = parentQName.getNamespaceURI();

                    if ((namespace != null) && (namespace.trim().length() > 0)) {
                        java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                        if (writerPrefix != null) {
                            xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                        } else {
                            if (prefix == null) {
                                prefix = generatePrefix(namespace);
                            }

                            xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                            xmlWriter.writeNamespace(prefix, namespace);
                            xmlWriter.setPrefix(prefix, namespace);
                        }
                    } else {
                        xmlWriter.writeStartElement(parentQName.getLocalPart());
                    }

                  if (serializeType){


                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://dam.imc.h3c.com/damAssetService");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":addAsset",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "addAsset",
                           xmlWriter);
                   }


                   }
                if (localParam0Tracker){
                                    if (localParam0==null){

                                            java.lang.String namespace2 = "http://dam.imc.h3c.com/damAssetService";

                                        if (! namespace2.equals("")) {
                                            java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                                            if (prefix2 == null) {
                                                prefix2 = generatePrefix(namespace2);

                                                xmlWriter.writeStartElement(prefix2,"param0", namespace2);
                                                xmlWriter.writeNamespace(prefix2, namespace2);
                                                xmlWriter.setPrefix(prefix2, namespace2);

                                            } else {
                                                xmlWriter.writeStartElement(namespace2,"param0");
                                            }

                                        } else {
                                            xmlWriter.writeStartElement("param0");
                                        }


                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localParam0.serialize(new javax.xml.namespace.QName("http://dam.imc.h3c.com/damAssetService","param0"),
                                        factory,xmlWriter);
                                    }
                                }
                    xmlWriter.writeEndElement();


        }

         /**
          * Util method to write an attribute with the ns prefix
          */
          public void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
              if (xmlWriter.getPrefix(namespace) == null) {
                       xmlWriter.writeNamespace(prefix, namespace);
                       xmlWriter.setPrefix(prefix, namespace);

              }

              xmlWriter.writeAttribute(namespace,attName,attValue);

         }

        /**
          * Util method to write an attribute without the ns prefix
          */
          public void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
                if (namespace.equals(""))
              {
                  xmlWriter.writeAttribute(attName,attValue);
              }
              else
              {
                  registerPrefix(xmlWriter, namespace);
                  xmlWriter.writeAttribute(namespace,attName,attValue);
              }
          }


           /**
             * Util method to write an attribute without the ns prefix
             */
            public void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        public void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        public void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


         /**
         * Register a namespace prefix
         */
         public java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                        prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                    }

                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }

                return prefix;
            }



        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{



                 java.util.ArrayList elementList = new java.util.ArrayList();
                 java.util.ArrayList attribList = new java.util.ArrayList();

                 if (localParam0Tracker){
                            elementList.add(new javax.xml.namespace.QName("http://dam.imc.h3c.com/damAssetService",
                                                                      "param0"));


                                    elementList.add(localParam0==null?null:
                                    localParam0);
                                }

                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());



        }



     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{




        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static AddAsset parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            AddAsset object =
                new AddAsset();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();


                if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
                  java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                        "type");
                  if (fullTypeName!=null){
                    java.lang.String nsPrefix = null;
                    if (fullTypeName.indexOf(":") > -1){
                        nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
                    }
                    nsPrefix = nsPrefix==null?"":nsPrefix;

                    java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);

                            if (!"addAsset".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (AddAsset)ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }


                  }


                }




                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();




                    reader.next();


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://dam.imc.h3c.com/damAssetService","param0").equals(reader.getName())){

                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setParam0(null);
                                          reader.next();

                                            reader.next();

                                      }else{

                                                object.setParam0(AddAssetInfo.Factory.parse(reader));

                                        reader.next();
                                    }
                              }  // End of if for expected property start element

                                    else {

                                    }

                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();

                                if (reader.isStartElement())
                                // A start element we are not expecting indicates a trailing invalid property
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());




            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class



        }


        public static class AssetQueryInfo
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = AssetQueryInfo
                Namespace URI = http://asset.damws.imc.h3c.com/xsd
                Namespace Prefix = ns2
                */


        public static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://asset.damws.imc.h3c.com/xsd")){
                return "ns2";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }



                        /**
                        * field for AssetName
                        */


                                    protected java.lang.String localAssetName ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAssetNameTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getAssetName(){
                               return localAssetName;
                           }



                            /**
                               * Auto generated setter method
                               * @param param AssetName
                               */
                               public void setAssetName(java.lang.String param){

                                       if (param != null){
                                          //update the setting tracker
                                          localAssetNameTracker = true;
                                       } else {
                                          localAssetNameTracker = true;

                                       }

                                            this.localAssetName=param;


                               }


                        /**
                        * field for AssetNumber
                        */


                                    protected java.lang.String localAssetNumber ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAssetNumberTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getAssetNumber(){
                               return localAssetNumber;
                           }



                            /**
                               * Auto generated setter method
                               * @param param AssetNumber
                               */
                               public void setAssetNumber(java.lang.String param){

                                       if (param != null){
                                          //update the setting tracker
                                          localAssetNumberTracker = true;
                                       } else {
                                          localAssetNumberTracker = true;

                                       }

                                            this.localAssetNumber=param;


                               }


                        /**
                        * field for ComputerType
                        */


                                    protected java.lang.String localComputerType ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localComputerTypeTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getComputerType(){
                               return localComputerType;
                           }



                            /**
                               * Auto generated setter method
                               * @param param ComputerType
                               */
                               public void setComputerType(java.lang.String param){

                                       if (param != null){
                                          //update the setting tracker
                                          localComputerTypeTracker = true;
                                       } else {
                                          localComputerTypeTracker = true;

                                       }

                                            this.localComputerType=param;


                               }


                        /**
                        * field for ComputerVariety
                        */


                                    protected java.lang.String localComputerVariety ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localComputerVarietyTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getComputerVariety(){
                               return localComputerVariety;
                           }



                            /**
                               * Auto generated setter method
                               * @param param ComputerVariety
                               */
                               public void setComputerVariety(java.lang.String param){

                                       if (param != null){
                                          //update the setting tracker
                                          localComputerVarietyTracker = true;
                                       } else {
                                          localComputerVarietyTracker = true;

                                       }

                                            this.localComputerVariety=param;


                               }


                        /**
                        * field for EndDate
                        */


                                    protected java.util.Calendar localEndDate ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localEndDateTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getEndDate(){
                               return localEndDate;
                           }



                            /**
                               * Auto generated setter method
                               * @param param EndDate
                               */
                               public void setEndDate(java.util.Calendar param){

                                       if (param != null){
                                          //update the setting tracker
                                          localEndDateTracker = true;
                                       } else {
                                          localEndDateTracker = true;

                                       }

                                            this.localEndDate=param;


                               }


                        /**
                        * field for GroupId
                        */


                                    protected long localGroupId ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localGroupIdTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return long
                           */
                           public  long getGroupId(){
                               return localGroupId;
                           }



                            /**
                               * Auto generated setter method
                               * @param param GroupId
                               */
                               public void setGroupId(long param){

                                       // setting primitive attribute tracker to true

                                               if (param==java.lang.Long.MIN_VALUE) {
                                           localGroupIdTracker = true;

                                       } else {
                                          localGroupIdTracker = true;
                                       }

                                            this.localGroupId=param;


                               }


                        /**
                        * field for OperSystem
                        */


                                    protected java.lang.String localOperSystem ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localOperSystemTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getOperSystem(){
                               return localOperSystem;
                           }



                            /**
                               * Auto generated setter method
                               * @param param OperSystem
                               */
                               public void setOperSystem(java.lang.String param){

                                       if (param != null){
                                          //update the setting tracker
                                          localOperSystemTracker = true;
                                       } else {
                                          localOperSystemTracker = true;

                                       }

                                            this.localOperSystem=param;


                               }


                        /**
                        * field for OperSystemId
                        */


                                    protected int localOperSystemId ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localOperSystemIdTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getOperSystemId(){
                               return localOperSystemId;
                           }



                            /**
                               * Auto generated setter method
                               * @param param OperSystemId
                               */
                               public void setOperSystemId(int param){

                                       // setting primitive attribute tracker to true

                                               if (param==java.lang.Integer.MIN_VALUE) {
                                           localOperSystemIdTracker = true;

                                       } else {
                                          localOperSystemIdTracker = true;
                                       }

                                            this.localOperSystemId=param;


                               }


                        /**
                        * field for OperSystemMend
                        */


                                    protected java.lang.String localOperSystemMend ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localOperSystemMendTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getOperSystemMend(){
                               return localOperSystemMend;
                           }



                            /**
                               * Auto generated setter method
                               * @param param OperSystemMend
                               */
                               public void setOperSystemMend(java.lang.String param){

                                       if (param != null){
                                          //update the setting tracker
                                          localOperSystemMendTracker = true;
                                       } else {
                                          localOperSystemMendTracker = true;

                                       }

                                            this.localOperSystemMend=param;


                               }


                        /**
                        * field for Responser
                        */


                                    protected java.lang.String localResponser ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localResponserTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getResponser(){
                               return localResponser;
                           }



                            /**
                               * Auto generated setter method
                               * @param param Responser
                               */
                               public void setResponser(java.lang.String param){

                                       if (param != null){
                                          //update the setting tracker
                                          localResponserTracker = true;
                                       } else {
                                          localResponserTracker = true;

                                       }

                                            this.localResponser=param;


                               }


                        /**
                        * field for ResultIndex
                        */


                                    protected int localResultIndex ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localResultIndexTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getResultIndex(){
                               return localResultIndex;
                           }



                            /**
                               * Auto generated setter method
                               * @param param ResultIndex
                               */
                               public void setResultIndex(int param){

                                       // setting primitive attribute tracker to true

                                               if (param==java.lang.Integer.MIN_VALUE) {
                                           localResultIndexTracker = true;

                                       } else {
                                          localResultIndexTracker = true;
                                       }

                                            this.localResultIndex=param;


                               }


                        /**
                        * field for ResultNumber
                        */


                                    protected int localResultNumber ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localResultNumberTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getResultNumber(){
                               return localResultNumber;
                           }



                            /**
                               * Auto generated setter method
                               * @param param ResultNumber
                               */
                               public void setResultNumber(int param){

                                       // setting primitive attribute tracker to true

                                               if (param==java.lang.Integer.MIN_VALUE) {
                                           localResultNumberTracker = true;

                                       } else {
                                          localResultNumberTracker = true;
                                       }

                                            this.localResultNumber=param;


                               }


                        /**
                        * field for ResultSort
                        */


                                    protected int localResultSort ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localResultSortTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getResultSort(){
                               return localResultSort;
                           }



                            /**
                               * Auto generated setter method
                               * @param param ResultSort
                               */
                               public void setResultSort(int param){

                                       // setting primitive attribute tracker to true

                                               if (param==java.lang.Integer.MIN_VALUE) {
                                           localResultSortTracker = true;

                                       } else {
                                          localResultSortTracker = true;
                                       }

                                            this.localResultSort=param;


                               }


                        /**
                        * field for ResultSortType
                        */


                                    protected int localResultSortType ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localResultSortTypeTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getResultSortType(){
                               return localResultSortType;
                           }



                            /**
                               * Auto generated setter method
                               * @param param ResultSortType
                               */
                               public void setResultSortType(int param){

                                       // setting primitive attribute tracker to true

                                               if (param==java.lang.Integer.MIN_VALUE) {
                                           localResultSortTypeTracker = true;

                                       } else {
                                          localResultSortTypeTracker = true;
                                       }

                                            this.localResultSortType=param;


                               }


                        /**
                        * field for StartDate
                        */


                                    protected java.util.Calendar localStartDate ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localStartDateTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getStartDate(){
                               return localStartDate;
                           }



                            /**
                               * Auto generated setter method
                               * @param param StartDate
                               */
                               public void setStartDate(java.util.Calendar param){

                                       if (param != null){
                                          //update the setting tracker
                                          localStartDateTracker = true;
                                       } else {
                                          localStartDateTracker = true;

                                       }

                                            this.localStartDate=param;


                               }


                        /**
                        * field for Status
                        */


                                    protected int localStatus ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localStatusTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getStatus(){
                               return localStatus;
                           }



                            /**
                               * Auto generated setter method
                               * @param param Status
                               */
                               public void setStatus(int param){

                                       // setting primitive attribute tracker to true

                                               if (param==java.lang.Integer.MIN_VALUE) {
                                           localStatusTracker = true;

                                       } else {
                                          localStatusTracker = true;
                                       }

                                            this.localStatus=param;


                               }


                        /**
                        * field for Type
                        */


                                    protected java.lang.String localType ;

                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localTypeTracker = false ;


                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getType(){
                               return localType;
                           }



                            /**
                               * Auto generated setter method
                               * @param param Type
                               */
                               public void setType(java.lang.String param){

                                       if (param != null){
                                          //update the setting tracker
                                          localTypeTracker = true;
                                       } else {
                                          localTypeTracker = true;

                                       }

                                            this.localType=param;


                               }


     /**
     * isReaderMTOMAware
     * @return true if the reader supports MTOM
     */
   public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
        boolean isReaderMTOMAware = false;

        try{
          isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
        }catch(java.lang.IllegalArgumentException e){
          isReaderMTOMAware = false;
        }
        return isReaderMTOMAware;
   }


        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{



               org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,parentQName){

                 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                       AssetQueryInfo.this.serialize(parentQName,factory,xmlWriter);
                 }
               };
               return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
               parentQName,factory,dataSource);

       }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       final org.apache.axiom.om.OMFactory factory,
                                       org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,factory,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               final org.apache.axiom.om.OMFactory factory,
                               org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{




                java.lang.String prefix = null;
                java.lang.String namespace = null;


                    prefix = parentQName.getPrefix();
                    namespace = parentQName.getNamespaceURI();

                    if ((namespace != null) && (namespace.trim().length() > 0)) {
                        java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                        if (writerPrefix != null) {
                            xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                        } else {
                            if (prefix == null) {
                                prefix = generatePrefix(namespace);
                            }

                            xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                            xmlWriter.writeNamespace(prefix, namespace);
                            xmlWriter.setPrefix(prefix, namespace);
                        }
                    } else {
                        xmlWriter.writeStartElement(parentQName.getLocalPart());
                    }

                  if (serializeType){


                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://asset.damws.imc.h3c.com/xsd");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":AssetQueryInfo",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "AssetQueryInfo",
                           xmlWriter);
                   }


                   }
                if (localAssetNameTracker){
                                    namespace = "http://asset.damws.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"assetName", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"assetName");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("assetName");
                                    }


                                          if (localAssetName==null){
                                              // write the nil attribute

                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                          }else{


                                                   xmlWriter.writeCharacters(localAssetName);

                                          }

                                   xmlWriter.writeEndElement();
                             } if (localAssetNumberTracker){
                                    namespace = "http://asset.damws.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"assetNumber", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"assetNumber");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("assetNumber");
                                    }


                                          if (localAssetNumber==null){
                                              // write the nil attribute

                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                          }else{


                                                   xmlWriter.writeCharacters(localAssetNumber);

                                          }

                                   xmlWriter.writeEndElement();
                             } if (localComputerTypeTracker){
                                    namespace = "http://asset.damws.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"computerType", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"computerType");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("computerType");
                                    }


                                          if (localComputerType==null){
                                              // write the nil attribute

                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                          }else{


                                                   xmlWriter.writeCharacters(localComputerType);

                                          }

                                   xmlWriter.writeEndElement();
                             } if (localComputerVarietyTracker){
                                    namespace = "http://asset.damws.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"computerVariety", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"computerVariety");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("computerVariety");
                                    }


                                          if (localComputerVariety==null){
                                              // write the nil attribute

                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                          }else{


                                                   xmlWriter.writeCharacters(localComputerVariety);

                                          }

                                   xmlWriter.writeEndElement();
                             } if (localEndDateTracker){
                                    namespace = "http://asset.damws.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"endDate", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"endDate");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("endDate");
                                    }


                                          if (localEndDate==null){
                                              // write the nil attribute

                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                          }else{


                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localEndDate));

                                          }

                                   xmlWriter.writeEndElement();
                             } if (localGroupIdTracker){
                                    namespace = "http://asset.damws.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"groupId", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"groupId");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("groupId");
                                    }

                                               if (localGroupId==java.lang.Long.MIN_VALUE) {

                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localGroupId));
                                               }

                                   xmlWriter.writeEndElement();
                             } if (localOperSystemTracker){
                                    namespace = "http://asset.damws.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"operSystem", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"operSystem");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("operSystem");
                                    }


                                          if (localOperSystem==null){
                                              // write the nil attribute

                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                          }else{


                                                   xmlWriter.writeCharacters(localOperSystem);

                                          }

                                   xmlWriter.writeEndElement();
                             } if (localOperSystemIdTracker){
                                    namespace = "http://asset.damws.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"operSystemId", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"operSystemId");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("operSystemId");
                                    }

                                               if (localOperSystemId==java.lang.Integer.MIN_VALUE) {

                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localOperSystemId));
                                               }

                                   xmlWriter.writeEndElement();
                             } if (localOperSystemMendTracker){
                                    namespace = "http://asset.damws.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"operSystemMend", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"operSystemMend");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("operSystemMend");
                                    }


                                          if (localOperSystemMend==null){
                                              // write the nil attribute

                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                          }else{


                                                   xmlWriter.writeCharacters(localOperSystemMend);

                                          }

                                   xmlWriter.writeEndElement();
                             } if (localResponserTracker){
                                    namespace = "http://asset.damws.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"responser", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"responser");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("responser");
                                    }


                                          if (localResponser==null){
                                              // write the nil attribute

                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                          }else{


                                                   xmlWriter.writeCharacters(localResponser);

                                          }

                                   xmlWriter.writeEndElement();
                             } if (localResultIndexTracker){
                                    namespace = "http://asset.damws.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"resultIndex", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"resultIndex");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("resultIndex");
                                    }

                                               if (localResultIndex==java.lang.Integer.MIN_VALUE) {

                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localResultIndex));
                                               }

                                   xmlWriter.writeEndElement();
                             } if (localResultNumberTracker){
                                    namespace = "http://asset.damws.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"resultNumber", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"resultNumber");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("resultNumber");
                                    }

                                               if (localResultNumber==java.lang.Integer.MIN_VALUE) {

                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localResultNumber));
                                               }

                                   xmlWriter.writeEndElement();
                             } if (localResultSortTracker){
                                    namespace = "http://asset.damws.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"resultSort", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"resultSort");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("resultSort");
                                    }

                                               if (localResultSort==java.lang.Integer.MIN_VALUE) {

                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localResultSort));
                                               }

                                   xmlWriter.writeEndElement();
                             } if (localResultSortTypeTracker){
                                    namespace = "http://asset.damws.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"resultSortType", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"resultSortType");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("resultSortType");
                                    }

                                               if (localResultSortType==java.lang.Integer.MIN_VALUE) {

                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localResultSortType));
                                               }

                                   xmlWriter.writeEndElement();
                             } if (localStartDateTracker){
                                    namespace = "http://asset.damws.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"startDate", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"startDate");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("startDate");
                                    }


                                          if (localStartDate==null){
                                              // write the nil attribute

                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                          }else{


                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localStartDate));

                                          }

                                   xmlWriter.writeEndElement();
                             } if (localStatusTracker){
                                    namespace = "http://asset.damws.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"status", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"status");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("status");
                                    }

                                               if (localStatus==java.lang.Integer.MIN_VALUE) {

                                                         writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localStatus));
                                               }

                                   xmlWriter.writeEndElement();
                             } if (localTypeTracker){
                                    namespace = "http://asset.damws.imc.h3c.com/xsd";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"type", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"type");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("type");
                                    }


                                          if (localType==null){
                                              // write the nil attribute

                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);

                                          }else{


                                                   xmlWriter.writeCharacters(localType);

                                          }

                                   xmlWriter.writeEndElement();
                             }
                    xmlWriter.writeEndElement();


        }

         /**
          * Util method to write an attribute with the ns prefix
          */
          public void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
              if (xmlWriter.getPrefix(namespace) == null) {
                       xmlWriter.writeNamespace(prefix, namespace);
                       xmlWriter.setPrefix(prefix, namespace);

              }

              xmlWriter.writeAttribute(namespace,attName,attValue);

         }

        /**
          * Util method to write an attribute without the ns prefix
          */
          public void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
                if (namespace.equals(""))
              {
                  xmlWriter.writeAttribute(attName,attValue);
              }
              else
              {
                  registerPrefix(xmlWriter, namespace);
                  xmlWriter.writeAttribute(namespace,attName,attValue);
              }
          }


           /**
             * Util method to write an attribute without the ns prefix
             */
            public void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        public void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        public void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


         /**
         * Register a namespace prefix
         */
         public java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                        prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                    }

                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }

                return prefix;
            }



        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{



                 java.util.ArrayList elementList = new java.util.ArrayList();
                 java.util.ArrayList attribList = new java.util.ArrayList();

                 if (localAssetNameTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                      "assetName"));

                                         elementList.add(localAssetName==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAssetName));
                                    } if (localAssetNumberTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                      "assetNumber"));

                                         elementList.add(localAssetNumber==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAssetNumber));
                                    } if (localComputerTypeTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                      "computerType"));

                                         elementList.add(localComputerType==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localComputerType));
                                    } if (localComputerVarietyTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                      "computerVariety"));

                                         elementList.add(localComputerVariety==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localComputerVariety));
                                    } if (localEndDateTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                      "endDate"));

                                         elementList.add(localEndDate==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localEndDate));
                                    } if (localGroupIdTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                      "groupId"));

                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localGroupId));
                            } if (localOperSystemTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                      "operSystem"));

                                         elementList.add(localOperSystem==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localOperSystem));
                                    } if (localOperSystemIdTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                      "operSystemId"));

                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localOperSystemId));
                            } if (localOperSystemMendTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                      "operSystemMend"));

                                         elementList.add(localOperSystemMend==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localOperSystemMend));
                                    } if (localResponserTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                      "responser"));

                                         elementList.add(localResponser==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localResponser));
                                    } if (localResultIndexTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                      "resultIndex"));

                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localResultIndex));
                            } if (localResultNumberTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                      "resultNumber"));

                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localResultNumber));
                            } if (localResultSortTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                      "resultSort"));

                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localResultSort));
                            } if (localResultSortTypeTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                      "resultSortType"));

                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localResultSortType));
                            } if (localStartDateTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                      "startDate"));

                                         elementList.add(localStartDate==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localStartDate));
                                    } if (localStatusTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                      "status"));

                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localStatus));
                            } if (localTypeTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd",
                                                                      "type"));

                                         elementList.add(localType==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localType));
                                    }

                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());



        }



     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{




        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static AssetQueryInfo parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            AssetQueryInfo object =
                new AssetQueryInfo();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {

                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();


                if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
                  java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                        "type");
                  if (fullTypeName!=null){
                    java.lang.String nsPrefix = null;
                    if (fullTypeName.indexOf(":") > -1){
                        nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
                    }
                    nsPrefix = nsPrefix==null?"":nsPrefix;

                    java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);

                            if (!"AssetQueryInfo".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (AssetQueryInfo)ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }


                  }


                }




                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();




                    reader.next();


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","assetName").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setAssetName(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                                       } else {


                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","assetNumber").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setAssetNumber(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                                       } else {


                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","computerType").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setComputerType(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                                       } else {


                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","computerVariety").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setComputerVariety(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                                       } else {


                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","endDate").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setEndDate(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));

                                       } else {


                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","groupId").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setGroupId(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToLong(content));

                                       } else {


                                                   object.setGroupId(java.lang.Long.MIN_VALUE);

                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                               object.setGroupId(java.lang.Long.MIN_VALUE);

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","operSystem").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setOperSystem(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                                       } else {


                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","operSystemId").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setOperSystemId(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));

                                       } else {


                                                   object.setOperSystemId(java.lang.Integer.MIN_VALUE);

                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                               object.setOperSystemId(java.lang.Integer.MIN_VALUE);

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","operSystemMend").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setOperSystemMend(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                                       } else {


                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","responser").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setResponser(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                                       } else {


                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","resultIndex").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setResultIndex(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));

                                       } else {


                                                   object.setResultIndex(java.lang.Integer.MIN_VALUE);

                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                               object.setResultIndex(java.lang.Integer.MIN_VALUE);

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","resultNumber").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setResultNumber(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));

                                       } else {


                                                   object.setResultNumber(java.lang.Integer.MIN_VALUE);

                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                               object.setResultNumber(java.lang.Integer.MIN_VALUE);

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","resultSort").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setResultSort(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));

                                       } else {


                                                   object.setResultSort(java.lang.Integer.MIN_VALUE);

                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                               object.setResultSort(java.lang.Integer.MIN_VALUE);

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","resultSortType").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setResultSortType(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));

                                       } else {


                                                   object.setResultSortType(java.lang.Integer.MIN_VALUE);

                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                               object.setResultSortType(java.lang.Integer.MIN_VALUE);

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","startDate").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setStartDate(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));

                                       } else {


                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","status").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setStatus(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));

                                       } else {


                                                   object.setStatus(java.lang.Integer.MIN_VALUE);

                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                               object.setStatus(java.lang.Integer.MIN_VALUE);

                                    }


                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://asset.damws.imc.h3c.com/xsd","type").equals(reader.getName())){

                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){

                                    java.lang.String content = reader.getElementText();

                                              object.setType(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));

                                       } else {


                                           reader.getElementText(); // throw away text nodes if any.
                                       }

                                        reader.next();

                              }  // End of if for expected property start element

                                    else {

                                    }

                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();

                                if (reader.isStartElement())
                                // A start element we are not expecting indicates a trailing invalid property
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());




            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class



        }


            public  org.apache.axiom.om.OMElement  toOM(com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.QueryAsset param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {


                        try{
                             return param.getOMElement(com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.QueryAsset.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }


            }

            public  org.apache.axiom.om.OMElement  toOM(com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.QueryAssetResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {


                        try{
                             return param.getOMElement(com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.QueryAssetResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }


            }

            public  org.apache.axiom.om.OMElement  toOM(com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.QueryAssetGroupResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {


                        try{
                             return param.getOMElement(com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.QueryAssetGroupResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }


            }

            public  org.apache.axiom.om.OMElement  toOM(com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.DeleteAsset param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {


                        try{
                             return param.getOMElement(com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.DeleteAsset.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }


            }

            public  org.apache.axiom.om.OMElement  toOM(com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.DeleteAssetResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {


                        try{
                             return param.getOMElement(com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.DeleteAssetResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }


            }

            public  org.apache.axiom.om.OMElement  toOM(com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.ModifyAsset param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {


                        try{
                             return param.getOMElement(com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.ModifyAsset.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }


            }

            public  org.apache.axiom.om.OMElement  toOM(com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.ModifyAssetResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {


                        try{
                             return param.getOMElement(com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.ModifyAssetResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }


            }

            public  org.apache.axiom.om.OMElement  toOM(com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.QueryAssetDetail param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {


                        try{
                             return param.getOMElement(com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.QueryAssetDetail.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }


            }

            public  org.apache.axiom.om.OMElement  toOM(com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.QueryAssetDetailResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {


                        try{
                             return param.getOMElement(com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.QueryAssetDetailResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }


            }

            public  org.apache.axiom.om.OMElement  toOM(com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.AddAsset param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {


                        try{
                             return param.getOMElement(com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.AddAsset.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }


            }

            public  org.apache.axiom.om.OMElement  toOM(com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.AddAssetResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {


                        try{
                             return param.getOMElement(com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.AddAssetResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }


            }


                                public  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                    com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.AssetQueryInfo param1,
                                    com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.QueryAsset dummyWrappedType,
                                 boolean optimizeContent) throws org.apache.axis2.AxisFault{

                                try{
                                com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.QueryAsset wrappedType = new com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.QueryAsset();


                                              wrappedType.setParam0(param1);


                               org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

                                        emptyEnvelope.getBody().addChild(wrappedType.getOMElement(com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.QueryAsset.MY_QNAME,factory));


                                return emptyEnvelope;
                               } catch(org.apache.axis2.databinding.ADBException e){
                                    throw org.apache.axis2.AxisFault.makeFault(e);
                               }
                               }





                             /* methods to provide back word compatibility */




                                public com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.RetAssetInfoList getQueryAssetResponse_return(
                                com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.QueryAssetResponse wrappedType){

                                        return wrappedType.get_return();

                                }



                                public com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.RetAssetGroupInfoList getQueryAssetGroupResponse_return(
                                com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.QueryAssetGroupResponse wrappedType){

                                        return wrappedType.get_return();

                                }


                                public  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                    long param1,
                                    com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.DeleteAsset dummyWrappedType,
                                 boolean optimizeContent) throws org.apache.axis2.AxisFault{

                                try{
                                com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.DeleteAsset wrappedType = new com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.DeleteAsset();


                                              wrappedType.setParam0(param1);


                               org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

                                        emptyEnvelope.getBody().addChild(wrappedType.getOMElement(com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.DeleteAsset.MY_QNAME,factory));


                                return emptyEnvelope;
                               } catch(org.apache.axis2.databinding.ADBException e){
                                    throw org.apache.axis2.AxisFault.makeFault(e);
                               }
                               }





                             /* methods to provide back word compatibility */




                                public com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.WSCommonResult getDeleteAssetResponse_return(
                                com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.DeleteAssetResponse wrappedType){

                                        return wrappedType.get_return();

                                }


                                public  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                    com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.ModifyAssetInfo param1,
                                    com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.ModifyAsset dummyWrappedType,
                                 boolean optimizeContent) throws org.apache.axis2.AxisFault{

                                try{
                                com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.ModifyAsset wrappedType = new com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.ModifyAsset();


                                              wrappedType.setParam0(param1);


                               org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

                                        emptyEnvelope.getBody().addChild(wrappedType.getOMElement(com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.ModifyAsset.MY_QNAME,factory));


                                return emptyEnvelope;
                               } catch(org.apache.axis2.databinding.ADBException e){
                                    throw org.apache.axis2.AxisFault.makeFault(e);
                               }
                               }





                             /* methods to provide back word compatibility */




                                public com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.WSCommonResult getModifyAssetResponse_return(
                                com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.ModifyAssetResponse wrappedType){

                                        return wrappedType.get_return();

                                }


                                public  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                    long param1,
                                    com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.QueryAssetDetail dummyWrappedType,
                                 boolean optimizeContent) throws org.apache.axis2.AxisFault{

                                try{
                                com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.QueryAssetDetail wrappedType = new com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.QueryAssetDetail();


                                              wrappedType.setParam0(param1);


                               org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

                                        emptyEnvelope.getBody().addChild(wrappedType.getOMElement(com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.QueryAssetDetail.MY_QNAME,factory));


                                return emptyEnvelope;
                               } catch(org.apache.axis2.databinding.ADBException e){
                                    throw org.apache.axis2.AxisFault.makeFault(e);
                               }
                               }





                             /* methods to provide back word compatibility */




                                public com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.RetAssetDetailInfo getQueryAssetDetailResponse_return(
                                com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.QueryAssetDetailResponse wrappedType){

                                        return wrappedType.get_return();

                                }


                                public  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                    com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.AddAssetInfo param1,
                                    com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.AddAsset dummyWrappedType,
                                 boolean optimizeContent) throws org.apache.axis2.AxisFault{

                                try{
                                com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.AddAsset wrappedType = new com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.AddAsset();


                                              wrappedType.setParam0(param1);


                               org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();

                                        emptyEnvelope.getBody().addChild(wrappedType.getOMElement(com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.AddAsset.MY_QNAME,factory));


                                return emptyEnvelope;
                               } catch(org.apache.axis2.databinding.ADBException e){
                                    throw org.apache.axis2.AxisFault.makeFault(e);
                               }
                               }





                             /* methods to provide back word compatibility */




                                public com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.WSCommonResult getAddAssetResponse_return(
                                com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.AddAssetResponse wrappedType){

                                        return wrappedType.get_return();

                                }



        /**
        *  get the default envelope
        */
        public org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory){
        return factory.getDefaultEnvelope();
        }


        public  java.lang.Object fromOM(
        org.apache.axiom.om.OMElement param,
        java.lang.Class type,
        java.util.Map extraNamespaces) throws org.apache.axis2.AxisFault{

        try {

                if (com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.QueryAsset.class.equals(type)){

                           return com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.QueryAsset.Factory.parse(param.getXMLStreamReaderWithoutCaching());


                }

                if (com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.QueryAssetResponse.class.equals(type)){

                           return com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.QueryAssetResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());


                }

                if (com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.QueryAssetGroupResponse.class.equals(type)){

                           return com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.QueryAssetGroupResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());


                }

                if (com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.DeleteAsset.class.equals(type)){

                           return com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.DeleteAsset.Factory.parse(param.getXMLStreamReaderWithoutCaching());


                }

                if (com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.DeleteAssetResponse.class.equals(type)){

                           return com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.DeleteAssetResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());


                }

                if (com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.ModifyAsset.class.equals(type)){

                           return com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.ModifyAsset.Factory.parse(param.getXMLStreamReaderWithoutCaching());


                }

                if (com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.ModifyAssetResponse.class.equals(type)){

                           return com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.ModifyAssetResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());


                }

                if (com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.QueryAssetDetail.class.equals(type)){

                           return com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.QueryAssetDetail.Factory.parse(param.getXMLStreamReaderWithoutCaching());


                }

                if (com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.QueryAssetDetailResponse.class.equals(type)){

                           return com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.QueryAssetDetailResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());


                }

                if (com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.AddAsset.class.equals(type)){

                           return com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.AddAsset.Factory.parse(param.getXMLStreamReaderWithoutCaching());


                }

                if (com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.AddAssetResponse.class.equals(type)){

                           return com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.AddAssetResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());


                }

        } catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
           return null;
        }




   }
