package com.ldd.consumer.core.version;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * API版本注解
 *
 * @author lee
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ApiVersion {
  VERSION_UNKNOWN(0, "未知", "未知版本", false, "王伟平","com.helian.healthmanage.web.controller"),

  VERSION_BEHALF(1, "对账版本", "对账版本", false, "姜聪","com.helian.healthmanage.web.controller"),

  VERSION_811(811, "V8.1.1", "家庭健管&商城", false, "李俊卿","com.helian.healthmanage.web.controller"),

  VERSION_812(812, "V8.1.2", "家庭健管&商城", true, "李俊卿","com.helian.healthmanage.web.controller"),

  VERSION_843(843, "V8.4.3", "预约流程优化", false, "姜聪","com.helian.healthmanage.web.controller"),

  VERSION_MINI_APP(840, "V8.4.0", "小程序", true, "姜聪","com.helian.healthmanage.web.controller"), 

  VERSION_8431(8431, "V8.4.3.1", "批次红包活动", false, "王伟平","com.helian.healthmanage.web.controller"),

  VERSION_8445(8445, "V8.4.4.5", "企业直签版本1.0", true, "王伟平","com.helian.healthmanage.web.controller"),

  VERSION_847(847, "V8.4.7", "企业直签版本1.1", true, "王伟平","com.helian.healthmanage.web.controller"),

  ;
  /**
   * 版本编号
   */
  private int code;
  /**
   * 版本名称
   */
  private String versionName;

  /**
   * 版本说明
   */
  private String description;

  /**
   * 是否当前在用
   */
  private boolean current;

  /**
   * 联系人
   */
  private String contact;


  private String basePath;


  /**
   * 获取所有在用的版本
   * @return
   */
  public static List<ApiVersion> getVersionGroup() {
    List<ApiVersion> list = new ArrayList<>();
    for (ApiVersion apiVersion : ApiVersion.values()) {
      if(apiVersion.current){
        list.add(apiVersion);
      }
    }
    return list;
  }

}