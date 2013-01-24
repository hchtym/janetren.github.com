
/**
 * CustomQueryServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:35 LKT)
 */

    package com.h3c.imc.acmws.acmuserservice.client;

    /**
     *  CustomQueryServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class CustomQueryServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public CustomQueryServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public CustomQueryServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for multiQuery method
            * override this method for handling normal response from multiQuery operation
            */
           public void receiveResultmultiQuery(
                    com.h3c.imc.acmws.acmuserservice.client.CustomQueryServiceStub.RetMultiResult result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from multiQuery operation
           */
            public void receiveErrormultiQuery(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for singleQuery method
            * override this method for handling normal response from singleQuery operation
            */
           public void receiveResultsingleQuery(
                    com.h3c.imc.acmws.acmuserservice.client.CustomQueryServiceStub.RetSingleResult result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from singleQuery operation
           */
            public void receiveErrorsingleQuery(java.lang.Exception e) {
            }
                


    }
    