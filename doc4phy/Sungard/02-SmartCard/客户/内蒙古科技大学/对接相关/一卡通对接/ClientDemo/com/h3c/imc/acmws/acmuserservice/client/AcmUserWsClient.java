/*
 * Copyright (c) 2009, Hangzhou H3C Technologies Co., Ltd. All rights reserved.
 * <http://www.h3c.com/>
 *------------------------------------------------------------------------------
 * Product     : iMC V300R006
 * Module Name :
 * Date Created: 2009-3-26
 * Creator     : jiaxun
 * Description :
 *
 *------------------------------------------------------------------------------
 * Modification History
 * DATE        NAME             DESCRIPTION
 *------------------------------------------------------------------------------
 * YYYY-MM-DD  John             XXXX project, new code file.
 *
 *------------------------------------------------------------------------------
 */
package com.h3c.imc.acmws.acmuserservice.client;

import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.context.ConfigurationContextFactory;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.neethi.Policy;
import org.apache.neethi.PolicyEngine;
import org.apache.rampart.RampartMessageData;

import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.AcmAccessDetailQueryParam;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.AcmAccessDetailSimpleInfo;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.AcmBlackQueryParam;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.AcmOnlineUserQueryParam;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.AcmOnlineUserSimpleInfo;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.AcmServiceTemplateQueryParam;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.AcmSyncPolicyQueryParam;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.AcmSyncPolicyUserQueryParam;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.AcmUserListQueryParam;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.AcmUserSimpleInfo;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.AddAcmUser;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.AddAcmUserParam;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.AddAcmUserResponse;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.AddBindingUser;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.AddBindingUserResponse;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.AddBlackList;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.AddBlackListResponse;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.ApplyService;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.ApplyServiceInfo;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.ApplyServiceParam;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.ApplyServiceResponse;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.CancelAcmUser;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.CancelAcmUserResponse;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.CancelBindingUser;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.CancelBindingUserResponse;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.CancelService;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.CancelServiceParam;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.CancelServiceResponse;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.ClearOnlineInfo;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.ClearOnlineInfoResponse;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.IpMacInfo;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.KickOut;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.KickOutResponse;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.ModifyAcmUser;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.ModifyAcmUserParam;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.ModifyAcmUserResponse;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.ModifyInvalidTime;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.ModifyInvalidTimeResponse;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.ModifyUserPassword;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.ModifyUserPsdParam;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.QueryAcmAccessDetailList;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.QueryAcmAccessDetailListResponse;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.QueryAcmOnlineUserList;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.QueryAcmOnlineUserListResponse;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.QueryAcmUser;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.QueryAcmUserByPlatUserId;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.QueryAcmUserByPlatUserIdResponse;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.QueryAcmUserList;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.QueryAcmUserListResponse;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.QueryAcmUserResponse;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.QueryBlackList;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.QueryBlackListResponse;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.QueryParameterByName;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.QueryParameterByNameResponse;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.QueryServiceTemplateList;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.QueryServiceTemplateListResponse;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.QuerySyncPolicyInfoList;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.QuerySyncPolicyInfoListResponse;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.QuerySyncPolicyUserInfoList;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.QuerySyncPolicyUserInfoListResponse;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.RemoveBlackList;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.RemoveBlackListResponse;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.RetAcmAccessDetailList;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.RetAcmBlackInfo;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.RetAcmBlackInfoList;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.RetAcmOnlineUserList;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.RetAcmServiceTemplateInfo;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.RetAcmServiceTemplateInfoList;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.RetAcmSyncPolicyInfo;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.RetAcmSyncPolicyInfoList;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.RetAcmSyncPolicyUserInfo;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.RetAcmSyncPolicyUserInfoList;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.RetAcmUser;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.RetAcmUserList;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.RetSystemParameter;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.SendMessage;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.SendMessageResponse;
import com.h3c.imc.acmws.acmuserservice.client.AcmUserServiceStub.WSCommonResult;
import com.h3c.imc.acmws.acmuserservice.client.CustomQueryServiceStub.MultiQuery;
import com.h3c.imc.acmws.acmuserservice.client.CustomQueryServiceStub.MultiQueryResponse;
import com.h3c.imc.acmws.acmuserservice.client.CustomQueryServiceStub.QueryActionInfo;
import com.h3c.imc.acmws.acmuserservice.client.CustomQueryServiceStub.Record;
import com.h3c.imc.acmws.acmuserservice.client.CustomQueryServiceStub.RetMultiResult;
import com.h3c.imc.acmws.acmuserservice.client.CustomQueryServiceStub.RetSingleResult;
import com.h3c.imc.acmws.acmuserservice.client.CustomQueryServiceStub.SingleQuery;
import com.h3c.imc.acmws.acmuserservice.client.CustomQueryServiceStub.SingleQueryResponse;
import com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.AddAsset;
import com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.AddAssetInfo;
import com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.AddAssetResponse;
import com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.AssetQueryInfo;
import com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.DeleteAsset;
import com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.DeleteAssetResponse;
import com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.ModifyAsset;
import com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.ModifyAssetInfo;
import com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.ModifyAssetResponse;
import com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.QueryAsset;
import com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.QueryAssetDetail;
import com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.QueryAssetDetailResponse;
import com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.QueryAssetGroupResponse;
import com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.QueryAssetResponse;
import com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.RetAssetDetailInfo;
import com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.RetAssetGroupInfo;
import com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.RetAssetGroupInfoList;
import com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.RetAssetInfo;
import com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.RetAssetInfoList;
import com.h3c.imc.acmws.acmuserservice.client.FeeServiceStub.AcmBillDetailSimpleInfo;
import com.h3c.imc.acmws.acmuserservice.client.FeeServiceStub.AcmUserBillSimpleInfo;
import com.h3c.imc.acmws.acmuserservice.client.FeeServiceStub.CancelSuspendUserById;
import com.h3c.imc.acmws.acmuserservice.client.FeeServiceStub.CancelSuspendUserByIdResponse;
import com.h3c.imc.acmws.acmuserservice.client.FeeServiceStub.Pay;
import com.h3c.imc.acmws.acmuserservice.client.FeeServiceStub.PayResponse;
import com.h3c.imc.acmws.acmuserservice.client.FeeServiceStub.PaymentInfo;
import com.h3c.imc.acmws.acmuserservice.client.FeeServiceStub.PaymentRecordInfo;
import com.h3c.imc.acmws.acmuserservice.client.FeeServiceStub.QueryBalance;
import com.h3c.imc.acmws.acmuserservice.client.FeeServiceStub.QueryBalanceResponse;
import com.h3c.imc.acmws.acmuserservice.client.FeeServiceStub.QueryBillByUserId;
import com.h3c.imc.acmws.acmuserservice.client.FeeServiceStub.QueryBillByUserIdResponse;
import com.h3c.imc.acmws.acmuserservice.client.FeeServiceStub.QueryBillDetailByBillId;
import com.h3c.imc.acmws.acmuserservice.client.FeeServiceStub.QueryBillDetailByBillIdResponse;
import com.h3c.imc.acmws.acmuserservice.client.FeeServiceStub.QueryPaymentRecord;
import com.h3c.imc.acmws.acmuserservice.client.FeeServiceStub.QueryPaymentRecordResponse;
import com.h3c.imc.acmws.acmuserservice.client.FeeServiceStub.RetAcmBillDetailList;
import com.h3c.imc.acmws.acmuserservice.client.FeeServiceStub.RetAcmUserBillList;
import com.h3c.imc.acmws.acmuserservice.client.FeeServiceStub.RetPaymentRecordList;
import com.h3c.imc.acmws.acmuserservice.client.FeeServiceStub.RetUserBalance;
import com.h3c.imc.acmws.acmuserservice.client.FeeServiceStub.SuspendUserById;
import com.h3c.imc.acmws.acmuserservice.client.FeeServiceStub.SuspendUserByIdResponse;
import com.h3c.imc.acmws.platservice.client.ImcplatServiceStub;
import com.h3c.imc.acmws.platservice.client.ImcplatServiceStub.Login;
import com.h3c.imc.acmws.platservice.client.ImcplatServiceStub.LoginResponse;
import com.h3c.imc.acmws.platservice.client.ImcplatServiceStub.LogoutResponse;
import com.h3c.imc.acmws.platuserservice.client.ImcplatUserServiceStub;
import com.h3c.imc.acmws.platuserservice.client.ImcplatUserServiceStub.AddUser;
import com.h3c.imc.acmws.platuserservice.client.ImcplatUserServiceStub.AddUserResponse;
import com.h3c.imc.acmws.platuserservice.client.ImcplatUserServiceStub.QueryAllUser;
import com.h3c.imc.acmws.platuserservice.client.ImcplatUserServiceStub.QueryAllUserGroupResponse;
import com.h3c.imc.acmws.platuserservice.client.ImcplatUserServiceStub.QueryAllUserResponse;
import com.h3c.imc.acmws.platuserservice.client.ImcplatUserServiceStub.QueryUserByNameAndIdentity;
import com.h3c.imc.acmws.platuserservice.client.ImcplatUserServiceStub.QueryUserByNameAndIdentityResponse;
import com.h3c.imc.acmws.platuserservice.client.ImcplatUserServiceStub.User;
import com.h3c.imc.acmws.platuserservice.client.ImcplatUserServiceStub.UserAppendInfo;
import com.h3c.imc.acmws.platuserservice.client.ImcplatUserServiceStub.UserGroup;
import com.h3c.imc.acmws.platuserservice.client.ImcplatUserServiceStub.WSUser;
import com.h3c.imc.acmws.platuserservice.client.ImcplatUserServiceStub.WSUserArray;
import com.h3c.imc.acmws.platuserservice.client.ImcplatUserServiceStub.WSUserGroupArray;

/**
 * ���ο����ӿڿͻ���������
 *
 * @author jiaxun & fujiangnan
 */
public class AcmUserWsClient {

	/** ip��ַ */
	private static String ipAddress;

	/** �˿� */
	private static String port;

	/** �Ƿ���� */
	private static boolean rampart;

	/** �����ʲ�����ʲ���� */
	private static String assetNo;

	/** Ĭ�Ϸ���ID */
	private static final long GROUP_ID = 1;

	/** ͬ������ID */
	private static long policyId;

	/** �����û�ID */
	private static long userId;

	/** ����ƽ̨�û�ID */
	private static long platUserId;

	/** �����û��� */
	private static String accountName;

	/** ��Ҫע���ķ���ID���� */
	private static long[] serviceIdArray = new long[1];

	/** ��ѯ�����������û��б� */
	private static AcmOnlineUserSimpleInfo[] acmOnlineUserArray;

	/**
	 * ���ο����ӿڿͻ���������
	 *
	 * @param args �����в���
	 * @throws Exception �׳��쳣
	 */
	public static void main(String[] args) throws Exception {
		String ptIpAddress = "(((1[0-9][0-9])|(2[0-4][0-9])|(25[0-5])|([1-9][0-9])|([0-9]))\\.){3}((1[0-9][0-9])|(2[0-4][0-9])|(25[0-5])|([1-9][0-9])|([0-9]))";

		if (args.length == 0) {
			ipAddress = "127.0.0.1";
			port = "8080";
			rampart = false;
		} else if (args.length == 2) {
			if (args[0].matches(ptIpAddress)) {
				ipAddress = args[0];
			} else {
				System.out.println("��Ч��IP��ַ��");
				System.exit(0);
			}

			try {
				int ptPort = Integer.parseInt(args[1]);
				if (ptPort < 0 || ptPort > 65535) {
					throw new Exception("invalid port");
				}
			} catch (Exception e) {
				System.out.println("��Ч�Ķ˿ںš�");
				System.exit(0);
			}

			port = args[1];
			rampart = false;

		} else if (args.length == 3) {
			if (args[0].matches(ptIpAddress)) {
				ipAddress = args[0];
			} else {
				System.out.println("��Ч��IP��ַ��");
				System.exit(0);
			}

			try {
				int ptPort = Integer.parseInt(args[1]);
				if (ptPort < 0 || ptPort > 65535) {
					throw new Exception("invalid port");
				}
			} catch (Exception e) {
				System.out.println("��Ч�Ķ˿ںš�");
				System.exit(0);
			}

			port = args[1];

			if (args[2].equals("-r")) {
				rampart = true;
			} else {
				System.out.println("������" + args[2] + "����Ч��");
				System.exit(0);
			}

		} else {
			System.out.println("�밴���¸�ʽ�������: IP Port [-r]");
			System.out.println("-r �Ƿ����");
			System.exit(0);
		}

		// ��ʼ��
		String imcPlatEndpointStr = new StringBuilder("http://").append(
				ipAddress).append(":").append(port).append(
				"/imcws/services/imcplatService").toString();

		String imcUserEndporintStr = new StringBuilder("http://").append(
				ipAddress).append(":").append(port).append(
				"/imcws/services/imcplatUserService").toString();

		String damEndpointStr = new StringBuilder("http://").append(ipAddress)
				.append(":").append(port).append(
						"/imcws/services/damAssetService").toString();

		String acmEndpointStr = new StringBuilder("http://").append(ipAddress)
				.append(":").append(port).append(
						"/imcws/services/acmUserService").toString();

		String feeEndpointStr = new StringBuilder("http://").append(ipAddress)
				.append(":").append(port).append("/imcws/services/feeService")
				.toString();

		String queryEndpointStr = new StringBuilder("http://")
				.append(ipAddress).append(":").append(port).append(
						"/imcws/services/customQueryService").toString();

		// �����ͻ���
		ConfigurationContext ctx = ConfigurationContextFactory
				.createConfigurationContextFromFileSystem("repository", null);
		ServiceClient sc = new ServiceClient(ctx, null);

		// ��¼ϵͳ
		login(imcPlatEndpointStr, sc);

		// ���ӽ����û�
		addAcmUser(imcUserEndporintStr, acmEndpointStr, sc);

		// �ɷ�
		pay(feeEndpointStr, sc);

		// ��ѯ���
		queryBalance(feeEndpointStr, sc);

		// ��ѯ��Ӧ�����û�
		queryAcmUser(acmEndpointStr, sc);

		// ����ƽ̨�û�ID��ѯ�û���ϸ��Ϣ
		queryAcmUserByPlatUserId(acmEndpointStr, sc);

		// ����ID�޸ĸ��û���ʧЧʱ��
		modifyInvalidTime(acmEndpointStr, sc);

		// ��ѯ�����û��б�
		queryAccessUserArray(acmEndpointStr, sc);

		// �޸Ľ����û�
		modifyAcmUser(acmEndpointStr, sc);

		// �޸�����
		modifyUserPassword(acmEndpointStr, sc);

		// ��ѯ������ϸ�б�
		queryAccessDetail(acmEndpointStr, sc);

		// // ��ѯ����ģ���б�
		// queryServerTemplateList(acmEndpointStr, sc);

		// ����󶨷������е����˲�ѯ����ģ���б�
		applyService(acmEndpointStr, sc);

		// ���Ӻ�����
		addBlackList(acmEndpointStr, sc);

		// ��ѯ������
		queryBlackList(acmEndpointStr, sc);

		// ���������
		deleteBlackList(acmEndpointStr, sc);

		// ��ѯͬ�������б�
		querySyncPolicyList(acmEndpointStr, sc);

		// ���Ӱ��û�
		addBindingUserList(acmEndpointStr, sc);

		// ��ѯͬ���������û�
		querySyncPolicyUserList(acmEndpointStr, sc);

		// ������û�
		deleteBindingUserList(acmEndpointStr, sc);

		// ��ѯ�����û�
		queryOnlineUser(acmEndpointStr, sc);

		// // �·���Ϣ
		// sendMessage(acmEndpointStr, sc);
		//
		// // ���������Ϣ
		// clearOnlineInfo(acmEndpointStr, sc);
		//
		// // ǿ������
		// kickOut(acmEndpointStr, sc);
		//

		// Add new clientDemo for cams porject
		// �����û�ID��ͣ�û�
		suspendUserByUserId(feeEndpointStr, sc);
		// �����û�IDȡ����ͣ
		cancelSuspendUserByUserId(feeEndpointStr, sc);

		// ע������
		cancelService(acmEndpointStr, sc);

		// �����û�ID��ѯ�˵�
		queryPaymentRecordByUserId(feeEndpointStr, sc);
		// ��ѯϵͳ�����ӿ�
		querySystemParamValue(acmEndpointStr, sc);

		// �����ʺ�ID��ѯ�ʵ���ϸ
		queryBillByUserId(feeEndpointStr, sc);
		// �����ʵ�ID��ѯ������ϸ
		queryBillDetailByBillId(feeEndpointStr, sc);

		// Add finish

		// ע�������û�
		deleteAcmUser(acmEndpointStr, sc);

		// �������Ʋ�ѯ
		singleQuery(queryEndpointStr, acmEndpointStr, sc);

		// �������Ʋ�ѯ
		multiQuery(queryEndpointStr, imcUserEndporintStr, sc);

		try {
			// ��ѯǰ15���ʲ�
			queryFirstPageAssets(damEndpointStr, sc);

			// ��ѯ�����ʲ�����
			queryAssetGroups(damEndpointStr, sc);

			// �����ʲ�
			addAsset(damEndpointStr, imcPlatEndpointStr, imcUserEndporintStr,
					sc);

			// �޸��ʲ�
			modifyAsset(damEndpointStr, imcPlatEndpointStr,
					imcUserEndporintStr, sc);

			// ɾ���ʲ�
			deleteAsset(damEndpointStr, imcUserEndporintStr, sc);

		} catch (Exception e) {
			System.out.println("*** ϵͳδ��װ�ʲ������***\n");
		}

		// ע��ϵͳ
		logout(imcPlatEndpointStr, sc);
	}

