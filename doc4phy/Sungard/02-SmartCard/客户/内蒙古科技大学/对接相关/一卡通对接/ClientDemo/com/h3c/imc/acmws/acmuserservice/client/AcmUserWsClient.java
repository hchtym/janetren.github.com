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
 * 二次开发接口客户端样例。
 *
 * @author jiaxun & fujiangnan
 */
public class AcmUserWsClient {

	/** ip地址 */
	private static String ipAddress;

	/** 端口 */
	private static String port;

	/** 是否加密 */
	private static boolean rampart;

	/** 增加资产后的资产编号 */
	private static String assetNo;

	/** 默认分组ID */
	private static final long GROUP_ID = 1;

	/** 同步策略ID */
	private static long policyId;

	/** 接入用户ID */
	private static long userId;

	/** 接入平台用户ID */
	private static long platUserId;

	/** 接入用户名 */
	private static String accountName;

	/** 需要注销的服务ID数组 */
	private static long[] serviceIdArray = new long[1];

	/** 查询出来的在线用户列表 */
	private static AcmOnlineUserSimpleInfo[] acmOnlineUserArray;

	/**
	 * 二次开发接口客户端样例。
	 *
	 * @param args 命令行参数
	 * @throws Exception 抛出异常
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
				System.out.println("无效的IP地址。");
				System.exit(0);
			}

			try {
				int ptPort = Integer.parseInt(args[1]);
				if (ptPort < 0 || ptPort > 65535) {
					throw new Exception("invalid port");
				}
			} catch (Exception e) {
				System.out.println("无效的端口号。");
				System.exit(0);
			}

			port = args[1];
			rampart = false;

		} else if (args.length == 3) {
			if (args[0].matches(ptIpAddress)) {
				ipAddress = args[0];
			} else {
				System.out.println("无效的IP地址。");
				System.exit(0);
			}

			try {
				int ptPort = Integer.parseInt(args[1]);
				if (ptPort < 0 || ptPort > 65535) {
					throw new Exception("invalid port");
				}
			} catch (Exception e) {
				System.out.println("无效的端口号。");
				System.exit(0);
			}

			port = args[1];

			if (args[2].equals("-r")) {
				rampart = true;
			} else {
				System.out.println("参数“" + args[2] + "”无效。");
				System.exit(0);
			}

		} else {
			System.out.println("请按如下格式输入参数: IP Port [-r]");
			System.out.println("-r 是否加密");
			System.exit(0);
		}

		// 初始化
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

		// 创建客户端
		ConfigurationContext ctx = ConfigurationContextFactory
				.createConfigurationContextFromFileSystem("repository", null);
		ServiceClient sc = new ServiceClient(ctx, null);

		// 登录系统
		login(imcPlatEndpointStr, sc);

		// 增加接入用户
		addAcmUser(imcUserEndporintStr, acmEndpointStr, sc);

		// 缴费
		pay(feeEndpointStr, sc);

		// 查询余额
		queryBalance(feeEndpointStr, sc);

		// 查询对应接入用户
		queryAcmUser(acmEndpointStr, sc);

		// 根据平台用户ID查询用户详细信息
		queryAcmUserByPlatUserId(acmEndpointStr, sc);

		// 根据ID修改该用户的失效时间
		modifyInvalidTime(acmEndpointStr, sc);

		// 查询接入用户列表
		queryAccessUserArray(acmEndpointStr, sc);

		// 修改接入用户
		modifyAcmUser(acmEndpointStr, sc);

		// 修改密码
		modifyUserPassword(acmEndpointStr, sc);

		// 查询接入明细列表
		queryAccessDetail(acmEndpointStr, sc);

		// // 查询服务模板列表
		// queryServerTemplateList(acmEndpointStr, sc);

		// 申请绑定服务，其中调用了查询服务模板列表。
		applyService(acmEndpointStr, sc);

		// 增加黑名单
		addBlackList(acmEndpointStr, sc);

		// 查询黑名单
		queryBlackList(acmEndpointStr, sc);

		// 解除黑名单
		deleteBlackList(acmEndpointStr, sc);

		// 查询同步策略列表
		querySyncPolicyList(acmEndpointStr, sc);

		// 增加绑定用户
		addBindingUserList(acmEndpointStr, sc);

		// 查询同步策略下用户
		querySyncPolicyUserList(acmEndpointStr, sc);

		// 解除绑定用户
		deleteBindingUserList(acmEndpointStr, sc);

		// 查询在线用户
		queryOnlineUser(acmEndpointStr, sc);

		// // 下发消息
		// sendMessage(acmEndpointStr, sc);
		//
		// // 清除在线信息
		// clearOnlineInfo(acmEndpointStr, sc);
		//
		// // 强制下线
		// kickOut(acmEndpointStr, sc);
		//

		// Add new clientDemo for cams porject
		// 根据用户ID暂停用户
		suspendUserByUserId(feeEndpointStr, sc);
		// 根据用户ID取消暂停
		cancelSuspendUserByUserId(feeEndpointStr, sc);

		// 注销服务
		cancelService(acmEndpointStr, sc);

		// 根据用户ID查询账单
		queryPaymentRecordByUserId(feeEndpointStr, sc);
		// 查询系统参数接口
		querySystemParamValue(acmEndpointStr, sc);

		// 根据帐号ID查询帐单明细
		queryBillByUserId(feeEndpointStr, sc);
		// 根据帐单ID查询接入明细
		queryBillDetailByBillId(feeEndpointStr, sc);

		// Add finish

		// 注销接入用户
		deleteAcmUser(acmEndpointStr, sc);

		// 单条定制查询
		singleQuery(queryEndpointStr, acmEndpointStr, sc);

		// 多条定制查询
		multiQuery(queryEndpointStr, imcUserEndporintStr, sc);

		try {
			// 查询前15条资产
			queryFirstPageAssets(damEndpointStr, sc);

			// 查询所有资产分组
			queryAssetGroups(damEndpointStr, sc);

			// 增加资产
			addAsset(damEndpointStr, imcPlatEndpointStr, imcUserEndporintStr,
					sc);

			// 修改资产
			modifyAsset(damEndpointStr, imcPlatEndpointStr,
					imcUserEndporintStr, sc);

			// 删除资产
			deleteAsset(damEndpointStr, imcUserEndporintStr, sc);

		} catch (Exception e) {
			System.out.println("*** 系统未安装资产组件。***\n");
		}

		// 注销系统
		logout(imcPlatEndpointStr, sc);
	}

	/**
	 * 查询系统参数值
	 *
	 * @param acmEndpointStr 访问WebService url
	 * @param sc 测试客户端
	 * @throws Exception Exception
	 * @return value
	 */
	private static RetSystemParameter querySystemParamValue(
			String acmEndpointStr, ServiceClient sc) throws Exception {

		System.out.println("=============== 查询系统参数值 ===============");
		// 执行查询在线用户操作
		setOptions(acmEndpointStr, sc, "urn:queryParameterByName");

		// 设置绑定用户
		AcmUserServiceStub stub = new AcmUserServiceStub();

		// 设置输入参数
		QueryParameterByName query = new QueryParameterByName();
		// 查询营业厅组件是否安装
		query.setParam0("IF_COUNTER_COMP_INSTALL");

		OMElement element = stub.toOM(query, true);

		// 发送并接收消息
		OMElement response1 = sc.sendReceive(element);
		RetSystemParameter result = QueryParameterByNameResponse.Factory.parse(
				response1.getXMLStreamReaderWithoutCaching()).get_return();

		if (result.getErrorCode() == 0) {
			System.out.println("查询系统参数值 :" + result.getValue());

		} else {
			System.out.println("*** 查询系统参数值失败 ***");
			System.out.println("查询系统参数值 ErrorCode: " + result.getErrorCode());
			System.out.println("查询系统参数值 ErrorMsg: " + result.getErrorMsg());
		}
		System.out.println();
		return result;
	}

