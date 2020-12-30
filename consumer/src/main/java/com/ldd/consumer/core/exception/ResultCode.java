package com.ldd.consumer.core.exception;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public enum ResultCode {
    /**
     * 正常
     */
    NORMAL(0, "NORMAL", "", 0),

    /** ========== 系统错误码 ========== **/

    /**
     * Token过期
     */
    NOT_FOUND(404, "NOT_FOUND", "不存在的API", 1),
    TOKEN_ERROR(401, "TOKEN_ERROT", "登录已失效,请重新登录", 1),
    SIGN_ERROR(20029, "SIGN_ERROR", "签名失败", 2),
    NOT_AUTH(20030, "NOT_AUTH", "权限不足", 2),
    /**
     * 系统错误
     */
    ERROR_SYSTEM(10001, "ERROR_SYSTEM", "系统错误,请稍后再试！", 1),

    /**
     *
     */
    IDEMPOTENT_ERROR(10015, "IDEMPOTENT_ERROR", "不能重复提交，请稍后重试！", 1),

    /**
     * 数据库查询失败
     */
    ERROR_SYSTEM_DATABASE_QUERY(10011, "ERROR_SYSTEM_DATABASE_QUERY", "数据库查询失败！", 1),

    /**
     * 数据库存储失败
     */
    ERROR_SYSTEM_DATABASE_INSERT(10012, "ERROR_SYSTEM_DATABASE_INSERT", "数据库存储失败！", 1),

    /**
     * 数据库更新失败
     */
    ERROR_SYSTEM_DATABASE_UPDATE(10013, "ERROR_SYSTEM_DATABASE_UPDATE", "数据库更新失败！", 1),

    /** ========== 应用错误码 ========== **/

    /**
     * 传入的参数有误，验证不能通过
     */
    PARAM_WRONG(20000, "PARAM_WRONG", "传入的参数有误，验证不能通过！", 2),

    /**
     * 验证码已过期
     */
    VALID_CODE_EXPIRE_ERROR(20002, "valid_code_expire", "验证码已过期！", 2),

    /**
     * 该用户不存在，请注册
     */
    USER_NOT_EXISTS_ERROR(20003, "user_not_exists", "账号或密码不正确，请重试！", 2),

    /**
     * 密码修改失败
     */
    PASSWORD_CHANGE_FAILED_ERROR(20004, "password_change_failed", "密码修改失败！", 2),

    /**
     * 密码错误
     */
    PASSWORD_FAILED_ERROR(20005, "password_failed", "账号或密码不正确，请重试！", 2),

    /**
     * 头像上传失败
     */
    IMG_UPLOAD_FAILED_ERROR(20006, "img_upload_failed", "上传失败！", 2),

    /**
     * 验证码已过期
     */
    MSG_UPLOAD_FAILED_ERROR(20007, "valicode_failed", "验证码已过期！", 2),

    /**
     * 信息获取失败
     */
    DATA_REQUIRD_ERROR(20008, "Data_requird", "信息获取失败！", 2),

    /**
     * 账号已被冻结
     */
    ACCOUNT_HAS_BEEN_FROZEN_ERROR(20009, "Account_has_been_frozen", "账号已被冻结！", 2),

    /**
     * 注册失败
     */
    REGISTER_FAILED_ERROR(20010, "register_failed", "注册失败！", 2),

    /**
     * 该手机号已注册
     */
    ACCOUNT_HAS_BEEN_EXISTS_ERROR(20011, "Account_has_been_exists", "该手机号已注册！", 2),

    /**
     * 不存在的验证码
     */
    VALICODE_NOT_EXISTS_ERROR(20012, "valicode_not_exists", "不存在的验证码！", 2),

    /**
     * 短信发送失败
     */
    MSG_PUSH_FAILED_ERROR(20013, "msg_push_failed", "短信发送失败！", 2),

    /**
     * 验证码不匹配
     */
    VALICODE_NOT_EQUEL_ERROR(20014, "valicode_not_equel", "验证码不匹配！", 2),

    /**
     * 设备信息保存失败
     */
    DEVICE_INFO_ERROR(20015, "device_info_error", "设备信息保存失败！", 2),

    /**
     * 设备信息保存失败
     */
    MSG_INFO_ERROR(20016, "msg_info_error", "建议信息保存失败！", 2),

    /**
     * 请在15分钟之后，再发送验证码
     */
    UNDETECTED_FAILURE_TIME_ERROR(20017, " undetected_failure_time", "请在15分钟之后，再发送验证码！", 2),

    HNC_INVALID_PHONE_NUM(20104, "HNC_INVALID_PHONE_NUM", "非法手机号码", 2),

    USER_NO_RECORD_ERROR(20105, "USER_NO_RECORD_ERROR", "用户基础信息不全，请补充", 2),

    REPORT_NO_DETAIL(20106, "REPORT_NO_DETAIL", "暂无详情数据", 2),

    OPERATION_FAILED(20107, "OPERATION_FAILED", "操作失败", 2),

    USER_NOT_USER(20108, "USER_NOT_USER", "非本人操作，无权限更新", 2),

    USER_NO_PERSONAL_INFO(20109, "USER_NO_PERSONAL_INFO", "未填写个人信息", 2),

    NO_USER_PLAN_ERROR(20110, "NO_USER_PALN_ERROR", "没有该计划", 2),

    PLAN_OUT_OF_DATE_ERROR(20111, "PLAN_OUT_OF_DATE_ERROR", "计划已经过期", 2),

    SYNC_INFO_ERROR(20112, "SYNC_INFO_ERROR", "同步信息失败", 2),

    XLS_INFO_ERROR(20113, "XLS_INFO_ERROR", "表格数据有误", 2),

    ASYN_INFO_ERROR(20114, "ASYN_INFO_ERROR", "异步服务生成失败", 2),

    EXPERT_NOT_EXIST_ERROR(20115, "EXPERT_NOT_EXIST_ERROR", "专家团不存在", 2),

    RECODE_NOT_FOUND(20116, "RECODE_NOT_FOUND", "信息不存在", 2),

    RECODE_NOT_EQUIPMENT(20117, "RECODE_NOT_EQUIPMENT", "该设备无法识别", 2),

    RECODE_EQUIPMENT_BINDING_AGAIN(20118, "RECODE_EQUIPMENT_BINDING_AGAIN", "您已经绑定过该设备", 2),

    ORDER_NOT_EXISTS(20119, "ORDER_NOT_EXISTS", "订单不存在", 2),

    REST_MONEY_NOT_ENOUGH(20120, "REST_MONEY_NOT_ENOUGH", "余额不足", 2),

    PAY_FAILED_ERROR(20121, "PAY_FAILED_ERROR", "支付失败", 2),

    REFUND_FAILED_ERROR(20122, "REFUND_FAILED_ERROR", "退款失败", 2),

    PAY_ORDER_INVOKE_SERVICE_ERROR(20123, "PAY_ORDER_INVOKE_SERVICE_ERROR", "调用服务失败", 2),

    ORDER_STATUS_ERROR(20124, "ORDER_STATUS_ERROR", "订单状态异常", 2),

    PHYSCIAL_FITNESS_IMPORT_EMPTY_DATA(20125, "PHYSCIAL_FITNESS_IMPORT_EMPTY_DATA", "导入数据为空", 2),

    PHYSCIAL_FITNESS_IMPORT_EXISTS_EMPTY_DATA(20126, "PHYSCIAL_FITNESS_IMPORT_EXISTS_EMPTY_DATA", "导入数据存在空值", 2),

    PAY_ORDER_PAY_TYPE_NOT_EXITS(20127, "PAY_ORDER_PAY_TYPE_NOT_EXITS", "支付方式不存在", 2),

    ORDER_HAS_PAYED_ERROR(20128, "ORDER_HAS_PAYED_ERROR", "订单已经支付", 2),

    USER_ALREADY_EXIST(20129, "USER_ALREADY_EXIST", "用户已经存在", 2),

    PLAN_PERIOD_END_ERROR(20130, "PLAN_PERIOD_END_ERROR", "计划结束时间不能小于今天", 2),

    PLAN_TEMPLATE_NO_EXIST(20131, "PLAN_TEMPLATE_NO_EXIST", "健康方案不存在", 2),

    PLAN_TASK_IS_EXIST(20132, "PLAN_TASK_IS_EXIST", "健康方案已存在，请勿重复操作", 2),

    PLAN_NO_USER_TASK_ERROR(20133, "PLAN_NO_USER_TASK_ERROR", "没有找到任务", 2),

    TASK_HAS_FINISH_ERROR(20134, "TASK_HAS_FINISH_ERROR", "任务已经完成", 2),

    RECORD_ALREADY_EXIST(20135, "RECORD_ALREADY_EXIST", "记录已经存在", 2),

    ADMIN_USER_NOT_EXIST(20136, "ADMIN_USER_NOT_EXIST", "管理员不存在", 2),

    SERVICE_PACKAGE_COMPANY_SALE_TYPE_ERROR(20137, "SERVICE_PACKAGE_COMPANY_SALE_TYPE_ERROR", "售卖为企业时候企业信息不能为空", 2),

    REPORT_TYPE_NOT_VALID(20138, "REPORT_TYPE_NOT_VALID", "报告类型不正确", 2),

    SIGN_CONFIG_COUNT_TWO(20139, "SIGN_CONFIG_COUNT_TWO", "体征配置显示部分最少需要2个", 2),

    REWARD_TASK_NOT_EXIST(20140, "REWARD_TASK_NOT_EXIST", "任务奖励后台任务不存在", 2),

    TODAY_SIGN_ERROR(20141, "TODAY_SIGN_ERROR", "重复操作", 2),

    MALL_PRODUCT_NOT_EXIST(20142, "MALL_PRODUCT_NOT_EXIST", "商品不存在", 2),

    NOT_REACH_RECEIVE_TERM_ERROR(20143, "NOT_REACH_RECEIVE_TERM_ERROR", "未达到领取条件", 2),

    USER_HAS_GET_SPORT_REWARD(20144, "USER_HAS_GET_SPORT_REWARD", "用户已经领取过奖励", 2),

    PHY_EXAM_INST_EXIST_ERROR(20145, "PHY_EXAM_INST_EXIST_ERROR", "体检机构已存在", 2),

    PHY_EXAM_PKG_EXIST_ERROR(20146, "PHY_EXAM_PKG_EXIST_ERROR", "套餐不存在", 2),
    GOODS_ORDER_STATUS_AUDIT_ERROR(20147, "GOODS_ORDER_STATUS_AUDIT_ERROR", "订单状态不是待审核状态", 2),

    COMPANY_GOODS_PRIZE_ERROR(20148, "COMPANY_GOODS_PRIZE_ERROR", "商品单价不正确，请刷新后重新购买", 2),

    ADD_COMPANY_GOODS_ERROR(20149, "ADD_COMPANY_GOODS_ERROR", "添加商品失败", 2),

    USER_OR_COMPANY_NOT_EXIST(20150, "USER_OR_COMPANY_NOT_EXIST", "用户不存在", 2),

    MALL_USER_NO_ENOUGH_COIN(20151, "MALL_USER_NO_ENOUGH_COIN", "您的金币不够哦~~", 2),

    MALL_PRODUCT_NO_STOCK(20152, "MALL_PRODUCT_NO_STOCK", "兑换失败，太火爆了，已经被兑换光了", 2),

    MALL_PRODUCT_UN_SHELF(20153, "MALL_PRODUCT_UN_SHELF", "商品已下架了", 2),

    MALL_EXCHANGE_ERROR(20154, "MALL_EXCHANGE_ERROR", "兑换失败，请联系工作人员", 2),

    MALL_EXCHANGE_NO_MATCH(20155, "MALL_EXCHANGE_NO_MATCH", "兑换失败，您不符合兑换条件", 2),

    REPORT_UPLOAD_SAME_NAME(20156, "REPORT_UPLOAD_SAME_NAME", "名字有重复", 2),

    PLAN_NOT_FINISHED_ERROR(20157, "PLAN_NOT_FINISHED_ERROR", "计划还未完成，请先完成计划", 2),

    MOVEMENT_NOT_MATCH(20158, "MOVEMENT_NOT_MATCH", "运动记录不达标", 2),

    MOVEMENT_TASK_FUNCTION_ID_NOT_EXIST(20159, "MOVEMENT_TASK_FUNCTION_ID_NOT_EXIST", "运动任务未配置功能点", 2),

    REPORT_IS_DELETE_OR_NOT_ERROR(20160, "REPORT_IS_DELETE_OR_NOT_ERROR", "体检报告不存在", 2),

    SURVEY_NO_FINISH_OR_NOT_ERROR(20161, "SURVEY_NO_FINISH_OR_NOT_ERROR", "问卷填写不完整", 2),

    ERROR_IMPORT_REPORT(20162, "ERROR_IMPORT_REPORT", "以下导入数据错误", 2),

    REPORT_PARSE_ERROR(20163, "REPORT_PARSE_ERROR", "报告解析失败", 2),

    REPORT_ASSESS_ERROR(20164, "REPORT_ASSESS_ERROR", "报告评估失败", 2),

    PLAN_NO_PLAN_CONFIG_ERROR(20165, "PLAN_NO_PLAN_CONFIG_ERROR", "用户没有计划配置", 2),

    HAVE_NO_ANALYSIS_ACCESS(20166, "HAVE_NO_ANALYSIS_ACCESS", "没有报告解读权限", 2),

    STATION_ID_NOT_EXIST(20167, "STATION_ID_NOT_EXIST", "渠道号不存在", 2),

    GET_REPORT_FROM_HOSPITAL_FAIL(20168, "GET_REPORT_FROM_HOSPITAL_FAIL", "从医院获取报告失败", 2),

    REDUCE_MONEY_MORE_THAN_REAL_VALUE(20169, "REDUCE_MONEY_MORE_THAN_REAL_VALUE", "抵扣金额最高值大于卡券实际金额", 2),

    MSG_PUSH_TIMES_ERROR(20170, "MSG_PUSH_TIMES_ERROR", "短信发送频繁，稍后再试！", 2),

    NO_REPORT_SAVE_SUCCESS(20171, "NO_REPORT_SAVE_SUCCESS", "没有报告保存成功", 2),

    STATION_NO_TEST_ENV(20172, "STATION_NO_TEST_ENV", "该医院不在测试范围内", 2),

    ID_NUMBER_NOT_REGULAR(20173, "ID_NUMBER_NOT_REGULAR", "身份证号码不符合规范", 2),

    NOT_SUPPORT_TYPE(20174, "NOT_SUPPORT_TYPE", "暂不支持该类型", 2),

    NOT_SUPPORT_ADDITION(20175, "NOT_SUPPORT_ADDITION", "检中加项不支持退款", 2),

    EXCEL_NO_DATA(20176, "EXCEL_NO_DATA", "导入文件没有数据", 2),

    COMPANY_NAME_EXISTS(20177, "COMPANY_NAME_EXISTS", "已存在该名称企业", 2),

    NO_UPLOAD_DATA(20178, "COMPANY_NAME_EXISTS", "请上传 Excel 文件", 2),

    NO_SUIT_DATA(20179, "NO_SUIT_DATA", "请选择套餐", 2),

    CREATE_ORDER_FAILED(20180, "CREATE_ORDER_FAILED", "创建订单失败", 2),

    DEVICE_ID_AND_UID_NOT_MATCH(20181, "DEVICE_ID_AND_UID_NOT_MATCH", "设备id和uid不匹配", 2),

    REFUND_STATUS_FAILED(20182, "REFUND_STATUS_FAILED", "取消退款失败", 2),

    REFUND_ADDITION_FIRST(20183, "REFUND_ADDITION_FIRST", "请先退款加项订单", 2),
    ORDER_AMOUNT_LESS_ZERO(20184, "ORDER_AMOUNT_LESS_ZERO", "订单数量不能少于0", 2),

    GOODS_NOT_ENOUGH_INVENTORY(20185, "GOODS_NOT_ENOUGH_INVENTORY", "商品库存不足", 2),

    ORDER_RECEIVING_INFORMATION(20186, "GOODS_NOT_ENOUGH_INVENTORY", "商品收货信息未填写", 2),

    ORDER_VALID_PAY_TYPE(20187, "ORDER_VALID_PAY_TYPE", "商品支付方式不匹配", 2),

    ORDER_REFUND_MONEY_OVER_ERROR(20188, "ORDER_REFUND_MONEY_OVER_ERROR", "商品退款金额超出订单原金额", 2),

    ORDER_SEARCH_TIME_OVER_RANG_ERROR(20189, "ORDER_SEARCH_TIME_OVER_RANG_ERROR", "订单搜索时间最长不能长于31天", 2),

    ORDER_IMPORT_ERROR(20190, "ORDER_IMPORT_ERROR", "订单导入错误", 2),

    ORDER_OVER_TIME_ERROR(20191, "ORDER_OVER_TIME_ERROR", "订单已经超时", 2),

    HELIAN_ITME_EXIST_ERROR(20192, "HELIAN_ITME_EXIST_ERROR", "标准库编号已存在", 2),

    ORDER_SUPPORT_ERROR(20193, "ORDER_SUPPORT_ERROR", "该订单不支持直接退款", 2),

    ANALYSIS_NEED_TAG(20194, "ANALYSIS_NEED_TAG", "请选择标签！", 2),

    STATUS_ERROR(20195, "STATUS_ERROR", "操作状态有误！", 2),

    OCR_REPORT_ERROR(20196, "OCR_REPORT_ERROR", "报告解读失败！", 2),

    OCR_REPORT_INDEX_NAME_NULL_ERROR(20197, "OCR_REPORT_INDEX_NAME_NULL_ERROR", "指标名字为空！", 2),

    OCR_REPORT_INDEX_VALUE_NULL_ERROR(20198, "OCR_REPORT_INDEX_VALUE_NULL_ERROR", "指标值为空！", 2),

    RESERVE_CARD_PASS(20199, "RESERVE_CARD_PASS", "体检卡已经审核通过！", 2),

    NO_HOSPITAL_CONFIG_EXISTS(20200, "NO_HOSPITAL_CONFIG_EXISTS", "医院不存在！", 2),

    ADDITION_NOT_SUPPORT(20201, "ADDITION_NOT_SUPPORT", "医院不支持检中加项！", 2),

    RESERVE_NOT_SUPPORT(20202, "RESERVE_NOT_SUPPORT", "医院不支持预约或者检中加项！", 2),

    CARD_NOT_FOUND(20203, "CARD_NOT_FOUND", "信息不存在", 2),

    REFUND_PKG_HAS_NOT_REFUND_ADDITION(20204, "REFUND_PKG_HAS_NOT_REFUND_ADDITION", "加项全部退款后可退款套餐", 2),

    CARD_NOT_SUPPORT(20205, "CARD_NOT_SUPPORT", "绑定失败,请到<禾健康>公众号预约", 2),

    SURVEY_NOT_FOUND(20206, "SURVEY_NOT_FOUND", "暂无合适的智能问卷", 2),

    RESERVE_CARD_ID_NOT_EXIST(20207, "RESERVE_CARD_ID_NOT_EXIST", "团检卡模板id不能为空", 2),
    CARD_TASK_TIME_NOT_EXIST(20208, "CARD_TASK_TIME_NOT_EXIST", "团检卡任务时间不能为空", 2),
    CARD_TASK_TIME_ERROR(20209, "CARD_TASK_TIME_ERROR", "团检卡任务时间格式不正确,HH:mm:ss", 2),


    WX_GET_OPENID_ERROR(20210, "WX_GET_OPENID_ERROR", "获取微信失败", 2),

    ADDITION_PKG_CONTROLLER_PARAM_ERROR(20211, "ADDITION_PKG_CONTROLLER_PARAM_ERROR", "请输入名称和关联项", 2),

    STATION_ID_EXISTS(20212, "STATION_ID_EXISTS", "医院id已经存在!", 2),
    STATION_NAME_EXISTS(20213, "STATION_NAME_EXISTS", "医院名称已经存在!", 2),
    STATION_ID_ERROR(20214, "STATION_ID_ERROR", "检查stationId，机构找不到!", 2),

    SPU_ID_ERROR(20215, "SPU_ID_ERROR", "检查spuId，商品找不到!", 2),

    ALI_SETTLEMENT_PRICE_ERROR(20216, "ALI_SETTLEMENT_PRICE_ERROR", "阿里结算金额必须>0", 2),

    AREA_CODE_ERROR(20217, "AREA_CODE_ERROR", "区域编码有误", 2),

    REPORT_ERROR_COUNT(20218, "REPORT_ERROR_COUNT", "查询次数超过限制", 2),

    SAVE_REPORT_ERROR_COUNT(20219, "SAVE_REPORT_ERROR_COUNT", "可获取的报告数量已达上限", 2),
    UN_REF_STANDARD(20220, "UN_REF_STANDARD", "未关联标准项", 2),

    COMPANY_USER_BIND_ERROR(20221, "COMPANY_USER_BIND_ERROR", "该用户未绑定企业", 2),

    COMPANY_SERVICE_EXIRPE_ERROR(20223, "COMPANY_SERVICE_EXIRPE_ERROR", "企业服务已过期", 2),

    USER_HAD_HELP_ENTERPRISES_ERROR(20224, "USER_HAD_HELP_ENTERPRISES_ERROR", "用户已经助力过该企业或者其他企业", 2),

    NOT_IN_HELP_ENTERPRISES_ERROR(20225, "NOT_IN_HELP_ENTERPRISES_ERROR", "企业助力时间已结束", 2),


    EXIST_FAMILY_NUMBER(20226, "EXIST_FAMILY_NUMBER", "已存在该家人", 2),

    EXIST_START_TIME(20227, "EXIST_START_TIME", "预约开始时间不能重复", 2),

    DELETE_ALL_START_TIME(20228, "DELETE_ALL_START_TIME", "开启预约时间必须存在一个有效的预约时间段", 2),


    RESERVE_DATA_ERROR(20229, "RESERVE_DATA_ERROR", "该预约时间不能预约", 2),

    RESERVE_DATA_INTERVAL_ERROR(20230, "RESERVE_DATA_INTERVAL_ERROR", "该预约时段不能预约", 2),

    INDIVIDUAL_NOT_SUPPORT(20231, "INDIVIDUAL_NOT_SUPPORT", "该医院暂不支持单项购买", 2),


    REFUND_HAS_NOT_REFUND_DDJX(20232, "REFUND_HAS_NOT_REFUND_DDJX", "加项全部退款后可退款套餐", 2),
    APPOINTMENT_DATE_REPEAT(20233, "APPOINTMENT_DATE_REPEAT", "分时预约日期不能存在包含关系", 2),
    BIZ_ERROR(20234, "BIZ_ERROR", "业务异常！", 2),
    AGE_ERROR(20235, "AGE_ERROR", "您的年龄不符合体检宝要求", 2),
    GROUP_ID_ERROR(20236, "GROUP_ID_ERROR", "检查groupId，商品组找不到!", 2),

    ONSHELVES_TYPE_ERROR(20237, "ONSHELVES_TYPE_ERROR", "类型不对,上下架操作失败", 2),

    ONSHELVES_ERROR(20238, "ONSHELVES_ERROR", "上下架操作失败", 2),

    ONSHELVES_NUM_ERROR(20239, "ONSHELVES_NUM_ERROR", "无上下架操作对象", 2),
    INST_CONFIG_ERROR(20240, "INST_CONFIG_ERROR", "该机构在运维后台尚未完成配置，请咨询相关实施人员。", 1),
    REPORT_EMPTY_FORBID(20241, "REPORT_EMPTY_FORBID", "应医院要求，贵单位体检报告无法在线查询，请前往医院获取纸质报告", 1),
    REPORT_ERROR_SYNC_CLOSE(20242, "REPORT_ERROR_SYNC_CLOSE", "该医院报告查询通道已关闭", 1),
    REPORT_ERROR_SYNC_ERROR(20243, "REPORT_ERROR_SYNC_ERROR", "报告获取失败，请检查医院的网络状况", 1),
    REPORT_SMS_CONFIG_ERROR(20244, "REPORT_SMS_CONFIG_ERROR", "发送时间最小为0.5，按0.5增加", 1),

    ITEM_TAG_NAME_EXISTS(20245, "ITEM_TAG_NAME_EXISTS", "分类名称不得重复", 1),
    DEV_NO_SYNC_AUTH(20246, "DEV_NO_SYNC_AUTH", "该环境暂无同步权限！", 2),
    ITEM_REFERED(20247, "ITEM_REFERED", "分类下存在项目时不允许删除。请先将该分类下项目的所属分类进行修改后，再尝试删除", 1),
    CRM_USER_NOT_EXISTS_ERROR(20248, "crm_user_not_exists", "CRM账号或密码不正确，请重试！", 1),
    INFO_ALREADY_IMPORT(20249, "INFO_ALREADY_IMPORT", "信息已经全部导入体软", 1),
    INST_BRANCH_EXISTS(20250, "INST_BRANCH_EXISTS", "院区名已存在", 1),

    APPOINTMENT_BATCH_DATE_REPEAT(20252, "APPOINTMENT_BATCH_DATE_REPEAT", "体检限流的日期选择不在体检范围中", 2),
    COMPANY_DOES_NOT_EXIST(20253, "COMPANY_DOES_NOT_EXIST", "企业不存在", 2),
    ITEM_EXCLUDE_ERROR(20256, "ITEM_EXCLUDE_ERROR", "该项目与已选项目中的xxx不可同时存在", 1),
    ITEM_DATA_FROM_ERROR(20257, "ITEM_DATA_FROM_ERROR", "后台导入与医院同步数据不能并存，请先将其他来源项目下架！", 2),
    BATCH_STATUS_ERROR(20258, "BATCH_STATUS_ERROR", "批次已失效", 2),
    SEND_AUDIT_ERROR(20259, "SEND_AUDIT_ERROR", "正在发放中，请不要重复发放", 2),
    GROUP_CARD_ERROR(20260, "GROUP_CARD_ERROR", "分组不存在", 2),
    STATION_TYPE_PKG_ERROR(20261, "STATION_TYPE_PKG_ERROR", "医院对接类型和套餐同步类型不匹配", 2),
    STATION_SYNC_ERROR(20262, "STATION_SYNC_ERROR", "同步医院失败", 2),
    USER_IDENTITY_ERROR(20263, "USER_IDENTITY_ERROR", "用户身份校验失败", 2),
    CARD_SYNC_DUPLICATE_ERROR(20264, "CARD_SYNC_DUPLICATE_ERROR", "用户信息已同步医院，不可绑定", 2),
    USER_BIND_DUPLICATE_ERROR(20265, "USER_BIND_DUPLICATE_ERROR", "用户已绑定", 2),

    USER_ACCOUNT_EXISTS_ERROR(20268, "USER_ACCOUNT_EXISTS_ERROR", "账号已存在，请更换！", 2),
    BATCH_STARTTIME_ERROR(20269, "BATCH_STARTTIME_ERROR", "开始时间不能晚于结束时间", 2),
    BATCH_STARTTIME_OUT_ERROR(20270, "BATCH_STARTTIME_LONG_ERROR", "开始结束时间不能长于365天", 2),
    BATCH_MODIFY_ERROR(20271, "BATCH_MODIFY_ERROR", "同步更新体检时间失败", 2),
    BATCH_NOT_AUTH_ERROR(20272, "BATCH_NOT_AUTH_ERROR", "该批次医院不匹配，无操作权限", 2),

    STATION_EXIST_ERROR(20273, "STATION_EXIST_ERROR", "机构已下架", 2),
    REPORT_PHONE_IS_NULL(20274, "REPORT_PHONE_IS_NULL", "医院要求，为保护用户隐私，系统内未留手机号的报告无法在线查询，请前往体检医院获取纸质报告。", 2),
    REPORT_EXAM_TYPE_FILTER(20275, "REPORT_EXAM_TYPE_FILTER", "您的体检报告无法在线查询，如需了解可咨询您所在的企业", 2),
    GROUP_UPDATE_ONLINE_STATUS_ERROR(20276, "GROUP_UPDATE_ONLINE_STATUS_ERROR", "阿里套餐上架状态异常", 2),

    PASSWORDKEY_ERROR(20277, "PASSWORDKEY_ERROR", "口令错误，请重新输入", 2),
    PASSWORDKEY_EXPIRE_ERROR(20278, "PASSWORDKEY_EXPIRE_ERROR", "口令已过期，请重新输入", 2),
    PASSWORDKEY_BIND_DUPLICATE(20279, "PASSWORDKEY_BIND_DUPLICATE", "口令已绑过用户", 2),

    BEHALF_PAY_MONEY_ERROR(20280, "BEHALF_PAY_MONEY_ERROR", "代收付订单支付金额错误", 2),

    RECEIVE_COUPON_ERROR(20281, "RECEIVE_COUPON_ERROR", "领取优惠券异常", 2),

    RECEIVE_COUPON_RECEIVE_ERROR(20282, "RECEIVE_COUPON_RECEIVE_ERROR", "已经领取优惠券", 2),

    JDSP_ALREADY_ADD(20283, "JDSP_ALREADY_ADD", "商品已经加入自有库", 2),

    WX_MINI_APP_SESSION_KEY_EXPIRED(20284, "WX_MINI_APP_SESSION_KEY_EXPIRED", "小程序sessionKey已过期", 2),

    BATCH_PHONE_TYPE_VERIFICATION(20285, "PHONE_TYPE_VERIFICATION", "该批次未开启手机号验证，无法配置活动", 2),
    ACTIVITY_CONF_EXISTS(20286, "ACTIVITY_CONF_EXISTS", "该批次已配置了生效的活动", 2),
    BATCH_NOT_EXISTS(20287, "BATCH_NOT_EXISTS", "批次号不存在", 2),
    TRANSFER_ERROR(20288, "TRANSFER_ERROR", "转账错误", 2),
    OPTIMISTIC_LOCK_CHECK(20289, "OPTIMISTIC_LOCK_CHECK", "该项数据已被修改，请刷新后重试！", 2),

    USER_CARD_UPLOADED(20290, "USER_CARD_UPLOADED","分组已有人员上传，请勿删除",2),

    BATCH_EXISTED(20291, "BATCH_EXISTED","同名批次已存在，请修改批次名称",2),

    ORDER_REFUND_ERROR(20292, "ORDER_REFUND_ERROR","订单退款异常",2),

    GROUP_EXISTED(20293, "GROUP_EXISTED","同名分组已存在，请修改分组名称",2),

    DISCOUNT_EMPTY(20294, "DISCOUNT_EMPTY","折扣不能为空",2),


    TIME_ERROR(20295, "TIME_ERROR","当前不在提现时间段",2),


    ;


    private String msg;

    private int code;

    private String codeStr;

    /**
     * 错误类型（0:一般结果码；1：系统级的错误；2：应用级的错误）
     */
    private int type;

    public Integer getIntCode() {
        return code;
    }

    public String getCode() {
        return String.valueOf(this.code);
    }

    public String getMsg() {
        return this.msg;
    }

    public String getCodeStr() {
        return this.codeStr;
    }

    public int getType() {
        return this.type;
    }

    ResultCode(int code, String codeStr, String msg, int type) {
        this.msg = msg;
        this.code = code;
        this.codeStr = codeStr;
        this.type = type;
    }

    public static ResultCode getByCode(int code) {
        for (ResultCode v : ResultCode.values()) {
            if (Objects.equals(v.getCode(), code)) {
                return v;
            }
        }
        return null;
    }

    //自检返回码是否重复
    static {
        ResultCode[] values = ResultCode.values();
        Map<String, ResultCode> m = new HashMap<>();
        for (ResultCode rc : values) {
            String code = rc.getCode();
            if (m.containsKey(code)) {
                throw new SecurityException("返回状态码存在重复code值," + m.get(code) + "," + rc);
            } else {
                m.put(code, rc);
            }
        }
    }
}
