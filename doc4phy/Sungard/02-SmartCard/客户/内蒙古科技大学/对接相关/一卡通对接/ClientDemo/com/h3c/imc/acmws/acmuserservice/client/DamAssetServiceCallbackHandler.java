
/**
 * DamAssetServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:35 LKT)
 */

    package com.h3c.imc.acmws.acmuserservice.client;

    /**
     *  DamAssetServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class DamAssetServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public DamAssetServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public DamAssetServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }


           /**
            * auto generated Axis2 call back method for queryAsset method
            * override this method for handling normal response from queryAsset operation
            */
           public void receiveResultqueryAsset(
                    com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.RetAssetInfoList result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from queryAsset operation
           */
            public void receiveErrorqueryAsset(java.lang.Exception e) {
            }

           /**
            * auto generated Axis2 call back method for queryAssetGroup method
            * override this method for handling normal response from queryAssetGroup operation
            */
           public void receiveResultqueryAssetGroup(
                    com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.RetAssetGroupInfoList result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from queryAssetGroup operation
           */
            public void receiveErrorqueryAssetGroup(java.lang.Exception e) {
            }

           /**
            * auto generated Axis2 call back method for deleteAsset method
            * override this method for handling normal response from deleteAsset operation
            */
           public void receiveResultdeleteAsset(
                    com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.WSCommonResult result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from deleteAsset operation
           */
            public void receiveErrordeleteAsset(java.lang.Exception e) {
            }

           /**
            * auto generated Axis2 call back method for modifyAsset method
            * override this method for handling normal response from modifyAsset operation
            */
           public void receiveResultmodifyAsset(
                    com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.WSCommonResult result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from modifyAsset operation
           */
            public void receiveErrormodifyAsset(java.lang.Exception e) {
            }

           /**
            * auto generated Axis2 call back method for queryAssetDetail method
            * override this method for handling normal response from queryAssetDetail operation
            */
           public void receiveResultqueryAssetDetail(
                    com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.RetAssetDetailInfo result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from queryAssetDetail operation
           */
            public void receiveErrorqueryAssetDetail(java.lang.Exception e) {
            }

           /**
            * auto generated Axis2 call back method for addAsset method
            * override this method for handling normal response from addAsset operation
            */
           public void receiveResultaddAsset(
                    com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.WSCommonResult result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from addAsset operation
           */
            public void receiveErroraddAsset(java.lang.Exception e) {
            }



    }