	/**
	 * ��ѯϵͳ����ֵ
	 *
	 * @param acmEndpointStr ����WebService url
	 * @param sc ���Կͻ���
	 * @throws Exception Exception
	 * @return value
	 */
	private static RetSystemParameter querySystemParamValue(
			String acmEndpointStr, ServiceClient sc) throws Exception {

		System.out.println("=============== ��ѯϵͳ����ֵ ===============");
		// ִ�в�ѯ�����û�����
		setOptions(acmEndpointStr, sc, "urn:queryParameterByName");

		// ���ð��û�
		AcmUserServiceStub stub = new AcmUserServiceStub();

		// �����������
		QueryParameterByName query = new QueryParameterByName();
		// ��ѯӪҵ������Ƿ�װ
		query.setParam0("IF_COUNTER_COMP_INSTALL");

		OMElement element = stub.toOM(query, true);

		// ���Ͳ�������Ϣ
		OMElement response1 = sc.sendReceive(element);
		RetSystemParameter result = QueryParameterByNameResponse.Factory.parse(
				response1.getXMLStreamReaderWithoutCaching()).get_return();

		if (result.getErrorCode() == 0) {
			System.out.println("��ѯϵͳ����ֵ :" + result.getValue());

		} else {
			System.out.println("*** ��ѯϵͳ����ֵʧ�� ***");
			System.out.println("��ѯϵͳ����ֵ ErrorCode: " + result.getErrorCode());
			System.out.println("��ѯϵͳ����ֵ ErrorMsg: " + result.getErrorMsg());
		}
		System.out.println();
		return result;
	}

