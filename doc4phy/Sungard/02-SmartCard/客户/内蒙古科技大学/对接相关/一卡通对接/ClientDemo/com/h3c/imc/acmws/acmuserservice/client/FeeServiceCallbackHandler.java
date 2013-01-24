
/**
 * FeeServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:35 LKT)
 */

    package com.h3c.imc.acmws.acmuserservice.client;

    /**
     *  FeeServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class FeeServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public FeeServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public FeeServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for suspendUserById method
            * override this method for handling normal response from suspendUserById operation
            */
           public void receiveResultsuspendUserById(
                    com.h3c.imc.acmws.acmuserservice.client.FeeServiceStub.WSCommonResult result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from suspendUserById operation
           */
            public void receiveErrorsuspendUserById(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for pay method
            * override this method for handling normal response from pay operation
            */
           public void receiveResultpay(
                    com.h3c.imc.acmws.acmuserservice.client.FeeServiceStub.WSCommonResult result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from pay operation
           */
            public void receiveErrorpay(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for cancelSuspendUserById method
            * override this method for handling normal response from cancelSuspendUserById operation
            */
           public void receiveResultcancelSuspendUserById(
                    com.h3c.imc.acmws.acmuserservice.client.FeeServiceStub.WSCommonResult result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from cancelSuspendUserById operation
           */
            public void receiveErrorcancelSuspendUserById(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for queryBillDetailByBillId method
            * override this method for handling normal response from queryBillDetailByBillId operation
            */
           public void receiveResultqueryBillDetailByBillId(
                    com.h3c.imc.acmws.acmuserservice.client.FeeServiceStub.RetAcmBillDetailList result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from queryBillDetailByBillId operation
           */
            public void receiveErrorqueryBillDetailByBillId(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for queryBillByUserId method
            * override this method for handling normal response from queryBillByUserId operation
            */
           public void receiveResultqueryBillByUserId(
                    com.h3c.imc.acmws.acmuserservice.client.FeeServiceStub.RetAcmUserBillList result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from queryBillByUserId operation
           */
            public void receiveErrorqueryBillByUserId(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for queryBalance method
            * override this method for handling normal response from queryBalance operation
            */
           public void receiveResultqueryBalance(
                    com.h3c.imc.acmws.acmuserservice.client.FeeServiceStub.RetUserBalance result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from queryBalance operation
           */
            public void receiveErrorqueryBalance(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for queryPaymentRecord method
            * override this method for handling normal response from queryPaymentRecord operation
            */
           public void receiveResultqueryPaymentRecord(
                    com.h3c.imc.acmws.acmuserservice.client.FeeServiceStub.RetPaymentRecordList result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from queryPaymentRecord operation
           */
            public void receiveErrorqueryPaymentRecord(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for randomReq method
            * override this method for handling normal response from randomReq operation
            */
           public void receiveResultrandomReq(
                    com.h3c.imc.acmws.acmuserservice.client.FeeServiceStub.RandomInfo result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from randomReq operation
           */
            public void receiveErrorrandomReq(java.lang.Exception e) {
            }
                


    }
    