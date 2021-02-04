package cn.hyperchain.demo.base;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: dsy
 * @date: 2020/3/9 16:56
 */
@Getter
public enum Code {

    /**
     * 未定义
     */
    UNDEFINED(-1, "未定义"),

    /**
     * 系统状态码
     */
    SUCCESS(0, "ok"),

    SYSTEM_ERROR(1, "系统繁忙，请稍后再试"),

    USER_IS_BLOCKING(2, "用户已被冻结，无法操作"),

    DECODE_ERROR(3, "解密失败"),

    READ_FILE_ERROR(4, "读取证书错误"),

    SM_NOT_NULL(5, "加密传输信息为空"),

    DATA_VERITY_ERROR(6, "数据完整性校验失败"),

    DATA_CONVERT_ERROR(7, "入参转换失败,请查看接口文档"),

    CHAINID_ERROR(8, "请正确配置链编号，主链：1001，交易侧链1002，数据侧链1003"),

    CHAINID_API_ERROR(9, "请核对请求接口编号是否属于该链（主链，交易侧链，数据侧链只能使用相对应的接口）"),

    CHAIN_NODE_FAILL(10, "区块链节点连接异常，请检查API配置及节点状态"),

    PARAM_TYPE_ERROR(11, "请检查参数名称及参数json格式"),

    USER_IS_ERROR(12, "应用所属用户信息错误，请联系管理员查询应用与用户绑定关系"),

    /**
     * 入参校验10000-19999
     */

    API_NUM_ERROR(10000, "接口编号错误"),

    PARAM_ERROR(10001, "请求参数异常,请参考接口文档调整参数"),

    HTTP_METHOD_NOT_SUPPORTED(10002, "请求方法错误"),

    HTTP_CONTENT_TYPE_NOT_SUPPORTED(10003, "不支持的Content-Type"),

    TIMESTAMP_NEED_MSEC(10004, "时间戳需要为毫秒（13位）"),

    API_NUM_NOT_NULL(10005, "接口编号不能为空"),

    APP_ID_NOT_NULL(10006, "appId不能为空"),

    APP_SECRET_NOT_NULL(10007, "appSecret不能为空"),

    FILE_TOO_BIG(10008, "上传文件最大1MB"),

    LOST_TOKEN(10009, "请求头未携带token"),


    /**
     * 业务状态码20000-29999
     */
    CHAIN_INVOKE_FAILL(20001, "区块链调用失败"),

    TOKEN_ERROR(20002, "身份验证失败，请重新登录"),

    AUTH_FAIL(20003, "身份验证失败，请检查系统接入id、系统接入秘钥和应用状态"),

    HVM_NOT_SUPPORT(20004, "暂时不支持hvm合约部署"),

    PERMISSION_ERROR(20005, "暂无权限"),

    SM4_DECODE_ERROR(20006, "解密失败"),

    CHECK_HASH(20007, "请校验hash来源，需要为文件存证hash"),

    COMPILE_CONTRACT_ERROR(20008, "编译合约失败，请检查solidity合约内容"),

    DEPLOY_CONTRACT_ERROR(20009, "部署合约失败"),

    INVOKE_CONTRACT_ERROR(200010, "调用合约失败"),

    SEND_TRANSACTION_ERROR(20011, "发送交易失败"),

    PERMISSION_REFUSE(20012, "权限拒绝,仅数据拥有者可执行此操作"),

    FILE_UPLOAD_TYPE_ERROR(20013, "文件存证异常，文件格式需要为 jpg，png，pdf，doc"),

    FILE_UPLOAD_NOT_NULL(20014, "上传文件为必填项"),

    FILE_NOT_EXIST(20015, "文件不存在，请核验fileUrl"),

    FILE_NOT_TOTAL(20016, "文件传输不完整，请重试"),

    DATA_UUID_ERROR(20017, "编号错误"),

    FILE_UUID_AND_HASH_ERROR(20018, "文件存证数据不存在"),

    DATA_EVIDENCE_MAX_SIZE(20019, "数据存证内容长度超出"),

    FILE_SUFFIX_ERROR(20020, "请检测文件后缀是否正确，文件格式需要为 jpg，png，pdf，doc"),

    FILE_SUFFIX_TYPE_ERROR(20021, "文件类型与文件后缀不匹配，文件格式需要为 jpg，png，pdf，doc"),

    SM4_ENCODE_DECODE_ERROR(20022, "加解密失败"),

    FILE_NAME_ERROR(20023, "文件名不能为空且长度不超过50个字符"),

    FILE_DIR_CREATE_ERROR(20024, "文件夹创建失败，请联系管理员检查相关配置"),

    MUST_FILE_OWNER_DOWN(20025, "只能下载应用所有存证文件"),

    /**
     * 数字身份30000-39999
     */
    CREATE_IDENTITY_FAIL(30000, "数字身份添加失败"),

    MODIFY_IDENTITY_FAIL(30001, "数字身份添加失败"),


    /**
     * 共享数据40000-49999
     */
    SHARE_DATA_NOT_EXIST(40000, "共享数据不存在"),

    DATA_IS_BLOCKING(40001, "数据已被冻结，无法操作"),

    CREATE_DATA_BLOCKING(40002, "数据添加失败"),

    CHANGE_DATA_BLOCKING(40002, "修改数据失败"),

    QUERY_DATA_BLOCKING(40002, "数据查询失败"),

    SHARE_DATA_PERMISSION(40003, "访问此数据需要申请权限"),

    FREEZE_DATA_PERMISSION(40004, "数据已冻结"),

    SHARE_DATA_NOT_EXIST_OR_NOT_USER(40005, "共享数据不存在或非当前用户所有"),
    ;

    private int code;
    private String message;

    Code(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private static final Map<Integer, Code> CODE_MAP = new HashMap<>();

    static {
        for (Code code : Code.values()) {
            CODE_MAP.put(code.code, code);
        }
    }

    public static Code getEnumByCode(int code) {
        return CODE_MAP.get(code);
    }

    public static boolean isValid(int code) {
        return CODE_MAP.get(code) != null;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

}
