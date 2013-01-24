
/**
 * ImcplatOperatorServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:35 LKT)
 */

    package com.h3c.imc.acmws.operatorservice.client;

    /**
     *  ImcplatOperatorServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class ImcplatOperatorServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public ImcplatOperatorServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public ImcplatOperatorServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for insertLog method
            * override this method for handling normal response from insertLog operation
            */
           public void receiveResultinsertLog(
                    com.h3c.imc.acmws.operatorservice.client.ImcplatOperatorServiceStub.WSCommonResult result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from insertLog operation
           */
            public void receiveErrorinsertLog(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for isOperatorExisted method
            * override this method for handling normal response from isOperatorExisted operation
            */
           public void receiveResultisOperatorExisted(
                    com.h3c.imc.acmws.operatorservice.client.ImcplatOperatorServiceStub.WSCommonResult result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from isOperatorExisted operation
           */
            public void receiveErrorisOperatorExisted(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for queryUserGroupsOfOperatorName method
            * override this method for handling normal response from queryUserGroupsOfOperatorName operation
            */
           public void receiveResultqueryUserGroupsOfOperatorName(
                    com.h3c.imc.acmws.operatorservice.client.ImcplatOperatorServiceStub.WSUserGroupArray result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from queryUserGroupsOfOperatorName operation
           */
            public void receiveErrorqueryUserGroupsOfOperatorName(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for modifyPassword method
            * override this method for handling normal response from modifyPassword operation
            */
           public void receiveResultmodifyPassword(
                    com.h3c.imc.acmws.operatorservice.client.ImcplatOperatorServiceStub.WSCommonResult result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from modifyPassword operation
           */
            public void receiveErrormodifyPassword(java.lang.Exception e) {
            }
                


    }
    