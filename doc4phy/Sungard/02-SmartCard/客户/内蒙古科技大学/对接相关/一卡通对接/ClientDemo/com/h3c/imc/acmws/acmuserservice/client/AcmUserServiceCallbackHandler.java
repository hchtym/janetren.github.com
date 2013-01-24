
/**
 * AcmUserServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:35 LKT)
 */

    package com.h3c.imc.acmws.acmuserservice.client;

    /**
     *  AcmUserServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class AcmUserServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public AcmUserServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public AcmUserServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for querySyncPolicyUserInfoList method
            * override this method for handling normal response from querySyncPolicyUserInfoList operation
            */
           public void receiveResultquerySyncPolicyUserInfoList(
                    com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.RetAcmSyncPolicyUserInfoList result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from querySyncPolicyUserInfoList operation
           */
            public void receiveErrorquerySyncPolicyUserInfoList(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for queryAcmUserByPlatUserId method
            * override this method for handling normal response from queryAcmUserByPlatUserId operation
            */
           public void receiveResultqueryAcmUserByPlatUserId(
                    com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.RetAcmUser result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from queryAcmUserByPlatUserId operation
           */
            public void receiveErrorqueryAcmUserByPlatUserId(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for queryBlackList method
            * override this method for handling normal response from queryBlackList operation
            */
           public void receiveResultqueryBlackList(
                    com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.RetAcmBlackInfoList result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from queryBlackList operation
           */
            public void receiveErrorqueryBlackList(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for randomReq method
            * override this method for handling normal response from randomReq operation
            */
           public void receiveResultrandomReq(
                    com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.RetRandomInfo result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from randomReq operation
           */
            public void receiveErrorrandomReq(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for forceDelete method
            * override this method for handling normal response from forceDelete operation
            */
           public void receiveResultforceDelete(
                    com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.WSCommonResult result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from forceDelete operation
           */
            public void receiveErrorforceDelete(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for cancelAcmUser method
            * override this method for handling normal response from cancelAcmUser operation
            */
           public void receiveResultcancelAcmUser(
                    com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.WSCommonResult result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from cancelAcmUser operation
           */
            public void receiveErrorcancelAcmUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for kickOut method
            * override this method for handling normal response from kickOut operation
            */
           public void receiveResultkickOut(
                    com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.WSCommonResult result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from kickOut operation
           */
            public void receiveErrorkickOut(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addAcmUser method
            * override this method for handling normal response from addAcmUser operation
            */
           public void receiveResultaddAcmUser(
                    com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.WSCommonResult result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addAcmUser operation
           */
            public void receiveErroraddAcmUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for applyService method
            * override this method for handling normal response from applyService operation
            */
           public void receiveResultapplyService(
                    com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.WSCommonResult result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from applyService operation
           */
            public void receiveErrorapplyService(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for queryAcmUserPassword method
            * override this method for handling normal response from queryAcmUserPassword operation
            */
           public void receiveResultqueryAcmUserPassword(
                    com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.RetPassword result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from queryAcmUserPassword operation
           */
            public void receiveErrorqueryAcmUserPassword(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for queryServiceTemplateList method
            * override this method for handling normal response from queryServiceTemplateList operation
            */
           public void receiveResultqueryServiceTemplateList(
                    com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.RetAcmServiceTemplateInfoList result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from queryServiceTemplateList operation
           */
            public void receiveErrorqueryServiceTemplateList(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for modifyAcmUser method
            * override this method for handling normal response from modifyAcmUser operation
            */
           public void receiveResultmodifyAcmUser(
                    com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.WSCommonResult result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from modifyAcmUser operation
           */
            public void receiveErrormodifyAcmUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for queryAcmOnlineUserList method
            * override this method for handling normal response from queryAcmOnlineUserList operation
            */
           public void receiveResultqueryAcmOnlineUserList(
                    com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.RetAcmOnlineUserList result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from queryAcmOnlineUserList operation
           */
            public void receiveErrorqueryAcmOnlineUserList(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for cancelAcctUser method
            * override this method for handling normal response from cancelAcctUser operation
            */
           public void receiveResultcancelAcctUser(
                    com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.RetCancelUserInfo result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from cancelAcctUser operation
           */
            public void receiveErrorcancelAcctUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for cancelService method
            * override this method for handling normal response from cancelService operation
            */
           public void receiveResultcancelService(
                    com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.RetCancelServiceInfo result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from cancelService operation
           */
            public void receiveErrorcancelService(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for sendMessage method
            * override this method for handling normal response from sendMessage operation
            */
           public void receiveResultsendMessage(
                    com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.WSCommonResult result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from sendMessage operation
           */
            public void receiveErrorsendMessage(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for queryAcmUser method
            * override this method for handling normal response from queryAcmUser operation
            */
           public void receiveResultqueryAcmUser(
                    com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.RetAcmUser result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from queryAcmUser operation
           */
            public void receiveErrorqueryAcmUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for modifyInvalidTime method
            * override this method for handling normal response from modifyInvalidTime operation
            */
           public void receiveResultmodifyInvalidTime(
                    com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.WSCommonResult result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from modifyInvalidTime operation
           */
            public void receiveErrormodifyInvalidTime(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for querySyncPolicyInfoList method
            * override this method for handling normal response from querySyncPolicyInfoList operation
            */
           public void receiveResultquerySyncPolicyInfoList(
                    com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.RetAcmSyncPolicyInfoList result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from querySyncPolicyInfoList operation
           */
            public void receiveErrorquerySyncPolicyInfoList(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for cancelBindingUser method
            * override this method for handling normal response from cancelBindingUser operation
            */
           public void receiveResultcancelBindingUser(
                    com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.WSCommonResult result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from cancelBindingUser operation
           */
            public void receiveErrorcancelBindingUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for modifyUserPassword method
            * override this method for handling normal response from modifyUserPassword operation
            */
           public void receiveResultmodifyUserPassword(
                    com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.WSCommonResult result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from modifyUserPassword operation
           */
            public void receiveErrormodifyUserPassword(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addBindingUser method
            * override this method for handling normal response from addBindingUser operation
            */
           public void receiveResultaddBindingUser(
                    com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.WSCommonResult result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addBindingUser operation
           */
            public void receiveErroraddBindingUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for forceLogout method
            * override this method for handling normal response from forceLogout operation
            */
           public void receiveResultforceLogout(
                    com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.WSCommonResult result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from forceLogout operation
           */
            public void receiveErrorforceLogout(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for queryAcmUserServiceInfo method
            * override this method for handling normal response from queryAcmUserServiceInfo operation
            */
           public void receiveResultqueryAcmUserServiceInfo(
                    com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.RetAcmUserService result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from queryAcmUserServiceInfo operation
           */
            public void receiveErrorqueryAcmUserServiceInfo(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for queryAcmUserList method
            * override this method for handling normal response from queryAcmUserList operation
            */
           public void receiveResultqueryAcmUserList(
                    com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.RetAcmUserList result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from queryAcmUserList operation
           */
            public void receiveErrorqueryAcmUserList(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for clearOnlineInfo method
            * override this method for handling normal response from clearOnlineInfo operation
            */
           public void receiveResultclearOnlineInfo(
                    com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.WSCommonResult result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from clearOnlineInfo operation
           */
            public void receiveErrorclearOnlineInfo(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for queryAcmAccessDetailList method
            * override this method for handling normal response from queryAcmAccessDetailList operation
            */
           public void receiveResultqueryAcmAccessDetailList(
                    com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.RetAcmAccessDetailList result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from queryAcmAccessDetailList operation
           */
            public void receiveErrorqueryAcmAccessDetailList(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for queryParameterByName method
            * override this method for handling normal response from queryParameterByName operation
            */
           public void receiveResultqueryParameterByName(
                    com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.RetSystemParameter result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from queryParameterByName operation
           */
            public void receiveErrorqueryParameterByName(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for removeBlackList method
            * override this method for handling normal response from removeBlackList operation
            */
           public void receiveResultremoveBlackList(
                    com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.WSCommonResult result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from removeBlackList operation
           */
            public void receiveErrorremoveBlackList(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addBlackList method
            * override this method for handling normal response from addBlackList operation
            */
           public void receiveResultaddBlackList(
                    com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.WSCommonResult result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addBlackList operation
           */
            public void receiveErroraddBlackList(java.lang.Exception e) {
            }
                


    }
    