	/**
	 * ��ѯ�ɷѼ�¼
	 *
	 * @param feeEndpointStr ����webService url
	 * @param sc ���Կͻ���
	 * @throws Exception exception
	 * @return �ɷѼ�¼
	 * @throws Exception exception
	 */
	private static RetPaymentRecordList queryPaymentRecordByUserId(
			String feeEndpointStr, ServiceClient sc) throws Exception {

		System.out.println("=============== ��ѯ�ɷѼ�¼�б� ===============");
		// ִ�в�ѯ�����û�����
		setOptions(feeEndpointStr, sc, "urn:queryPaymentRecord");

		// ���ò�ѯ�����û��б����
		FeeServiceStub stub = new FeeServiceStub();

		QueryPaymentRecord query = new QueryPaymentRecord();
		query.setParam0(userId);

		OMElement element = stub.toOM(query, true);

		// ���Ͳ�������Ϣ
		OMElement response1 = sc.sendReceive(element);
		RetPaymentRecordList result = QueryPaymentRecordResponse.Factory.parse(
				response1.getXMLStreamReaderWithoutCaching()).get_return();
		// ת����������
		if (result.getErrorCode() == 0) {
			System.out.println("*** ��ѯ�ɷѼ�¼�б� ***");
			System.out.printf(
					"%-10s %-20s %-15s %-15s %-20s %-20s %-20s %-20s "
							+ "%-20s %-20s %-20s %-20s", "�ɷѼ�¼ID", " ��ˮ��",
					"�ʺ���", "�ʺ�����", "�û�����", "�ɷѽ��", "�ɷ�����", "���", "�շ���Ա",
					"�ɷѷ�ʽ", "�ϴ����", "����Ա��¼IP");
			System.out.println();
			PaymentRecordInfo[] info = result.getResultList();
			if (null != info && 0 < info.length) {

				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
						"yyyy-MM-dd hh:mm:ss");
				for (PaymentRecordInfo entry : info) {
					System.out
							.printf(
									"%-10s %-20s %-15s %-15s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s",
									entry.getPaymentID(), entry.getFlowId(),
									entry.getFullName(), entry.getFeeType(),
									entry.getUserName(), entry.getPayAmount(),
									entry.getPaymentDate() == null ? "--"
											: simpleDateFormat
													.format(entry
															.getPaymentDate()
															.getTime()), entry
											.getBalance(), entry.getOperator(),
									entry.getPaymentMode(), entry
											.getLastBalance(), entry
											.getOperatorLoginIp());
					System.out.println();
				}
			} else {
				System.out.println("*** δ�ҵ����������ļ�¼ ***");
			}
		} else {
			System.out.println("*** ��ѯ�ɷѼ�¼�б�ʧ�� ***");
			System.out.println("��ѯ�ɷѼ�¼�б� ErrorCode: " + result.getErrorCode());
			System.out.println("��ѯ�ɷѼ�¼�б� ErrorMsg: " + result.getErrorMsg());
		}
		System.out.println();
		return result;
	}

	/**
	 * �����û�ID��ͣ�û�
	 *
	 * @param feeEndpointStr ����url
	 * @param sc ���Կͻ���
	 * @throws Exception exception
	 */
	private static void suspendUserByUserId(String feeEndpointStr,
			ServiceClient sc) throws Exception {

		System.out.println("=============== �����û�ID��ͣ�û� =================");

		setOptions(feeEndpointStr, sc, "urn:suspendUserById");

		// ���ð��û�
		FeeServiceStub stub = new FeeServiceStub();

		// �����������
		SuspendUserById user = new SuspendUserById();
		user.setParam0(userId);
		user.setParam1(Calendar.getInstance());
		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());
		char[] dictionary = new char[] { '1', '2', '3', '4', '5', '6', '7',
					'8', '9'};
		user.setParam2(rand.nextInt(dictionary.length));

		OMElement element = stub.toOM(user, true);

		// ���Ͳ�������Ϣ
		OMElement response1 = sc.sendReceive(element);
		com.h3c.imc.acmws.acmuserservice.client.FeeServiceStub.WSCommonResult result = SuspendUserByIdResponse.Factory
				.parse(response1.getXMLStreamReaderWithoutCaching())
				.get_return();

		if (result.getErrorCode() != 0) {
			System.out.println("*** ��ͣ�û�ʧ�ܡ�***");
			System.out.println("������: " + result.getErrorCode());
			System.out.println("������Ϣ: " + result.getErrorMsg() + "\n");
		} else {
			System.out.println("*** ��ͣ�û��ɹ���***");
		}

	}

	/**
	 * �����û�ȡ����ͣ
	 *
	 * @param feeEndpointStr ����webService url
	 * @param sc ���Կͻ���
	 * @throws Exception Exception
	 */
	private static void cancelSuspendUserByUserId(String feeEndpointStr,
			ServiceClient sc) throws Exception {

		System.out.println("=============== �����û�IDȡ����ͣ�û� =================");

		setOptions(feeEndpointStr, sc, "urn:cancelSuspendUserById");

		// ���ð��û�
		FeeServiceStub stub = new FeeServiceStub();

		// �����������
		CancelSuspendUserById user = new CancelSuspendUserById();
		user.setParam0(userId);

		OMElement element = stub.toOM(user, true);

		// ���Ͳ�������Ϣ
		OMElement response1 = sc.sendReceive(element);
		com.h3c.imc.acmws.acmuserservice.client.FeeServiceStub.WSCommonResult result = CancelSuspendUserByIdResponse.Factory
				.parse(response1.getXMLStreamReaderWithoutCaching())
				.get_return();

		if (result.getErrorCode() != 0) {
			System.out.println("*** ȡ����ͣ�û�ʧ�ܡ�***");
			System.out.println("������: " + result.getErrorCode());
			System.out.println("������Ϣ: " + result.getErrorMsg() + "\n");
		} else {
			System.out.println("*** ȡ����ͣ�û��ɹ���***");
		}

	}

	/**
	 * ����ID�޸ĸ��û���ʧЧʱ��
	 *
	 * @param acmEndpointStr ���ʵ�WebService URL
	 * @param sc ���Կͻ���
	 * @throws Exception exception
	 */
	public static void modifyInvalidTime(String acmEndpointStr, ServiceClient sc)
			throws Exception {
		System.out.println("=============== ����ID�޸ĸ��û���ʧЧʱ�� =================");

		setOptions(acmEndpointStr, sc, "urn:modifyInvalidTime");

		// ���ð��û�
		AcmUserServiceStub stub = new AcmUserServiceStub();

		// �����������
		ModifyInvalidTime time = new ModifyInvalidTime();
		time.setParam0(userId);
		time.setParam1(Calendar.getInstance());

		OMElement element = stub.toOM(time, true);

		// ���Ͳ�������Ϣ
		OMElement response1 = sc.sendReceive(element);
		WSCommonResult result = ModifyInvalidTimeResponse.Factory.parse(
				response1.getXMLStreamReaderWithoutCaching()).get_return();

		if (result.getErrorCode() != 0) {
			System.out.println("*** �޸ĸ��û���ʧЧʱ��ʧ�ܡ�***");
			System.out.println("������: " + result.getErrorCode());
			System.out.println("������Ϣ: " + result.getErrorMsg() + "\n");
		} else {
			System.out.println("*** �޸ĸ��û���ʧЧʱ��ɹ���***\n");
		}
	}

	/**
	 * ����ƽ̨�û�ID��ѯ�û���ϸ��Ϣ��
	 *
	 * @param acmEndpointStr ���ʵ�WebService URL
	 * @param sc ���Կͻ���
	 * @throws Exception exception
	 */
	public static RetAcmUser queryAcmUserByPlatUserId(String acmEndpointStr,
			ServiceClient sc) throws Exception {
		System.out
				.println("=============== ����ƽ̨�û�ID��ѯ�û���ϸ��Ϣ =================");
		setOptions(acmEndpointStr, sc, "urn:queryAcmUserByPlatUserId");

		// ���ð��û�
		AcmUserServiceStub stub = new AcmUserServiceStub();

		// �����������
		QueryAcmUserByPlatUserId user = new QueryAcmUserByPlatUserId();
		user.setParam0(platUserId);

		OMElement element = stub.toOM(user, true);

		// ���Ͳ�������Ϣ
		OMElement response1 = sc.sendReceive(element);
		RetAcmUser acmUser = QueryAcmUserByPlatUserIdResponse.Factory.parse(
				response1.getXMLStreamReaderWithoutCaching()).get_return();

		if (acmUser.getErrorCode() != 0) {
			System.out.println("*** ��ѯ�����û�ʧ�ܡ�***");
			System.out.println("������: " + acmUser.getErrorCode());
			System.out.println("������Ϣ: " + acmUser.getErrorMsg() + "\n");
		} else {
			if (null != acmUser.getAcmUser()) {
				System.out.println("*** ��ѯ�����û���"
						+ acmUser.getAcmUser().getUserName() + "�ɹ�����***\n");
			} else {
				System.out.println("*** ��ƽ̨�û�û�л�û����������û���***\n");
			}
		}
		return acmUser;
	}

	/**
	 * �����ʺ�ID��ѯ�ʵ���ϸ�б�
	 *
	 * @param endPointStr ���ʵ�WebService URL
	 * @param sc ���Կͻ���
	 * @return �ʵ���ϸ�б�
	 * @throws Exception �׳��쳣
	 */
	public static RetAcmUserBillList queryBillByUserId(String endPointStr,
			ServiceClient sc) throws Exception {
		System.out.println("=============== ��ѯ�ʵ���ϸ�б� ===============");
		// ִ�в�ѯ�����û�����
		setOptions(endPointStr, sc, "urn:queryBillByUserId");

		// ���ò�ѯ�����û��б����
		FeeServiceStub stub = new FeeServiceStub();
		QueryBillByUserId queryBillByUserId = new QueryBillByUserId();
		queryBillByUserId.setParam0(1L);
		OMElement element = stub.toOM(queryBillByUserId, true);

		// ���Ͳ�������Ϣ
		OMElement response1 = sc.sendReceive(element);
		RetAcmUserBillList result = QueryBillByUserIdResponse.Factory.parse(
				response1.getXMLStreamReaderWithoutCaching()).get_return();
		// ת����������
		if (result.getErrorCode() == 0) {
			System.out.println("*** ��ѯ�ʵ���ϸ�б�ɹ���10����¼�� ***");
			System.out
					.printf(
							"%-10s %-10s %-20s %-20s %-10s %-20s %-30s %-10s "
									+ "%-20s %-10s %-20s %-10s %-10s %-20s %-10s %-10s",
							"���", "�ʵ�ID", "�ʺ���", "������", "ҵ������", "�Ʒ����ڿ�ʼʱ��",
							"�Ʒ����ڽ���ʱ��", "���ڹ̶���", "ʹ����", "ʹ�õ�λ", "���Ѷ�", "�������",
							"�������ʹ����", "�ʵ�����ʱ��", "��������", "�ʵ�״̬");
			System.out.println();
			AcmUserBillSimpleInfo[] acmUserBillSimpleInfo = result
					.getAcmUserBillSimpleInfo();
			if (null != acmUserBillSimpleInfo
					&& 0 < acmUserBillSimpleInfo.length) {
				int count = 0;
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
						"yyyy-MM-dd hh:mm:ss");
				for (AcmUserBillSimpleInfo billInfo : acmUserBillSimpleInfo) {
					System.out
							.printf(
									"%-10s %-10s %-20s %-20s %-10s %-20s %-30s %-10s "
											+ "%-20s %-10s %-20s %-10s %-10s %-20s %-10s %-10s",
									count, billInfo.getBillID(), billInfo
											.getUserName(), billInfo
											.getServiceName(), billInfo
											.getServiceType(), billInfo
											.getStartTime() == null ? "--"
											: simpleDateFormat.format(billInfo
													.getStartTime().getTime()),
									billInfo.getEndTime() == null ? "--"
											: simpleDateFormat.format(billInfo
													.getEndTime().getTime()),
									billInfo.getFixedAmount(), billInfo
											.getUsedAmount(), billInfo
											.getUsageUnit(), billInfo
											.getUsedCash(), billInfo
											.getBonusCash(), billInfo
											.getUsedBonusCash(), billInfo
											.getBillTime() == null ? "--"
											: simpleDateFormat.format(billInfo
													.getBillTime().getTime()),
									billInfo.getBillType(), billInfo
											.getBillStatus());
					System.out.println();
					count += 1;
				}
			} else {
				System.out.println("*** δ�ҵ����������ļ�¼ ***");
			}
		} else {
			System.out.println("*** ��ѯ�ʵ���ϸ�б�ʧ�� ***");
			System.out.println("��ѯ�ʵ���ϸ ErrorCode: " + result.getErrorCode());
			System.out.println("��ѯ�ʵ���ϸ ErrorMsg: " + result.getErrorMsg());
		}
		System.out.println();
		return result;
	}

	/**
	 * �����ʵ�ID��ѯ������ϸ�б�
	 *
	 * @param endPointStr ���ʵ�WebService URL
	 * @param sc ���Կͻ���
	 * @return �ʵ���ϸ�б�
	 * @throws Exception �׳��쳣
	 */
	public static RetAcmBillDetailList queryBillDetailByBillId(
			String endPointStr, ServiceClient sc) throws Exception {
		System.out.println("=============== ��ѯ�ʵ���ؽ�����ϸ�б� ===============");
		// ִ�в�ѯ�����û�����
		setOptions(endPointStr, sc, "urn:queryBillDetailByBillId");

		// ���ò�ѯ�����û��б����
		FeeServiceStub stub = new FeeServiceStub();
		QueryBillDetailByBillId queryBillDetailByBillId = new QueryBillDetailByBillId();
		queryBillDetailByBillId.setParam0(1L);
		OMElement element = stub.toOM(queryBillDetailByBillId, true);

		// ���Ͳ�������Ϣ
		OMElement response1 = sc.sendReceive(element);
		RetAcmBillDetailList result = QueryBillDetailByBillIdResponse.Factory
				.parse(response1.getXMLStreamReaderWithoutCaching())
				.get_return();
		// ת����������
		if (result.getErrorCode() == 0) {
			System.out.println("*** ��ѯ�ʵ���ؽ�����ϸ�б�ɹ���10����¼�� ***");
			System.out.printf("%-10s %-20s %-20s %-10s "
					+ "%-20s %-10s %-20s %-20s %-10s %-20s", "���", "�Ʒѿ�ʼʱ��",
					"�Ʒѽ���ʱ��", "�Ʒ�ʱ��", "�����ֽ���", "�����ֽ���", "����", "�������", "ʹ�ý���",
					"�ƷѻỰ��ʶ");
			System.out.println();
			AcmBillDetailSimpleInfo[] acmBillDetailSimpleInfo = result
					.getAcmBillDetailSimpleInfo();
			if (null != acmBillDetailSimpleInfo
					&& 0 < acmBillDetailSimpleInfo.length) {
				int count = 0;
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
						"yyyy-MM-dd hh:mm:ss");
				for (AcmBillDetailSimpleInfo detailInfo : acmBillDetailSimpleInfo) {
					System.out.printf("%-10s %-20s %-20s %-10s "
							+ "%-20s %-10s %-20s %-20s %-10s %-20s", count,
							detailInfo.getAccessStartTime() == null ? "--"
									: simpleDateFormat.format(detailInfo
											.getAccessStartTime().getTime()),
							detailInfo.getAccessEndTime() == null ? "--"
									: simpleDateFormat.format(detailInfo
											.getAccessEndTime().getTime()),
							detailInfo.getAccessSessionTime(), detailInfo
									.getInfluxByte(), detailInfo
									.getOutfluxByte(),
							detailInfo.getUsedCash(),
							detailInfo.getBonusCash(), detailInfo
									.getUsedBonusCash(), detailInfo
									.getFeeSessionId());
					System.out.println();
					count += 1;
				}
			} else {
				System.out.println("*** δ�ҵ����������ļ�¼ ***");
			}
		} else {
			System.out.println("*** ��ѯ�ʵ���ؽ�����ϸ�б�ʧ�� ***");
			System.out
					.println("��ѯ�ʵ���ؽ�����ϸ ErrorCode: " + result.getErrorCode());
			System.out.println("��ѯ�ʵ���ؽ�����ϸ ErrorMsg: " + result.getErrorMsg());
		}
		System.out.println();
		return result;
	}

	/**
	 * Ϊ�û��ɷѡ�
	 *
	 * @param feeEndpointStr Fee WebService location
	 * @param sc �ͻ���
	 * @throws Exception �쳣
	 */
	public static void pay(String feeEndpointStr, ServiceClient sc)
			throws Exception {

		System.out.println("=============== Ϊ�����û��ɷ� =================");
		// ͨ��ѡ������
		setOptions(feeEndpointStr, sc, "urn:pay");

		// ����׮
		FeeServiceStub stub = new FeeServiceStub();

		// ���ýɷѲ���
		PaymentInfo paymentInfo = new PaymentInfo();
		paymentInfo.setUserName(accountName);
		paymentInfo.setAmount("800");

		// ��װ����
		Pay pay = new Pay();
		pay.setParam0(paymentInfo);

		// ����������
		OMElement element = stub.toOM(pay, true);
		// ���������Ĳ�������Ӧ���
		OMElement response = sc.sendReceive(element);
		com.h3c.imc.acmws.acmuserservice.client.FeeServiceStub.WSCommonResult result = PayResponse.Factory
				.parse(response.getXMLStreamReaderWithoutCaching())
				.get_return();

		// �ɷѳɹ�
		if (result.getErrorCode() == 0) {
			System.out.println("*** Ϊ�����û���" + accountName + "���ɷ�800Ԫ�ɹ���***\n");
		}
		// �ɷ�ʧ��
		else {
			System.out.println("*** Ϊ�����û���" + accountName + "���ɷ�800Ԫʧ�ܡ�***\n");
			System.out.println("������: " + result.getErrorCode());
			System.out.println("������Ϣ: " + result.getErrorMsg() + "\n");
		}

	}

	/**
	 * ��ѯ�û���
	 *
	 * @param feeEndpointStr Fee WebService location
	 * @param sc �ͻ���
	 * @throws Exception �쳣
	 */
	public static void queryBalance(String feeEndpointStr, ServiceClient sc)
			throws Exception {

		System.out.println("=============== ��ѯ��� =================");

		// ͨ��ѡ������
		setOptions(feeEndpointStr, sc, "urn:queryBalance");

		// ����׮
		FeeServiceStub stub = new FeeServiceStub();

		// ���ò�ѯ����
		QueryBalance queryBalance = new QueryBalance();
		queryBalance.setParam0(accountName);

		// ����������
		OMElement element = stub.toOM(queryBalance, true);
		// ���������Ĳ�������Ӧ���
		OMElement response = sc.sendReceive(element);
		RetUserBalance userBalance = QueryBalanceResponse.Factory.parse(
				response.getXMLStreamReaderWithoutCaching()).get_return();

		// ��ѯ�ɹ�
		if (userBalance.getErrorCode() == 0) {
			System.out.println("*** ��ѯ�û���" + accountName + "�������ɹ���***");
			System.out.println("���: " + userBalance.getBalance() + " Ԫ\n");
		}
		// ��ѯʧ��
		else {
			System.out.println("*** ��ѯ�û���" + accountName + "�������ʧ�ܡ�***\n");
			System.out.println("������: " + userBalance.getErrorCode());
			System.out.println("������Ϣ: " + userBalance.getErrorMsg() + "\n");
		}
	}

	/**
	 * �������Ʋ�ѯ��
	 *
	 * @param queryEndpointStr Fee WebService location
	 * @param acmEndpointStr AcmUser WebService location
	 * @param sc �ͻ���
	 * @throws Exception �쳣
	 */
	public static void singleQuery(String queryEndpointStr,
			String acmEndpointStr, ServiceClient sc) throws Exception {

		// ��ѯ�����б�
		RetAcmServiceTemplateInfoList retServiceList = queryServiceTemplateList(
				acmEndpointStr, sc);

		System.out
				.println("=============== �������Ʋ�ѯ-������ϸ��Ϣ(acm_service_template.xml) =================");

		// ��ѯʧ��
		if (retServiceList.getErrorCode() != 0) {
			System.out.println("*** ��ѯ����ʧ�ܡ�***");
			System.out.println("������: " + retServiceList.getErrorCode());
			System.out.println("������Ϣ: " + retServiceList.getErrorMsg() + "\n");
			return;
		}

		RetAcmServiceTemplateInfo[] services = retServiceList
				.getRetAcmServiceTemplateInfoList();
		// û�з���
		if (services == null || services.length == 0) {
			System.out.println("*** ��ѯ����ʧ�ܣ�ϵͳ�в������κη���***\n");
			return;
		}

		// ͨ��ѡ������
		setOptions(queryEndpointStr, sc, "urn:singleQuery");

		// ����׮
		CustomQueryServiceStub stub = new CustomQueryServiceStub();

		// ���ò�ѯ����
		QueryActionInfo qai = new QueryActionInfo();
		qai.setCommand("acm_service_template");

		String[] paramNames = new String[] { "serviceTemplateName" };
		String[] paramValues = new String[] { services[0].getServiceName() };

		qai.setParaNames(paramNames);
		qai.setParaValues(paramValues);

		SingleQuery singleQuery = new SingleQuery();
		singleQuery.setParam0(qai);
		OMElement element = stub.toOM(singleQuery, true);

		// ���Ͳ�������Ϣ
		OMElement response1 = sc.sendReceive(element);
		RetSingleResult result = SingleQueryResponse.Factory.parse(
				response1.getXMLStreamReaderWithoutCaching()).get_return();

		String resultInfo = new StringBuilder("������: ").append(
				result.getErrorCode()).append("\n������Ϣ: ").append(
				result.getErrorMsg()).append("\n��ѯ����: ").append(
				result.getColumnCount()).append("\n��ѯ����: ").append(
				ArrayUtils.toString(result.getColumnNames())).append(
				"\n��ѯ������: ").append(
				ArrayUtils.toString(result.getColumnTypes())).append("\n�����: ")
				.append(ArrayUtils.toString(result.getResultValues()))
				.toString();

		System.out.println(resultInfo + "\n");
	}

	/**
	 * �������Ʋ�ѯ��
	 *
	 * @param queryEndpointStr Fee WebService location
	 * @param imcUserEndporintStr iMC User WebService location
	 * @param sc �ͻ���
	 * @throws Exception �쳣
	 */
	public static void multiQuery(String queryEndpointStr,
			String imcUserEndporintStr, ServiceClient sc) throws Exception {

		System.out
				.println("=============== �������Ʋ�ѯ-�û���־(uam_user_log.xml) =================");

		// ��ѯ�����û�����
		WSUserGroupArray userGroups = queryAllUserGroup(imcUserEndporintStr, sc);

		// ��ѯʧ��
		if (userGroups.getErrorCode() != 0) {
			System.out.println("*** ��ѯ�û�����ʧ�ܡ�***");
			System.out.println("������: " + userGroups.getErrorCode());
			System.out.println("������Ϣ: " + userGroups.getErrorMsg() + "\n");
			return;
		}

		// ���ٴ���һ����δ���顱
		StringBuilder userGroupIds = new StringBuilder("");
		for (UserGroup userGroup : userGroups.getUserGroupArray()) {
			userGroupIds.append(userGroup.getId()).append(",");
		}

		// ͨ��ѡ������
		setOptions(queryEndpointStr, sc, "urn:multiQuery");

		// ����׮
		CustomQueryServiceStub stub = new CustomQueryServiceStub();

		// ���ò�ѯ����
		QueryActionInfo qai = new QueryActionInfo();
		qai.setCommand("uam_user_log");

		qai.setCount(-1);
		qai.setStartPos(1);

		String[] paramNames = new String[] { "insertStartTime",
				"insertEndTime", "type", "userName", "description",
				"userGroupIds" };
		String[] paramValues = new String[] { "", "", "", "", "",
				userGroupIds.substring(0, userGroupIds.length() - 1).toString() };

		qai.setParaNames(paramNames);
		qai.setParaValues(paramValues);

		MultiQuery multiQuery = new MultiQuery();
		multiQuery.setParam0(qai);
		OMElement element = stub.toOM(multiQuery, true);

		// ���Ͳ�������Ϣ
		OMElement response1 = sc.sendReceive(element);
		RetMultiResult result = MultiQueryResponse.Factory.parse(
				response1.getXMLStreamReaderWithoutCaching()).get_return();

		StringBuilder resultValues = new StringBuilder("");
		if (result.getResultValues() != null) {
			for (Record record : result.getResultValues()) {
				resultValues.append(ArrayUtils.toString(record.getValues()))
						.append("\n ");
			}
		}
		String resultInfo = new StringBuilder("������: ").append(
				result.getErrorCode()).append("\n������Ϣ: ").append(
				result.getErrorMsg()).append("\n�ܼ�¼��: ").append(
				String.valueOf(result.getTotalRecordCount())).append(
				"\n���������ļ�¼��: ").append(String.valueOf(result.getRecordCount()))
				.append("\n��ѯ����: ").append(result.getColumnCount()).append(
						"\n��ѯ����: ").append(
						ArrayUtils.toString(result.getColumnNames())).append(
						"\n��ѯ������: ").append(
						ArrayUtils.toString(result.getColumnTypes())).append(
						"\n�����:\n ").append(resultValues).toString();

		System.out.println(resultInfo);
	}

	/**
	 * ��ѯ�����ʲ����顣
	 *
	 * @param damEndPointStr WebService location
	 * @param sc �ͻ���
	 * @throws Exception �쳣
	 * @return �����û�
	 */
	public static WSUserGroupArray queryAllUserGroup(
			String imcUserEndporintStr, ServiceClient sc) throws Exception {
		// ���ò�ѯ�����û�����ӿ�
		setOptions(imcUserEndporintStr, sc, "urn:queryAllUserGroup");

		// ���ͺ������Ӧ����
		OMElement response = sc.sendReceive(null);
		// ������Ӧ����
		WSUserGroupArray userGroups = QueryAllUserGroupResponse.Factory.parse(
				response.getXMLStreamReaderWithoutCaching()).get_return();

		return userGroups;
	}

	/**
	 * ��ѯ�����������ʲ���
	 *
	 * @param damEndPointStr WebService location
	 * @param sc �ͻ���
	 * @param queryInfo ��ѯ����
	 * @throws Exception �쳣
	 * @return �����������ʲ�
	 */
	public static RetAssetInfoList queryAssets(String damEndPointStr,
			ServiceClient sc, AssetQueryInfo queryInfo) throws Exception {
		// ���ò�ѯ�����ʲ�����ӿ�
		setOptions(damEndPointStr, sc, "urn:queryAsset");

		DamAssetServiceStub stub = new DamAssetServiceStub();
		QueryAsset queryAsset = new QueryAsset();

		// ���ò�ѯ����
		queryAsset.setParam0(queryInfo);
		// ����������
		OMElement element = stub.toOM(queryAsset, true);

		// ���ͺ������Ӧ����
		OMElement response = sc.sendReceive(element);
		// ������Ӧ����
		RetAssetInfoList assets = QueryAssetResponse.Factory.parse(
				response.getXMLStreamReaderWithoutCaching()).get_return();

		return assets;
	}

	/**
	 * �����ʲ���ʶ��ѯ�ʲ���ϸ��Ϣ��
	 *
	 * @param damEndPointStr WebService location
	 * @param sc �ͻ���
	 * @param assetId �ʲ���ʶ
	 * @throws Exception �쳣
	 * @return �ʲ���ϸ��Ϣ
	 */
	public static RetAssetDetailInfo queryAssetDetail(String damEndPointStr,
			ServiceClient sc, Long assetId) throws Exception {
		// ���ò�ѯ�ʲ���ϸ��Ϣ�ӿ�
		setOptions(damEndPointStr, sc, "urn:queryAssetDetail");

		DamAssetServiceStub stub = new DamAssetServiceStub();
		QueryAssetDetail queryAssetDetail = new QueryAssetDetail();

		// ���ò�ѯ����
		queryAssetDetail.setParam0(assetId);
		// ����������
		OMElement element = stub.toOM(queryAssetDetail, true);

		// ���ͺ������Ӧ����
		OMElement response = sc.sendReceive(element);
		// ������Ӧ����
		RetAssetDetailInfo assetDetail = QueryAssetDetailResponse.Factory
				.parse(response.getXMLStreamReaderWithoutCaching())
				.get_return();

		return assetDetail;
	}

	/**
	 * ��ѯ�����û���
	 *
	 * @param imcPlatUserEndpointStr WebService location
	 * @param sc �ͻ���
	 * @throws Exception �쳣
	 * @return �����û�
	 */
	public static WSUserArray queryAllUser(String imcPlatUserEndpointStr,
			ServiceClient sc) throws Exception {
		// ���ò�ѯ�����û��ӿ�
		setOptions(imcPlatUserEndpointStr, sc, "urn:queryAllUser");

		ImcplatUserServiceStub stub = new ImcplatUserServiceStub();
		QueryAllUser query = new QueryAllUser();

		// ���ò�ѯ�û�id����һ������������ѯ�����û�
		query.setParam0(new long[] { 0 });
		// ����������
		OMElement element = stub.toOM(query, true);

		// ���ͺ������Ӧ����
		OMElement response = sc.sendReceive(element);
		// ������Ӧ����
		ImcplatUserServiceStub.WSUserArray users = QueryAllUserResponse.Factory
				.parse(response.getXMLStreamReaderWithoutCaching())
				.get_return();

		return users;
	}

	/**
	 * ��ѯ�����ʲ����顣
	 *
	 * @param damEndPointStr WebService location
	 * @param sc �ͻ���
	 * @throws Exception �쳣
	 * @return �����û�
	 */
	public static RetAssetGroupInfoList queryAllAssetGroup(
			String damEndPointStr, ServiceClient sc) throws Exception {
		// ���ò�ѯ�����ʲ�����ӿ�
		setOptions(damEndPointStr, sc, "urn:queryAssetGroup");

		// ���ͺ������Ӧ����
		OMElement response = sc.sendReceive(null);
		// ������Ӧ����
		RetAssetGroupInfoList assetGroup = QueryAssetGroupResponse.Factory
				.parse(response.getXMLStreamReaderWithoutCaching())
				.get_return();

		return assetGroup;
	}

	/**
	 * �����ʲ���
	 *
	 * @param damEndpointStr DAM WebService location
	 * @param imcPlatEndpointStr iMC plat WebService location
	 * @param imcPlatUserEndpointStr iMC plat user WebService location
	 * @param sc �ͻ���
	 * @throws Exception �쳣
	 */
	public static void addAsset(String damEndpointStr,
			String imcPlatEndpointStr, String imcPlatUserEndpointStr,
			ServiceClient sc) throws Exception {

		System.out.println("=============== �����ʲ� =================");
		// ��ѯ�����û�
		WSUserArray users = queryAllUser(imcPlatUserEndpointStr, sc);
		// ��ѯʧ��
		if (users.getErrorCode() != 0) {
			System.out.println("*** ��ѯ�û�ʧ�ܡ�***");
			System.out.println("������: " + users.getErrorCode());
			System.out.println("������Ϣ: " + users.getErrorMsg() + "\n");

			// ע��ϵͳ����������
			logout(imcPlatEndpointStr, sc);
			System.exit(0);
		}

		// û���û�
		if (users.getUserArray() == null || users.getUserArray().length == 0) {
			System.out.println("*** �����ʲ�ʧ�ܣ�ϵͳ�в������κ��û���***\n");

			// ע��ϵͳ����������
			logout(imcPlatEndpointStr, sc);
			System.exit(0);
		}

		// ��ѯ�����ʲ�����
		RetAssetGroupInfoList assetGroup = queryAllAssetGroup(damEndpointStr,
				sc);
		// ��ѯʧ��
		if (assetGroup.getErrorCode() != 0) {
			System.out.println("*** ��ѯ�ʲ�����ʧ�ܡ�***");
			System.out.println("������: " + assetGroup.getErrorCode());
			System.out.println("������Ϣ: " + assetGroup.getErrorMsg() + "\n");

			// ע��ϵͳ����������
			logout(imcPlatEndpointStr, sc);
			System.exit(0);
		}

		RetAssetGroupInfo[] assetInfo = assetGroup.getRetAssetGroupInfoList();
		// û�з���
		if (assetInfo == null || assetInfo.length == 0) {
			System.out.println("*** �����ʲ�ʧ�ܣ�ϵͳ�в������κ��ʲ����顣***\n");

			// ע��ϵͳ����������
			logout(imcPlatEndpointStr, sc);
			System.exit(0);
		}

		// �����ʲ���������
		AddAssetInfo asset = new AddAssetInfo();

		// �����������Ϊ�ʲ����
		String assetNumber = String
				.valueOf(new Random().nextInt(999999999) + 1);
		asset.setAssetNumber(assetNumber);

		// ȡ��һ���û���Ϊ������
		asset.setResponserId(users.getUserArray()[0].getId());
		// �����ʶ
		asset.setGroupId(assetInfo[0].getGroupId());
		// ���������(pc/laptop/server/workstation/other)
		asset.setComputerType("workstation");
		// ����λ��
		asset.setPhysicalPos("�����������Ӵ���");
		// �ʲ�����
		asset.setAssetName("H3C-IX5000�洢�豸");
		// �����Ʒ��
		asset.setComputerVariety("H3C");
		// �ͺ�
		asset.setType("IX5000");
		// ��ע
		asset.setRemark("�ֱ��ָ���������");

		// ���������ʲ��ӿ�
		setOptions(damEndpointStr, sc, "urn:addAsset");

		DamAssetServiceStub stub = new DamAssetServiceStub();
		AddAsset addAsset = new AddAsset();

		// �������ӵ��ʲ�
		addAsset.setParam0(asset);
		// ����������
		OMElement element = stub.toOM(addAsset, true);

		// ���ͺ������Ӧ����
		OMElement response = sc.sendReceive(element);
		// ������Ӧ����
		com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.WSCommonResult result = AddAssetResponse.Factory
				.parse(response.getXMLStreamReaderWithoutCaching())
				.get_return();

		// �����ʲ�ʧ��
		if (result.getErrorCode() != 0) {
			System.out.println("*** �����ʲ�ʧ�ܡ�***");
			System.out.println("������: " + result.getErrorCode());
			System.out.println("������Ϣ: " + result.getErrorMsg() + "\n");

			// ע��ϵͳ����������
			logout(imcPlatEndpointStr, sc);
			System.exit(0);
		}
		// �����ʲ��ɹ�
		else {
			// �����ʲ����
			assetNo = assetNumber;

			System.out.println("*** ���ӱ��Ϊ��" + assetNo + "�����ʲ��ɹ���***\n");

			System.out.println("��ѯ���Ϊ��" + assetNo + "�����ʲ�...");

			// �����ʲ���Ų�ѯ�����ӵ��ʲ�
			AssetQueryInfo queryInfo = new AssetQueryInfo();
			queryInfo.setAssetNumber(assetNo);

			RetAssetInfoList assets = queryAssets(damEndpointStr, sc, queryInfo);

			// ��ѯ�ʲ�ʧ��
			if (assets.getErrorCode() != 0) {
				System.out.println("*** ��ѯ���Ϊ��" + assetNo + "�����ʲ�ʧ�ܡ�***");
				System.out.println("������: " + assets.getErrorCode());
				System.out.println("������Ϣ: " + assets.getErrorMsg() + "\n");

				// ע��ϵͳ����������
				logout(imcPlatEndpointStr, sc);
				System.exit(0);
			}

			// �ʲ�������
			if (assets.getRetAssetList() == null
					|| assets.getRetAssetList().length == 0) {
				System.out.println("���Ϊ��" + assetNo + "�����ʲ��Ѳ����ڡ�\n");

				// ע��ϵͳ����������
				logout(imcPlatEndpointStr, sc);
				System.exit(0);
			}

			// ��ȡ�����ӵ��ʲ�
			RetAssetInfo addedAsset = assets.getRetAssetList()[0];
			// ��ѯ�ʲ���ϸ��Ϣ
			RetAssetDetailInfo assetDetail = queryAssetDetail(damEndpointStr,
					sc, addedAsset.getAssetId());

			// ��ѯʧ��
			if (assetDetail.getErrorCode() != 0) {
				System.out.println("*** ��ѯ���Ϊ��" + assetNo + "�����ʲ���ϸ��Ϣʧ�ܡ�***");
				System.out.println("������: " + assetDetail.getErrorCode());
				System.out.println("������Ϣ: " + assetDetail.getErrorMsg() + "\n");

				// ע��ϵͳ����������
				logout(imcPlatEndpointStr, sc);
				System.exit(0);
			}

			System.out.println("�ʲ���ʶ: " + addedAsset.getAssetId());
			System.out.println("�ʲ����: " + assetNo);
			System.out.println("�ʲ�����: " + assetDetail.getAssetName());
			System.out.println("��������: " + assetDetail.getGroupName());
			System.out.println("������: " + assetDetail.getResponserName());
			System.out.println("���������: " + assetDetail.getComputerType());
			System.out.println("�ͺ�: " + assetDetail.getType());
			System.out.println("����λ��: " + assetDetail.getPhysicalPos());
			System.out.println("��ע: " + assetDetail.getRemark() + "\n");
		}
	}

	/**
	 * �޸��ʲ���
	 *
	 * @param damEndpointStr DAM WebService location
	 * @param imcPlatEndpointStr iMC plat WebService location
	 * @param imcPlatUserEndpointStr iMC plat user WebService location
	 * @param sc �ͻ���
	 * @throws Exception �쳣
	 */
	public static void modifyAsset(String damEndpointStr,
			String imcPlatEndpointStr, String imcPlatUserEndpointStr,
			ServiceClient sc) throws Exception {

		System.out.println("=============== �޸��ʲ� =================");
		// �����ʲ���Ų�ѯԤ�޸ĵ��ʲ�
		AssetQueryInfo queryInfo = new AssetQueryInfo();
		queryInfo.setAssetNumber(assetNo);

		RetAssetInfoList assets = queryAssets(damEndpointStr, sc, queryInfo);

		// ��ѯ�ʲ�ʧ��
		if (assets.getErrorCode() != 0) {
			System.out.println("*** ��ѯ���Ϊ��" + assetNo + "�����ʲ�ʧ�ܡ�***");
			System.out.println("������: " + assets.getErrorCode());
			System.out.println("������Ϣ: " + assets.getErrorMsg() + "\n");
			return;
		}

		// �ʲ�������
		if (assets.getRetAssetList() == null
				|| assets.getRetAssetList().length == 0) {
			System.out.println("*** �޸��ʲ�ʧ�ܣ����Ϊ��" + assetNo + "�����ʲ��Ѳ����ڡ�***\n");
			return;
		}

		// ��ȡԤ�޸ĵ��ʲ�
		RetAssetInfo preModifyAsset = assets.getRetAssetList()[0];
		// ��ѯ�ʲ���ϸ��Ϣ
		RetAssetDetailInfo assetDetail = queryAssetDetail(damEndpointStr, sc,
				preModifyAsset.getAssetId());

		// ��ѯʧ��
		if (assetDetail.getErrorCode() != 0) {
			System.out.println("*** ��ѯ���Ϊ��" + assetNo + "�����ʲ���ϸ��Ϣʧ�ܡ�***");
			System.out.println("������: " + assetDetail.getErrorCode());
			System.out.println("������Ϣ: " + assetDetail.getErrorMsg() + "\n");
			return;
		}

		System.out.println("ѡ���ʲ�...");
		System.out.println("�ʲ���ʶ: " + preModifyAsset.getAssetId());
		System.out.println("�ʲ����: " + assetNo);
		System.out.println("�ʲ�����: " + assetDetail.getAssetName());
		System.out.println("��������: " + assetDetail.getGroupName());
		System.out.println("������: " + assetDetail.getResponserName());
		System.out.println("���������: " + assetDetail.getComputerType());
		System.out.println("�ͺ�: " + assetDetail.getType());
		System.out.println("����λ��: " + assetDetail.getPhysicalPos());
		System.out.println("��ע: " + assetDetail.getRemark() + "\n");

		// �޸��ʲ���������
		ModifyAssetInfo asset = new ModifyAssetInfo();

		// �ʲ�id
		asset.setAssetId(preModifyAsset.getAssetId());

		// ��ѯ�����û�
		WSUserArray users = queryAllUser(imcPlatUserEndpointStr, sc);

		// ��ѯ�ɹ����������û�����Ϊ�޸Ķ���
		if (users.getErrorCode() == 0 && users.getUserArray() != null
				&& users.getUserArray().length > 0) {

			int lastIndex = users.getUserArray().length - 1;
			// ȡ���һ���û���Ϊ�޸ĵ�������
			asset.setResponserId(users.getUserArray()[lastIndex].getId());
		}

		// ���޸��ʲ����
		asset.setAssetNumber(assetNo);
		// ���������(pc/laptop/server/workstation/other)
		asset.setComputerType("server");
		// ����λ��
		asset.setPhysicalPos("�����������A��");
		// �ʲ�����
		asset.setAssetName("Oracle���ݿ������");
		// �����Ʒ��
		asset.setComputerVariety("lenovo");
		// �ͺ�
		asset.setType("PC8560");
		// ��ע
		asset.setRemark("ҵ������з�");

		// �����޸��ʲ��ӿ�
		setOptions(damEndpointStr, sc, "urn:modifyAsset");

		DamAssetServiceStub stub = new DamAssetServiceStub();
		ModifyAsset modifyAsset = new ModifyAsset();

		// �����޸ĵ��ʲ�
		modifyAsset.setParam0(asset);
		// ����������
		OMElement element = stub.toOM(modifyAsset, true);

		// ���ͺ������Ӧ����
		OMElement response = sc.sendReceive(element);
		// ������Ӧ����
		com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.WSCommonResult result = ModifyAssetResponse.Factory
				.parse(response.getXMLStreamReaderWithoutCaching())
				.get_return();

		// �޸��ʲ�ʧ��
		if (result.getErrorCode() != 0) {
			System.out.println("*** �޸ı��Ϊ��" + assetNo + "�����ʲ�ʧ�ܡ�***");
			System.out.println("������: " + result.getErrorCode());
			System.out.println("������Ϣ: " + result.getErrorMsg() + "\n");
		}
		// �޸��ʲ��ɹ�
		else {
			System.out.println("*** �޸ı��Ϊ��" + assetNo + "�����ʲ��ɹ���***\n");

			// ��ѯ�ʲ���ϸ��Ϣ
			assetDetail = queryAssetDetail(damEndpointStr, sc, preModifyAsset
					.getAssetId());

			// ���²�ѯʧ��
			if (assetDetail.getErrorCode() != 0) {
				System.out.println("*** ���²�ѯ���Ϊ��" + assetNo + "�����ʲ���ϸ��Ϣʧ�ܡ�***");
				System.out.println("������: " + assetDetail.getErrorCode());
				System.out.println("������Ϣ: " + assetDetail.getErrorMsg() + "\n");
				return;
			}

			System.out.println("��ѯ���Ϊ��" + assetNo + "�����ʲ�...");
			System.out.println("�ʲ���ʶ: " + preModifyAsset.getAssetId());
			System.out.println("�ʲ����: " + assetNo);
			System.out.println("�ʲ�����: " + assetDetail.getAssetName());
			System.out.println("��������: " + assetDetail.getGroupName());
			System.out.println("������: " + assetDetail.getResponserName());
			System.out.println("���������: " + assetDetail.getComputerType());
			System.out.println("�ͺ�: " + assetDetail.getType());
			System.out.println("����λ��: " + assetDetail.getPhysicalPos());
			System.out.println("��ע: " + assetDetail.getRemark() + "\n");
		}
	}

	/**
	 * ɾ���ʲ���
	 *
	 * @param damEndpointStr DAM WebService location
	 * @param imcPlatUserEndpointStr iMC plat user WebService location
	 * @param sc �ͻ���
	 * @throws Exception �쳣
	 */
	public static void deleteAsset(String damEndpointStr,
			String imcPlatUserEndpointStr, ServiceClient sc) throws Exception {

		System.out.println("=============== ɾ���ʲ� =================");
		// �����ʲ���Ų�ѯԤɾ�����ʲ�
		AssetQueryInfo queryInfo = new AssetQueryInfo();
		queryInfo.setAssetNumber(assetNo);

		RetAssetInfoList assets = queryAssets(damEndpointStr, sc, queryInfo);

		// ��ѯ�ʲ�ʧ��
		if (assets.getErrorCode() != 0) {
			System.out.println("*** ��ѯ���Ϊ��" + assetNo + "�����ʲ�ʧ�ܡ�***");
			System.out.println("������: " + assets.getErrorCode());
			System.out.println("������Ϣ: " + assets.getErrorMsg());
			return;
		}

		// �ʲ�������
		if (assets.getRetAssetList() == null
				|| assets.getRetAssetList().length == 0) {
			System.out.println("*** ɾ���ʲ�ʧ�ܣ����Ϊ��" + assetNo + "�����ʲ��Ѳ����ڡ�***\n");
			return;
		}

		// ��ȡԤɾ�����ʲ�
		RetAssetInfo preDeleteAsset = assets.getRetAssetList()[0];
		// ��ѯ�ʲ���ϸ��Ϣ
		RetAssetDetailInfo assetDetail = queryAssetDetail(damEndpointStr, sc,
				preDeleteAsset.getAssetId());

		// ��ѯʧ��
		if (assetDetail.getErrorCode() != 0) {
			System.out.println("*** ��ѯ���Ϊ��" + assetNo + "�����ʲ���ϸ��Ϣʧ�ܡ�***");
			System.out.println("������: " + assetDetail.getErrorCode());
			System.out.println("������Ϣ: " + assetDetail.getErrorMsg() + "\n");
			return;
		}

		System.out.println("ѡ���ʲ�...");
		System.out.println("�ʲ���ʶ: " + preDeleteAsset.getAssetId());
		System.out.println("�ʲ����: " + assetNo);
		System.out.println("�ʲ�����: " + assetDetail.getAssetName());
		System.out.println("��������: " + assetDetail.getGroupName());
		System.out.println("������: " + assetDetail.getResponserName());
		System.out.println("���������: " + assetDetail.getComputerType());
		System.out.println("�ͺ�: " + assetDetail.getType());
		System.out.println("����λ��: " + assetDetail.getPhysicalPos());
		System.out.println("��ע: " + assetDetail.getRemark() + "\n");

		// ����ɾ���ʲ��ӿ�
		setOptions(damEndpointStr, sc, "urn:deleteAsset");

		DamAssetServiceStub stub = new DamAssetServiceStub();
		DeleteAsset deleteAsset = new DeleteAsset();

		// ����Ҫɾ�����ʲ�id
		deleteAsset.setParam0(preDeleteAsset.getAssetId());
		// ����������
		OMElement element = stub.toOM(deleteAsset, true);

		// ���ͺ������Ӧ����
		OMElement response = sc.sendReceive(element);
		// ������Ӧ����
		com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.WSCommonResult result = DeleteAssetResponse.Factory
				.parse(response.getXMLStreamReaderWithoutCaching())
				.get_return();

		// ɾ���ʲ�ʧ��
		if (result.getErrorCode() != 0) {
			System.out.println("*** ɾ�����Ϊ��" + assetNo + "�����ʲ�ʧ�ܡ�***");
			System.out.println("������: " + result.getErrorCode());
			System.out.println("������Ϣ: " + result.getErrorMsg() + "\n");
		}
		// ɾ���ʲ��ɹ�
		else {
			System.out.println("*** ɾ�����Ϊ��" + assetNo + "�����ʲ��ɹ���***\n");

			// ��ѯ�ʲ���ϸ��Ϣ
			assetDetail = queryAssetDetail(damEndpointStr, sc, preDeleteAsset
					.getAssetId());

			System.out.println("��ѯ���Ϊ��" + assetNo + "�����ʲ�...");
			if (assetDetail.getErrorCode() == 62407) {
				System.out.println("���Ϊ��" + assetNo + "�����ʲ��Ѳ����ڡ�\n");
			} else {
				System.out.println("*** ��ѯ���Ϊ��" + assetNo + "�����ʲ���ϸ��Ϣʧ�ܡ�***");
				System.out.println("������: " + assetDetail.getErrorCode());
				System.out.println("������Ϣ: " + assetDetail.getErrorMsg() + "\n");
			}
		}
	}

	/**
	 * ��ѯǰ15���ʲ���
	 *
	 * @param damEndpointStr DAM WebService location
	 * @param sc �ͻ���
	 * @throws Exception �쳣
	 */
	public static void queryFirstPageAssets(String damEndpointStr,
			ServiceClient sc) throws Exception {

		System.out.println("=============== ��ѯ�ʲ� =================");
		// ������ʱ�併������
		AssetQueryInfo queryInfo = new AssetQueryInfo();
		queryInfo.setResultSortType(7);
		queryInfo.setResultSort(1);

		RetAssetInfoList assets = queryAssets(damEndpointStr, sc, queryInfo);

		// ��ѯʧ��
		if (assets.getErrorCode() != 0) {
			System.out.println("*** ��ѯ�ʲ�ʧ�ܡ�***");
			System.out.println("������: " + assets.getErrorCode());
			System.out.println("������Ϣ: " + assets.getErrorMsg() + "\n");
			return;
		}

		RetAssetInfo[] assetList = assets.getRetAssetList();

		// ϵͳ��û���ʲ�
		if (assetList == null || assetList.length == 0) {
			System.out.println("δ�ҵ��κμ�¼��");
			System.out.printf("%-10s %-20s %-30s %-20s %-20s %-10s", "״̬",
					"�ʲ����", "�ʲ�����", "������", "�ͺ�", "�������ڡ�");
			System.out.println("\n");
			return;
		}

		int pageCount = assetList.length <= 15 ? 1
				: (assetList.length % 15 == 0 ? assetList.length / 15
						: assetList.length / 15 + 1);
		int firstPageCount = assetList.length >= 15 ? 15 : assetList.length;
		System.out.println("��" + assetList.length + "����¼����ǰ��1-"
				+ firstPageCount + "����1/" + pageCount + "ҳ��");
		System.out.printf("%-10s %-20s %-30s %-20s %-20s %-10s", "״̬", "�ʲ����",
				"�ʲ�����", "������", "�ͺ�", "�������ڡ�");
		System.out.println();

		for (int i = 0; i < firstPageCount; i++) {
			System.out.printf(
					"%-10s %-20s %-30s %-20s %-20s %6$tY-%6$tm-%6$td",
					convertDamStatus(assetList[i].getStatus()), assetList[i]
							.getAssetNumber(), convertNull(assetList[i]
							.getAssetName()), assetList[i].getResponser(),
					convertNull(assetList[i].getType()), assetList[i]
							.getJoinDate());
			System.out.println();
		}

		System.out.println();
	}

	/**
	 * ��ѯ�����ʲ����顣
	 *
	 * @param damEndpointStr DAM WebService location
	 * @param sc �ͻ���
	 * @throws Exception �쳣
	 */
	public static void queryAssetGroups(String damEndpointStr, ServiceClient sc)
			throws Exception {

		System.out.println("============= ��ѯ�ʲ����� ===============");
		// ��ѯ�����ʲ�����
		RetAssetGroupInfoList assetGroups = queryAllAssetGroup(damEndpointStr,
				sc);

		// ��ѯʧ��
		if (assetGroups.getErrorCode() != 0) {
			System.out.println("*** ��ѯ�ʲ�����ʧ�ܡ�***");
			System.out.println("������: " + assetGroups.getErrorCode());
			System.out.println("������Ϣ: " + assetGroups.getErrorMsg() + "\n");
			return;
		}

		RetAssetGroupInfo[] assetGroupList = assetGroups
				.getRetAssetGroupInfoList();

		// ϵͳ��û���ʲ�����
		if (assetGroupList == null || assetGroupList.length == 0) {
			System.out.println("δ�ҵ��κμ�¼��");
			System.out.printf("%-30s %-100s", "�������ơ�", "��������");
			System.out.println("\n");
			return;
		}

		System.out.println("��" + assetGroupList.length + "����¼");
		System.out.printf("%-30s %-100s", "�������ơ�", "��������");
		System.out.println();

		for (RetAssetGroupInfo assetGroup : assetGroupList) {
			System.out.printf("%-30s %-100s", assetGroup.getGroupName(),
					convertNull(assetGroup.getGroupDescription()));
			System.out.println();
		}

		System.out.println();
	}

	/**
	 * ͨ��ѡ�����á�
	 *
	 * @param endPointStr ���ʵ�WebService URL
	 * @param sc ���Կͻ���
	 * @param urn ���ýӿڷ���ͳһ��Դ����
	 * @throws FileNotFoundException �ļ��������쳣
	 * @throws XMLStreamException XML�����쳣
	 * @throws AxisFault Axis����
	 */
	public static void setOptions(String endPointStr, ServiceClient sc,
			String urn) throws FileNotFoundException, XMLStreamException,
			AxisFault {
		Options opts = new Options();
		opts.setTo(new EndpointReference(endPointStr));
		opts.setAction(urn);
		opts.setManageSession(true);
		opts.setProperty(RampartMessageData.KEY_RAMPART_POLICY,
				loadPolicy("policy.xml"));
		sc.setOptions(opts);
		if (rampart) {
			sc.engageModule("rampart");
		}
	}

	/**
	 * ��¼ϵͳ��
	 *
	 * @param imcPlatEndPointStr WebService location
	 * @param sc �ͻ���
	 * @throws Exception �쳣
	 */
	public static void login(String imcPlatEndPointStr, ServiceClient sc)
			throws Exception {
		// ���õ�¼�ӿ�
		setOptions(imcPlatEndPointStr, sc, "urn:login");

		ImcplatServiceStub stub = new ImcplatServiceStub();
		// ���õ�¼����Ա���ƺ�����
		Login login = new Login();
		login.setParam0("admin");
		login.setParam1("admin");
		// ����������
		OMElement element = stub.toOM(login, true);

		// ���ͺ������Ӧ����
		OMElement response = sc.sendReceive(element);
		// ������Ӧ����
		ImcplatServiceStub.WSCommonResult result = LoginResponse.Factory.parse(
				response.getXMLStreamReaderWithoutCaching()).get_return();

		System.out.println("=============== ��¼ϵͳ =================");
		// ��¼ʧ��
		if (result.getErrorCode() != 0) {
			System.out.println("*** ����Ա��admin����¼ʧ�ܡ�***");
			System.out.println("������: " + result.getErrorCode());
			System.out.println("������Ϣ: " + result.getErrorMsg());
		}
		// ��¼�ɹ�
		else {
			System.out.println("*** ����Ա��admin����¼�ɹ���***\n");
		}
	}

	/**
	 * ���ݽ����û����ƻ�ȡ�����û�
	 *
	 * @param acmEndpointStr acm service
	 * @param sc client
	 * @return �����û�
	 * @throws Exception �׳��쳣
	 */
	public static RetAcmUser queryAcmUser(String acmEndpointStr,
			ServiceClient sc) throws Exception {
		System.out.println("=============== ��ѯ�����û� =================");
		setOptions(acmEndpointStr, sc, "urn:queryAcmUser");

		// ���ð��û�
		AcmUserServiceStub stub = new AcmUserServiceStub();

		// �����������
		QueryAcmUser user = new QueryAcmUser();
		user.setParam0(accountName);

		OMElement element = stub.toOM(user, true);

		// ���Ͳ�������Ϣ
		OMElement response1 = sc.sendReceive(element);
		RetAcmUser acmUser = QueryAcmUserResponse.Factory.parse(
				response1.getXMLStreamReaderWithoutCaching()).get_return();

		if (acmUser.getErrorCode() != 0) {
			System.out.println("*** ��ѯ�����û�ʧ�ܡ�***");
			System.out.println("������: " + acmUser.getErrorCode());
			System.out.println("������Ϣ: " + acmUser.getErrorMsg() + "\n");
		} else {
			System.out.println("*** ��ѯ�����û���" + accountName + "�ɹ�����***\n");
			// ���ý����û�ID
			userId = acmUser.getAcmUser().getAcmUserId();

		}

		return acmUser;
	}

	/**
	 * ��ѯ�����û�
	 *
	 * @param endPointStr ���ʵ�WebService URL
	 * @param sc ���Կͻ���
	 * @return �����û��б�
	 * @throws Exception �׳��쳣
	 */
	private static RetAcmUserList queryAccessUserArray(String endPointStr,
			ServiceClient sc) throws Exception {
		System.out.println("=============== ��ѯ�����û��б� ===============");
		// ִ�в�ѯ�����û�����
		setOptions(endPointStr, sc, "urn:queryAcmUserList");

		// ���ò�ѯ�����û��б����
		AcmUserServiceStub stub = new AcmUserServiceStub();
		AcmUserListQueryParam queryInfo = new AcmUserListQueryParam();
		queryInfo.setAccountName("");
		queryInfo.setFullName("");
		queryInfo.setDeviceStartIp("");
		queryInfo.setDeviceEndIp("");
		queryInfo.setUserGroupId(-1);
		queryInfo.setInnerVlanId(-1);
		queryInfo.setMaxConcurrentLimit(-1);
		queryInfo.setMaxIdleTime(-1);
		queryInfo.setOuterVlanId(-1);
		queryInfo.setPort(-1);
		queryInfo.setServiceID(-1);
		QueryAcmUserList queryAcmUserList = new QueryAcmUserList();
		queryAcmUserList.setParam0(queryInfo);
		OMElement element = stub.toOM(queryAcmUserList, true);

		// ���Ͳ�������Ϣ
		OMElement response1 = sc.sendReceive(element);
		RetAcmUserList result = QueryAcmUserListResponse.Factory.parse(
				response1.getXMLStreamReaderWithoutCaching()).get_return();
		// ת����������
		if (result.getErrorCode() == 0) {
			System.out.println("*** ��ѯ�����û��б�ɹ���10����¼�� ***");
			System.out.printf("%-10s %-10s %-20s %-25s %-20s %-30s", "���",
					"�ʺ�ID", "�ʺ���", "�û�����", "�û�����ID", "ʧЧ����");
			System.out.println();
			int count = 1;
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
					"yyyy-MM-dd hh:mm:ss");

			AcmUserSimpleInfo[] acmUserArray = result.getUserSimpleInfoArray();
			if (null != acmUserArray && 0 < acmUserArray.length) {
				for (AcmUserSimpleInfo acmUserSimpleInfo : acmUserArray) {
					System.out.printf("%-10s %-10s %-20s %-25s %-20s %-30s",
							count, acmUserSimpleInfo.getAccountId(),
							acmUserSimpleInfo.getAccountName(),
							acmUserSimpleInfo.getFullName(), acmUserSimpleInfo
									.getUserGroupId(), acmUserSimpleInfo
									.getInvalidTime() == null ? "--"
									: simpleDateFormat.format(acmUserSimpleInfo
											.getInvalidTime().getTime()));
					System.out.println();
					count += 1;
					if (10 < count) {
						break;
					}
				}
			} else {
				System.out.println("*** δ�ҵ����������ļ�¼ ***");
			}
		} else {
			System.out.println("*** ��ѯ�����û��б�ʧ�� ***");
			System.out.println("��ѯ�����û��б� ErrorCode: " + result.getErrorCode());
			System.out.println("��ѯ�����û��б� ErrorMsg: " + result.getErrorMsg());
		}
		System.out.println();
		return result;
	}

	/**
	 * ���ӽ����û�
	 *
	 * @param imcUserEndporintStr ƽ̨����url
	 * @param acmEndpointStr acm url
	 * @param sc client
	 * @throws Exception exception
	 */
	public static void addAcmUser(String imcUserEndporintStr,
			String acmEndpointStr, ServiceClient sc) throws Exception {

		System.out.println("============= ���ӽ����û� =================");
		// ����ƽ̨�û�
		setOptions(imcUserEndporintStr, sc, "urn:addUser");

		// �����û�����Ϊ δ����
		long userGroupId = GROUP_ID;

		WSUser platUser = addPlatUser(imcUserEndporintStr, userGroupId, sc);
		// �����û�ʧ��
		if (platUser == null) {
			System.out.println("*** ���ӽ����û�ʧ�ܣ�����ƽ̨�û�ʧ�ܡ�***");
			return;
		}
		// ��ѯ�û�ʧ��
		if (platUser.getErrorCode() != 0) {
			System.out.println("*** ���ӽ����û�ʧ�ܣ���ѯƽ̨�û�ʧ�ܡ�***");
			System.out.println("������: " + platUser.getErrorCode());
			System.out.println("������Ϣ: " + platUser.getErrorMsg() + "\n");
			return;
		}
		User user = platUser.getUser();
		if (null == user) {
			System.out.println("*** ���ӽ����û�ʧ�ܣ�ϵͳ�����ڶ�Ӧƽ̨�û���Ϣ��***");
			return;
		}
		// ���������û���ȡ���û�userId
		platUserId = user.getId();

		// ���ö�Ӧ�ӿڣ����ӽ����û�
		setOptions(acmEndpointStr, sc, "urn:addAcmUser");

		// ���ӽ����û�
		AcmUserServiceStub stub = new AcmUserServiceStub();

		AddAcmUserParam param = new AddAcmUserParam();
		param.setUserName("clientDemoTest"
				+ String.valueOf(new Random().nextInt(999) + 1));
		Calendar invalidTime = Calendar.getInstance();
		invalidTime.set(2015, 5, 12, 0, 0, 0);
		param.setInvalidTime(invalidTime);
		param.setIdleTimeout(-9999);
		param.setOnlineLimit(1);
		param.setNasIpStr("1.1.1.1");
		param.setNasPort(23);
		param.setVlan(1234);
		param.setVlan2(4000);
		param.setWlanSsid("��add user��_wlan ssid.");
		param.setComputerName("_add_user-_computer%name.");
		param.setBoundDomainName("��add user��_bound domain name.");
		param.setLogonDomainName("��add user��_logon domain name.");
		int count = 7;
		IpMacInfo ipMacInfos[] = new IpMacInfo[count];
		for (int i = 0; i < count; i++) {
			ipMacInfos[i] = new IpMacInfo();
			ipMacInfos[i].setIp("1.0.1." + i);//
			ipMacInfos[i].setMac("A1:B2:C3:D4:E5:F" + (i + 1));
		}
		ipMacInfos[5] = new IpMacInfo();
		ipMacInfos[5].setIp("0.0.0.2");//
		ipMacInfos[5].setMac("A1:B2:C3:D4:E5:F" + 5);

		ipMacInfos[6] = new IpMacInfo();
		ipMacInfos[6].setIp("0.0.0.1");//
		ipMacInfos[6].setMac("A1:B2:C3:D4:E5:F" + 5);
		param.setIpMacInfos(ipMacInfos);
		param.setPassword(String.valueOf(new Random().nextInt(99999) + 1));
		param.setPlatUserId(platUserId);
		// �ʺ����ͺͿ���Ԥ�����
		param.setFeeType(String.valueOf(3));
		param.setOpenPayAmount(String.valueOf(500));


		AddAcmUser addAcmUser = new AddAcmUser();
		addAcmUser.setParam0(param);

		OMElement addAcmUserResp = sc.sendReceive(stub.toOM(addAcmUser, true));
		WSCommonResult result = AddAcmUserResponse.Factory.parse(
				addAcmUserResp.getXMLStreamReaderWithoutCaching()).get_return();

		if (result.getErrorCode() != 0) {
			System.out.println("*** ���ӽ����û�ʧ�ܡ�***");
			System.out.println("������: " + result.getErrorCode());
			System.out.println("������Ϣ: " + result.getErrorMsg() + "\n");
		} else {
			// ��������û���
			accountName = param.getUserName().toLowerCase();

			System.out.println("*** �����û���" + accountName + "�����ӳɹ���***\n");
		}
	}

	/**
	 * �޸Ľ����û�
	 *
	 * @param acmEndpointStr acm url
	 * @param sc client
	 * @throws Exception exception
	 */
	public static void modifyAcmUser(String acmEndpointStr, ServiceClient sc)
			throws Exception {

		System.out.println("============= �޸Ľ����û� =================");
		// ���ӽ����û��ɹ�
		if (StringUtils.isNotBlank(accountName)) {
			// ��ѯ�����û�
			setOptions(acmEndpointStr, sc, "urn:queryAcmUser");

			AcmUserServiceStub stub = new AcmUserServiceStub();
			QueryAcmUser queryAcmUser = new QueryAcmUser();

			// ���ò�ѯ����
			queryAcmUser.setParam0(accountName);

			// ����������
			OMElement element = stub.toOM(queryAcmUser, true);
			// ���������Ĳ�������Ӧ���
			OMElement response = sc.sendReceive(element);
			RetAcmUser acmUser = QueryAcmUserResponse.Factory.parse(
					response.getXMLStreamReaderWithoutCaching()).get_return();

			if (acmUser.getErrorCode() != 0) {
				System.out.println("*** �޸Ľ����û�ʧ�ܣ���ѯ�����û���" + accountName
						+ "��ʧ�ܡ�***");
				System.out.println("������: " + acmUser.getErrorCode());
				System.out.println("������Ϣ: " + acmUser.getErrorMsg() + "\n");
				return;
			}

			// �޸Ľ����û�
			ModifyAcmUserParam acmUserParam = new ModifyAcmUserParam();

			acmUserParam.setUserName(accountName);
			Calendar invalidTime = Calendar.getInstance();
			invalidTime.set(2018, 5, 12, 0, 0, 0);
			acmUserParam.setInvalidTime(invalidTime);
			acmUserParam.setOnlineLimit(2);
			acmUserParam.setNasIpStr("1.1.1.2");
			acmUserParam.setNasPort(25);
			acmUserParam.setVlan(4321);
			acmUserParam.setVlan2(5000);
			acmUserParam.setWlanSsid("��modify user��_wlan ssid.");
			acmUserParam.setComputerName("_modify_user-_computer%name.");
			acmUserParam.setBoundDomainName("��modify user��_bound domain name.");
			acmUserParam.setLogonDomainName("��modify user��_logon domain name.");
			int count = 7;
			IpMacInfo ipMacInfos[] = new IpMacInfo[count];
			for (int i = 0; i < count; i++) {
				ipMacInfos[i] = new IpMacInfo();
				ipMacInfos[i].setIp("1.0.1." + i + 1);//
				ipMacInfos[i].setMac("A1:B2:C3:D4:E5:F" + (i + 2));
			}
			ipMacInfos[5] = new IpMacInfo();
			ipMacInfos[5].setIp("0.0.0.3");//
			ipMacInfos[5].setMac("A1:B2:C3:D4:E5:F" + 6);

			ipMacInfos[6] = new IpMacInfo();
			ipMacInfos[6].setIp("0.0.0.2");//
			ipMacInfos[6].setMac("A1:B2:C3:D4:E5:F" + 6);
			acmUserParam.setIpMacInfos(ipMacInfos);

			ModifyAcmUser modifyAcmUser = new ModifyAcmUser();
			modifyAcmUser.setParam0(acmUserParam);

			// ����������
			element = stub.toOM(queryAcmUser, true);
			// ���������Ĳ�������Ӧ���
			response = sc.sendReceive(element);
			WSCommonResult result = ModifyAcmUserResponse.Factory.parse(
					response.getXMLStreamReaderWithoutCaching()).get_return();

			if (result.getErrorCode() != 0) {
				System.out.println("*** �޸Ľ����û���" + accountName + "��ʧ�ܡ�***");
				System.out.println("������: " + acmUser.getErrorCode());
				System.out.println("������Ϣ: " + acmUser.getErrorMsg() + "\n");
			} else {
				System.out.println("*** �޸Ľ����û���" + accountName + "���ɹ���***");
			}

		} else {
			System.out.println("*** �޸Ľ����û�ʧ�ܣ��������ӽ����û��� ***");
		}
	}

	/**
	 * ע�������û�
	 *
	 * @param acmEndpointStr acm Service Url
	 * @param sc client
	 * @throws Exception exception
	 */
	public static void deleteAcmUser(String acmEndpointStr, ServiceClient sc)
			throws Exception {

		System.out.println("============= ע�������û� =================");

		setOptions(acmEndpointStr, sc, "urn:cancelAcmUser");

		// ���ð��û�
		AcmUserServiceStub stub = new AcmUserServiceStub();

		// �����������
		CancelAcmUser user = new CancelAcmUser();
		user.setParam0(accountName);

		OMElement element = stub.toOM(user, true);

		// ���Ͳ�������Ϣ
		OMElement response1 = sc.sendReceive(element);
		WSCommonResult result = CancelAcmUserResponse.Factory.parse(
				response1.getXMLStreamReaderWithoutCaching()).get_return();

		if (result.getErrorCode() != 0) {
			System.out.println("*** ע�������û�ʧ�ܡ�***");
			System.out.println("������: " + result.getErrorCode());
			System.out.println("������Ϣ: " + result.getErrorMsg() + "\n");
		} else {
			System.out.println("*** ע�������û���" + accountName + "�ɹ�����***\n");
		}

	}

	/**
	 * �޸Ľ����û�����
	 *
	 * @param acmEndpointStr acm Service Url
	 * @param sc client
	 * @throws Exception exception
	 */
	public static void modifyUserPassword(String acmEndpointStr,
			ServiceClient sc) throws Exception {

		System.out.println("============= �޸Ľ����û����� =================");

		setOptions(acmEndpointStr, sc, "urn:modifyUserPassword");

		// ���ð��û�
		AcmUserServiceStub stub = new AcmUserServiceStub();

		// �����������
		ModifyUserPassword user = new ModifyUserPassword();

		ModifyUserPsdParam param = new ModifyUserPsdParam();
		param.setName(accountName);
		param.setNewPsd("12345");

		user.setParam0(param);

		OMElement element = stub.toOM(user, true);

		// ���Ͳ�������Ϣ
		OMElement response1 = sc.sendReceive(element);
		WSCommonResult result = ModifyAcmUserResponse.Factory.parse(
				response1.getXMLStreamReaderWithoutCaching()).get_return();

		if (result.getErrorCode() != 0) {
			System.out.println("*** �޸Ľ����û�����ʧ�ܡ�***");
			System.out.println("������: " + result.getErrorCode());
			System.out.println("������Ϣ: " + result.getErrorMsg() + "\n");
		} else {
			System.out.println("*** �޸Ľ����û���" + accountName + "����ɹ�����***\n");
		}
	}

	/**
	 * ��ȡƽ̨�û�
	 *
	 * @param imcUserEndporintStr Service Url
	 * @param userGroupId �û�����ID
	 * @param sc client
	 * @return ƽ̨User
	 * @throws Exception �׳��쳣
	 */
	public static WSUser addPlatUser(String imcUserEndporintStr,
			long userGroupId, ServiceClient sc) throws Exception {

		// ƽ̨�û�
		WSUser wsUser;

		AddUser addUser = new AddUser();
		User user = new User();
		long time = System.nanoTime();
		String username = "platUser" + time;
		user.setUserName(username);
		user.setStatus(0);
		String certification = "certification" + time;
		user.setCertification(certification);

		UserGroup userGrp = new UserGroup();
		userGrp.setId(userGroupId);
		user.setUserGroup(userGrp);
		UserAppendInfo userAppendInfo = new UserAppendInfo();
		user.setUserAppend(userAppendInfo);
		addUser.setParam0(user);

		ImcplatUserServiceStub stub = new ImcplatUserServiceStub();

		// ����������
		OMElement element = stub.toOM(addUser, true);

		// ���ͺ������Ӧ����
		OMElement response = sc.sendReceive(element);

		com.h3c.imc.acmws.platuserservice.client.ImcplatUserServiceStub.WSCommonResult addUserResult = AddUserResponse.Factory
				.parse(response.getXMLStreamReaderWithoutCaching())
				.get_return();
		// ����ʧ��
		if (0 != addUserResult.getErrorCode()) {

			System.out.println("*** ���ӽ����û�ʧ�ܣ�����ƽ̨�û�ʧ�ܡ�***");
			System.out.println("������: " + addUserResult.getErrorCode());
			System.out.println("������Ϣ: " + addUserResult.getErrorMsg() + "\n");

			return null;
		} else {
			// �������ƺͱ�ʾ��ѯƽ̨�û�
			setOptions(imcUserEndporintStr, sc,
					"urn:queryUserByNameAndIdentity");

			QueryUserByNameAndIdentity query = new QueryUserByNameAndIdentity();
			query.setParam0(username);
			query.setParam1(certification);

			// ����������
			element = stub.toOM(query, true);

			// ���ͺ������Ӧ����
			response = sc.sendReceive(element);
			// ��ѯ��Ӧƽ̨�û�
			wsUser = QueryUserByNameAndIdentityResponse.Factory.parse(
					response.getXMLStreamReaderWithoutCaching()).get_return();

			if (wsUser.getErrorCode() != 0) {
				System.out.println("*** ���ӽ����û�ʧ�ܣ���ѯƽ̨�û�ʧ�ܡ�***");
				System.out.println("������: " + wsUser.getErrorCode());
				System.out.println("������Ϣ: " + wsUser.getErrorMsg() + "\n");

				wsUser.setErrorCode(addUserResult.getErrorCode());
				wsUser.setErrorMsg(addUserResult.getErrorMsg());
			}
		}
		return wsUser;
	}

	/**
	 * ��ѯ������ϸ�б�
	 *
	 * @param endPointStr ���ʵ�WebService URL
	 * @param sc ���Կͻ���
	 * @return ������ϸ�б�
	 * @throws Exception �׳��쳣
	 */
	private static RetAcmAccessDetailList queryAccessDetail(String endPointStr,
			ServiceClient sc) throws Exception {
		System.out.println("=============== ��ѯ������ϸ�б� ===============");
		// ִ�������ʲ�����
		setOptions(endPointStr, sc, "urn:queryAcmAccessDetailList");

		// ���ò�ѯ������ϸ�б����
		AcmUserServiceStub stub = new AcmUserServiceStub();
		AcmAccessDetailQueryParam queryInfo = new AcmAccessDetailQueryParam();
		queryInfo.setAccountName("");
		queryInfo.setServiceID(-1);
		queryInfo.setDeviceStartIp("");
		queryInfo.setUserMac("");
		queryInfo.setUserStartIp("");
		queryInfo.setOfflineCause(-1);
		QueryAcmAccessDetailList queryAcmUserList = new QueryAcmAccessDetailList();
		queryAcmUserList.setParam0(queryInfo);
		OMElement element = stub.toOM(queryAcmUserList, true);

		// ���Ͳ�������Ϣ
		OMElement response = sc.sendReceive(element);
		RetAcmAccessDetailList result = QueryAcmAccessDetailListResponse.Factory
				.parse(response.getXMLStreamReaderWithoutCaching())
				.get_return();
		// ת����������
		if (result.getErrorCode() == 0) {
			System.out.println("*** ��ѯ������ϸ�б�ɹ���10����¼�� ***");
			System.out
					.printf(
							"%-10s %-10s %-20s %-20s %-25s %-10s %-30s %-10s %-15s %-15s %-15s",
							"���", "������ϸID", "�ʺ���", "�û�����", "��¼��", "����ID",
							"���뿪ʼʱ��", "����ʱ��", "�û�IP��ַ", "�����ֽ���", "�����ֽ���");
			System.out.println();
			AcmAccessDetailSimpleInfo[] accessDetailArray = result
					.getAcmAccessDetailSimpleInfo();
			if (null != accessDetailArray && 0 < accessDetailArray.length) {
				int count = 1;
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
						"yyyy-MM-dd hh:mm:ss");
				for (AcmAccessDetailSimpleInfo detailInfo : accessDetailArray) {
					System.out.printf(
							"%-10s %-10s %-20s %-20s %-25s %-10s %-30s"
									+ " %-10s %-15s %-15s %-15s", count,
							detailInfo.getAccessDetailId(), detailInfo
									.getAccountName(),
							detailInfo.getFullName(),
							detailInfo.getLoginName(), detailInfo
									.getServiceId(), detailInfo
									.getAccessStartTime() == null ? "--"
									: simpleDateFormat.format(detailInfo
											.getAccessStartTime().getTime()),
							detailInfo.getAccessDuration(), detailInfo
									.getUserIp(), detailInfo.getInfluxByte(),
							detailInfo.getOutfluxByte());
					System.out.println();
					count += 1;
					if (10 < count) {
						break;
					}
				}
			} else {
				System.out.println("*** δ�ҵ����������ļ�¼ ***");
			}
		} else {
			System.out.println("*** ��ѯ������ϸ�б�ʧ�� ***");
			System.out.println("��ѯ������ϸ�б� ErrorCode: " + result.getErrorCode());
			System.out.println("��ѯ������ϸ�б� ErrorMsg: " + result.getErrorMsg());
		}
		System.out.println();
		return result;
	}

	/**
	 * ��ѯ����ģ���б�
	 *
	 * @param acmEndpointStr service url
	 * @param sc �ͻ���
	 * @throws Exception �쳣
	 * @return RetAcmServerInfoList ����ģ���б�
	 */
	public static RetAcmServiceTemplateInfoList queryServiceTemplateList(
			String acmEndpointStr, ServiceClient sc) throws Exception {

		System.out.println("============= ��ѯ����ģ���б� =================");

		setOptions(acmEndpointStr, sc, "urn:queryServiceTemplateList");

		// ���ò���
		AcmUserServiceStub stub = new AcmUserServiceStub();

		// �����������
		QueryServiceTemplateList templateList = new QueryServiceTemplateList();
		templateList.setParam0(new AcmServiceTemplateQueryParam());
		OMElement element = stub.toOM(templateList, true);

		// ���Ͳ�������Ϣ
		OMElement response = sc.sendReceive(element);

		RetAcmServiceTemplateInfoList result = QueryServiceTemplateListResponse.Factory
				.parse(response.getXMLStreamReaderWithoutCaching())
				.get_return();

		// ��ѯʧ��
		if (result.getErrorCode() != 0) {
			System.out.println("*** ��ѯ����ģ��ʧ�ܡ�***");
			System.out.println("������: " + result.getErrorCode());
			System.out.println("������Ϣ: " + result.getErrorMsg() + "\n");
			return result;
		}
		// ��ѯ���Ϊ��
		RetAcmServiceTemplateInfo[] serverInfo = result
				.getRetAcmServiceTemplateInfoList();
		if (serverInfo == null || serverInfo.length == 0) {
			System.out.println("*** ϵͳ�в����ڷ���ģ�塣***\n");
			return result;
		}

		System.out.println("��" + serverInfo.length + "����¼");
		System.out.printf(
				"%-10s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s",
				" ����ID", "��������", "����״̬", "��������", "�����׺", "����ID", "��ȫ����ID",
				"����IP��ַ", "��������", "�ƷѲ�������");
		System.out.println();

		for (RetAcmServiceTemplateInfo info : serverInfo) {
			System.out
					.printf(
							"%-10s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s",
							info.getServiceId(), convertNull(info
									.getServiceName()), convertStatus(info
									.getServiceStatus()), convertNull(info
									.getServiceDesc()), convertNull(info
									.getServiceSuffix()), info.getGroupId(),
							info.getSafePolicy(), convertAssignIp(info
									.getAssignAddress()), info.getType(), info
									.getPolicyName());
			System.out.println();
		}
		System.out.println();

		return result;
	}

	/**
	 * ����󶨷���
	 *
	 * @param endPointStr ���ʵ�WebService URL
	 * @param sc ���Կͻ���
	 * @throws Exception �׳��쳣
	 */
	private static void applyService(String endPointStr, ServiceClient sc)
			throws Exception {
		// ���ò�ѯ����ģ���б�������÷����б�
		RetAcmServiceTemplateInfoList retServiceList = queryServiceTemplateList(
				endPointStr, sc);
		System.out.println("=============== ������� ===============");
		RetAcmServiceTemplateInfo[] retServiceArray = retServiceList
				.getRetAcmServiceTemplateInfoList();
		if (null == retServiceArray || 0 >= retServiceArray.length) {
			System.out.println("*** �������ʧ��--û�п�������� ***");
			return;
		}
		// ִ����������
		setOptions(endPointStr, sc, "urn:applyService");

		// ��������������
		AcmUserServiceStub stub = new AcmUserServiceStub();
		WSCommonResult result = new WSCommonResult();
		result.setErrorCode(0);
		// ���������б����
		ApplyServiceInfo[] serviceInfoArray = new ApplyServiceInfo[retServiceArray.length];

		for (int i = 0; i < retServiceArray.length; i++) {
			ApplyServiceInfo applyServiceInfo = new ApplyServiceInfo();
			// �жϷ���״̬�Ƿ������
			if (1 == retServiceArray[i].getServiceStatus()) {
				applyServiceInfo.setServiceTemplateId(retServiceArray[i]
						.getServiceId());
				// �ж��Ƿ���Ҫ����IP
				if (1 == retServiceArray[i].getAssignAddress()) {
					applyServiceInfo.setUserIpAddress("10.153.130.12");
				}
				// ������Ҫ�󶨵ķ���ʵ��
				serviceInfoArray[0] = applyServiceInfo;
				ApplyServiceParam queryInfo = new ApplyServiceParam();
				queryInfo.setAccountName(accountName);
				queryInfo.setServiceInfo(serviceInfoArray);
				ApplyService applyService = new ApplyService();
				applyService.setParam0(queryInfo);
				OMElement element = stub.toOM(applyService, true);

				// ���Ͳ�������Ϣ
				OMElement response1 = sc.sendReceive(element);
				result = ApplyServiceResponse.Factory.parse(
						response1.getXMLStreamReaderWithoutCaching())
						.get_return();
				if (0 == result.getErrorCode()) {
					// ������ķ���ID���浽ȫ�ֱ�������ע������ʹ�á�
					serviceIdArray[0] = applyServiceInfo.getServiceTemplateId();
					break;
				}
			}
		}

		// �ж��Ƿ��п�������ķ���
		if (null == serviceInfoArray || 0 >= serviceInfoArray.length
				|| null == serviceInfoArray[0]) {
			System.out.println("*** �������ʧ��--û�п�������� ***");
			return;
		}

		if (0 == result.getErrorCode()) {
			System.out.println("*** �������ɹ� ***");
		} else {
			System.out.println("*** �������ʧ�� ***");
		}
		System.out.println("������� ErrorCode: " + result.getErrorCode());
		System.out.println("������� ErrorMsg: " + result.getErrorMsg());
		System.out.println();
	}

	/**
	 * ע���󶨷���
	 *
	 * @param endPointStr ���ʵ�WebService URL
	 * @param sc ���Կͻ���
	 * @throws Exception �׳��쳣
	 */
	public static void cancelService(String endPointStr, ServiceClient sc)
			throws Exception {
		System.out.println("=============== ע������ ===============");
		if (0 >= serviceIdArray[0]) {
			System.out.println("*** ע������ʧ��--û�п�ע������ ***");
			System.out.println("ע������ ErrorMsg: ��Ҫע���ķ���ID ��" + serviceIdArray[0]
					+ "�������ڻ�δ�󶨵��ʺš�" + accountName + "��");
			return;
		}
		// ִ��ע������
		setOptions(endPointStr, sc, "urn:cancelService");

		// ����ע���������
		AcmUserServiceStub stub = new AcmUserServiceStub();
		CancelServiceParam queryInfo = new CancelServiceParam();
		queryInfo.setAccountName(accountName);
		queryInfo.setServiceList(serviceIdArray);
		CancelService cancelService = new CancelService();
		cancelService.setParam0(queryInfo);
		OMElement element = stub.toOM(cancelService, true);

		// ���Ͳ�������Ϣ
		OMElement response = sc.sendReceive(element);
		WSCommonResult result = CancelServiceResponse.Factory.parse(
				response.getXMLStreamReaderWithoutCaching()).get_return();
		if (0 == result.getErrorCode()) {
			System.out.println("*** ע������ɹ� ***");
		} else {
			System.out.println("*** ע������ʧ�� ***");
		}
		System.out.println("ע������ ErrorCode: " + result.getErrorCode());
		System.out.println("ע������ ErrorMsg: " + result.getErrorMsg());
		System.out.println();
	}

	/**
	 * ת���Զ�����IP
	 *
	 * @param assign intֵ
	 * @return ����IP
	 */
	public static String convertAssignIp(int assign) {
		String assignAddress;
		switch (assign) {
		case 0:
			assignAddress = "��";
			break;
		case 1:
			assignAddress = "��";
			break;
		default:
			assignAddress = "��";
			break;
		}
		return assignAddress;
	}

	/**
	 * ״ֵ̬ת����
	 *
	 * @param status ״̬��
	 * @return ״̬������Ϣ
	 */
	public static String convertDamStatus(int status) {
		if (status == 1) {
			return "δ����";
		} else if (status == 2) {
			return "����";
		} else if (status == 3) {
			return "����";
		} else {
			return "δ֪";
		}
	}

	/**
	 * ת������״̬
	 *
	 * @param status intֵ
	 * @return ����״̬
	 */
	public static String convertStatus(int status) {
		String serverStatus;
		switch (status) {
		case 1:
			serverStatus = "������";
			break;
		case 2:
			serverStatus = "��������";
			break;
		case 3:
			serverStatus = "ɾ��";
			break;
		default:
			serverStatus = "������";
			break;
		}
		return serverStatus;
	}

	/**
	 * �󶨺�����
	 *
	 * @param acmEndpointStr acmService
	 * @param sc �ͻ���
	 * @throws Exception exception
	 */
	public static void addBlackList(String acmEndpointStr, ServiceClient sc)
			throws Exception {

		System.out.println("============= �����û��󶨺����� =================");

		// ���ð󶨺�����
		setOptions(acmEndpointStr, sc, "urn:addBlackList");
		// ���ú�����
		AcmUserServiceStub stub = new AcmUserServiceStub();

		// �����������
		AddBlackList blackList = new AddBlackList();
		blackList.setParam0(accountName);
		OMElement element = stub.toOM(blackList, true);

		// ���Ͳ�������Ϣ
		OMElement response1 = sc.sendReceive(element);
		WSCommonResult result = AddBlackListResponse.Factory.parse(
				response1.getXMLStreamReaderWithoutCaching()).get_return();

		if (result.getErrorCode() != 0) {
			System.out.println("*** ���Ӱ󶨺�����ʧ�ܡ�***");
			System.out.println("������: " + result.getErrorCode());
			System.out.println("������Ϣ: " + result.getErrorMsg() + "\n");
		} else {
			System.out.println("*** �����û���" + accountName + "�������������***\n");
		}
	}

	/**
	 * ��ѯ������
	 *
	 * @param acmEndpointStr acmService
	 * @param sc �ͻ���
	 * @return �������б�
	 * @throws Exception exception
	 */
	public static RetAcmBlackInfoList queryBlackList(String acmEndpointStr,
			ServiceClient sc) throws Exception {

		System.out.println("============= ��ѯ������ =================");

		RetAcmBlackInfoList result;
		// ����
		setOptions(acmEndpointStr, sc, "urn:queryBlackList");
		// ���ú�����
		AcmUserServiceStub stub = new AcmUserServiceStub();
		// �����������
		QueryBlackList blackList = new QueryBlackList();
		blackList.setParam0(new AcmBlackQueryParam());
		OMElement element = stub.toOM(blackList, true);

		// ���Ͳ�������Ϣ
		OMElement response1 = sc.sendReceive(element);
		// ��ȡ��ѯ���
		result = QueryBlackListResponse.Factory.parse(
				response1.getXMLStreamReaderWithoutCaching()).get_return();

		if (result.getErrorCode() != 0) {
			System.out.println("*** ��ѯ������ʧ�ܡ�***");
			System.out.println("������: " + result.getErrorCode());
			System.out.println("������Ϣ: " + result.getErrorMsg() + "\n");

			return result;
		}

		RetAcmBlackInfo[] retAcmBlackInfo = result.getRetAcmBlackInfoList();
		if (retAcmBlackInfo == null || retAcmBlackInfo.length == 0) {
			System.out.println("*** ��ѯ������ʧ�ܣ�ϵͳ�в����ں�������***\n");
			return result;
		}
		System.out.println("��" + retAcmBlackInfo.length + "����¼");
		System.out.printf("%-10s %-25s %-30s %-20s %-25s %-20s", " �ʺ�ID",
				"�ʺ�����", "����ԭ��", "Ip��ַ", "Mac��ַ", "����ʱ��");
		System.out.println();

		for (RetAcmBlackInfo info : retAcmBlackInfo) {
			System.out
					.printf(
							"%-10s %-25s %-30s %-20s %-25s %6$tY-%6$tm-%6$td %6$tH:%6$tM:%6$tS",
							info.getAccountId(), info.getAccountName(),
							convertJoinReason(info.getJoinReason()),
							convertNull(info.getUserIpAddress()),
							convertNull(info.getUserMacAddress()), info
									.getJoinDate());
			System.out.println();
		}
		System.out.println();
		return result;
	}

	/**
	 * ���������
	 *
	 * @param acmEndpointStr acmService
	 * @param sc �ͻ���
	 * @throws Exception exception
	 */
	public static void deleteBlackList(String acmEndpointStr, ServiceClient sc)
			throws Exception {

		System.out.println("============= ��������� =================");

		// ���ý��������
		setOptions(acmEndpointStr, sc, "urn:removeBlackList");
		// ���ú�����
		AcmUserServiceStub stub = new AcmUserServiceStub();

		// �����������
		RemoveBlackList removeList = new RemoveBlackList();
		removeList.setParam0(accountName);
		OMElement element = stub.toOM(removeList, true);

		// ���Ͳ�������Ϣ
		OMElement response1 = sc.sendReceive(element);
		WSCommonResult result = RemoveBlackListResponse.Factory.parse(
				response1.getXMLStreamReaderWithoutCaching()).get_return();

		if (result.getErrorCode() != 0) {
			System.out.println("*** ���������ʧ�ܡ�***");
			System.out.println("������: " + result.getErrorCode());
			System.out.println("������Ϣ: " + result.getErrorMsg() + "\n");
		} else {
			System.out.println("*** �����û���" + accountName + "�������������***\n");
		}
	}

	/**
	 * ��ѯͬ�������б�
	 *
	 * @param acmEndpointStr acm service
	 * @param sc �ͻ���
	 * @return RetAcmSyncPolicyInfoList ͬ�������б�
	 * @throws Exception �쳣
	 */
	public static RetAcmSyncPolicyInfoList querySyncPolicyList(
			String acmEndpointStr, ServiceClient sc) throws Exception {

		System.out.println("============= ��ѯͬ�������б� =================");

		// ���ò�ѯͬ������
		setOptions(acmEndpointStr, sc, "urn:querySyncPolicyInfoList");

		// ����
		AcmUserServiceStub stub = new AcmUserServiceStub();

		// �����������
		QuerySyncPolicyInfoList policy = new QuerySyncPolicyInfoList();
		AcmSyncPolicyQueryParam param = new AcmSyncPolicyQueryParam();
		policy.setParam0(param);
		OMElement element = stub.toOM(policy, true);

		// ���Ͳ�������Ϣ
		OMElement response1 = sc.sendReceive(element);
		RetAcmSyncPolicyInfoList result = QuerySyncPolicyInfoListResponse.Factory
				.parse(response1.getXMLStreamReaderWithoutCaching())
				.get_return();

		if (result.getErrorCode() != 0) {
			System.out.println("*** ��ѯͬ�������б�ʧ�ܡ�***");
			System.out.println("������: " + result.getErrorCode());
			System.out.println("������Ϣ: " + result.getErrorMsg() + "\n");
			return result;
		}

		RetAcmSyncPolicyInfo[] policyInfo = result
				.getRetAcmSyncPolicyInfoList();

		if (policyInfo == null || 0 == policyInfo.length) {
			System.out.println("*** ��ѯͬ�������б�ʧ�ܣ�ϵͳ�в�����ͬ�����ԡ�***\n");
			return result;
		}

		System.out.println("��" + policyInfo.length + "����¼");
		System.out.printf("%-25s %-15s %-25s %-15s %-25s %-20s %-20s", " ��������",
				"����ID", "��������", "����ͬ������ID", "�û�����ID", "����״̬", "�Զ�ͬ��");
		System.out.println();

		for (RetAcmSyncPolicyInfo info : policyInfo) {
			System.out.printf("%-25s %-15s %-25s %-15s %-25s %-20s %-20s",
					convertNull(info.getPolicyName()), info.getServerId(),
					convertNull(info.getServerName()), info.getSyncPolicyId(),
					info.getUserGroupId(), info.getConfigStatus(), info
							.getAutoSync());
			System.out.println();
		}
		// ȡ��һ����¼��id
		policyId = policyInfo[0].getPolicyId();

		System.out.println();
		return result;
	}

	/**
	 * ���Ӱ��û�
	 *
	 * @param acmEndpointStr acm service
	 * @param sc �ͻ���
	 * @throws Exception �쳣
	 */
	public static void addBindingUserList(String acmEndpointStr,
			ServiceClient sc) throws Exception {

		System.out.println("============= ���Ӱ��û� =================");

		setOptions(acmEndpointStr, sc, "urn:addBindingUser");

		// ���ð��û�
		AcmUserServiceStub stub = new AcmUserServiceStub();

		// �����������
		AddBindingUser user = new AddBindingUser();
		user.setParam0(policyId);
		user.setParam1(userId);
		OMElement element = stub.toOM(user, true);

		// ���Ͳ�������Ϣ
		OMElement response1 = sc.sendReceive(element);
		WSCommonResult result = AddBindingUserResponse.Factory.parse(
				response1.getXMLStreamReaderWithoutCaching()).get_return();

		if (result.getErrorCode() != 0) {
			System.out.println("*** ���Ӱ��û�ʧ�ܡ�***");
			System.out.println("������: " + result.getErrorCode());
			System.out.println("������Ϣ: " + result.getErrorMsg() + "\n");
		} else {
			System.out.println("*** ����LDAP���û���" + accountName + "����***\n");
		}
	}

	/**
	 * ��ѯͬ�������û��б�
	 *
	 * @param acmEndpointStr acm service
	 * @param sc �ͻ���
	 * @return RetAcmSyncPolicyUserInfoList ͬ�������û��б�
	 * @throws Exception �쳣
	 */
	public static RetAcmSyncPolicyUserInfoList querySyncPolicyUserList(
			String acmEndpointStr, ServiceClient sc) throws Exception {

		System.out.println("============= ��ѯͬ�������û��б� =================");

		RetAcmSyncPolicyUserInfoList result;
		// ����
		setOptions(acmEndpointStr, sc, "urn:querySyncPolicyUserInfoList");

		// ���ò�ѯͬ�������û�
		AcmUserServiceStub stub = new AcmUserServiceStub();

		AcmSyncPolicyUserQueryParam param = new AcmSyncPolicyUserQueryParam();
		param.setPolicyId(policyId);
		// �����������
		QuerySyncPolicyUserInfoList policy = new QuerySyncPolicyUserInfoList();

		policy.setParam0(param);
		OMElement element = stub.toOM(policy, true);

		// ���Ͳ�������Ϣ
		OMElement response1 = sc.sendReceive(element);
		result = QuerySyncPolicyUserInfoListResponse.Factory.parse(
				response1.getXMLStreamReaderWithoutCaching()).get_return();

		// ��ѯʧ��
		if (result.getErrorCode() != 0) {
			System.out.println("*** ��ѯͬ�������û��б�ʧ�ܣ���ѯͬ�������û�ʧ�ܡ�***");
			System.out.println("������: " + result.getErrorCode());
			System.out.println("������Ϣ: " + result.getErrorMsg() + "\n");
			return result;
		}
		// û�в�ѯ���
		RetAcmSyncPolicyUserInfo[] retAcmSyncUserInfo = result
				.getRetAcmSyncPolicyUserInfoList();
		if (retAcmSyncUserInfo == null || retAcmSyncUserInfo.length == 0) {
			System.out.println("*** ��ѯͬ�������û��б�ϵͳ�в�����ͬ�������û���***\n");
			return result;
		}
		System.out.println("��" + retAcmSyncUserInfo.length + "����¼");
		System.out.printf("%-25s %-25s %-25s %-25s ", " �ʺ�����", "�û�����",
				"�û�����ID", "�û�״̬");
		System.out.println();

		for (RetAcmSyncPolicyUserInfo info : retAcmSyncUserInfo) {
			System.out.printf("%-25s %-25s %-25s %-25s", convertNull(info
					.getAccountName()), convertNull(info.getUserName()), info
					.getUserGroupId(), info.getStatus());
			System.out.println();
		}
		System.out.println();
		return result;
	}

	/**
	 * ������û�
	 *
	 * @param acmEndpointStr acm service
	 * @param sc �ͻ���
	 * @throws Exception �쳣
	 */
	public static void deleteBindingUserList(String acmEndpointStr,
			ServiceClient sc) throws Exception {

		System.out.println("============= ������û� =================");

		setOptions(acmEndpointStr, sc, "urn:cancelBindingUser");

		// ���ý�����û�
		AcmUserServiceStub stub = new AcmUserServiceStub();

		// �����������
		CancelBindingUser user = new CancelBindingUser();
		user.setParam0(userId);
		OMElement element = stub.toOM(user, true);

		// ���Ͳ�������Ϣ
		OMElement response1 = sc.sendReceive(element);
		WSCommonResult result = CancelBindingUserResponse.Factory.parse(
				response1.getXMLStreamReaderWithoutCaching()).get_return();

		if (result.getErrorCode() != 0) {
			System.out.println("*** ������û�ʧ�ܡ�***");
			System.out.println("������: " + result.getErrorCode());
			System.out.println("������Ϣ: " + result.getErrorMsg() + "\n");
		} else {
			System.out.println("*** ����û���" + accountName
					+ "��LDAPͬ�����Եİ󶨡���***\n");
		}
	}

	/**
	 * ��ѯ�����û��б�
	 *
	 * @param endPointStr ���ʵ�WebService URL
	 * @param sc ���Կͻ���
	 * @return �����û��б�
	 * @throws Exception �׳��쳣
	 */
	public static RetAcmOnlineUserList queryOnlineUser(String endPointStr,
			ServiceClient sc) throws Exception {
		System.out.println("=============== ��ѯ�����û��б� ===============");
		// ִ�в�ѯ�����û�����
		setOptions(endPointStr, sc, "urn:queryAcmOnlineUserList");

		// ���ò�ѯ�����û��б����
		AcmUserServiceStub stub = new AcmUserServiceStub();
		AcmOnlineUserQueryParam queryInfo = new AcmOnlineUserQueryParam();
		queryInfo.setAccountName("");
		queryInfo.setInnerVlanId(-9999);
		queryInfo.setOuterVlanId(-9999);
		queryInfo.setPort(-9999);
		queryInfo.setServiceID(-9999);
		queryInfo.setSecurityStatus(-9999);
		queryInfo.setSuspendDuration(-9999);
		QueryAcmOnlineUserList queryAcmOnlineList = new QueryAcmOnlineUserList();
		queryAcmOnlineList.setParam0(queryInfo);
		OMElement element = stub.toOM(queryAcmOnlineList, true);

		// ���Ͳ�������Ϣ
		OMElement response1 = sc.sendReceive(element);
		RetAcmOnlineUserList result = QueryAcmOnlineUserListResponse.Factory
				.parse(response1.getXMLStreamReaderWithoutCaching())
				.get_return();
		// ת����������
		if (result.getErrorCode() == 0) {
			System.out.println("*** ��ѯ�����û��б�ɹ���10����¼�� ***");
			System.out
					.printf(
							"%-10s %-10s %-20s %-20s %-20s %-20s %-30s %-10s %-20s %-20s %-10s",
							"���", "�����û�ID", "�ʺ���", "��¼��", "�û�����", "��������",
							"����ʱ��", "����ʱ��", "�豸IP", "�û�IP", "��ȫ״̬");
			System.out.println();
			acmOnlineUserArray = result.getOnlineUserInfoArray();
			if (null != acmOnlineUserArray && 0 < acmOnlineUserArray.length) {
				int count = 0;
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
						"yyyy-MM-dd hh:mm:ss");
				for (AcmOnlineUserSimpleInfo onlineInfo : acmOnlineUserArray) {
					System.out.printf(
							"%-10s %-10s %-20s %-20s %-20s %-20s %-30s"
									+ " %-10s %-20s %-20s %-10s", count,
							onlineInfo.getOnlineUserId(), onlineInfo
									.getAccountName(), onlineInfo
									.getLoginName(), onlineInfo.getFullName(),
							onlineInfo.getServiceName(), onlineInfo
									.getLoginTime() == null ? "--"
									: simpleDateFormat.format(onlineInfo
											.getLoginTime().getTime()),
							onlineInfo.getOnlineDuration(), onlineInfo
									.getDeviceIp(), onlineInfo.getUserIp(),
							onlineInfo.getSecurityStatus());
					System.out.println();
					count += 1;
				}
			} else {
				System.out.println("*** δ�ҵ����������ļ�¼ ***");
			}
		} else {
			System.out.println("*** ��ѯ�����û��б�ʧ�� ***");
			System.out.println("��ѯ�����û� ErrorCode: " + result.getErrorCode());
			System.out.println("��ѯ�����û� ErrorMsg: " + result.getErrorMsg());
		}
		System.out.println();
		return result;
	}

	/**
	 * �·���Ϣ
	 *
	 * @param endPointStr ���ʵ�WebService URL
	 * @param sc ���Կͻ���
	 * @throws Exception �׳��쳣
	 */
	public static void sendMessage(String endPointStr, ServiceClient sc)
			throws Exception {
		System.out.println("=============== �������û��·���Ϣ ===============");
		// ������в����������û�
		AcmOnlineUserSimpleInfo acmOnlineUserSimpleInfo;
		if (null != acmOnlineUserArray && 0 < acmOnlineUserArray.length) {
			acmOnlineUserSimpleInfo = acmOnlineUserArray[0];
		} else {
			System.out.println("*** �·���Ϣʧ�ܣ�δ�ҵ������û��� ***");
			System.out.println();
			return;
		}
		// ִ�в�ѯ�����û�����
		setOptions(endPointStr, sc, "urn:sendMessage");

		// ���ò�ѯ�����û��б����
		AcmUserServiceStub stub = new AcmUserServiceStub();
		SendMessage sendMessage = new SendMessage();
		// ���������û�ID
		sendMessage.setParam0(acmOnlineUserSimpleInfo.getOnlineUserId());
		// �����·���Ϣ����
		sendMessage.setParam1("The Messages.");
		OMElement element = stub.toOM(sendMessage, true);

		// ���Ͳ�������Ϣ
		OMElement response1 = sc.sendReceive(element);
		WSCommonResult result = SendMessageResponse.Factory.parse(
				response1.getXMLStreamReaderWithoutCaching()).get_return();
		if (0 == result.getErrorCode()) {
			System.out.println("*** �·���Ϣ�ɹ� ***");
		} else {
			System.out.println("*** �·���Ϣʧ�� ***");
		}
		System.out.println("�·���Ϣ ErrorCode: " + result.getErrorCode());
		System.out.println("�·���Ϣ ErrorMsg: " + result.getErrorMsg());
		System.out.println();
	}

	/**
	 * ���������Ϣ
	 *
	 * @param endPointStr ���ʵ�WebService URL
	 * @param sc ���Կͻ���
	 * @throws Exception �׳��쳣
	 */
	public static void clearOnlineInfo(String endPointStr, ServiceClient sc)
			throws Exception {
		System.out.println("=============== ��������û���Ϣ ===============");
		// ������в����������û�
		AcmOnlineUserSimpleInfo acmOnlineUserSimpleInfo;
		if (null != acmOnlineUserArray && 0 < acmOnlineUserArray.length) {
			acmOnlineUserSimpleInfo = acmOnlineUserArray[0];
		} else {
			System.out.println("*** �����Ϣʧ�ܣ�δ�ҵ������û��� ***");
			System.out.println();
			return;
		}
		// ִ�в�ѯ�����û�����
		setOptions(endPointStr, sc, "urn:clearOnlineInfo");

		// ���ò�ѯ�����û��б����
		AcmUserServiceStub stub = new AcmUserServiceStub();
		ClearOnlineInfo clearOnlineInfo = new ClearOnlineInfo();
		// ���������û�ID
		clearOnlineInfo.setParam0(acmOnlineUserSimpleInfo.getOnlineUserId());
		OMElement element = stub.toOM(clearOnlineInfo, true);

		// ���Ͳ�������Ϣ
		OMElement response1 = sc.sendReceive(element);
		WSCommonResult result = ClearOnlineInfoResponse.Factory.parse(
				response1.getXMLStreamReaderWithoutCaching()).get_return();
		if (0 == result.getErrorCode()) {
			System.out.println("*** �����Ϣ�ɹ� ***");
		} else {
			System.out.println("*** �����Ϣʧ�� ***");
		}
		System.out.println("��������û���Ϣ ErrorCode: " + result.getErrorCode());
		System.out.println("��������û���Ϣ ErrorMsg: " + result.getErrorMsg());
		System.out.println();
	}

	/**
	 * ǿ������
	 *
	 * @param endPointStr ���ʵ�WebService URL
	 * @param sc ���Կͻ���
	 * @throws Exception �׳��쳣
	 */
	public static void kickOut(String endPointStr, ServiceClient sc)
			throws Exception {
		System.out.println("=============== ǿ�������û����� ===============");
		// ������в����������û�
		AcmOnlineUserSimpleInfo acmOnlineUserSimpleInfo;
		if (null != acmOnlineUserArray && 0 < acmOnlineUserArray.length) {
			acmOnlineUserSimpleInfo = acmOnlineUserArray[0];
		} else {
			System.out.println("*** ǿ������ʧ�ܣ�δ�ҵ������û��� ***");
			System.out.println();
			return;
		}
		// ִ�в�ѯ�����û�����
		setOptions(endPointStr, sc, "urn:kickOut");

		// ���ò�ѯ�����û��б����
		AcmUserServiceStub stub = new AcmUserServiceStub();
		KickOut kickOut = new KickOut();
		// ���������û�ID
		kickOut.setParam0(acmOnlineUserSimpleInfo.getOnlineUserId());
		OMElement element = stub.toOM(kickOut, true);

		// ���Ͳ�������Ϣ
		OMElement response1 = sc.sendReceive(element);
		WSCommonResult result = KickOutResponse.Factory.parse(
				response1.getXMLStreamReaderWithoutCaching()).get_return();
		if (0 == result.getErrorCode()) {
			System.out.println("*** ǿ�����߳ɹ� ***");
		} else {
			System.out.println("*** ǿ������ʧ�� ***");
		}
		System.out.println("ǿ�������û����� ErrorCode: " + result.getErrorCode());
		System.out.println("ǿ�������û����� ErrorMsg: " + result.getErrorMsg());
		System.out.println();
	}

	/**
	 * ת�����������ԭ��
	 *
	 * @param joinReason ����ԭ��
	 * @return ����ԭ��
	 */
	public static String convertJoinReason(int joinReason) {
		String reason;
		switch (joinReason) {
		case 1:
			reason = "����Ա�����û�";
			break;
		case 2:
			reason = "������֤ʧ����ֵ";
			break;
		case 3:
			reason = "�����֤ʧ��(������)";
			break;
		default:
			reason = "����Ա�����û�";
			break;
		}
		return reason;
	}

	/**
	 * NULLֵת����
	 *
	 * @param value ���ݿ�ֵ
	 * @return ת�����ֵ
	 */
	public static String convertNull(String value) {
		if (StringUtils.isBlank(value)) {
			return "--";
		} else {
			return value;
		}
	}

	/**
	 * ע��ϵͳ��
	 *
	 * @param imcPlatEndPointStr WebService location
	 * @param sc �ͻ���
	 * @throws Exception �쳣
	 */
	public static void logout(String imcPlatEndPointStr, ServiceClient sc)
			throws Exception {
		// ����ע���ӿ�
		setOptions(imcPlatEndPointStr, sc, "urn:logout");

		// ����������
		OMFactory factory = OMAbstractFactory.getOMFactory();
		OMNamespace ns = factory.createOMNamespace(
				"http://imc.h3c.com/imcplatService", "ns");
		OMElement elem = factory.createOMElement("logout", ns);

		// ���ͺ������Ӧ����
		OMElement response = sc.sendReceive(elem);
		// ������Ӧ����
		ImcplatServiceStub.WSCommonResult result = LogoutResponse.Factory
				.parse(response.getXMLStreamReaderWithoutCaching())
				.get_return();

		System.out.println("=============== ע��ϵͳ =================");
		// ע��ʧ��
		if (result.getErrorCode() != 0) {
			System.out.println("*** ����Ա��admin��ע��ʧ�ܡ�***");
			System.out.println("������: " + result.getErrorCode());
			System.out.println("������Ϣ: " + result.getErrorMsg());
		}
		// ע���ɹ�
		else {
			System.out.println("*** ����Ա��admin��ע���ɹ���***\n");
		}
	}

	/**
	 * ���ز��ԡ�
	 *
	 * @param xmlPath �����ļ�·��
	 * @return ���Զ���
	 * @throws FileNotFoundException �ļ��������쳣
	 * @throws XMLStreamException XML�����쳣
	 */
	private static Policy loadPolicy(String xmlPath)
			throws FileNotFoundException, XMLStreamException {
		StAXOMBuilder stAXOMBuilder = new StAXOMBuilder(xmlPath);
		return PolicyEngine.getPolicy(stAXOMBuilder.getDocumentElement());
	}

}
