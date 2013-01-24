/*
 * Copyright (c) 2009, Hangzhou H3C Technologies Co., Ltd. All rights reserved.
 * <http://www.h3c.com/>
 *------------------------------------------------------------------------------
 * Product     : iMC V300R006
 * Module Name : EAD
 * Date Created: 2009-3-10
 * Creator     : PH745
 * Description :
 *
 *------------------------------------------------------------------------------
 * Modification History
 * DATE        NAME             DESCRIPTION
 *------------------------------------------------------------------------------
 *
 *
 *------------------------------------------------------------------------------
 */
package com.h3c.imc.acmws.acmuserservice.client;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.ws.security.WSPasswordCallback;

/**
 * Handler of server password calling back.
 * @author PH745
 */
public class PWCBHandler implements CallbackHandler {

    public PWCBHandler() {

    }

    public void handle(Callback callbacks[]) throws IOException,
        UnsupportedCallbackException {
        for (int i = 0; i < callbacks.length; i++) {
            WSPasswordCallback pwcb = (WSPasswordCallback) callbacks[i];
            String id = pwcb.getIdentifer();
            if ("client".equals(id)) {
                pwcb.setPassword("imcws-client");
            }
        }
    }
}
