
/**
 * ImcplatUserServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:35 LKT)
 */

    package com.h3c.imc.acmws.platuserservice.client;

    /**
     *  ImcplatUserServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class ImcplatUserServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public ImcplatUserServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public ImcplatUserServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for cancelUserForPreReg method
            * override this method for handling normal response from cancelUserForPreReg operation
            */
           public void receiveResultcancelUserForPreReg(
                    com.h3c.imc.acmws.platuserservice.client.ImcplatUserServiceStub.WSCommonResult result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from cancelUserForPreReg operation
           */
            public void receiveErrorcancelUserForPreReg(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addUserForPreReg method
            * override this method for handling normal response from addUserForPreReg operation
            */
           public void receiveResultaddUserForPreReg(
                    com.h3c.imc.acmws.platuserservice.client.ImcplatUserServiceStub.WSCommonResult result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addUserForPreReg operation
           */
            public void receiveErroraddUserForPreReg(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for queryUserById method
            * override this method for handling normal response from queryUserById operation
            */
           public void receiveResultqueryUserById(
                    com.h3c.imc.acmws.platuserservice.client.ImcplatUserServiceStub.WSUser result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from queryUserById operation
           */
            public void receiveErrorqueryUserById(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for queryUserByNameAndIdentity method
            * override this method for handling normal response from queryUserByNameAndIdentity operation
            */
           public void receiveResultqueryUserByNameAndIdentity(
                    com.h3c.imc.acmws.platuserservice.client.ImcplatUserServiceStub.WSUser result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from queryUserByNameAndIdentity operation
           */
            public void receiveErrorqueryUserByNameAndIdentity(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for modifyUser method
            * override this method for handling normal response from modifyUser operation
            */
           public void receiveResultmodifyUser(
                    com.h3c.imc.acmws.platuserservice.client.ImcplatUserServiceStub.WSCommonResult result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from modifyUser operation
           */
            public void receiveErrormodifyUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for addUser method
            * override this method for handling normal response from addUser operation
            */
           public void receiveResultaddUser(
                    com.h3c.imc.acmws.platuserservice.client.ImcplatUserServiceStub.WSCommonResult result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addUser operation
           */
            public void receiveErroraddUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for queryAllUser method
            * override this method for handling normal response from queryAllUser operation
            */
           public void receiveResultqueryAllUser(
                    com.h3c.imc.acmws.platuserservice.client.ImcplatUserServiceStub.WSUserArray result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from queryAllUser operation
           */
            public void receiveErrorqueryAllUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for modifyUserForPreReg method
            * override this method for handling normal response from modifyUserForPreReg operation
            */
           public void receiveResultmodifyUserForPreReg(
                    com.h3c.imc.acmws.platuserservice.client.ImcplatUserServiceStub.WSCommonResult result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from modifyUserForPreReg operation
           */
            public void receiveErrormodifyUserForPreReg(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for queryAllUserAppendsForPreRegister method
            * override this method for handling normal response from queryAllUserAppendsForPreRegister operation
            */
           public void receiveResultqueryAllUserAppendsForPreRegister(
                    com.h3c.imc.acmws.platuserservice.client.ImcplatUserServiceStub.WSUserAppendArray result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from queryAllUserAppendsForPreRegister operation
           */
            public void receiveErrorqueryAllUserAppendsForPreRegister(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for queryUserByIdForPreReg method
            * override this method for handling normal response from queryUserByIdForPreReg operation
            */
           public void receiveResultqueryUserByIdForPreReg(
                    com.h3c.imc.acmws.platuserservice.client.ImcplatUserServiceStub.WSUser result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from queryUserByIdForPreReg operation
           */
            public void receiveErrorqueryUserByIdForPreReg(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for cancelUser method
            * override this method for handling normal response from cancelUser operation
            */
           public void receiveResultcancelUser(
                    com.h3c.imc.acmws.platuserservice.client.ImcplatUserServiceStub.WSCommonResult result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from cancelUser operation
           */
            public void receiveErrorcancelUser(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for queryAllUserGroup method
            * override this method for handling normal response from queryAllUserGroup operation
            */
           public void receiveResultqueryAllUserGroup(
                    com.h3c.imc.acmws.platuserservice.client.ImcplatUserServiceStub.WSUserGroupArray result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from queryAllUserGroup operation
           */
            public void receiveErrorqueryAllUserGroup(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for queryUserByNameAndIdentityForPreReg method
            * override this method for handling normal response from queryUserByNameAndIdentityForPreReg operation
            */
           public void receiveResultqueryUserByNameAndIdentityForPreReg(
                    com.h3c.imc.acmws.platuserservice.client.ImcplatUserServiceStub.WSUser result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from queryUserByNameAndIdentityForPreReg operation
           */
            public void receiveErrorqueryUserByNameAndIdentityForPreReg(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for queryUserGroupById method
            * override this method for handling normal response from queryUserGroupById operation
            */
           public void receiveResultqueryUserGroupById(
                    com.h3c.imc.acmws.platuserservice.client.ImcplatUserServiceStub.WSUserGroup result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from queryUserGroupById operation
           */
            public void receiveErrorqueryUserGroupById(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for queryAllUserAppend method
            * override this method for handling normal response from queryAllUserAppend operation
            */
           public void receiveResultqueryAllUserAppend(
                    com.h3c.imc.acmws.platuserservice.client.ImcplatUserServiceStub.WSUserAppendArray result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from queryAllUserAppend operation
           */
            public void receiveErrorqueryAllUserAppend(java.lang.Exception e) {
            }
                


    }
    