	/**
	 * 查询缴费记录
	 *
	 * @param feeEndpointStr 访问webService url
	 * @param sc 测试客户端
	 * @throws Exception exception
	 * @return 缴费记录
	 * @throws Exception exception
	 */
	private static RetPaymentRecordList queryPaymentRecordByUserId(
			String feeEndpointStr, ServiceClient sc) throws Exception {

		System.out.println("=============== 查询缴费记录列表 ===============");
		// 执行查询在线用户操作
		setOptions(feeEndpointStr, sc, "urn:queryPaymentRecord");

		// 设置查询接入用户列表参数
		FeeServiceStub stub = new FeeServiceStub();

		QueryPaymentRecord query = new QueryPaymentRecord();
		query.setParam0(userId);

		OMElement element = stub.toOM(query, true);

		// 发送并接收消息
		OMElement response1 = sc.sendReceive(element);
		RetPaymentRecordList result = QueryPaymentRecordResponse.Factory.parse(
				response1.getXMLStreamReaderWithoutCaching()).get_return();
		// 转换日期类型
		if (result.getErrorCode() == 0) {
			System.out.println("*** 查询缴费记录列表 ***");
			System.out.printf(
					"%-10s %-20s %-15s %-15s %-20s %-20s %-20s %-20s "
							+ "%-20s %-20s %-20s %-20s", "缴费记录ID", " 流水号",
					"帐号名", "帐号类型", "用户姓名", "缴费金额", "缴费日期", "余额", "收费人员",
					"缴费方式", "上次余额", "操作员登录IP");
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
				System.out.println("*** 未找到符合条件的记录 ***");
			}
		} else {
			System.out.println("*** 查询缴费记录列表失败 ***");
			System.out.println("查询缴费记录列表 ErrorCode: " + result.getErrorCode());
			System.out.println("查询缴费记录列表 ErrorMsg: " + result.getErrorMsg());
		}
		System.out.println();
		return result;
	}

	/**
	 * 根据用户ID暂停用户
	 *
	 * @param feeEndpointStr 访问url
	 * @param sc 测试客户端
	 * @throws Exception exception
	 */
	private static void suspendUserByUserId(String feeEndpointStr,
			ServiceClient sc) throws Exception {

		System.out.println("=============== 根据用户ID暂停用户 =================");

		setOptions(feeEndpointStr, sc, "urn:suspendUserById");

		// 设置绑定用户
		FeeServiceStub stub = new FeeServiceStub();

		// 设置输入参数
		SuspendUserById user = new SuspendUserById();
		user.setParam0(userId);
		user.setParam1(Calendar.getInstance());
		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());
		char[] dictionary = new char[] { '1', '2', '3', '4', '5', '6', '7',
					'8', '9'};
		user.setParam2(rand.nextInt(dictionary.length));

		OMElement element = stub.toOM(user, true);

		// 发送并接收消息
		OMElement response1 = sc.sendReceive(element);
		com.h3c.imc.acmws.acmuserservice.client.FeeServiceStub.WSCommonResult result = SuspendUserByIdResponse.Factory
				.parse(response1.getXMLStreamReaderWithoutCaching())
				.get_return();

		if (result.getErrorCode() != 0) {
			System.out.println("*** 暂停用户失败。***");
			System.out.println("错误码: " + result.getErrorCode());
			System.out.println("错误信息: " + result.getErrorMsg() + "\n");
		} else {
			System.out.println("*** 暂停用户成功。***");
		}

	}

	/**
	 * 根据用户取消暂停
	 *
	 * @param feeEndpointStr 访问webService url
	 * @param sc 测试客户端
	 * @throws Exception Exception
	 */
	private static void cancelSuspendUserByUserId(String feeEndpointStr,
			ServiceClient sc) throws Exception {

		System.out.println("=============== 根据用户ID取消暂停用户 =================");

		setOptions(feeEndpointStr, sc, "urn:cancelSuspendUserById");

		// 设置绑定用户
		FeeServiceStub stub = new FeeServiceStub();

		// 设置输入参数
		CancelSuspendUserById user = new CancelSuspendUserById();
		user.setParam0(userId);

		OMElement element = stub.toOM(user, true);

		// 发送并接收消息
		OMElement response1 = sc.sendReceive(element);
		com.h3c.imc.acmws.acmuserservice.client.FeeServiceStub.WSCommonResult result = CancelSuspendUserByIdResponse.Factory
				.parse(response1.getXMLStreamReaderWithoutCaching())
				.get_return();

		if (result.getErrorCode() != 0) {
			System.out.println("*** 取消暂停用户失败。***");
			System.out.println("错误码: " + result.getErrorCode());
			System.out.println("错误信息: " + result.getErrorMsg() + "\n");
		} else {
			System.out.println("*** 取消暂停用户成功。***");
		}

	}

	/**
	 * 根据ID修改该用户的失效时间
	 *
	 * @param acmEndpointStr 访问的WebService URL
	 * @param sc 测试客户端
	 * @throws Exception exception
	 */
	public static void modifyInvalidTime(String acmEndpointStr, ServiceClient sc)
			throws Exception {
		System.out.println("=============== 根据ID修改该用户的失效时间 =================");

		setOptions(acmEndpointStr, sc, "urn:modifyInvalidTime");

		// 设置绑定用户
		AcmUserServiceStub stub = new AcmUserServiceStub();

		// 设置输入参数
		ModifyInvalidTime time = new ModifyInvalidTime();
		time.setParam0(userId);
		time.setParam1(Calendar.getInstance());

		OMElement element = stub.toOM(time, true);

		// 发送并接收消息
		OMElement response1 = sc.sendReceive(element);
		WSCommonResult result = ModifyInvalidTimeResponse.Factory.parse(
				response1.getXMLStreamReaderWithoutCaching()).get_return();

		if (result.getErrorCode() != 0) {
			System.out.println("*** 修改该用户的失效时间失败。***");
			System.out.println("错误码: " + result.getErrorCode());
			System.out.println("错误信息: " + result.getErrorMsg() + "\n");
		} else {
			System.out.println("*** 修改该用户的失效时间成功。***\n");
		}
	}

	/**
	 * 根据平台用户ID查询用户详细信息。
	 *
	 * @param acmEndpointStr 访问的WebService URL
	 * @param sc 测试客户端
	 * @throws Exception exception
	 */
	public static RetAcmUser queryAcmUserByPlatUserId(String acmEndpointStr,
			ServiceClient sc) throws Exception {
		System.out
				.println("=============== 根据平台用户ID查询用户详细信息 =================");
		setOptions(acmEndpointStr, sc, "urn:queryAcmUserByPlatUserId");

		// 设置绑定用户
		AcmUserServiceStub stub = new AcmUserServiceStub();

		// 设置输入参数
		QueryAcmUserByPlatUserId user = new QueryAcmUserByPlatUserId();
		user.setParam0(platUserId);

		OMElement element = stub.toOM(user, true);

		// 发送并接收消息
		OMElement response1 = sc.sendReceive(element);
		RetAcmUser acmUser = QueryAcmUserByPlatUserIdResponse.Factory.parse(
				response1.getXMLStreamReaderWithoutCaching()).get_return();

		if (acmUser.getErrorCode() != 0) {
			System.out.println("*** 查询接入用户失败。***");
			System.out.println("错误码: " + acmUser.getErrorCode());
			System.out.println("错误信息: " + acmUser.getErrorMsg() + "\n");
		} else {
			if (null != acmUser.getAcmUser()) {
				System.out.println("*** 查询接入用户“"
						+ acmUser.getAcmUser().getUserName() + "成功”。***\n");
			} else {
				System.out.println("*** 该平台用户没有还没有申请接入用户。***\n");
			}
		}
		return acmUser;
	}

	/**
	 * 根据帐号ID查询帐单明细列表
	 *
	 * @param endPointStr 访问的WebService URL
	 * @param sc 测试客户端
	 * @return 帐单明细列表
	 * @throws Exception 抛出异常
	 */
	public static RetAcmUserBillList queryBillByUserId(String endPointStr,
			ServiceClient sc) throws Exception {
		System.out.println("=============== 查询帐单明细列表 ===============");
		// 执行查询在线用户操作
		setOptions(endPointStr, sc, "urn:queryBillByUserId");

		// 设置查询接入用户列表参数
		FeeServiceStub stub = new FeeServiceStub();
		QueryBillByUserId queryBillByUserId = new QueryBillByUserId();
		queryBillByUserId.setParam0(1L);
		OMElement element = stub.toOM(queryBillByUserId, true);

		// 发送并接收消息
		OMElement response1 = sc.sendReceive(element);
		RetAcmUserBillList result = QueryBillByUserIdResponse.Factory.parse(
				response1.getXMLStreamReaderWithoutCaching()).get_return();
		// 转换日期类型
		if (result.getErrorCode() == 0) {
			System.out.println("*** 查询帐单明细列表成功（10条记录） ***");
			System.out
					.printf(
							"%-10s %-10s %-20s %-20s %-10s %-20s %-30s %-10s "
									+ "%-20s %-10s %-20s %-10s %-10s %-20s %-10s %-10s",
							"序号", "帐单ID", "帐号名", "服务名", "业务类型", "计费周期开始时间",
							"计费周期结束时间", "周期固定费", "使用量", "使用单位", "消费额", "奖励金额",
							"奖励金额使用量", "帐单生成时间", "出帐类型", "帐单状态");
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
				System.out.println("*** 未找到符合条件的记录 ***");
			}
		} else {
			System.out.println("*** 查询帐单明细列表失败 ***");
			System.out.println("查询帐单明细 ErrorCode: " + result.getErrorCode());
			System.out.println("查询帐单明细 ErrorMsg: " + result.getErrorMsg());
		}
		System.out.println();
		return result;
	}

	/**
	 * 根据帐单ID查询接入明细列表
	 *
	 * @param endPointStr 访问的WebService URL
	 * @param sc 测试客户端
	 * @return 帐单明细列表
	 * @throws Exception 抛出异常
	 */
	public static RetAcmBillDetailList queryBillDetailByBillId(
			String endPointStr, ServiceClient sc) throws Exception {
		System.out.println("=============== 查询帐单相关接入明细列表 ===============");
		// 执行查询在线用户操作
		setOptions(endPointStr, sc, "urn:queryBillDetailByBillId");

		// 设置查询接入用户列表参数
		FeeServiceStub stub = new FeeServiceStub();
		QueryBillDetailByBillId queryBillDetailByBillId = new QueryBillDetailByBillId();
		queryBillDetailByBillId.setParam0(1L);
		OMElement element = stub.toOM(queryBillDetailByBillId, true);

		// 发送并接收消息
		OMElement response1 = sc.sendReceive(element);
		RetAcmBillDetailList result = QueryBillDetailByBillIdResponse.Factory
				.parse(response1.getXMLStreamReaderWithoutCaching())
				.get_return();
		// 转换日期类型
		if (result.getErrorCode() == 0) {
			System.out.println("*** 查询帐单相关接入明细列表成功（10条记录） ***");
			System.out.printf("%-10s %-20s %-20s %-10s "
					+ "%-20s %-10s %-20s %-20s %-10s %-20s", "序号", "计费开始时间",
					"计费结束时间", "计费时长", "流入字节数", "流出字节数", "费用", "奖励金额", "使用奖励",
					"计费会话标识");
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
				System.out.println("*** 未找到符合条件的记录 ***");
			}
		} else {
			System.out.println("*** 查询帐单相关接入明细列表失败 ***");
			System.out
					.println("查询帐单相关接入明细 ErrorCode: " + result.getErrorCode());
			System.out.println("查询帐单相关接入明细 ErrorMsg: " + result.getErrorMsg());
		}
		System.out.println();
		return result;
	}

	/**
	 * 为用户缴费。
	 *
	 * @param feeEndpointStr Fee WebService location
	 * @param sc 客户端
	 * @throws Exception 异常
	 */
	public static void pay(String feeEndpointStr, ServiceClient sc)
			throws Exception {

		System.out.println("=============== 为接入用户缴费 =================");
		// 通用选项设置
		setOptions(feeEndpointStr, sc, "urn:pay");

		// 测试桩
		FeeServiceStub stub = new FeeServiceStub();

		// 设置缴费参数
		PaymentInfo paymentInfo = new PaymentInfo();
		paymentInfo.setUserName(accountName);
		paymentInfo.setAmount("800");

		// 封装参数
		Pay pay = new Pay();
		pay.setParam0(paymentInfo);

		// 创建请求报文
		OMElement element = stub.toOM(pay, true);
		// 发送请求报文并接收响应结果
		OMElement response = sc.sendReceive(element);
		com.h3c.imc.acmws.acmuserservice.client.FeeServiceStub.WSCommonResult result = PayResponse.Factory
				.parse(response.getXMLStreamReaderWithoutCaching())
				.get_return();

		// 缴费成功
		if (result.getErrorCode() == 0) {
			System.out.println("*** 为接入用户“" + accountName + "”缴费800元成功。***\n");
		}
		// 缴费失败
		else {
			System.out.println("*** 为接入用户“" + accountName + "”缴费800元失败。***\n");
			System.out.println("错误码: " + result.getErrorCode());
			System.out.println("错误信息: " + result.getErrorMsg() + "\n");
		}

	}

	/**
	 * 查询用户余额。
	 *
	 * @param feeEndpointStr Fee WebService location
	 * @param sc 客户端
	 * @throws Exception 异常
	 */
	public static void queryBalance(String feeEndpointStr, ServiceClient sc)
			throws Exception {

		System.out.println("=============== 查询余额 =================");

		// 通用选项设置
		setOptions(feeEndpointStr, sc, "urn:queryBalance");

		// 测试桩
		FeeServiceStub stub = new FeeServiceStub();

		// 设置查询参数
		QueryBalance queryBalance = new QueryBalance();
		queryBalance.setParam0(accountName);

		// 创建请求报文
		OMElement element = stub.toOM(queryBalance, true);
		// 发送请求报文并接收响应结果
		OMElement response = sc.sendReceive(element);
		RetUserBalance userBalance = QueryBalanceResponse.Factory.parse(
				response.getXMLStreamReaderWithoutCaching()).get_return();

		// 查询成功
		if (userBalance.getErrorCode() == 0) {
			System.out.println("*** 查询用户“" + accountName + "”的余额成功。***");
			System.out.println("余额: " + userBalance.getBalance() + " 元\n");
		}
		// 查询失败
		else {
			System.out.println("*** 查询用户“" + accountName + "”的余额失败。***\n");
			System.out.println("错误码: " + userBalance.getErrorCode());
			System.out.println("错误信息: " + userBalance.getErrorMsg() + "\n");
		}
	}

	/**
	 * 单条定制查询。
	 *
	 * @param queryEndpointStr Fee WebService location
	 * @param acmEndpointStr AcmUser WebService location
	 * @param sc 客户端
	 * @throws Exception 异常
	 */
	public static void singleQuery(String queryEndpointStr,
			String acmEndpointStr, ServiceClient sc) throws Exception {

		// 查询服务列表
		RetAcmServiceTemplateInfoList retServiceList = queryServiceTemplateList(
				acmEndpointStr, sc);

		System.out
				.println("=============== 单条定制查询-服务详细信息(acm_service_template.xml) =================");

		// 查询失败
		if (retServiceList.getErrorCode() != 0) {
			System.out.println("*** 查询服务失败。***");
			System.out.println("错误码: " + retServiceList.getErrorCode());
			System.out.println("错误信息: " + retServiceList.getErrorMsg() + "\n");
			return;
		}

		RetAcmServiceTemplateInfo[] services = retServiceList
				.getRetAcmServiceTemplateInfoList();
		// 没有服务
		if (services == null || services.length == 0) {
			System.out.println("*** 查询服务失败，系统中不存在任何服务。***\n");
			return;
		}

		// 通用选项设置
		setOptions(queryEndpointStr, sc, "urn:singleQuery");

		// 测试桩
		CustomQueryServiceStub stub = new CustomQueryServiceStub();

		// 设置查询参数
		QueryActionInfo qai = new QueryActionInfo();
		qai.setCommand("acm_service_template");

		String[] paramNames = new String[] { "serviceTemplateName" };
		String[] paramValues = new String[] { services[0].getServiceName() };

		qai.setParaNames(paramNames);
		qai.setParaValues(paramValues);

		SingleQuery singleQuery = new SingleQuery();
		singleQuery.setParam0(qai);
		OMElement element = stub.toOM(singleQuery, true);

		// 发送并接收消息
		OMElement response1 = sc.sendReceive(element);
		RetSingleResult result = SingleQueryResponse.Factory.parse(
				response1.getXMLStreamReaderWithoutCaching()).get_return();

		String resultInfo = new StringBuilder("错误码: ").append(
				result.getErrorCode()).append("\n错误信息: ").append(
				result.getErrorMsg()).append("\n查询列数: ").append(
				result.getColumnCount()).append("\n查询列名: ").append(
				ArrayUtils.toString(result.getColumnNames())).append(
				"\n查询列类型: ").append(
				ArrayUtils.toString(result.getColumnTypes())).append("\n结果集: ")
				.append(ArrayUtils.toString(result.getResultValues()))
				.toString();

		System.out.println(resultInfo + "\n");
	}

	/**
	 * 多条定制查询。
	 *
	 * @param queryEndpointStr Fee WebService location
	 * @param imcUserEndporintStr iMC User WebService location
	 * @param sc 客户端
	 * @throws Exception 异常
	 */
	public static void multiQuery(String queryEndpointStr,
			String imcUserEndporintStr, ServiceClient sc) throws Exception {

		System.out
				.println("=============== 多条定制查询-用户日志(uam_user_log.xml) =================");

		// 查询所有用户分组
		WSUserGroupArray userGroups = queryAllUserGroup(imcUserEndporintStr, sc);

		// 查询失败
		if (userGroups.getErrorCode() != 0) {
			System.out.println("*** 查询用户分组失败。***");
			System.out.println("错误码: " + userGroups.getErrorCode());
			System.out.println("错误信息: " + userGroups.getErrorMsg() + "\n");
			return;
		}

		// 至少存在一个“未分组”
		StringBuilder userGroupIds = new StringBuilder("");
		for (UserGroup userGroup : userGroups.getUserGroupArray()) {
			userGroupIds.append(userGroup.getId()).append(",");
		}

		// 通用选项设置
		setOptions(queryEndpointStr, sc, "urn:multiQuery");

		// 测试桩
		CustomQueryServiceStub stub = new CustomQueryServiceStub();

		// 设置查询参数
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

		// 发送并接收消息
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
		String resultInfo = new StringBuilder("错误码: ").append(
				result.getErrorCode()).append("\n错误信息: ").append(
				result.getErrorMsg()).append("\n总记录数: ").append(
				String.valueOf(result.getTotalRecordCount())).append(
				"\n符合条件的记录数: ").append(String.valueOf(result.getRecordCount()))
				.append("\n查询列数: ").append(result.getColumnCount()).append(
						"\n查询列名: ").append(
						ArrayUtils.toString(result.getColumnNames())).append(
						"\n查询列类型: ").append(
						ArrayUtils.toString(result.getColumnTypes())).append(
						"\n结果集:\n ").append(resultValues).toString();

		System.out.println(resultInfo);
	}

	/**
	 * 查询所有资产分组。
	 *
	 * @param damEndPointStr WebService location
	 * @param sc 客户端
	 * @throws Exception 异常
	 * @return 所有用户
	 */
	public static WSUserGroupArray queryAllUserGroup(
			String imcUserEndporintStr, ServiceClient sc) throws Exception {
		// 调用查询所有用户分组接口
		setOptions(imcUserEndporintStr, sc, "urn:queryAllUserGroup");

		// 发送后接收响应报文
		OMElement response = sc.sendReceive(null);
		// 解析响应报文
		WSUserGroupArray userGroups = QueryAllUserGroupResponse.Factory.parse(
				response.getXMLStreamReaderWithoutCaching()).get_return();

		return userGroups;
	}

	/**
	 * 查询符合条件的资产。
	 *
	 * @param damEndPointStr WebService location
	 * @param sc 客户端
	 * @param queryInfo 查询条件
	 * @throws Exception 异常
	 * @return 符合条件的资产
	 */
	public static RetAssetInfoList queryAssets(String damEndPointStr,
			ServiceClient sc, AssetQueryInfo queryInfo) throws Exception {
		// 调用查询所有资产分组接口
		setOptions(damEndPointStr, sc, "urn:queryAsset");

		DamAssetServiceStub stub = new DamAssetServiceStub();
		QueryAsset queryAsset = new QueryAsset();

		// 设置查询条件
		queryAsset.setParam0(queryInfo);
		// 构造请求报文
		OMElement element = stub.toOM(queryAsset, true);

		// 发送后接收响应报文
		OMElement response = sc.sendReceive(element);
		// 解析响应报文
		RetAssetInfoList assets = QueryAssetResponse.Factory.parse(
				response.getXMLStreamReaderWithoutCaching()).get_return();

		return assets;
	}

	/**
	 * 根据资产标识查询资产详细信息。
	 *
	 * @param damEndPointStr WebService location
	 * @param sc 客户端
	 * @param assetId 资产标识
	 * @throws Exception 异常
	 * @return 资产详细信息
	 */
	public static RetAssetDetailInfo queryAssetDetail(String damEndPointStr,
			ServiceClient sc, Long assetId) throws Exception {
		// 调用查询资产详细信息接口
		setOptions(damEndPointStr, sc, "urn:queryAssetDetail");

		DamAssetServiceStub stub = new DamAssetServiceStub();
		QueryAssetDetail queryAssetDetail = new QueryAssetDetail();

		// 设置查询条件
		queryAssetDetail.setParam0(assetId);
		// 构造请求报文
		OMElement element = stub.toOM(queryAssetDetail, true);

		// 发送后接收响应报文
		OMElement response = sc.sendReceive(element);
		// 解析响应报文
		RetAssetDetailInfo assetDetail = QueryAssetDetailResponse.Factory
				.parse(response.getXMLStreamReaderWithoutCaching())
				.get_return();

		return assetDetail;
	}

	/**
	 * 查询所有用户。
	 *
	 * @param imcPlatUserEndpointStr WebService location
	 * @param sc 客户端
	 * @throws Exception 异常
	 * @return 所有用户
	 */
	public static WSUserArray queryAllUser(String imcPlatUserEndpointStr,
			ServiceClient sc) throws Exception {
		// 调用查询所有用户接口
		setOptions(imcPlatUserEndpointStr, sc, "urn:queryAllUser");

		ImcplatUserServiceStub stub = new ImcplatUserServiceStub();
		QueryAllUser query = new QueryAllUser();

		// 设置查询用户id集，一个正整数即查询所有用户
		query.setParam0(new long[] { 0 });
		// 构造请求报文
		OMElement element = stub.toOM(query, true);

		// 发送后接收响应报文
		OMElement response = sc.sendReceive(element);
		// 解析响应报文
		ImcplatUserServiceStub.WSUserArray users = QueryAllUserResponse.Factory
				.parse(response.getXMLStreamReaderWithoutCaching())
				.get_return();

		return users;
	}

	/**
	 * 查询所有资产分组。
	 *
	 * @param damEndPointStr WebService location
	 * @param sc 客户端
	 * @throws Exception 异常
	 * @return 所有用户
	 */
	public static RetAssetGroupInfoList queryAllAssetGroup(
			String damEndPointStr, ServiceClient sc) throws Exception {
		// 调用查询所有资产分组接口
		setOptions(damEndPointStr, sc, "urn:queryAssetGroup");

		// 发送后接收响应报文
		OMElement response = sc.sendReceive(null);
		// 解析响应报文
		RetAssetGroupInfoList assetGroup = QueryAssetGroupResponse.Factory
				.parse(response.getXMLStreamReaderWithoutCaching())
				.get_return();

		return assetGroup;
	}

	/**
	 * 增加资产。
	 *
	 * @param damEndpointStr DAM WebService location
	 * @param imcPlatEndpointStr iMC plat WebService location
	 * @param imcPlatUserEndpointStr iMC plat user WebService location
	 * @param sc 客户端
	 * @throws Exception 异常
	 */
	public static void addAsset(String damEndpointStr,
			String imcPlatEndpointStr, String imcPlatUserEndpointStr,
			ServiceClient sc) throws Exception {

		System.out.println("=============== 增加资产 =================");
		// 查询所有用户
		WSUserArray users = queryAllUser(imcPlatUserEndpointStr, sc);
		// 查询失败
		if (users.getErrorCode() != 0) {
			System.out.println("*** 查询用户失败。***");
			System.out.println("错误码: " + users.getErrorCode());
			System.out.println("错误信息: " + users.getErrorMsg() + "\n");

			// 注销系统并结束程序
			logout(imcPlatEndpointStr, sc);
			System.exit(0);
		}

		// 没有用户
		if (users.getUserArray() == null || users.getUserArray().length == 0) {
			System.out.println("*** 增加资产失败，系统中不存在任何用户。***\n");

			// 注销系统并结束程序
			logout(imcPlatEndpointStr, sc);
			System.exit(0);
		}

		// 查询所有资产分组
		RetAssetGroupInfoList assetGroup = queryAllAssetGroup(damEndpointStr,
				sc);
		// 查询失败
		if (assetGroup.getErrorCode() != 0) {
			System.out.println("*** 查询资产分组失败。***");
			System.out.println("错误码: " + assetGroup.getErrorCode());
			System.out.println("错误信息: " + assetGroup.getErrorMsg() + "\n");

			// 注销系统并结束程序
			logout(imcPlatEndpointStr, sc);
			System.exit(0);
		}

		RetAssetGroupInfo[] assetInfo = assetGroup.getRetAssetGroupInfoList();
		// 没有分组
		if (assetInfo == null || assetInfo.length == 0) {
			System.out.println("*** 增加资产失败，系统中不存在任何资产分组。***\n");

			// 注销系统并结束程序
			logout(imcPlatEndpointStr, sc);
			System.exit(0);
		}

		// 增加资产参数对象
		AddAssetInfo asset = new AddAssetInfo();

		// 产生随机数作为资产编号
		String assetNumber = String
				.valueOf(new Random().nextInt(999999999) + 1);
		asset.setAssetNumber(assetNumber);

		// 取第一个用户作为责任人
		asset.setResponserId(users.getUserArray()[0].getId());
		// 分组标识
		asset.setGroupId(assetInfo[0].getGroupId());
		// 计算机类型(pc/laptop/server/workstation/other)
		asset.setComputerType("workstation");
		// 物理位置
		asset.setPhysicalPos("北京东方电子大厦");
		// 资产名称
		asset.setAssetName("H3C-IX5000存储设备");
		// 计算机品牌
		asset.setComputerVariety("H3C");
		// 型号
		asset.setType("IX5000");
		// 备注
		asset.setRemark("灾备恢复生产中心");

		// 调用增加资产接口
		setOptions(damEndpointStr, sc, "urn:addAsset");

		DamAssetServiceStub stub = new DamAssetServiceStub();
		AddAsset addAsset = new AddAsset();

		// 设置增加的资产
		addAsset.setParam0(asset);
		// 构造请求报文
		OMElement element = stub.toOM(addAsset, true);

		// 发送后接收响应报文
		OMElement response = sc.sendReceive(element);
		// 解析响应报文
		com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.WSCommonResult result = AddAssetResponse.Factory
				.parse(response.getXMLStreamReaderWithoutCaching())
				.get_return();

		// 增加资产失败
		if (result.getErrorCode() != 0) {
			System.out.println("*** 增加资产失败。***");
			System.out.println("错误码: " + result.getErrorCode());
			System.out.println("错误信息: " + result.getErrorMsg() + "\n");

			// 注销系统并结束程序
			logout(imcPlatEndpointStr, sc);
			System.exit(0);
		}
		// 增加资产成功
		else {
			// 保存资产编号
			assetNo = assetNumber;

			System.out.println("*** 增加编号为“" + assetNo + "”的资产成功。***\n");

			System.out.println("查询编号为“" + assetNo + "”的资产...");

			// 根据资产编号查询新增加的资产
			AssetQueryInfo queryInfo = new AssetQueryInfo();
			queryInfo.setAssetNumber(assetNo);

			RetAssetInfoList assets = queryAssets(damEndpointStr, sc, queryInfo);

			// 查询资产失败
			if (assets.getErrorCode() != 0) {
				System.out.println("*** 查询编号为“" + assetNo + "”的资产失败。***");
				System.out.println("错误码: " + assets.getErrorCode());
				System.out.println("错误信息: " + assets.getErrorMsg() + "\n");

				// 注销系统并结束程序
				logout(imcPlatEndpointStr, sc);
				System.exit(0);
			}

			// 资产不存在
			if (assets.getRetAssetList() == null
					|| assets.getRetAssetList().length == 0) {
				System.out.println("编号为“" + assetNo + "”的资产已不存在。\n");

				// 注销系统并结束程序
				logout(imcPlatEndpointStr, sc);
				System.exit(0);
			}

			// 获取新增加的资产
			RetAssetInfo addedAsset = assets.getRetAssetList()[0];
			// 查询资产详细信息
			RetAssetDetailInfo assetDetail = queryAssetDetail(damEndpointStr,
					sc, addedAsset.getAssetId());

			// 查询失败
			if (assetDetail.getErrorCode() != 0) {
				System.out.println("*** 查询编号为“" + assetNo + "”的资产详细信息失败。***");
				System.out.println("错误码: " + assetDetail.getErrorCode());
				System.out.println("错误信息: " + assetDetail.getErrorMsg() + "\n");

				// 注销系统并结束程序
				logout(imcPlatEndpointStr, sc);
				System.exit(0);
			}

			System.out.println("资产标识: " + addedAsset.getAssetId());
			System.out.println("资产编号: " + assetNo);
			System.out.println("资产名称: " + assetDetail.getAssetName());
			System.out.println("分组名称: " + assetDetail.getGroupName());
			System.out.println("责任人: " + assetDetail.getResponserName());
			System.out.println("计算机类型: " + assetDetail.getComputerType());
			System.out.println("型号: " + assetDetail.getType());
			System.out.println("物理位置: " + assetDetail.getPhysicalPos());
			System.out.println("备注: " + assetDetail.getRemark() + "\n");
		}
	}

	/**
	 * 修改资产。
	 *
	 * @param damEndpointStr DAM WebService location
	 * @param imcPlatEndpointStr iMC plat WebService location
	 * @param imcPlatUserEndpointStr iMC plat user WebService location
	 * @param sc 客户端
	 * @throws Exception 异常
	 */
	public static void modifyAsset(String damEndpointStr,
			String imcPlatEndpointStr, String imcPlatUserEndpointStr,
			ServiceClient sc) throws Exception {

		System.out.println("=============== 修改资产 =================");
		// 根据资产编号查询预修改的资产
		AssetQueryInfo queryInfo = new AssetQueryInfo();
		queryInfo.setAssetNumber(assetNo);

		RetAssetInfoList assets = queryAssets(damEndpointStr, sc, queryInfo);

		// 查询资产失败
		if (assets.getErrorCode() != 0) {
			System.out.println("*** 查询编号为“" + assetNo + "”的资产失败。***");
			System.out.println("错误码: " + assets.getErrorCode());
			System.out.println("错误信息: " + assets.getErrorMsg() + "\n");
			return;
		}

		// 资产不存在
		if (assets.getRetAssetList() == null
				|| assets.getRetAssetList().length == 0) {
			System.out.println("*** 修改资产失败，编号为“" + assetNo + "”的资产已不存在。***\n");
			return;
		}

		// 获取预修改的资产
		RetAssetInfo preModifyAsset = assets.getRetAssetList()[0];
		// 查询资产详细信息
		RetAssetDetailInfo assetDetail = queryAssetDetail(damEndpointStr, sc,
				preModifyAsset.getAssetId());

		// 查询失败
		if (assetDetail.getErrorCode() != 0) {
			System.out.println("*** 查询编号为“" + assetNo + "”的资产详细信息失败。***");
			System.out.println("错误码: " + assetDetail.getErrorCode());
			System.out.println("错误信息: " + assetDetail.getErrorMsg() + "\n");
			return;
		}

		System.out.println("选中资产...");
		System.out.println("资产标识: " + preModifyAsset.getAssetId());
		System.out.println("资产编号: " + assetNo);
		System.out.println("资产名称: " + assetDetail.getAssetName());
		System.out.println("分组名称: " + assetDetail.getGroupName());
		System.out.println("责任人: " + assetDetail.getResponserName());
		System.out.println("计算机类型: " + assetDetail.getComputerType());
		System.out.println("型号: " + assetDetail.getType());
		System.out.println("物理位置: " + assetDetail.getPhysicalPos());
		System.out.println("备注: " + assetDetail.getRemark() + "\n");

		// 修改资产参数对象
		ModifyAssetInfo asset = new ModifyAssetInfo();

		// 资产id
		asset.setAssetId(preModifyAsset.getAssetId());

		// 查询所有用户
		WSUserArray users = queryAllUser(imcPlatUserEndpointStr, sc);

		// 查询成功且有其他用户可做为修改对象
		if (users.getErrorCode() == 0 && users.getUserArray() != null
				&& users.getUserArray().length > 0) {

			int lastIndex = users.getUserArray().length - 1;
			// 取最后一个用户作为修改的责任人
			asset.setResponserId(users.getUserArray()[lastIndex].getId());
		}

		// 不修改资产编号
		asset.setAssetNumber(assetNo);
		// 计算机类型(pc/laptop/server/workstation/other)
		asset.setComputerType("server");
		// 物理位置
		asset.setPhysicalPos("国际软件大厦A座");
		// 资产名称
		asset.setAssetName("Oracle数据库服务器");
		// 计算机品牌
		asset.setComputerVariety("lenovo");
		// 型号
		asset.setType("PC8560");
		// 备注
		asset.setRemark("业务软件研发");

		// 调用修改资产接口
		setOptions(damEndpointStr, sc, "urn:modifyAsset");

		DamAssetServiceStub stub = new DamAssetServiceStub();
		ModifyAsset modifyAsset = new ModifyAsset();

		// 设置修改的资产
		modifyAsset.setParam0(asset);
		// 构造请求报文
		OMElement element = stub.toOM(modifyAsset, true);

		// 发送后接收响应报文
		OMElement response = sc.sendReceive(element);
		// 解析响应报文
		com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.WSCommonResult result = ModifyAssetResponse.Factory
				.parse(response.getXMLStreamReaderWithoutCaching())
				.get_return();

		// 修改资产失败
		if (result.getErrorCode() != 0) {
			System.out.println("*** 修改编号为“" + assetNo + "”的资产失败。***");
			System.out.println("错误码: " + result.getErrorCode());
			System.out.println("错误信息: " + result.getErrorMsg() + "\n");
		}
		// 修改资产成功
		else {
			System.out.println("*** 修改编号为“" + assetNo + "”的资产成功。***\n");

			// 查询资产详细信息
			assetDetail = queryAssetDetail(damEndpointStr, sc, preModifyAsset
					.getAssetId());

			// 重新查询失败
			if (assetDetail.getErrorCode() != 0) {
				System.out.println("*** 重新查询编号为“" + assetNo + "”的资产详细信息失败。***");
				System.out.println("错误码: " + assetDetail.getErrorCode());
				System.out.println("错误信息: " + assetDetail.getErrorMsg() + "\n");
				return;
			}

			System.out.println("查询编号为“" + assetNo + "”的资产...");
			System.out.println("资产标识: " + preModifyAsset.getAssetId());
			System.out.println("资产编号: " + assetNo);
			System.out.println("资产名称: " + assetDetail.getAssetName());
			System.out.println("分组名称: " + assetDetail.getGroupName());
			System.out.println("责任人: " + assetDetail.getResponserName());
			System.out.println("计算机类型: " + assetDetail.getComputerType());
			System.out.println("型号: " + assetDetail.getType());
			System.out.println("物理位置: " + assetDetail.getPhysicalPos());
			System.out.println("备注: " + assetDetail.getRemark() + "\n");
		}
	}

	/**
	 * 删除资产。
	 *
	 * @param damEndpointStr DAM WebService location
	 * @param imcPlatUserEndpointStr iMC plat user WebService location
	 * @param sc 客户端
	 * @throws Exception 异常
	 */
	public static void deleteAsset(String damEndpointStr,
			String imcPlatUserEndpointStr, ServiceClient sc) throws Exception {

		System.out.println("=============== 删除资产 =================");
		// 根据资产编号查询预删除的资产
		AssetQueryInfo queryInfo = new AssetQueryInfo();
		queryInfo.setAssetNumber(assetNo);

		RetAssetInfoList assets = queryAssets(damEndpointStr, sc, queryInfo);

		// 查询资产失败
		if (assets.getErrorCode() != 0) {
			System.out.println("*** 查询编号为“" + assetNo + "”的资产失败。***");
			System.out.println("错误码: " + assets.getErrorCode());
			System.out.println("错误信息: " + assets.getErrorMsg());
			return;
		}

		// 资产不存在
		if (assets.getRetAssetList() == null
				|| assets.getRetAssetList().length == 0) {
			System.out.println("*** 删除资产失败，编号为“" + assetNo + "”的资产已不存在。***\n");
			return;
		}

		// 获取预删除的资产
		RetAssetInfo preDeleteAsset = assets.getRetAssetList()[0];
		// 查询资产详细信息
		RetAssetDetailInfo assetDetail = queryAssetDetail(damEndpointStr, sc,
				preDeleteAsset.getAssetId());

		// 查询失败
		if (assetDetail.getErrorCode() != 0) {
			System.out.println("*** 查询编号为“" + assetNo + "”的资产详细信息失败。***");
			System.out.println("错误码: " + assetDetail.getErrorCode());
			System.out.println("错误信息: " + assetDetail.getErrorMsg() + "\n");
			return;
		}

		System.out.println("选中资产...");
		System.out.println("资产标识: " + preDeleteAsset.getAssetId());
		System.out.println("资产编号: " + assetNo);
		System.out.println("资产名称: " + assetDetail.getAssetName());
		System.out.println("分组名称: " + assetDetail.getGroupName());
		System.out.println("责任人: " + assetDetail.getResponserName());
		System.out.println("计算机类型: " + assetDetail.getComputerType());
		System.out.println("型号: " + assetDetail.getType());
		System.out.println("物理位置: " + assetDetail.getPhysicalPos());
		System.out.println("备注: " + assetDetail.getRemark() + "\n");

		// 调用删除资产接口
		setOptions(damEndpointStr, sc, "urn:deleteAsset");

		DamAssetServiceStub stub = new DamAssetServiceStub();
		DeleteAsset deleteAsset = new DeleteAsset();

		// 设置要删除的资产id
		deleteAsset.setParam0(preDeleteAsset.getAssetId());
		// 构造请求报文
		OMElement element = stub.toOM(deleteAsset, true);

		// 发送后接收响应报文
		OMElement response = sc.sendReceive(element);
		// 解析响应报文
		com.h3c.imc.acmws.acmuserservice.client.DamAssetServiceStub.WSCommonResult result = DeleteAssetResponse.Factory
				.parse(response.getXMLStreamReaderWithoutCaching())
				.get_return();

		// 删除资产失败
		if (result.getErrorCode() != 0) {
			System.out.println("*** 删除编号为“" + assetNo + "”的资产失败。***");
			System.out.println("错误码: " + result.getErrorCode());
			System.out.println("错误信息: " + result.getErrorMsg() + "\n");
		}
		// 删除资产成功
		else {
			System.out.println("*** 删除编号为“" + assetNo + "”的资产成功。***\n");

			// 查询资产详细信息
			assetDetail = queryAssetDetail(damEndpointStr, sc, preDeleteAsset
					.getAssetId());

			System.out.println("查询编号为“" + assetNo + "”的资产...");
			if (assetDetail.getErrorCode() == 62407) {
				System.out.println("编号为“" + assetNo + "”的资产已不存在。\n");
			} else {
				System.out.println("*** 查询编号为“" + assetNo + "”的资产详细信息失败。***");
				System.out.println("错误码: " + assetDetail.getErrorCode());
				System.out.println("错误信息: " + assetDetail.getErrorMsg() + "\n");
			}
		}
	}

	/**
	 * 查询前15条资产。
	 *
	 * @param damEndpointStr DAM WebService location
	 * @param sc 客户端
	 * @throws Exception 异常
	 */
	public static void queryFirstPageAssets(String damEndpointStr,
			ServiceClient sc) throws Exception {

		System.out.println("=============== 查询资产 =================");
		// 按加入时间降序排列
		AssetQueryInfo queryInfo = new AssetQueryInfo();
		queryInfo.setResultSortType(7);
		queryInfo.setResultSort(1);

		RetAssetInfoList assets = queryAssets(damEndpointStr, sc, queryInfo);

		// 查询失败
		if (assets.getErrorCode() != 0) {
			System.out.println("*** 查询资产失败。***");
			System.out.println("错误码: " + assets.getErrorCode());
			System.out.println("错误信息: " + assets.getErrorMsg() + "\n");
			return;
		}

		RetAssetInfo[] assetList = assets.getRetAssetList();

		// 系统中没有资产
		if (assetList == null || assetList.length == 0) {
			System.out.println("未找到任何记录。");
			System.out.printf("%-10s %-20s %-30s %-20s %-20s %-10s", "状态",
					"资产编号", "资产名称", "责任人", "型号", "加入日期↓");
			System.out.println("\n");
			return;
		}

		int pageCount = assetList.length <= 15 ? 1
				: (assetList.length % 15 == 0 ? assetList.length / 15
						: assetList.length / 15 + 1);
		int firstPageCount = assetList.length >= 15 ? 15 : assetList.length;
		System.out.println("共" + assetList.length + "条记录，当前第1-"
				+ firstPageCount + "，第1/" + pageCount + "页。");
		System.out.printf("%-10s %-20s %-30s %-20s %-20s %-10s", "状态", "资产编号",
				"资产名称", "责任人", "型号", "加入日期↓");
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
	 * 查询所有资产分组。
	 *
	 * @param damEndpointStr DAM WebService location
	 * @param sc 客户端
	 * @throws Exception 异常
	 */
	public static void queryAssetGroups(String damEndpointStr, ServiceClient sc)
			throws Exception {

		System.out.println("============= 查询资产分组 ===============");
		// 查询所有资产分组
		RetAssetGroupInfoList assetGroups = queryAllAssetGroup(damEndpointStr,
				sc);

		// 查询失败
		if (assetGroups.getErrorCode() != 0) {
			System.out.println("*** 查询资产分组失败。***");
			System.out.println("错误码: " + assetGroups.getErrorCode());
			System.out.println("错误信息: " + assetGroups.getErrorMsg() + "\n");
			return;
		}

		RetAssetGroupInfo[] assetGroupList = assetGroups
				.getRetAssetGroupInfoList();

		// 系统中没有资产分组
		if (assetGroupList == null || assetGroupList.length == 0) {
			System.out.println("未找到任何记录。");
			System.out.printf("%-30s %-100s", "分组名称↑", "分组描述");
			System.out.println("\n");
			return;
		}

		System.out.println("共" + assetGroupList.length + "条记录");
		System.out.printf("%-30s %-100s", "分组名称↑", "分组描述");
		System.out.println();

		for (RetAssetGroupInfo assetGroup : assetGroupList) {
			System.out.printf("%-30s %-100s", assetGroup.getGroupName(),
					convertNull(assetGroup.getGroupDescription()));
			System.out.println();
		}

		System.out.println();
	}

	/**
	 * 通用选项设置。
	 *
	 * @param endPointStr 访问的WebService URL
	 * @param sc 测试客户端
	 * @param urn 调用接口方法统一资源名称
	 * @throws FileNotFoundException 文件不存在异常
	 * @throws XMLStreamException XML操作异常
	 * @throws AxisFault Axis错误
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
	 * 登录系统。
	 *
	 * @param imcPlatEndPointStr WebService location
	 * @param sc 客户端
	 * @throws Exception 异常
	 */
	public static void login(String imcPlatEndPointStr, ServiceClient sc)
			throws Exception {
		// 调用登录接口
		setOptions(imcPlatEndPointStr, sc, "urn:login");

		ImcplatServiceStub stub = new ImcplatServiceStub();
		// 设置登录操作员名称和密码
		Login login = new Login();
		login.setParam0("admin");
		login.setParam1("admin");
		// 构造请求报文
		OMElement element = stub.toOM(login, true);

		// 发送后接收响应报文
		OMElement response = sc.sendReceive(element);
		// 解析响应报文
		ImcplatServiceStub.WSCommonResult result = LoginResponse.Factory.parse(
				response.getXMLStreamReaderWithoutCaching()).get_return();

		System.out.println("=============== 登录系统 =================");
		// 登录失败
		if (result.getErrorCode() != 0) {
			System.out.println("*** 操作员“admin”登录失败。***");
			System.out.println("错误码: " + result.getErrorCode());
			System.out.println("错误信息: " + result.getErrorMsg());
		}
		// 登录成功
		else {
			System.out.println("*** 操作员“admin”登录成功。***\n");
		}
	}

	/**
	 * 根据接入用户名称获取接入用户
	 *
	 * @param acmEndpointStr acm service
	 * @param sc client
	 * @return 接入用户
	 * @throws Exception 抛出异常
	 */
	public static RetAcmUser queryAcmUser(String acmEndpointStr,
			ServiceClient sc) throws Exception {
		System.out.println("=============== 查询接入用户 =================");
		setOptions(acmEndpointStr, sc, "urn:queryAcmUser");

		// 设置绑定用户
		AcmUserServiceStub stub = new AcmUserServiceStub();

		// 设置输入参数
		QueryAcmUser user = new QueryAcmUser();
		user.setParam0(accountName);

		OMElement element = stub.toOM(user, true);

		// 发送并接收消息
		OMElement response1 = sc.sendReceive(element);
		RetAcmUser acmUser = QueryAcmUserResponse.Factory.parse(
				response1.getXMLStreamReaderWithoutCaching()).get_return();

		if (acmUser.getErrorCode() != 0) {
			System.out.println("*** 查询接入用户失败。***");
			System.out.println("错误码: " + acmUser.getErrorCode());
			System.out.println("错误信息: " + acmUser.getErrorMsg() + "\n");
		} else {
			System.out.println("*** 查询接入用户“" + accountName + "成功”。***\n");
			// 设置接入用户ID
			userId = acmUser.getAcmUser().getAcmUserId();

		}

		return acmUser;
	}

	/**
	 * 查询接入用户
	 *
	 * @param endPointStr 访问的WebService URL
	 * @param sc 测试客户端
	 * @return 接入用户列表
	 * @throws Exception 抛出异常
	 */
	private static RetAcmUserList queryAccessUserArray(String endPointStr,
			ServiceClient sc) throws Exception {
		System.out.println("=============== 查询接入用户列表 ===============");
		// 执行查询接入用户操作
		setOptions(endPointStr, sc, "urn:queryAcmUserList");

		// 设置查询接入用户列表参数
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

		// 发送并接收消息
		OMElement response1 = sc.sendReceive(element);
		RetAcmUserList result = QueryAcmUserListResponse.Factory.parse(
				response1.getXMLStreamReaderWithoutCaching()).get_return();
		// 转换日期类型
		if (result.getErrorCode() == 0) {
			System.out.println("*** 查询接入用户列表成功（10条记录） ***");
			System.out.printf("%-10s %-10s %-20s %-25s %-20s %-30s", "序号",
					"帐号ID", "帐号名", "用户姓名", "用户分组ID", "失效日期");
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
				System.out.println("*** 未找到符合条件的记录 ***");
			}
		} else {
			System.out.println("*** 查询接入用户列表失败 ***");
			System.out.println("查询接入用户列表 ErrorCode: " + result.getErrorCode());
			System.out.println("查询接入用户列表 ErrorMsg: " + result.getErrorMsg());
		}
		System.out.println();
		return result;
	}

	/**
	 * 增加接入用户
	 *
	 * @param imcUserEndporintStr 平台服务url
	 * @param acmEndpointStr acm url
	 * @param sc client
	 * @throws Exception exception
	 */
	public static void addAcmUser(String imcUserEndporintStr,
			String acmEndpointStr, ServiceClient sc) throws Exception {

		System.out.println("============= 增加接入用户 =================");
		// 增加平台用户
		setOptions(imcUserEndporintStr, sc, "urn:addUser");

		// 设置用户分组为 未分组
		long userGroupId = GROUP_ID;

		WSUser platUser = addPlatUser(imcUserEndporintStr, userGroupId, sc);
		// 增加用户失败
		if (platUser == null) {
			System.out.println("*** 增加接入用户失败，增加平台用户失败。***");
			return;
		}
		// 查询用户失败
		if (platUser.getErrorCode() != 0) {
			System.out.println("*** 增加接入用户失败，查询平台用户失败。***");
			System.out.println("错误码: " + platUser.getErrorCode());
			System.out.println("错误信息: " + platUser.getErrorMsg() + "\n");
			return;
		}
		User user = platUser.getUser();
		if (null == user) {
			System.out.println("*** 增加接入用户失败，系统不存在对应平台用户信息。***");
			return;
		}
		// 根据增加用户获取该用户userId
		platUserId = user.getId();

		// 调用对应接口，增加接入用户
		setOptions(acmEndpointStr, sc, "urn:addAcmUser");

		// 增加接入用户
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
		param.setWlanSsid("【add user】_wlan ssid.");
		param.setComputerName("_add_user-_computer%name.");
		param.setBoundDomainName("【add user】_bound domain name.");
		param.setLogonDomainName("【add user】_logon domain name.");
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
		// 帐号类型和开户预付金额
		param.setFeeType(String.valueOf(3));
		param.setOpenPayAmount(String.valueOf(500));


		AddAcmUser addAcmUser = new AddAcmUser();
		addAcmUser.setParam0(param);

		OMElement addAcmUserResp = sc.sendReceive(stub.toOM(addAcmUser, true));
		WSCommonResult result = AddAcmUserResponse.Factory.parse(
				addAcmUserResp.getXMLStreamReaderWithoutCaching()).get_return();

		if (result.getErrorCode() != 0) {
			System.out.println("*** 增加接入用户失败。***");
			System.out.println("错误码: " + result.getErrorCode());
			System.out.println("错误信息: " + result.getErrorMsg() + "\n");
		} else {
			// 保存接入用户名
			accountName = param.getUserName().toLowerCase();

			System.out.println("*** 接入用户“" + accountName + "”增加成功。***\n");
		}
	}

	/**
	 * 修改接入用户
	 *
	 * @param acmEndpointStr acm url
	 * @param sc client
	 * @throws Exception exception
	 */
	public static void modifyAcmUser(String acmEndpointStr, ServiceClient sc)
			throws Exception {

		System.out.println("============= 修改接入用户 =================");
		// 增加接入用户成功
		if (StringUtils.isNotBlank(accountName)) {
			// 查询接入用户
			setOptions(acmEndpointStr, sc, "urn:queryAcmUser");

			AcmUserServiceStub stub = new AcmUserServiceStub();
			QueryAcmUser queryAcmUser = new QueryAcmUser();

			// 设置查询参数
			queryAcmUser.setParam0(accountName);

			// 创建请求报文
			OMElement element = stub.toOM(queryAcmUser, true);
			// 发送请求报文并接收响应结果
			OMElement response = sc.sendReceive(element);
			RetAcmUser acmUser = QueryAcmUserResponse.Factory.parse(
					response.getXMLStreamReaderWithoutCaching()).get_return();

			if (acmUser.getErrorCode() != 0) {
				System.out.println("*** 修改接入用户失败，查询接入用户“" + accountName
						+ "”失败。***");
				System.out.println("错误码: " + acmUser.getErrorCode());
				System.out.println("错误信息: " + acmUser.getErrorMsg() + "\n");
				return;
			}

			// 修改接入用户
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
			acmUserParam.setWlanSsid("【modify user】_wlan ssid.");
			acmUserParam.setComputerName("_modify_user-_computer%name.");
			acmUserParam.setBoundDomainName("【modify user】_bound domain name.");
			acmUserParam.setLogonDomainName("【modify user】_logon domain name.");
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

			// 创建请求报文
			element = stub.toOM(queryAcmUser, true);
			// 发送请求报文并接收响应结果
			response = sc.sendReceive(element);
			WSCommonResult result = ModifyAcmUserResponse.Factory.parse(
					response.getXMLStreamReaderWithoutCaching()).get_return();

			if (result.getErrorCode() != 0) {
				System.out.println("*** 修改接入用户“" + accountName + "”失败。***");
				System.out.println("错误码: " + acmUser.getErrorCode());
				System.out.println("错误信息: " + acmUser.getErrorMsg() + "\n");
			} else {
				System.out.println("*** 修改接入用户“" + accountName + "”成功。***");
			}

		} else {
			System.out.println("*** 修改接入用户失败，请先增加接入用户。 ***");
		}
	}

	/**
	 * 注销接入用户
	 *
	 * @param acmEndpointStr acm Service Url
	 * @param sc client
	 * @throws Exception exception
	 */
	public static void deleteAcmUser(String acmEndpointStr, ServiceClient sc)
			throws Exception {

		System.out.println("============= 注销接入用户 =================");

		setOptions(acmEndpointStr, sc, "urn:cancelAcmUser");

		// 设置绑定用户
		AcmUserServiceStub stub = new AcmUserServiceStub();

		// 设置输入参数
		CancelAcmUser user = new CancelAcmUser();
		user.setParam0(accountName);

		OMElement element = stub.toOM(user, true);

		// 发送并接收消息
		OMElement response1 = sc.sendReceive(element);
		WSCommonResult result = CancelAcmUserResponse.Factory.parse(
				response1.getXMLStreamReaderWithoutCaching()).get_return();

		if (result.getErrorCode() != 0) {
			System.out.println("*** 注销接入用户失败。***");
			System.out.println("错误码: " + result.getErrorCode());
			System.out.println("错误信息: " + result.getErrorMsg() + "\n");
		} else {
			System.out.println("*** 注销接入用户“" + accountName + "成功”。***\n");
		}

	}

	/**
	 * 修改接入用户密码
	 *
	 * @param acmEndpointStr acm Service Url
	 * @param sc client
	 * @throws Exception exception
	 */
	public static void modifyUserPassword(String acmEndpointStr,
			ServiceClient sc) throws Exception {

		System.out.println("============= 修改接入用户密码 =================");

		setOptions(acmEndpointStr, sc, "urn:modifyUserPassword");

		// 设置绑定用户
		AcmUserServiceStub stub = new AcmUserServiceStub();

		// 设置输入参数
		ModifyUserPassword user = new ModifyUserPassword();

		ModifyUserPsdParam param = new ModifyUserPsdParam();
		param.setName(accountName);
		param.setNewPsd("12345");

		user.setParam0(param);

		OMElement element = stub.toOM(user, true);

		// 发送并接收消息
		OMElement response1 = sc.sendReceive(element);
		WSCommonResult result = ModifyAcmUserResponse.Factory.parse(
				response1.getXMLStreamReaderWithoutCaching()).get_return();

		if (result.getErrorCode() != 0) {
			System.out.println("*** 修改接入用户密码失败。***");
			System.out.println("错误码: " + result.getErrorCode());
			System.out.println("错误信息: " + result.getErrorMsg() + "\n");
		} else {
			System.out.println("*** 修改接入用户“" + accountName + "密码成功”。***\n");
		}
	}

	/**
	 * 获取平台用户
	 *
	 * @param imcUserEndporintStr Service Url
	 * @param userGroupId 用户分组ID
	 * @param sc client
	 * @return 平台User
	 * @throws Exception 抛出异常
	 */
	public static WSUser addPlatUser(String imcUserEndporintStr,
			long userGroupId, ServiceClient sc) throws Exception {

		// 平台用户
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

		// 构造请求报文
		OMElement element = stub.toOM(addUser, true);

		// 发送后接收响应报文
		OMElement response = sc.sendReceive(element);

		com.h3c.imc.acmws.platuserservice.client.ImcplatUserServiceStub.WSCommonResult addUserResult = AddUserResponse.Factory
				.parse(response.getXMLStreamReaderWithoutCaching())
				.get_return();
		// 增加失败
		if (0 != addUserResult.getErrorCode()) {

			System.out.println("*** 增加接入用户失败，增加平台用户失败。***");
			System.out.println("错误码: " + addUserResult.getErrorCode());
			System.out.println("错误信息: " + addUserResult.getErrorMsg() + "\n");

			return null;
		} else {
			// 根据名称和标示查询平台用户
			setOptions(imcUserEndporintStr, sc,
					"urn:queryUserByNameAndIdentity");

			QueryUserByNameAndIdentity query = new QueryUserByNameAndIdentity();
			query.setParam0(username);
			query.setParam1(certification);

			// 构造请求报文
			element = stub.toOM(query, true);

			// 发送后接收响应报文
			response = sc.sendReceive(element);
			// 查询对应平台用户
			wsUser = QueryUserByNameAndIdentityResponse.Factory.parse(
					response.getXMLStreamReaderWithoutCaching()).get_return();

			if (wsUser.getErrorCode() != 0) {
				System.out.println("*** 增加接入用户失败，查询平台用户失败。***");
				System.out.println("错误码: " + wsUser.getErrorCode());
				System.out.println("错误信息: " + wsUser.getErrorMsg() + "\n");

				wsUser.setErrorCode(addUserResult.getErrorCode());
				wsUser.setErrorMsg(addUserResult.getErrorMsg());
			}
		}
		return wsUser;
	}

	/**
	 * 查询接入明细列表
	 *
	 * @param endPointStr 访问的WebService URL
	 * @param sc 测试客户端
	 * @return 接入明细列表
	 * @throws Exception 抛出异常
	 */
	private static RetAcmAccessDetailList queryAccessDetail(String endPointStr,
			ServiceClient sc) throws Exception {
		System.out.println("=============== 查询接入明细列表 ===============");
		// 执行增加资产操作
		setOptions(endPointStr, sc, "urn:queryAcmAccessDetailList");

		// 设置查询接入明细列表参数
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

		// 发送并接收消息
		OMElement response = sc.sendReceive(element);
		RetAcmAccessDetailList result = QueryAcmAccessDetailListResponse.Factory
				.parse(response.getXMLStreamReaderWithoutCaching())
				.get_return();
		// 转换日期类型
		if (result.getErrorCode() == 0) {
			System.out.println("*** 查询接入明细列表成功（10条记录） ***");
			System.out
					.printf(
							"%-10s %-10s %-20s %-20s %-25s %-10s %-30s %-10s %-15s %-15s %-15s",
							"序号", "接入明细ID", "帐号名", "用户姓名", "登录名", "服务ID",
							"接入开始时间", "接入时长", "用户IP地址", "流入字节数", "流出字节数");
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
				System.out.println("*** 未找到符合条件的记录 ***");
			}
		} else {
			System.out.println("*** 查询接入明细列表失败 ***");
			System.out.println("查询接入明细列表 ErrorCode: " + result.getErrorCode());
			System.out.println("查询接入明细列表 ErrorMsg: " + result.getErrorMsg());
		}
		System.out.println();
		return result;
	}

	/**
	 * 查询服务模板列表
	 *
	 * @param acmEndpointStr service url
	 * @param sc 客户端
	 * @throws Exception 异常
	 * @return RetAcmServerInfoList 服务模板列表
	 */
	public static RetAcmServiceTemplateInfoList queryServiceTemplateList(
			String acmEndpointStr, ServiceClient sc) throws Exception {

		System.out.println("============= 查询服务模板列表 =================");

		setOptions(acmEndpointStr, sc, "urn:queryServiceTemplateList");

		// 设置插叙
		AcmUserServiceStub stub = new AcmUserServiceStub();

		// 设置输入参数
		QueryServiceTemplateList templateList = new QueryServiceTemplateList();
		templateList.setParam0(new AcmServiceTemplateQueryParam());
		OMElement element = stub.toOM(templateList, true);

		// 发送并接收消息
		OMElement response = sc.sendReceive(element);

		RetAcmServiceTemplateInfoList result = QueryServiceTemplateListResponse.Factory
				.parse(response.getXMLStreamReaderWithoutCaching())
				.get_return();

		// 查询失败
		if (result.getErrorCode() != 0) {
			System.out.println("*** 查询服务模板失败。***");
			System.out.println("错误码: " + result.getErrorCode());
			System.out.println("错误信息: " + result.getErrorMsg() + "\n");
			return result;
		}
		// 查询结果为空
		RetAcmServiceTemplateInfo[] serverInfo = result
				.getRetAcmServiceTemplateInfoList();
		if (serverInfo == null || serverInfo.length == 0) {
			System.out.println("*** 系统中不存在服务模板。***\n");
			return result;
		}

		System.out.println("共" + serverInfo.length + "条记录");
		System.out.printf(
				"%-10s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s",
				" 服务ID", "服务名称", "服务状态", "服务描述", "服务后缀", "分组ID", "安全策略ID",
				"分配IP地址", "服务类型", "计费策略名称");
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
	 * 申请绑定服务。
	 *
	 * @param endPointStr 访问的WebService URL
	 * @param sc 测试客户端
	 * @throws Exception 抛出异常
	 */
	private static void applyService(String endPointStr, ServiceClient sc)
			throws Exception {
		// 调用查询服务模板列表方法，获得服务列表
		RetAcmServiceTemplateInfoList retServiceList = queryServiceTemplateList(
				endPointStr, sc);
		System.out.println("=============== 申请服务 ===============");
		RetAcmServiceTemplateInfo[] retServiceArray = retServiceList
				.getRetAcmServiceTemplateInfoList();
		if (null == retServiceArray || 0 >= retServiceArray.length) {
			System.out.println("*** 申请服务失败--没有可申请服务 ***");
			return;
		}
		// 执行申请服务绑定
		setOptions(endPointStr, sc, "urn:applyService");

		// 设置申请服务参数
		AcmUserServiceStub stub = new AcmUserServiceStub();
		WSCommonResult result = new WSCommonResult();
		result.setErrorCode(0);
		// 构建服务列表参数
		ApplyServiceInfo[] serviceInfoArray = new ApplyServiceInfo[retServiceArray.length];

		for (int i = 0; i < retServiceArray.length; i++) {
			ApplyServiceInfo applyServiceInfo = new ApplyServiceInfo();
			// 判断服务状态是否可申请
			if (1 == retServiceArray[i].getServiceStatus()) {
				applyServiceInfo.setServiceTemplateId(retServiceArray[i]
						.getServiceId());
				// 判断是否需要分配IP
				if (1 == retServiceArray[i].getAssignAddress()) {
					applyServiceInfo.setUserIpAddress("10.153.130.12");
				}
				// 设置需要绑定的服务实体
				serviceInfoArray[0] = applyServiceInfo;
				ApplyServiceParam queryInfo = new ApplyServiceParam();
				queryInfo.setAccountName(accountName);
				queryInfo.setServiceInfo(serviceInfoArray);
				ApplyService applyService = new ApplyService();
				applyService.setParam0(queryInfo);
				OMElement element = stub.toOM(applyService, true);

				// 发送并接收消息
				OMElement response1 = sc.sendReceive(element);
				result = ApplyServiceResponse.Factory.parse(
						response1.getXMLStreamReaderWithoutCaching())
						.get_return();
				if (0 == result.getErrorCode()) {
					// 将申请的服务ID保存到全局变量，供注销服务使用。
					serviceIdArray[0] = applyServiceInfo.getServiceTemplateId();
					break;
				}
			}
		}

		// 判断是否有可以申请的服务
		if (null == serviceInfoArray || 0 >= serviceInfoArray.length
				|| null == serviceInfoArray[0]) {
			System.out.println("*** 申请服务失败--没有可申请服务 ***");
			return;
		}

		if (0 == result.getErrorCode()) {
			System.out.println("*** 申请服务成功 ***");
		} else {
			System.out.println("*** 申请服务失败 ***");
		}
		System.out.println("申请服务 ErrorCode: " + result.getErrorCode());
		System.out.println("申请服务 ErrorMsg: " + result.getErrorMsg());
		System.out.println();
	}

	/**
	 * 注销绑定服务。
	 *
	 * @param endPointStr 访问的WebService URL
	 * @param sc 测试客户端
	 * @throws Exception 抛出异常
	 */
	public static void cancelService(String endPointStr, ServiceClient sc)
			throws Exception {
		System.out.println("=============== 注销服务 ===============");
		if (0 >= serviceIdArray[0]) {
			System.out.println("*** 注销服务失败--没有可注销服务 ***");
			System.out.println("注销服务 ErrorMsg: 需要注销的服务ID “" + serviceIdArray[0]
					+ "”不存在或未绑定到帐号“" + accountName + "”");
			return;
		}
		// 执行注销服务
		setOptions(endPointStr, sc, "urn:cancelService");

		// 设置注销服务参数
		AcmUserServiceStub stub = new AcmUserServiceStub();
		CancelServiceParam queryInfo = new CancelServiceParam();
		queryInfo.setAccountName(accountName);
		queryInfo.setServiceList(serviceIdArray);
		CancelService cancelService = new CancelService();
		cancelService.setParam0(queryInfo);
		OMElement element = stub.toOM(cancelService, true);

		// 发送并接收消息
		OMElement response = sc.sendReceive(element);
		WSCommonResult result = CancelServiceResponse.Factory.parse(
				response.getXMLStreamReaderWithoutCaching()).get_return();
		if (0 == result.getErrorCode()) {
			System.out.println("*** 注销服务成功 ***");
		} else {
			System.out.println("*** 注销服务失败 ***");
		}
		System.out.println("注销服务 ErrorCode: " + result.getErrorCode());
		System.out.println("注销服务 ErrorMsg: " + result.getErrorMsg());
		System.out.println();
	}

	/**
	 * 转换自动分配IP
	 *
	 * @param assign int值
	 * @return 分配IP
	 */
	public static String convertAssignIp(int assign) {
		String assignAddress;
		switch (assign) {
		case 0:
			assignAddress = "否";
			break;
		case 1:
			assignAddress = "是";
			break;
		default:
			assignAddress = "否";
			break;
		}
		return assignAddress;
	}

	/**
	 * 状态值转换。
	 *
	 * @param status 状态码
	 * @return 状态描述信息
	 */
	public static String convertDamStatus(int status) {
		if (status == 1) {
			return "未管理";
		} else if (status == 2) {
			return "离线";
		} else if (status == 3) {
			return "在线";
		} else {
			return "未知";
		}
	}

	/**
	 * 转换服务状态
	 *
	 * @param status int值
	 * @return 服务状态
	 */
	public static String convertStatus(int status) {
		String serverStatus;
		switch (status) {
		case 1:
			serverStatus = "可申请";
			break;
		case 2:
			serverStatus = "不可申请";
			break;
		case 3:
			serverStatus = "删除";
			break;
		default:
			serverStatus = "可申请";
			break;
		}
		return serverStatus;
	}

	/**
	 * 绑定黑名单
	 *
	 * @param acmEndpointStr acmService
	 * @param sc 客户端
	 * @throws Exception exception
	 */
	public static void addBlackList(String acmEndpointStr, ServiceClient sc)
			throws Exception {

		System.out.println("============= 接入用户绑定黑名单 =================");

		// 调用绑定黑名单
		setOptions(acmEndpointStr, sc, "urn:addBlackList");
		// 设置黑名单
		AcmUserServiceStub stub = new AcmUserServiceStub();

		// 设置输入参数
		AddBlackList blackList = new AddBlackList();
		blackList.setParam0(accountName);
		OMElement element = stub.toOM(blackList, true);

		// 发送并接收消息
		OMElement response1 = sc.sendReceive(element);
		WSCommonResult result = AddBlackListResponse.Factory.parse(
				response1.getXMLStreamReaderWithoutCaching()).get_return();

		if (result.getErrorCode() != 0) {
			System.out.println("*** 增加绑定黑名单失败。***");
			System.out.println("错误码: " + result.getErrorCode());
			System.out.println("错误信息: " + result.getErrorMsg() + "\n");
		} else {
			System.out.println("*** 接入用户“" + accountName + "”加入黑名单。***\n");
		}
	}

	/**
	 * 查询黑名单
	 *
	 * @param acmEndpointStr acmService
	 * @param sc 客户端
	 * @return 黑名单列表
	 * @throws Exception exception
	 */
	public static RetAcmBlackInfoList queryBlackList(String acmEndpointStr,
			ServiceClient sc) throws Exception {

		System.out.println("============= 查询黑名单 =================");

		RetAcmBlackInfoList result;
		// 设置
		setOptions(acmEndpointStr, sc, "urn:queryBlackList");
		// 设置黑名单
		AcmUserServiceStub stub = new AcmUserServiceStub();
		// 设置输入参数
		QueryBlackList blackList = new QueryBlackList();
		blackList.setParam0(new AcmBlackQueryParam());
		OMElement element = stub.toOM(blackList, true);

		// 发送并接收消息
		OMElement response1 = sc.sendReceive(element);
		// 获取查询结果
		result = QueryBlackListResponse.Factory.parse(
				response1.getXMLStreamReaderWithoutCaching()).get_return();

		if (result.getErrorCode() != 0) {
			System.out.println("*** 查询黑名单失败。***");
			System.out.println("错误码: " + result.getErrorCode());
			System.out.println("错误信息: " + result.getErrorMsg() + "\n");

			return result;
		}

		RetAcmBlackInfo[] retAcmBlackInfo = result.getRetAcmBlackInfoList();
		if (retAcmBlackInfo == null || retAcmBlackInfo.length == 0) {
			System.out.println("*** 查询黑名单失败，系统中不存在黑名单。***\n");
			return result;
		}
		System.out.println("共" + retAcmBlackInfo.length + "条记录");
		System.out.printf("%-10s %-25s %-30s %-20s %-25s %-20s", " 帐号ID",
				"帐号名称", "加入原因", "Ip地址", "Mac地址", "加入时间");
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
	 * 解除黑名单
	 *
	 * @param acmEndpointStr acmService
	 * @param sc 客户端
	 * @throws Exception exception
	 */
	public static void deleteBlackList(String acmEndpointStr, ServiceClient sc)
			throws Exception {

		System.out.println("============= 解除黑名单 =================");

		// 调用解除黑名单
		setOptions(acmEndpointStr, sc, "urn:removeBlackList");
		// 设置黑名单
		AcmUserServiceStub stub = new AcmUserServiceStub();

		// 设置输入参数
		RemoveBlackList removeList = new RemoveBlackList();
		removeList.setParam0(accountName);
		OMElement element = stub.toOM(removeList, true);

		// 发送并接收消息
		OMElement response1 = sc.sendReceive(element);
		WSCommonResult result = RemoveBlackListResponse.Factory.parse(
				response1.getXMLStreamReaderWithoutCaching()).get_return();

		if (result.getErrorCode() != 0) {
			System.out.println("*** 解除黑名单失败。***");
			System.out.println("错误码: " + result.getErrorCode());
			System.out.println("错误信息: " + result.getErrorMsg() + "\n");
		} else {
			System.out.println("*** 接入用户“" + accountName + "”解除黑名单。***\n");
		}
	}

	/**
	 * 查询同步策略列表
	 *
	 * @param acmEndpointStr acm service
	 * @param sc 客户端
	 * @return RetAcmSyncPolicyInfoList 同步策略列表
	 * @throws Exception 异常
	 */
	public static RetAcmSyncPolicyInfoList querySyncPolicyList(
			String acmEndpointStr, ServiceClient sc) throws Exception {

		System.out.println("============= 查询同步策略列表 =================");

		// 调用查询同步策略
		setOptions(acmEndpointStr, sc, "urn:querySyncPolicyInfoList");

		// 设置
		AcmUserServiceStub stub = new AcmUserServiceStub();

		// 设置输入参数
		QuerySyncPolicyInfoList policy = new QuerySyncPolicyInfoList();
		AcmSyncPolicyQueryParam param = new AcmSyncPolicyQueryParam();
		policy.setParam0(param);
		OMElement element = stub.toOM(policy, true);

		// 发送并接收消息
		OMElement response1 = sc.sendReceive(element);
		RetAcmSyncPolicyInfoList result = QuerySyncPolicyInfoListResponse.Factory
				.parse(response1.getXMLStreamReaderWithoutCaching())
				.get_return();

		if (result.getErrorCode() != 0) {
			System.out.println("*** 查询同步策略列表失败。***");
			System.out.println("错误码: " + result.getErrorCode());
			System.out.println("错误信息: " + result.getErrorMsg() + "\n");
			return result;
		}

		RetAcmSyncPolicyInfo[] policyInfo = result
				.getRetAcmSyncPolicyInfoList();

		if (policyInfo == null || 0 == policyInfo.length) {
			System.out.println("*** 查询同步策略列表失败，系统中不存在同步策略。***\n");
			return result;
		}

		System.out.println("共" + policyInfo.length + "条记录");
		System.out.printf("%-25s %-15s %-25s %-15s %-25s %-20s %-20s", " 策略名称",
				"服务ID", "服务名称", "服务同步策略ID", "用户分组ID", "配置状态", "自动同步");
		System.out.println();

		for (RetAcmSyncPolicyInfo info : policyInfo) {
			System.out.printf("%-25s %-15s %-25s %-15s %-25s %-20s %-20s",
					convertNull(info.getPolicyName()), info.getServerId(),
					convertNull(info.getServerName()), info.getSyncPolicyId(),
					info.getUserGroupId(), info.getConfigStatus(), info
							.getAutoSync());
			System.out.println();
		}
		// 取第一条记录的id
		policyId = policyInfo[0].getPolicyId();

		System.out.println();
		return result;
	}

	/**
	 * 增加绑定用户
	 *
	 * @param acmEndpointStr acm service
	 * @param sc 客户端
	 * @throws Exception 异常
	 */
	public static void addBindingUserList(String acmEndpointStr,
			ServiceClient sc) throws Exception {

		System.out.println("============= 增加绑定用户 =================");

		setOptions(acmEndpointStr, sc, "urn:addBindingUser");

		// 设置绑定用户
		AcmUserServiceStub stub = new AcmUserServiceStub();

		// 设置输入参数
		AddBindingUser user = new AddBindingUser();
		user.setParam0(policyId);
		user.setParam1(userId);
		OMElement element = stub.toOM(user, true);

		// 发送并接收消息
		OMElement response1 = sc.sendReceive(element);
		WSCommonResult result = AddBindingUserResponse.Factory.parse(
				response1.getXMLStreamReaderWithoutCaching()).get_return();

		if (result.getErrorCode() != 0) {
			System.out.println("*** 增加绑定用户失败。***");
			System.out.println("错误码: " + result.getErrorCode());
			System.out.println("错误信息: " + result.getErrorMsg() + "\n");
		} else {
			System.out.println("*** 增加LDAP绑定用户“" + accountName + "”。***\n");
		}
	}

	/**
	 * 查询同步策略用户列表
	 *
	 * @param acmEndpointStr acm service
	 * @param sc 客户端
	 * @return RetAcmSyncPolicyUserInfoList 同步策略用户列表
	 * @throws Exception 异常
	 */
	public static RetAcmSyncPolicyUserInfoList querySyncPolicyUserList(
			String acmEndpointStr, ServiceClient sc) throws Exception {

		System.out.println("============= 查询同步策略用户列表 =================");

		RetAcmSyncPolicyUserInfoList result;
		// 设置
		setOptions(acmEndpointStr, sc, "urn:querySyncPolicyUserInfoList");

		// 设置查询同步策略用户
		AcmUserServiceStub stub = new AcmUserServiceStub();

		AcmSyncPolicyUserQueryParam param = new AcmSyncPolicyUserQueryParam();
		param.setPolicyId(policyId);
		// 设置输入参数
		QuerySyncPolicyUserInfoList policy = new QuerySyncPolicyUserInfoList();

		policy.setParam0(param);
		OMElement element = stub.toOM(policy, true);

		// 发送并接收消息
		OMElement response1 = sc.sendReceive(element);
		result = QuerySyncPolicyUserInfoListResponse.Factory.parse(
				response1.getXMLStreamReaderWithoutCaching()).get_return();

		// 查询失败
		if (result.getErrorCode() != 0) {
			System.out.println("*** 查询同步策略用户列表失败，查询同步策略用户失败。***");
			System.out.println("错误码: " + result.getErrorCode());
			System.out.println("错误信息: " + result.getErrorMsg() + "\n");
			return result;
		}
		// 没有查询结果
		RetAcmSyncPolicyUserInfo[] retAcmSyncUserInfo = result
				.getRetAcmSyncPolicyUserInfoList();
		if (retAcmSyncUserInfo == null || retAcmSyncUserInfo.length == 0) {
			System.out.println("*** 查询同步策略用户列表，系统中不存在同步策略用户。***\n");
			return result;
		}
		System.out.println("共" + retAcmSyncUserInfo.length + "条记录");
		System.out.printf("%-25s %-25s %-25s %-25s ", " 帐号名称", "用户名称",
				"用户分组ID", "用户状态");
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
	 * 解除绑定用户
	 *
	 * @param acmEndpointStr acm service
	 * @param sc 客户端
	 * @throws Exception 异常
	 */
	public static void deleteBindingUserList(String acmEndpointStr,
			ServiceClient sc) throws Exception {

		System.out.println("============= 解除绑定用户 =================");

		setOptions(acmEndpointStr, sc, "urn:cancelBindingUser");

		// 设置解除绑定用户
		AcmUserServiceStub stub = new AcmUserServiceStub();

		// 设置输入参数
		CancelBindingUser user = new CancelBindingUser();
		user.setParam0(userId);
		OMElement element = stub.toOM(user, true);

		// 发送并接收消息
		OMElement response1 = sc.sendReceive(element);
		WSCommonResult result = CancelBindingUserResponse.Factory.parse(
				response1.getXMLStreamReaderWithoutCaching()).get_return();

		if (result.getErrorCode() != 0) {
			System.out.println("*** 解除绑定用户失败。***");
			System.out.println("错误码: " + result.getErrorCode());
			System.out.println("错误信息: " + result.getErrorMsg() + "\n");
		} else {
			System.out.println("*** 解除用户“" + accountName
					+ "与LDAP同步策略的绑定”。***\n");
		}
	}

	/**
	 * 查询在线用户列表
	 *
	 * @param endPointStr 访问的WebService URL
	 * @param sc 测试客户端
	 * @return 在线用户列表
	 * @throws Exception 抛出异常
	 */
	public static RetAcmOnlineUserList queryOnlineUser(String endPointStr,
			ServiceClient sc) throws Exception {
		System.out.println("=============== 查询在线用户列表 ===============");
		// 执行查询在线用户操作
		setOptions(endPointStr, sc, "urn:queryAcmOnlineUserList");

		// 设置查询接入用户列表参数
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

		// 发送并接收消息
		OMElement response1 = sc.sendReceive(element);
		RetAcmOnlineUserList result = QueryAcmOnlineUserListResponse.Factory
				.parse(response1.getXMLStreamReaderWithoutCaching())
				.get_return();
		// 转换日期类型
		if (result.getErrorCode() == 0) {
			System.out.println("*** 查询在线用户列表成功（10条记录） ***");
			System.out
					.printf(
							"%-10s %-10s %-20s %-20s %-20s %-20s %-30s %-10s %-20s %-20s %-10s",
							"序号", "在线用户ID", "帐号名", "登录名", "用户姓名", "服务名称",
							"接入时间", "在线时长", "设备IP", "用户IP", "安全状态");
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
				System.out.println("*** 未找到符合条件的记录 ***");
			}
		} else {
			System.out.println("*** 查询在线用户列表失败 ***");
			System.out.println("查询在线用户 ErrorCode: " + result.getErrorCode());
			System.out.println("查询在线用户 ErrorMsg: " + result.getErrorMsg());
		}
		System.out.println();
		return result;
	}

	/**
	 * 下发消息
	 *
	 * @param endPointStr 访问的WebService URL
	 * @param sc 测试客户端
	 * @throws Exception 抛出异常
	 */
	public static void sendMessage(String endPointStr, ServiceClient sc)
			throws Exception {
		System.out.println("=============== 向在线用户下发消息 ===============");
		// 对其进行操作的在线用户
		AcmOnlineUserSimpleInfo acmOnlineUserSimpleInfo;
		if (null != acmOnlineUserArray && 0 < acmOnlineUserArray.length) {
			acmOnlineUserSimpleInfo = acmOnlineUserArray[0];
		} else {
			System.out.println("*** 下发消息失败，未找到在线用户。 ***");
			System.out.println();
			return;
		}
		// 执行查询在线用户操作
		setOptions(endPointStr, sc, "urn:sendMessage");

		// 设置查询接入用户列表参数
		AcmUserServiceStub stub = new AcmUserServiceStub();
		SendMessage sendMessage = new SendMessage();
		// 设置在线用户ID
		sendMessage.setParam0(acmOnlineUserSimpleInfo.getOnlineUserId());
		// 设置下发消息内容
		sendMessage.setParam1("The Messages.");
		OMElement element = stub.toOM(sendMessage, true);

		// 发送并接收消息
		OMElement response1 = sc.sendReceive(element);
		WSCommonResult result = SendMessageResponse.Factory.parse(
				response1.getXMLStreamReaderWithoutCaching()).get_return();
		if (0 == result.getErrorCode()) {
			System.out.println("*** 下发消息成功 ***");
		} else {
			System.out.println("*** 下发消息失败 ***");
		}
		System.out.println("下发消息 ErrorCode: " + result.getErrorCode());
		System.out.println("下发消息 ErrorMsg: " + result.getErrorMsg());
		System.out.println();
	}

	/**
	 * 清除在线信息
	 *
	 * @param endPointStr 访问的WebService URL
	 * @param sc 测试客户端
	 * @throws Exception 抛出异常
	 */
	public static void clearOnlineInfo(String endPointStr, ServiceClient sc)
			throws Exception {
		System.out.println("=============== 清除在线用户信息 ===============");
		// 对其进行操作的在线用户
		AcmOnlineUserSimpleInfo acmOnlineUserSimpleInfo;
		if (null != acmOnlineUserArray && 0 < acmOnlineUserArray.length) {
			acmOnlineUserSimpleInfo = acmOnlineUserArray[0];
		} else {
			System.out.println("*** 清除信息失败，未找到在线用户。 ***");
			System.out.println();
			return;
		}
		// 执行查询在线用户操作
		setOptions(endPointStr, sc, "urn:clearOnlineInfo");

		// 设置查询接入用户列表参数
		AcmUserServiceStub stub = new AcmUserServiceStub();
		ClearOnlineInfo clearOnlineInfo = new ClearOnlineInfo();
		// 设置在线用户ID
		clearOnlineInfo.setParam0(acmOnlineUserSimpleInfo.getOnlineUserId());
		OMElement element = stub.toOM(clearOnlineInfo, true);

		// 发送并接收消息
		OMElement response1 = sc.sendReceive(element);
		WSCommonResult result = ClearOnlineInfoResponse.Factory.parse(
				response1.getXMLStreamReaderWithoutCaching()).get_return();
		if (0 == result.getErrorCode()) {
			System.out.println("*** 清除信息成功 ***");
		} else {
			System.out.println("*** 清除信息失败 ***");
		}
		System.out.println("清除在线用户消息 ErrorCode: " + result.getErrorCode());
		System.out.println("清除在线用户消息 ErrorMsg: " + result.getErrorMsg());
		System.out.println();
	}

	/**
	 * 强制下线
	 *
	 * @param endPointStr 访问的WebService URL
	 * @param sc 测试客户端
	 * @throws Exception 抛出异常
	 */
	public static void kickOut(String endPointStr, ServiceClient sc)
			throws Exception {
		System.out.println("=============== 强制在线用户下线 ===============");
		// 对其进行操作的在线用户
		AcmOnlineUserSimpleInfo acmOnlineUserSimpleInfo;
		if (null != acmOnlineUserArray && 0 < acmOnlineUserArray.length) {
			acmOnlineUserSimpleInfo = acmOnlineUserArray[0];
		} else {
			System.out.println("*** 强制下线失败，未找到在线用户。 ***");
			System.out.println();
			return;
		}
		// 执行查询在线用户操作
		setOptions(endPointStr, sc, "urn:kickOut");

		// 设置查询接入用户列表参数
		AcmUserServiceStub stub = new AcmUserServiceStub();
		KickOut kickOut = new KickOut();
		// 设置在线用户ID
		kickOut.setParam0(acmOnlineUserSimpleInfo.getOnlineUserId());
		OMElement element = stub.toOM(kickOut, true);

		// 发送并接收消息
		OMElement response1 = sc.sendReceive(element);
		WSCommonResult result = KickOutResponse.Factory.parse(
				response1.getXMLStreamReaderWithoutCaching()).get_return();
		if (0 == result.getErrorCode()) {
			System.out.println("*** 强制下线成功 ***");
		} else {
			System.out.println("*** 强制下线失败 ***");
		}
		System.out.println("强制在线用户下线 ErrorCode: " + result.getErrorCode());
		System.out.println("强制在线用户下线 ErrorMsg: " + result.getErrorMsg());
		System.out.println();
	}

	/**
	 * 转化加入黑名单原因
	 *
	 * @param joinReason 加入原因
	 * @return 加入原因
	 */
	public static String convertJoinReason(int joinReason) {
		String reason;
		switch (joinReason) {
		case 1:
			reason = "管理员锁定用户";
			break;
		case 2:
			reason = "超过认证失败阈值";
			break;
		case 3:
			reason = "多次认证失败(灰名单)";
			break;
		default:
			reason = "管理员锁定用户";
			break;
		}
		return reason;
	}

	/**
	 * NULL值转换。
	 *
	 * @param value 数据库值
	 * @return 转换后的值
	 */
	public static String convertNull(String value) {
		if (StringUtils.isBlank(value)) {
			return "--";
		} else {
			return value;
		}
	}

	/**
	 * 注销系统。
	 *
	 * @param imcPlatEndPointStr WebService location
	 * @param sc 客户端
	 * @throws Exception 异常
	 */
	public static void logout(String imcPlatEndPointStr, ServiceClient sc)
			throws Exception {
		// 调用注销接口
		setOptions(imcPlatEndPointStr, sc, "urn:logout");

		// 构造请求报文
		OMFactory factory = OMAbstractFactory.getOMFactory();
		OMNamespace ns = factory.createOMNamespace(
				"http://imc.h3c.com/imcplatService", "ns");
		OMElement elem = factory.createOMElement("logout", ns);

		// 发送后接收响应报文
		OMElement response = sc.sendReceive(elem);
		// 解析响应报文
		ImcplatServiceStub.WSCommonResult result = LogoutResponse.Factory
				.parse(response.getXMLStreamReaderWithoutCaching())
				.get_return();

		System.out.println("=============== 注销系统 =================");
		// 注销失败
		if (result.getErrorCode() != 0) {
			System.out.println("*** 操作员“admin”注销失败。***");
			System.out.println("错误码: " + result.getErrorCode());
			System.out.println("错误信息: " + result.getErrorMsg());
		}
		// 注销成功
		else {
			System.out.println("*** 操作员“admin”注销成功。***\n");
		}
	}

	/**
	 * 加载策略。
	 *
	 * @param xmlPath 策略文件路径
	 * @return 策略对象
	 * @throws FileNotFoundException 文件不存在异常
	 * @throws XMLStreamException XML操作异常
	 */
	private static Policy loadPolicy(String xmlPath)
			throws FileNotFoundException, XMLStreamException {
		StAXOMBuilder stAXOMBuilder = new StAXOMBuilder(xmlPath);
		return PolicyEngine.getPolicy(stAXOMBuilder.getDocumentElement());
	}

}
